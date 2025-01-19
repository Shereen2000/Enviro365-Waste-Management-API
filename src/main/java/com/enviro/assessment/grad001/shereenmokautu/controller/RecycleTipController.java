package com.enviro.assessment.grad001.shereenmokautu.controller;

import com.enviro.assessment.grad001.shereenmokautu.dto.mapper.RecycleTipMapper;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.RecycleTipCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.RecycleTipUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.RecycleTip;
import com.enviro.assessment.grad001.shereenmokautu.service.RecycleTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recycle-tips")
public class RecycleTipController {

    private final RecycleTipService recycleTipService;
    private final RecycleTipMapper recycleTipMapper;

    @Autowired
    public RecycleTipController(RecycleTipService recycleTipService, RecycleTipMapper recycleTipMapper) {
        this.recycleTipService = recycleTipService;
        this.recycleTipMapper = recycleTipMapper;
    }

    @GetMapping
    public List<RecycleTip> getAllTips()
    {
        return recycleTipService.getAllRecycleTips();
    }

    @GetMapping(path = "/{Tip_id}")
    public RecycleTip getTipById(@PathVariable Long Tip_id){
        return recycleTipService.getRecycleTipById(Tip_id);
    }

    @GetMapping(path = "/active/{date}")
    public List<RecycleTip> getActiveTipsFromDate(@RequestParam("createdFrom") String date)
    {
        LocalDate createdDate = LocalDate.parse(date);
        return recycleTipService.getActiveTipsFromDate(createdDate);
    }

    @PostMapping
    public RecycleTip addNewTip(@RequestBody @Valid RecycleTipCreateRequest recycleTipCreateRequest)
    {
        return recycleTipService.addNewRecycleTip(recycleTipMapper.toRecycleTip(recycleTipCreateRequest));
    }

    @DeleteMapping(path = "/{recycleTip_id}")
    public void deleteTip(@PathVariable Long recycleTip_id)
    {
        recycleTipService.deleteRecycleTip(recycleTip_id);
    }

    @PutMapping(path = "/{recycleTip_id}")
    public RecycleTip UpdateTip(@RequestBody @Valid RecycleTipUpdateRequest recycleTipUpdateRequest, @PathVariable Long recycleTip_id)
    {
       return recycleTipService.updateRecycleTip(recycleTipMapper.toRecycleTip(recycleTipUpdateRequest),recycleTip_id);
    }

}
