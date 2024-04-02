package org.example;

import java.util.ArrayList;


import static spark.Spark.*;

public class SparkWebServer {
    public static void main(String[] args) {
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("factors", (req,res) -> {
            String json ;
            ArrayList<Integer> arrValores1;
            int valor = Integer.parseInt(req.queryParams("valor"));
            arrValores1 = facto(valor);
            json = jsonF(valor,arrValores1);
            return json;
        });
        get("primes", (req,res) -> {
            String json2 ;
            ArrayList<Integer> arrValores2 ;
            int valor = Integer.parseInt(req.queryParams("valor"));
            arrValores2 = primos(valor);
            json2 = jsonP(valor,arrValores2);
            return json2;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String jsonF(int valor, ArrayList<Integer> resultado){
        String s = "{\n" +
                " \"operation\": \"facto\",\n" +
                " \"input\": " + valor + ",\n" +
                " \"output\": " + resultado + " \n" +
                "}";
        return s;

    }

    private static String jsonP(int valor, ArrayList<Integer> resultado){
        String s = "{\n" +
                " \"operation\": \"Primo\",\n" +
                " \"input\": " + valor + ",\n" +
                " \"output\": " + resultado + " \n" +
                "}";
        return s;

    }
    private static ArrayList<Integer> facto(int valor){
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        int i =0;
        int numero = 1;
        while (i<= valor){
           if ( valor % numero == 0) {
                resultado.add(numero);
           }
            numero += 1;
           i += 1;
        }
        return resultado;
    }

    private static ArrayList<Integer> primos(int valor){
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        for(int i = 2; i<valor;i++){
            int factores = facto(i).size();
            if (factores == 2) {
                respuesta.add(i);
            }
        }
        return respuesta;
    }
}

