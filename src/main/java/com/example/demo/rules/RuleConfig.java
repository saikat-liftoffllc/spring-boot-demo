package com.example.demo.rules;

import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.deliveredtechnologies.rulebook.spring.SpringAwareRuleBookRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.rules")
public class RuleConfig {
    @Bean
    public RuleBook ruleBook() {
        RuleBook ruleBook = new SpringAwareRuleBookRunner("com.example.demo.rules");
        return ruleBook;
    }
}
