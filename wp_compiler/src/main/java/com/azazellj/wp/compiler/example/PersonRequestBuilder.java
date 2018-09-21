package com.azazellj.wp.compiler.example;

import java.util.HashMap;
import java.util.Map;

/**
 * For example, there are three fields that should be written;
 * <p>
 * name, age, total_achievements;
 * <p>
 * Methods setName, setAge, setTotalAchievements should be generated;
 */
@SuppressWarnings("unused")
public final class PersonRequestBuilder {

    private Map<String, Object> map = new HashMap<>();

    public static PersonRequestBuilder getInstance() {
        return new PersonRequestBuilder();
    }

    public PersonRequestBuilder setName(String name) {
        map.put("name", name);
        return this;
    }

    public PersonRequestBuilder setAge(int age) {
        map.put("age", age);
        return this;

    }

    public PersonRequestBuilder setTotalAchievements(int totalAchievements) {
        map.put("total_achievements", totalAchievements);
        return this;
    }

    public Map<String, Object> get() {
        return map;
    }
}