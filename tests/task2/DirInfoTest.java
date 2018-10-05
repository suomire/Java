package task2;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DirInfoTest {

    @Test
    public void processFilesFromDir() {
        File dir1 = new File("C:\\ol\\cinema4d");
        DirInfo di = new DirInfo();
        di.createListFiles(dir1);
    }
}