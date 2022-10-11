package com.nighthawk.spring_portfolio.mvc.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class RosterInit {

    // Inject repositories
    @Autowired
    RosterJpaRepository repository;

    @Bean
    CommandLineRunner runScioly() { // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // starting jokes
            final String[][] memberArray = {
                    { "Don Tran", "11", "donqt15@gmail.com", "000-000-0000" },
                    { "Krish Patil", "11", "krishpatil1019@gmail.com", "000-000-0000" },
                    { "Bailey Say", "11", "baileyasay@gmail.com", "000-000-0000" },
                    { "Rohan Gaikwad", "11", "gaikwadrohan326@gmail.com", "000-000-0000" },
                    { "Andrew Meng", "11", "unknown", "000-000-0000" },
                    { "Nicolas Mounier", "11", "unknown", "000-000-0000" },
                    { "Nicholas Ramos", "11", "unknown", "000-000-0000" },
            };

            // make sure Joke database is populated with starting jokes
            for (int i = 0; i < memberArray.length; i++) {
                String name = memberArray[i][0];
                String email = memberArray[i][2];
                String phoneNumber = memberArray[i][3];
                int grade = Integer.parseInt(memberArray[i][1]);
                List<Roster> test = repository.findByNameIgnoreCase(name); // JPA lookup
                if (test.size() == 0)
                    repository.save(new Roster(null, name, null, grade, email, phoneNumber)); // JPA save
            }

        };
    }
}