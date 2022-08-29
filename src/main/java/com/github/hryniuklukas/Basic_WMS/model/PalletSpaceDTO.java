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
  List<PalletDTO> palletDTOList;

  public PalletSpaceDTO(String spaceCode, List<PalletDTO> palletDTOList)  {
    this.spaceCode = spaceCode;
    this.palletDTOList=palletDTOList;
  }
}
