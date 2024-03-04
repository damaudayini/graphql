package com.graphql.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Customer (String cif, String cifType, String name, String gender, String nationality, String industry,
                        int riskProfile, String passportNumber, String emiratesID, String mobile,
                        String address, int grossMonthlyIncome, List<Customer> relatedCifs) {

    static Customer  customer1 = new Customer("cif124", "IND", "Preetham", "Male", "IND", "IT", 
                                2, "KDAFE2334", "7811987123123123", "97153232323", 
                                "Qusais", 10000, null);
    static Customer customer2 = new Customer("cif128", "IND", "Ganesh", "Male", "IND", "IT", 
                                2, "GEFFE1221", "78119871111111", "9715999999", 
                                "BusinessBay", 10000, null);

    private static List<Customer> customers = Arrays.asList(
            new Customer("cif123", "IND", "Udayini Dama", "Female","UAE", "OG", 
                        2, "UIYTFE2334", "781198799999", "9715888888", 
                        "DSO", 10000, null),
            customer1,
            new Customer("cif125", "IND", "Nilaknt", "Male", "USA", "IT" ,
                        2, "NIAFE2334", "781198788888", "9715777777", 
                        "JLT", 10000, null),    

            new Customer("cif126", "IND", "Tina", "Female", "IND", "IT", 
                        2, "TIAFE2334", "781198777777", "9715666666", 
                        "Furjan", 10000, null),

            new Customer("cif127", "ENT", "Tapas", "Male", "IND", "IT", 
                        2, "TAPFE2334", "781198766666", "9715555555", 
                        "DSO", 10000,
                         Arrays.asList(customer1, customer2)),
            customer2
    );

    public static List<Customer> getByCif(CustomerFilter filter) {

        return customers.stream()
        .filter(customer -> 
        (filter.getCif() == null || customer.cif().equals(filter.getCif())) &&
        (filter.getName() == null || customer.name().equals(filter.getName())))
        .collect(Collectors.toList());
			
    }
}