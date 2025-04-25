 class CustomHashSet<K> {
      /**
      * CustomHashSet:
      * Internally uses a CustomHashMap for storing objects in a provided key associated with a dummy object
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