package task2;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

/**
 * Задача 2. Разработать консольную утилиту, реализующую указанную в задании функциональность,
 * на языках Java и/или Kotlin. При проектировании использовать объектно-ориентированный подход.
 * Разработать автоматические тесты для отдельных частей программы.
 * Написанный код держать в отдельном проекте или модуле в репозитории на GitHub.
 *
 * Вывод содержимого указанной в качестве аргумента директории в виде отсортированного списка имен файлов.
 *
 * Флаг -l (long) переключает вывод в длинный формат, в котором, кроме имени файла,
 * указываются права на выполнение/чтение/запись в виде битовой маски XXX,
 * время последней модификации и размер в байтах.
 *
 * Флаг -h (human-readable) переключает вывод в человеко-читаемый формат (размер в кило-, мега-
 * или гигабайтах, права на выполнение в виде rwx).
 *
 * Флаг -r (reverse) меняет порядок вывода на противоположный.
 *
 * Флаг -o (output) указывает имя файла, в который следует вывести результат;
 * если этот флаг отсутствует, результат выводится в консоль.
 *
 * В случае, если в качестве аргумента указан файл, а не директория, следует вывести информацию об этом файле.
 *
 *
 * Command Line: ls [-l] [-h] [-r] [-o output.file] directory_or_file
 */

public final class CLParser {
    @Option(name = "-l", usage = "long format", forbids = "-h")
    private boolean longFormat = false;

    @Option(name = "-h", usage = "human-readable format", forbids = "-l")
    private boolean hrFormat = false;

    @Option(name = "-r", usage = "reverse print")
    private boolean reverseOut = false;

    @Option(name = "-o", metaVar = "Output File", usage = "output file name")
    private String outputFileName = "";

    @Argument(required = true, metaVar = "Input File", usage = "directory_or_file", index=1)
    private String inputFileString = "";

    @Argument(required = true, metaVar = "Launch command", usage = "launch")
    private String ls = "";

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
            System.err.println("java -jar Java_tasks.jar ls [-l] [-h] [-r] [-o output.file] directory_or_file");
            parser.printUsage(System.err);
        }


    }
}
