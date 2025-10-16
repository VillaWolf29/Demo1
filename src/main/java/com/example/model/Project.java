package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor con todos los atributos
@Data //Genera getters y setters
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int idProject;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false,length = 200)
    private String location;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date estimateEndDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne //FK (Foreign Key)
    @JoinColumn(name = "id_customer", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CUSTOMER")) //Nombre del campo en la tabla (col
    private Customer customer;

}
