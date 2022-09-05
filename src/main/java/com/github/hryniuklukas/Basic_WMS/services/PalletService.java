package com.github.hryniuklukas.Basic_WMS.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.repos.PalletRepo;

import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import com.github.hryniuklukas.Basic_WMS.specs.CustomSpecification;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import com.github.hryniuklukas.Basic_WMS.utils.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PalletService {

  private final PalletRepo palletRepo;
  private final PalletSpaceRepo palletSpaceRepo;
  private final DTOMapper mapper;

  public PalletService(PalletRepo palletRepo, PalletSpaceRepo palletSpaceRepo, DTOMapper mapper) {
    this.palletRepo = palletRepo;
    this.palletSpaceRepo = palletSpaceRepo;
    this.mapper = mapper;
  }

  public List<PalletDTO> listAllPallets() {
    return palletRepo.findAll().stream().map(mapper::toDTO).toList();
  }

  public void addPalletToPalletSpace(PalletDTO palletDTO, Long id) {
    if (id == 0) {
      id = 9L;
    }
    if (palletSpaceRepo.findById(id).isPresent()) {
      PalletSpace foundPalletSpace = palletSpaceRepo.findById(id).get();
      Pallet palletToAdd = mapper.toDomain(palletDTO);
      foundPalletSpace.addPallet(palletToAdd);
      palletSpaceRepo.save(foundPalletSpace);
      log.info(
          "Pallet with code: {} has been placed on Pallet Space with code: {}",
          palletToAdd.getPalletCode(),
          foundPalletSpace.getSpaceCode());
    } else {
      log.info("Pallet not added. Pallet space with id: {} not found.", id);
    }
  }
}
