package fr.technical.test.Infrastructure.tax;

import fr.technical.test.domain.TaxExemptProductService;

import java.util.List;

public class StubTaxExemptProductService implements TaxExemptProductService {
    @Override
    public List<String> getTaxExemptProducts() {
        return List.of("book", "chocolate bar","box of imported chocolates","imported box of chocolates", "packet of headache pills");
    }
}