import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Toaster", "Appliances", 30.0)
        );

        // Групуємо продукти за категоріями та знаходимо середню ціну в кожній категорії
        Map<String, Double> averagePrices = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("Середні ціни по категоріям: " + averagePrices);

        // Знаходимо категорію з найвищою середньою ціною
        Optional<Map.Entry<String, Double>> highestAverageCategory = averagePrices.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue));

        highestAverageCategory.ifPresent(entry ->
                System.out.println("Категорія з найвищою середньою ціною: " + entry.getKey() + " - " + entry.getValue()));
    }
}
