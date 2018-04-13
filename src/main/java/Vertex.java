import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private int number;

    public Map<Integer, Integer> routes;

    private boolean visited;

    private Integer weight;


    public Vertex(int number) {
        this.number = number;
        this.routes = new HashMap<Integer, Integer>();
        this.visited = false;
        this.weight = Integer.MAX_VALUE;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }


    public boolean isVisited() {
        return visited;
    }

    public Integer getWeight() {
        return weight;
    }

}
