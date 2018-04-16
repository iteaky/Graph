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
        Graph graph1 = new Graph(drevoList);
        Graph graph3 = new Graph(drevoList);
        Integer mainVertex = 3;

        final Graph route1 = graph.deikstra(mainVertex);
        System.out.println();
        System.out.println("<--------DEIKSTA------------------------------------------------------>");
        System.out.println();
        System.out.println("Vector of last min Vertex is: " + Arrays.toString(route1.vector));
        route1.getVertexes().forEach(s -> System.out.println("Route from " + mainVertex + " to " + s.getNumber() + " is equals " + s.getWeight()));
        System.out.println();
        System.out.println("<--------BELMAN FORD-------------------------------------------------->");
        System.out.println();
        final Graph route2 = graph1.belmanFord(mainVertex);
        System.out.println("Vector of last min Vertex is: " + Arrays.toString(route2.vector));
        route2.getVertexes().forEach(s -> System.out.println("Route from " + mainVertex + " to " + s.getNumber() + " is equals " + s.getWeight()));

        final Integer[][] integers = graph3.floidUorshal();
        System.out.println();
        System.out.println("<--------FLOID UORSHAL-------------------------------------------------->");
        System.out.println();
        System.out.println("<--------matrix of weight----------->");
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers.length; j++) {
                if (integers[i][j] == Integer.MAX_VALUE) {
                    integers[i][j] = 0;
                }
                System.out.print(integers[i][j] + (integers[i][j] >= 10 ? " " : "  "));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("<--------matrix of pre last route----------->");

        for (int i = 0; i < graph3.route.length; i++) {
            for (int j = 0; j < graph3.route.length; j++) {
                System.out.print(graph3.route[i][j] + (graph3.route[i][j] >= 10 ? " " : "  "));
            }
            System.out.println();
        }


    }
}
