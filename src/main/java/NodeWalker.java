import java.util.function.Predicate;

public abstract class NodeWalker {
    public void walk(Node node, Predicate<Node> predicate) {
        if (predicate.test(node)) {
            takeAction(node);
        }

        if (node.getChildren().size() > 0) {
            node.getChildren().forEach(n -> this.walk(n, predicate));
        }
    }

    protected abstract void takeAction(Node node);
}
