package task2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirInfoTest {

    @Test
    public void lineParserLaunch() throws IOException {
        String str_expected = "Java_tasks.iml\\";
        File dir1 = new File("Java_tasks.iml");
        DirInfo di = new DirInfo(false, false, false, "", dir1);
        String str = di.lineParserLaunch(dir1);
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
        assertEquals(str, str_expected);

        dir1 = new File("tests");
        di = new DirInfo(true, false, false, "", dir1);
        str = di.lineParserLaunch(dir1);
        str_expected = "tests\\task1\\ tests\\task2\\";
        assertEquals(str, str_expected);

        di = new DirInfo(false, false, false, "outputFilestask2/output.txt", dir1);
        str = di.lineParserLaunch(dir1);
        List<String> strReal = Files.readAllLines(Paths.get("outputFilestask2/output.txt"));
        List<String> strExp = Files.readAllLines(Paths.get("outputFilestask2/outputExpected.txt"));
        assertEquals(strReal, strExp);
    }

    @Test
    public void converter() throws NoSuchFileException {
        Long l = 2147483648L;
        String strReal = DirInfo.converter(l);
        assertEquals(strReal, "2.00 Gbytes");
        l = 2147483L;
        strReal = DirInfo.converter(l);
        assertEquals(strReal, "2.05 Mbytes");
        l = 21473L;
        strReal = DirInfo.converter(l);
        assertEquals(strReal, "20.97 Kbytes");
        l = 216L;
        strReal = DirInfo.converter(l);
        assertEquals(strReal, "0.21 Kbytes");
    }

    @Test
    public void converterToRWXFormat() {
        String str;
        str = "000";
        assertEquals(DirInfo.converterToRWXFormat(str), "---");
        str = "001";
        assertEquals(DirInfo.converterToRWXFormat(str), "--x");
        str = "010";
        assertEquals(DirInfo.converterToRWXFormat(str), "-w-");
        str = "011";
        assertEquals(DirInfo.converterToRWXFormat(str), "-wx");
        str = "100";
        assertEquals(DirInfo.converterToRWXFormat(str), "r--");
        str = "101";
        assertEquals(DirInfo.converterToRWXFormat(str), "r-x");
        str = "110";
        assertEquals(DirInfo.converterToRWXFormat(str), "rw-");
        str = "111";
        assertEquals(DirInfo.converterToRWXFormat(str), "rwx");
    }
}
