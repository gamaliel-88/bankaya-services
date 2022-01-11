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

@XmlRootElement(name = "namesAbility")
@XmlAccessorType(XmlAccessType.FIELD)
public class NameAbilityDto implements Serializable {

    private static final long serialVersionUID = -1331986174122911336L;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "language")
    private NameAndUrlDto language;

}
