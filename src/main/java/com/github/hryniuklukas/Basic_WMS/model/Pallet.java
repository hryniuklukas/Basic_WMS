package com.github.hryniuklukas.Basic_WMS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Pallet {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String palletCode;
    public Pallet(String palletCode){
        this.palletCode=palletCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private PalletSpace palletSpace;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pallet )) return false;
        return id != null && id.equals(((Pallet) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
