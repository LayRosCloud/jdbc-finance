package com.betrayal.finance.controllers;

import com.betrayal.finance.dtos.CreateBankDto;
import com.betrayal.finance.dtos.UpdateBankDto;
import com.betrayal.finance.entities.BankEntity;
import com.betrayal.finance.repositories.BankRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/banks")
public class BankController {
    private final BankRepository repository = new BankRepository();

    @GetMapping()
    public ResponseEntity findAll(){
        try {
            List<BankEntity> banks = repository.findAll();
            return ResponseEntity.ok().body(banks);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable String id){
        try {
            BankEntity bank = repository.findOne(Integer.valueOf(id));
            return ResponseEntity.ok().body(bank);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateBankDto bank){
        try {
            boolean result = repository.create(bank);
            return ResponseEntity.ok().body(result);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UpdateBankDto bank){
        try {
            int result = repository.update(bank);
            return ResponseEntity.ok().body(result);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable String id){
        try {
            repository.destroy(Integer.valueOf(id));
            return ResponseEntity.ok().body(true);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }
}
