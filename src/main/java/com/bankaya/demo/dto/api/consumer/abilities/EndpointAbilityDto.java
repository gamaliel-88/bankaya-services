package com.bankaya.demo.dto.api.consumer.abilities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.pokemon.NameAndUrlDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "pokemonAbilities")
@XmlAccessorType(XmlAccessType.FIELD)
public class EndpointAbilityDto implements Serializable {

    private static final long serialVersionUID = -271793800764012663L;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "is_main")
    private Boolean is_main;

    @XmlElement(name = "generation")
    private NameAndUrlDto generation;

    @XmlElementWrapper(name = "listNames")
    @XmlElement(name = "names")
    private List<NameAbilityDto> names;

    @XmlElementWrapper(name = "list_effect_entries")
    @XmlElement(name = "effect_entries")
    private List<EffectEntriesDto> effect_entries;

}
