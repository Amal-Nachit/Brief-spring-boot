package com.scorestable.restapi.controller;

import com.scorestable.restapi.model.Match;
import com.scorestable.restapi.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Operation(summary = "Get all matches", description = "Retourne tous les matchs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des matchs récupérée avec succès")
    })
    @Tag(name = "get", description = "GET methods for Matches")
    @GetMapping
    public List<Match> getAllMatchs() {
        return matchService.getAllMatchs();
    }

    @Operation(summary = "Get a match by ID", description = "Retourne les détails d'un match spécifique")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Match trouvé"),
            @ApiResponse(responseCode = "404", description = "Match non trouvé")
    })
    @Tag(name = "get", description = "GET method for Match by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@Parameter(description = "ID du match", required = true) @PathVariable Long id) {
        Optional<Match> match = matchService.getMatchById(id);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new match", description = "Ajoute un nouveau match")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Match créé avec succès")
    })
    @Tag(name = "post", description = "POST method to create a new Match")
    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @Operation(summary = "Delete a match", description = "Supprime un match par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Match supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Match non trouvé")
    })
    @Tag(name = "delete", description = "DELETE method to delete a Match")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}