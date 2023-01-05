/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.springframework.samples.petclinic.rest.api;

import org.springframework.samples.petclinic.rest.dto.RestErrorDto;
import org.springframework.samples.petclinic.rest.dto.SpecialtyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-05T13:25:09.341779100+01:00[Europe/Berlin]")
@Validated
@Tag(name = "specialties", description = "the specialties API")
public interface SpecialtiesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /specialties : Create a specialty
     * Creates a specialty .
     *
     * @param specialtyDto The specialty (required)
     * @return Specialty created successfully. (status code 200)
     *         or Not modified. (status code 304)
     *         or Bad request. (status code 400)
     *         or Specialty not found. (status code 404)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "addSpecialty",
        summary = "Create a specialty",
        tags = { "specialty" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Specialty created successfully.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecialtyDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Specialty not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/specialties",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SpecialtyDto> addSpecialty(
        @Parameter(name = "SpecialtyDto", description = "The specialty", required = true) @Valid @RequestBody SpecialtyDto specialtyDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"radiology\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /specialties/{specialtyId} : Delete a specialty by ID
     * Returns the specialty or a 404 error.
     *
     * @param specialtyId The ID of the specialty. (required)
     * @return Specialty details found and returned. (status code 200)
     *         or Not modified. (status code 304)
     *         or Bad request. (status code 400)
     *         or Specialty not found. (status code 404)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "deleteSpecialty",
        summary = "Delete a specialty by ID",
        tags = { "specialty" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Specialty details found and returned.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecialtyDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Specialty not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/specialties/{specialtyId}",
        produces = { "application/json" }
    )
    default ResponseEntity<SpecialtyDto> deleteSpecialty(
        @Min(0) @Parameter(name = "specialtyId", description = "The ID of the specialty.", required = true) @PathVariable("specialtyId") Integer specialtyId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"radiology\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /specialties/{specialtyId} : Get a specialty by ID
     * Returns the specialty or a 404 error.
     *
     * @param specialtyId The ID of the pet. (required)
     * @return Specialty details found and returned. (status code 200)
     *         or Not modified. (status code 304)
     *         or Bad request. (status code 400)
     *         or Specialty not found. (status code 404)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "getSpecialty",
        summary = "Get a specialty by ID",
        tags = { "specialty" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Specialty details found and returned.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecialtyDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Specialty not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/specialties/{specialtyId}",
        produces = { "application/json" }
    )
    default ResponseEntity<SpecialtyDto> getSpecialty(
        @Min(0) @Parameter(name = "specialtyId", description = "The ID of the pet.", required = true) @PathVariable("specialtyId") Integer specialtyId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"radiology\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /specialties : Lists specialties
     * Returns an array of specialty .
     *
     * @return Specialties found and returned. (status code 200)
     *         or Not modified. (status code 304)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "listSpecialties",
        summary = "Lists specialties",
        tags = { "specialty" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Specialties found and returned.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecialtyDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/specialties",
        produces = { "application/json" }
    )
    default ResponseEntity<List<SpecialtyDto>> listSpecialties(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"radiology\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /specialties/{specialtyId} : Update a specialty by ID
     * Returns the specialty or a 404 error.
     *
     * @param specialtyId The ID of the specialty. (required)
     * @param specialtyDto The pet (required)
     * @return Specialty details found and returned. (status code 200)
     *         or Not modified. (status code 304)
     *         or Bad request. (status code 400)
     *         or Specialty not found. (status code 404)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "updateSpecialty",
        summary = "Update a specialty by ID",
        tags = { "specialty" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Specialty details found and returned.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecialtyDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Specialty not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/specialties/{specialtyId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SpecialtyDto> updateSpecialty(
        @Min(0) @Parameter(name = "specialtyId", description = "The ID of the specialty.", required = true) @PathVariable("specialtyId") Integer specialtyId,
        @Parameter(name = "SpecialtyDto", description = "The pet", required = true) @Valid @RequestBody SpecialtyDto specialtyDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"radiology\", \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
