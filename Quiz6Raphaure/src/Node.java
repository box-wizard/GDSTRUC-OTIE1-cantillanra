public class Node {
    private int data;
    private Node LeftChild;
    private Node RightChild;

    public void traverseInOrder() {
        if (LeftChild != null)
            LeftChild.traverseInOrder();

        System.out.println(this);

        if (RightChild != null)
            RightChild.traverseInOrder();
    }
    
    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (data == value) {
            System.out.println("...Dude this is already here.");
            return;
        }

        if (value < data) {
            if (LeftChild != null) {
                LeftChild.insert(value);
            }
            else {
                LeftChild = new Node(value);
            }
        }
        else {
            if (RightChild != null) {
                RightChild.insert(value);
            }
            else {
                RightChild = new Node(value);
            }
        }
    }

    //It traverses the tree in a descending order if the name isn't obvious.
    public void traverseDesc() {
        if (RightChild != null)
            RightChild.traverseDesc();

        System.out.println(this);

        if (LeftChild != null)
            LeftChild.traverseDesc();
    }

    public Node get(int value) {
        if (value == data)
            return this;

        if (value < data) {
            if (LeftChild != null)
                return LeftChild.get(value);
            else
                return null;
        }
        else {
            if (RightChild != null)
                return RightChild.get(value);
            else
                return null;
        }
    }

    //get node with the minimum value
    public Node getMin() {
        if (LeftChild == null)
            return this;

        return LeftChild.getMin();
    }

    //get node with the maximum value
    public Node getMax() {
        if (RightChild == null)
            return this;

        return RightChild.getMax();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(Node LeftChild) {
        this.LeftChild = LeftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node RightChild) {
        this.RightChild = RightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}