package com.example.userregistration.service;

import com.example.userregistration.dto.RegisterDTO;
import com.example.userregistration.model.Employee;
import com.example.userregistration.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public RegisterDTO register(RegisterDTO registerDTO) {
        Employee employeeModel = new Employee();
        BeanUtils.copyProperties(registerDTO,employeeModel,"userId");
        Employee created = employeeRepository.save(employeeModel);
        RegisterDTO result = new RegisterDTO();
        BeanUtils.copyProperties(created,result);
        return result;
    }

    public RegisterDTO update(Integer id, String fieldName, RegisterDTO registerDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            BeanWrapper source = new BeanWrapperImpl(registerDTO);
            BeanWrapper target = new BeanWrapperImpl(employee);
            target.setPropertyValue(fieldName,source.getPropertyValue(fieldName));
            employeeRepository.save(employee);
        }
        Employee employee = employeeRepository.findById(id).get();
        RegisterDTO result = new RegisterDTO();
        BeanUtils.copyProperties(employee,result);
        return result;
   }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<RegisterDTO> getAll() {
        List<RegisterDTO> list = new ArrayList<>();
        employeeRepository.findAll().forEach(e->{
            RegisterDTO dto = new RegisterDTO();
            BeanUtils.copyProperties(e,dto);
            list.add(dto);
        });
        return list;
    }
}
