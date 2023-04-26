package com.smartech.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.app.Entities.MoyenTransport;
import com.smartech.app.Exception.NotFoundException;
import com.smartech.app.Repositories.MoyenTransportRepository;


@Service
public class TransportServiceImpl implements MoyenTranspService {
	
	
	private MoyenTransportRepository moyenTranspRepository;
	@Autowired
    public TransportServiceImpl(MoyenTransportRepository moyenTranspRepository) {
        super();
        this.moyenTranspRepository = moyenTranspRepository;
    }

    @Override
    public MoyenTransport saveTransport(MoyenTransport transport) {
        return moyenTranspRepository.save(transport);
    }

    @Override
    public List<MoyenTransport> getAllTransport() {
        return moyenTranspRepository.findAll();
    }

    @Override
    public MoyenTransport getTransportById(Long Id) {
        return moyenTranspRepository.findById(Id).orElseThrow(()->
                new NotFoundException("Moyen ,Id",Id));
    }

    @Override
    public MoyenTransport updateTransport(MoyenTransport transport, long id) {
        MoyenTransport moyenExist = moyenTranspRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("MoyenTransport,Id",id));
        moyenExist.setMarque(transport.getMarque());
        moyenExist.setMatricule(transport.getMatricule());

        moyenTranspRepository.save(moyenExist);
        return moyenExist;
    }

    @Override
    public void deleteTransport(long id) {
        moyenTranspRepository.findById(id).orElseThrow(()->
                new NotFoundException("MoyenTransport , Id",id));
        moyenTranspRepository.deleteById(id);
    }
}
