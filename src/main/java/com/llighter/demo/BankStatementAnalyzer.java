package com.llighter.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transaction in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("특정 금액 이상의 은행 거래 내역: " + bankStatementProcessor.findTransactionsGreaterThanEqual(2000));
        System.out.println("특정 월 이상의 은행 거래 내역: " + bankStatementProcessor.findTransactionsInMonth(Month.FEBRUARY));
        System.out.println("특정 월 또는 금액 이상의 은행 거래 내역: " + bankStatementProcessor.findTransactionsInMonthAndGreater(Month.AUGUST, 2000));
        System.out.println("[필터] 특정 월 또는 금액 이상의 은행 거래 내역: " + bankStatementProcessor.findTransactions(new BankTransactionIsInFabrauaryAndExpensive()));

        final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000);

        System.out.println("[람다] 특정 월 또는 금액 이상의 은행 거래 내역: " + transactions);
    }
}
