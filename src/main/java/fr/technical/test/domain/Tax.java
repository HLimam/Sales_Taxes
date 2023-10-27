package fr.technical.test.domain;

public interface Tax {
    Money calculate(Money price);
}
