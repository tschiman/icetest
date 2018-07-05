import java.util.function.Predicate;

public abstract class NodeWalker {
    public void walk(Node node, Predicate<Node> predicate, boolean decedentsOnly) {
        if (predicate.test(node) && !decedentsOnly) {
            takeAction(node);
        }

        if (node.getChildren().size() > 0) {
            node.getChildren().forEach(n -> this.walk(n, predicate, false));
        }
    }

    protected abstract void takeAction(Node node);
}
