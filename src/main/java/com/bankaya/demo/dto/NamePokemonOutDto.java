package com.bankaya.demo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "namePokemonOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class NamePokemonOutDto implements Serializable {

    private static final long serialVersionUID = -5041327864144587169L;

    @XmlElement(name = "name")
    private String name;
}
