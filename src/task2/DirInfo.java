package task2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class DirInfo {

    public void createListFiles(File folder) {

        File[] folderEntries = folder.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (File entry : folderEntries) {
            String rwx = "";
            long size = entry.getTotalSpace();
            String tempPath = entry.toString() + "\\ ";
            tempPath += " " + toBit(entry.canExecute()) + toBit(entry.canRead()) + toBit(entry.canWrite());
            rwx += toBit(entry.canExecute()) + toBit(entry.canRead()) + toBit(entry.canWrite());
            tempPath += " " + sdf.format(entry.lastModified());
            tempPath += " " + entry.getTotalSpace();

            tempPath += Convertor(entry.getTotalSpace()) + RWX(rwx);

        }
        System.out.println(folderEntries);
        //SORTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11
    }

    public int toBit(boolean b) {
        if (b) return 1;
        else
            return 0;
    }

    public String Convertor(Long bytes) {
        String str = "";
        int i = 0;
        long res = bytes / 1024;
        while (res > 1024) {
            res = res / 1024;
            i++;
        }
        str += res + " ";
        switch (i) {
            case 0:
                str = "bytes";
                break;
            case 1:
                str = "Kbytes";
                break;
            case 2:
                str = "Mbytes";
                break;
            case 3:
                str = "Gbytes";
                break;
        }
        return str;
    }

    public String RWX(String rwx) {
        String str = "";
        switch (rwx) {
            case "000":
                str = "---";
                break;
            case "001":
                str = "--x";
                break;
            case "010":
                str = "-w-";
                break;
            case "011":
                str = "-wx";
                break;
            case "100":
                str = "r--";
                break;
            case "101":
                str = "r-x";
                break;
            case "110":
                str = "rw-";
                break;
            case "111":
                str = "rwx";
                break;

        }
        return str;
    }


    public void filesInfo() {

    }
}
