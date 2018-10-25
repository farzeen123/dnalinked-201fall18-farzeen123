
public class LinkStrand implements IDnaStrand {
	int myIndex;
	int myLocalIndex;
	Node myCurrent;

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
		mySize = source.length();

		Node myCurrent = myFirst;
		myLocalIndex = 0;
		myIndex = 0;

		// REMEMBER TO ADD SOURCE LENGTH AS WELL,ORIGINAL LENGTH.

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
	
	 private Node pointer=null;

	private Node appendFirst(String s) {
	    	
	    	
	    	//if(pointer!=null) {
	    		StringBuilder copy=new StringBuilder(s);
	    		copy.reverse();
	    		
	            Node tail=new Node(copy.toString());
	            //creates a new node and append it to the myLast node
	            tail.next=pointer;
	            pointer=tail;
	            //tail1=tail1.next;
	        	//}
	            return pointer;
	        }

	@Override
	public IDnaStrand reverse() {
/*//		StringBuilder copy = new StringBuilder(myFirst.info); // temperory holder
//		copy.reverse();
//		LinkStrand org = new LinkStrand(copy.toString()); // has one node already
		Node last1 = myLast;
		Node pointer = myFirst;
		Node first1 = myFirst;// a pointer in reverse dna strand
		myFirst = myFirst.next;

		while (first1 != null) {
			StringBuilder copy1 = new StringBuilder(first1.info); // temperory holder
			copy1.reverse(); // Node two = new Node(copy1.toString());
			first1.info = copy1.toString();

			// LinkStrand other = new LinkStrand(copy1.toString());

			first1 = first1.next;
		}

		Node prev = null;

		while (pointer != null) {
			// System.out.println(pointer);
			Node temp = pointer.next;
			pointer.next = prev;
			prev = pointer;
			pointer = temp; // now the pointer moves to temp.

			myFirst = pointer; // now my last1 is the pointer.

		}*/
		
		    
		  
		  
		    	
		      Node head=myFirst; 
		      while(head.next!=null) {
		    	  appendFirst(head.info);
		    	  head=head.next;
		      }
		      
		   appendFirst(head.info);
		   LinkStrand ans=new LinkStrand(""); 
		   
		   while(pointer!=null) {
			   ans.append(pointer.info);
			   pointer=pointer.next;
		   }
		   
		   return ans;
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
			throw new IndexOutOfBoundsException("");
		}
		
		
		
		while (myIndex != index) {
			myIndex++;
			myLocalIndex++;
			
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			
			}
		}


		/*while (myIndex != index) {

			if (myLocalIndex >= myCurrent.info.length()) {
				if(myCurrent.next != null) {
					myLocalIndex = -1;
				}
				else if(myCurrent.next ==null) {
					throw new IndexOutOfBoundsException("");


				}

			}


			myCurrent = myCurrent.next;

		}

		myIndex++;
		myLocalIndex++;
*/

		return myCurrent.info.charAt(myLocalIndex);

		// TODO Auto-generated method stub

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
