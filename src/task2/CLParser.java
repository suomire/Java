package task2;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class CLParser {

    @Option(name = "ls", usage = "launch command", required = false)
    private boolean launchCommand = false;

    @Option(name = "-l", usage = "long format", forbids = "-h")
    private boolean longFormat = false;

    @Option(name = "-h", usage = "human-readable format", forbids = "-l")
    private boolean hrFormat = false;

    @Option(name = "-r", usage = "reverse print")
    private boolean reverseOut = false;

    @Option(name = "-o", metaVar = "Output File")
    private String outputFileName = "";

    @Argument(required = true, metaVar = "Input File", usage = "input file name")
    private String inputFileString = "";


    public static void main(String[] args) throws IOException {
        new CLParser().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            File dir1 = new File(inputFileString);
            DirInfo dirInfo = new DirInfo(reverseOut, hrFormat, longFormat, outputFileName);
            dirInfo.lineParserLaunch(dir1);

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }


    }
}
