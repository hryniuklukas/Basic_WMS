package com.github.hryniuklukas.Basic_WMS.services;

import com.github.hryniuklukas.Basic_WMS.controllers.PalletSpaceController;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalletSpaceService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PalletSpaceService.class);
    private final PalletSpaceRepo palletSpaceRepo;
    public PalletSpaceService(PalletSpaceRepo palletSpaceRepo){
        this.palletSpaceRepo = palletSpaceRepo;
    }
    public List<PalletSpace> listAllPalletSpaces(){
        log.info("Listing all pallet spaces;");
        return palletSpaceRepo.findAll();
    }
}
