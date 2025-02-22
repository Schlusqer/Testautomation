package MorseCode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("""
                What kind of message is it? (1/2)
                1. I will enter text
                2. I will enter morse""");
        String choice = scan.nextLine();

        System.out.println("Enter your message: ");
        String message = scan.nextLine();

        Translator translator = new Translator();
        translator.translationSheet();


        if(choice.equals("1")) {
            System.out.println(translator.translateToMorse(message));
        }
        else if(choice.equals("2")) {
            System.out.println(translator.translateToText(message));
        } else {
            System.out.println("No message sent.");
        }

    }
}

