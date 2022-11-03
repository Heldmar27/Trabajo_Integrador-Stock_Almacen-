import java.io.*;

public class Archivo {
    private File ruta = new File("archivoAlmacen.txt");

    public Almacen leer(){

        try {
            ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));

            Almacen almacen = (Almacen)flujoEntrada.readObject();

            return almacen;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void escribir(Almacen almacen){

        try {
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));

            flujoSalida.writeObject(almacen);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
