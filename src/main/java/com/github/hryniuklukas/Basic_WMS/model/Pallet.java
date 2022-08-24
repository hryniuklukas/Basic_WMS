package com.github.hryniuklukas.Basic_WMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Pallet {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String palletCode;
}
