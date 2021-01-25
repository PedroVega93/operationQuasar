package com.pedrovega.operationquasarmlb.controller;


import com.pedrovega.operationquasarmlb.domain.SatelliteData;
import com.pedrovega.operationquasarmlb.dto.TopSecretRequestDTO;
import com.pedrovega.operationquasarmlb.dto.TopSecretResponseDTO;
import com.pedrovega.operationquasarmlb.service.ITopSecretService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TopSecretController {

    @Autowired
    private ITopSecretService topSecretService;

    @PostMapping("/topsecret")
    @ApiOperation("Retornar el mensaje y la posición del emisor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = TopSecretResponseDTO.class),
            @ApiResponse(code = 404, message = "")})
    public ResponseEntity<TopSecretResponseDTO> topSecret(
            @ApiParam(value = "Satellite Information", required = true)
            @RequestBody @Valid TopSecretRequestDTO topSecretRequestDTO) {
        return new ResponseEntity<>(topSecretService.topsecret(topSecretRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/topsecret_split/{satelliteName}")
    @ApiOperation("Recibir informacion, distancia y mensaje, por satélite")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "")})
    public ResponseEntity topSecretSlipt(
            @PathVariable("satelliteName") String satelliteName,
            @ApiParam(value = "Satellite Information", required = true)
            @RequestBody @Valid SatelliteData satelliteData) {
        topSecretService.topsecretSlipt(satelliteData, satelliteName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/topsecret_split")
    @ApiOperation("Retornar el mensaje y la posición del emisor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = TopSecretResponseDTO.class),
            @ApiResponse(code = 404, message = "")})
    public ResponseEntity<TopSecretResponseDTO> topSecretSlipt() {

        return new ResponseEntity<>(topSecretService.getTopsecretSlipt(), HttpStatus.OK);

    }
}