package com.github.hryniuklukas.Basic_WMS.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "pallet")
@Getter
@Setter
public class Pallet {
  private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
  private String palletCode;
  private LocalDate date;
  private boolean isInWarehouse;
  @ManyToOne(fetch = FetchType.LAZY)
  private PalletSpace palletSpace;
  @ManyToOne(fetch = FetchType.LAZY)
  private Document outboundDocument;

  public Pallet(String palletCode, LocalDate date) {
    this.palletCode = palletCode;
    this.date = date;
    this.isInWarehouse = true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pallet)) return false;
    return id != null && id.equals(((Pallet) o).getId());
  }

  public void setPalletStatusAsSent() {
    this.isInWarehouse = false;
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
