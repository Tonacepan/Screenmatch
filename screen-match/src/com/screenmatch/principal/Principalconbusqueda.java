package com.alura.screenmatch.principal;

import com.alura.screenmatch.exepcion.ErrorEnConversionDeDuracionExeption;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principalconbusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner t = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escriba el nombre de una película: ");
            var busqueda = t.nextLine();

            if (busqueda.equalsIgnoreCase("Salir")) {
                break;
            }

            String url = "https://www.omdbapi.com/?t=" + busqueda.replace(" ", "+")
                    + "&apikey=69a5dd4f&y";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb mitituloomdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println( mitituloomdb);

                Titulo mititulo = new Titulo(mitituloomdb);
                System.out.println("Titulo ya convertido: " + mititulo);


                titulos.add(mititulo);

            }catch (NumberFormatException e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Erroe en la URI, verifique la dirección.");
            }catch (ErrorEnConversionDeDuracionExeption e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizo la ejecución del programae");


    }
}
