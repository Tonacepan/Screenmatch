package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);
        var peliculatona = new Pelicula("El Señor de los anillos", 2001);
        peliculatona.evalua(10);
        Serie lost = new Serie("Lost", 2000);
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculatona);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println((pelicula.getClasificacion()));
            }
        }

        ArrayList<String> artistas = new ArrayList<>();
        artistas.add("Penelope Cruz");
        artistas.add("Antonio Valderas");
        artistas.add("Ricardo Jarin");

        System.out.println(artistas);
        Collections.sort(artistas);
        System.out.println("Lista de artista ordenada: " + artistas);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por feccha: " + lista);
    }
}
