package com.bankaya.demo.dto.helditem;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bankaya.demo.dto.api.consumer.items.ResponseHeldItemDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode

@XmlRootElement(name = "helItemsOut")
@XmlAccessorType(XmlAccessType.FIELD)
public class HelItemsOutDto implements Serializable {

    private static final long serialVersionUID = -6254490788977264398L;

    @XmlElementWrapper(name = "listHeldsItems")
    @XmlElement(name = "heldsItems")
    private List<ResponseHeldItemDto> listHeldsItems;
}
