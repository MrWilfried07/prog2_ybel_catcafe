package tree;

public class InOrderVisitor<T extends Comparable<T>> implements TreeVisitor<T> {

    @Override
    public String visit(Empty<T> node) {
        return "";
    }

    @Override
    public String visit(Node<T> node) {
        String left = node.leftChild().accept(this);
        String current = node.data().toString();
        String right = node.rightChild().accept(this);

        StringBuilder result = new StringBuilder();
        if (!left.isEmpty()) result.append(left).append(", ");
        result.append(current);
        if (!right.isEmpty()) result.append(", ").append(right);

        return result.toString();
    }
}
