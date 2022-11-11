package Exepciones;

import java.io.IOException;

public class ExeptionCampoVacio extends IOException {

    public ExeptionCampoVacio(){};

    public ExeptionCampoVacio(String mensaje){
        super(mensaje);
    }
}
