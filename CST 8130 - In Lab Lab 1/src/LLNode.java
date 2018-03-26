
public class LLNode {
	private Character data;
	private LLNode next;
	
	public LLNode() {
		this.data = null;
		this.next = null;
	}
	public LLNode (Character newData) {
		this.data = (newData);
		this.next = null;
	}
	public void updateNode (LLNode nextOne) {
		this.next = nextOne;
	}
	public Character toChar () {
		return  this.data;
	}
	public LLNode getNext() {
		return this.next;
	}

}
