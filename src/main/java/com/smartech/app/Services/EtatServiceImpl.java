package com.smartech.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.app.Entities.Etat;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.EtatRepository;
@Service
public class EtatServiceImpl implements EtatService {
	
	
	private EtatRepository EtatRepository;
	@Autowired
	
    public EtatServiceImpl(EtatRepository EtatRepository) {
        super();
        this.EtatRepository = EtatRepository;
    }

    @Override
    public Etat saveEtat(Etat Etat) {
        return EtatRepository.save(Etat);
    }

    @Override
    public List<Etat> getAllEtat() {
        return EtatRepository.findAll();
    }

    @Override
    public Etat getEtatById(Long Id) {
        return EtatRepository.findById(Id).orElseThrow(()->
                new NotFoundException("Moyen ,Id",Id));
    }

    @Override
    public Etat updateEtat(Etat Etat, long id) {
        Etat EtatExist = EtatRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Etat, Id",id));
        EtatExist.setCode(Etat.getCode());
        EtatExist.setEtat(Etat.getEtat());

        EtatRepository.save(EtatExist);
        return EtatExist;
    }

    @Override
    public void deleteEtat(long id) {
        EtatRepository.findById(id).orElseThrow(()->
                new NotFoundException("Etat ,Id",id));
        EtatRepository.deleteById(id);
    }
}
