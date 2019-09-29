package com.company;

import java.util.Scanner;
//importera scanner

public class Calculator {

    private double[] tal = new double[3];

    public Calculator() {

    }

    public void menu() {

        //Prompt åt användaren + menyn för miniräknarens operator alternativ

        Scanner scan = new Scanner(System.in); //deklarera scanner

        System.out.println("\t\t\tVilken operator vill du använda?\n");   // prompt

        System.out.println("\t\t\t1:Addition (+)");
        System.out.println("\t\t\t2:Subtraktion (-)");
        System.out.println("\t\t\t3:Divition (/)");
        System.out.println("\t\t\t4:Multiplikation (*)");
        System.out.println("\t\t\t5:Ingen (Avsluta)\n\n");

        System.out.print("\t\t\tAnge operator nr: "); //prompt för att välja operator för meny 1 - 5
                                                    // 5 = instant switch break + error prompt


        int operatorChoice = scan.nextInt();
        switch (operatorChoice) {
            case 1:
                mataTal();
                add();
                break;
            case 2:
                mataTal();
                sub();
                break;
            case 3:
                mataTal();
                div();
                break;
            case 4:
                mataTal();
                mul();
                break;
            case 5:
                break;
            default:
                System.out.println("Välj ett av de korrekta alternativen");
                menu();

                // beroende på vilket tal (case) som väljs i menyn anropas "mataTal" + en unik metod.
        }
    }

    public void mataTal() {

       Scanner scan = new Scanner(System.in);

        // Talen ska nu matas in, använder double för att få en mer accurate uträkning

        System.out.print("\t\t\tAnge tal 1: ");

        tal[0] = scan.nextDouble();

        System.out.print("\t\t\tAnge tal 2: ");

        tal[1] = scan.nextDouble();

        //User prompt för första talet och andra talet. Dessa ska sedan användas för uträkning.
        //tal 0 = tal 1
        //tal 1 = tal 2
        //tal 2 = ans

    }
    public void add() {//input 1 + input 2 = ans

        tal[2] = tal[0] + tal[1];
        printResultat();            //printResultat metod för att få ut formaterat svar i slutet

    }
    public void sub(){ //input 1 - input 2 = ans

        tal[2] = tal[0] - tal[1];
        printResultat();
    }
    public void div(){ //input 1 / input 2 = ans (om input 2 =! 0)

        if(tal[1] == 0){
            System.out.println("zero division error"); //nämnare i div (case 3) får ej vara 0 då kvoten går mot oändlighet
            menu();
        } else {
            tal[2] = tal[0] / tal[1];
            printResultat();
        }
    }
    public void mul(){ //input 1 * input 2 = ans

        tal[2] = tal[0] * tal[1];
        printResultat();
    }
    public void printResultat(){  //anropas av antingen add, sub, div, mul

        System.out.println("\n\n\t\t\t * * * Reslutat är: " +  tal[2] + " * * *");
        menu(); //kör igen
    }
}
