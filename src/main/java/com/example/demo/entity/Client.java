package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    //@OneToOne(targetEntity = Chart.class, cascade = CascadeType.ALL)
    //@OneToOne
    //@OneToOne(targetEntity = Chart.class, cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    //@JoinColumn(name = "client_id")
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Chart chart;


}
