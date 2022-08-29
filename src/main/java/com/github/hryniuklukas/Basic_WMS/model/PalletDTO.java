package com.github.hryniuklukas.Basic_WMS.model;

import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class PalletDTO {
    String palletCode;

  public PalletDTO(String palletCode) {
    this.palletCode = palletCode;
    }
}
