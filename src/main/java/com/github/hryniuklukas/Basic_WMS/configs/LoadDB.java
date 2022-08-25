package com.github.hryniuklukas.Basic_WMS.configs;

import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletSpace;
import com.github.hryniuklukas.Basic_WMS.repos.PalletRepo;
import com.github.hryniuklukas.Basic_WMS.repos.PalletSpaceRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDB {
    @Bean
    ApplicationRunner initDatabase(PalletSpaceRepo palletSpaceRepo){
        return args -> {
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.01")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.02")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.03")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.04")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.05")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.06")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.07")));
//            log.info("Preloading "+ palletSpaceRepo.save(new PalletSpace("1.08")));

        };
    }
}
