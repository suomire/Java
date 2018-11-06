package task2;

import org.junit.Test;

import java.io.File;

public class DirInfoTest {

    @Test
    public void lineParserLaunch() {
        File dir1 = new File("C:\\ol\\cinema4d");
        DirInfo di = new DirInfo(false, false, false, "");
        di.lineParserLaunch(dir1);
        System.out.println();
        di = new DirInfo(false, true, false, "");
        di.lineParserLaunch(dir1);
        System.out.println();
        di = new DirInfo(true, true, false, "");
        di.lineParserLaunch(dir1);
        System.out.println();
        di = new DirInfo(false, false, true, "");
        di.lineParserLaunch(dir1);
        System.out.println();
        di = new DirInfo(true, false, true, "");
        di.lineParserLaunch(dir1);
        System.out.println();
        di = new DirInfo(true, true, true, "C:\\ol\\cinema4d\\output.txt");
        di.lineParserLaunch(dir1);
        System.out.println();
    }

    @Test
    public void printOutput() {
    }

    @Test
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
        System.out.println(di.RWX(str));
        str = "001";
        System.out.println(di.RWX(str));
        str = "010";
        System.out.println(di.RWX(str));
        str = "011";
        System.out.println(di.RWX(str));
        str = "100";
        System.out.println(di.RWX(str));
        str = "101";
        System.out.println(di.RWX(str));
        str = "110";
        System.out.println(di.RWX(str));
        str = "111";
        System.out.println(di.RWX(str));
    }
}
