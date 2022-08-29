package com.github.hryniuklukas.Basic_WMS.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PalletSpaceShortDTO {
    String spaceCode;
    public PalletSpaceShortDTO(String spaceCode){
        this.spaceCode = spaceCode;
    }
}
