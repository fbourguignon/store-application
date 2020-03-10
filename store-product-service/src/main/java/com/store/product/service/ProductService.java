package com.store.product.service;

import com.store.product.domain.Product;
import com.store.product.dto.ProductDTO;
import com.store.product.exception.StoreBusinessException;
import com.store.product.exception.StoreGenericException;
import com.store.product.exception.StoreNotFoundException;
import com.store.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> list(Pageable pageable) {
        try {
            return productRepository.findAll(pageable);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new StoreGenericException("Houve um erro ao listar os produtos");
        }
    }

    public Product get(UUID uuid) {
        try {
            return productRepository
                    .findById(uuid)
                    .orElseThrow(() -> new StoreNotFoundException("Produto não localizado"));
        } catch (StoreNotFoundException s) {
            log.warn("O produto com id [{}] não foi localizado", uuid);
            throw s;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new StoreGenericException("Houve um erro ao recuperar o produto");
        }

    }

    public void delete(UUID uuid) {
        try {
            productRepository.findById(uuid).ifPresent(product -> productRepository.deleteById(uuid));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new StoreGenericException("Houve um erro ao remover o produto");
        }

    }

    public Product save(ProductDTO productDTO) {
        try {
            return productRepository.save(
                    Product.builder()
                            .name(productDTO.getName())
                            .description(productDTO.getDescription())
                            .build());
        } catch (DataIntegrityViolationException de) {
            log.error("O nome [{}] já existe em nossos registros", productDTO.getName());
            throw new StoreBusinessException("Nome de produto já cadastrado!");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new StoreGenericException("Houve um erro ao salvar o produto");
        }

    }

    public void update(ProductDTO productDTO, UUID uuid) {
        try {

            Optional<Product> product = productRepository.findById(uuid);

            if (product.isPresent()) {
                productRepository.save(Product.builder()
                        .id(uuid)
                        .description(productDTO.getDescription())
                        .name(productDTO.getName())
                        .build());
            } else {
                throw new StoreNotFoundException("Produto não localizado");
            }
        } catch (StoreNotFoundException s) {
            log.warn("O produto com id [{}] não foi localizado para alteração", uuid);
            throw s;
        } catch (DataIntegrityViolationException de) {
            log.error("O nome [{}] já existe em nossos registros", productDTO.getName());
            throw new StoreBusinessException("Nome de produto já cadastrado!");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new StoreGenericException("Houve um erro ao salvar o produto");
        }

    }
}
