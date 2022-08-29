package com.github.hryniuklukas.Basic_WMS.utils;

import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpaceDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DTOMapper {
  public PalletDTO toDTO(Pallet pallet) {
    return new PalletDTO(pallet.getPalletCode());
  }

  public Pallet toDomain(PalletDTO palletDTO) {
    return new Pallet(palletDTO.getPalletCode());
  }

  public PalletSpaceDTO toDTO(PalletSpace palletSpace) {
    return new PalletSpaceDTO(palletSpace.getSpaceCode(),
            palletSpace.getPalletList().stream()
            .map(this::toDTO)
                    .toList()
    );
  }

  public PalletSpace toDomain(PalletSpaceDTO palletSpaceDTO) {
    return new PalletSpace(palletSpaceDTO.getSpaceCode());
  }
}
