import java.io.Serializable;

public class GeneradorID implements Serializable {
    private int id;

    public GeneradorID(int id){
        this.id = id;
    }

    public int generarID(){
        id++;
        return id;
    }
}
