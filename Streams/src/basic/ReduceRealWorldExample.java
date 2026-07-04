package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceRealWorldExample {

	static class Sale {
        String item;
        double amount;

        Sale(String item, double amount) {
            this.item = item;
            this.amount = amount;
        }

        double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Stream<Sale> sales = Stream.of(
            new Sale("Item1", 100.0),
            new Sale("Item2", 200.0),
            new Sale("Item3", 300.0)
        );

        // Use reduce() to compute the total sales amount
        double totalSales = sales.reduce(
                0.0, // Identity
                (m, n) -> m + n.getAmount(), // Accumulator
                (m1, n1) -> m1 + n1 // Combiner
                );
        
        //or
        
        // if we dont comment above code and run below code it will give 
        //stream has already been operated upon or closed exception
        // bcoz stream can be operated only once . it cant be reused
        double total = sales
                .map(p -> p.getAmount())
                .reduce(0.0, (m, n) -> m + n);
        
        //or
        double total1 = sales
                .mapToDouble(p -> p.getAmount())
                .sum();
        // Print the total sales amount
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Total Sales: " + total);
        System.out.println("Total Sales: " + total1);
    }
}
