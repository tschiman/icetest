import java.util.function.Predicate;

public abstract class NodeWalker {
    public void walk(Node node, Predicate<Node> predicate, boolean includeRoot, boolean reverse) {
        if (predicate.test(node) && includeRoot) {
            takeAction(node);
        }

        if (reverse) {
            if (node.getParent() != null) {
                walk(node.getParent(), predicate, true, true);
            }
        } else {
            if (node.getChildren().size() > 0) {
                node.getChildren().forEach(n -> this.walk(n, predicate, true, false));
            }
        }
    }

    protected abstract void takeAction(Node node);
}
