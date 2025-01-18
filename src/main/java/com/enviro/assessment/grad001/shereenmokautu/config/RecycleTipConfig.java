package com.enviro.assessment.grad001.shereenmokautu.config;

import com.enviro.assessment.grad001.shereenmokautu.model.RecycleTip;
import com.enviro.assessment.grad001.shereenmokautu.repository.RecycleTipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class RecycleTipConfig {

    @Bean
    CommandLineRunner seedRecycleTip (RecycleTipRepository recycleTipRepository)
    {
        return args -> {
                RecycleTip tip1 = new RecycleTip(
                        null, // id will be generated automatically
                        "Recycle Paper and Cardboard",
                        "Recycle paper and cardboard to save trees and reduce landfill waste.",
                        LocalDate.now(),
                        LocalDate.now(),
                        true
                );

                RecycleTip tip2 = new RecycleTip(
                        null, // id will be generated automatically
                        "Avoid Single-Use Plastics",
                        "Avoid single-use plastics and opt for reusable items like bags, bottles, and containers.",
                        LocalDate.now(),
                        LocalDate.now(),
                        true
                );

                RecycleTip tip3 = new RecycleTip(
                        null, // id will be generated automatically
                        "Donate Items You Don't Use",
                        "Instead of throwing items away, donate them to reduce waste and help others.",
                        LocalDate.now(),
                        LocalDate.now(),
                        true
                );

                RecycleTip tip4 = new RecycleTip(
                        null, // id will be generated automatically
                        "Compost Organic Waste",
                        "Composting food scraps and yard waste can help reduce landfill and create nutrient-rich soil.",
                        LocalDate.now(),
                        LocalDate.now(),
                        true
                );

                RecycleTip tip5 = new RecycleTip(
                        null, // id will be generated automatically
                        "Recycle Electronics Responsibly",
                        "Ensure proper recycling of electronic devices to prevent hazardous materials from polluting the environment.",
                        LocalDate.now(),
                        LocalDate.now(),
                        true
                );

                    recycleTipRepository.saveAll(
                            List.of(tip1, tip2, tip3, tip4, tip5)
            );
        };
    }
}
