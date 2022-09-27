package com.springpostgreSQLexample.springpostgreSQLexample.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name = "adress_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "adress_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500 , name = "adress")
    private String adress;

    @Enumerated
    private AdressType adressType;

    @Column(name = "isAdressActive")
    private boolean isAdressActive;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi user;
    public enum AdressType {
        HOME, WORK, OTHER
    }
}
