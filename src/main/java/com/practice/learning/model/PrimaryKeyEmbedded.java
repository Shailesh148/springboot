package com.practice.learning.model;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PrimaryKeyEmbedded implements Serializable {
    private String floor;
    private String block;
    private String aisle;
    private Integer section;
    private Integer location_id;
}
