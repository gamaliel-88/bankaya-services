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

@XmlRootElement(name = "encounterDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class EncounterDetailDto implements Serializable {

    private static final long serialVersionUID = 603287014411941747L;

    @XmlElement(name = "chance")
    private String chance;

    @XmlElement(name = "max_level")
    private String max_level;

    @XmlElement(name = "min_level")
    private String min_level;

    @XmlElement(name = "method")
    private NameAndUrlDto method;

    @XmlElementWrapper(name = "list_condition_values")
    @XmlElement(name = "condition_values")
    private List<NameAndUrlDto> condition_values;

}
