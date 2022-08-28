package com.github.hryniuklukas.Basic_WMS.services;


import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.repos.PalletRepo;

import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalletService {

    private final PalletRepo palletRepo;
    private final DTOMapper mapper;
    public PalletService(PalletRepo palletRepo, DTOMapper mapper){
        this.palletRepo = palletRepo;
        this.mapper = mapper;
    }
    public List<PalletDTO> listAllPallets(){
    return palletRepo.findAll().stream()
            .map(mapper::toDTO)
            .toList();
    }
}
