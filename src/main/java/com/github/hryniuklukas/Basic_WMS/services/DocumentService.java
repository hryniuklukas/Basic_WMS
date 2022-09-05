package com.github.hryniuklukas.Basic_WMS.services;

import com.github.hryniuklukas.Basic_WMS.model.Document;
import com.github.hryniuklukas.Basic_WMS.model.Pallet;
import com.github.hryniuklukas.Basic_WMS.repos.DocumentRepo;

public class DocumentService {

  DocumentRepo documentRepo;

  public DocumentService(DocumentRepo documentRepo) {
    this.documentRepo = documentRepo;
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
}
