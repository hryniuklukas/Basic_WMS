package com.github.hryniuklukas.Basic_WMS.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpaceDTO;
import com.github.hryniuklukas.Basic_WMS.services.PalletSpaceService;
import com.github.hryniuklukas.Basic_WMS.services.QrApiService;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/palletspace")
public class PalletSpaceController {

  private final DTOMapper mapper;

  private final PalletSpaceService palletSpaceService;


  public PalletSpaceController(DTOMapper mapper, PalletSpaceService palletSpaceService) {
    this.mapper = mapper;
    this.palletSpaceService = palletSpaceService;
  }

  @GetMapping
  List<PalletSpaceDTO> listAllPalletSpaces() {
    return palletSpaceService.listAllPalletSpaces();
  }

  @PostMapping
  void createPalletSpace(@RequestBody ObjectNode messageNode){
    palletSpaceService.createPalletSpace(messageNode);
  }

  @GetMapping("/pallets")
  PalletDTO listTestPallet() {
    return mapper.toDTO(new Pallet("1234"));
  }
  @GetMapping("/{id}")
  List<PalletSpaceDTO> getPalletsFromPalletSpace(@PathVariable Long id){
    return palletSpaceService.getAllPalletsFromPalletSpace(id);
  }
  @GetMapping(value = "/qr/{id}", produces = MediaType.IMAGE_PNG_VALUE)
  public @ResponseBody byte[] getPalletSpaceQR(@PathVariable Long id){
    return palletSpaceService.getQrForPalletSpace(id);
  }
}
