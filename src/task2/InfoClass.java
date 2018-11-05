package task2;

import java.io.File;
import java.text.SimpleDateFormat;

public class InfoClass {
    private String path;
    private String rwx;
    private Long length;
    private String lastModify;

    public InfoClass(File folder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.path = folder.getPath();
        this.rwx = "" + toBit(folder.canExecute()) + toBit(folder.canRead()) + toBit(folder.canWrite());
        this.length = folder.length();
        lastModify = sdf.format(folder.lastModified());
    }

    public int toBit(boolean b) {
        if (b) return 1;
        else
            return 0;
    }

    public String getPath() {
        return path;
    }

    public String getRwx() {
        return rwx;
    }

    public Long getLength() {
        return length;
    }

    public String getLastModify() {
        return lastModify;
    }
}
