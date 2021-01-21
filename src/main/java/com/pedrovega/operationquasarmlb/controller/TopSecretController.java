package com.pedrovega.operationquasarmlb.controller;

import com.pedrovega.operationquasarmlb.domain.Satellite;
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

@RestController
@RequestMapping
public class TopSecretController {

    @Autowired
    private ITopSecretService topSecretService;


    @PostMapping("/topsecret")
    @ApiOperation("Return the source and mesagge content")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = TopSecretResponseDTO.class),@ApiResponse(code = 404, message = "")})
    public ResponseEntity<TopSecretResponseDTO> topSecret(@ApiParam(value = "Satellite Information", required = true) @RequestBody TopSecretRequestDTO topSecretRequestDTO){

        return new ResponseEntity<>(topSecretService.topsecret(topSecretRequestDTO), HttpStatus.OK);
    }



}
