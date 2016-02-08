package com.epam.esp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParserTest {

    @Test
    public void testCommandLine() throws Exception {
        String[] args = {"-r", "4", "-c", "2", "-f", "0.5"};
        Input result = new Input(new Size(4, 2), 0.5);
        Parser parser = new Parser();
        assertTrue(parser.commandLine(args).equals(result));
    }

}