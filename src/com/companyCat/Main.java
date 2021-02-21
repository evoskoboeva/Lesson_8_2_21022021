package com.companyCat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите сумму платежа");
        long pay = scanner.nextLong();
        Audit audit = new Audit(pay);
        System.out.println(audit);
    }
}
