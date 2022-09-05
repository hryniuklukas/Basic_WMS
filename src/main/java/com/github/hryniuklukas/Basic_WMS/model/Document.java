package com.github.hryniuklukas.Basic_WMS.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Slf4j
@Entity
@Table(name = "document")
public class Document {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

  @OneToMany(mappedBy = "outboundDocument", cascade = CascadeType.PERSIST)
  private List<Pallet> palletList = new ArrayList<>();

  public void addPalletToDocument(Pallet pallet) {
    palletList.add(pallet);
    pallet.setOutboundDocument(this);
  }


  public void removePalletFromDocument(Pallet pallet) {
    palletList.remove(pallet);
    pallet.setOutboundDocument(null);
  }

  public void executeDocument() {
    palletList.forEach(Pallet::setPalletStatusAsSent);
  }
}
