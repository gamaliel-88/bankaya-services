package com.bankaya.demo.dto.api.consumer.pokemon;

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

@XmlRootElement(name = "abilityDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilityDto implements Serializable {

    private static final long serialVersionUID = 2082189239037938785L;

    @XmlElement(name = "ability")
    private NameAndUrlDto ability;

}
