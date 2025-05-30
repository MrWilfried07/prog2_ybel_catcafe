package tree;

public class PostOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

    @Override
    public String visit(Empty<T> node) {
        return "";
    }

    @Override
    public String visit(Node<T> node) {
        String left = node.leftChild().accept(this);
        String right = node.rightChild().accept(this);
        String current = node.data().toString();

        StringBuilder result = new StringBuilder();
        if (!left.isEmpty()) result.append(left).append(", ");
        if (!right.isEmpty()) result.append(right).append(", ");
        result.append(current);

        return result.toString();
    }
}
