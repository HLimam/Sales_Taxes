package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.Money;
import fr.technical.test.domain.Rate;
import fr.technical.test.domain.Tax;

public class ImportDutyTax implements Tax {
    @Override
    public Money calculate(Money price) {
        return price.multiply(Rate.IMPORT.getValue());
    }
}