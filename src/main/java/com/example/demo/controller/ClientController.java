package com.example.demo.controller;

import com.example.demo.entity.Chart;
import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PostMapping("/addIntoCharts")
    public List<Chart> addIntoChart(@RequestBody List<Chart> charts){
        return clientService.addIntoChart(charts);
    }
    @GetMapping("/id/{id}")
    public Client getClientByid(@PathVariable Long id){
        return clientService.getClientByid(id);
    }
    @GetMapping("/getClients")
    public List<Client> getClients(){
        return clientService.getClients();
    }
}
