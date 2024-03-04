package com.graphql.demo;

import java.util.Arrays;
import java.util.List;

public record Industry  (String code, String description) {
    private static List<Industry> industries = Arrays.asList(
            new Industry("IT", "Information Technology"),
            new Industry("OG", "Oil and Gas")
    );

    public static Industry getByCode(String code) {
        return industries.stream()
				.filter(industry -> industry.code().equals(code))
				.findFirst()
				.orElse(null);
    }
}
