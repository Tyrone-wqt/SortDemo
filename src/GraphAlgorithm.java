import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.util.*;

/**
 * Created by lenovo on 2017/2/21.
 */
public class GraphAlgorithm {

    public void depthFirstSearch(GraphNode start, Set<GraphNode> visited) {
        if (visited.contains(start)) return;
        visit(start);
        visited.add(start);
        for (GraphNode node : start.outs) {
            depthFirstSearch(node, visited);
        }

    }

    public void depthFirstSearchResur(GraphNode start ,Set<GraphNode> visited){
        Stack<GraphNode> stack=new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            GraphNode curNode=stack.pop();
            visit(curNode);
            visited.add(curNode);
            for (GraphNode node:curNode.outs){
                if(visited.contains(node)) continue;
                else stack.push(node);
            }
        }
        //throw new AWTError("");
        throw new RuntimeException("");

    }

    public void widthFirstSearch(GraphNode start,Set<GraphNode> visited){
        Queue<GraphNode> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            GraphNode node=queue.poll();
            visit(node);
            visited.add(node);
            for(GraphNode graphNode:node.outs){
                if(!visited.contains(graphNode))
                queue.add(graphNode);
            }
        }
    }

    public void widthFirstSearchResur(GraphNode start){
        if(start==null) return;
        Queue<GraphNode> queue=new LinkedList<>();
        Set<GraphNode> visited=new HashSet<>();
        queue.add(start);
        widthFirstSearchResurCore( queue, visited);
    }

    private void widthFirstSearchResurCore(Queue<GraphNode> queue,Set<GraphNode> visited){
        if(queue.isEmpty()) return;
        GraphNode curNode=queue.poll();
        visit(curNode);
        visited.add(curNode);
        for(GraphNode node:curNode.outs){
            if(!visited.contains(node))
                queue.add(node);
        }
        widthFirstSearchResurCore(queue,visited);
    }

    private void visit(GraphNode node) {
        System.out.println(node.value);
    }
}
