package com.github.hryniuklukas.Basic_WMS.services;

import com.github.hryniuklukas.Basic_WMS.controllers.PalletSpaceController;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PalletSpaceService {
  private static final Logger log = org.slf4j.LoggerFactory.getLogger(PalletSpaceService.class);
  private final PalletSpaceRepo palletSpaceRepo;

  public PalletSpaceService(PalletSpaceRepo palletSpaceRepo) {
    this.palletSpaceRepo = palletSpaceRepo;
  }

  public List<PalletSpace> listAllPalletSpaces() {
    log.info("Listing all pallet spaces;");
    return palletSpaceRepo.findAll();
  }

  public void addPalletToPalletSpace(Pallet pallet, Long palletID) {
    Optional<PalletSpace> palletSpace = palletSpaceRepo.findById(palletID);
    if (palletSpace.isPresent()) {
      log.info(
          "Adding pallet: {} to: {}", pallet.getPalletCode(), palletSpace.get().getSpaceCode());
      palletSpace.get().addPallet(pallet);
      palletSpaceRepo.save(palletSpace.get());
    }else{
      log.info("Pallet space with id: {} not found", palletID);
    }
  }
}
