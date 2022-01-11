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

@XmlRootElement(name = "identifierPokemonOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentifierPokemonOutDto implements Serializable {

    private static final long serialVersionUID = -3042541430388916762L;

    @XmlElement(name = "id")
    private String id;
}
