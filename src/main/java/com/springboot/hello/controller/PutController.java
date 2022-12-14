package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
    @RequestMapping("/api/v1/put-api")
    public class PutController {


    @PutMapping(value = "/member2")
    public ResponseEntity<MemberDto> putMember(@RequestBody MemberDto memberDto){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}

