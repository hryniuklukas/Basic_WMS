package com.github.hryniuklukas.Basic_WMS.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PalletSpace")
@Table(name = "pallet_space")
public class PalletSpace {
    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
    private String spaceCode;

    @OneToMany(
            mappedBy = "palletSpace",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Pallet> palletList = new ArrayList<>();
    public PalletSpace(String spaceCode){
        this.spaceCode = spaceCode;
    }
    public void addPallet(Pallet pallet){
        palletList.add(pallet);
        pallet.setPalletSpace(this);
    }
    public void removePallet(Pallet pallet){
        palletList.remove(pallet);
        pallet.setPalletSpace(null);
    }
}
