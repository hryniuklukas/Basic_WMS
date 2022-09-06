package com.github.hryniuklukas.Basic_WMS.utils;

import com.github.hryniuklukas.Basic_WMS.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DTOMapper {
  public PalletDTO toDTO(Pallet pallet) {
    return new PalletDTO(pallet.getPalletCode(),pallet.getDate(), this.toShortDTO(pallet.getPalletSpace()));
  }
  public PalletShortDTO toShortDTO(Pallet pallet){
    return new PalletShortDTO(pallet.getPalletCode());
  }

  public Pallet toDomain(PalletDTO palletDTO) {
    return new Pallet(palletDTO.getPalletCode(),palletDTO.getDate());
  }

  public PalletSpaceDTO toDTO(PalletSpace palletSpace) {
    return new PalletSpaceDTO(palletSpace.getSpaceCode(),
            palletSpace.getPalletList().stream()
            .map(this::toShortDTO)
                    .toList()
    );
  }
  public PalletSpaceShortDTO toShortDTO(PalletSpace palletSpace){
    return new PalletSpaceShortDTO(palletSpace.getSpaceCode());
  }

  public PalletSpace toDomain(PalletSpaceDTO palletSpaceDTO) {
    return new PalletSpace(palletSpaceDTO.getSpaceCode());
  }

  public DocumentDTO toDTO(Document document){
    return new DocumentDTO(document.getId(), document.getCreationDate(), document.getPalletList().stream().map(this::toDTO).toList());
  }
}
