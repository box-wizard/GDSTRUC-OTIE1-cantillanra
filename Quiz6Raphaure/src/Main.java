public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // establish the value for the trees.
        binaryTree.insert(-84);
        binaryTree.insert(412);
        binaryTree.insert(19);
        binaryTree.insert(-3);
        binaryTree.insert(95);
        binaryTree.insert(611);
        binaryTree.insert(-156);
        binaryTree.insert(38);
        binaryTree.insert(204);

        // printing out and sorting the values. nothing too substantial.
        System.out.println("\nThis is the order for them descending:\n");
        binaryTree.traverseDesc();
        System.out.println("\nThis is the order for them ascending:\n");
        binaryTree.traverseInOrder();

        // prints out the maximum nodes and minimum nodes
        System.out.println("\nMax. Node: " + binaryTree.getMax());
        System.out.println("Min. Node: " + binaryTree.getMin());

        int findIndex = 95;

        System.out.println("\nThe nodes with value " + findIndex + " = "
                + binaryTree.get(findIndex));
    }
}