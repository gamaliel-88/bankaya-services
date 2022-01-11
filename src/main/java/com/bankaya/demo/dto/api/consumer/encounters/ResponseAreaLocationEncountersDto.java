package com.bankaya.demo.dto.api.consumer.encounters;

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

@XmlRootElement(name = "responseAreaLocationEncounters")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseAreaLocationEncountersDto implements Serializable {

    private static final long serialVersionUID = -7895039785877695860L;

    @XmlElement(name = "location_area")
    private NameAndUrlDto location_area;

    @XmlElementWrapper(name = "list_version_details")
    @XmlElement(name = "version_details")
    private List<VersionDetailLocationAreaDto> version_details;
}
