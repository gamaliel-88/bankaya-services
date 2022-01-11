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

@XmlRootElement(name = "versionDetailLocationArea")
@XmlAccessorType(XmlAccessType.FIELD)
public class VersionDetailLocationAreaDto implements Serializable {

    private static final long serialVersionUID = -718371855155682069L;

    @XmlElementWrapper(name = "list_encounter_details")
    @XmlElement(name = "encounter_details")
    private List<EncounterDetailDto> encounter_details;

    @XmlElement(name = "max_chance")
    private String max_chance;

    @XmlElement(name = "version")
    private NameAndUrlDto version;
}
