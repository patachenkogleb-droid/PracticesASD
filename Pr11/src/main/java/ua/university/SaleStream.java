package ua.university;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SaleStream {
    public record Sale(String customerEmail, String product, int cents) {}

    private List<Sale> sales = List.of(
            new Sale("a@ex.com", "Tea", 120),
            new Sale("b@ex.com", "Cake", 200),
            new Sale("a@ex.com", "Tea", 120),
            new Sale("c@ex.com", "Coffee", 150),
            new Sale("b@ex.com", "Cake", 200)
    );

    public Map<String, Integer> getRevenueByProduct() {
        return sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));
    }

    public Map<String, Long> getTransactionsByCustomer() {
        return sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));
    }

    public Map<String, Integer> getSortedRevenueByProduct() {
        return sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum,
                        TreeMap::new
                ));
    }
}