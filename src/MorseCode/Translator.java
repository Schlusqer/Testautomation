package MorseCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Translator {

    HashMap<Character, String> textToMorse = new HashMap<>();
    HashMap<String, Character> morseToText = new HashMap<>();

    char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    String[] morseCode = (".- -... -.-. -.. . ..-. --. .... .. " +
            ".--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- " +
            "...- .-- -..- -.-- --..").split(" ");

    public void translationSheet() {
        createMaps();
    }

    private void createMaps() {
        for(int i = 0; i < letters.length; i++) {
            textToMorse.put(letters[i], morseCode[i]);
            morseToText.put(morseCode[i], letters[i]);
        }
    }



    public String translateToMorse(String message) {

        ArrayList<Character> characters = new ArrayList<>();
        StringBuilder morseString = new StringBuilder();

        if(message.isEmpty()) {
            morseString.append("No message sent.");
            return morseString.toString();
        }
        else {

            for (int i = 0; i < message.length(); i++) {
                if ((message.charAt(i)) != ' ') {
                    characters.add((message.toUpperCase()).charAt(i));
                }
            }

            for (char character : characters) {
                if (Character.isLetter(character)) {
                    morseString.append(textToMorse.get(character)).append(" ");
                }
            }

            return (morseString.toString()).stripTrailing();
        }
    }

    public String translateToText(String message) {
        String[] morseArray = message.split(" ");
        StringBuilder textString = new StringBuilder();

        if(message.isEmpty()) {
            textString.append("No message sent.");
        }
        else {

            for (String morsePart : morseArray) {
                if(morsePart.charAt(0) == '.' || morsePart.charAt(0) == '-') {
                    textString.append(morseToText.get(morsePart));
                }
            }
        }
        return textString.toString();
    }

    public char[] getLetters() {
        return letters;
    }

    public String[] getMorseCode() {
        return morseCode;
    }
    
}
