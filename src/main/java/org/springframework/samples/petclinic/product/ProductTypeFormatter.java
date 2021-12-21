package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType> {

    @Autowired
    ProductService productService;

    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        try {
            // TODO do something with locale
            return productService.getProductType(text);
        } catch (Exception e) { // TODO specifiy exception type
            throw new ParseException("Type " + text + " is not a valid product type", 0);
        }
    }

}
