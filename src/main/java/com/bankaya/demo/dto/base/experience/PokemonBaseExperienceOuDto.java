package com.bankaya.demo.dto.base.experience;

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

@XmlRootElement(name = "pokemonBaseExperienceOu")
@XmlAccessorType(XmlAccessType.FIELD)
public class PokemonBaseExperienceOuDto implements Serializable {

    private static final long serialVersionUID = 4380193976197312809L;

    @XmlElement(name = "baseExperience")
    private String baseExperience;
}
