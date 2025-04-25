 class CustomHashSet<K> {
      /**
      * CustomHashSet:
      * CustomHashSet class internally uses a CustomHashMap for backup storing like ArrayList uses internally array
      * Uses:
      * -> Allows only unique elements duplicates are not allowed
      * -> Provide constant-time performance for basic operations (such as add, remove, contains, size,etc.)
      * Operations:
      * -> add(E): Add new Object into a HashSet and duplicates are not allowed
      * -> remove(E): Remove an Object from a HashSet only if exists
      * -> contains(E): Checks if an object is in a HashSet or not
      * -> size(): Return a size of a HashSet
      */
      private CustomHashMap<K, Object> map;
      private final Object PRESENT;
      
      CustomHashSet() {
          map = new CustomHashMap<>();
          PRESENT  = new Object();
      }
      
      //Add new Object into a HashSet if its not exists already and doesn't allows duplicate values'
      public void add(K key) {
          map.put(key, PRESENT);
      }
      
      //Removes an Object from the HashSet if it exists
      public void remove(K key) {
          map.remove(key);
      }
      
      //Checks if given object present in a HashSet or not
      public boolean contains(K key) {
          return map.containsKey(key);
      }
      
      //clear a CustomHashSet object internally without changing its structure
      public void clear() {
          map.clear();
      }
      
      //Getting a HashSet size
      public int size() {
          return map.size();
      }
      
      //Checks given HashSet is empty or not
      public boolean isEmpty() {
          return map.size() == 0;
      }
      
      @Override
      public String toString() {
          StringBuilder builder = new StringBuilder();
          builder.append("[");
          boolean isFirst = true;
          for(K key : map.keySet()) {
              if(!isFirst) {
                  builder.append(", ");
              }
              builder.append(key);
              isFirst = false;
          }
          builder.append("]");
          return builder.toString();
      }
}
