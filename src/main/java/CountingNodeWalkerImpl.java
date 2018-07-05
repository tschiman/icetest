public class CountingNodeWalkerImpl extends NodeWalker {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    protected void takeAction(Node node) {
        count++;
    }
}
