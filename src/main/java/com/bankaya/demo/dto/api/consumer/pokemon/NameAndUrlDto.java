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

@XmlRootElement(name = "urlCatalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class NameAndUrlDto implements Serializable {

    private static final long serialVersionUID = -4020241765626386794L;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "url")
    private String url;

}
