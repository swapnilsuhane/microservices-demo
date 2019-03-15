package com.example.jedisdemo.controller;

import com.example.jedisdemo.model.Programmer;
import com.example.jedisdemo.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgrammerController {
    @Autowired
    ProgrammerService programmerService;

    @RequestMapping(method = RequestMethod.POST, value = "/addProgrammer")
    public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String programmer1 = mapper.writeValueAsString(programmer);
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
            programmer1);
    }

    @RequestMapping("getProgrammer/{id}")
    public String readString(@PathVariable String id){
        return programmerService.getProgrammerAsString(id);
    }

}
