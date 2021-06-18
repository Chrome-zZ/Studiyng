package org.example.clickcounter.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Button {

    @Id
    private int id;
    private int count;
}
