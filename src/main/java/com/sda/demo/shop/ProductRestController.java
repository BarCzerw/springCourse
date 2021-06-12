package com.sda.demo.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product/add")
    public void addProduct(
            @RequestParam String name,
            @RequestParam int quantity,
            @RequestParam String productType,
            @RequestParam double price
    ){
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        product.setType(ProductType.valueOf(productType));
        product.setPrice(price);
        productRepository.save(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(
        @PathVariable long id
    ){
        productRepository.deleteById(id);
    }

    @PutMapping("/product/edit/{id}")
    public void updateProduct(
            @PathVariable long id,
            @RequestParam String name,
            @RequestParam int quantity,
            @RequestParam ProductType productType,
            @RequestParam double price
    ){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newParameters = product.get();
            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setQuantity(quantity);
            newProduct.setType(productType);
            newProduct.setPrice(price);
            productRepository.save(newProduct);
        } else {
            log.error("Product id:{} not found!",id);
        }
    }

    @GetMapping("/product/all/")
    public List<Product> showAllProducts(){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    @GetMapping("/product/type/{type}")
    public List<Product> showAllProductsOfType(
            @PathVariable String type
    ){
        return showAllProducts().stream().filter(product -> product.getType() == ProductType.valueOf(type)).collect(Collectors.toList());
    }

    @GetMapping("/product/type/{type}/sorted")
    public List<Product> showAllProductsOfTypeSorted(
            @PathVariable String type
    ){
        return showAllProductsOfType(type).stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
    }



}
