package com.github.hryniuklukas.Basic_WMS.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PalletShortDTO {

  String palletCode;

  public PalletShortDTO(String palletCode) {
    this.palletCode = palletCode;
  }
}
