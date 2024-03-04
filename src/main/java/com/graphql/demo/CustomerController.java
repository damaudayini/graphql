package com.graphql.demo;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    @QueryMapping
    public List<Customer> searchCustomers(@Argument CustomerFilter filter) {
        return Customer.getByCif(filter);
    }

    @SchemaMapping
    public CIFType cifType(Customer customer) {
        return CIFType.getByCode(customer.cifType());
    }

   @SchemaMapping
    public Nationality nationality(Customer customer) {
        return Nationality.getByCode(customer.nationality());
    }

    @SchemaMapping
    public Industry industry(Customer customer) {
        return Industry.getByCode(customer.industry());
    }

}
