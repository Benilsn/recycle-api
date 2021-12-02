package com.recycle.Recycle.services;

import com.recycle.Recycle.DTO.ClientDTO;
import com.recycle.Recycle.config.SecurityConfig;
import com.recycle.Recycle.models.Client;
import com.recycle.Recycle.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    protected ClientRepository clientRepository;

    public boolean checkIfExists(Integer id){
        var client = clientRepository.findById(id);

        if (client.isPresent()){
            return true;
        }else{
            return false;
        }
    }

    public List<ClientDTO> getAll(){
        List<ClientDTO> list = new ArrayList<>();

        for (Client c : clientRepository.findAll()){
            list.add(ClientDTO.convert(c));
        }
        return list;
    }

    public ClientDTO getById(Integer id){
        return ClientDTO.convert(clientRepository.getById(id));
    }

    public void addClient(ClientDTO cd){

        var client = new Client();
        client.setClient_id(cd.getClient_id());
        client.setFirst_name(cd.getFirst_name());
        client.setLast_name(cd.getLast_name());
        client.setAge(cd.getAge());
        client.setEmail(cd.getEmail());
        client.setUser_role(cd.getUser_role());
        client.setUser_name(cd.getUser_name());
        client.setUser_password(SecurityConfig.hashPassword(cd.getUser_password()));

        clientRepository.save(client);
    }

    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    public void updateById(ClientDTO c){

        var client = clientRepository.findById(c.getClient_id()).get();

        client.setClient_id(c.getClient_id());
        client.setFirst_name(c.getFirst_name());
        client.setLast_name(c.getLast_name());
        client.setAge(c.getAge());
        client.setEmail(c.getEmail());

        clientRepository.save(client);

    }
}
