package ru.bmstu.lab1.task02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void shouldPrintFirstIndex() {
        assertEquals("1", runMain("5\n7 3 7 3 9\n3\n"));
    }

    @Test
    void shouldPrintMinusOneWhenNotFound() {
        assertEquals("-1", runMain("3\n1 2 3\n10\n"));
    }

    private String runMain(String input) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(output));
            Main.main(new String[0]);
        } finally {
            // возвращаем стандартные потоки, чтобы не сломать другие тесты
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
        return output.toString().trim();
    }
}
