package douframe;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fish123 on 2016/11/29.
 */
//public class MainFrame extends Runnable {
//    private SpleshWindow spleshWindow=null;
//    private void jbInit() throws Exception {
////setIconImage(Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("[Your Icon]")));
//        JPanel contentPane = (JPanel) this.getContentPane();
//        contentPane.setLayout(borderLayout1);
//        this.setSize(new Dimension(400, 300));
//        this.setTitle("JSpleshWindowDemo");
////创建新的线程，运行信息窗口
//        Thread t = new Thread(this);
//        t.start();
//// 等待信息窗口显示
//        try{
//            t.join();
//        }catch ( InterruptedException e ){
//            e.printStackTrace() ;
//        }
//// 向信息窗体中显示消息
//        long x=System.currentTimeMillis();
//        while ( System.currentTimeMillis()-x <35000 )
//        {
//            System.out.print( "Waiting "+(35000-System.currentTimeMillis()+x+" \r") );
//// you can set status string in splash window
//            spleshWindow.setStatus( "Waiting "+(35-(long)(System.currentTimeMillis()/1000)+(long)(x/1000)) );
//        }
////关闭信息窗体
//        if ( spleshWindow!=null ) {
//            spleshWindow.dispose();
//            spleshWindow=null;
//        }
//    }
//    public void run() {
////新建一个信息窗体并显示
//        spleshWindow=new SpleshWindow( this );
//        spleshWindow.show();
//// throw new java.lang.UnsupportedOperationException("Method run() not yet implemented.");
//    }
//}
