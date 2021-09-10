package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Chart")
public class Chart {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long product_id;
    //private Long client_id;
    private double quantity;

    @JoinColumn(name = "Client_id", referencedColumnName = "id")
    @OneToOne
    @MapsId
    @JsonIgnore
    private Client client;
}
