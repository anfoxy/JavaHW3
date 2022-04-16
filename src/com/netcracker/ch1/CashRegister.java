package com.netcracker.ch1;

public class CashRegister {

        private double purchase;
        private double payment;

        private int itemCount;
        private double totalTax;
        private double salesTax;
        private double totalSalesTax = 0;

	public CashRegister(double salesTax) {
            purchase = 0;
            payment = 0;
            itemCount = 0;
            totalTax = 0;
            this.salesTax = salesTax / 100.0;
    }


    public void recordPurchase(double amount) {
            purchase = purchase + amount;
            itemCount++;

    }


    public void recordTaxablePurchase(double amount) {
            purchase = purchase + (amount + (amount * salesTax));
            itemCount++;
            totalSalesTax = totalSalesTax + (amount * salesTax);
    }


    public void recievePayment(double amount) {

        payment = payment + amount;

    }


    public double giveChange() {

            System.out.println("total Tax: " + totalSalesTax);
            totalTax = totalTax + purchase;
            double change = payment - purchase;
            System.out.println("Payment: " + payment);
            purchase = 0;
            payment = 0;
            totalSalesTax = 0;
            return change;
    }


    public double getTotalTax() {

            return totalTax;
    }

    public int getItemCount () {

            return itemCount;
    }

    public double getPayment() {

            return payment;
    }
}
