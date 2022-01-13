package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private static final String VIEWS_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/create")
    public String initCreationForm(Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        return VIEWS_PRODUCT_CREATE_FORM;
    }

    @PostMapping(value = "/product/create")
    public String processCreationForm(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_PRODUCT_CREATE_FORM;
        } else {
            this.productService.save(product);
            return "welcome";
        }
    }
}
