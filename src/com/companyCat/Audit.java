package com.companyCat;

import java.util.Objects;

public class Audit {
    //1. Представьте, что вы реализуете программу для банка, которая помогает
    //определить, погасил ли клиент кредит или нет. Допустим, ежемесячная сумма
    //платежа должна составлять 100 грн. Клиент должен выполнить 7 платежей, но
    //может платить реже большими суммами. Т.е., может двумя платежами по 300
    //и 400 грн. Закрыть весь долг. Создайте метод, который будет в качестве
    //аргумента принимать сумму платежа, введенную экономистом банка. Метод
    //выводит на экран информацию о состоянии кредита (сумма задолженности,
    //сумма переплаты, сообщение об отсутствии долга).
final private int payMounth = 100;
private long debt = 10000;
private long prepayment;
private long pay;
private double mounth;

    @Override
    public String toString() {
        if (debt - pay <0) {
            this.prepayment = pay - debt;
            this.debt = -1;
        }
        else {
            this.prepayment = -1;
            this.debt = debt - pay;
        }


        this.mounth = (debt-pay)/payMounth;
        return  "Аудит по счету клиента: " +   System.lineSeparator()+
                "________________________"  + System.lineSeparator()+
                "сумма долга с учетом сегодняшнего платежа -" + (this.debt<0? "долг погашен": this.debt ) + System.lineSeparator()+
                "переплата - " + (this.prepayment<0? "переплаты нет":this.prepayment) +  System.lineSeparator()+
                "оплачено сегодня - " + pay  + System.lineSeparator()+
                "при ежемесячном погащении равном - " + payMounth  + System.lineSeparator()+
                "осталось месяцев на погашение - "+(this.prepayment>0? "вы все погасили!!! ":this.mounth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Audit)) return false;
        Audit audit = (Audit) o;
        return payMounth == audit.payMounth && debt == audit.debt && prepayment == audit.prepayment && getPay() == audit.getPay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(payMounth, debt, prepayment, getPay());
    }

    public void setPay(long pay) {
        this.pay = pay;
    }

    public long getPay() {
        return pay;
    }

    public Audit(long pay) {
        this.pay = pay;
    }
}
