package douframe;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by fish123 on 2016/11/28.
 */
public class FileUtil {
    public FileFilter setFileFilter(String endsWithWord) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String s = pathname.getName().toLowerCase();

                if (s.endsWith(endsWithWord)) {
                    return true;
                }
                return false;
            }
        };
        return fileFilter;
    }

}
