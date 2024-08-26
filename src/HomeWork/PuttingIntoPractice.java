package HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> transactionsUnder2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .toList();

                transactionsUnder2011.forEach(System.out::println);

        System.out.println();

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> uniqTowns = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .toList();

                uniqTowns.forEach(System.out::println);

        System.out.println();

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<String> tradersFromCambridge = transactions.stream()
                .filter(trad -> trad.getTrader().getCity().equals("Cambridge"))
                .map(e -> e.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        tradersFromCambridge.forEach(System.out::println);
        System.out.println();

        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        List<String> traderAlfabetNames = transactions.stream()
                .map(x->x.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        traderAlfabetNames.forEach(System.out::println);
        System.out.println();

        //5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean traderFromMilan = transactions.stream()
                .anyMatch(x->x.getTrader().getCity().equals("Milan"));

        System.out.println(traderFromMilan);
        System.out.println();

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        List <Integer> transactionsSumCambridge = transactions.stream()
                .filter(x->x.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();

        System.out.println(transactionsSumCambridge);
        System.out.println();

        //7. Какова максимальная сумма среди всех транзакций?
        int transactionsMax = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();

        System.out.println(transactionsMax);
        System.out.println();


        //8. Найти транзакцию с минимальной суммой.
        int transactionsMin = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .getAsInt();

        System.out.println(transactionsMin);
        System.out.println();
    }

}







