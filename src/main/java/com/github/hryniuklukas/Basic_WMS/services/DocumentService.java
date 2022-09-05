package com.github.hryniuklukas.Basic_WMS.services;

import com.github.hryniuklukas.Basic_WMS.model.Document;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.model.PalletDTO;
import com.github.hryniuklukas.Basic_WMS.repos.DocumentRepo;
import com.github.hryniuklukas.Basic_WMS.utils.DTOMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentService {

  DocumentRepo documentRepo;
  DTOMapper mapper;
  public DocumentService(DocumentRepo documentRepo, DTOMapper mapper) {
    this.documentRepo = documentRepo;
    this.mapper = mapper;
  }

  public Document createNewDocument() {
    Document createdDocument = new Document();
    documentRepo.save(createdDocument);
    return createdDocument;
  }

  public void addPalletToDocument(Document document, Pallet pallet) {
    document.addPalletToDocument(pallet);
    documentRepo.save(document);
  }

  public void removePalletFromDocument(Document document, Pallet pallet) {
    document.removePalletFromDocument(pallet);
    documentRepo.save(document);
  }

  public void executeDocument(Document document) {
    document.executeDocument();
  }
  public List<PalletDTO> getPalletsFromDocument(Document document){
    return document.getPalletList().stream()
            .map(mapper::toDTO)
            .toList();
  }
}
