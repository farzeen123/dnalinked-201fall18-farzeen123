
public class LinkStrand implements IDnaStrand {
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;

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
	
		myAppends = 0;
		mySize = source.length();

		myCurrent = myFirst;
		myLocalIndex = 0;
		myIndex = 0;

		// REMEMBER TO ADD SOURCE LENGTH AS WELL,ORIGINAL LENGTH.

	}

	@Override
	public IDnaStrand getInstance(String source) {
		
		return new LinkStrand(source);
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

	private Node pointer=null;

	private Node appendFirst(String s) {



		StringBuilder copy=new StringBuilder(s);
		copy.reverse();

		Node tail7=new Node(copy.toString());
		//creates a new node
		//append it to the myLast node
		tail7.next=pointer;
		pointer=tail7;

		return pointer;
	}

	@Override
	public IDnaStrand reverse() {


		Node head2=myFirst; 
		while(head2.next!=null) {
			appendFirst(head2.info);
			head2=head2.next;
		}

		appendFirst(head2.info);
		LinkStrand rev=new LinkStrand(""); 

		while(pointer!=null) {
			rev.append(pointer.info);
			pointer=pointer.next;
		}

		return rev;
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

		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}


		if(myIndex>index) {

			myIndex = 0;
			myCurrent = myFirst;
			myLocalIndex =0;
	
		}

		while (myIndex != index) {
			myIndex++;
			myLocalIndex++;


			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;

			}
			if(myCurrent == null) {
				throw new IndexOutOfBoundsException();

			}

		}
		
		return myCurrent.info.charAt(myLocalIndex);

		// TODO Auto-generated method stub

	}
    
	public String toString() {
		Node tempo = myFirst;
		StringBuilder obj = new StringBuilder();
		while (tempo != null) {
			obj.append(tempo.info);
			tempo = tempo.next;
		}
		return obj.toString(); // returns the concatenation version of each node.
	}

}
