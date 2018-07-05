import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testTopNodeCreation() {
        Node node = new Node("one");

        Assert.assertNull(node.getParent());
        Assert.assertEquals(0L, node.getChildren().size());
        Assert.assertEquals("one", node.getValue());
    }

    @Test
    public void testAddChildNode() {
        Node parent = new Node("one");
        Node child = new Node("First Child");

        parent.addChild(child);

        Assert.assertTrue(parent == child.getParent());
        Assert.assertEquals(1L, parent.getChildren().size());
        Assert.assertEquals("one", parent.getChildren().get(0).getParent().getValue());
        Assert.assertEquals("First Child", parent.getChildren().get(0).getValue());
    }
}