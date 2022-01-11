package com.bankaya.demo.dto.api.consumer.abilities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.pokemon.NameAndUrlDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "effect_entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class EffectEntriesDto implements Serializable {

    private static final long serialVersionUID = -969323674868053146L;

    @XmlElement(name = "effect")
    private String effect;

    @XmlElement(name = "short_effect")
    private String short_effect;

    @XmlElement(name = "language")
    private NameAndUrlDto language;

}
