package com.github.hryniuklukas.Basic_WMS.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.services.PalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/pallet")
public class PalletController {
    private final PalletService palletService;

    public PalletController(PalletService palletService) {
        this.palletService = palletService;
    }

    @GetMapping
    public List<PalletDTO> getAllPallets(){
        return palletService.listAllPallets();
    }
    @PostMapping("/{id}")
    void addPalletToPalletSpace(@PathVariable Long id,
            @RequestBody PalletDTO palletDTO) {
        palletService.addPalletToPalletSpace(palletDTO, id);
    }
}
