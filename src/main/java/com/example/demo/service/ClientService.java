package com.example.demo.service;

import com.example.demo.entity.Chart;
import com.example.demo.entity.Client;
import com.example.demo.repository.ChartRep;
import com.example.demo.repository.ClientRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRep clientRep;
    @Autowired
    private ChartRep chartRep;

    public Client saveClient(Client client){
        //Client client1 = new Client();
        //Chart chart1 = new Chart();
        //chart1.setClient(client);
        //client.getChart().forEach(chart -> chart.setClient(client));
        client.getChart().setClient(client);
        return clientRep.save(client);
    }

    public Client getClientByid(Long id){
        return clientRep.findById(id).orElse(null);
    }
    public List<Client> getClients(){
        return clientRep.findAll();
    }

    //Read productId and quantity
    public List<Chart> addIntoChart(List<Chart> charts){
        return chartRep.saveAll(charts);
    }


}
