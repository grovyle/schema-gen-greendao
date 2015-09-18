package com.company.professor;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.company.professor.TypeEfficacy;
import com.company.professor.ConquestPokemonStats;
import com.company.professor.AbilityNames;
import com.company.professor.AbilityFlavorText;
import com.company.professor.AbilityProse;
import com.company.professor.AbilityChangelog;
import com.company.professor.PokemonAbilities;
import com.company.professor.ConquestPokemonAbilities;
import com.company.professor.Abilities;
import com.company.professor.MoveFlagProse;
import com.company.professor.ConquestPokemonEvolution;
import com.company.professor.ConquestMoveData;
import com.company.professor.ConquestMoveEffectProse;
import com.company.professor.ConquestMoveEffects;
import com.company.professor.PokemonDexNumbers;
import com.company.professor.PokedexVersionGroups;
import com.company.professor.PokedexProse;
import com.company.professor.Pokedexes;
import com.company.professor.LocationAreaProse;
import com.company.professor.EncounterConditionValueMap;
import com.company.professor.Encounters;
import com.company.professor.LocationAreaEncounterRates;
import com.company.professor.LocationAreas;
import com.company.professor.VersionGroupPokemonMoveMethods;
import com.company.professor.ConquestStatNames;
import com.company.professor.MoveMetaCategoryProse;
import com.company.professor.MoveMeta;
import com.company.professor.MoveMetaCategories;
import com.company.professor.PokemonSpeciesFlavorSummaries;
import com.company.professor.PokemonEggGroups;
import com.company.professor.PokemonEvolution;
import com.company.professor.ConquestPokemonMoves;
import com.company.professor.ConquestTransformationPokemon;
import com.company.professor.PokemonMoves;
import com.company.professor.PokemonGameIndices;
import com.company.professor.PokemonStats;
import com.company.professor.Pokemon;
import com.company.professor.PalPark;
import com.company.professor.PokemonSpeciesProse;
import com.company.professor.PokemonSpeciesFlavorText;
import com.company.professor.ConquestMaxLinks;
import com.company.professor.PokemonSpeciesNames;
import com.company.professor.PokemonSpecies;
import com.company.professor.PokemonShapeProse;
import com.company.professor.PokemonShapes;
import com.company.professor.ConquestTransformationWarriors;
import com.company.professor.PokemonItems;
import com.company.professor.MoveFlavorSummaries;
import com.company.professor.AbilityChangelogProse;
import com.company.professor.StatNames;
import com.company.professor.MoveBattleStyleProse;
import com.company.professor.ContestEffectProse;
import com.company.professor.MoveDamageClassProse;
import com.company.professor.RegionNames;
import com.company.professor.GrowthRateProse;
import com.company.professor.ItemCategoryProse;
import com.company.professor.MoveNames;
import com.company.professor.EncounterConditionValueProse;
import com.company.professor.ContestTypeNames;
import com.company.professor.PokemonMoveMethodProse;
import com.company.professor.ConquestEpisodeNames;
import com.company.professor.ConquestWarriorNames;
import com.company.professor.PalParkAreaNames;
import com.company.professor.ItemNames;
import com.company.professor.EncounterConditionProse;
import com.company.professor.SuperContestEffectProse;
import com.company.professor.ItemFlavorSummaries;
import com.company.professor.ConquestWarriorSkillNames;
import com.company.professor.ConquestKingdomNames;
import com.company.professor.GenerationNames;
import com.company.professor.MoveFlavorText;
import com.company.professor.VersionNames;
import com.company.professor.ItemFlavorText;
import com.company.professor.MoveMetaAilmentNames;
import com.company.professor.PokemonHabitatNames;
import com.company.professor.MoveTargetProse;
import com.company.professor.ConquestMoveDisplacementProse;
import com.company.professor.StatHintNames;
import com.company.professor.ItemFlagProse;
import com.company.professor.LocationNames;
import com.company.professor.EvolutionTriggerProse;
import com.company.professor.BerryFirmnessNames;
import com.company.professor.ItemPocketNames;
import com.company.professor.ItemProse;
import com.company.professor.ConquestWarriorStatNames;
import com.company.professor.EggGroupProse;
import com.company.professor.MoveEffectProse;
import com.company.professor.ConquestMoveRangeProse;
import com.company.professor.NatureNames;
import com.company.professor.ItemFlingEffectProse;
import com.company.professor.EncounterMethodProse;
import com.company.professor.TypeNames;
import com.company.professor.PokemonColorNames;
import com.company.professor.PokemonFormNames;
import com.company.professor.LanguageNames;
import com.company.professor.PokeathlonStatNames;
import com.company.professor.MoveEffectChangelogProse;
import com.company.professor.Languages;
import com.company.professor.PokemonFormGenerations;
import com.company.professor.EncounterConditionValues;
import com.company.professor.ConquestMoveDisplacements;
import com.company.professor.ConquestWarriorRankStatMap;
import com.company.professor.ConquestWarriorTransformation;
import com.company.professor.ConquestWarriorRanks;
import com.company.professor.MoveFlagMap;
import com.company.professor.LocationGameIndices;
import com.company.professor.ItemGameIndices;
import com.company.professor.Moves;
import com.company.professor.ConquestKingdoms;
import com.company.professor.ConquestWarriorSpecialties;
import com.company.professor.TypeGameIndices;
import com.company.professor.Berries;
import com.company.professor.Types;
import com.company.professor.VersionGroupRegions;
import com.company.professor.VersionGroups;
import com.company.professor.Generations;
import com.company.professor.PokemonFormPokeathlonStats;
import com.company.professor.PokemonForms;
import com.company.professor.BerryFirmness;
import com.company.professor.PokemonMoveMethods;
import com.company.professor.MoveMetaStatChanges;
import com.company.professor.ConquestEpisodeWarriors;
import com.company.professor.ConquestEpisodes;
import com.company.professor.NatureBattleStylePreferences;
import com.company.professor.MoveBattleStyles;
import com.company.professor.Machines;
import com.company.professor.EggGroups;
import com.company.professor.StatHints;
import com.company.professor.Natures;
import com.company.professor.Stats;
import com.company.professor.EncounterConditions;
import com.company.professor.MoveChangelog;
import com.company.professor.ConquestWarriorSkills;
import com.company.professor.ItemFlagMap;
import com.company.professor.ItemFlags;
import com.company.professor.ItemCategories;
import com.company.professor.ItemPockets;
import com.company.professor.BerryFlavors;
import com.company.professor.ContestTypes;
import com.company.professor.SuperContestCombos;
import com.company.professor.EncounterSlots;
import com.company.professor.ConquestWarriors;
import com.company.professor.ConquestWarriorArchetypes;
import com.company.professor.EvolutionTriggers;
import com.company.professor.MoveEffectChangelog;
import com.company.professor.MoveEffects;
import com.company.professor.EvolutionChains;
import com.company.professor.Items;
import com.company.professor.Experience;
import com.company.professor.NaturePokeathlonStats;
import com.company.professor.PokemonTypes;
import com.company.professor.ConquestWarriorStats;
import com.company.professor.EncounterMethods;
import com.company.professor.PokemonColors;
import com.company.professor.MoveDamageClasses;
import com.company.professor.PokeathlonStats;
import com.company.professor.ContestCombos;
import com.company.professor.PalParkAreas;
import com.company.professor.MoveTargets;
import com.company.professor.GrowthRates;
import com.company.professor.ContestEffects;
import com.company.professor.MoveMetaAilments;
import com.company.professor.Versions;
import com.company.professor.MoveFlags;
import com.company.professor.Genders;
import com.company.professor.PokemonHabitats;
import com.company.professor.Locations;
import com.company.professor.Regions;
import com.company.professor.SuperContestEffects;
import com.company.professor.ConquestMoveRanges;
import com.company.professor.ConquestStats;
import com.company.professor.ItemFlingEffects;

import com.company.professor.TypeEfficacyDao;
import com.company.professor.ConquestPokemonStatsDao;
import com.company.professor.AbilityNamesDao;
import com.company.professor.AbilityFlavorTextDao;
import com.company.professor.AbilityProseDao;
import com.company.professor.AbilityChangelogDao;
import com.company.professor.PokemonAbilitiesDao;
import com.company.professor.ConquestPokemonAbilitiesDao;
import com.company.professor.AbilitiesDao;
import com.company.professor.MoveFlagProseDao;
import com.company.professor.ConquestPokemonEvolutionDao;
import com.company.professor.ConquestMoveDataDao;
import com.company.professor.ConquestMoveEffectProseDao;
import com.company.professor.ConquestMoveEffectsDao;
import com.company.professor.PokemonDexNumbersDao;
import com.company.professor.PokedexVersionGroupsDao;
import com.company.professor.PokedexProseDao;
import com.company.professor.PokedexesDao;
import com.company.professor.LocationAreaProseDao;
import com.company.professor.EncounterConditionValueMapDao;
import com.company.professor.EncountersDao;
import com.company.professor.LocationAreaEncounterRatesDao;
import com.company.professor.LocationAreasDao;
import com.company.professor.VersionGroupPokemonMoveMethodsDao;
import com.company.professor.ConquestStatNamesDao;
import com.company.professor.MoveMetaCategoryProseDao;
import com.company.professor.MoveMetaDao;
import com.company.professor.MoveMetaCategoriesDao;
import com.company.professor.PokemonSpeciesFlavorSummariesDao;
import com.company.professor.PokemonEggGroupsDao;
import com.company.professor.PokemonEvolutionDao;
import com.company.professor.ConquestPokemonMovesDao;
import com.company.professor.ConquestTransformationPokemonDao;
import com.company.professor.PokemonMovesDao;
import com.company.professor.PokemonGameIndicesDao;
import com.company.professor.PokemonStatsDao;
import com.company.professor.PokemonDao;
import com.company.professor.PalParkDao;
import com.company.professor.PokemonSpeciesProseDao;
import com.company.professor.PokemonSpeciesFlavorTextDao;
import com.company.professor.ConquestMaxLinksDao;
import com.company.professor.PokemonSpeciesNamesDao;
import com.company.professor.PokemonSpeciesDao;
import com.company.professor.PokemonShapeProseDao;
import com.company.professor.PokemonShapesDao;
import com.company.professor.ConquestTransformationWarriorsDao;
import com.company.professor.PokemonItemsDao;
import com.company.professor.MoveFlavorSummariesDao;
import com.company.professor.AbilityChangelogProseDao;
import com.company.professor.StatNamesDao;
import com.company.professor.MoveBattleStyleProseDao;
import com.company.professor.ContestEffectProseDao;
import com.company.professor.MoveDamageClassProseDao;
import com.company.professor.RegionNamesDao;
import com.company.professor.GrowthRateProseDao;
import com.company.professor.ItemCategoryProseDao;
import com.company.professor.MoveNamesDao;
import com.company.professor.EncounterConditionValueProseDao;
import com.company.professor.ContestTypeNamesDao;
import com.company.professor.PokemonMoveMethodProseDao;
import com.company.professor.ConquestEpisodeNamesDao;
import com.company.professor.ConquestWarriorNamesDao;
import com.company.professor.PalParkAreaNamesDao;
import com.company.professor.ItemNamesDao;
import com.company.professor.EncounterConditionProseDao;
import com.company.professor.SuperContestEffectProseDao;
import com.company.professor.ItemFlavorSummariesDao;
import com.company.professor.ConquestWarriorSkillNamesDao;
import com.company.professor.ConquestKingdomNamesDao;
import com.company.professor.GenerationNamesDao;
import com.company.professor.MoveFlavorTextDao;
import com.company.professor.VersionNamesDao;
import com.company.professor.ItemFlavorTextDao;
import com.company.professor.MoveMetaAilmentNamesDao;
import com.company.professor.PokemonHabitatNamesDao;
import com.company.professor.MoveTargetProseDao;
import com.company.professor.ConquestMoveDisplacementProseDao;
import com.company.professor.StatHintNamesDao;
import com.company.professor.ItemFlagProseDao;
import com.company.professor.LocationNamesDao;
import com.company.professor.EvolutionTriggerProseDao;
import com.company.professor.BerryFirmnessNamesDao;
import com.company.professor.ItemPocketNamesDao;
import com.company.professor.ItemProseDao;
import com.company.professor.ConquestWarriorStatNamesDao;
import com.company.professor.EggGroupProseDao;
import com.company.professor.MoveEffectProseDao;
import com.company.professor.ConquestMoveRangeProseDao;
import com.company.professor.NatureNamesDao;
import com.company.professor.ItemFlingEffectProseDao;
import com.company.professor.EncounterMethodProseDao;
import com.company.professor.TypeNamesDao;
import com.company.professor.PokemonColorNamesDao;
import com.company.professor.PokemonFormNamesDao;
import com.company.professor.LanguageNamesDao;
import com.company.professor.PokeathlonStatNamesDao;
import com.company.professor.MoveEffectChangelogProseDao;
import com.company.professor.LanguagesDao;
import com.company.professor.PokemonFormGenerationsDao;
import com.company.professor.EncounterConditionValuesDao;
import com.company.professor.ConquestMoveDisplacementsDao;
import com.company.professor.ConquestWarriorRankStatMapDao;
import com.company.professor.ConquestWarriorTransformationDao;
import com.company.professor.ConquestWarriorRanksDao;
import com.company.professor.MoveFlagMapDao;
import com.company.professor.LocationGameIndicesDao;
import com.company.professor.ItemGameIndicesDao;
import com.company.professor.MovesDao;
import com.company.professor.ConquestKingdomsDao;
import com.company.professor.ConquestWarriorSpecialtiesDao;
import com.company.professor.TypeGameIndicesDao;
import com.company.professor.BerriesDao;
import com.company.professor.TypesDao;
import com.company.professor.VersionGroupRegionsDao;
import com.company.professor.VersionGroupsDao;
import com.company.professor.GenerationsDao;
import com.company.professor.PokemonFormPokeathlonStatsDao;
import com.company.professor.PokemonFormsDao;
import com.company.professor.BerryFirmnessDao;
import com.company.professor.PokemonMoveMethodsDao;
import com.company.professor.MoveMetaStatChangesDao;
import com.company.professor.ConquestEpisodeWarriorsDao;
import com.company.professor.ConquestEpisodesDao;
import com.company.professor.NatureBattleStylePreferencesDao;
import com.company.professor.MoveBattleStylesDao;
import com.company.professor.MachinesDao;
import com.company.professor.EggGroupsDao;
import com.company.professor.StatHintsDao;
import com.company.professor.NaturesDao;
import com.company.professor.StatsDao;
import com.company.professor.EncounterConditionsDao;
import com.company.professor.MoveChangelogDao;
import com.company.professor.ConquestWarriorSkillsDao;
import com.company.professor.ItemFlagMapDao;
import com.company.professor.ItemFlagsDao;
import com.company.professor.ItemCategoriesDao;
import com.company.professor.ItemPocketsDao;
import com.company.professor.BerryFlavorsDao;
import com.company.professor.ContestTypesDao;
import com.company.professor.SuperContestCombosDao;
import com.company.professor.EncounterSlotsDao;
import com.company.professor.ConquestWarriorsDao;
import com.company.professor.ConquestWarriorArchetypesDao;
import com.company.professor.EvolutionTriggersDao;
import com.company.professor.MoveEffectChangelogDao;
import com.company.professor.MoveEffectsDao;
import com.company.professor.EvolutionChainsDao;
import com.company.professor.ItemsDao;
import com.company.professor.ExperienceDao;
import com.company.professor.NaturePokeathlonStatsDao;
import com.company.professor.PokemonTypesDao;
import com.company.professor.ConquestWarriorStatsDao;
import com.company.professor.EncounterMethodsDao;
import com.company.professor.PokemonColorsDao;
import com.company.professor.MoveDamageClassesDao;
import com.company.professor.PokeathlonStatsDao;
import com.company.professor.ContestCombosDao;
import com.company.professor.PalParkAreasDao;
import com.company.professor.MoveTargetsDao;
import com.company.professor.GrowthRatesDao;
import com.company.professor.ContestEffectsDao;
import com.company.professor.MoveMetaAilmentsDao;
import com.company.professor.VersionsDao;
import com.company.professor.MoveFlagsDao;
import com.company.professor.GendersDao;
import com.company.professor.PokemonHabitatsDao;
import com.company.professor.LocationsDao;
import com.company.professor.RegionsDao;
import com.company.professor.SuperContestEffectsDao;
import com.company.professor.ConquestMoveRangesDao;
import com.company.professor.ConquestStatsDao;
import com.company.professor.ItemFlingEffectsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig typeEfficacyDaoConfig;
    private final DaoConfig conquestPokemonStatsDaoConfig;
    private final DaoConfig abilityNamesDaoConfig;
    private final DaoConfig abilityFlavorTextDaoConfig;
    private final DaoConfig abilityProseDaoConfig;
    private final DaoConfig abilityChangelogDaoConfig;
    private final DaoConfig pokemonAbilitiesDaoConfig;
    private final DaoConfig conquestPokemonAbilitiesDaoConfig;
    private final DaoConfig abilitiesDaoConfig;
    private final DaoConfig moveFlagProseDaoConfig;
    private final DaoConfig conquestPokemonEvolutionDaoConfig;
    private final DaoConfig conquestMoveDataDaoConfig;
    private final DaoConfig conquestMoveEffectProseDaoConfig;
    private final DaoConfig conquestMoveEffectsDaoConfig;
    private final DaoConfig pokemonDexNumbersDaoConfig;
    private final DaoConfig pokedexVersionGroupsDaoConfig;
    private final DaoConfig pokedexProseDaoConfig;
    private final DaoConfig pokedexesDaoConfig;
    private final DaoConfig locationAreaProseDaoConfig;
    private final DaoConfig encounterConditionValueMapDaoConfig;
    private final DaoConfig encountersDaoConfig;
    private final DaoConfig locationAreaEncounterRatesDaoConfig;
    private final DaoConfig locationAreasDaoConfig;
    private final DaoConfig versionGroupPokemonMoveMethodsDaoConfig;
    private final DaoConfig conquestStatNamesDaoConfig;
    private final DaoConfig moveMetaCategoryProseDaoConfig;
    private final DaoConfig moveMetaDaoConfig;
    private final DaoConfig moveMetaCategoriesDaoConfig;
    private final DaoConfig pokemonSpeciesFlavorSummariesDaoConfig;
    private final DaoConfig pokemonEggGroupsDaoConfig;
    private final DaoConfig pokemonEvolutionDaoConfig;
    private final DaoConfig conquestPokemonMovesDaoConfig;
    private final DaoConfig conquestTransformationPokemonDaoConfig;
    private final DaoConfig pokemonMovesDaoConfig;
    private final DaoConfig pokemonGameIndicesDaoConfig;
    private final DaoConfig pokemonStatsDaoConfig;
    private final DaoConfig pokemonDaoConfig;
    private final DaoConfig palParkDaoConfig;
    private final DaoConfig pokemonSpeciesProseDaoConfig;
    private final DaoConfig pokemonSpeciesFlavorTextDaoConfig;
    private final DaoConfig conquestMaxLinksDaoConfig;
    private final DaoConfig pokemonSpeciesNamesDaoConfig;
    private final DaoConfig pokemonSpeciesDaoConfig;
    private final DaoConfig pokemonShapeProseDaoConfig;
    private final DaoConfig pokemonShapesDaoConfig;
    private final DaoConfig conquestTransformationWarriorsDaoConfig;
    private final DaoConfig pokemonItemsDaoConfig;
    private final DaoConfig moveFlavorSummariesDaoConfig;
    private final DaoConfig abilityChangelogProseDaoConfig;
    private final DaoConfig statNamesDaoConfig;
    private final DaoConfig moveBattleStyleProseDaoConfig;
    private final DaoConfig contestEffectProseDaoConfig;
    private final DaoConfig moveDamageClassProseDaoConfig;
    private final DaoConfig regionNamesDaoConfig;
    private final DaoConfig growthRateProseDaoConfig;
    private final DaoConfig itemCategoryProseDaoConfig;
    private final DaoConfig moveNamesDaoConfig;
    private final DaoConfig encounterConditionValueProseDaoConfig;
    private final DaoConfig contestTypeNamesDaoConfig;
    private final DaoConfig pokemonMoveMethodProseDaoConfig;
    private final DaoConfig conquestEpisodeNamesDaoConfig;
    private final DaoConfig conquestWarriorNamesDaoConfig;
    private final DaoConfig palParkAreaNamesDaoConfig;
    private final DaoConfig itemNamesDaoConfig;
    private final DaoConfig encounterConditionProseDaoConfig;
    private final DaoConfig superContestEffectProseDaoConfig;
    private final DaoConfig itemFlavorSummariesDaoConfig;
    private final DaoConfig conquestWarriorSkillNamesDaoConfig;
    private final DaoConfig conquestKingdomNamesDaoConfig;
    private final DaoConfig generationNamesDaoConfig;
    private final DaoConfig moveFlavorTextDaoConfig;
    private final DaoConfig versionNamesDaoConfig;
    private final DaoConfig itemFlavorTextDaoConfig;
    private final DaoConfig moveMetaAilmentNamesDaoConfig;
    private final DaoConfig pokemonHabitatNamesDaoConfig;
    private final DaoConfig moveTargetProseDaoConfig;
    private final DaoConfig conquestMoveDisplacementProseDaoConfig;
    private final DaoConfig statHintNamesDaoConfig;
    private final DaoConfig itemFlagProseDaoConfig;
    private final DaoConfig locationNamesDaoConfig;
    private final DaoConfig evolutionTriggerProseDaoConfig;
    private final DaoConfig berryFirmnessNamesDaoConfig;
    private final DaoConfig itemPocketNamesDaoConfig;
    private final DaoConfig itemProseDaoConfig;
    private final DaoConfig conquestWarriorStatNamesDaoConfig;
    private final DaoConfig eggGroupProseDaoConfig;
    private final DaoConfig moveEffectProseDaoConfig;
    private final DaoConfig conquestMoveRangeProseDaoConfig;
    private final DaoConfig natureNamesDaoConfig;
    private final DaoConfig itemFlingEffectProseDaoConfig;
    private final DaoConfig encounterMethodProseDaoConfig;
    private final DaoConfig typeNamesDaoConfig;
    private final DaoConfig pokemonColorNamesDaoConfig;
    private final DaoConfig pokemonFormNamesDaoConfig;
    private final DaoConfig languageNamesDaoConfig;
    private final DaoConfig pokeathlonStatNamesDaoConfig;
    private final DaoConfig moveEffectChangelogProseDaoConfig;
    private final DaoConfig languagesDaoConfig;
    private final DaoConfig pokemonFormGenerationsDaoConfig;
    private final DaoConfig encounterConditionValuesDaoConfig;
    private final DaoConfig conquestMoveDisplacementsDaoConfig;
    private final DaoConfig conquestWarriorRankStatMapDaoConfig;
    private final DaoConfig conquestWarriorTransformationDaoConfig;
    private final DaoConfig conquestWarriorRanksDaoConfig;
    private final DaoConfig moveFlagMapDaoConfig;
    private final DaoConfig locationGameIndicesDaoConfig;
    private final DaoConfig itemGameIndicesDaoConfig;
    private final DaoConfig movesDaoConfig;
    private final DaoConfig conquestKingdomsDaoConfig;
    private final DaoConfig conquestWarriorSpecialtiesDaoConfig;
    private final DaoConfig typeGameIndicesDaoConfig;
    private final DaoConfig berriesDaoConfig;
    private final DaoConfig typesDaoConfig;
    private final DaoConfig versionGroupRegionsDaoConfig;
    private final DaoConfig versionGroupsDaoConfig;
    private final DaoConfig generationsDaoConfig;
    private final DaoConfig pokemonFormPokeathlonStatsDaoConfig;
    private final DaoConfig pokemonFormsDaoConfig;
    private final DaoConfig berryFirmnessDaoConfig;
    private final DaoConfig pokemonMoveMethodsDaoConfig;
    private final DaoConfig moveMetaStatChangesDaoConfig;
    private final DaoConfig conquestEpisodeWarriorsDaoConfig;
    private final DaoConfig conquestEpisodesDaoConfig;
    private final DaoConfig natureBattleStylePreferencesDaoConfig;
    private final DaoConfig moveBattleStylesDaoConfig;
    private final DaoConfig machinesDaoConfig;
    private final DaoConfig eggGroupsDaoConfig;
    private final DaoConfig statHintsDaoConfig;
    private final DaoConfig naturesDaoConfig;
    private final DaoConfig statsDaoConfig;
    private final DaoConfig encounterConditionsDaoConfig;
    private final DaoConfig moveChangelogDaoConfig;
    private final DaoConfig conquestWarriorSkillsDaoConfig;
    private final DaoConfig itemFlagMapDaoConfig;
    private final DaoConfig itemFlagsDaoConfig;
    private final DaoConfig itemCategoriesDaoConfig;
    private final DaoConfig itemPocketsDaoConfig;
    private final DaoConfig berryFlavorsDaoConfig;
    private final DaoConfig contestTypesDaoConfig;
    private final DaoConfig superContestCombosDaoConfig;
    private final DaoConfig encounterSlotsDaoConfig;
    private final DaoConfig conquestWarriorsDaoConfig;
    private final DaoConfig conquestWarriorArchetypesDaoConfig;
    private final DaoConfig evolutionTriggersDaoConfig;
    private final DaoConfig moveEffectChangelogDaoConfig;
    private final DaoConfig moveEffectsDaoConfig;
    private final DaoConfig evolutionChainsDaoConfig;
    private final DaoConfig itemsDaoConfig;
    private final DaoConfig experienceDaoConfig;
    private final DaoConfig naturePokeathlonStatsDaoConfig;
    private final DaoConfig pokemonTypesDaoConfig;
    private final DaoConfig conquestWarriorStatsDaoConfig;
    private final DaoConfig encounterMethodsDaoConfig;
    private final DaoConfig pokemonColorsDaoConfig;
    private final DaoConfig moveDamageClassesDaoConfig;
    private final DaoConfig pokeathlonStatsDaoConfig;
    private final DaoConfig contestCombosDaoConfig;
    private final DaoConfig palParkAreasDaoConfig;
    private final DaoConfig moveTargetsDaoConfig;
    private final DaoConfig growthRatesDaoConfig;
    private final DaoConfig contestEffectsDaoConfig;
    private final DaoConfig moveMetaAilmentsDaoConfig;
    private final DaoConfig versionsDaoConfig;
    private final DaoConfig moveFlagsDaoConfig;
    private final DaoConfig gendersDaoConfig;
    private final DaoConfig pokemonHabitatsDaoConfig;
    private final DaoConfig locationsDaoConfig;
    private final DaoConfig regionsDaoConfig;
    private final DaoConfig superContestEffectsDaoConfig;
    private final DaoConfig conquestMoveRangesDaoConfig;
    private final DaoConfig conquestStatsDaoConfig;
    private final DaoConfig itemFlingEffectsDaoConfig;

    private final TypeEfficacyDao typeEfficacyDao;
    private final ConquestPokemonStatsDao conquestPokemonStatsDao;
    private final AbilityNamesDao abilityNamesDao;
    private final AbilityFlavorTextDao abilityFlavorTextDao;
    private final AbilityProseDao abilityProseDao;
    private final AbilityChangelogDao abilityChangelogDao;
    private final PokemonAbilitiesDao pokemonAbilitiesDao;
    private final ConquestPokemonAbilitiesDao conquestPokemonAbilitiesDao;
    private final AbilitiesDao abilitiesDao;
    private final MoveFlagProseDao moveFlagProseDao;
    private final ConquestPokemonEvolutionDao conquestPokemonEvolutionDao;
    private final ConquestMoveDataDao conquestMoveDataDao;
    private final ConquestMoveEffectProseDao conquestMoveEffectProseDao;
    private final ConquestMoveEffectsDao conquestMoveEffectsDao;
    private final PokemonDexNumbersDao pokemonDexNumbersDao;
    private final PokedexVersionGroupsDao pokedexVersionGroupsDao;
    private final PokedexProseDao pokedexProseDao;
    private final PokedexesDao pokedexesDao;
    private final LocationAreaProseDao locationAreaProseDao;
    private final EncounterConditionValueMapDao encounterConditionValueMapDao;
    private final EncountersDao encountersDao;
    private final LocationAreaEncounterRatesDao locationAreaEncounterRatesDao;
    private final LocationAreasDao locationAreasDao;
    private final VersionGroupPokemonMoveMethodsDao versionGroupPokemonMoveMethodsDao;
    private final ConquestStatNamesDao conquestStatNamesDao;
    private final MoveMetaCategoryProseDao moveMetaCategoryProseDao;
    private final MoveMetaDao moveMetaDao;
    private final MoveMetaCategoriesDao moveMetaCategoriesDao;
    private final PokemonSpeciesFlavorSummariesDao pokemonSpeciesFlavorSummariesDao;
    private final PokemonEggGroupsDao pokemonEggGroupsDao;
    private final PokemonEvolutionDao pokemonEvolutionDao;
    private final ConquestPokemonMovesDao conquestPokemonMovesDao;
    private final ConquestTransformationPokemonDao conquestTransformationPokemonDao;
    private final PokemonMovesDao pokemonMovesDao;
    private final PokemonGameIndicesDao pokemonGameIndicesDao;
    private final PokemonStatsDao pokemonStatsDao;
    private final PokemonDao pokemonDao;
    private final PalParkDao palParkDao;
    private final PokemonSpeciesProseDao pokemonSpeciesProseDao;
    private final PokemonSpeciesFlavorTextDao pokemonSpeciesFlavorTextDao;
    private final ConquestMaxLinksDao conquestMaxLinksDao;
    private final PokemonSpeciesNamesDao pokemonSpeciesNamesDao;
    private final PokemonSpeciesDao pokemonSpeciesDao;
    private final PokemonShapeProseDao pokemonShapeProseDao;
    private final PokemonShapesDao pokemonShapesDao;
    private final ConquestTransformationWarriorsDao conquestTransformationWarriorsDao;
    private final PokemonItemsDao pokemonItemsDao;
    private final MoveFlavorSummariesDao moveFlavorSummariesDao;
    private final AbilityChangelogProseDao abilityChangelogProseDao;
    private final StatNamesDao statNamesDao;
    private final MoveBattleStyleProseDao moveBattleStyleProseDao;
    private final ContestEffectProseDao contestEffectProseDao;
    private final MoveDamageClassProseDao moveDamageClassProseDao;
    private final RegionNamesDao regionNamesDao;
    private final GrowthRateProseDao growthRateProseDao;
    private final ItemCategoryProseDao itemCategoryProseDao;
    private final MoveNamesDao moveNamesDao;
    private final EncounterConditionValueProseDao encounterConditionValueProseDao;
    private final ContestTypeNamesDao contestTypeNamesDao;
    private final PokemonMoveMethodProseDao pokemonMoveMethodProseDao;
    private final ConquestEpisodeNamesDao conquestEpisodeNamesDao;
    private final ConquestWarriorNamesDao conquestWarriorNamesDao;
    private final PalParkAreaNamesDao palParkAreaNamesDao;
    private final ItemNamesDao itemNamesDao;
    private final EncounterConditionProseDao encounterConditionProseDao;
    private final SuperContestEffectProseDao superContestEffectProseDao;
    private final ItemFlavorSummariesDao itemFlavorSummariesDao;
    private final ConquestWarriorSkillNamesDao conquestWarriorSkillNamesDao;
    private final ConquestKingdomNamesDao conquestKingdomNamesDao;
    private final GenerationNamesDao generationNamesDao;
    private final MoveFlavorTextDao moveFlavorTextDao;
    private final VersionNamesDao versionNamesDao;
    private final ItemFlavorTextDao itemFlavorTextDao;
    private final MoveMetaAilmentNamesDao moveMetaAilmentNamesDao;
    private final PokemonHabitatNamesDao pokemonHabitatNamesDao;
    private final MoveTargetProseDao moveTargetProseDao;
    private final ConquestMoveDisplacementProseDao conquestMoveDisplacementProseDao;
    private final StatHintNamesDao statHintNamesDao;
    private final ItemFlagProseDao itemFlagProseDao;
    private final LocationNamesDao locationNamesDao;
    private final EvolutionTriggerProseDao evolutionTriggerProseDao;
    private final BerryFirmnessNamesDao berryFirmnessNamesDao;
    private final ItemPocketNamesDao itemPocketNamesDao;
    private final ItemProseDao itemProseDao;
    private final ConquestWarriorStatNamesDao conquestWarriorStatNamesDao;
    private final EggGroupProseDao eggGroupProseDao;
    private final MoveEffectProseDao moveEffectProseDao;
    private final ConquestMoveRangeProseDao conquestMoveRangeProseDao;
    private final NatureNamesDao natureNamesDao;
    private final ItemFlingEffectProseDao itemFlingEffectProseDao;
    private final EncounterMethodProseDao encounterMethodProseDao;
    private final TypeNamesDao typeNamesDao;
    private final PokemonColorNamesDao pokemonColorNamesDao;
    private final PokemonFormNamesDao pokemonFormNamesDao;
    private final LanguageNamesDao languageNamesDao;
    private final PokeathlonStatNamesDao pokeathlonStatNamesDao;
    private final MoveEffectChangelogProseDao moveEffectChangelogProseDao;
    private final LanguagesDao languagesDao;
    private final PokemonFormGenerationsDao pokemonFormGenerationsDao;
    private final EncounterConditionValuesDao encounterConditionValuesDao;
    private final ConquestMoveDisplacementsDao conquestMoveDisplacementsDao;
    private final ConquestWarriorRankStatMapDao conquestWarriorRankStatMapDao;
    private final ConquestWarriorTransformationDao conquestWarriorTransformationDao;
    private final ConquestWarriorRanksDao conquestWarriorRanksDao;
    private final MoveFlagMapDao moveFlagMapDao;
    private final LocationGameIndicesDao locationGameIndicesDao;
    private final ItemGameIndicesDao itemGameIndicesDao;
    private final MovesDao movesDao;
    private final ConquestKingdomsDao conquestKingdomsDao;
    private final ConquestWarriorSpecialtiesDao conquestWarriorSpecialtiesDao;
    private final TypeGameIndicesDao typeGameIndicesDao;
    private final BerriesDao berriesDao;
    private final TypesDao typesDao;
    private final VersionGroupRegionsDao versionGroupRegionsDao;
    private final VersionGroupsDao versionGroupsDao;
    private final GenerationsDao generationsDao;
    private final PokemonFormPokeathlonStatsDao pokemonFormPokeathlonStatsDao;
    private final PokemonFormsDao pokemonFormsDao;
    private final BerryFirmnessDao berryFirmnessDao;
    private final PokemonMoveMethodsDao pokemonMoveMethodsDao;
    private final MoveMetaStatChangesDao moveMetaStatChangesDao;
    private final ConquestEpisodeWarriorsDao conquestEpisodeWarriorsDao;
    private final ConquestEpisodesDao conquestEpisodesDao;
    private final NatureBattleStylePreferencesDao natureBattleStylePreferencesDao;
    private final MoveBattleStylesDao moveBattleStylesDao;
    private final MachinesDao machinesDao;
    private final EggGroupsDao eggGroupsDao;
    private final StatHintsDao statHintsDao;
    private final NaturesDao naturesDao;
    private final StatsDao statsDao;
    private final EncounterConditionsDao encounterConditionsDao;
    private final MoveChangelogDao moveChangelogDao;
    private final ConquestWarriorSkillsDao conquestWarriorSkillsDao;
    private final ItemFlagMapDao itemFlagMapDao;
    private final ItemFlagsDao itemFlagsDao;
    private final ItemCategoriesDao itemCategoriesDao;
    private final ItemPocketsDao itemPocketsDao;
    private final BerryFlavorsDao berryFlavorsDao;
    private final ContestTypesDao contestTypesDao;
    private final SuperContestCombosDao superContestCombosDao;
    private final EncounterSlotsDao encounterSlotsDao;
    private final ConquestWarriorsDao conquestWarriorsDao;
    private final ConquestWarriorArchetypesDao conquestWarriorArchetypesDao;
    private final EvolutionTriggersDao evolutionTriggersDao;
    private final MoveEffectChangelogDao moveEffectChangelogDao;
    private final MoveEffectsDao moveEffectsDao;
    private final EvolutionChainsDao evolutionChainsDao;
    private final ItemsDao itemsDao;
    private final ExperienceDao experienceDao;
    private final NaturePokeathlonStatsDao naturePokeathlonStatsDao;
    private final PokemonTypesDao pokemonTypesDao;
    private final ConquestWarriorStatsDao conquestWarriorStatsDao;
    private final EncounterMethodsDao encounterMethodsDao;
    private final PokemonColorsDao pokemonColorsDao;
    private final MoveDamageClassesDao moveDamageClassesDao;
    private final PokeathlonStatsDao pokeathlonStatsDao;
    private final ContestCombosDao contestCombosDao;
    private final PalParkAreasDao palParkAreasDao;
    private final MoveTargetsDao moveTargetsDao;
    private final GrowthRatesDao growthRatesDao;
    private final ContestEffectsDao contestEffectsDao;
    private final MoveMetaAilmentsDao moveMetaAilmentsDao;
    private final VersionsDao versionsDao;
    private final MoveFlagsDao moveFlagsDao;
    private final GendersDao gendersDao;
    private final PokemonHabitatsDao pokemonHabitatsDao;
    private final LocationsDao locationsDao;
    private final RegionsDao regionsDao;
    private final SuperContestEffectsDao superContestEffectsDao;
    private final ConquestMoveRangesDao conquestMoveRangesDao;
    private final ConquestStatsDao conquestStatsDao;
    private final ItemFlingEffectsDao itemFlingEffectsDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        typeEfficacyDaoConfig = daoConfigMap.get(TypeEfficacyDao.class).clone();
        typeEfficacyDaoConfig.initIdentityScope(type);

        conquestPokemonStatsDaoConfig = daoConfigMap.get(ConquestPokemonStatsDao.class).clone();
        conquestPokemonStatsDaoConfig.initIdentityScope(type);

        abilityNamesDaoConfig = daoConfigMap.get(AbilityNamesDao.class).clone();
        abilityNamesDaoConfig.initIdentityScope(type);

        abilityFlavorTextDaoConfig = daoConfigMap.get(AbilityFlavorTextDao.class).clone();
        abilityFlavorTextDaoConfig.initIdentityScope(type);

        abilityProseDaoConfig = daoConfigMap.get(AbilityProseDao.class).clone();
        abilityProseDaoConfig.initIdentityScope(type);

        abilityChangelogDaoConfig = daoConfigMap.get(AbilityChangelogDao.class).clone();
        abilityChangelogDaoConfig.initIdentityScope(type);

        pokemonAbilitiesDaoConfig = daoConfigMap.get(PokemonAbilitiesDao.class).clone();
        pokemonAbilitiesDaoConfig.initIdentityScope(type);

        conquestPokemonAbilitiesDaoConfig = daoConfigMap.get(ConquestPokemonAbilitiesDao.class).clone();
        conquestPokemonAbilitiesDaoConfig.initIdentityScope(type);

        abilitiesDaoConfig = daoConfigMap.get(AbilitiesDao.class).clone();
        abilitiesDaoConfig.initIdentityScope(type);

        moveFlagProseDaoConfig = daoConfigMap.get(MoveFlagProseDao.class).clone();
        moveFlagProseDaoConfig.initIdentityScope(type);

        conquestPokemonEvolutionDaoConfig = daoConfigMap.get(ConquestPokemonEvolutionDao.class).clone();
        conquestPokemonEvolutionDaoConfig.initIdentityScope(type);

        conquestMoveDataDaoConfig = daoConfigMap.get(ConquestMoveDataDao.class).clone();
        conquestMoveDataDaoConfig.initIdentityScope(type);

        conquestMoveEffectProseDaoConfig = daoConfigMap.get(ConquestMoveEffectProseDao.class).clone();
        conquestMoveEffectProseDaoConfig.initIdentityScope(type);

        conquestMoveEffectsDaoConfig = daoConfigMap.get(ConquestMoveEffectsDao.class).clone();
        conquestMoveEffectsDaoConfig.initIdentityScope(type);

        pokemonDexNumbersDaoConfig = daoConfigMap.get(PokemonDexNumbersDao.class).clone();
        pokemonDexNumbersDaoConfig.initIdentityScope(type);

        pokedexVersionGroupsDaoConfig = daoConfigMap.get(PokedexVersionGroupsDao.class).clone();
        pokedexVersionGroupsDaoConfig.initIdentityScope(type);

        pokedexProseDaoConfig = daoConfigMap.get(PokedexProseDao.class).clone();
        pokedexProseDaoConfig.initIdentityScope(type);

        pokedexesDaoConfig = daoConfigMap.get(PokedexesDao.class).clone();
        pokedexesDaoConfig.initIdentityScope(type);

        locationAreaProseDaoConfig = daoConfigMap.get(LocationAreaProseDao.class).clone();
        locationAreaProseDaoConfig.initIdentityScope(type);

        encounterConditionValueMapDaoConfig = daoConfigMap.get(EncounterConditionValueMapDao.class).clone();
        encounterConditionValueMapDaoConfig.initIdentityScope(type);

        encountersDaoConfig = daoConfigMap.get(EncountersDao.class).clone();
        encountersDaoConfig.initIdentityScope(type);

        locationAreaEncounterRatesDaoConfig = daoConfigMap.get(LocationAreaEncounterRatesDao.class).clone();
        locationAreaEncounterRatesDaoConfig.initIdentityScope(type);

        locationAreasDaoConfig = daoConfigMap.get(LocationAreasDao.class).clone();
        locationAreasDaoConfig.initIdentityScope(type);

        versionGroupPokemonMoveMethodsDaoConfig = daoConfigMap.get(VersionGroupPokemonMoveMethodsDao.class).clone();
        versionGroupPokemonMoveMethodsDaoConfig.initIdentityScope(type);

        conquestStatNamesDaoConfig = daoConfigMap.get(ConquestStatNamesDao.class).clone();
        conquestStatNamesDaoConfig.initIdentityScope(type);

        moveMetaCategoryProseDaoConfig = daoConfigMap.get(MoveMetaCategoryProseDao.class).clone();
        moveMetaCategoryProseDaoConfig.initIdentityScope(type);

        moveMetaDaoConfig = daoConfigMap.get(MoveMetaDao.class).clone();
        moveMetaDaoConfig.initIdentityScope(type);

        moveMetaCategoriesDaoConfig = daoConfigMap.get(MoveMetaCategoriesDao.class).clone();
        moveMetaCategoriesDaoConfig.initIdentityScope(type);

        pokemonSpeciesFlavorSummariesDaoConfig = daoConfigMap.get(PokemonSpeciesFlavorSummariesDao.class).clone();
        pokemonSpeciesFlavorSummariesDaoConfig.initIdentityScope(type);

        pokemonEggGroupsDaoConfig = daoConfigMap.get(PokemonEggGroupsDao.class).clone();
        pokemonEggGroupsDaoConfig.initIdentityScope(type);

        pokemonEvolutionDaoConfig = daoConfigMap.get(PokemonEvolutionDao.class).clone();
        pokemonEvolutionDaoConfig.initIdentityScope(type);

        conquestPokemonMovesDaoConfig = daoConfigMap.get(ConquestPokemonMovesDao.class).clone();
        conquestPokemonMovesDaoConfig.initIdentityScope(type);

        conquestTransformationPokemonDaoConfig = daoConfigMap.get(ConquestTransformationPokemonDao.class).clone();
        conquestTransformationPokemonDaoConfig.initIdentityScope(type);

        pokemonMovesDaoConfig = daoConfigMap.get(PokemonMovesDao.class).clone();
        pokemonMovesDaoConfig.initIdentityScope(type);

        pokemonGameIndicesDaoConfig = daoConfigMap.get(PokemonGameIndicesDao.class).clone();
        pokemonGameIndicesDaoConfig.initIdentityScope(type);

        pokemonStatsDaoConfig = daoConfigMap.get(PokemonStatsDao.class).clone();
        pokemonStatsDaoConfig.initIdentityScope(type);

        pokemonDaoConfig = daoConfigMap.get(PokemonDao.class).clone();
        pokemonDaoConfig.initIdentityScope(type);

        palParkDaoConfig = daoConfigMap.get(PalParkDao.class).clone();
        palParkDaoConfig.initIdentityScope(type);

        pokemonSpeciesProseDaoConfig = daoConfigMap.get(PokemonSpeciesProseDao.class).clone();
        pokemonSpeciesProseDaoConfig.initIdentityScope(type);

        pokemonSpeciesFlavorTextDaoConfig = daoConfigMap.get(PokemonSpeciesFlavorTextDao.class).clone();
        pokemonSpeciesFlavorTextDaoConfig.initIdentityScope(type);

        conquestMaxLinksDaoConfig = daoConfigMap.get(ConquestMaxLinksDao.class).clone();
        conquestMaxLinksDaoConfig.initIdentityScope(type);

        pokemonSpeciesNamesDaoConfig = daoConfigMap.get(PokemonSpeciesNamesDao.class).clone();
        pokemonSpeciesNamesDaoConfig.initIdentityScope(type);

        pokemonSpeciesDaoConfig = daoConfigMap.get(PokemonSpeciesDao.class).clone();
        pokemonSpeciesDaoConfig.initIdentityScope(type);

        pokemonShapeProseDaoConfig = daoConfigMap.get(PokemonShapeProseDao.class).clone();
        pokemonShapeProseDaoConfig.initIdentityScope(type);

        pokemonShapesDaoConfig = daoConfigMap.get(PokemonShapesDao.class).clone();
        pokemonShapesDaoConfig.initIdentityScope(type);

        conquestTransformationWarriorsDaoConfig = daoConfigMap.get(ConquestTransformationWarriorsDao.class).clone();
        conquestTransformationWarriorsDaoConfig.initIdentityScope(type);

        pokemonItemsDaoConfig = daoConfigMap.get(PokemonItemsDao.class).clone();
        pokemonItemsDaoConfig.initIdentityScope(type);

        moveFlavorSummariesDaoConfig = daoConfigMap.get(MoveFlavorSummariesDao.class).clone();
        moveFlavorSummariesDaoConfig.initIdentityScope(type);

        abilityChangelogProseDaoConfig = daoConfigMap.get(AbilityChangelogProseDao.class).clone();
        abilityChangelogProseDaoConfig.initIdentityScope(type);

        statNamesDaoConfig = daoConfigMap.get(StatNamesDao.class).clone();
        statNamesDaoConfig.initIdentityScope(type);

        moveBattleStyleProseDaoConfig = daoConfigMap.get(MoveBattleStyleProseDao.class).clone();
        moveBattleStyleProseDaoConfig.initIdentityScope(type);

        contestEffectProseDaoConfig = daoConfigMap.get(ContestEffectProseDao.class).clone();
        contestEffectProseDaoConfig.initIdentityScope(type);

        moveDamageClassProseDaoConfig = daoConfigMap.get(MoveDamageClassProseDao.class).clone();
        moveDamageClassProseDaoConfig.initIdentityScope(type);

        regionNamesDaoConfig = daoConfigMap.get(RegionNamesDao.class).clone();
        regionNamesDaoConfig.initIdentityScope(type);

        growthRateProseDaoConfig = daoConfigMap.get(GrowthRateProseDao.class).clone();
        growthRateProseDaoConfig.initIdentityScope(type);

        itemCategoryProseDaoConfig = daoConfigMap.get(ItemCategoryProseDao.class).clone();
        itemCategoryProseDaoConfig.initIdentityScope(type);

        moveNamesDaoConfig = daoConfigMap.get(MoveNamesDao.class).clone();
        moveNamesDaoConfig.initIdentityScope(type);

        encounterConditionValueProseDaoConfig = daoConfigMap.get(EncounterConditionValueProseDao.class).clone();
        encounterConditionValueProseDaoConfig.initIdentityScope(type);

        contestTypeNamesDaoConfig = daoConfigMap.get(ContestTypeNamesDao.class).clone();
        contestTypeNamesDaoConfig.initIdentityScope(type);

        pokemonMoveMethodProseDaoConfig = daoConfigMap.get(PokemonMoveMethodProseDao.class).clone();
        pokemonMoveMethodProseDaoConfig.initIdentityScope(type);

        conquestEpisodeNamesDaoConfig = daoConfigMap.get(ConquestEpisodeNamesDao.class).clone();
        conquestEpisodeNamesDaoConfig.initIdentityScope(type);

        conquestWarriorNamesDaoConfig = daoConfigMap.get(ConquestWarriorNamesDao.class).clone();
        conquestWarriorNamesDaoConfig.initIdentityScope(type);

        palParkAreaNamesDaoConfig = daoConfigMap.get(PalParkAreaNamesDao.class).clone();
        palParkAreaNamesDaoConfig.initIdentityScope(type);

        itemNamesDaoConfig = daoConfigMap.get(ItemNamesDao.class).clone();
        itemNamesDaoConfig.initIdentityScope(type);

        encounterConditionProseDaoConfig = daoConfigMap.get(EncounterConditionProseDao.class).clone();
        encounterConditionProseDaoConfig.initIdentityScope(type);

        superContestEffectProseDaoConfig = daoConfigMap.get(SuperContestEffectProseDao.class).clone();
        superContestEffectProseDaoConfig.initIdentityScope(type);

        itemFlavorSummariesDaoConfig = daoConfigMap.get(ItemFlavorSummariesDao.class).clone();
        itemFlavorSummariesDaoConfig.initIdentityScope(type);

        conquestWarriorSkillNamesDaoConfig = daoConfigMap.get(ConquestWarriorSkillNamesDao.class).clone();
        conquestWarriorSkillNamesDaoConfig.initIdentityScope(type);

        conquestKingdomNamesDaoConfig = daoConfigMap.get(ConquestKingdomNamesDao.class).clone();
        conquestKingdomNamesDaoConfig.initIdentityScope(type);

        generationNamesDaoConfig = daoConfigMap.get(GenerationNamesDao.class).clone();
        generationNamesDaoConfig.initIdentityScope(type);

        moveFlavorTextDaoConfig = daoConfigMap.get(MoveFlavorTextDao.class).clone();
        moveFlavorTextDaoConfig.initIdentityScope(type);

        versionNamesDaoConfig = daoConfigMap.get(VersionNamesDao.class).clone();
        versionNamesDaoConfig.initIdentityScope(type);

        itemFlavorTextDaoConfig = daoConfigMap.get(ItemFlavorTextDao.class).clone();
        itemFlavorTextDaoConfig.initIdentityScope(type);

        moveMetaAilmentNamesDaoConfig = daoConfigMap.get(MoveMetaAilmentNamesDao.class).clone();
        moveMetaAilmentNamesDaoConfig.initIdentityScope(type);

        pokemonHabitatNamesDaoConfig = daoConfigMap.get(PokemonHabitatNamesDao.class).clone();
        pokemonHabitatNamesDaoConfig.initIdentityScope(type);

        moveTargetProseDaoConfig = daoConfigMap.get(MoveTargetProseDao.class).clone();
        moveTargetProseDaoConfig.initIdentityScope(type);

        conquestMoveDisplacementProseDaoConfig = daoConfigMap.get(ConquestMoveDisplacementProseDao.class).clone();
        conquestMoveDisplacementProseDaoConfig.initIdentityScope(type);

        statHintNamesDaoConfig = daoConfigMap.get(StatHintNamesDao.class).clone();
        statHintNamesDaoConfig.initIdentityScope(type);

        itemFlagProseDaoConfig = daoConfigMap.get(ItemFlagProseDao.class).clone();
        itemFlagProseDaoConfig.initIdentityScope(type);

        locationNamesDaoConfig = daoConfigMap.get(LocationNamesDao.class).clone();
        locationNamesDaoConfig.initIdentityScope(type);

        evolutionTriggerProseDaoConfig = daoConfigMap.get(EvolutionTriggerProseDao.class).clone();
        evolutionTriggerProseDaoConfig.initIdentityScope(type);

        berryFirmnessNamesDaoConfig = daoConfigMap.get(BerryFirmnessNamesDao.class).clone();
        berryFirmnessNamesDaoConfig.initIdentityScope(type);

        itemPocketNamesDaoConfig = daoConfigMap.get(ItemPocketNamesDao.class).clone();
        itemPocketNamesDaoConfig.initIdentityScope(type);

        itemProseDaoConfig = daoConfigMap.get(ItemProseDao.class).clone();
        itemProseDaoConfig.initIdentityScope(type);

        conquestWarriorStatNamesDaoConfig = daoConfigMap.get(ConquestWarriorStatNamesDao.class).clone();
        conquestWarriorStatNamesDaoConfig.initIdentityScope(type);

        eggGroupProseDaoConfig = daoConfigMap.get(EggGroupProseDao.class).clone();
        eggGroupProseDaoConfig.initIdentityScope(type);

        moveEffectProseDaoConfig = daoConfigMap.get(MoveEffectProseDao.class).clone();
        moveEffectProseDaoConfig.initIdentityScope(type);

        conquestMoveRangeProseDaoConfig = daoConfigMap.get(ConquestMoveRangeProseDao.class).clone();
        conquestMoveRangeProseDaoConfig.initIdentityScope(type);

        natureNamesDaoConfig = daoConfigMap.get(NatureNamesDao.class).clone();
        natureNamesDaoConfig.initIdentityScope(type);

        itemFlingEffectProseDaoConfig = daoConfigMap.get(ItemFlingEffectProseDao.class).clone();
        itemFlingEffectProseDaoConfig.initIdentityScope(type);

        encounterMethodProseDaoConfig = daoConfigMap.get(EncounterMethodProseDao.class).clone();
        encounterMethodProseDaoConfig.initIdentityScope(type);

        typeNamesDaoConfig = daoConfigMap.get(TypeNamesDao.class).clone();
        typeNamesDaoConfig.initIdentityScope(type);

        pokemonColorNamesDaoConfig = daoConfigMap.get(PokemonColorNamesDao.class).clone();
        pokemonColorNamesDaoConfig.initIdentityScope(type);

        pokemonFormNamesDaoConfig = daoConfigMap.get(PokemonFormNamesDao.class).clone();
        pokemonFormNamesDaoConfig.initIdentityScope(type);

        languageNamesDaoConfig = daoConfigMap.get(LanguageNamesDao.class).clone();
        languageNamesDaoConfig.initIdentityScope(type);

        pokeathlonStatNamesDaoConfig = daoConfigMap.get(PokeathlonStatNamesDao.class).clone();
        pokeathlonStatNamesDaoConfig.initIdentityScope(type);

        moveEffectChangelogProseDaoConfig = daoConfigMap.get(MoveEffectChangelogProseDao.class).clone();
        moveEffectChangelogProseDaoConfig.initIdentityScope(type);

        languagesDaoConfig = daoConfigMap.get(LanguagesDao.class).clone();
        languagesDaoConfig.initIdentityScope(type);

        pokemonFormGenerationsDaoConfig = daoConfigMap.get(PokemonFormGenerationsDao.class).clone();
        pokemonFormGenerationsDaoConfig.initIdentityScope(type);

        encounterConditionValuesDaoConfig = daoConfigMap.get(EncounterConditionValuesDao.class).clone();
        encounterConditionValuesDaoConfig.initIdentityScope(type);

        conquestMoveDisplacementsDaoConfig = daoConfigMap.get(ConquestMoveDisplacementsDao.class).clone();
        conquestMoveDisplacementsDaoConfig.initIdentityScope(type);

        conquestWarriorRankStatMapDaoConfig = daoConfigMap.get(ConquestWarriorRankStatMapDao.class).clone();
        conquestWarriorRankStatMapDaoConfig.initIdentityScope(type);

        conquestWarriorTransformationDaoConfig = daoConfigMap.get(ConquestWarriorTransformationDao.class).clone();
        conquestWarriorTransformationDaoConfig.initIdentityScope(type);

        conquestWarriorRanksDaoConfig = daoConfigMap.get(ConquestWarriorRanksDao.class).clone();
        conquestWarriorRanksDaoConfig.initIdentityScope(type);

        moveFlagMapDaoConfig = daoConfigMap.get(MoveFlagMapDao.class).clone();
        moveFlagMapDaoConfig.initIdentityScope(type);

        locationGameIndicesDaoConfig = daoConfigMap.get(LocationGameIndicesDao.class).clone();
        locationGameIndicesDaoConfig.initIdentityScope(type);

        itemGameIndicesDaoConfig = daoConfigMap.get(ItemGameIndicesDao.class).clone();
        itemGameIndicesDaoConfig.initIdentityScope(type);

        movesDaoConfig = daoConfigMap.get(MovesDao.class).clone();
        movesDaoConfig.initIdentityScope(type);

        conquestKingdomsDaoConfig = daoConfigMap.get(ConquestKingdomsDao.class).clone();
        conquestKingdomsDaoConfig.initIdentityScope(type);

        conquestWarriorSpecialtiesDaoConfig = daoConfigMap.get(ConquestWarriorSpecialtiesDao.class).clone();
        conquestWarriorSpecialtiesDaoConfig.initIdentityScope(type);

        typeGameIndicesDaoConfig = daoConfigMap.get(TypeGameIndicesDao.class).clone();
        typeGameIndicesDaoConfig.initIdentityScope(type);

        berriesDaoConfig = daoConfigMap.get(BerriesDao.class).clone();
        berriesDaoConfig.initIdentityScope(type);

        typesDaoConfig = daoConfigMap.get(TypesDao.class).clone();
        typesDaoConfig.initIdentityScope(type);

        versionGroupRegionsDaoConfig = daoConfigMap.get(VersionGroupRegionsDao.class).clone();
        versionGroupRegionsDaoConfig.initIdentityScope(type);

        versionGroupsDaoConfig = daoConfigMap.get(VersionGroupsDao.class).clone();
        versionGroupsDaoConfig.initIdentityScope(type);

        generationsDaoConfig = daoConfigMap.get(GenerationsDao.class).clone();
        generationsDaoConfig.initIdentityScope(type);

        pokemonFormPokeathlonStatsDaoConfig = daoConfigMap.get(PokemonFormPokeathlonStatsDao.class).clone();
        pokemonFormPokeathlonStatsDaoConfig.initIdentityScope(type);

        pokemonFormsDaoConfig = daoConfigMap.get(PokemonFormsDao.class).clone();
        pokemonFormsDaoConfig.initIdentityScope(type);

        berryFirmnessDaoConfig = daoConfigMap.get(BerryFirmnessDao.class).clone();
        berryFirmnessDaoConfig.initIdentityScope(type);

        pokemonMoveMethodsDaoConfig = daoConfigMap.get(PokemonMoveMethodsDao.class).clone();
        pokemonMoveMethodsDaoConfig.initIdentityScope(type);

        moveMetaStatChangesDaoConfig = daoConfigMap.get(MoveMetaStatChangesDao.class).clone();
        moveMetaStatChangesDaoConfig.initIdentityScope(type);

        conquestEpisodeWarriorsDaoConfig = daoConfigMap.get(ConquestEpisodeWarriorsDao.class).clone();
        conquestEpisodeWarriorsDaoConfig.initIdentityScope(type);

        conquestEpisodesDaoConfig = daoConfigMap.get(ConquestEpisodesDao.class).clone();
        conquestEpisodesDaoConfig.initIdentityScope(type);

        natureBattleStylePreferencesDaoConfig = daoConfigMap.get(NatureBattleStylePreferencesDao.class).clone();
        natureBattleStylePreferencesDaoConfig.initIdentityScope(type);

        moveBattleStylesDaoConfig = daoConfigMap.get(MoveBattleStylesDao.class).clone();
        moveBattleStylesDaoConfig.initIdentityScope(type);

        machinesDaoConfig = daoConfigMap.get(MachinesDao.class).clone();
        machinesDaoConfig.initIdentityScope(type);

        eggGroupsDaoConfig = daoConfigMap.get(EggGroupsDao.class).clone();
        eggGroupsDaoConfig.initIdentityScope(type);

        statHintsDaoConfig = daoConfigMap.get(StatHintsDao.class).clone();
        statHintsDaoConfig.initIdentityScope(type);

        naturesDaoConfig = daoConfigMap.get(NaturesDao.class).clone();
        naturesDaoConfig.initIdentityScope(type);

        statsDaoConfig = daoConfigMap.get(StatsDao.class).clone();
        statsDaoConfig.initIdentityScope(type);

        encounterConditionsDaoConfig = daoConfigMap.get(EncounterConditionsDao.class).clone();
        encounterConditionsDaoConfig.initIdentityScope(type);

        moveChangelogDaoConfig = daoConfigMap.get(MoveChangelogDao.class).clone();
        moveChangelogDaoConfig.initIdentityScope(type);

        conquestWarriorSkillsDaoConfig = daoConfigMap.get(ConquestWarriorSkillsDao.class).clone();
        conquestWarriorSkillsDaoConfig.initIdentityScope(type);

        itemFlagMapDaoConfig = daoConfigMap.get(ItemFlagMapDao.class).clone();
        itemFlagMapDaoConfig.initIdentityScope(type);

        itemFlagsDaoConfig = daoConfigMap.get(ItemFlagsDao.class).clone();
        itemFlagsDaoConfig.initIdentityScope(type);

        itemCategoriesDaoConfig = daoConfigMap.get(ItemCategoriesDao.class).clone();
        itemCategoriesDaoConfig.initIdentityScope(type);

        itemPocketsDaoConfig = daoConfigMap.get(ItemPocketsDao.class).clone();
        itemPocketsDaoConfig.initIdentityScope(type);

        berryFlavorsDaoConfig = daoConfigMap.get(BerryFlavorsDao.class).clone();
        berryFlavorsDaoConfig.initIdentityScope(type);

        contestTypesDaoConfig = daoConfigMap.get(ContestTypesDao.class).clone();
        contestTypesDaoConfig.initIdentityScope(type);

        superContestCombosDaoConfig = daoConfigMap.get(SuperContestCombosDao.class).clone();
        superContestCombosDaoConfig.initIdentityScope(type);

        encounterSlotsDaoConfig = daoConfigMap.get(EncounterSlotsDao.class).clone();
        encounterSlotsDaoConfig.initIdentityScope(type);

        conquestWarriorsDaoConfig = daoConfigMap.get(ConquestWarriorsDao.class).clone();
        conquestWarriorsDaoConfig.initIdentityScope(type);

        conquestWarriorArchetypesDaoConfig = daoConfigMap.get(ConquestWarriorArchetypesDao.class).clone();
        conquestWarriorArchetypesDaoConfig.initIdentityScope(type);

        evolutionTriggersDaoConfig = daoConfigMap.get(EvolutionTriggersDao.class).clone();
        evolutionTriggersDaoConfig.initIdentityScope(type);

        moveEffectChangelogDaoConfig = daoConfigMap.get(MoveEffectChangelogDao.class).clone();
        moveEffectChangelogDaoConfig.initIdentityScope(type);

        moveEffectsDaoConfig = daoConfigMap.get(MoveEffectsDao.class).clone();
        moveEffectsDaoConfig.initIdentityScope(type);

        evolutionChainsDaoConfig = daoConfigMap.get(EvolutionChainsDao.class).clone();
        evolutionChainsDaoConfig.initIdentityScope(type);

        itemsDaoConfig = daoConfigMap.get(ItemsDao.class).clone();
        itemsDaoConfig.initIdentityScope(type);

        experienceDaoConfig = daoConfigMap.get(ExperienceDao.class).clone();
        experienceDaoConfig.initIdentityScope(type);

        naturePokeathlonStatsDaoConfig = daoConfigMap.get(NaturePokeathlonStatsDao.class).clone();
        naturePokeathlonStatsDaoConfig.initIdentityScope(type);

        pokemonTypesDaoConfig = daoConfigMap.get(PokemonTypesDao.class).clone();
        pokemonTypesDaoConfig.initIdentityScope(type);

        conquestWarriorStatsDaoConfig = daoConfigMap.get(ConquestWarriorStatsDao.class).clone();
        conquestWarriorStatsDaoConfig.initIdentityScope(type);

        encounterMethodsDaoConfig = daoConfigMap.get(EncounterMethodsDao.class).clone();
        encounterMethodsDaoConfig.initIdentityScope(type);

        pokemonColorsDaoConfig = daoConfigMap.get(PokemonColorsDao.class).clone();
        pokemonColorsDaoConfig.initIdentityScope(type);

        moveDamageClassesDaoConfig = daoConfigMap.get(MoveDamageClassesDao.class).clone();
        moveDamageClassesDaoConfig.initIdentityScope(type);

        pokeathlonStatsDaoConfig = daoConfigMap.get(PokeathlonStatsDao.class).clone();
        pokeathlonStatsDaoConfig.initIdentityScope(type);

        contestCombosDaoConfig = daoConfigMap.get(ContestCombosDao.class).clone();
        contestCombosDaoConfig.initIdentityScope(type);

        palParkAreasDaoConfig = daoConfigMap.get(PalParkAreasDao.class).clone();
        palParkAreasDaoConfig.initIdentityScope(type);

        moveTargetsDaoConfig = daoConfigMap.get(MoveTargetsDao.class).clone();
        moveTargetsDaoConfig.initIdentityScope(type);

        growthRatesDaoConfig = daoConfigMap.get(GrowthRatesDao.class).clone();
        growthRatesDaoConfig.initIdentityScope(type);

        contestEffectsDaoConfig = daoConfigMap.get(ContestEffectsDao.class).clone();
        contestEffectsDaoConfig.initIdentityScope(type);

        moveMetaAilmentsDaoConfig = daoConfigMap.get(MoveMetaAilmentsDao.class).clone();
        moveMetaAilmentsDaoConfig.initIdentityScope(type);

        versionsDaoConfig = daoConfigMap.get(VersionsDao.class).clone();
        versionsDaoConfig.initIdentityScope(type);

        moveFlagsDaoConfig = daoConfigMap.get(MoveFlagsDao.class).clone();
        moveFlagsDaoConfig.initIdentityScope(type);

        gendersDaoConfig = daoConfigMap.get(GendersDao.class).clone();
        gendersDaoConfig.initIdentityScope(type);

        pokemonHabitatsDaoConfig = daoConfigMap.get(PokemonHabitatsDao.class).clone();
        pokemonHabitatsDaoConfig.initIdentityScope(type);

        locationsDaoConfig = daoConfigMap.get(LocationsDao.class).clone();
        locationsDaoConfig.initIdentityScope(type);

        regionsDaoConfig = daoConfigMap.get(RegionsDao.class).clone();
        regionsDaoConfig.initIdentityScope(type);

        superContestEffectsDaoConfig = daoConfigMap.get(SuperContestEffectsDao.class).clone();
        superContestEffectsDaoConfig.initIdentityScope(type);

        conquestMoveRangesDaoConfig = daoConfigMap.get(ConquestMoveRangesDao.class).clone();
        conquestMoveRangesDaoConfig.initIdentityScope(type);

        conquestStatsDaoConfig = daoConfigMap.get(ConquestStatsDao.class).clone();
        conquestStatsDaoConfig.initIdentityScope(type);

        itemFlingEffectsDaoConfig = daoConfigMap.get(ItemFlingEffectsDao.class).clone();
        itemFlingEffectsDaoConfig.initIdentityScope(type);

        typeEfficacyDao = new TypeEfficacyDao(typeEfficacyDaoConfig, this);
        conquestPokemonStatsDao = new ConquestPokemonStatsDao(conquestPokemonStatsDaoConfig, this);
        abilityNamesDao = new AbilityNamesDao(abilityNamesDaoConfig, this);
        abilityFlavorTextDao = new AbilityFlavorTextDao(abilityFlavorTextDaoConfig, this);
        abilityProseDao = new AbilityProseDao(abilityProseDaoConfig, this);
        abilityChangelogDao = new AbilityChangelogDao(abilityChangelogDaoConfig, this);
        pokemonAbilitiesDao = new PokemonAbilitiesDao(pokemonAbilitiesDaoConfig, this);
        conquestPokemonAbilitiesDao = new ConquestPokemonAbilitiesDao(conquestPokemonAbilitiesDaoConfig, this);
        abilitiesDao = new AbilitiesDao(abilitiesDaoConfig, this);
        moveFlagProseDao = new MoveFlagProseDao(moveFlagProseDaoConfig, this);
        conquestPokemonEvolutionDao = new ConquestPokemonEvolutionDao(conquestPokemonEvolutionDaoConfig, this);
        conquestMoveDataDao = new ConquestMoveDataDao(conquestMoveDataDaoConfig, this);
        conquestMoveEffectProseDao = new ConquestMoveEffectProseDao(conquestMoveEffectProseDaoConfig, this);
        conquestMoveEffectsDao = new ConquestMoveEffectsDao(conquestMoveEffectsDaoConfig, this);
        pokemonDexNumbersDao = new PokemonDexNumbersDao(pokemonDexNumbersDaoConfig, this);
        pokedexVersionGroupsDao = new PokedexVersionGroupsDao(pokedexVersionGroupsDaoConfig, this);
        pokedexProseDao = new PokedexProseDao(pokedexProseDaoConfig, this);
        pokedexesDao = new PokedexesDao(pokedexesDaoConfig, this);
        locationAreaProseDao = new LocationAreaProseDao(locationAreaProseDaoConfig, this);
        encounterConditionValueMapDao = new EncounterConditionValueMapDao(encounterConditionValueMapDaoConfig, this);
        encountersDao = new EncountersDao(encountersDaoConfig, this);
        locationAreaEncounterRatesDao = new LocationAreaEncounterRatesDao(locationAreaEncounterRatesDaoConfig, this);
        locationAreasDao = new LocationAreasDao(locationAreasDaoConfig, this);
        versionGroupPokemonMoveMethodsDao = new VersionGroupPokemonMoveMethodsDao(versionGroupPokemonMoveMethodsDaoConfig, this);
        conquestStatNamesDao = new ConquestStatNamesDao(conquestStatNamesDaoConfig, this);
        moveMetaCategoryProseDao = new MoveMetaCategoryProseDao(moveMetaCategoryProseDaoConfig, this);
        moveMetaDao = new MoveMetaDao(moveMetaDaoConfig, this);
        moveMetaCategoriesDao = new MoveMetaCategoriesDao(moveMetaCategoriesDaoConfig, this);
        pokemonSpeciesFlavorSummariesDao = new PokemonSpeciesFlavorSummariesDao(pokemonSpeciesFlavorSummariesDaoConfig, this);
        pokemonEggGroupsDao = new PokemonEggGroupsDao(pokemonEggGroupsDaoConfig, this);
        pokemonEvolutionDao = new PokemonEvolutionDao(pokemonEvolutionDaoConfig, this);
        conquestPokemonMovesDao = new ConquestPokemonMovesDao(conquestPokemonMovesDaoConfig, this);
        conquestTransformationPokemonDao = new ConquestTransformationPokemonDao(conquestTransformationPokemonDaoConfig, this);
        pokemonMovesDao = new PokemonMovesDao(pokemonMovesDaoConfig, this);
        pokemonGameIndicesDao = new PokemonGameIndicesDao(pokemonGameIndicesDaoConfig, this);
        pokemonStatsDao = new PokemonStatsDao(pokemonStatsDaoConfig, this);
        pokemonDao = new PokemonDao(pokemonDaoConfig, this);
        palParkDao = new PalParkDao(palParkDaoConfig, this);
        pokemonSpeciesProseDao = new PokemonSpeciesProseDao(pokemonSpeciesProseDaoConfig, this);
        pokemonSpeciesFlavorTextDao = new PokemonSpeciesFlavorTextDao(pokemonSpeciesFlavorTextDaoConfig, this);
        conquestMaxLinksDao = new ConquestMaxLinksDao(conquestMaxLinksDaoConfig, this);
        pokemonSpeciesNamesDao = new PokemonSpeciesNamesDao(pokemonSpeciesNamesDaoConfig, this);
        pokemonSpeciesDao = new PokemonSpeciesDao(pokemonSpeciesDaoConfig, this);
        pokemonShapeProseDao = new PokemonShapeProseDao(pokemonShapeProseDaoConfig, this);
        pokemonShapesDao = new PokemonShapesDao(pokemonShapesDaoConfig, this);
        conquestTransformationWarriorsDao = new ConquestTransformationWarriorsDao(conquestTransformationWarriorsDaoConfig, this);
        pokemonItemsDao = new PokemonItemsDao(pokemonItemsDaoConfig, this);
        moveFlavorSummariesDao = new MoveFlavorSummariesDao(moveFlavorSummariesDaoConfig, this);
        abilityChangelogProseDao = new AbilityChangelogProseDao(abilityChangelogProseDaoConfig, this);
        statNamesDao = new StatNamesDao(statNamesDaoConfig, this);
        moveBattleStyleProseDao = new MoveBattleStyleProseDao(moveBattleStyleProseDaoConfig, this);
        contestEffectProseDao = new ContestEffectProseDao(contestEffectProseDaoConfig, this);
        moveDamageClassProseDao = new MoveDamageClassProseDao(moveDamageClassProseDaoConfig, this);
        regionNamesDao = new RegionNamesDao(regionNamesDaoConfig, this);
        growthRateProseDao = new GrowthRateProseDao(growthRateProseDaoConfig, this);
        itemCategoryProseDao = new ItemCategoryProseDao(itemCategoryProseDaoConfig, this);
        moveNamesDao = new MoveNamesDao(moveNamesDaoConfig, this);
        encounterConditionValueProseDao = new EncounterConditionValueProseDao(encounterConditionValueProseDaoConfig, this);
        contestTypeNamesDao = new ContestTypeNamesDao(contestTypeNamesDaoConfig, this);
        pokemonMoveMethodProseDao = new PokemonMoveMethodProseDao(pokemonMoveMethodProseDaoConfig, this);
        conquestEpisodeNamesDao = new ConquestEpisodeNamesDao(conquestEpisodeNamesDaoConfig, this);
        conquestWarriorNamesDao = new ConquestWarriorNamesDao(conquestWarriorNamesDaoConfig, this);
        palParkAreaNamesDao = new PalParkAreaNamesDao(palParkAreaNamesDaoConfig, this);
        itemNamesDao = new ItemNamesDao(itemNamesDaoConfig, this);
        encounterConditionProseDao = new EncounterConditionProseDao(encounterConditionProseDaoConfig, this);
        superContestEffectProseDao = new SuperContestEffectProseDao(superContestEffectProseDaoConfig, this);
        itemFlavorSummariesDao = new ItemFlavorSummariesDao(itemFlavorSummariesDaoConfig, this);
        conquestWarriorSkillNamesDao = new ConquestWarriorSkillNamesDao(conquestWarriorSkillNamesDaoConfig, this);
        conquestKingdomNamesDao = new ConquestKingdomNamesDao(conquestKingdomNamesDaoConfig, this);
        generationNamesDao = new GenerationNamesDao(generationNamesDaoConfig, this);
        moveFlavorTextDao = new MoveFlavorTextDao(moveFlavorTextDaoConfig, this);
        versionNamesDao = new VersionNamesDao(versionNamesDaoConfig, this);
        itemFlavorTextDao = new ItemFlavorTextDao(itemFlavorTextDaoConfig, this);
        moveMetaAilmentNamesDao = new MoveMetaAilmentNamesDao(moveMetaAilmentNamesDaoConfig, this);
        pokemonHabitatNamesDao = new PokemonHabitatNamesDao(pokemonHabitatNamesDaoConfig, this);
        moveTargetProseDao = new MoveTargetProseDao(moveTargetProseDaoConfig, this);
        conquestMoveDisplacementProseDao = new ConquestMoveDisplacementProseDao(conquestMoveDisplacementProseDaoConfig, this);
        statHintNamesDao = new StatHintNamesDao(statHintNamesDaoConfig, this);
        itemFlagProseDao = new ItemFlagProseDao(itemFlagProseDaoConfig, this);
        locationNamesDao = new LocationNamesDao(locationNamesDaoConfig, this);
        evolutionTriggerProseDao = new EvolutionTriggerProseDao(evolutionTriggerProseDaoConfig, this);
        berryFirmnessNamesDao = new BerryFirmnessNamesDao(berryFirmnessNamesDaoConfig, this);
        itemPocketNamesDao = new ItemPocketNamesDao(itemPocketNamesDaoConfig, this);
        itemProseDao = new ItemProseDao(itemProseDaoConfig, this);
        conquestWarriorStatNamesDao = new ConquestWarriorStatNamesDao(conquestWarriorStatNamesDaoConfig, this);
        eggGroupProseDao = new EggGroupProseDao(eggGroupProseDaoConfig, this);
        moveEffectProseDao = new MoveEffectProseDao(moveEffectProseDaoConfig, this);
        conquestMoveRangeProseDao = new ConquestMoveRangeProseDao(conquestMoveRangeProseDaoConfig, this);
        natureNamesDao = new NatureNamesDao(natureNamesDaoConfig, this);
        itemFlingEffectProseDao = new ItemFlingEffectProseDao(itemFlingEffectProseDaoConfig, this);
        encounterMethodProseDao = new EncounterMethodProseDao(encounterMethodProseDaoConfig, this);
        typeNamesDao = new TypeNamesDao(typeNamesDaoConfig, this);
        pokemonColorNamesDao = new PokemonColorNamesDao(pokemonColorNamesDaoConfig, this);
        pokemonFormNamesDao = new PokemonFormNamesDao(pokemonFormNamesDaoConfig, this);
        languageNamesDao = new LanguageNamesDao(languageNamesDaoConfig, this);
        pokeathlonStatNamesDao = new PokeathlonStatNamesDao(pokeathlonStatNamesDaoConfig, this);
        moveEffectChangelogProseDao = new MoveEffectChangelogProseDao(moveEffectChangelogProseDaoConfig, this);
        languagesDao = new LanguagesDao(languagesDaoConfig, this);
        pokemonFormGenerationsDao = new PokemonFormGenerationsDao(pokemonFormGenerationsDaoConfig, this);
        encounterConditionValuesDao = new EncounterConditionValuesDao(encounterConditionValuesDaoConfig, this);
        conquestMoveDisplacementsDao = new ConquestMoveDisplacementsDao(conquestMoveDisplacementsDaoConfig, this);
        conquestWarriorRankStatMapDao = new ConquestWarriorRankStatMapDao(conquestWarriorRankStatMapDaoConfig, this);
        conquestWarriorTransformationDao = new ConquestWarriorTransformationDao(conquestWarriorTransformationDaoConfig, this);
        conquestWarriorRanksDao = new ConquestWarriorRanksDao(conquestWarriorRanksDaoConfig, this);
        moveFlagMapDao = new MoveFlagMapDao(moveFlagMapDaoConfig, this);
        locationGameIndicesDao = new LocationGameIndicesDao(locationGameIndicesDaoConfig, this);
        itemGameIndicesDao = new ItemGameIndicesDao(itemGameIndicesDaoConfig, this);
        movesDao = new MovesDao(movesDaoConfig, this);
        conquestKingdomsDao = new ConquestKingdomsDao(conquestKingdomsDaoConfig, this);
        conquestWarriorSpecialtiesDao = new ConquestWarriorSpecialtiesDao(conquestWarriorSpecialtiesDaoConfig, this);
        typeGameIndicesDao = new TypeGameIndicesDao(typeGameIndicesDaoConfig, this);
        berriesDao = new BerriesDao(berriesDaoConfig, this);
        typesDao = new TypesDao(typesDaoConfig, this);
        versionGroupRegionsDao = new VersionGroupRegionsDao(versionGroupRegionsDaoConfig, this);
        versionGroupsDao = new VersionGroupsDao(versionGroupsDaoConfig, this);
        generationsDao = new GenerationsDao(generationsDaoConfig, this);
        pokemonFormPokeathlonStatsDao = new PokemonFormPokeathlonStatsDao(pokemonFormPokeathlonStatsDaoConfig, this);
        pokemonFormsDao = new PokemonFormsDao(pokemonFormsDaoConfig, this);
        berryFirmnessDao = new BerryFirmnessDao(berryFirmnessDaoConfig, this);
        pokemonMoveMethodsDao = new PokemonMoveMethodsDao(pokemonMoveMethodsDaoConfig, this);
        moveMetaStatChangesDao = new MoveMetaStatChangesDao(moveMetaStatChangesDaoConfig, this);
        conquestEpisodeWarriorsDao = new ConquestEpisodeWarriorsDao(conquestEpisodeWarriorsDaoConfig, this);
        conquestEpisodesDao = new ConquestEpisodesDao(conquestEpisodesDaoConfig, this);
        natureBattleStylePreferencesDao = new NatureBattleStylePreferencesDao(natureBattleStylePreferencesDaoConfig, this);
        moveBattleStylesDao = new MoveBattleStylesDao(moveBattleStylesDaoConfig, this);
        machinesDao = new MachinesDao(machinesDaoConfig, this);
        eggGroupsDao = new EggGroupsDao(eggGroupsDaoConfig, this);
        statHintsDao = new StatHintsDao(statHintsDaoConfig, this);
        naturesDao = new NaturesDao(naturesDaoConfig, this);
        statsDao = new StatsDao(statsDaoConfig, this);
        encounterConditionsDao = new EncounterConditionsDao(encounterConditionsDaoConfig, this);
        moveChangelogDao = new MoveChangelogDao(moveChangelogDaoConfig, this);
        conquestWarriorSkillsDao = new ConquestWarriorSkillsDao(conquestWarriorSkillsDaoConfig, this);
        itemFlagMapDao = new ItemFlagMapDao(itemFlagMapDaoConfig, this);
        itemFlagsDao = new ItemFlagsDao(itemFlagsDaoConfig, this);
        itemCategoriesDao = new ItemCategoriesDao(itemCategoriesDaoConfig, this);
        itemPocketsDao = new ItemPocketsDao(itemPocketsDaoConfig, this);
        berryFlavorsDao = new BerryFlavorsDao(berryFlavorsDaoConfig, this);
        contestTypesDao = new ContestTypesDao(contestTypesDaoConfig, this);
        superContestCombosDao = new SuperContestCombosDao(superContestCombosDaoConfig, this);
        encounterSlotsDao = new EncounterSlotsDao(encounterSlotsDaoConfig, this);
        conquestWarriorsDao = new ConquestWarriorsDao(conquestWarriorsDaoConfig, this);
        conquestWarriorArchetypesDao = new ConquestWarriorArchetypesDao(conquestWarriorArchetypesDaoConfig, this);
        evolutionTriggersDao = new EvolutionTriggersDao(evolutionTriggersDaoConfig, this);
        moveEffectChangelogDao = new MoveEffectChangelogDao(moveEffectChangelogDaoConfig, this);
        moveEffectsDao = new MoveEffectsDao(moveEffectsDaoConfig, this);
        evolutionChainsDao = new EvolutionChainsDao(evolutionChainsDaoConfig, this);
        itemsDao = new ItemsDao(itemsDaoConfig, this);
        experienceDao = new ExperienceDao(experienceDaoConfig, this);
        naturePokeathlonStatsDao = new NaturePokeathlonStatsDao(naturePokeathlonStatsDaoConfig, this);
        pokemonTypesDao = new PokemonTypesDao(pokemonTypesDaoConfig, this);
        conquestWarriorStatsDao = new ConquestWarriorStatsDao(conquestWarriorStatsDaoConfig, this);
        encounterMethodsDao = new EncounterMethodsDao(encounterMethodsDaoConfig, this);
        pokemonColorsDao = new PokemonColorsDao(pokemonColorsDaoConfig, this);
        moveDamageClassesDao = new MoveDamageClassesDao(moveDamageClassesDaoConfig, this);
        pokeathlonStatsDao = new PokeathlonStatsDao(pokeathlonStatsDaoConfig, this);
        contestCombosDao = new ContestCombosDao(contestCombosDaoConfig, this);
        palParkAreasDao = new PalParkAreasDao(palParkAreasDaoConfig, this);
        moveTargetsDao = new MoveTargetsDao(moveTargetsDaoConfig, this);
        growthRatesDao = new GrowthRatesDao(growthRatesDaoConfig, this);
        contestEffectsDao = new ContestEffectsDao(contestEffectsDaoConfig, this);
        moveMetaAilmentsDao = new MoveMetaAilmentsDao(moveMetaAilmentsDaoConfig, this);
        versionsDao = new VersionsDao(versionsDaoConfig, this);
        moveFlagsDao = new MoveFlagsDao(moveFlagsDaoConfig, this);
        gendersDao = new GendersDao(gendersDaoConfig, this);
        pokemonHabitatsDao = new PokemonHabitatsDao(pokemonHabitatsDaoConfig, this);
        locationsDao = new LocationsDao(locationsDaoConfig, this);
        regionsDao = new RegionsDao(regionsDaoConfig, this);
        superContestEffectsDao = new SuperContestEffectsDao(superContestEffectsDaoConfig, this);
        conquestMoveRangesDao = new ConquestMoveRangesDao(conquestMoveRangesDaoConfig, this);
        conquestStatsDao = new ConquestStatsDao(conquestStatsDaoConfig, this);
        itemFlingEffectsDao = new ItemFlingEffectsDao(itemFlingEffectsDaoConfig, this);

        registerDao(TypeEfficacy.class, typeEfficacyDao);
        registerDao(ConquestPokemonStats.class, conquestPokemonStatsDao);
        registerDao(AbilityNames.class, abilityNamesDao);
        registerDao(AbilityFlavorText.class, abilityFlavorTextDao);
        registerDao(AbilityProse.class, abilityProseDao);
        registerDao(AbilityChangelog.class, abilityChangelogDao);
        registerDao(PokemonAbilities.class, pokemonAbilitiesDao);
        registerDao(ConquestPokemonAbilities.class, conquestPokemonAbilitiesDao);
        registerDao(Abilities.class, abilitiesDao);
        registerDao(MoveFlagProse.class, moveFlagProseDao);
        registerDao(ConquestPokemonEvolution.class, conquestPokemonEvolutionDao);
        registerDao(ConquestMoveData.class, conquestMoveDataDao);
        registerDao(ConquestMoveEffectProse.class, conquestMoveEffectProseDao);
        registerDao(ConquestMoveEffects.class, conquestMoveEffectsDao);
        registerDao(PokemonDexNumbers.class, pokemonDexNumbersDao);
        registerDao(PokedexVersionGroups.class, pokedexVersionGroupsDao);
        registerDao(PokedexProse.class, pokedexProseDao);
        registerDao(Pokedexes.class, pokedexesDao);
        registerDao(LocationAreaProse.class, locationAreaProseDao);
        registerDao(EncounterConditionValueMap.class, encounterConditionValueMapDao);
        registerDao(Encounters.class, encountersDao);
        registerDao(LocationAreaEncounterRates.class, locationAreaEncounterRatesDao);
        registerDao(LocationAreas.class, locationAreasDao);
        registerDao(VersionGroupPokemonMoveMethods.class, versionGroupPokemonMoveMethodsDao);
        registerDao(ConquestStatNames.class, conquestStatNamesDao);
        registerDao(MoveMetaCategoryProse.class, moveMetaCategoryProseDao);
        registerDao(MoveMeta.class, moveMetaDao);
        registerDao(MoveMetaCategories.class, moveMetaCategoriesDao);
        registerDao(PokemonSpeciesFlavorSummaries.class, pokemonSpeciesFlavorSummariesDao);
        registerDao(PokemonEggGroups.class, pokemonEggGroupsDao);
        registerDao(PokemonEvolution.class, pokemonEvolutionDao);
        registerDao(ConquestPokemonMoves.class, conquestPokemonMovesDao);
        registerDao(ConquestTransformationPokemon.class, conquestTransformationPokemonDao);
        registerDao(PokemonMoves.class, pokemonMovesDao);
        registerDao(PokemonGameIndices.class, pokemonGameIndicesDao);
        registerDao(PokemonStats.class, pokemonStatsDao);
        registerDao(Pokemon.class, pokemonDao);
        registerDao(PalPark.class, palParkDao);
        registerDao(PokemonSpeciesProse.class, pokemonSpeciesProseDao);
        registerDao(PokemonSpeciesFlavorText.class, pokemonSpeciesFlavorTextDao);
        registerDao(ConquestMaxLinks.class, conquestMaxLinksDao);
        registerDao(PokemonSpeciesNames.class, pokemonSpeciesNamesDao);
        registerDao(PokemonSpecies.class, pokemonSpeciesDao);
        registerDao(PokemonShapeProse.class, pokemonShapeProseDao);
        registerDao(PokemonShapes.class, pokemonShapesDao);
        registerDao(ConquestTransformationWarriors.class, conquestTransformationWarriorsDao);
        registerDao(PokemonItems.class, pokemonItemsDao);
        registerDao(MoveFlavorSummaries.class, moveFlavorSummariesDao);
        registerDao(AbilityChangelogProse.class, abilityChangelogProseDao);
        registerDao(StatNames.class, statNamesDao);
        registerDao(MoveBattleStyleProse.class, moveBattleStyleProseDao);
        registerDao(ContestEffectProse.class, contestEffectProseDao);
        registerDao(MoveDamageClassProse.class, moveDamageClassProseDao);
        registerDao(RegionNames.class, regionNamesDao);
        registerDao(GrowthRateProse.class, growthRateProseDao);
        registerDao(ItemCategoryProse.class, itemCategoryProseDao);
        registerDao(MoveNames.class, moveNamesDao);
        registerDao(EncounterConditionValueProse.class, encounterConditionValueProseDao);
        registerDao(ContestTypeNames.class, contestTypeNamesDao);
        registerDao(PokemonMoveMethodProse.class, pokemonMoveMethodProseDao);
        registerDao(ConquestEpisodeNames.class, conquestEpisodeNamesDao);
        registerDao(ConquestWarriorNames.class, conquestWarriorNamesDao);
        registerDao(PalParkAreaNames.class, palParkAreaNamesDao);
        registerDao(ItemNames.class, itemNamesDao);
        registerDao(EncounterConditionProse.class, encounterConditionProseDao);
        registerDao(SuperContestEffectProse.class, superContestEffectProseDao);
        registerDao(ItemFlavorSummaries.class, itemFlavorSummariesDao);
        registerDao(ConquestWarriorSkillNames.class, conquestWarriorSkillNamesDao);
        registerDao(ConquestKingdomNames.class, conquestKingdomNamesDao);
        registerDao(GenerationNames.class, generationNamesDao);
        registerDao(MoveFlavorText.class, moveFlavorTextDao);
        registerDao(VersionNames.class, versionNamesDao);
        registerDao(ItemFlavorText.class, itemFlavorTextDao);
        registerDao(MoveMetaAilmentNames.class, moveMetaAilmentNamesDao);
        registerDao(PokemonHabitatNames.class, pokemonHabitatNamesDao);
        registerDao(MoveTargetProse.class, moveTargetProseDao);
        registerDao(ConquestMoveDisplacementProse.class, conquestMoveDisplacementProseDao);
        registerDao(StatHintNames.class, statHintNamesDao);
        registerDao(ItemFlagProse.class, itemFlagProseDao);
        registerDao(LocationNames.class, locationNamesDao);
        registerDao(EvolutionTriggerProse.class, evolutionTriggerProseDao);
        registerDao(BerryFirmnessNames.class, berryFirmnessNamesDao);
        registerDao(ItemPocketNames.class, itemPocketNamesDao);
        registerDao(ItemProse.class, itemProseDao);
        registerDao(ConquestWarriorStatNames.class, conquestWarriorStatNamesDao);
        registerDao(EggGroupProse.class, eggGroupProseDao);
        registerDao(MoveEffectProse.class, moveEffectProseDao);
        registerDao(ConquestMoveRangeProse.class, conquestMoveRangeProseDao);
        registerDao(NatureNames.class, natureNamesDao);
        registerDao(ItemFlingEffectProse.class, itemFlingEffectProseDao);
        registerDao(EncounterMethodProse.class, encounterMethodProseDao);
        registerDao(TypeNames.class, typeNamesDao);
        registerDao(PokemonColorNames.class, pokemonColorNamesDao);
        registerDao(PokemonFormNames.class, pokemonFormNamesDao);
        registerDao(LanguageNames.class, languageNamesDao);
        registerDao(PokeathlonStatNames.class, pokeathlonStatNamesDao);
        registerDao(MoveEffectChangelogProse.class, moveEffectChangelogProseDao);
        registerDao(Languages.class, languagesDao);
        registerDao(PokemonFormGenerations.class, pokemonFormGenerationsDao);
        registerDao(EncounterConditionValues.class, encounterConditionValuesDao);
        registerDao(ConquestMoveDisplacements.class, conquestMoveDisplacementsDao);
        registerDao(ConquestWarriorRankStatMap.class, conquestWarriorRankStatMapDao);
        registerDao(ConquestWarriorTransformation.class, conquestWarriorTransformationDao);
        registerDao(ConquestWarriorRanks.class, conquestWarriorRanksDao);
        registerDao(MoveFlagMap.class, moveFlagMapDao);
        registerDao(LocationGameIndices.class, locationGameIndicesDao);
        registerDao(ItemGameIndices.class, itemGameIndicesDao);
        registerDao(Moves.class, movesDao);
        registerDao(ConquestKingdoms.class, conquestKingdomsDao);
        registerDao(ConquestWarriorSpecialties.class, conquestWarriorSpecialtiesDao);
        registerDao(TypeGameIndices.class, typeGameIndicesDao);
        registerDao(Berries.class, berriesDao);
        registerDao(Types.class, typesDao);
        registerDao(VersionGroupRegions.class, versionGroupRegionsDao);
        registerDao(VersionGroups.class, versionGroupsDao);
        registerDao(Generations.class, generationsDao);
        registerDao(PokemonFormPokeathlonStats.class, pokemonFormPokeathlonStatsDao);
        registerDao(PokemonForms.class, pokemonFormsDao);
        registerDao(BerryFirmness.class, berryFirmnessDao);
        registerDao(PokemonMoveMethods.class, pokemonMoveMethodsDao);
        registerDao(MoveMetaStatChanges.class, moveMetaStatChangesDao);
        registerDao(ConquestEpisodeWarriors.class, conquestEpisodeWarriorsDao);
        registerDao(ConquestEpisodes.class, conquestEpisodesDao);
        registerDao(NatureBattleStylePreferences.class, natureBattleStylePreferencesDao);
        registerDao(MoveBattleStyles.class, moveBattleStylesDao);
        registerDao(Machines.class, machinesDao);
        registerDao(EggGroups.class, eggGroupsDao);
        registerDao(StatHints.class, statHintsDao);
        registerDao(Natures.class, naturesDao);
        registerDao(Stats.class, statsDao);
        registerDao(EncounterConditions.class, encounterConditionsDao);
        registerDao(MoveChangelog.class, moveChangelogDao);
        registerDao(ConquestWarriorSkills.class, conquestWarriorSkillsDao);
        registerDao(ItemFlagMap.class, itemFlagMapDao);
        registerDao(ItemFlags.class, itemFlagsDao);
        registerDao(ItemCategories.class, itemCategoriesDao);
        registerDao(ItemPockets.class, itemPocketsDao);
        registerDao(BerryFlavors.class, berryFlavorsDao);
        registerDao(ContestTypes.class, contestTypesDao);
        registerDao(SuperContestCombos.class, superContestCombosDao);
        registerDao(EncounterSlots.class, encounterSlotsDao);
        registerDao(ConquestWarriors.class, conquestWarriorsDao);
        registerDao(ConquestWarriorArchetypes.class, conquestWarriorArchetypesDao);
        registerDao(EvolutionTriggers.class, evolutionTriggersDao);
        registerDao(MoveEffectChangelog.class, moveEffectChangelogDao);
        registerDao(MoveEffects.class, moveEffectsDao);
        registerDao(EvolutionChains.class, evolutionChainsDao);
        registerDao(Items.class, itemsDao);
        registerDao(Experience.class, experienceDao);
        registerDao(NaturePokeathlonStats.class, naturePokeathlonStatsDao);
        registerDao(PokemonTypes.class, pokemonTypesDao);
        registerDao(ConquestWarriorStats.class, conquestWarriorStatsDao);
        registerDao(EncounterMethods.class, encounterMethodsDao);
        registerDao(PokemonColors.class, pokemonColorsDao);
        registerDao(MoveDamageClasses.class, moveDamageClassesDao);
        registerDao(PokeathlonStats.class, pokeathlonStatsDao);
        registerDao(ContestCombos.class, contestCombosDao);
        registerDao(PalParkAreas.class, palParkAreasDao);
        registerDao(MoveTargets.class, moveTargetsDao);
        registerDao(GrowthRates.class, growthRatesDao);
        registerDao(ContestEffects.class, contestEffectsDao);
        registerDao(MoveMetaAilments.class, moveMetaAilmentsDao);
        registerDao(Versions.class, versionsDao);
        registerDao(MoveFlags.class, moveFlagsDao);
        registerDao(Genders.class, gendersDao);
        registerDao(PokemonHabitats.class, pokemonHabitatsDao);
        registerDao(Locations.class, locationsDao);
        registerDao(Regions.class, regionsDao);
        registerDao(SuperContestEffects.class, superContestEffectsDao);
        registerDao(ConquestMoveRanges.class, conquestMoveRangesDao);
        registerDao(ConquestStats.class, conquestStatsDao);
        registerDao(ItemFlingEffects.class, itemFlingEffectsDao);
    }
    
    public void clear() {
        typeEfficacyDaoConfig.getIdentityScope().clear();
        conquestPokemonStatsDaoConfig.getIdentityScope().clear();
        abilityNamesDaoConfig.getIdentityScope().clear();
        abilityFlavorTextDaoConfig.getIdentityScope().clear();
        abilityProseDaoConfig.getIdentityScope().clear();
        abilityChangelogDaoConfig.getIdentityScope().clear();
        pokemonAbilitiesDaoConfig.getIdentityScope().clear();
        conquestPokemonAbilitiesDaoConfig.getIdentityScope().clear();
        abilitiesDaoConfig.getIdentityScope().clear();
        moveFlagProseDaoConfig.getIdentityScope().clear();
        conquestPokemonEvolutionDaoConfig.getIdentityScope().clear();
        conquestMoveDataDaoConfig.getIdentityScope().clear();
        conquestMoveEffectProseDaoConfig.getIdentityScope().clear();
        conquestMoveEffectsDaoConfig.getIdentityScope().clear();
        pokemonDexNumbersDaoConfig.getIdentityScope().clear();
        pokedexVersionGroupsDaoConfig.getIdentityScope().clear();
        pokedexProseDaoConfig.getIdentityScope().clear();
        pokedexesDaoConfig.getIdentityScope().clear();
        locationAreaProseDaoConfig.getIdentityScope().clear();
        encounterConditionValueMapDaoConfig.getIdentityScope().clear();
        encountersDaoConfig.getIdentityScope().clear();
        locationAreaEncounterRatesDaoConfig.getIdentityScope().clear();
        locationAreasDaoConfig.getIdentityScope().clear();
        versionGroupPokemonMoveMethodsDaoConfig.getIdentityScope().clear();
        conquestStatNamesDaoConfig.getIdentityScope().clear();
        moveMetaCategoryProseDaoConfig.getIdentityScope().clear();
        moveMetaDaoConfig.getIdentityScope().clear();
        moveMetaCategoriesDaoConfig.getIdentityScope().clear();
        pokemonSpeciesFlavorSummariesDaoConfig.getIdentityScope().clear();
        pokemonEggGroupsDaoConfig.getIdentityScope().clear();
        pokemonEvolutionDaoConfig.getIdentityScope().clear();
        conquestPokemonMovesDaoConfig.getIdentityScope().clear();
        conquestTransformationPokemonDaoConfig.getIdentityScope().clear();
        pokemonMovesDaoConfig.getIdentityScope().clear();
        pokemonGameIndicesDaoConfig.getIdentityScope().clear();
        pokemonStatsDaoConfig.getIdentityScope().clear();
        pokemonDaoConfig.getIdentityScope().clear();
        palParkDaoConfig.getIdentityScope().clear();
        pokemonSpeciesProseDaoConfig.getIdentityScope().clear();
        pokemonSpeciesFlavorTextDaoConfig.getIdentityScope().clear();
        conquestMaxLinksDaoConfig.getIdentityScope().clear();
        pokemonSpeciesNamesDaoConfig.getIdentityScope().clear();
        pokemonSpeciesDaoConfig.getIdentityScope().clear();
        pokemonShapeProseDaoConfig.getIdentityScope().clear();
        pokemonShapesDaoConfig.getIdentityScope().clear();
        conquestTransformationWarriorsDaoConfig.getIdentityScope().clear();
        pokemonItemsDaoConfig.getIdentityScope().clear();
        moveFlavorSummariesDaoConfig.getIdentityScope().clear();
        abilityChangelogProseDaoConfig.getIdentityScope().clear();
        statNamesDaoConfig.getIdentityScope().clear();
        moveBattleStyleProseDaoConfig.getIdentityScope().clear();
        contestEffectProseDaoConfig.getIdentityScope().clear();
        moveDamageClassProseDaoConfig.getIdentityScope().clear();
        regionNamesDaoConfig.getIdentityScope().clear();
        growthRateProseDaoConfig.getIdentityScope().clear();
        itemCategoryProseDaoConfig.getIdentityScope().clear();
        moveNamesDaoConfig.getIdentityScope().clear();
        encounterConditionValueProseDaoConfig.getIdentityScope().clear();
        contestTypeNamesDaoConfig.getIdentityScope().clear();
        pokemonMoveMethodProseDaoConfig.getIdentityScope().clear();
        conquestEpisodeNamesDaoConfig.getIdentityScope().clear();
        conquestWarriorNamesDaoConfig.getIdentityScope().clear();
        palParkAreaNamesDaoConfig.getIdentityScope().clear();
        itemNamesDaoConfig.getIdentityScope().clear();
        encounterConditionProseDaoConfig.getIdentityScope().clear();
        superContestEffectProseDaoConfig.getIdentityScope().clear();
        itemFlavorSummariesDaoConfig.getIdentityScope().clear();
        conquestWarriorSkillNamesDaoConfig.getIdentityScope().clear();
        conquestKingdomNamesDaoConfig.getIdentityScope().clear();
        generationNamesDaoConfig.getIdentityScope().clear();
        moveFlavorTextDaoConfig.getIdentityScope().clear();
        versionNamesDaoConfig.getIdentityScope().clear();
        itemFlavorTextDaoConfig.getIdentityScope().clear();
        moveMetaAilmentNamesDaoConfig.getIdentityScope().clear();
        pokemonHabitatNamesDaoConfig.getIdentityScope().clear();
        moveTargetProseDaoConfig.getIdentityScope().clear();
        conquestMoveDisplacementProseDaoConfig.getIdentityScope().clear();
        statHintNamesDaoConfig.getIdentityScope().clear();
        itemFlagProseDaoConfig.getIdentityScope().clear();
        locationNamesDaoConfig.getIdentityScope().clear();
        evolutionTriggerProseDaoConfig.getIdentityScope().clear();
        berryFirmnessNamesDaoConfig.getIdentityScope().clear();
        itemPocketNamesDaoConfig.getIdentityScope().clear();
        itemProseDaoConfig.getIdentityScope().clear();
        conquestWarriorStatNamesDaoConfig.getIdentityScope().clear();
        eggGroupProseDaoConfig.getIdentityScope().clear();
        moveEffectProseDaoConfig.getIdentityScope().clear();
        conquestMoveRangeProseDaoConfig.getIdentityScope().clear();
        natureNamesDaoConfig.getIdentityScope().clear();
        itemFlingEffectProseDaoConfig.getIdentityScope().clear();
        encounterMethodProseDaoConfig.getIdentityScope().clear();
        typeNamesDaoConfig.getIdentityScope().clear();
        pokemonColorNamesDaoConfig.getIdentityScope().clear();
        pokemonFormNamesDaoConfig.getIdentityScope().clear();
        languageNamesDaoConfig.getIdentityScope().clear();
        pokeathlonStatNamesDaoConfig.getIdentityScope().clear();
        moveEffectChangelogProseDaoConfig.getIdentityScope().clear();
        languagesDaoConfig.getIdentityScope().clear();
        pokemonFormGenerationsDaoConfig.getIdentityScope().clear();
        encounterConditionValuesDaoConfig.getIdentityScope().clear();
        conquestMoveDisplacementsDaoConfig.getIdentityScope().clear();
        conquestWarriorRankStatMapDaoConfig.getIdentityScope().clear();
        conquestWarriorTransformationDaoConfig.getIdentityScope().clear();
        conquestWarriorRanksDaoConfig.getIdentityScope().clear();
        moveFlagMapDaoConfig.getIdentityScope().clear();
        locationGameIndicesDaoConfig.getIdentityScope().clear();
        itemGameIndicesDaoConfig.getIdentityScope().clear();
        movesDaoConfig.getIdentityScope().clear();
        conquestKingdomsDaoConfig.getIdentityScope().clear();
        conquestWarriorSpecialtiesDaoConfig.getIdentityScope().clear();
        typeGameIndicesDaoConfig.getIdentityScope().clear();
        berriesDaoConfig.getIdentityScope().clear();
        typesDaoConfig.getIdentityScope().clear();
        versionGroupRegionsDaoConfig.getIdentityScope().clear();
        versionGroupsDaoConfig.getIdentityScope().clear();
        generationsDaoConfig.getIdentityScope().clear();
        pokemonFormPokeathlonStatsDaoConfig.getIdentityScope().clear();
        pokemonFormsDaoConfig.getIdentityScope().clear();
        berryFirmnessDaoConfig.getIdentityScope().clear();
        pokemonMoveMethodsDaoConfig.getIdentityScope().clear();
        moveMetaStatChangesDaoConfig.getIdentityScope().clear();
        conquestEpisodeWarriorsDaoConfig.getIdentityScope().clear();
        conquestEpisodesDaoConfig.getIdentityScope().clear();
        natureBattleStylePreferencesDaoConfig.getIdentityScope().clear();
        moveBattleStylesDaoConfig.getIdentityScope().clear();
        machinesDaoConfig.getIdentityScope().clear();
        eggGroupsDaoConfig.getIdentityScope().clear();
        statHintsDaoConfig.getIdentityScope().clear();
        naturesDaoConfig.getIdentityScope().clear();
        statsDaoConfig.getIdentityScope().clear();
        encounterConditionsDaoConfig.getIdentityScope().clear();
        moveChangelogDaoConfig.getIdentityScope().clear();
        conquestWarriorSkillsDaoConfig.getIdentityScope().clear();
        itemFlagMapDaoConfig.getIdentityScope().clear();
        itemFlagsDaoConfig.getIdentityScope().clear();
        itemCategoriesDaoConfig.getIdentityScope().clear();
        itemPocketsDaoConfig.getIdentityScope().clear();
        berryFlavorsDaoConfig.getIdentityScope().clear();
        contestTypesDaoConfig.getIdentityScope().clear();
        superContestCombosDaoConfig.getIdentityScope().clear();
        encounterSlotsDaoConfig.getIdentityScope().clear();
        conquestWarriorsDaoConfig.getIdentityScope().clear();
        conquestWarriorArchetypesDaoConfig.getIdentityScope().clear();
        evolutionTriggersDaoConfig.getIdentityScope().clear();
        moveEffectChangelogDaoConfig.getIdentityScope().clear();
        moveEffectsDaoConfig.getIdentityScope().clear();
        evolutionChainsDaoConfig.getIdentityScope().clear();
        itemsDaoConfig.getIdentityScope().clear();
        experienceDaoConfig.getIdentityScope().clear();
        naturePokeathlonStatsDaoConfig.getIdentityScope().clear();
        pokemonTypesDaoConfig.getIdentityScope().clear();
        conquestWarriorStatsDaoConfig.getIdentityScope().clear();
        encounterMethodsDaoConfig.getIdentityScope().clear();
        pokemonColorsDaoConfig.getIdentityScope().clear();
        moveDamageClassesDaoConfig.getIdentityScope().clear();
        pokeathlonStatsDaoConfig.getIdentityScope().clear();
        contestCombosDaoConfig.getIdentityScope().clear();
        palParkAreasDaoConfig.getIdentityScope().clear();
        moveTargetsDaoConfig.getIdentityScope().clear();
        growthRatesDaoConfig.getIdentityScope().clear();
        contestEffectsDaoConfig.getIdentityScope().clear();
        moveMetaAilmentsDaoConfig.getIdentityScope().clear();
        versionsDaoConfig.getIdentityScope().clear();
        moveFlagsDaoConfig.getIdentityScope().clear();
        gendersDaoConfig.getIdentityScope().clear();
        pokemonHabitatsDaoConfig.getIdentityScope().clear();
        locationsDaoConfig.getIdentityScope().clear();
        regionsDaoConfig.getIdentityScope().clear();
        superContestEffectsDaoConfig.getIdentityScope().clear();
        conquestMoveRangesDaoConfig.getIdentityScope().clear();
        conquestStatsDaoConfig.getIdentityScope().clear();
        itemFlingEffectsDaoConfig.getIdentityScope().clear();
    }

    public TypeEfficacyDao getTypeEfficacyDao() {
        return typeEfficacyDao;
    }

    public ConquestPokemonStatsDao getConquestPokemonStatsDao() {
        return conquestPokemonStatsDao;
    }

    public AbilityNamesDao getAbilityNamesDao() {
        return abilityNamesDao;
    }

    public AbilityFlavorTextDao getAbilityFlavorTextDao() {
        return abilityFlavorTextDao;
    }

    public AbilityProseDao getAbilityProseDao() {
        return abilityProseDao;
    }

    public AbilityChangelogDao getAbilityChangelogDao() {
        return abilityChangelogDao;
    }

    public PokemonAbilitiesDao getPokemonAbilitiesDao() {
        return pokemonAbilitiesDao;
    }

    public ConquestPokemonAbilitiesDao getConquestPokemonAbilitiesDao() {
        return conquestPokemonAbilitiesDao;
    }

    public AbilitiesDao getAbilitiesDao() {
        return abilitiesDao;
    }

    public MoveFlagProseDao getMoveFlagProseDao() {
        return moveFlagProseDao;
    }

    public ConquestPokemonEvolutionDao getConquestPokemonEvolutionDao() {
        return conquestPokemonEvolutionDao;
    }

    public ConquestMoveDataDao getConquestMoveDataDao() {
        return conquestMoveDataDao;
    }

    public ConquestMoveEffectProseDao getConquestMoveEffectProseDao() {
        return conquestMoveEffectProseDao;
    }

    public ConquestMoveEffectsDao getConquestMoveEffectsDao() {
        return conquestMoveEffectsDao;
    }

    public PokemonDexNumbersDao getPokemonDexNumbersDao() {
        return pokemonDexNumbersDao;
    }

    public PokedexVersionGroupsDao getPokedexVersionGroupsDao() {
        return pokedexVersionGroupsDao;
    }

    public PokedexProseDao getPokedexProseDao() {
        return pokedexProseDao;
    }

    public PokedexesDao getPokedexesDao() {
        return pokedexesDao;
    }

    public LocationAreaProseDao getLocationAreaProseDao() {
        return locationAreaProseDao;
    }

    public EncounterConditionValueMapDao getEncounterConditionValueMapDao() {
        return encounterConditionValueMapDao;
    }

    public EncountersDao getEncountersDao() {
        return encountersDao;
    }

    public LocationAreaEncounterRatesDao getLocationAreaEncounterRatesDao() {
        return locationAreaEncounterRatesDao;
    }

    public LocationAreasDao getLocationAreasDao() {
        return locationAreasDao;
    }

    public VersionGroupPokemonMoveMethodsDao getVersionGroupPokemonMoveMethodsDao() {
        return versionGroupPokemonMoveMethodsDao;
    }

    public ConquestStatNamesDao getConquestStatNamesDao() {
        return conquestStatNamesDao;
    }

    public MoveMetaCategoryProseDao getMoveMetaCategoryProseDao() {
        return moveMetaCategoryProseDao;
    }

    public MoveMetaDao getMoveMetaDao() {
        return moveMetaDao;
    }

    public MoveMetaCategoriesDao getMoveMetaCategoriesDao() {
        return moveMetaCategoriesDao;
    }

    public PokemonSpeciesFlavorSummariesDao getPokemonSpeciesFlavorSummariesDao() {
        return pokemonSpeciesFlavorSummariesDao;
    }

    public PokemonEggGroupsDao getPokemonEggGroupsDao() {
        return pokemonEggGroupsDao;
    }

    public PokemonEvolutionDao getPokemonEvolutionDao() {
        return pokemonEvolutionDao;
    }

    public ConquestPokemonMovesDao getConquestPokemonMovesDao() {
        return conquestPokemonMovesDao;
    }

    public ConquestTransformationPokemonDao getConquestTransformationPokemonDao() {
        return conquestTransformationPokemonDao;
    }

    public PokemonMovesDao getPokemonMovesDao() {
        return pokemonMovesDao;
    }

    public PokemonGameIndicesDao getPokemonGameIndicesDao() {
        return pokemonGameIndicesDao;
    }

    public PokemonStatsDao getPokemonStatsDao() {
        return pokemonStatsDao;
    }

    public PokemonDao getPokemonDao() {
        return pokemonDao;
    }

    public PalParkDao getPalParkDao() {
        return palParkDao;
    }

    public PokemonSpeciesProseDao getPokemonSpeciesProseDao() {
        return pokemonSpeciesProseDao;
    }

    public PokemonSpeciesFlavorTextDao getPokemonSpeciesFlavorTextDao() {
        return pokemonSpeciesFlavorTextDao;
    }

    public ConquestMaxLinksDao getConquestMaxLinksDao() {
        return conquestMaxLinksDao;
    }

    public PokemonSpeciesNamesDao getPokemonSpeciesNamesDao() {
        return pokemonSpeciesNamesDao;
    }

    public PokemonSpeciesDao getPokemonSpeciesDao() {
        return pokemonSpeciesDao;
    }

    public PokemonShapeProseDao getPokemonShapeProseDao() {
        return pokemonShapeProseDao;
    }

    public PokemonShapesDao getPokemonShapesDao() {
        return pokemonShapesDao;
    }

    public ConquestTransformationWarriorsDao getConquestTransformationWarriorsDao() {
        return conquestTransformationWarriorsDao;
    }

    public PokemonItemsDao getPokemonItemsDao() {
        return pokemonItemsDao;
    }

    public MoveFlavorSummariesDao getMoveFlavorSummariesDao() {
        return moveFlavorSummariesDao;
    }

    public AbilityChangelogProseDao getAbilityChangelogProseDao() {
        return abilityChangelogProseDao;
    }

    public StatNamesDao getStatNamesDao() {
        return statNamesDao;
    }

    public MoveBattleStyleProseDao getMoveBattleStyleProseDao() {
        return moveBattleStyleProseDao;
    }

    public ContestEffectProseDao getContestEffectProseDao() {
        return contestEffectProseDao;
    }

    public MoveDamageClassProseDao getMoveDamageClassProseDao() {
        return moveDamageClassProseDao;
    }

    public RegionNamesDao getRegionNamesDao() {
        return regionNamesDao;
    }

    public GrowthRateProseDao getGrowthRateProseDao() {
        return growthRateProseDao;
    }

    public ItemCategoryProseDao getItemCategoryProseDao() {
        return itemCategoryProseDao;
    }

    public MoveNamesDao getMoveNamesDao() {
        return moveNamesDao;
    }

    public EncounterConditionValueProseDao getEncounterConditionValueProseDao() {
        return encounterConditionValueProseDao;
    }

    public ContestTypeNamesDao getContestTypeNamesDao() {
        return contestTypeNamesDao;
    }

    public PokemonMoveMethodProseDao getPokemonMoveMethodProseDao() {
        return pokemonMoveMethodProseDao;
    }

    public ConquestEpisodeNamesDao getConquestEpisodeNamesDao() {
        return conquestEpisodeNamesDao;
    }

    public ConquestWarriorNamesDao getConquestWarriorNamesDao() {
        return conquestWarriorNamesDao;
    }

    public PalParkAreaNamesDao getPalParkAreaNamesDao() {
        return palParkAreaNamesDao;
    }

    public ItemNamesDao getItemNamesDao() {
        return itemNamesDao;
    }

    public EncounterConditionProseDao getEncounterConditionProseDao() {
        return encounterConditionProseDao;
    }

    public SuperContestEffectProseDao getSuperContestEffectProseDao() {
        return superContestEffectProseDao;
    }

    public ItemFlavorSummariesDao getItemFlavorSummariesDao() {
        return itemFlavorSummariesDao;
    }

    public ConquestWarriorSkillNamesDao getConquestWarriorSkillNamesDao() {
        return conquestWarriorSkillNamesDao;
    }

    public ConquestKingdomNamesDao getConquestKingdomNamesDao() {
        return conquestKingdomNamesDao;
    }

    public GenerationNamesDao getGenerationNamesDao() {
        return generationNamesDao;
    }

    public MoveFlavorTextDao getMoveFlavorTextDao() {
        return moveFlavorTextDao;
    }

    public VersionNamesDao getVersionNamesDao() {
        return versionNamesDao;
    }

    public ItemFlavorTextDao getItemFlavorTextDao() {
        return itemFlavorTextDao;
    }

    public MoveMetaAilmentNamesDao getMoveMetaAilmentNamesDao() {
        return moveMetaAilmentNamesDao;
    }

    public PokemonHabitatNamesDao getPokemonHabitatNamesDao() {
        return pokemonHabitatNamesDao;
    }

    public MoveTargetProseDao getMoveTargetProseDao() {
        return moveTargetProseDao;
    }

    public ConquestMoveDisplacementProseDao getConquestMoveDisplacementProseDao() {
        return conquestMoveDisplacementProseDao;
    }

    public StatHintNamesDao getStatHintNamesDao() {
        return statHintNamesDao;
    }

    public ItemFlagProseDao getItemFlagProseDao() {
        return itemFlagProseDao;
    }

    public LocationNamesDao getLocationNamesDao() {
        return locationNamesDao;
    }

    public EvolutionTriggerProseDao getEvolutionTriggerProseDao() {
        return evolutionTriggerProseDao;
    }

    public BerryFirmnessNamesDao getBerryFirmnessNamesDao() {
        return berryFirmnessNamesDao;
    }

    public ItemPocketNamesDao getItemPocketNamesDao() {
        return itemPocketNamesDao;
    }

    public ItemProseDao getItemProseDao() {
        return itemProseDao;
    }

    public ConquestWarriorStatNamesDao getConquestWarriorStatNamesDao() {
        return conquestWarriorStatNamesDao;
    }

    public EggGroupProseDao getEggGroupProseDao() {
        return eggGroupProseDao;
    }

    public MoveEffectProseDao getMoveEffectProseDao() {
        return moveEffectProseDao;
    }

    public ConquestMoveRangeProseDao getConquestMoveRangeProseDao() {
        return conquestMoveRangeProseDao;
    }

    public NatureNamesDao getNatureNamesDao() {
        return natureNamesDao;
    }

    public ItemFlingEffectProseDao getItemFlingEffectProseDao() {
        return itemFlingEffectProseDao;
    }

    public EncounterMethodProseDao getEncounterMethodProseDao() {
        return encounterMethodProseDao;
    }

    public TypeNamesDao getTypeNamesDao() {
        return typeNamesDao;
    }

    public PokemonColorNamesDao getPokemonColorNamesDao() {
        return pokemonColorNamesDao;
    }

    public PokemonFormNamesDao getPokemonFormNamesDao() {
        return pokemonFormNamesDao;
    }

    public LanguageNamesDao getLanguageNamesDao() {
        return languageNamesDao;
    }

    public PokeathlonStatNamesDao getPokeathlonStatNamesDao() {
        return pokeathlonStatNamesDao;
    }

    public MoveEffectChangelogProseDao getMoveEffectChangelogProseDao() {
        return moveEffectChangelogProseDao;
    }

    public LanguagesDao getLanguagesDao() {
        return languagesDao;
    }

    public PokemonFormGenerationsDao getPokemonFormGenerationsDao() {
        return pokemonFormGenerationsDao;
    }

    public EncounterConditionValuesDao getEncounterConditionValuesDao() {
        return encounterConditionValuesDao;
    }

    public ConquestMoveDisplacementsDao getConquestMoveDisplacementsDao() {
        return conquestMoveDisplacementsDao;
    }

    public ConquestWarriorRankStatMapDao getConquestWarriorRankStatMapDao() {
        return conquestWarriorRankStatMapDao;
    }

    public ConquestWarriorTransformationDao getConquestWarriorTransformationDao() {
        return conquestWarriorTransformationDao;
    }

    public ConquestWarriorRanksDao getConquestWarriorRanksDao() {
        return conquestWarriorRanksDao;
    }

    public MoveFlagMapDao getMoveFlagMapDao() {
        return moveFlagMapDao;
    }

    public LocationGameIndicesDao getLocationGameIndicesDao() {
        return locationGameIndicesDao;
    }

    public ItemGameIndicesDao getItemGameIndicesDao() {
        return itemGameIndicesDao;
    }

    public MovesDao getMovesDao() {
        return movesDao;
    }

    public ConquestKingdomsDao getConquestKingdomsDao() {
        return conquestKingdomsDao;
    }

    public ConquestWarriorSpecialtiesDao getConquestWarriorSpecialtiesDao() {
        return conquestWarriorSpecialtiesDao;
    }

    public TypeGameIndicesDao getTypeGameIndicesDao() {
        return typeGameIndicesDao;
    }

    public BerriesDao getBerriesDao() {
        return berriesDao;
    }

    public TypesDao getTypesDao() {
        return typesDao;
    }

    public VersionGroupRegionsDao getVersionGroupRegionsDao() {
        return versionGroupRegionsDao;
    }

    public VersionGroupsDao getVersionGroupsDao() {
        return versionGroupsDao;
    }

    public GenerationsDao getGenerationsDao() {
        return generationsDao;
    }

    public PokemonFormPokeathlonStatsDao getPokemonFormPokeathlonStatsDao() {
        return pokemonFormPokeathlonStatsDao;
    }

    public PokemonFormsDao getPokemonFormsDao() {
        return pokemonFormsDao;
    }

    public BerryFirmnessDao getBerryFirmnessDao() {
        return berryFirmnessDao;
    }

    public PokemonMoveMethodsDao getPokemonMoveMethodsDao() {
        return pokemonMoveMethodsDao;
    }

    public MoveMetaStatChangesDao getMoveMetaStatChangesDao() {
        return moveMetaStatChangesDao;
    }

    public ConquestEpisodeWarriorsDao getConquestEpisodeWarriorsDao() {
        return conquestEpisodeWarriorsDao;
    }

    public ConquestEpisodesDao getConquestEpisodesDao() {
        return conquestEpisodesDao;
    }

    public NatureBattleStylePreferencesDao getNatureBattleStylePreferencesDao() {
        return natureBattleStylePreferencesDao;
    }

    public MoveBattleStylesDao getMoveBattleStylesDao() {
        return moveBattleStylesDao;
    }

    public MachinesDao getMachinesDao() {
        return machinesDao;
    }

    public EggGroupsDao getEggGroupsDao() {
        return eggGroupsDao;
    }

    public StatHintsDao getStatHintsDao() {
        return statHintsDao;
    }

    public NaturesDao getNaturesDao() {
        return naturesDao;
    }

    public StatsDao getStatsDao() {
        return statsDao;
    }

    public EncounterConditionsDao getEncounterConditionsDao() {
        return encounterConditionsDao;
    }

    public MoveChangelogDao getMoveChangelogDao() {
        return moveChangelogDao;
    }

    public ConquestWarriorSkillsDao getConquestWarriorSkillsDao() {
        return conquestWarriorSkillsDao;
    }

    public ItemFlagMapDao getItemFlagMapDao() {
        return itemFlagMapDao;
    }

    public ItemFlagsDao getItemFlagsDao() {
        return itemFlagsDao;
    }

    public ItemCategoriesDao getItemCategoriesDao() {
        return itemCategoriesDao;
    }

    public ItemPocketsDao getItemPocketsDao() {
        return itemPocketsDao;
    }

    public BerryFlavorsDao getBerryFlavorsDao() {
        return berryFlavorsDao;
    }

    public ContestTypesDao getContestTypesDao() {
        return contestTypesDao;
    }

    public SuperContestCombosDao getSuperContestCombosDao() {
        return superContestCombosDao;
    }

    public EncounterSlotsDao getEncounterSlotsDao() {
        return encounterSlotsDao;
    }

    public ConquestWarriorsDao getConquestWarriorsDao() {
        return conquestWarriorsDao;
    }

    public ConquestWarriorArchetypesDao getConquestWarriorArchetypesDao() {
        return conquestWarriorArchetypesDao;
    }

    public EvolutionTriggersDao getEvolutionTriggersDao() {
        return evolutionTriggersDao;
    }

    public MoveEffectChangelogDao getMoveEffectChangelogDao() {
        return moveEffectChangelogDao;
    }

    public MoveEffectsDao getMoveEffectsDao() {
        return moveEffectsDao;
    }

    public EvolutionChainsDao getEvolutionChainsDao() {
        return evolutionChainsDao;
    }

    public ItemsDao getItemsDao() {
        return itemsDao;
    }

    public ExperienceDao getExperienceDao() {
        return experienceDao;
    }

    public NaturePokeathlonStatsDao getNaturePokeathlonStatsDao() {
        return naturePokeathlonStatsDao;
    }

    public PokemonTypesDao getPokemonTypesDao() {
        return pokemonTypesDao;
    }

    public ConquestWarriorStatsDao getConquestWarriorStatsDao() {
        return conquestWarriorStatsDao;
    }

    public EncounterMethodsDao getEncounterMethodsDao() {
        return encounterMethodsDao;
    }

    public PokemonColorsDao getPokemonColorsDao() {
        return pokemonColorsDao;
    }

    public MoveDamageClassesDao getMoveDamageClassesDao() {
        return moveDamageClassesDao;
    }

    public PokeathlonStatsDao getPokeathlonStatsDao() {
        return pokeathlonStatsDao;
    }

    public ContestCombosDao getContestCombosDao() {
        return contestCombosDao;
    }

    public PalParkAreasDao getPalParkAreasDao() {
        return palParkAreasDao;
    }

    public MoveTargetsDao getMoveTargetsDao() {
        return moveTargetsDao;
    }

    public GrowthRatesDao getGrowthRatesDao() {
        return growthRatesDao;
    }

    public ContestEffectsDao getContestEffectsDao() {
        return contestEffectsDao;
    }

    public MoveMetaAilmentsDao getMoveMetaAilmentsDao() {
        return moveMetaAilmentsDao;
    }

    public VersionsDao getVersionsDao() {
        return versionsDao;
    }

    public MoveFlagsDao getMoveFlagsDao() {
        return moveFlagsDao;
    }

    public GendersDao getGendersDao() {
        return gendersDao;
    }

    public PokemonHabitatsDao getPokemonHabitatsDao() {
        return pokemonHabitatsDao;
    }

    public LocationsDao getLocationsDao() {
        return locationsDao;
    }

    public RegionsDao getRegionsDao() {
        return regionsDao;
    }

    public SuperContestEffectsDao getSuperContestEffectsDao() {
        return superContestEffectsDao;
    }

    public ConquestMoveRangesDao getConquestMoveRangesDao() {
        return conquestMoveRangesDao;
    }

    public ConquestStatsDao getConquestStatsDao() {
        return conquestStatsDao;
    }

    public ItemFlingEffectsDao getItemFlingEffectsDao() {
        return itemFlingEffectsDao;
    }

}
