package MorseCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase {

    @Test
    public void testLetterArray() {
        Translator translator = new Translator();

        char[] expected = {'A','B','C','D','E','F','G','H','I',
                'J','K','L','M','N','O','P','Q','R','S','T','U',
                'V','W','X','Y','Z'};

        char[] actual = translator.getLetters();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testMorseArray() {
        Translator translator = new Translator();

        String[] expected = {".-", "-...", "-.-.","-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};

        String[] actual = translator.getMorseCode();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLetterToMorse() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = ".-";

        String actual = translator.translateToMorse("A");

        assertEquals(expected, actual);

    }

    @Test
    public void testMorseToLetter() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "A";

        String actual = translator.translateToText(".-");

        assertEquals(expected, actual);

    }
    @Test
    public void testMessageToMorse() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";

        String actual = translator.translateToMorse("HELLOWORLD");

        assertEquals(expected, actual);

    }

    @Test
    public void testMessageToText() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "HELLOWORLD";

        String actual = translator.translateToText(".... . .-.. .-.. --- .-- --- .-. .-.. -..");

        assertEquals(expected, actual);

    }

    @Test
    public void testMixedCaseMessage() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "- . ... - .. -. --. .- -.-. --- -- -... .. -." +
                " .- - .. --- -. --- ..-. ... -- .- .-.. .-.. .- -. -.. .-.." +
                " .- .-. --. .";

        String actual = translator.translateToMorse("TeSTinG a cOMbInATIon oF SMALL aNd large");

        assertEquals(expected, actual);

    }

    @Test
    public void testEmptyMorseInput() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "No message sent.";

        String actual = translator.translateToText("");

        assertEquals(expected, actual);

    }

    @Test
    public void testEmptyTextInput() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "No message sent.";

        String actual = translator.translateToMorse("");

        assertEquals(expected, actual);

    }
    @Test
    public void testWithSpecialCharacter() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = ".... . .-.. .-.. ---";

        String actual = translator.translateToMorse("...?HE %L@LO!");

        assertEquals(expected, actual);

    }
    @Test
    public void testOnlySpecialCharacter() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "";

        String actual = translator.translateToMorse("!@#$?..");

        assertEquals(expected, actual);

    }

    @Test
    public void testNoMorse() {
        Translator translator = new Translator();
        translator.translationSheet();

        String expected = "HELLO";

        String actual = translator.translateToText("HELLO .... . HI .-.. .-.. HOW ARE YOU? ---");

        assertEquals(expected, actual);

    }
}
