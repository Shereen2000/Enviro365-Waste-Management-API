package com.enviro.assessment.grad001.shereenmokautu.controller;

import com.enviro.assessment.grad001.shereenmokautu.dto.mapper.WasteProductMapper;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteProductRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteProductSortRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteProduct;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteSortingAnswer;
import com.enviro.assessment.grad001.shereenmokautu.service.WasteProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/products")
public class WasteProductController {

    private final WasteProductService wasteProductService;
    private final WasteProductMapper wasteProductMapper;

    @Autowired
    public WasteProductController(WasteProductService wasteProductService, WasteProductMapper wasteProductMapper)
    {
        this.wasteProductService = wasteProductService;
        this.wasteProductMapper = wasteProductMapper;

    }

    @GetMapping
    public List<WasteProduct> GetAllWasteProducts()
    {
        return wasteProductService.getAllWasteProducts();
    }

    @GetMapping(path = "/{wasteProduct_id}")
    public WasteProduct getByWasteProductId(@PathVariable Long wasteProduct_id)
    {
    return wasteProductService.getWasteProductById(wasteProduct_id);
    }

    @GetMapping(path="/categories/{wasteCategory_id}")
    public List<WasteProduct> getByWasteProduct(@PathVariable Long wasteCategory_id)
    {
        return wasteProductService.getWasteProductsByCategory(wasteCategory_id);
    }

    @PostMapping(path = "/categories/{category_id}")
    public WasteProduct addNewWasteProduct(@RequestBody @Valid WasteProductRequest wasteProductRequest,
                                           @PathVariable Long category_id)
    {
        return wasteProductService.AddNewWasteProduct(wasteProductMapper.toWasteProduct(wasteProductRequest),category_id);
    }

    @PostMapping(path = "/sort" )
    public List<WasteSortingAnswer> sortProducts(@RequestBody @Valid  List<WasteProductSortRequest> wasteProductSortRequests)
    {
        return wasteProductService.SortProducts(wasteProductSortRequests.stream().map(wasteProductMapper::toWasteSortingAnswer)
                .collect(Collectors.toList()));
    }

    @DeleteMapping(path = "/{product_id}")
    public void deleteWasteProduct(@PathVariable Long product_id)
    {
        wasteProductService.deleteWasteProduct(product_id);
    }
}
