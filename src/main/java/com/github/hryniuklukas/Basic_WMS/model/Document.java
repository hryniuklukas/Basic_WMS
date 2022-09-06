package com.github.hryniuklukas.Basic_WMS.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Slf4j
@Entity
@Table(name = "document")
public class Document {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

  @OneToMany(mappedBy = "outboundDocument", cascade = CascadeType.PERSIST)
  private List<Pallet> palletList = new ArrayList<>();

  private LocalDate creationDate;

  public Document(){
    creationDate = LocalDate.now();
  }
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
