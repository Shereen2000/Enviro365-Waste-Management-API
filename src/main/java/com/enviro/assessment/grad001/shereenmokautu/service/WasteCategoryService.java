package com.enviro.assessment.grad001.shereenmokautu.service;

import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WasteCategoryService {
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    //Retrieve all waste categories ______________________________________________________________________________________

    public List<WasteCategory> getAllWasteCategories()
    {
        return wasteCategoryRepository.findAll();
    }

    //Retrieve a waste category by id __________________________________________________________________________________

    public WasteCategory getWasteCategoryById(Long wasteCategoryId)
    {
        return wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(()-> new IllegalStateException("waste category of id="+wasteCategoryId+" is not found"));
    }

    //Add a new waste category _________________________________________________________________________________________

    public WasteCategory addNewWasteCategory(WasteCategory wasteCategory)
    {
        Optional<WasteCategory> wasteCategoryOptional = wasteCategoryRepository
                .findWasteCategoryByName(wasteCategory.getName());

        if(wasteCategoryOptional.isPresent())
        {
            throw new IllegalStateException(wasteCategory.getName()+" already exist");
        }

        WasteCategory savedWasteCategory = wasteCategoryRepository.save(wasteCategory);

        return savedWasteCategory;
    }


    //Update a waste product____________________________________________________________________________________________

    @Transactional
    public WasteCategory updateWasteCategory(WasteCategory wasteCategory, Long wasteCategoryId) {

        WasteCategory existingWasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new IllegalStateException("WasteCategory of id: " + wasteCategoryId +
                        " does not exist"));

        if (wasteCategory.getName() != null &&
                wasteCategory.getName().length() > 0 &&
                !Objects.equals( existingWasteCategory.getName(), wasteCategory.getName() ))
        {
                existingWasteCategory.setName(wasteCategory.getName());
        }

        if (wasteCategory.getDescription() != null &&
                wasteCategory.getDescription().length() > 0 &&
                !Objects.equals( existingWasteCategory.getDescription(), wasteCategory.getDescription() ))
        {
            existingWasteCategory.setDescription(wasteCategory.getDescription());
        }

        if(wasteCategory.getWasteType() != null &&
                !Objects.equals(existingWasteCategory.getWasteType(), wasteCategory.getWasteType()))
        {
            existingWasteCategory.setWasteType(wasteCategory.getWasteType());
        }

        return existingWasteCategory;

    }


    //Delete a waste category by id_____________________________________________________________________________________

    public void deleteWasteCategory(Long wasteCategoryId)
    {
        boolean exists = wasteCategoryRepository.existsById(wasteCategoryId);

        if(!exists)
        {
            throw new IllegalStateException("waste category with id: "+wasteCategoryId+" does not exist");
        }

        wasteCategoryRepository.deleteById(wasteCategoryId);
    }

}
