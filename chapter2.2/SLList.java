public class SLList{
	private class intnode{
		public int item;
		public intnode next;

		public intnode(int i, intnode n){
			item = i;
			next = n;
	}
}
	private intnode first;
	public int size;


	/** instanitate a empty sslist*/
	public SLList(){
		first = null;
		size = 0;
	}


	public SLList(int x){
		first = new intnode(x,null);
		size += 1;
	}

	/** Adds an item to the front of the sllist*/
	public void addFirst(int x){
		first = new intnode(x,first);
		size += 1;
	}
	
	/** Retrieves the front item from the list. */
	public int getFirst() {
	    return first.item;
	}

	/** Adds an iterm to the last of the list*/
	public void addLast(int x){
		intnode p = first;
		size += 1;
		if(p == null){
			p = new intnode(x,null);
		}

		while(p.next != null){
			p = p.next;
		}

		p.next =  new intnode(x,null);
	}

	/** Retrieves the last of the list*/
	public int getLast(){
		intnode p = first;
		
		while(p.next != null){
			p = p.next;
		}

		return p.item;
	}

	// /** return the length of the list*/
	// private static int size(intnode p){
	// 	if(p.next == null){
	// 		return 1;
	// 	}else{
	// 		return 1 + SLList.size(p.next);
	// 	}
	// }


	public int size(){
		return size;
	}



	public static void main(String[] args) {
	SLList L = new SLList();
	L.addFirst(10);
	L.addFirst(5);
	L.addLast(10);
	int x = L.getLast();
	System.out.println(L.size());
	}
}