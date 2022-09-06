package com.github.hryniuklukas.Basic_WMS.controllers;

import com.github.hryniuklukas.Basic_WMS.model.DocumentDTO;

import com.github.hryniuklukas.Basic_WMS.services.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocumentController {
  private final DocumentService documentService;

  public DocumentController(DocumentService documentService) {
    this.documentService = documentService;
  }

  @GetMapping("/{id}")
  public DocumentDTO getDocumentById(@PathVariable Long id) {
    return documentService.getDocumentById(id);
  }
  @GetMapping
  public List<DocumentDTO> getAllDocumentsAsDTO() {
    return documentService.getDocumentDTOList();
  }

  @PutMapping("/{docID}/add/{palletID}")
  public void addPalletToDocument(@PathVariable Long docID, @PathVariable Long palletID) {
    documentService.addPalletToDocument(docID, palletID);
  }

  @PostMapping
  public DocumentDTO createNewDocument() {
    return documentService.createNewDocument();
  }

  @PutMapping("/{docID}/execute")
  public void executeDocumentById(@PathVariable Long docID) {
    documentService.executeDocument(docID);
  }
}
