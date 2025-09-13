package com.althafkutagulla.pg_management.controllers;

import com.althafkutagulla.pg_management.record.PgRecordRequest;
import com.althafkutagulla.pg_management.record.PgRecordResponse;
import com.althafkutagulla.pg_management.service.PgService;
import com.althafkutagulla.pg_management.validations.PgId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/pg")
public class PgController {
    private final PgService pgService;

    @PostMapping("/create")
    public ResponseEntity<PgRecordResponse> createPg(@Valid @RequestBody PgRecordRequest pgRecordRequest) {
        return new ResponseEntity<>(pgService.createPg(pgRecordRequest), HttpStatus.CREATED);
    }

    @GetMapping("all-pgs")
    public ResponseEntity<List<PgRecordResponse>> getAllPg() {
        return new ResponseEntity<>(pgService.getAllPg(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PgRecordResponse> updatePg(@Validated({PgId.class}) @RequestBody PgRecordRequest pgRecordRequest) {
        return new ResponseEntity<>(pgService.updatePg(pgRecordRequest), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{pgId}")
    public ResponseEntity<Boolean> deletePg(@PathVariable("pgId") Integer pgId) {
        pgService.deletePg(pgId);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
