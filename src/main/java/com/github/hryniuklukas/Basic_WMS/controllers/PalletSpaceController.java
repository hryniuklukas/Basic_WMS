package com.github.hryniuklukas.Basic_WMS.controllers;

import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.services.PalletSpaceService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/palletspace")
public class PalletSpaceController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PalletSpaceController.class);

    private final PalletSpaceService palletSpaceService;
    public PalletSpaceController(PalletSpaceService palletSpaceService){
        this.palletSpaceService=palletSpaceService;
    }

    @GetMapping
    List<PalletSpace> listAllPalletSpaces(){

        return palletSpaceService.listAllPalletSpaces();
    }
    @PostMapping
    void addPalletToPalletSpace(@RequestBody String message){
        String palletCode;
        String palletID;
        palletCode = message.split("_")[0];
        palletID = message.split("_")[1];
        palletSpaceService.addPalletToPalletSpace(new Pallet(palletCode), Long.parseLong(palletID));
    }
}
