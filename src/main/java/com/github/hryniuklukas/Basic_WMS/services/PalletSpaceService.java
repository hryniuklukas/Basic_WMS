package com.github.hryniuklukas.Basic_WMS.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpaceDTO;
import com.github.hryniuklukas.Basic_WMS.repos.PalletRepo;
import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import com.github.hryniuklukas.Basic_WMS.specs.CustomSpecification;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import com.github.hryniuklukas.Basic_WMS.utils.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PalletSpaceService {

  private final PalletSpaceRepo palletSpaceRepo;
  private final DTOMapper mapper;

  public PalletSpaceService(
      PalletSpaceRepo palletSpaceRepo, DTOMapper mapper) {
    this.palletSpaceRepo = palletSpaceRepo;
    this.mapper = mapper;
  }

  public List<PalletSpaceDTO> listAllPalletSpaces() {
    log.info("Listing all pallet spaces;");
    return palletSpaceRepo.findAll().stream().map(mapper::toDTO).toList();
  }

  public void addPalletToPalletSpace(ObjectNode messageNode) {
    String palletCode = messageNode.get("palletCode").asText();
    String palletSpaceCode = messageNode.get("palletSpace").asText();
    CustomSpecification<PalletSpace> mySpec1 =
        new CustomSpecification<>(new SearchCriteria("spaceCode", ":", palletSpaceCode));
    Optional<PalletSpace> foundPalletSpace =
        palletSpaceRepo.findAll(Specification.where(mySpec1)).stream().findFirst();
    if (foundPalletSpace.isPresent()) {
      foundPalletSpace.get().addPallet(new Pallet(palletCode));
      palletSpaceRepo.save(foundPalletSpace.get());
      log.info("Pallet with code: {} has been placed on Pallet Space with code: {}", palletCode, palletSpaceCode);
    }else{
      log.info("Pallet Space with code: {} hasn't been found", palletSpaceCode);
    }
  }
}
