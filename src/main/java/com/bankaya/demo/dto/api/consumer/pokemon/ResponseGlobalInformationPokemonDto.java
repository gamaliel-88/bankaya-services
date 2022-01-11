package com.bankaya.demo.dto.api.consumer.pokemon;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "globalInformationPokemonOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGlobalInformationPokemonDto implements Serializable {

    private static final long serialVersionUID = 2630446531749722133L;

    @XmlElementWrapper(name = "list_abilities")
    @XmlElement(name = "abilities")
    private List<AbilityDto> abilities;

    @XmlElementWrapper(name = "list_base_experience")
    @XmlElement(name = "base_experience")
    private String base_experience;

    @XmlElementWrapper(name = "list_held_items")
    @XmlElement(name = "held_items")
    private List<GlobalInformationHeldItemDto> held_items;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "location_area_encounters")
    private String location_area_encounters;

    @XmlElement(name = "name")
    private String name;

}
