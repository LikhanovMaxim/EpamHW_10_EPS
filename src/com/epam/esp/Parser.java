package com.epam.esp;

import org.apache.commons.cli.*;

public class Parser {
    public Input commandLine(String[] args) throws ParseException {
        if (args == null || args.length == 0) {
            assert false : "Wrong args in function 'divideBinaryOperation'";
        }
        Options options = new Options();
        options.addOption(OptionBuilder.
                withLongOpt("height").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("height").
                withArgName("height").
                create("r"));
        options.addOption(OptionBuilder.
                withLongOpt("width").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("width").
                withArgName("width").
                create("c"));
        options.addOption(OptionBuilder.
                withLongOpt("fill_factor").
                isRequired().
                withType(PatternOptionBuilder.NUMBER_VALUE).
                hasArg().
                withDescription("fill factor").
                withArgName("fillFactor").
                create("f"));
        CommandLineParser commandLineParser = new PosixParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        int height = Integer.parseInt(commandLine.getOptionValue("height"));
        int width = Integer.parseInt(commandLine.getOptionValue("width"));
        Size size = new Size(height, width);
        double fillFactor = Double.parseDouble(commandLine.getOptionValue("fill_factor"));
        if (fillFactor < 0 || fillFactor > 1) {
            throw new ParseException("fill factor(" + fillFactor + ") is not int the [0;1]");
        }
        return new Input(size, fillFactor);
    }

}
