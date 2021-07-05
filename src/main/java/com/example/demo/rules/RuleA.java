package com.example.demo.rules;

import com.deliveredtechnologies.rulebook.annotation.*;
import com.deliveredtechnologies.rulebook.spring.RuleBean;

import java.util.List;
import java.util.stream.Collectors;

@RuleBean
@Rule(order = 1)
public class RuleA {
    @Given
    private List<String> factsList;

    @Result
    private List<String> resultFactsList;

    @When
    public boolean when() {
        return true;
    }

    @Then
    public void then() {
        resultFactsList = factsList
                .stream()
                .filter(word -> !isWordStartsWithCharA(word))
                .collect(Collectors.toList());
    }

    private Boolean isWordStartsWithCharA(String word) {
        return word.toLowerCase().startsWith("a");
    }
}