package com.enviro.assessment.grad001.shereenmokautu.config;

import com.enviro.assessment.grad001.shereenmokautu.enums.WasteType;
import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteProduct;
import com.enviro.assessment.grad001.shereenmokautu.repository.DisposalGuideLineRepository;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Set;

@Configuration
public class WasteCategoryConfig {

    @Bean
    CommandLineRunner seedWasteCategory(
            WasteCategoryRepository wasteCategoryRepository,
            DisposalGuideLineRepository disposalGuideLineRepository,
            WasteProductRepository wasteProductRepository ) {
        return args -> {
            // E-Waste category and its guidelines
            WasteCategory eWaste = new WasteCategory(
                    "E-Waste",
                    "E-waste refers to discarded electronic devices and components such as old smartphones, computers, televisions, batteries, and other electronic gadgets that are no longer in use.",
                    WasteType.H
            );
            DisposalGuideLine eWasteGuideline_1 = new DisposalGuideLine("Proper Disposal of E-Waste", "Ensure e-waste is collected at designated recycling centers.", eWaste);
            DisposalGuideLine eWasteGuideline_2 = new DisposalGuideLine("Avoid dumping e-waste in landfills", "E-waste should not be disposed of in regular trash bins.", eWaste);
            eWaste.setDisposalGuideLines(Set.of(eWasteGuideline_1, eWasteGuideline_2));

            // WasteProducts for E-Waste category
            WasteProduct eWasteProduct_1 = new WasteProduct("Used Batteries", eWaste);
            WasteProduct eWasteProduct_2 = new WasteProduct("Used Computer", eWaste);
            eWaste.setWasteProducts(Set.of(eWasteProduct_1, eWasteProduct_2));

            // Plastic Waste category and its guidelines
            WasteCategory plasticWaste = new WasteCategory(
                    "Plastic Waste",
                    "Plastic waste includes items like plastic bags, bottles, packaging materials, and containers.",
                    WasteType.NH
            );
            DisposalGuideLine plasticWasteGuideline_1 = new DisposalGuideLine("Recycling Plastic", "Collect plastics separately for recycling.", plasticWaste);
            DisposalGuideLine plasticWasteGuideline_2 = new DisposalGuideLine("Avoid Single-Use Plastics", "Reduce the use of single-use plastics where possible.", plasticWaste);
            plasticWaste.setDisposalGuideLines(Set.of(plasticWasteGuideline_1, plasticWasteGuideline_2));

            // WasteProducts for Plastic Waste category
            WasteProduct plasticWasteProduct_1 = new WasteProduct("Plastic Bag", plasticWaste);
            WasteProduct plasticWasteProduct_2 = new WasteProduct("Plastic Bottle", plasticWaste);
            plasticWaste.setWasteProducts(Set.of(plasticWasteProduct_1, plasticWasteProduct_2));

            // Organic Waste category and its guidelines
            WasteCategory organicWaste = new WasteCategory(
                    "Organic Waste",
                    "Organic waste consists of biodegradable waste such as food scraps, yard waste, and garden clippings.",
                    WasteType.NH
            );
            DisposalGuideLine organicWasteGuideline_1 = new DisposalGuideLine("Composting Organic Waste", "Use a composting bin to recycle organic waste.", organicWaste);
            DisposalGuideLine organicWasteGuideline_2 = new DisposalGuideLine("Separate from other waste", "Ensure organic waste is separated from non-organic waste.", organicWaste);
            organicWaste.setDisposalGuideLines(Set.of(organicWasteGuideline_1, organicWasteGuideline_2));

            // WasteProducts for Organic Waste category
            WasteProduct organicWasteProduct_1 = new WasteProduct("Food Scraps", organicWaste);
            WasteProduct organicWasteProduct_2 = new WasteProduct("Garden Clippings", organicWaste);
            organicWaste.setWasteProducts(Set.of(organicWasteProduct_1, organicWasteProduct_2));

            // Paper Waste category and its guidelines
            WasteCategory paperWaste = new WasteCategory(
                    "Paper Waste",
                    "Paper waste includes newspapers, magazines, cardboard, and other paper-based products.",
                    WasteType.NH
            );
            DisposalGuideLine paperWasteGuideline_1 = new DisposalGuideLine("Recycling Paper", "Recyclable paper should be placed in paper recycling bins.", paperWaste);
            DisposalGuideLine paperWasteGuideline_2 = new DisposalGuideLine("Avoid Contaminating Paper Waste", "Ensure paper is clean and free of food or other contaminants.", paperWaste);
            paperWaste.setDisposalGuideLines(Set.of(paperWasteGuideline_1, paperWasteGuideline_2));

            // WasteProducts for Paper Waste category
            WasteProduct paperWasteProduct_1 = new WasteProduct("Newspapers", paperWaste);
            WasteProduct paperWasteProduct_2 = new WasteProduct("Cardboard", paperWaste);
            paperWaste.setWasteProducts(Set.of(paperWasteProduct_1, paperWasteProduct_2));

            // Hazardous Chemical Waste category and its guidelines
            WasteCategory hazardousChemicalWaste = new WasteCategory(
                    "Hazardous Chemical Waste",
                    "Hazardous chemical waste includes waste products from manufacturing and industrial processes, including solvents, paints, and other chemicals that are toxic or flammable.",
                    WasteType.H
            );
            DisposalGuideLine hazardousChemicalWasteGuideline_1 = new DisposalGuideLine("Handle with Caution", "Ensure that hazardous chemicals are stored and disposed of properly to avoid contamination.", hazardousChemicalWaste);
            DisposalGuideLine hazardousChemicalWasteGuideline_2 = new DisposalGuideLine("Use Certified Disposal Facilities", "Only use certified hazardous waste disposal facilities.", hazardousChemicalWaste);
            hazardousChemicalWaste.setDisposalGuideLines(Set.of(hazardousChemicalWasteGuideline_1, hazardousChemicalWasteGuideline_2));

            // WasteProducts for Hazardous Chemical Waste category
            WasteProduct hazardousChemicalWasteProduct_1 = new WasteProduct("Paint Cans", hazardousChemicalWaste);
            WasteProduct hazardousChemicalWasteProduct_2 = new WasteProduct("Cleaning Solvents", hazardousChemicalWaste);
            hazardousChemicalWaste.setWasteProducts(Set.of(hazardousChemicalWasteProduct_1, hazardousChemicalWasteProduct_2));

            // Medical Waste category and its guidelines
            WasteCategory medicalWaste = new WasteCategory(
                    "Medical Waste",
                    "Medical waste includes items such as used syringes, bandages, and medical equipment that may be contaminated.",
                    WasteType.NH
            );
            DisposalGuideLine medicalWasteGuideline_1 = new DisposalGuideLine("Safe Disposal of Sharps", "Used syringes and other sharp objects should be disposed of in a proper sharps container.", medicalWaste);
            DisposalGuideLine medicalWasteGuideline_2 = new DisposalGuideLine("Hazardous Material Handling", "Ensure that all medical waste is treated as hazardous waste.", medicalWaste);
            medicalWaste.setDisposalGuideLines(Set.of(medicalWasteGuideline_1, medicalWasteGuideline_2));

            // WasteProducts for Medical Waste category
            WasteProduct medicalWasteProduct_1 = new WasteProduct("Used Syringes", medicalWaste);
            WasteProduct medicalWasteProduct_2 = new WasteProduct("Bandages", medicalWaste);
            medicalWaste.setWasteProducts(Set.of(medicalWasteProduct_1, medicalWasteProduct_2));

            // Textile Waste category and its guidelines
            WasteCategory textileWaste = new WasteCategory(
                    "Textile Waste",
                    "Textile waste consists of discarded clothing, fabrics, and other textile-based products.",
                    WasteType.NH
            );
            DisposalGuideLine textileWasteGuideline_1 = new DisposalGuideLine("Donate Usable Textiles", "Donate clothing or textiles that are still in good condition.", textileWaste);
            DisposalGuideLine textileWasteGuideline_2 = new DisposalGuideLine("Recycling Fabrics", "Recycle fabric waste at designated textile recycling centers.", textileWaste);
            textileWaste.setDisposalGuideLines(Set.of(textileWasteGuideline_1, textileWasteGuideline_2));

            // WasteProducts for Textile Waste category
            WasteProduct textileWasteProduct_1 = new WasteProduct("Old Clothes", textileWaste);
            WasteProduct textileWasteProduct_2 = new WasteProduct("Fabric Scraps", textileWaste);
            textileWaste.setWasteProducts(Set.of(textileWasteProduct_1, textileWasteProduct_2));

            // Saving all the categories, guidelines, and products to the repositories
            wasteCategoryRepository.saveAll(List.of(
                    eWaste, plasticWaste, organicWaste, paperWaste,
                    hazardousChemicalWaste, medicalWaste, textileWaste
            ));

            disposalGuideLineRepository.saveAll(List.of(
                    eWasteGuideline_1, eWasteGuideline_2,
                    plasticWasteGuideline_1, plasticWasteGuideline_2,
                    organicWasteGuideline_1, organicWasteGuideline_2,
                    paperWasteGuideline_1, paperWasteGuideline_2,
                    hazardousChemicalWasteGuideline_1, hazardousChemicalWasteGuideline_2,
                    medicalWasteGuideline_1, medicalWasteGuideline_2,
                    textileWasteGuideline_1, textileWasteGuideline_2
            ));

            wasteProductRepository.saveAll(List.of(
                    eWasteProduct_1, eWasteProduct_2,
                    plasticWasteProduct_1, plasticWasteProduct_2,
                    organicWasteProduct_1, organicWasteProduct_2,
                    paperWasteProduct_1, paperWasteProduct_2,
                    hazardousChemicalWasteProduct_1, hazardousChemicalWasteProduct_2,
                    medicalWasteProduct_1, medicalWasteProduct_2,
                    textileWasteProduct_1, textileWasteProduct_2
            ));
        };
    }
}
