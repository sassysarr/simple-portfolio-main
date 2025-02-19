package com.olky.exchangerateservice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CryptoAPIClient {
    public static void main(String[] args) throws Exception {
        // Créer une instance d'HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // L'URL de l'API CoinGecko pour récupérer les informations sur Bitcoin
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";

        // Créer une requête HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Envoyer la requête et obtenir la réponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir la réponse JSON en un objet Java
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response.body());

        // Extraire la valeur de Bitcoin en USD
        double bitcoinPrice = jsonResponse.path("bitcoin").path("usd").asDouble();
        System.out.println("Le prix actuel de Bitcoin est : " + bitcoinPrice + " USD");
    }
}
