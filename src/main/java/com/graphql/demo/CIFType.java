package com.graphql.demo;

import java.util.Arrays;
import java.util.List;

public record CIFType (String code, String description) {
    private static List<CIFType> cifTypes = Arrays.asList(
            new CIFType("IND", "Individual"),
            new CIFType("ENT", "Entity")
    );

    public static CIFType getByCode(String code) {
        return cifTypes.stream()
				.filter(cifType -> cifType.code().equals(code))
				.findFirst()
				.orElse(null);
    }
}

