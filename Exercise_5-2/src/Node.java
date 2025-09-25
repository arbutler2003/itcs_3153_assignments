//	This class implements a simple tree node that can be
//	used by the search algorithms.
//
//	Do NOT make any changes to the code in this class.
public class Node
{
	Node left;
	Node right;
	int depth;
	int data;


	public Node(Node left, Node right, int data)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}


	public Node(int data)
	{
		this.data = data;
	}


	public void setDepth(int depth)
	{
		this.depth = depth;
	}


	public Node()
	{
		left = null;
		right = null;
		data = 0;
	}
}