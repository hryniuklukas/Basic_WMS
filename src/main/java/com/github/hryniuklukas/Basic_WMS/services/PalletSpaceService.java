package com.github.hryniuklukas.Basic_WMS.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpaceDTO;
import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PalletSpaceService {

  private final PalletSpaceRepo palletSpaceRepo;
  private final DTOMapper mapper;
  private final QrApiService qrApiService;

  public PalletSpaceService(
          PalletSpaceRepo palletSpaceRepo, DTOMapper mapper, QrApiService qrApiService) {
    this.palletSpaceRepo = palletSpaceRepo;
    this.mapper = mapper;
    this.qrApiService = qrApiService;
  }

  public List<PalletSpaceDTO> listAllPalletSpaces() {
    log.info("Listing all pallet spaces;");
    return palletSpaceRepo.findAll().stream().map(mapper::toDTO).toList();
  }
  public void createPalletSpace(ObjectNode messageNode){
    String palletSpaceCode = messageNode.get("palletSpace").asText();
    palletSpaceRepo.save(new PalletSpace(palletSpaceCode));
  }
  public List<PalletSpaceDTO> getAllPalletsFromPalletSpace(Long id){
    return palletSpaceRepo.findById(id).stream()
            .map(mapper::toDTO)
            .toList();
  }
  public byte[] getQrForPalletSpace(Long id){
    return qrApiService.getQR("200x200", palletSpaceRepo.findById(id).get().getSpaceCode());
  }
}
