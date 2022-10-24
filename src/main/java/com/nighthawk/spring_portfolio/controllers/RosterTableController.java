package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Controller // HTTP requests are handled as a controller, using the @Controller annotation
public class RosterTableController {
    // CONTROLLER handles GET request for /birds, maps it to birds() method
    @GetMapping("/roster")
    public String roster(Model model) {

        try {
            // Backend API call
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://backend.dnhsscioly.tk/api/roster/"))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            // RapidAPI request and response
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            // JSONParser extracts text body and parses to JSONObject
            JSONArray roster = (JSONArray) new JSONParser().parse(response.body());

            model.addAttribute("roster", roster);

            // load HTML VIEW (birds.html)
            return "roster";
        } catch (Exception e) { // return error
            e.printStackTrace();
            return "404";
        }

    }
}