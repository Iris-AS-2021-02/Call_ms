package com.iris.call.controller

import com.iris.call.model.Call
import com.iris.call.repository.CallRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class CallController {

    @Autowired
    lateinit var callRepository : CallRepository;

    @PostMapping("/saveCall")
    fun save(@RequestBody call: Call):String{
        callRepository.save(call);
        return "Call details saved..";
    }

    @GetMapping("/getAll")
    fun getAllCall(): List<Call>{
        return callRepository.findAll();
    }


    @DeleteMapping("/delete/{id}")
    fun deleteCall(@PathVariable id: Int) :String{
        callRepository.deleteById(id);
        return "call deleted"
    }

}

