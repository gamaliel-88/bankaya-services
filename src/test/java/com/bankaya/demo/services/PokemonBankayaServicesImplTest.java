package com.bankaya.demo.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.bankaya.demo.PokemonBankayaFactoryTest;
import com.bankaya.demo.dto.IdentifierPokemonOutDto;
import com.bankaya.demo.dto.NamePokemonOutDto;
import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.api.consumer.abilities.EndpointAbilityDto;
import com.bankaya.demo.dto.api.consumer.encounters.ResponseAreaLocationEncountersDto;
import com.bankaya.demo.dto.api.consumer.items.ResponseHeldItemDto;
import com.bankaya.demo.dto.api.consumer.pokemon.ResponseGlobalInformationPokemonDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;
import com.bankaya.demo.services.api.PokemonBankayaServices;
import com.bankaya.demo.services.impl.PokemonBankayaServicesImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PokemonBankayaServicesImplTest {

    private static final String POKEMON = "PIKACHU";

    @InjectMocks
    private final PokemonBankayaServices pokemonBankayaServices = new PokemonBankayaServicesImpl();

    @Mock
    private RestTemplate restTemplate;

    private ResponseGlobalInformationPokemonDto responseGlobalInformationPokemonDto;

    @Before
    public void setUp() {

        responseGlobalInformationPokemonDto = PokemonBankayaFactoryTest.createResponseGlobalInformationPokemonDto(POKEMON);

        when(restTemplate.getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET))
                .thenReturn(responseGlobalInformationPokemonDto);
    }

    @Test
    public void abilities() {

        final EndpointAbilityDto endpointAbilityDtoMock = PokemonBankayaFactoryTest.createEndpointAbilityDto("31", "lightning-rod");

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET)).thenReturn(endpointAbilityDtoMock);

        final PokemonAbilityOutDto pokemonAbilityOutDto = pokemonBankayaServices.getAbilities(POKEMON);

        assertNotNull(pokemonAbilityOutDto);

        final List<EndpointAbilityDto> pokemonAbilities = pokemonAbilityOutDto.getPokemonAbilities();

        for (final EndpointAbilityDto endpointAbilityDto : pokemonAbilities) {

            assertEquals(endpointAbilityDto, endpointAbilityDtoMock);
        }

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET);

    }

    @Test(expected = HttpStatusCodeException.class)
    public void abilitiesBadRequest() {

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET)).thenThrow(new HttpStatusCodeException(HttpStatus.BAD_REQUEST) {

                    private static final long serialVersionUID = -1049528278213740615L;
                });

        pokemonBankayaServices.getAbilities(POKEMON);

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET);

    }

    @Test(expected = HttpStatusCodeException.class)
    public void abilitiesError500() {

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET)).thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR) {

                    private static final long serialVersionUID = -1049528278213740615L;
                });

        pokemonBankayaServices.getAbilities(POKEMON);

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getAbilities().get(0).getAbility().getUrl(),
                EndpointAbilityDto.class, HttpMethod.GET);
    }

    @Test
    public void getBaseExperience() {

        final PokemonBaseExperienceOuDto pokemonBaseExperienceOuDto = pokemonBankayaServices.getBaseExperience(POKEMON);

        assertNotNull(pokemonBaseExperienceOuDto);

        assertEquals(responseGlobalInformationPokemonDto.getBase_experience(), pokemonBaseExperienceOuDto.getBaseExperience());
        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);

    }

    @Test
    public void getId() {

        final IdentifierPokemonOutDto identifierPokemonOutDto = pokemonBankayaServices.getId(POKEMON);

        assertNotNull(identifierPokemonOutDto);

        assertEquals(responseGlobalInformationPokemonDto.getId(), identifierPokemonOutDto.getId());
        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);

    }

    @Test
    public void getLocationAreaEncounters() {

        final ResponseAreaLocationEncountersDto[] arrayLocations = PokemonBankayaFactoryTest.createArrayResponseAreaLocationEncountersDto();

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getLocation_area_encounters(),
                ResponseAreaLocationEncountersDto[].class, HttpMethod.GET)).thenReturn(arrayLocations);

        final LocationEncountersOutDto locationEncountersOutDto = pokemonBankayaServices.getLocationAreaEncounters(POKEMON);

        assertNotNull(locationEncountersOutDto);

        for (int i = 0; i < arrayLocations.length; i++) {

            final ResponseAreaLocationEncountersDto responseAreaLocationEncountersDto = locationEncountersOutDto
                    .getListLocationAreasEncpunters().get(i);

            final ResponseAreaLocationEncountersDto responseAreaLocationEncountersDtoMock = arrayLocations[i];

            assertEquals(responseAreaLocationEncountersDto, responseAreaLocationEncountersDtoMock);

        }

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getLocation_area_encounters(),
                ResponseAreaLocationEncountersDto[].class, HttpMethod.GET);

    }

    @Test
    public void getHeldItems() {

        final ResponseHeldItemDto responseHeldItemDto = PokemonBankayaFactoryTest.createResponseHeldItemDto();

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET)).thenReturn(responseHeldItemDto);

        final HelItemsOutDto helItemsOutDto = pokemonBankayaServices.getHeldItems(POKEMON);

        assertNotNull(helItemsOutDto);

        final List<ResponseHeldItemDto> listHeldsItems = helItemsOutDto.getListHeldsItems();

        for (final ResponseHeldItemDto responseHeldItemDto2 : listHeldsItems) {
            assertEquals(responseHeldItemDto2, responseHeldItemDto);
        }

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET);

    }

    @Test(expected = HttpStatusCodeException.class)
    public void getHeldItemsHttpBadrequest() {

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET)).thenThrow(new HttpStatusCodeException(HttpStatus.BAD_REQUEST) {

                    private static final long serialVersionUID = -1049528278213740615L;
                });

        pokemonBankayaServices.getHeldItems(POKEMON);

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET);

    }

    @Test(expected = HttpStatusCodeException.class)
    public void getHeldItemsHttp500() {

        when(restTemplate.getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET)).thenThrow(new HttpStatusCodeException(HttpStatus.INTERNAL_SERVER_ERROR) {

                    private static final long serialVersionUID = -1049528278213740615L;
                });

        pokemonBankayaServices.getHeldItems(POKEMON);

        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);
        verify(restTemplate).getForObject(responseGlobalInformationPokemonDto.getHeld_items().get(0).getItem().getUrl(),
                ResponseHeldItemDto.class, HttpMethod.GET);

    }

    @Test
    public void getName() {

        final NamePokemonOutDto namePokemonOutDto = pokemonBankayaServices.getName(POKEMON);

        assertNotNull(namePokemonOutDto);

        assertEquals(responseGlobalInformationPokemonDto.getName(), namePokemonOutDto.getName());
        verify(restTemplate).getForObject("null" + POKEMON, ResponseGlobalInformationPokemonDto.class, HttpMethod.GET);

    }

}
