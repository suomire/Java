package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirInfo {
    private boolean r;
    private boolean h;
    private boolean l;
    private String o;
    private File file;
    private String finalPath;

    private List<String> stringList = new ArrayList<>();
    private List<String> lineList = new ArrayList<>();

    public DirInfo(boolean r, boolean h, boolean l, String o, File file) throws NoSuchFileException {
        if (!file.exists()) {
            throw new NoSuchFileException(file.getPath());
        } else {
            this.r = r;
            this.h = h;
            this.l = l;
            this.o = o;
            this.file = file;
        }

    }

    public String lineParserLaunch(File folder) throws NoSuchFileException {
        stringList.clear();
        if (folder.exists()) {
            File[] folderEntries = folder.listFiles();
            if (folderEntries != null) {
                for (File entry : folderEntries) {
                    InfoClass ic = new InfoClass(entry);
                    additionalMethod(ic);
                }
            } else {
                InfoClass ic = new InfoClass(folder);
                additionalMethod(ic);
            }
            if (this.o.equals("")) {
                finalPath = returnPath();
            } else printOutput(this.o);
        } else {
            throw new NoSuchFileException(file.getPath());
        }
        return finalPath;
    }

    public void additionalMethod(InfoClass ic) {
        lineList.clear();
        lineList.add(ic.getPath() + "\\");
        if (this.h != this.l) {
            if (this.l) {
                lineList.add(ic.getRwx() + "\\");
                lineList.add(ic.getLength() + "\\");
            } else {
                lineList.add(convertorToRWXFormat(ic.getRwx()) + "\\");
                lineList.add(converter(ic.getLength()) + "");
            }
            lineList.add(ic.getLastModify() + "");
        }
        if (r) Collections.reverse(lineList);
        stringList.add(lineList.toString());
    }


    public void printOutput(String outputFileName) {
        try {
            FileWriter fl = new FileWriter(outputFileName, false);
            for (String elem : stringList) {
                for (String str : elem.split(", ")) {
                    fl.write(str + " ");
                }
                fl.write("\r\n");
            }
            fl.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public String converter(Long bytes) {
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

    public String convertorToRWXFormat(String rwx) {
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

    public String returnPath() {
        StringBuilder strPath = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            stringList.set(i, stringList.get(i).replaceAll("[\\[\\]]", ""));
        }
        strPath.append(stringList.toString()).deleteCharAt(0).deleteCharAt(
                strPath.length()-1);
        return strPath.toString();
    }
}
