package com.bankaya.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.bankaya.demo.dto.IdentifierPokemonOutDto;
import com.bankaya.demo.dto.NamePokemonOutDto;
import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.api.consumer.abilities.EndpointAbilityDto;
import com.bankaya.demo.dto.api.consumer.encounters.ResponseAreaLocationEncountersDto;
import com.bankaya.demo.dto.api.consumer.items.ResponseHeldItemDto;
import com.bankaya.demo.dto.api.consumer.pokemon.AbilityDto;
import com.bankaya.demo.dto.api.consumer.pokemon.GlobalInformationHeldItemDto;
import com.bankaya.demo.dto.api.consumer.pokemon.ResponseGlobalInformationPokemonDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;
import com.bankaya.demo.services.api.PokemonBankayaServices;

@Service
public class PokemonBankayaServicesImpl implements PokemonBankayaServices {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bankaya.pokemon.general.information.url}")
    private String pokemoGeneralInformationUrl;

    @Override
    public PokemonAbilityOutDto getAbilities(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final List<EndpointAbilityDto> listPokemoAbilities = getListPokemonAbilities(responseGlobalInformationPokemonDto.getAbilities());

        final PokemonAbilityOutDto pokemonAbilityOutDto = new PokemonAbilityOutDto();
        pokemonAbilityOutDto.setPokemonAbilities(listPokemoAbilities);

        return pokemonAbilityOutDto;

    }

    @Override
    public PokemonBaseExperienceOuDto getBaseExperience(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final PokemonBaseExperienceOuDto pokemonBaseExperienceOuDto = new PokemonBaseExperienceOuDto();

        pokemonBaseExperienceOuDto.setBaseExperience(responseGlobalInformationPokemonDto.getBase_experience());

        return pokemonBaseExperienceOuDto;

    }

    @Override
    public HelItemsOutDto getHeldItems(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final List<ResponseHeldItemDto> listHeldsItems = getListHeldItems(responseGlobalInformationPokemonDto.getHeld_items());

        final HelItemsOutDto helItemsOutDto = new HelItemsOutDto();
        helItemsOutDto.setListHeldsItems(listHeldsItems);

        return helItemsOutDto;

    }

    @Override
    public IdentifierPokemonOutDto getId(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final IdentifierPokemonOutDto identifierPokemonOutDto = new IdentifierPokemonOutDto();

        identifierPokemonOutDto.setId(responseGlobalInformationPokemonDto.getId());

        return identifierPokemonOutDto;
    }

    @Override
    public NamePokemonOutDto getName(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final NamePokemonOutDto namePokemonOutDto = new NamePokemonOutDto();

        namePokemonOutDto.setName(responseGlobalInformationPokemonDto.getName());

        return namePokemonOutDto;
    }

    @Override
    public LocationEncountersOutDto getLocationAreaEncounters(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = getGlobalInformationPokemon(pokemon);

        final String location_area_encounters = responseGlobalInformationPokemonDto.getLocation_area_encounters();

        List<ResponseAreaLocationEncountersDto> listLocationAreasEncpunters = new ArrayList<ResponseAreaLocationEncountersDto>();

        if (StringUtils.isNotBlank(location_area_encounters)) {

            final ResponseAreaLocationEncountersDto[] arrayLocationAreasEncpunters = restTemplate.getForObject(location_area_encounters,
                    ResponseAreaLocationEncountersDto[].class, HttpMethod.GET);

            if (arrayLocationAreasEncpunters != null) {

                listLocationAreasEncpunters = Arrays.asList(arrayLocationAreasEncpunters);
            }

        }

        final LocationEncountersOutDto locationEncountersOutDto = new LocationEncountersOutDto();

        locationEncountersOutDto.setListLocationAreasEncpunters(listLocationAreasEncpunters);

        return locationEncountersOutDto;
    }

    private ResponseGlobalInformationPokemonDto getGlobalInformationPokemon(final String pokemon) {

        final ResponseGlobalInformationPokemonDto basGlobalInformationPokemonDto = restTemplate
                .getForObject(pokemoGeneralInformationUrl + pokemon, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);

        return basGlobalInformationPokemonDto;
    }

    private List<EndpointAbilityDto> getListPokemonAbilities(final List<AbilityDto> abilities) {

        final List<EndpointAbilityDto> listPokemoAbilities = new ArrayList<EndpointAbilityDto>();

        if (!CollectionUtils.isEmpty(abilities)) {

            for (final AbilityDto abilityDto : abilities) {

                if (abilityDto.getAbility() != null && StringUtils.isNotBlank(abilityDto.getAbility().getUrl())) {

                    final EndpointAbilityDto endpointAbilityDto = restTemplate.getForObject(abilityDto.getAbility().getUrl(),
                            EndpointAbilityDto.class, HttpMethod.GET);

                    listPokemoAbilities.add(endpointAbilityDto);
                }
            }
        }

        return listPokemoAbilities;
    }

    private List<ResponseHeldItemDto> getListHeldItems(final List<GlobalInformationHeldItemDto> held_items) {

        final List<ResponseHeldItemDto> listHeldsItems = new ArrayList<ResponseHeldItemDto>();

        if (!CollectionUtils.isEmpty(held_items)) {

            for (final GlobalInformationHeldItemDto globalInformationHeldItemDto : held_items) {

                final ResponseHeldItemDto responseHeldItemDto = restTemplate.getForObject(globalInformationHeldItemDto.getItem().getUrl(),
                        ResponseHeldItemDto.class, HttpMethod.GET);

                listHeldsItems.add(responseHeldItemDto);

            }

        }

        return listHeldsItems;
    }
}
