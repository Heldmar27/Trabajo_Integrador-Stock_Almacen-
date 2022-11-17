package Exepciones;

public class ExepcionPropia {

    public static void estaCampoVacio(String campo) throws ExeptionCampoVacio{

        if (campo.isEmpty()){
            ExeptionCampoVacio nuevaExepcion = new ExeptionCampoVacio();
            throw nuevaExepcion;
        }
    }
}
