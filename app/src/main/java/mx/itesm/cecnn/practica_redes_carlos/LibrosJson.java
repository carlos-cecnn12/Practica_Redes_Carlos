package mx.itesm.cecnn.practica_redes_carlos;

import android.graphics.Bitmap;

public class LibrosJson {
    private String titulo;
    private Bitmap portada;

    public LibrosJson(String titulo, Bitmap portada){
        this.titulo = titulo;
        this.portada =portada;

    }

    public String getTitulo(){
        return this.titulo;
    }

    public Bitmap getPortada(){
        return this.portada;
    }


}
