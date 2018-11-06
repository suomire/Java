package task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DirInfo {
    private boolean r;
    private boolean h;
    private boolean l;
    private String o;

    private ArrayList<String> stringList = new ArrayList<>();
    private ArrayList<String> lineList = new ArrayList<>();

    public DirInfo(boolean r, boolean h, boolean l, String o) {
        this.r = r;
        this.h = h;
        this.l = l;
        this.o = o;
    }

    public void lineParserLaunch(File folder) {
        stringList.clear();
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File entry : folderEntries) {
                InfoClass ic = new InfoClass(entry);
                lineList.clear();
                lineList.add(ic.getPath() + "\\");
                if (this.h != this.l) {
                    if (this.l) {
                        lineList.add(ic.getRwx() + "\\");
                        lineList.add(ic.getLength() + "\\");
                    } else {
                        lineList.add(RWX(ic.getRwx()) + "\\");
                        lineList.add(convertor(ic.getLength()) + "");
                    }
                    lineList.add(ic.getLastModify() + "");
                }
                if (r) Collections.reverse(lineList);
                stringList.add(lineList.toString());
            }
        } else {
            InfoClass ic = new InfoClass(folder);
            lineList.clear();
            lineList.add(ic.getPath() + "\\");
            if (this.h != this.l) {
                if (this.l) {
                    lineList.add(ic.getRwx() + "\\");
                    lineList.add(ic.getLength() + "\\");
                } else {
                    lineList.add(RWX(ic.getRwx()) + "\\");
                    lineList.add(convertor(ic.getLength()) + "");
                }
                lineList.add(ic.getLastModify() + "");
            }
            if (r) Collections.reverse(lineList);
            stringList.add(lineList.toString());
        }
        if (this.o.equals("")) {
            printList();
        }
        else printOutput(this.o);
    }


    public void printOutput(String outputFileName) {
        try {
            FileWriter fl = new FileWriter(outputFileName, true);
            for (String elem : stringList) {
                for (String str : elem.split(", ")) {
                    fl.write(str+" ");
                }
                fl.write("\r\n");
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
        System.out.println("print list");
        for (String line : stringList) {
            for (String str : line.split(", ")) {
                System.out.print(str);
            }
            System.out.println();
        }

    }
}
