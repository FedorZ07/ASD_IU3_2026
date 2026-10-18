package ru.bmstu.lab1.task01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void shouldPrintMinAndMax() {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream("5\n3 -7 12 0 5\n".getBytes()));
            System.setOut(new PrintStream(output));
            Main.main(new String[0]);
        } finally {
            // возвращаем стандартные потоки, чтобы не сломать другие тесты
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
        assertEquals("-7 12", output.toString().trim());
    }
}
