package com.smartech.app.Services;

import java.util.List;

import com.smartech.app.Entities.MoyenTransport;

public interface MoyenTranspService {
    MoyenTransport saveTransport(MoyenTransport transport);
    List<MoyenTransport> getAllTransport();
    MoyenTransport getTransportById(Long Id);
    MoyenTransport updateTransport(MoyenTransport transport,long id);
    void deleteTransport(long id);
}