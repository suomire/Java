package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class DirInfo {
    boolean r;
    ArrayList<String> stringList = new ArrayList<>();

    public void menu(boolean l, boolean h, String outputFileName, String inputName) {
        File folder = new File(inputName);
        if (l) longFileList(folder);
        if (h) humanReadableFileList(folder);
        else if (!(l == h)) defaultFileList(folder);
        if (outputFileName.equals("")) printOutput(outputFileName);
    }

    public void defaultFileList(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File folderEntry : folderEntries) System.out.println(folderEntry);
    }

    public void longFileList(File folder) {
        File[] folderEntries = folder.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (File entry : folderEntries) {
            String rwx = "";
            String tempPath = entry.toString() + "\\";
            tempPath += "" + toBit(entry.canExecute()) + toBit(entry.canRead()) + toBit(entry.canWrite()) + "\\";
            tempPath += sdf.format(entry.lastModified()) + "\\";
            tempPath += "" + entry.length();
            stringList.add(tempPath);
        }
        for (String aStringList : stringList) System.out.println(aStringList);
    }

    public void humanReadableFileList(File folder) {
        File[] folderEntries = folder.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (File entry : folderEntries) {
            String rwx = "";
            String tempPath = entry.toString() + "\\";
            rwx += "" + RWX("" + toBit(entry.canExecute()) + toBit(entry.canRead()) + toBit(entry.canWrite())) + "\\";
            tempPath += rwx;
            tempPath += sdf.format(entry.lastModified()) + "\\";
            tempPath += convertor(entry.length()) + RWX(rwx);
            stringList.add(tempPath);
        }
        for (String aStringList : stringList) System.out.println(aStringList);
    }

    public void printOutput(String outputFileName) {
        try {
            FileWriter fl = new FileWriter(outputFileName, true);
            for (String elem : stringList) {
                fl.write(elem + "\r\n");
            }
            fl.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public int toBit(boolean b) {
        if (b) return 1;
        else
            return 0;
    }

    public String convertor(Long bytes) {
        String str = "";
        double temp;
        double tBytes = bytes.doubleValue();
        int i = 0;
        long res = bytes / 1024;
        while (res > 1024) {
            res = res / 1024;
            i++;
        }
        str += res + " ";
        switch (i + 1) {
            case 0:
                temp = tBytes;
                str = String.format("%.2f", temp) + " bytes";
                break;
            case 1:
                temp = tBytes / 1024;
                str = String.format("%.2f", temp) + " Kbytes";
                break;
            case 2:
                temp = tBytes / 1024 / 1024;
                str = String.format("%.2f", temp) + " Mbytes";
                break;
            case 3:
                temp = tBytes / 1024 / 1024 / 1024;
                str = String.format("%.2f", temp) + " Gbytes";
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

}
