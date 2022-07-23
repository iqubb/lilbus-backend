//package com.qubb.lilbus.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User first = new User(
//                    "Nadir",
//                    "nadir@gmail.com",
//                    "nadir"
//            );
//
//            User second = new User(
//                    "Dima",
//                    "dima@gmail.com",
//                    "dima"
//            );
//
//            User third = new User(
//                    "Egor",
//                    "egor@gmail.com",
//                    "egor"
//            );
//
//            userRepository.saveAll(List.of(first, second, third));
//        };
//    }
//}
