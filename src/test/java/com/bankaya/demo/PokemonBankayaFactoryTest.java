package com.bankaya.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.api.consumer.abilities.EndpointAbilityDto;
import com.bankaya.demo.dto.api.consumer.encounters.EncounterDetailDto;
import com.bankaya.demo.dto.api.consumer.encounters.ResponseAreaLocationEncountersDto;
import com.bankaya.demo.dto.api.consumer.encounters.VersionDetailLocationAreaDto;
import com.bankaya.demo.dto.api.consumer.items.ResponseHeldItemDto;
import com.bankaya.demo.dto.api.consumer.pokemon.AbilityDto;
import com.bankaya.demo.dto.api.consumer.pokemon.GlobalInformationHeldItemDto;
import com.bankaya.demo.dto.api.consumer.pokemon.NameAndUrlDto;
import com.bankaya.demo.dto.api.consumer.pokemon.ResponseGlobalInformationPokemonDto;
import com.bankaya.demo.dto.api.consumer.pokemon.VersionDetailItemDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;

public class PokemonBankayaFactoryTest {

    public static PokemonAbilityOutDto createPokemonAbilityOutDto() {

        final PokemonAbilityOutDto pokemonAbilityOutDto = new PokemonAbilityOutDto();

        final List<EndpointAbilityDto> listAbilities = new ArrayList<EndpointAbilityDto>();

        listAbilities.add(createEndpointAbilityDto("31", "lightning-rod"));

        pokemonAbilityOutDto.setPokemonAbilities(listAbilities);

        return pokemonAbilityOutDto;
    }

    public static EndpointAbilityDto createEndpointAbilityDto(final String id, final String name) {

        final EndpointAbilityDto endpointAbilityDto = new EndpointAbilityDto();

        endpointAbilityDto.setId(id);
        endpointAbilityDto.setName(name);
        final NameAndUrlDto generation = createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/");
        endpointAbilityDto.setGeneration(generation);

        return endpointAbilityDto;
    }

    public static ResponseGlobalInformationPokemonDto createResponseGlobalInformationPokemonDto(final String pokemon) {

        final ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto = new ResponseGlobalInformationPokemonDto();

        final List<AbilityDto> listAbilities = new ArrayList<AbilityDto>();

        listAbilities.add(createAbilityDto());
        responseGlobalInformationPokemonDto.setAbilities(listAbilities);
        responseGlobalInformationPokemonDto.setBase_experience("1");
        final List<GlobalInformationHeldItemDto> listaHelItems = new ArrayList<GlobalInformationHeldItemDto>();
        listaHelItems.add(createGlobalInformationHeldItemDto());
        responseGlobalInformationPokemonDto.setHeld_items(listaHelItems);
        responseGlobalInformationPokemonDto.setId("1");
        responseGlobalInformationPokemonDto.setLocation_area_encounters("location");
        responseGlobalInformationPokemonDto.setName(pokemon);

        return responseGlobalInformationPokemonDto;
    }

    private static GlobalInformationHeldItemDto createGlobalInformationHeldItemDto() {

        final GlobalInformationHeldItemDto globalInformationHeldItemDto = new GlobalInformationHeldItemDto();

        globalInformationHeldItemDto.setItem(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        final List<VersionDetailItemDto> listVersions = new ArrayList<VersionDetailItemDto>();

        listVersions.add(createVersionDetailItemDto());
        globalInformationHeldItemDto.setVersion_details(listVersions);

        return globalInformationHeldItemDto;
    }

    private static VersionDetailItemDto createVersionDetailItemDto() {

        final VersionDetailItemDto versionDetailItemDto = new VersionDetailItemDto();

        versionDetailItemDto.setRarity("rarity");
        versionDetailItemDto.setVersion(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        return versionDetailItemDto;
    }

    private static AbilityDto createAbilityDto() {

        final AbilityDto abilityDto = new AbilityDto();

        abilityDto.setAbility(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        return abilityDto;
    }

    private static NameAndUrlDto createNameAndUrlDto(final String name, final String uri) {

        final NameAndUrlDto nameAndUrlDto = new NameAndUrlDto();

        nameAndUrlDto.setName(name);
        nameAndUrlDto.setUrl(uri);

        return nameAndUrlDto;
    }

    public static ResponseAreaLocationEncountersDto[] createArrayResponseAreaLocationEncountersDto() {

        final ResponseAreaLocationEncountersDto[] arrayLocations = new ResponseAreaLocationEncountersDto[1];

        arrayLocations[0] = createResponseAreaLocationEncountersDto();

        return arrayLocations;
    }

    private static ResponseAreaLocationEncountersDto createResponseAreaLocationEncountersDto() {

        final ResponseAreaLocationEncountersDto responseAreaLocationEncountersDto = new ResponseAreaLocationEncountersDto();

        final List<VersionDetailLocationAreaDto> listVersionDetails = new ArrayList<VersionDetailLocationAreaDto>();

        responseAreaLocationEncountersDto
                .setLocation_area(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));
        listVersionDetails.add(createVersionDetailLocationAreaDto());
        responseAreaLocationEncountersDto.setVersion_details(listVersionDetails);

        return responseAreaLocationEncountersDto;
    }

    private static VersionDetailLocationAreaDto createVersionDetailLocationAreaDto() {

        final VersionDetailLocationAreaDto versionDetailLocationAreaDto = new VersionDetailLocationAreaDto();

        versionDetailLocationAreaDto.setMax_chance("1");
        versionDetailLocationAreaDto.setVersion(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        final List<EncounterDetailDto> listEncouterDetail = new ArrayList<EncounterDetailDto>();

        listEncouterDetail.add(createEncounterDetailDto());

        versionDetailLocationAreaDto.setEncounter_details(listEncouterDetail);

        return versionDetailLocationAreaDto;
    }

    private static EncounterDetailDto createEncounterDetailDto() {

        final List<NameAndUrlDto> listConditions = new ArrayList<NameAndUrlDto>();
        listConditions.add(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        final EncounterDetailDto encounterDetailDto = new EncounterDetailDto();

        encounterDetailDto.setChance("12");
        encounterDetailDto.setCondition_values(listConditions);
        encounterDetailDto.setMax_level("20");
        encounterDetailDto.setMethod(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));
        encounterDetailDto.setMin_level("1");

        return encounterDetailDto;
    }

    public static ResponseHeldItemDto createResponseHeldItemDto() {

        final List<NameAndUrlDto> listAtributes = new ArrayList<NameAndUrlDto>();
        listAtributes.add(createNameAndUrlDto("generation-iii", "https://pokeapi.co/api/v2/generation/3/"));

        final ResponseHeldItemDto responseHeldItemDto = new ResponseHeldItemDto();

        responseHeldItemDto.setName("name");
        responseHeldItemDto.setId("1");
        responseHeldItemDto.setFling_power("fling");
        responseHeldItemDto.setCost("cost");
        responseHeldItemDto.setAttributes(listAtributes);

        return responseHeldItemDto;
    }

    public static PokemonBaseExperienceOuDto createPokemonBaseExperienceOuDto() {

        final PokemonBaseExperienceOuDto pokemonBaseExperienceOuDto = new PokemonBaseExperienceOuDto();

        pokemonBaseExperienceOuDto.setBaseExperience("base");

        return pokemonBaseExperienceOuDto;
    }

    public static HelItemsOutDto createHelItemsOutDto() {

        final HelItemsOutDto helItemsOutDto = new HelItemsOutDto();

        final List<ResponseHeldItemDto> listHeldItems = new ArrayList<ResponseHeldItemDto>();
        listHeldItems.add(createResponseHeldItemDto());

        helItemsOutDto.setListHeldsItems(listHeldItems);

        return helItemsOutDto;
    }

    public static LocationEncountersOutDto createLocationEncountersOutDto() {

        final LocationEncountersOutDto locationEncountersOutDto = new LocationEncountersOutDto();

        locationEncountersOutDto.setListLocationAreasEncpunters(Arrays.asList(createArrayResponseAreaLocationEncountersDto()));

        return locationEncountersOutDto;
    }

}
