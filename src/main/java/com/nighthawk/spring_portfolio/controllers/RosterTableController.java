package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.scioly_backend.student_roster.mvc.students.RosterJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.scioly_backend.student_roster.mvc.students.Roster;
import java.util.List;

@Controller // HTTP requests are handled as a controller, using the @Controller annotation
public class RosterTableController {

    // Dependency Injection
    @Autowired
    RosterJpaRepository repository;

    // CONTROLLER handles GET request for /birds, maps it to birds() method
    @GetMapping("/roster")
    public String roster(Model model) {

        List<Roster> roster = repository.findAll();
        model.addAttribute("roster", roster);

        // load HTML VIEW (birds.html)
        return "roster";

    }
}
