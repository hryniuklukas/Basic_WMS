package com.github.hryniuklukas.Basic_WMS.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DocumentDTO {
    Long id;
    LocalDate creationDate;
    List<PalletDTO> palletDTOList;
}
