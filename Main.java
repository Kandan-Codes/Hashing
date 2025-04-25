
public class Main {
	public static void main(String[] args) {
		
		//Testing all the implementations over here
		/**CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
		map.put(1,10);
		map.put(2,20);
		map.put(3,30);
		map.put(4,40);
		map.put(3,12);
		map.put(78,23);
		map.put(6,3);
		
		System.out.println(map);
		System.out.println(map.get(4));
		System.out.println(map.get(10));
		
		System.out.println(map.containsKey(78));
		System.out.println(map.containsKey(5));
		
		map.remove(2);
		System.out.println(map);
		
		System.out.println("Map size: "+map.size());
		
		System.out.println("All keys are over here: ");
		for(int key : map.keySet()) {
		    System.out.print(key + "  ");
		}*/
		
		//Testing HashSet Implementations
		CustomHashSet<Character> lookups = new CustomHashSet<>();
		lookups.add('A');
		lookups.add('B');
		lookups.add('C');
		lookups.add('D');
		lookups.add('E');
		lookups.add('F');
		
		System.out.println(lookups);
		
		System.out.println(lookups.size());
		
		lookups.add('D');
		lookups.add('G');
		lookups.add('2');
		
		System.out.println(lookups.size());
		System.out.println(lookups);
		
		System.out.println(lookups.contains('E'));
		
		lookups.clear();
		
		System.out.println(lookups);
		
		lookups.add('A');
		lookups.add('B');
		lookups.add('C');
		
		System.out.println(lookups);
	}
}