package com.qubb.lilbus.config;

import com.qubb.lilbus.enumeration.PaymentMethod;
import com.qubb.lilbus.repository.UserRepository;
import com.qubb.lilbus.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User first = new User(
                    "375331111111",
                    PaymentMethod.BY_CASH,
                    LocalDate.now()
            );

            User second = new User(
                    "375292222222",
                    PaymentMethod.BY_CARD,
                    LocalDate.now()
            );

            User third = new User(
                    "375293333333",
                    PaymentMethod.BY_CASH,
                    LocalDate.now()
            );

            userRepository.saveAll(List.of(first, second, third));
        };
    }
}
