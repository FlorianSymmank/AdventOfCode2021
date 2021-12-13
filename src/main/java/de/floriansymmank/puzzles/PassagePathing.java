package de.floriansymmank.puzzles;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PassagePathing {
    private final List<String> passages;
    private final Map<String, Node> nodes;
    private final List<Connection> connections;

    private Node start = null;
    private Node end = null;

    public PassagePathing(List<String> passages) {
        this.passages = passages;
        this.nodes = new HashMap<>();
        this.connections = new ArrayList<>();

        for (String passage : passages) {
            String[] parts = passage.split("-");
            String from = parts[0];
            String to = parts[1];

            Node fromNode;
            if (nodes.containsKey(from))
                fromNode = nodes.get(from);
            else {
                fromNode = new Node(from);
                nodes.put(from, fromNode);
            }

            Node toNode;
            if (nodes.containsKey(to))
                toNode = nodes.get(to);
            else {
                toNode = new Node(to);
                nodes.put(to, toNode);
            }

            connections.add(new Connection(fromNode, toNode));
        }

        start = nodes.get("start");
        end = nodes.get("end");
    }

    public int getAllPathCount() {

        List<Stack<Node>> paths = new ArrayList<>();
        List<Stack<Node>> uniquePaths = new ArrayList<>();

        Stack<Node> startPath = new Stack<>();
        startPath.push(start);
        paths.add(startPath);

        while (paths.size() > 0) {
            List<Stack<Node>> newPaths = new ArrayList<>();
            for (Stack<Node> path : paths) {

                if (path.peek().equals(end)) {
                    uniquePaths.add(path);
                    continue;
                }

                newPaths.addAll(createPaths(path, smallNodesOnlyOnce));
            }
            paths = newPaths;
        }

        printAllPaths(uniquePaths);
        return uniquePaths.size();
    }

    public final BiPredicate<Node, Stack<Node>> smallNodesOnlyOnce = (node, path) -> !node.isSmall() || !path.contains(node);

    private List<Stack<Node>> createPaths(Stack<Node> path, BiPredicate<Node, Stack<Node>> nodeVisitable) {
        List<Stack<Node>> paths = new ArrayList<>();
        if (path.peek().equals(end))
            return paths;

        for (Node node : getAllConnectingNodesFrom(path.peek())) {
            if (nodeVisitable.test(node, path)) {
                Stack<Node> newPath = (Stack<Node>) path.clone();
                newPath.push(node);
                paths.add(newPath);
            }
        }

        return paths;
    }

    public int getAllPathCount2() {
        return 0;
    }

    private List<Node> getAllConnectingNodesFrom(Node node) {

        List<Node> connectingNodes = new ArrayList<>();
        for (Connection connection : connections)
            if (connection.isConnected(node))
                connectingNodes.add(connection.getOtherNode(node));

        return connectingNodes;
    }

    private void printAllPaths(List<Stack<Node>> paths) {
        for (Stack<Node> path : paths)
            System.out.println(path.toString());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Day 12 (PassagePathing): getAllPathCount() = " + getAllPathCount() + "//// getAllPathCount2() = " + getAllPathCount2();
    }


}
