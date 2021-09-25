package com.llighter.demo;

public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
