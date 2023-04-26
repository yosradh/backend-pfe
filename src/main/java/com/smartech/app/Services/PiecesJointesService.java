package com.smartech.app.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.smartech.app.Entities.PiecesJointes;

public interface PiecesJointesService {

    List<PiecesJointes> getAllPiecesJointes();
    PiecesJointes getPiecesJointesById(Long Id);
    PiecesJointes updatePiecesJointes(PiecesJointes PiecesJointes,long id);
    void deletePiecesJointes(long id);
	PiecesJointes saveAttachement(MultipartFile file) throws Exception;
	PiecesJointes savePiecesJointes(PiecesJointes PiecesJointes);
}
