package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor con todos los atributos
@Data //Genera getters y setters
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Supplier {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupplier;

    @Column(nullable = false, length = 70)
    private String name;

    @Column(nullable = false, length = 30)
    private String ruc;

    @Column(length = 150)
    private String address;

    @Column(length = 30)
    private String phone;

    @Column( length = 70)
    private String email;

}
