import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CustomHashMap<K, V> {
     /**
     * CustomHashMap for storing and handling key-value pairs in a structured format
     * Uses:
     * -> Allows only unique keys and duplicate keys are not allowed
     * -> Separate chaining with LinkedList to handling collissions happening 
     * -> Assuming hash function distribute elements evenly
     * Operations:
     * -> put(K,V): Store key-value pair in a HashMap if key doesn't exists already
     * -> remove(K): Removes a key from a HashMap only if key already exists
     * -> get(K): Get a value from a HashMap associated with a Key
     * -> containsKey(K): Checks if key is exists already or not
     * -> keySet(): Get all keys from a HashMap
     */
     private class Node<K, V> {
          K key;
          V value;
          Node(K key, V value) {
              this.key = key;
              this.value = value;
          }
     }
     
     private static final int DEFAULT_CAPACITY = 16;
     private static final double LOAD_FACTOR = 0.75f;
     private int capacity;
     private int size;
     private LinkedList<Node<K, V>> [] buckets;
     
     CustomHashMap() {
         this.size = 0;
         buckets = new LinkedList[DEFAULT_CAPACITY];
         this.capacity = DEFAULT_CAPACITY;
     }
     
     //Calculate a index for storing new key-value pair in a HashMap or HashTable
     private int getBucketIndex(K key) {
         return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
     }
     
     //Insert a key-value pair into a HashMap if it's key not exists, if it exists update its value
     public void put(K key, V value) {
         int bucketIndex = getBucketIndex(key);
         if(buckets[bucketIndex] == null) {
             buckets[bucketIndex] = new LinkedList<>();
         }         
         for(Node<K, V> node : buckets[bucketIndex]) {
             if(node.key.equals(key)) {
                 node.value = value;
                 return;
             }
         }         
         buckets[bucketIndex].add(new Node<>(key, value));
         this.size++;
         if((double) this.size / DEFAULT_CAPACITY >= LOAD_FACTOR ) {
             rehash();
         }
     }
         
      //Remove key-value pair from a HashMap only if given key exists   
      public void remove(K key) {
         int bucketIndex = getBucketIndex(key);
         if(buckets[bucketIndex] == null) {
             return;
         }
         buckets[bucketIndex].removeIf(node -> node.key.equals(key));
         this.size--;
      }
      
      //Retrieve a value from a HashMap associated with it's key
      public V get(K key) {
          int bucketIndex = getBucketIndex(key);
          if(buckets[bucketIndex] == null) {
              return null;
          }
          for(Node<K, V> node : buckets[bucketIndex]) {
              if(node.key.equals(key)) {
                  return node.value;
              }
          }
          return null;
      }
      
      //Checks if given key exists in a HashMap or not
      public boolean containsKey(K key) {
          int bucketIndex = getBucketIndex(key);
          if(buckets[bucketIndex] == null) {
              return false;
          }
          for(Node<K, V> node : buckets[bucketIndex]) {
              if(node.key.equals(key)) {
                  return true;
              }
          }
          return false;
      }
      
      //Get all keys from a HashMap
      public List<K> keySet() {
          List<K> keyset = new ArrayList<>();
          for(LinkedList<Node<K, V>> bucket : buckets) {
              if(bucket != null) {
                  for(Node<K,V> node : bucket) {
                      keyset.add(node.key);
                  }
              }
          }
          return keyset;
      }
      
      //Re-hashing means when the HashMap size exists a current capacity , it's going to double current size
      private void rehash() {
          LinkedList<Node<K, V>>[] oldBuckets = buckets;
          capacity = capacity * 2;
          buckets = new LinkedList[capacity];
          for(int i=0; i<capacity; i++) {
              buckets[i] = new LinkedList<>();
          }
          for(LinkedList<Node<K, V>> bucket : oldBuckets) {
              if(bucket != null) {
                  for(Node<K, V> node : bucket) {
                      put(node.key, node.value);
                  }
              }
          }
      }
      
      //Making all buckests are as null means no more buckets or tables are available
      public void clear() {
          for(int i=0; i<capacity; i++) {
              buckets[i] = null;
          }
          this.size = 0;
      }
      
      //Finding a length of a HashMap
      public int size() {
          return this.size;
      }
      
      @Override
      public String toString() {
          StringBuilder builder = new StringBuilder();
          builder.append("[");
          boolean isFirst = true;
          for(LinkedList<Node<K, V>> bucket : buckets) {
              if(bucket != null) {
                  for(Node<K,V> node : bucket) {
                      if(!isFirst) {
                          builder.append(", ");
                      }
                      builder.append(node.key).append("=").append(node.value);
                      isFirst = false;
                  }
              }
          }
          builder.append("]");
          return builder.toString();
      }
      
}
