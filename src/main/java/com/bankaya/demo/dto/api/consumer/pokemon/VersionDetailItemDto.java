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

@XmlRootElement(name = "versionDetailItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class VersionDetailItemDto implements Serializable {

    private static final long serialVersionUID = 3730762928949709446L;

    @XmlElement(name = "rarity")
    private String rarity;

    @XmlElement(name = "version")
    private NameAndUrlDto version;

}
