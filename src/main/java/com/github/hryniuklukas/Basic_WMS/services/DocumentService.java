package com.github.hryniuklukas.Basic_WMS.services;

import com.github.hryniuklukas.Basic_WMS.model.Document;
import com.github.hryniuklukas.Basic_WMS.model.DocumentDTO;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.repos.DocumentRepo;
import com.github.hryniuklukas.Basic_WMS.repos.PalletRepo;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentService {

  DocumentRepo documentRepo;
  PalletRepo palletRepo;
  DTOMapper mapper;

  public DocumentService(DocumentRepo documentRepo, DTOMapper mapper, PalletRepo palletRepo) {
    this.documentRepo = documentRepo;
    this.mapper = mapper;
    this.palletRepo = palletRepo;
  }

  public DocumentDTO createNewDocument() {
    Document createdDocument = new Document();
    documentRepo.save(createdDocument);
    return mapper.toDTO(createdDocument);
  }

  public void addPalletToDocument(Document document, Pallet pallet) {
    document.addPalletToDocument(pallet);
    documentRepo.save(document);
  }

  public void addPalletToDocument(Long docID, Long palletID) {
    Optional<Document> documentSearchResult;
    Optional<Pallet> palletSearchResult;
    Document document;
    Pallet pallet;
    documentSearchResult = documentRepo.findById(docID);
    palletSearchResult = palletRepo.findById(palletID);
    log.info("Searching for document of id: {}", docID);
    if (documentSearchResult.isPresent()) {
      log.info("Document found");
      document = documentSearchResult.get();
      log.info("Searching for pallet of id: {}", palletID);
      if (palletSearchResult.isPresent()) {
        log.info("Pallet found");
        pallet = palletSearchResult.get();
        log.info("Adding pallet of id: {} to document of id: {}", palletID, docID);
        document.addPalletToDocument(pallet);
      } else {
        log.info("Pallet not found");
      }
    } else {
      log.info("Document not found");
    }
  }

  public void removePalletFromDocument(Document document, Pallet pallet) {
    document.removePalletFromDocument(pallet);
    documentRepo.save(document);
  }

  public void executeDocument(Document document) {
    document.executeDocument();
  }

  public void executeDocument(Long docID){
    Optional<Document> searchResult;
    Document document;
    searchResult=documentRepo.findById(docID);
    if(searchResult.isPresent()){
      document=searchResult.get();
      document.executeDocument();
      log.info("Document of id: {} executed", docID);
    }else{
      log.info("Document of id: {} not found", docID);
    }
  }

  public List<PalletDTO> getPalletsFromDocument(Document document) {
    return document.getPalletList().stream()
            .map(mapper::toDTO)
            .toList();
  }

  public DocumentDTO getDocumentById(Long id) {
    return documentRepo.findById(id)
            .map(document -> mapper.toDTO(document))
            .orElse(null);
  }

  public List<DocumentDTO> getDocumentDTOList(){
    return documentRepo.findAll().stream()
            .map(mapper::toDTO)
            .toList();
  }
}
