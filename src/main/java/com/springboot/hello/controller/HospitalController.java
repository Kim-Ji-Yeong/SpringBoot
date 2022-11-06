package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.dto.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
@Slf4j
public class HospitalController {
    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> selectById(@PathVariable int id) {
        Hospital selectedHospital = hospitalDao.findById(id);
        Optional<Hospital> opt =  Optional.of(selectedHospital);

        if(!opt.isEmpty()){
            return ResponseEntity.ok().body(selectedHospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }

//    @PostMapping("")
//    public ResponseEntity<Integer> add(@RequestBody Hospital hospital) {
//        log.info("정보를 등록했습니다.");
//        hospitalDao.add(hospital);
//        return ResponseEntity
//                .ok()
//                .body(hospitalDao.add(hospital));
//    }

}
