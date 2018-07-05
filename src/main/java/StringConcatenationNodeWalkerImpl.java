public class StringConcatenationNodeWalkerImpl extends NodeWalker {

    private String string = "";

    public String getString() {
        return string;
    }

    @Override
    protected void takeAction(Node node) {
        string += node.getValue().toString();
    }
}
