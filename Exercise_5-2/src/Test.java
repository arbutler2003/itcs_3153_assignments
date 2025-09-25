//	This class will be used to test your work
//	Do NOT make any changes to the code in this class
public class Test
{
	public static Node populateNode_Test1()
	{
		Node node = new Node(new Node(new Node(new Node(8), null, 4), new Node(new Node(9), new Node(new Node(14), null, 10), 5), 
				2), new Node(new Node(new Node(11), null, 6), new Node(new Node(12), new Node(13), 7), 3), 1);
		
		//						1
		//			   2				3
		//			4	  5			6		7	
		//		   8     9 10		 11	  12 13
		//				    14
		
		return node;
	}
	
	
	public static Node populateNode_Test2()
	{	
		Node node = new Node(new Node(new Node(new Node(8),new Node(9), 4), new Node(new Node(10), 
				new Node(11), 5),2), new Node(new Node(new Node(12), 
						new Node(13), 6), new Node(new Node(14), new Node(15), 7),3),1);

		//						1
		//			   2				3
		//			4	  5			6		7	
		//		   8 9  10 11	  12 13	  14 15
		
		return node;
	}
	
	
	//Do NOT make any changes to the code in this method
	public static void main(String[] Args)
	{
		//	Test 1
		Node tree = populateNode_Test1();
		
		System.out.println("--- Test Case 1 ---");
		
		Search.BFS(tree, 14);
		System.out.println("\n");
		
		Search.DFS(tree, 14);
		System.out.println("\n");
		
		Search.DFSLimited(tree, 2, 14);
		System.out.println("\n");
		
		Search.iterativeDFS(tree, 14);
		System.out.println("\n");
		
		
		//		Test 2
		Node tree2 = populateNode_Test2();
		
		System.out.println("--- Test Case 2 ---");
			
		Search.BFS(tree2, 7);
		System.out.println("\n");
		
		Search.DFS(tree2, 7);
		System.out.println("\n");
		
		Search.DFSLimited(tree2, 2, 7);
		System.out.println("\n");
		
		Search.iterativeDFS(tree2, 7);
	}
}
