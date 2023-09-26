import java.util.EmptyStackException;//for when you want to pop from an empty
/**
   A class of stacks whose entries are stored in a chain of nodes.
   Each node in the chain is an instance of the private class Node that is defined within 
   the class LinkedStack
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
	
   //StackInterface<String> myStack = new LinkedStack<>();
	public LinkedStack()
	{
		topNode = null;//The default constructor sets head reference to null
	} // end default constructor
	
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);//creating a newNode that point to the first node in chain
		topNode = newNode;//making sure that topNode that references the first node is pointing to our new node
//    topNode = new Node(newEntry, topNode); // Alternate code
	} // end push
   //peek method retrieves data by calling getData on topNode
	public T peek()
	{
		if (isEmpty())//if the stack is empty, nothing is there to be peeked
			throw new EmptyStackException();
		else
         return topNode.getData();//if we have items in the stack, lets return the firts object's data
	} // end peek

   //retrieves and removes the object
	public T pop()
	{
	   T top = peek();  // Might throw EmptyStackException
   // Assertion: topNode != null
      topNode = topNode.getNextNode();//makes sure that topNode is pointing to the second node in chain

	   return top;//return the value in th etop 
	} // end pop		

	public boolean isEmpty()
	{
		return topNode == null;
	} // end isEmpty
	
	public void clear()
	{
		topNode = null;  // Causes deallocation of nodes in the chain
	} // end clear

	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      //Node newNode = new Node("Jack"); 
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      // Node newNode1 = new Node("Hellen" , newNode);
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;	
      } // end constructor

      private T getData()
      {
         return data;
      } // end getData

      private void setData(T newData)
      {
         data = newData;
      } // end setData

      private Node getNextNode()
      {
         return next;
      } // end getNextNode

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedStack
