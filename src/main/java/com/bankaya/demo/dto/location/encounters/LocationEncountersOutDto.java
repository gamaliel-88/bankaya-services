package com.bankaya.demo.dto.location.encounters;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.encounters.ResponseAreaLocationEncountersDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "locationEncountersOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationEncountersOutDto implements Serializable {

    private static final long serialVersionUID = -2680282059390378478L;

    @XmlElementWrapper(name = "listLocationAreasEncpunters")
    @XmlElement(name = "responseAreaLocationEncounters")
    private List<ResponseAreaLocationEncountersDto> listLocationAreasEncpunters;
}
