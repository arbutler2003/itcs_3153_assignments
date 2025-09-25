import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Search {
    /**
     * Performs a Breadth-First Search (BFS) over the given tree to find the target value.
     * Uses a FIFO queue for the search frontier.
     *
     * @param tree the root node of the tree to search
     * @param goal the target value to search for
     */
	public static void BFS(Node tree, int goal) {
		System.out.println("BFS");
		System.out.println("goal: " + goal);	

        Queue<Node> frontier = new LinkedList<Node>();
        tree.setDepth(0);
        frontier.add(tree);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();
            System.out.println(currentNode.data);

            if (currentNode.data == goal) {
                System.out.println("Goal Found!");
                break;
            }

            // Add the current nodes children to the queue
            if (currentNode.left != null) {
                currentNode.left.setDepth(currentNode.depth + 1);
                frontier.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.setDepth(currentNode.depth + 1);
                frontier.add(currentNode.right);
            }
        }
	}


    /**
     * Performs a Depth-First Search (DFS) over the given tree to find the target value.
     * Uses a LIFO stack for the search frontier.
     *
     * @param tree the root node of the tree to search
     * @param goal the target value to search for
     */
	public static void DFS(Node tree, int goal)
	{
		System.out.println("DFS");
		System.out.println("goal: " + goal);

        Stack<Node> frontier = new Stack<Node>();
        tree.setDepth(0);
        frontier.push(tree);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            System.out.println(currentNode.data);

            if (currentNode.data == goal) {
                System.out.println("Goal Found!");
                return;
            }

            // Push the children in reverse order
            if (currentNode.right != null) {
                currentNode.right.setDepth(currentNode.depth + 1);
                frontier.push(currentNode.right);
            }
            if (currentNode.left != null) {
                currentNode.left.setDepth(currentNode.depth + 1);
                frontier.push(currentNode.left);
            }
        }
	}


    /**
     * Performs a Depth-First Search with a depth limit (DLS).
     * Uses a LIFO stack for the search frontier and doesn't explore nodes beyond the depth limit.
     *
     * @param tree the root node of the tree to search
     * @param depthLimit the maximum depth to search to
     * @param goal the target value to search for
     */
	public static void DFSLimited(Node tree, int depthLimit, int goal)
	{
		System.out.println("DFS Limited");
		System.out.println("depth limit: "+ depthLimit);
		System.out.println("goal: " + goal);

        Stack<Node> frontier = new Stack<Node>();
        tree.setDepth(0);
        frontier.push(tree);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            System.out.println(currentNode.data);

            if (currentNode.data == goal) {
                System.out.println("Goal Found!");
                return;
            }

            // Only push children if the depth limited hasn't been reached
            if (currentNode.depth < depthLimit) {
                if (currentNode.right != null) {
                    currentNode.right.setDepth(currentNode.depth + 1);
                    frontier.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    currentNode.left.setDepth(currentNode.depth + 1);
                    frontier.push(currentNode.left);
                }
            }
        }
	}


    /**
     * Performs an Iterative Deepening Depth-First Search (IDDFS) to find the target value.
     * Repeatedly performs Depth-Limited Search (DLS) with increasing depth limits until the goal is found
     * or the maximum depth is reached.
     * Uses a LIFO stack for the search frontier.
     *
     * @param tree the root node of the tree to search
     * @param goal the target value to search for
     */
	public static void iterativeDFS(Node tree, int goal)
	{
		System.out.println("DFS Iterative");
		System.out.println("goal: " + goal);

        // Prevent infinite loop
        final int MAX_DEPTH = 50;

        for (int depthLimit = 0; depthLimit < MAX_DEPTH; depthLimit++) {
            System.out.println("Iteration #" + depthLimit);

            Stack<Node> frontier = new Stack<>();
            tree.setDepth(0);
            frontier.push(tree);

            while (!frontier.isEmpty()) {
                Node currentNode = frontier.pop();
                System.out.println(currentNode.data);

                if (currentNode.data == goal) {
                    System.out.println("Goal Found!");
                    return;
                }

                if (currentNode.depth < depthLimit) {
                    if (currentNode.right != null) {
                        currentNode.right.setDepth(currentNode.depth + 1);
                        frontier.push(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        currentNode.left.setDepth(currentNode.depth + 1);
                        frontier.push(currentNode.left);
                    }
                }
            }
        }
	}
}