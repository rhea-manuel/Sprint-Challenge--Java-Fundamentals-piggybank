package com.rheact.piggybank.controllers;

import com.rheact.piggybank.models.Coin;
import com.rheact.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepo;

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> getTotal(){
        final double[] total = {0};
        coinrepo.findAll().iterator().forEachRemaining((item) -> total[0] +=item.getValue());

        return new ResponseEntity<>(total[0], HttpStatus.OK);
    }
}
