
public class LinkStrand implements IDnaStrand {

	private class Node {
		String info;
		Node next;

		public Node(String s) {
			info = s;
			next = null;
		}
	}

	private Node myFirst, myLast;
	private long mySize;
	private int myAppends;
	private LinkStrand next;

	public LinkStrand() {
		this(""); // copied strand so that we work on it

	}

	public LinkStrand(String s) {
		initialize(s);

	}

	@Override
	public long size() {

		// TODO Auto-generated method stub
		return mySize;
	}

	@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		myLast = myFirst; // initialize mylast as well. point to same node at first then mylast iterates
							// overnodes.
		myAppends = 0;
		mySize = source.length(); // REMEMBER TO ADD SOURCE LENGTH AS WELL,ORIGINAL LENGTH.

	}

	@Override
	public IDnaStrand getInstance(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDnaStrand append(String dna) {
		Node head = myFirst;
		// creates a new node and append the dna to the myFirst.
		Node tail = new Node(dna);
		// myLast.info = dna;
		myLast.next = tail;
		myLast = myLast.next;
		myAppends++;
		mySize = mySize + dna.length();

		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		StringBuilder copy = new StringBuilder(myFirst.info); // temperory holder
		copy.reverse();
		LinkStrand org = new LinkStrand(copy.toString()); // has one node already
		Node last1 = org.myLast;
		Node pointer = org.myFirst; // a pointer in reverse dna strand
		myFirst = myFirst.next;

		while (myFirst != null) {
			StringBuilder copy1 = new StringBuilder(myFirst.info); // temperory holder
			copy1.reverse(); // Node two = new Node(copy1.toString());
			org.append(copy1.toString());
			// LinkStrand other = new LinkStrand(copy1.toString());

			myFirst = myFirst.next;
		}

		Node prev = null;

		while (pointer != null) {
			Node temp = pointer.next; //creates a temporary node that stores the rest of loop.
			pointer.next = prev;// before we can assign pointer the value of next.
			  pointer = temp; //now the pointer moves to temp.
			 
			  last1 = pointer; //now my last1 is the pointer.

			// org.next = org;

		}

		return org;
	}

	/**
	 * @param
	 * @return
	 */
	@Override
	public int getAppendCount() {
		// myAppends++;
		return myAppends;
	}

	@Override
	public char charAt(int index) {

		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		StringBuilder obj = new StringBuilder();
		while (myFirst != null) {
			obj.append(myFirst.info);
			myFirst = myFirst.next;
		}
		return obj.toString(); // returns the concatenation version of each node.
	}

}
