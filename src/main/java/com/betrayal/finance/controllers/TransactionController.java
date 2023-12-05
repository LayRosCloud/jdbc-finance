package com.betrayal.finance.controllers;

import com.betrayal.finance.dtos.CreateCategoryDto;
import com.betrayal.finance.dtos.CreateTransactionDto;
import com.betrayal.finance.dtos.UpdateTransactionDto;
import com.betrayal.finance.entities.CategoryEntity;
import com.betrayal.finance.entities.TransactionEntity;
import com.betrayal.finance.repositories.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/transactions")
public class TransactionController {
    private final TransactionRepository repository = new TransactionRepository();

    @GetMapping()
    public ResponseEntity findAll(){
        try {
            List<TransactionEntity> categories = repository.findAll();
            return ResponseEntity.ok().body(categories);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable String id){
        try {
            TransactionEntity categories = repository.findOne(Integer.valueOf(id));
            return ResponseEntity.ok().body(categories);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody CreateTransactionDto dto){
        try {
            boolean result = repository.create(dto);
            return ResponseEntity.ok().body(result);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody UpdateTransactionDto dto){
        try {
            int result = repository.update(dto);
            return ResponseEntity.ok().body(result);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable String id){
        try {
            repository.destroy(Integer.valueOf(id));
            return ResponseEntity.ok().body(true);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }
}
