package com.github.hryniuklukas.Basic_WMS.repos;

import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PalletRepo extends JpaRepository<Pallet,Long>, JpaSpecificationExecutor<Pallet> {
}
