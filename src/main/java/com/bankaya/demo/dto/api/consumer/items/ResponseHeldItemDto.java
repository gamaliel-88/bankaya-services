package com.bankaya.demo.dto.api.consumer.items;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.abilities.EffectEntriesDto;
import com.bankaya.demo.dto.api.consumer.pokemon.NameAndUrlDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "heldsItems")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseHeldItemDto implements Serializable {

    private static final long serialVersionUID = 2445098665822826477L;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "cost")
    private String cost;

    @XmlElement(name = "fling_power")
    private String fling_power;

    @XmlElement(name = "fling_effects")
    private NameAndUrlDto fling_effects;

    @XmlElementWrapper(name = "list_attributes")
    @XmlElement(name = "attributes")
    private List<NameAndUrlDto> attributes;

    @XmlElement(name = "category")
    private NameAndUrlDto category;

    @XmlElementWrapper(name = "list_effect_entries")
    @XmlElement(name = "effect_entries")
    private List<EffectEntriesDto> effect_entries;

}
