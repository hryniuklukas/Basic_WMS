package com.github.hryniuklukas.Basic_WMS.repos;

import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PalletSpaceRepo extends JpaRepository<PalletSpace,Long>, JpaSpecificationExecutor<PalletSpace> {
}
