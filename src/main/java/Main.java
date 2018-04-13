import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vertex> drevoList = new ArrayList<Vertex>();
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.routes.put(2, 10);
        vertex1.routes.put(3, 30);
        vertex1.routes.put(4, 50);
        vertex1.routes.put(5, 10);

        vertex3.routes.put(5, 10);

        vertex4.routes.put(2, 40);
        vertex4.routes.put(3, 20);

        vertex5.routes.put(1, 10);
        vertex5.routes.put(3, 10);
        vertex5.routes.put(4, 30);

        drevoList.add(vertex1);
        drevoList.add(vertex2);
        drevoList.add(vertex3);
        drevoList.add(vertex4);
        drevoList.add(vertex5);

        Graph graph = new Graph(drevoList);
        Integer mainVertex = 1;
        final Graph route1 = graph.findRoute(mainVertex);
        System.out.println("Vector of last min Vertex is: " + Arrays.toString(route1.vector));
        route1.getVertexes().forEach(s -> System.out.println("Route from " + mainVertex + " to " + s.getNumber() + " is equals " + s.getWeight()));


    }
}
