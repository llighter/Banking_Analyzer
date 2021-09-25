package com.llighter.demo;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}
