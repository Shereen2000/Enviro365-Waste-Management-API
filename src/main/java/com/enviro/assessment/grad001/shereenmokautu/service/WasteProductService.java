package com.enviro.assessment.grad001.shereenmokautu.service;

import com.enviro.assessment.grad001.shereenmokautu.enums.SortingResult;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteProduct;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteSortingAnswer;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WasteProductService {

    private final WasteProductRepository wasteProductRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    public WasteProductService(WasteProductRepository wasteProductRepository,
                               WasteCategoryRepository wasteCategoryRepository
    )
    {
        this.wasteProductRepository = wasteProductRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    //Retrieve all waste products ______________________________________________________________________________________
    public List<WasteProduct> getAllWasteProducts()
    {
        return wasteProductRepository.findAll();
    }

    //Retrieve a waste product by id ___________________________________________________________________________________

    public WasteProduct getWasteProductById(Long wasteProductId)
    {
        return  wasteProductRepository.findById(wasteProductId)
            .orElseThrow(()-> new IllegalStateException("Waste Product of id; "+wasteProductId+" " +
                    "is not found"));
    }


    //Retrieve all waste products of waste category ____________________________________________________________________

    public List<WasteProduct> getWasteProductsByCategory(Long wasteCategoryId)
    {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(()-> new IllegalStateException("waste category of id: "+wasteCategoryId+" is not found"));

        return wasteProductRepository.findByWasteCategory(wasteCategory);
    }

    //Save a new waste product and add it to its waste category ________________________________________________________
    @Transactional
    public WasteProduct AddNewWasteProduct(WasteProduct wasteProduct, Long wasteCategoryId)
    {
        Optional<WasteProduct> wasteProductOptional = wasteProductRepository.findWasteProductByName(wasteProduct.getName());

        if(wasteProductOptional.isPresent())
        {
            throw new IllegalStateException("Product "+wasteProduct.getName()+" already exist");
        }

        WasteCategory existingCategory =  wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(()-> new IllegalStateException("waste category of id: "+wasteCategoryId+" is not found"));

        wasteProduct.setWasteCategory(existingCategory);

        WasteProduct saveWasteProduct = wasteProductRepository.save(wasteProduct);

        existingCategory.getWasteProducts().add(saveWasteProduct);

        return saveWasteProduct;

    }

    //Delete a waste product and remove it from a waste category
    @Transactional
    public void deleteWasteProduct(Long wasteProductId)
    {
        WasteProduct existingProduct = wasteProductRepository.findById(wasteProductId)
                .orElseThrow(()-> new IllegalStateException("Waste Product of id: "+wasteProductId+" " +
                        "is not found"));

        existingProduct.getWasteCategory().getWasteProducts().remove(existingProduct);

        wasteProductRepository.delete(existingProduct);
    }

    public List<WasteSortingAnswer> SortProducts(List<WasteSortingAnswer> answers)
    {

        for (WasteSortingAnswer answer : answers) {

            WasteProduct wasteProduct = wasteProductRepository.findById(answer.getWasteProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Waste Product with id: " + answer.getWasteProductId()
                    +" is not found"));


            WasteCategory wasteCategory = wasteProduct.getWasteCategory();

            answer.setProductName(wasteProduct.getName());
            answer.setCategoryName(wasteCategory.getName());

            if (wasteCategory.getId() == answer.getWasteCategoryId()) {

                answer.setSortingResult(SortingResult.CORRECT);
            } else {

                answer.setSortingResult(SortingResult.INCORRECT);
            }
        }

        return answers;
    }

}
