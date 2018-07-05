import java.util.ArrayList;
import java.util.List;

public class StringCollectionBuilderNodeWalkerImpl extends NodeWalker {
    private List<String> strings = new ArrayList<>();

    public List<String> getStrings() {
        return strings;
    }

    @Override
    protected void takeAction(Node node) {
        strings.add((String) node.getValue());
    }
}
