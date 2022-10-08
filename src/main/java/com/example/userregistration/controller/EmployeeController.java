package com.example.userregistration.controller;

import com.example.userregistration.dto.RegisterDTO;
import com.example.userregistration.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/alive")
    public String alive(){
        return "Service is up and running...";
    }

    @PostMapping("/registration")
    public ResponseEntity<RegisterDTO> registration(@RequestBody RegisterDTO registerDTO){
        RegisterDTO employee = employeeService.register(registerDTO);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/{fieldName}")
    public ResponseEntity<RegisterDTO> update(@PathVariable Integer id,@PathVariable String fieldName,@RequestBody RegisterDTO registerDTO) {
        return new ResponseEntity<>(employeeService.update(id,fieldName,registerDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        employeeService.delete(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RegisterDTO>> list(){
        return new ResponseEntity<>(
                employeeService.getAll(),
                HttpStatus.OK
        );
    }

}
