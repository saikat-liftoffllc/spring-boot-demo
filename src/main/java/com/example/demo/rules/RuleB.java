package com.example.demo.rules;

import com.deliveredtechnologies.rulebook.annotation.*;
import com.deliveredtechnologies.rulebook.spring.RuleBean;

import java.util.List;
import java.util.stream.Collectors;

@RuleBean
@Rule(order = 2)
public class RuleB {
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
        resultFactsList = resultFactsList
                .stream()
                .filter(word -> !isWordStartsWithCharB(word))
                .collect(Collectors.toList());
    }

    private Boolean isWordStartsWithCharB(String word) {
        return word.toLowerCase().startsWith("b");
    }
}