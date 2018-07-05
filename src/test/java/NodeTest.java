import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class NodeTest {

    @Test
    public void testTopNodeCreation() {
        Node node = new Node(null, new ArrayList<>(), "one");

        Assert.assertNull(node.getParent());
        Assert.assertEquals(0L, node.getChildren().size());
        Assert.assertEquals("one", node.getValue());
    }
}