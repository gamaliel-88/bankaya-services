package com.bankaya.demo.controllers.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankaya.demo.controllers.api.PokemonBankayaController;
import com.bankaya.demo.dto.IdentifierPokemonOutDto;
import com.bankaya.demo.dto.NamePokemonOutDto;
import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.bitacora.BitacoraPeticionDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;
import com.bankaya.demo.services.api.BitacoraServices;
import com.bankaya.demo.services.api.PokemonBankayaServices;

@RestController
@RequestMapping(path = "/api/v2/pokemon")
public class PokemonBankayaControllerImpl implements PokemonBankayaController {

    @Autowired
    private PokemonBankayaServices pokemonBankayaServices;

    @Autowired
    private BitacoraServices bitacoraServices;

    @Autowired
    private HttpServletRequest request;

    @Override
    @RequestMapping(value = "/ability/{pokemon}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody PokemonAbilityOutDto getAbilities(@PathVariable(name = "pokemon") final String pokemon) {

        final PokemonAbilityOutDto pokemonAbilityOutDto = pokemonBankayaServices.getAbilities(pokemon);

        insertarBitacoraSevicios();

        return pokemonAbilityOutDto;

    }

    @Override
    @RequestMapping(value = "/base_experience/{pokemon}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody PokemonBaseExperienceOuDto getBaseExperience(@PathVariable(name = "pokemon") final String pokemon) {

        final PokemonBaseExperienceOuDto pokemonBaseExperienceOuDto = pokemonBankayaServices.getBaseExperience(pokemon);

        insertarBitacoraSevicios();

        return pokemonBaseExperienceOuDto;

    }

    @Override
    @RequestMapping(value = "/held_items/{pokemon}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public HelItemsOutDto getHeldItems(@PathVariable(name = "pokemon") final String pokemon) {

        final HelItemsOutDto helItemsOutDto = pokemonBankayaServices.getHeldItems(pokemon);

        insertarBitacoraSevicios();

        return helItemsOutDto;

    }

    @Override
    @RequestMapping(value = "/id/{pokemon}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody IdentifierPokemonOutDto getId(@PathVariable(name = "pokemon") final String pokemon) {

        final IdentifierPokemonOutDto identifierPokemonOutDto = pokemonBankayaServices.getId(pokemon);

        insertarBitacoraSevicios();

        return identifierPokemonOutDto;
    }

    @Override
    @RequestMapping(value = "/name/{pokemon}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody NamePokemonOutDto getName(@PathVariable(name = "pokemon") final String pokemon) {

        final NamePokemonOutDto namePokemonOutDto = pokemonBankayaServices.getName(pokemon);

        insertarBitacoraSevicios();

        return namePokemonOutDto;
    }

    @Override
    @RequestMapping(value = "/location_area_encounters/{pokemon}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody LocationEncountersOutDto getLocationAreaEncounters(@PathVariable(name = "pokemon") final String pokemon) {

        final LocationEncountersOutDto locationAreaEncounters = pokemonBankayaServices.getLocationAreaEncounters(pokemon);

        insertarBitacoraSevicios();

        return locationAreaEncounters;
    }

    private void insertarBitacoraSevicios() {
        final BitacoraPeticionDto bitacoraPeticionDto = new BitacoraPeticionDto();

        bitacoraPeticionDto.setEndpoint(request.getRequestURI());
        bitacoraPeticionDto.setFecha_request(new Date());
        bitacoraPeticionDto.setIp_origen(request.getRemoteAddr());

        bitacoraServices.createRegister(bitacoraPeticionDto);
    }

}
