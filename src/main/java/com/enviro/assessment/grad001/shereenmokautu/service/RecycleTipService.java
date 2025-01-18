package com.enviro.assessment.grad001.shereenmokautu.service;

import com.enviro.assessment.grad001.shereenmokautu.model.RecycleTip;
import com.enviro.assessment.grad001.shereenmokautu.repository.RecycleTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class RecycleTipService {
    private final RecycleTipRepository recycleTipRepository;

    @Autowired
    public RecycleTipService(RecycleTipRepository recycleTipRepository) {
        this.recycleTipRepository = recycleTipRepository;
    }

    //Retrieve all recycle tips ______________________________________________________________________________________

    public List<RecycleTip> getAllRecycleTips()
    {
        return recycleTipRepository.findAll();
    }

    //Retrieve a recycle tip by id ____________________________________________________________________________________

    public RecycleTip getRecycleTipById(Long recycleTipId)
    {
        return recycleTipRepository.findById(recycleTipId)
                .orElseThrow(()-> new IllegalStateException("Recycle tip of Id: "+recycleTipId+
                        " is not found"));
    }

    //Delete a recycle tip _____________________________________________________________________________________________

    public void deleteRecycleTip(Long recycleTipId)
    {
        RecycleTip existingTip = recycleTipRepository.findById(recycleTipId)
                .orElseThrow(()-> new IllegalStateException("Recycle tip of Id = "+recycleTipId+
                        " is not found"));

        recycleTipRepository.delete(existingTip);
    }

    //Create New Recycle tip __________________________________________________________________________________________

    public RecycleTip addNewRecycleTip(RecycleTip recycleTip)
    {
        recycleTipRepository.save(recycleTip);
        return recycleTip;
    }

    //Update a recycle tip ____________________________________________________________________________________________

    @Transactional
    public RecycleTip updateRecycleTip(RecycleTip Tip, Long recycleTipId)
    {
        RecycleTip existingTip = recycleTipRepository.findById(recycleTipId)
                .orElseThrow(()-> new IllegalStateException("Recycle tip of Id = "+recycleTipId+
                        " is not found"));

        if (Tip.getTitle() != null &&
            Tip.getTitle().length() > 0 &&
                !Objects.equals( existingTip.getTitle(), Tip.getTitle() ))
        {
            existingTip.setTitle(Tip.getTitle());
        }

        if (Tip.getBody() != null &&
                Tip.getBody().length() > 0 &&
                !Objects.equals( existingTip.getBody(), Tip.getBody() ))
        {
            existingTip.setBody(Tip.getBody());
        }

        if (Tip.getIsActive() != null &&
                !Objects.equals( existingTip.getIsActive(), Tip.getIsActive() ))
        {
            existingTip.setIsActive(Tip.getIsActive());
        }

            existingTip.setUpdatedAt(LocalDate.now());

            return existingTip;
    }

    //Retrieve active recycle tips create from date ____________________________________________________________________

    public List<RecycleTip> getActiveTipsFromDate(LocalDate createdFrom)
    {
        return recycleTipRepository.findByIsActiveAndCreatedAtGreaterThanEqual(true, createdFrom);
    }

}
