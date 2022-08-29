package com.github.hryniuklukas.Basic_WMS.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PalletSpaceDTO {
  String spaceCode;
  List<PalletShortDTO> palletShortDTOList;

  public PalletSpaceDTO(String spaceCode, List<PalletShortDTO> palletShortDTOList)  {
    this.spaceCode = spaceCode;
    this.palletShortDTOList=palletShortDTOList;
  }
}
