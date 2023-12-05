package com.betrayal.finance.controllers;

import com.betrayal.finance.dtos.CreateCategoryDto;
import com.betrayal.finance.dtos.UpdateCategoryDto;
import com.betrayal.finance.entities.CategoryEntity;
import com.betrayal.finance.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {
    private final CategoryRepository repository = new CategoryRepository();
    @GetMapping()
    public ResponseEntity findAll(){
        try {
            List<CategoryEntity> categories = repository.findAll();
            return ResponseEntity.ok().body(categories);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: "+ex.getMessage());
        }
    }
    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable String id){
        try {
            CategoryEntity categories = repository.findOne(Integer.valueOf(id));
            return ResponseEntity.ok().body(categories);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }
    @PostMapping()
    public ResponseEntity create(@RequestBody CreateCategoryDto dto){
        try {
            boolean result = repository.create(dto);
            return ResponseEntity.ok().body(result);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("error: " + ex.getMessage());
        }
    }
    @PutMapping()
    public ResponseEntity update(@RequestBody UpdateCategoryDto dto){
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
