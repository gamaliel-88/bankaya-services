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

@XmlRootElement(name = "globalInformationHeldItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class GlobalInformationHeldItemDto implements Serializable {

    private static final long serialVersionUID = -6357624060144990084L;

    @XmlElement(name = "item")
    private NameAndUrlDto item;

    @XmlElementWrapper(name = "list_version_details")
    @XmlElement(name = "version_details")
    private List<VersionDetailItemDto> version_details;

}
