/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank.datalayer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import mybank.account.Account;
import mybank.account.Account.AccountType;
import mybank.account.CreditAccount;
import mybank.account.CustomerAccount;
import mybank.account.RestrictedAccount;
import mybank.model.card.Card;
import mybank.model.card.CustomerCard;
import mybank.model.card.DebitCard;
import mybank.model.customer.Customer;
import mybank.view.customer.CreditCardCustomerView;

/**
 *
 * @author camr
 */
public class CustomerDAOImp {

    private final List<Customer> customer = new ArrayList<>();
    //dette array bruges til at generere pigenavne
    private String[] girls = {"Emma", "Sofia", "Ida", "Laura", "Freja", "Anna", "Clara", "Ella", "Louise", "Ditte", "Janni", "Anette", "Lone", "Lis", "Marianne"};
    //dette array bruges til at generere drengenavne
    private String[] boys = {"Thomas", "Søren", "Jakob", "Jesper", "Carlo", "Viggo", "Bo", "Lars", "Christian", "Karl", "Ronni", "Jan", "Michael", "Jørgen", "Flemming"};
    private String[] lastName = {"Søndergård", "Jensen", "Olsen", "Sørensen", "Jakobsen", "Andersen", "Lund", "Blak", "Poulsen", "Thygesen", "Eriksen", "Jensen", "Pedersen", "Thyme", "Hansen", "Jørgensen", "Lorentzen", "Mortensen"};

    public CustomerDAOImp() {

        //herinde oprettes der 6 kunder med test data, dvs. tilhørende konti og kort
        for (int i = 0; i < 6; i++) {
            //først genereres et CPR nummer
            String birthday = generateRandomBirthDay() + generate4Digits();
            //find ud om det er en kvinde eller mand - det kan ses på CPRnummeret, hvis tallet ender på et lige tal er det en kvinde ellers en mand
            int lastDigit = Integer.parseInt(birthday.substring(birthday.length() - 1));
            Random r = new Random();
            String name;
            if (lastDigit % 2 == 0) {
                //find et random pigenavn
                name = girls[r.nextInt(girls.length - 1)];
            } else {
                //find et random drengenavn
                name = boys[r.nextInt(girls.length - 1)];
            }

            //find et random efternavn
            String lastname = lastName[r.nextInt(lastName.length - 1)];

            Customer c = new Customer(name, lastname, birthday);

            int accountAmount = new Random().nextInt(3)+1;
            //opretter en eller flere konti
            for (int j = 0; j < accountAmount; j++) {

                //Oprettelse af et kreditkort
                Card customerCard = new DebitCard(name +" "+lastname);

                //her oprettes der en ny konto med tilhørende kort
                //først skal vi finde ud af hvilken type konto der skal oprettes
                AccountType randomX = AccountType.values()[new Random().nextInt(AccountType.values().length)];
                //opretter en standard konto
                Account ac = new CustomerAccount(customerCard, randomX, new Random().nextDouble() * 200000.0);

                switch (randomX) {
                    case Overdraft:
                        //Opret en kreditkonto med en ukendt credit limit
                        ac = new CreditAccount(ac, new Random().nextDouble() * 100000.0);
                        break;
                    case Student:
                        ac = new CreditAccount(ac, 3000);
                        break;
                    case ChildSavings:
                        //her skal vi finde ud af hvornår et barn bliver 18

                        //vi har allerede CPRNummeret
                        //Så vi kan starte de første 8 cifre
                        //omform til dato
                        LocalDate birth = LocalDate.parse(birthday.substring(0, 8), DateTimeFormatter.ofPattern("ddMMyyyy"));
                        birth.plusYears(18);
                        ac = new RestrictedAccount(ac, birth);
                        break;
                    case GiftSavings:
                        //Find en random dato for i år
                        LocalDate now = LocalDate.now();
                        LocalDate randomDate = LocalDate.ofYearDay(now.getYear(), new Random().nextInt(366));
                        ac = new RestrictedAccount(ac, randomDate);
                        break;
                    default:
                        break;
                }

                System.err.println("Account er oprettet");

                c.addAccount(ac);
            }

            //Tilføj kunden til listen
            customer.add(c);
        }

    }

    public List<Customer> getCustomers() {
        return customer;
    }

    private String generate4Digits() {
        Random r = new Random();
        String formatted = String.format("%07d", r.nextInt(9999));
        return formatted;
    }

    private String generateRandomBirthDay() {
        Random r = new Random();
        int year = r.nextInt(2003 - 1944) + 1944; // generate a year between 1900 and 2010;
        int dayOfYear = r.nextInt(365);// generate a number between 1 and 365 (or 366 if you need to handle leap year);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        SimpleDateFormat sd = new SimpleDateFormat("ddMMyyyy");
        return sd.format(calendar.getTime());
    }
}
