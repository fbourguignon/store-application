package com.store.product.controller;

import com.store.product.domain.Product;
import com.store.product.dto.ProductDTO;
import com.store.product.dto.ResponseDTO;
import com.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductService productService;

    @Secured("ROLE_ADMIN")
    @GetMapping
    public Page<Product> list(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                              @RequestParam(value = "size", defaultValue = "5", required = false) Integer size){
        return productService.list(PageRequest.of(page, size));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.save(productDTO),HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable UUID id){
        return ResponseEntity.ok(productService.get(id));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@RequestBody ProductDTO productDTO, @PathVariable UUID id){
        productService.update(productDTO,id);
        return ResponseEntity.ok(new ResponseDTO("Produto alterado com sucesso!"));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable UUID id){
        productService.delete(id);
        return ResponseEntity.ok(new ResponseDTO("Produto removido com sucesso!"));
    }
}
