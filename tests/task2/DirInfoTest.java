package task2;

import org.junit.Test;

import java.io.File;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;

public class DirInfoTest {

    @Test
    public void lineParserLaunch() throws NoSuchFileException {
        String str_expected = "Java_tasks.iml\\";
        File dir1 = new File("Java_tasks.iml");
        DirInfo di = new DirInfo(false, false, false, "", dir1);
        /*String str = di.lineParserLaunch(dir1);
        assertEquals(str, str_expected);
        di = new DirInfo(false, true, false, "", dir1);
        str = di.lineParserLaunch(dir1);
        str_expected = "Java_tasks.iml\\ rwx\\ 1.14 Kbytes 13/02/2019 10:58:11";
        assertEquals(str, str_expected);
        di = new DirInfo(true, true, false, "", dir1);
        str = di.lineParserLaunch(dir1);
        str_expected = "13/02/2019 10:58:11 1.14 Kbytes rwx\\ Java_tasks.iml\\";
        assertEquals(str, str_expected);
        di = new DirInfo(false, false, true, "", dir1);
        str = di.lineParserLaunch(dir1);
        str_expected = "Java_tasks.iml\\ 111\\ 1172\\ 13/02/2019 10:58:11";
        assertEquals(str, str_expected);*/
        dir1 = new File("tests");
        di = new DirInfo(true, false, false, "", dir1);
        String str = di.lineParserLaunch(dir1);
        str_expected = "tests\\task1\\ tests\\task2\\";
        assertEquals(str, str_expected);
        di = new DirInfo(false, true, false, "outputFilestask2/output.txt", dir1);
        str = di.lineParserLaunch(dir1);
        assertEquals(str, str_expected);
    }

    @Test
    public void printOutput() {
    }

    /*@Test
    public void convertor() {
        Long l = 2147483648L;
        DirInfo di = new DirInfo(false, true, false, "");
        System.out.println(di.converter(l));
        l = 2147483L;
        System.out.println(di.converter(l));
        l = 21473L;
        System.out.println(di.converter(l));
        l = 216L;
        System.out.println(di.converter(l));
    }

    @Test
    public void RWX() {
        DirInfo di = new DirInfo(false, true, false, "");
        String str;
        str = "000";
        System.out.println(di.convertorToRWXFormat(str));
        str = "001";
        System.out.println(di.convertorToRWXFormat(str));
        str = "010";
        System.out.println(di.convertorToRWXFormat(str));
        str = "011";
        System.out.println(di.convertorToRWXFormat(str));
        str = "100";
        System.out.println(di.convertorToRWXFormat(str));
        str = "101";
        System.out.println(di.convertorToRWXFormat(str));
        str = "110";
        System.out.println(di.convertorToRWXFormat(str));
        str = "111";
        System.out.println(di.convertorToRWXFormat(str));
    }*/
}
