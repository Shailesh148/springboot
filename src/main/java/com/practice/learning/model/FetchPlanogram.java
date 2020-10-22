package com.practice.learning.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//@Entity
//@Table(name = "sf_location")
@Data
public class FetchPlanogram implements Serializable {

    @EmbeddedId
    private PrimaryKeyEmbedded primaryKeyEmbedded;

    private String status_code;

}
