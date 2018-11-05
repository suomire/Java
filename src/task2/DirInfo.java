package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DirInfo {
    private boolean r = false;
    private ArrayList<String> stringList = new ArrayList<>();
    private ArrayList<String> lineList = new ArrayList<>();
    private InfoClass ic = new InfoClass();

    public void menu(boolean l, boolean h, String outputFileName, String inputName) {
        File folder = new File(inputName);
        if (l) longFileList(folder);
        if (h) humanReadableFileList(folder);
        else if (!(l == h)) defaultFileList(folder);
        if (outputFileName.equals("")) printOutput(outputFileName);
    }

    public void defaultFileList(File folder) {
        stringList.clear();
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (int i = 0; i < folderEntries.length; i++) {
                stringList.add(i, folderEntries[i].toString());
            }
            if (r) Collections.reverse(stringList);
            for (String aStringList : stringList) System.out.println(aStringList);
        } else System.out.println(folder);
    }

    public void longFileList(File folder) {
        stringList.clear();
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File entry : folderEntries) {
                lineList.clear();
                lineList.add(ic.Path(entry) + "\\");
                lineList.add(ic.Rwx(entry) + "\\");
                lineList.add(ic.LastModify(entry) + "\\");
                lineList.add(ic.Length(entry) + "");
                if (r) Collections.reverse(lineList);
                stringList.add(lineList.toString());
            }
        } else {
            lineList.clear();
            lineList.add(ic.Path(folder) + "\\");
            lineList.add(ic.Rwx(folder) + "\\");
            lineList.add(ic.LastModify(folder) + "\\");
            lineList.add(ic.Length(folder) + "");
            if (r) Collections.reverse(lineList);
            stringList.add(lineList.toString());
        }
        for (String str : stringList) System.out.println(str);
    }

    public void humanReadableFileList(File folder) {
        stringList.clear();
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File entry : folderEntries) {
                lineList.clear();
                lineList.add(ic.Path(entry) + "\\");
                lineList.add(RWX(ic.Rwx(entry)) + "\\");
                lineList.add(ic.LastModify(entry) + "\\");
                lineList.add(convertor(ic.Length(entry)) + "");
                if (r) Collections.reverse(lineList);
                stringList.add(lineList.toString());
            }
        } else {
            lineList.clear();
            lineList.add(ic.Path(folder) + "\\");
            lineList.add(ic.Rwx(folder) + "\\");
            lineList.add(ic.LastModify(folder) + "\\");
            lineList.add(ic.Length(folder) + "");
            if (r) Collections.reverse(lineList);
            stringList.add(lineList.toString());
        }
        for (String str : stringList) System.out.println(str);
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

    public void printList() {
        for (String line : stringList) {
            for (String str : line.split(", ")) {
                System.out.print(str);

            }
            System.out.println();
        }

    }
}
