package com.bankaya.demo.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankaya.demo.PokemonBankayaFactoryTest;
import com.bankaya.demo.controllers.api.PokemonBankayaController;
import com.bankaya.demo.controllers.impl.PokemonBankayaControllerImpl;
import com.bankaya.demo.dto.IdentifierPokemonOutDto;
import com.bankaya.demo.dto.NamePokemonOutDto;
import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.api.consumer.abilities.EndpointAbilityDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;
import com.bankaya.demo.services.api.BitacoraServices;
import com.bankaya.demo.services.api.PokemonBankayaServices;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PokemonBankayaControllerImplTest {

    private static final String POKEMON = "Pikachu";

    @InjectMocks
    private final PokemonBankayaController pokemonBankayaController = new PokemonBankayaControllerImpl();

    @Mock
    private PokemonBankayaServices pokemonBankayaServices;

    @Mock
    private BitacoraServices bitacoraServices;

    @Mock
    private HttpServletRequest request;

    @Test
    public void testAbility() {

        final PokemonAbilityOutDto pokemonAbilityOutDto = PokemonBankayaFactoryTest.createPokemonAbilityOutDto();

        when(pokemonBankayaServices.getAbilities(POKEMON)).thenReturn(pokemonAbilityOutDto);

        final PokemonAbilityOutDto abilityOutDtoController = pokemonBankayaController.getAbilities(POKEMON);

        assertNotNull(abilityOutDtoController);

        final List<EndpointAbilityDto> pokemonAbilities = abilityOutDtoController.getPokemonAbilities();

        assertNotNull(pokemonAbilities);

        for (final EndpointAbilityDto endpointAbilityDto : pokemonAbilities) {
            assertEquals(endpointAbilityDto.getId(), "31");
            assertEquals(endpointAbilityDto.getName(), "lightning-rod");
        }

        assertEquals(pokemonAbilityOutDto, abilityOutDtoController);

        verify(pokemonBankayaServices, times(1)).getAbilities(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();

    }

    @Test
    public void getBaseExperience() {

        final PokemonBaseExperienceOuDto pokemonBaseExperienceMock = PokemonBankayaFactoryTest.createPokemonBaseExperienceOuDto();

        when(pokemonBankayaServices.getBaseExperience(POKEMON)).thenReturn(pokemonBaseExperienceMock);

        final PokemonBaseExperienceOuDto pokemonBaseExperienceOuDto = pokemonBankayaController.getBaseExperience(POKEMON);

        assertEquals(pokemonBaseExperienceMock, pokemonBaseExperienceOuDto);

        verify(pokemonBankayaServices, times(1)).getBaseExperience(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();
    }

    @Test
    public void getHeldItems() {

        final HelItemsOutDto helItemsMock = PokemonBankayaFactoryTest.createHelItemsOutDto();

        when(pokemonBankayaServices.getHeldItems(POKEMON)).thenReturn(helItemsMock);

        final HelItemsOutDto helItemsOutDto = pokemonBankayaController.getHeldItems(POKEMON);

        assertEquals(helItemsMock, helItemsOutDto);

        verify(pokemonBankayaServices, times(1)).getHeldItems(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();

    }

    @Test
    public void getId() {

        final IdentifierPokemonOutDto identifierPokemonMock = new IdentifierPokemonOutDto();
        identifierPokemonMock.setId("2");

        when(pokemonBankayaServices.getId(POKEMON)).thenReturn(identifierPokemonMock);

        final IdentifierPokemonOutDto identifierPokemonOutDto = pokemonBankayaController.getId(POKEMON);

        assertEquals(identifierPokemonMock, identifierPokemonOutDto);

        verify(pokemonBankayaServices, times(1)).getId(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();
    }

    @Test
    public void getLocationAreaEncounters() {

        final LocationEncountersOutDto locationEncountersMock = PokemonBankayaFactoryTest.createLocationEncountersOutDto();

        when(pokemonBankayaServices.getLocationAreaEncounters(POKEMON)).thenReturn(locationEncountersMock);

        final LocationEncountersOutDto locationEncountersOutDto = pokemonBankayaController.getLocationAreaEncounters(POKEMON);

        assertEquals(locationEncountersMock, locationEncountersOutDto);

        verify(pokemonBankayaServices, times(1)).getLocationAreaEncounters(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();
    }

    @Test
    public void getName() {

        final NamePokemonOutDto namePokemonMock = new NamePokemonOutDto();
        namePokemonMock.setName(POKEMON);

        when(pokemonBankayaServices.getName(POKEMON)).thenReturn(namePokemonMock);

        final NamePokemonOutDto namePokemonOutDto = pokemonBankayaController.getName(POKEMON);

        assertEquals(namePokemonMock, namePokemonOutDto);

        verify(pokemonBankayaServices, times(1)).getName(POKEMON);
        verify(bitacoraServices, times(1)).createRegister(org.mockito.ArgumentMatchers.any());
        verify(request).getRemoteAddr();

    }

}
