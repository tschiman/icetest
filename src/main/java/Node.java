import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node parent; //null if top of tree
    private List<Node> children = new ArrayList<>(); //empty list if no children
    private Object value; //values can be any object, equality checked on object references

    public Node(Object value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void addChild(Node node) {
        node.parent = this;
        children.add(node);
    }


}
