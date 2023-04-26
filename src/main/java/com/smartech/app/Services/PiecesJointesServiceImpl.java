package com.smartech.app.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.smartech.app.Entities.PiecesJointes;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.PiecesJointesRepository;

@Service
public class PiecesJointesServiceImpl implements PiecesJointesService{

private PiecesJointesRepository PiecesJointesRepository;
    
    @Autowired
    public PiecesJointesServiceImpl(PiecesJointesRepository PiecesJointesRepository) {
        super();
        this.PiecesJointesRepository = PiecesJointesRepository;
    }

    @Override
    public PiecesJointes savePiecesJointes(PiecesJointes PiecesJointes) {
        return PiecesJointesRepository.save(PiecesJointes);
    }

    @Override
    public List<PiecesJointes> getAllPiecesJointes() {
        return PiecesJointesRepository.findAll();
    }

    @Override
    public PiecesJointes getPiecesJointesById(Long Id) {
        return PiecesJointesRepository.findById(Id).orElseThrow(()->
                new NotFoundException("PiecesJointes Id : ",Id));
    }

    @Override
    public PiecesJointes updatePiecesJointes(PiecesJointes PiecesJointes, long id){
    	PiecesJointes PiecesJointesExist = PiecesJointesRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("PiecesJointes Id :",id));
    	PiecesJointesExist.setNomFichier(PiecesJointes.getNomFichier());
    	PiecesJointesExist.setType(PiecesJointes.getType());
    	PiecesJointesExist.setPiece(PiecesJointes.getPiece());
    	PiecesJointesExist.setDescription(PiecesJointes.getDescription());

    	PiecesJointesRepository.save(PiecesJointesExist);
        return PiecesJointesExist;
    }

    @Override
    public void deletePiecesJointes(long id) {
    	PiecesJointesRepository.findById(id).orElseThrow(()->
                new NotFoundException("PiecesJointes Id :",id));
    	PiecesJointesRepository.deleteById(id);
    }

	@Override
	public PiecesJointes saveAttachement(MultipartFile file) throws Exception {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new Exception ("Filename contains invalid path sequence " + fileName);
			}
			
			PiecesJointes PiecesJointes = new PiecesJointes(fileName
							,file.getContentType()
							,file.getBytes());
			return PiecesJointesRepository.save(PiecesJointes);
		}catch(Exception e) {
			throw new Exception ("could not save file " + fileName);
		}
		
	}

}
