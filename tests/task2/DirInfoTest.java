package task2;

import org.junit.Test;

import java.io.File;

public class DirInfoTest {

    @Test
    public void processFilesFromDir() {
        File dir1 = new File("C:\\ol\\cinema4d");
        DirInfo di = new DirInfo(false, true, false, "C:\\ol\\cinema4d\\output.txt");
        //di.defaultFileList(dir1);
        System.out.println();
        di.lineParserLaunch(dir1);
        System.out.println();
        //di.humanReadableFileList(dir1);
        //di.printOutput("C:\\ol\\cinema4d\\output.txt");
        //di.printList();
    }
}