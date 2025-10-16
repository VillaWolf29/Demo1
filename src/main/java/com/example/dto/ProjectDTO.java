package com.example.dto;

import com.example.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private int idProject;
    private String name;
    private String location;
    private Date startDate;
    private Date estimatedEndDate;
    private String status;
    private Customer customer;
}
