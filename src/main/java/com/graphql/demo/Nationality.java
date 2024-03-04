package com.graphql.demo;

import java.util.Arrays;
import java.util.List;

public record Nationality (String code, String description) {
    private static List<Nationality> nationalities = Arrays.asList(
            new Nationality("UAE", "United Arab Emirates"),
            new Nationality("IND", "India"),
            new Nationality("USA", "United States of America")
    );

    public static Nationality getByCode(String code) {
        return nationalities.stream()
				.filter(nationality -> nationality.code().equals(code))
				.findFirst()
				.orElse(null);
    }
}
