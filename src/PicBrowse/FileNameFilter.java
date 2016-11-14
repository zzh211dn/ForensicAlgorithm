package PicBrowse;
import java.io.File;


public class FileNameFilter {
	//Accept all directories and all gif, jpg, tiff, or png files.
    public boolean acceptfile(String extension) {
    	String ext="";
    	 int i = extension.lastIndexOf('.');

         if (i > 0 &&  i < extension.length() - 1) {
             ext = extension.substring(i+1).toLowerCase();
         }
        if ( ext!= null) {
            if ( ext.equals(Utils.tiff) ||
            		 ext.equals(Utils.tif) ||
            		 ext.equals(Utils.gif) ||
            		 ext.equals(Utils.jpeg) ||
            		 ext.equals(Utils.jpg) ||
            		 ext.equals(Utils.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
