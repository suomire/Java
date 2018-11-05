package task2;

import java.io.File;
import java.text.SimpleDateFormat;

public class InfoClass {
    String path;
    String rwx;
    Long length;
    String lastModify;
    InfoClass(){
        path="";
        rwx="";
        length=----;
    }
    public int toBit(boolean b) {
        if (b) return 1;
        else
            return 0;
    }

    public String Path(File folder) {
        path = folder.getPath();
        return path;
    }

    public String Rwx(File folder) {
        rwx = "" + toBit(folder.canExecute()) + toBit(folder.canRead()) + toBit(folder.canWrite());
        return rwx;
    }

    public Long Length(File folder) {
        length = folder.length();
        return length;
    }

    public String LastModify(File folder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        lastModify = sdf.format(folder.lastModified());
        return lastModify;
    }
}
