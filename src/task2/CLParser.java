package task2;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public final class CLParser {

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

    @Option(name = "ls", usage = "launch command", required = true)
    private boolean launchCommand = false;

    public static void main(String[] args) {
        new CLParser().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            DirInfo dirInfo = new DirInfo(reverseOut, hrFormat, longFormat, outputFileName);

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }


    }
}
