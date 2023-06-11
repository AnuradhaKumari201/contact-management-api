package com.losung.assignment.controller;

import com.losung.assignment.domain.Contact;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.util.List;

@RestController
public interface AbstractContactController {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while retrieving all contacts",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while retrieving all contacts",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Retrieve all contacts from database",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @GetMapping("/")
    ResponseEntity<List<Contact>> getAllContacts();

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while retrieve contact with given id",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while retrieving contact with given id",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Retrieve contact from db for given id",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @GetMapping({"/{id}"})
    ResponseEntity<Contact> getContact(@PathVariable Long id);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while saving contact to db",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while saving contact to db",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Save to a given contact to db",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @PostMapping({"/"})
    ResponseEntity<Contact> saveContact(@RequestBody Contact contact);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while updating contact to db",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while updating contact to db",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Save to a given contact to db",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @PutMapping({"/save/{id}"})
    ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while deleting contact from db for given id",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while deleting contact from db for given id",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Delete a contact from db with given id",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @DeleteMapping({"/{id}"})
    ResponseEntity<String> deleteContact(@PathVariable Long id);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while finding contacts from db with given first name",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while finding contacts from db with given first name",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Find all contacts from db with given first name",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @GetMapping("/firstName")
    ResponseEntity<List<Contact>> getByFirstName(@RequestParam String firstName);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while finding contacts from db with given last name",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while finding contacts from db with given last name",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Find all contacts from db with given last name",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @GetMapping("/lastName")
    ResponseEntity<List<Contact>> getByLastName(@RequestParam String lastName);


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success while finding contacts from db with given email",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed while finding contacts from db with given email",
                    content = {@Content(schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    @Operation(
            summary = "Find all contacts from db with given email",
            security = {@SecurityRequirement(name = "ApiKey")}
    )
    @GetMapping("/email")
    ResponseEntity<List<Contact>> getByEmail(@RequestParam String email);
}
