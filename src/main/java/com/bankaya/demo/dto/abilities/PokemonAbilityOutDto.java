package com.bankaya.demo.dto.abilities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.abilities.EndpointAbilityDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "pokemonAbilityOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class PokemonAbilityOutDto implements Serializable {

    private static final long serialVersionUID = 5714351040803342555L;

    @XmlElementWrapper(name = "listPokemonAbilities")
    @XmlElement(name = "pokemonAbilities")
    private List<EndpointAbilityDto> pokemonAbilities;

}
