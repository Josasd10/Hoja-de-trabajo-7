class Node<E> {
    E data;
    Node<E> left, right;

    public Node(E data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {

    private Node<Association<String, String>> root;

    public BinaryTree() {
        root = null;
    }

    // INSERTAR
    public void insert(Association<String, String> value) {
        root = insertRec(root, value);
    }

    private Node<Association<String, String>> insertRec(Node<Association<String, String>> node, Association<String, String> value) {
        if (node == null) return new Node<>(value);

        int cmp = value.getKey().compareTo(node.data.getKey());

        if (cmp < 0)
            node.left = insertRec(node.left, value);
        else if (cmp > 0)
            node.right = insertRec(node.right, value);
        else
            node.data.setValue(value.getValue());

        return node;
    }

    // BUSCAR
    public String search(String key) {
        return searchRec(root, key.toLowerCase());
    }

    private String searchRec(Node<Association<String, String>> node, String key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.data.getKey());

        if (cmp == 0)
            return node.data.getValue();
        else if (cmp < 0)
            return searchRec(node.left, key);
        else
            return searchRec(node.right, key);
    }

    // INORDER
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node<Association<String, String>> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println("(" + node.data.getKey() + ", " + node.data.getValue() + ")");
            inorderRec(node.right);
        }
    }
}