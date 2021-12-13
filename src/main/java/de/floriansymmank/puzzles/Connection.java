package de.floriansymmank.puzzles;

public class Connection {

    private final Node node2;
    private final Node node1;

    public Connection(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public boolean isConnected(Node node) {
        return (node1 == node || node2 == node);
    }

    public Node getOtherNode(Node node) {
        if (node1 == node)
            return node2;

        if (node2 == node)
            return node1;

        throw new IllegalArgumentException("Node is not connected to this connection");
    }

    @Override
    public String toString() {
        return "Connection [node1=" + node1 + ", node2=" + node2 + "]";
    }
}
