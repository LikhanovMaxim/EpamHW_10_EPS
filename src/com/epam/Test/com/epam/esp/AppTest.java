package com.epam.esp;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AppTest {

    @Test
    public void testOneMain() throws Exception {
        String[] args = {"-r", "5", "-c", "4", "-f", "1"};
        String result="5 4\n" +
                "1.0\n" +
                "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 1\n" +
                "\n" +
                "Emergency Prevention System\n" +
                "------------------------------------------------------------\n" +
                "------------------------------------------------------------\n" +
                "    0  1  2  3 \n" +
                " 0 |X||X||X||X|\n" +
                " 1 |X||X||X||X|\n" +
                " 2 |X||X||X||X|\n" +
                " 3 |X||X||X||X|\n" +
                " 4 |X||X||X||X|\n" +
                "\n" +
                "Risk groups report:\n" +
                "------------------------------------------------------------\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 1 groups;\n";
        assertTrue(result.equals(App.main(args)));
    }

    @Test
    public void testZeroMain() throws Exception {
        String[] args = {"-r", "3", "-c", "3", "-f", "0"};
        String result="3 3\n" +
                "0.0\n" +
                "NONE 0\n" +
                "MINOR 0\n" +
                "NORMAL 0\n" +
                "MAJOR 0\n" +
                "CRITICAL 0\n" +
                "\n" +
                "Emergency Prevention System\n" +
                "------------------------------------------------------------\n" +
                "------------------------------------------------------------\n" +
                "    0  1  2 \n" +
                " 0  -  -  - \n" +
                " 1  -  -  - \n" +
                " 2  -  -  - \n" +
                "\n" +
                "Risk groups report:\n" +
                "------------------------------------------------------------\n" +
                "NONE: 0 groups;\n" +
                "MINOR: 0 groups;\n" +
                "NORMAL: 0 groups;\n" +
                "MAJOR: 0 groups;\n" +
                "CRITICAL: 0 groups;\n";
        assertTrue(result.equals(App.main(args)));
    }
}