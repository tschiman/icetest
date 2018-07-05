import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

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

    @Test
    public void testCountingNodeWalker() {
        Node root = new Node("root");
        Node c1a = new Node("c1a");
        Node c1b = new Node("c1b");
        Node c1c = new Node("c1c");

        root.addChild(c1a);
        root.addChild(c1b);
        root.addChild(c1c);

        Node c2a = new Node("c2a");
        Node c2b = new Node("c2b");
        Node c2c = new Node("c2c");

        c1a.addChild(c2a);
        c1a.addChild(c2b);
        c1a.addChild(c2c);

        Node c3a = new Node("c3a");
        Node c3b = new Node("c3b");
        Node c3c = new Node("c3c");

        c2a.addChild(c3a);
        c2a.addChild(c3b);
        c2a.addChild(c3c);

        CountingNodeWalkerImpl countingNodeWalker = new CountingNodeWalkerImpl();

        countingNodeWalker.walk(root, Objects::nonNull, false);

        Assert.assertEquals(10, countingNodeWalker.getCount());
    }

    @Test
    public void testStringCollectionNodeWalker() {
        Node root = new Node("root");
        Node c1a = new Node("c1a");
        Node c1b = new Node("c1b");
        Node c1c = new Node("c1c");

        root.addChild(c1a);
        root.addChild(c1b);
        root.addChild(c1c);

        Node c2a = new Node(123);
        Node c2b = new Node("c2b");
        Node c2c = new Node("c2c");

        c1a.addChild(c2a);
        c1a.addChild(c2b);
        c1a.addChild(c2c);

        Node c3a = new Node("c3a");
        Node c3b = new Node(456L);
        Node c3c = new Node(new Object());

        c2a.addChild(c3a);
        c2a.addChild(c3b);
        c2a.addChild(c3c);

        StringCollectionBuilderNodeWalkerImpl stringCollectionBuilderNodeWalker = new StringCollectionBuilderNodeWalkerImpl();

        stringCollectionBuilderNodeWalker.walk(root, n -> n.getValue() instanceof String, true);

        Assert.assertEquals(6, stringCollectionBuilderNodeWalker.getStrings().size());
    }
}