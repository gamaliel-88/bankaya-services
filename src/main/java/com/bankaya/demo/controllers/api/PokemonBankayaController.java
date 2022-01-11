package com.bankaya.demo.controllers.api;

import com.bankaya.demo.dto.IdentifierPokemonOutDto;
import com.bankaya.demo.dto.NamePokemonOutDto;
import com.bankaya.demo.dto.abilities.PokemonAbilityOutDto;
import com.bankaya.demo.dto.base.experience.PokemonBaseExperienceOuDto;
import com.bankaya.demo.dto.helditem.HelItemsOutDto;
import com.bankaya.demo.dto.location.encounters.LocationEncountersOutDto;

public interface PokemonBankayaController {

    PokemonAbilityOutDto getAbilities(String pokemon);

    PokemonBaseExperienceOuDto getBaseExperience(final String pokemon);

    HelItemsOutDto getHeldItems(String pokemon);

    IdentifierPokemonOutDto getId(String pokemon);

    NamePokemonOutDto getName(String pokemon);

    LocationEncountersOutDto getLocationAreaEncounters(String pokemon);
}
