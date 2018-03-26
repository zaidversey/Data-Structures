
public class LList {
	private LLNode head;
	
	public LList() {
		head = null;
	}
	public void addAtHead (String newData) {
		LLNode newNode = new LLNode (newData);
		newNode.updateNode(head);
		head = newNode;
	}
	
	public void display() {
		LLNode temp = head;
		while (temp != null) {
			System.out.println (temp);
			temp = temp.getNext();
		}
	}
	
	public LLNode deleteAtHead ( ) {
		LLNode removedOne = head;
		head = head.getNext();
		return removedOne;
	}
	
	public LLNode getHead(){
		return head;
	}
	
	public LLNode delete(String keyNode){
		LLNode currentNode = head;
		LLNode previousNode = head;
		//at head
		if(keyNode.equals(currentNode.toString())){
			head = head.getNext();
			return currentNode;
		}
		//from head to end
		while(currentNode.getNext() != null){
			previousNode = currentNode;
			currentNode = currentNode.getNext();
			
			if(keyNode.equals(currentNode.toString())){
				previousNode.updateNode(currentNode.getNext());
				return currentNode;
			}
		}// end of while
		System.out.println("Doesn't exist, please try again");
		return null;
		
	}// end of method
	

}
