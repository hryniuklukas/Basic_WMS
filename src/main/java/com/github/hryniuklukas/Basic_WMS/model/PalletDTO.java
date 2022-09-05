package com.github.hryniuklukas.Basic_WMS.model;

import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@EqualsAndHashCode
public class PalletDTO {
    String palletCode;
    PalletSpaceShortDTO palletSpaceShortDTO;
    LocalDate date;

  public PalletDTO(String palletCode, LocalDate date, PalletSpaceShortDTO palletSpaceShortDTO) {
    this.palletCode = palletCode;
    this.date = date;
    this.palletSpaceShortDTO = palletSpaceShortDTO;
    }
}
