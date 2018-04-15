import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Graph {

    private List<Vertex> vertexes;

    public int vector[];

    Graph(List<Vertex> vertexes) {
        this.vertexes = vertexes;
        this.vector = new int[vertexes.size()];

    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    private Vertex getMinWeightVertex() {

        final Optional<Vertex> min = vertexes.stream().filter(s -> !s.isVisited()).min((o1, o2) -> {
            if (o1.getWeight() > o2.getWeight()) return 1;
            if (o1.getWeight() < o2.getWeight()) return -1;
            else return 0;
        });
        return min.get();
    }


    public Graph belmanFord(int numberOfMainVertex) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = numberOfMainVertex;
        }

        vertexes.forEach(vertex -> {
            if (vertex.getNumber() == numberOfMainVertex) vertex.setWeight(0);
            else vertex.setWeight(Integer.MAX_VALUE);
        });

        for (int i = 0; i < vertexes.size() - 1; i++) {
            vertexes.forEach(vertex -> vertex.routes.forEach((key, value) -> {
                if (vertex.getWeight() != Integer.MAX_VALUE) {
                    if (vertexes.get(key - 1).getWeight() > vertex.getWeight() + value) {
                        vertexes.get(key - 1).setWeight(vertex.getWeight() + value);
                        vector[key - 1] = vertex.getNumber();

                    }
                }
            }));
        }
        return this;
    }


    public Graph deikstra(int numberOfMainVertex) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = numberOfMainVertex;
        }
        Vertex vertex = vertexes.get(numberOfMainVertex - 1);
        vertex.setWeight(0);
        vertex.routes.forEach((k, v) -> vertexes.get(k - 1).setWeight(Integer.MAX_VALUE));

        while (!vertexes.stream().filter(vertex1 -> !vertex1.isVisited()).collect(Collectors.toList()).isEmpty()) {
            Vertex minVertex = getMinWeightVertex();
            if (!minVertex.routes.isEmpty() & minVertex.getWeight() != Integer.MAX_VALUE) {
                Map<Integer, Integer> routes = minVertex.routes;
                routes.forEach((Integer k, Integer v) -> {
                    final Vertex vertex1 = vertexes.get(k - 1);
                    int newWeight = v + minVertex.getWeight();
                    if (vertex1.getWeight() > newWeight) {
                        vertex1.setWeight(newWeight);
                        vector[vertex1.getNumber() - 1] = minVertex.getNumber();
                    }
                });
                minVertex.setVisited();
            }
            minVertex.setVisited();
        }
        return this;
    }
}
