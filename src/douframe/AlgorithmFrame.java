package douframe;

import KNN.KNN;
import SVM.SimplifiedSmo;
import com.smooth.gui.SmoothGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class AlgorithmFrame extends JFrame {
    public static JScrollPane scroll = new JScrollPane();
    public static FileAction file = new FileAction();
    public static String from;
    public static String to;
    public static JFrame jf;
    public static JFrame jfjuzheng;
    public static boolean isChooseFileEnd = false;//判断是否选择过文件了。
    TextField row;
    TextField classrow;
    TextField col;
    TextField classcol;
    TextField lei;
    TextField weishu;

    TextField leftXText;
    TextField rightXText;
    TextField leftYText;
    TextField rightYText;
    TextField allLeftXText;
    TextField allLeftYText;
    TextField allRightXText ;
    TextField allRightYText ;
    TextField danwei ;

    int readlength;
    int readtall;

    TextField tf1;
    TextField jztf;
    TextField tf2;
    //	private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new AlgorithmFrame();
    }

    /**
     * Create the frame.
     */
    public AlgorithmFrame() {
        setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 474, 347);
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("文件");
        menuBar.add(mnNewMenu_1);

        //		JMenuItem mntmNewMenuItem_3 = new JMenuItem("打开文件");
        //		mntmNewMenuItem_3.addActionListener(new OpenFileAction());
        //		mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem = new JMenuItem("数据预处理");
        mntmNewMenuItem.addActionListener(new OpenFilesAction());
        mnNewMenu_1.add(mntmNewMenuItem);


        JMenuItem mntmNewMenuItem4 = new JMenuItem("预处理算法");
        mntmNewMenuItem4.addActionListener(new PreDealAction());
        mnNewMenu_1.add(mntmNewMenuItem4);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("保存");
        mntmNewMenuItem_4.addActionListener(new BaoCunAction());
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenu menu_1 = new JMenu("画图");
        menuBar.add(menu_1);

        JMenu menu_2 = new JMenu("算法");
        menuBar.add(menu_2);

        JMenuItem menuItem_3 = new JMenuItem("Kmeans");
        menuItem_3.addActionListener(new KmeansAction());
        menu_2.add(menuItem_3);

        JMenuItem menuItem_4 = new JMenuItem("PCA");
        menuItem_4.addActionListener(new PCAAction());
        menu_2.add(menuItem_4);


        JMenuItem menuItem_5 = new JMenuItem("MAD");
        menuItem_5.addActionListener(new MADAction());
        menu_2.add(menuItem_5);

        JMenuItem menuItem_6 = new JMenuItem("KNN");
        menuItem_6.addActionListener(new KNNAction());
        menu_2.add(menuItem_6);

        JMenuItem mnBpnn = new JMenuItem("BPNN");
        mnBpnn.addActionListener(new BPNNction());
        menu_2.add(mnBpnn);

        JMenuItem mntmSvm = new JMenuItem("SVM");
        mntmSvm.addActionListener(new SVMAction());
        menu_2.add(mntmSvm);

        JMenuItem menuItem_1 = new JMenuItem("波形图");
        menuItem_1.addActionListener(new BoXingChooseAction());
        menu_1.add(menuItem_1);

        JMenuItem menuItem = new JMenuItem("多文件波形图");
        menuItem.addActionListener(new duoBoXingChooseAction());
        menu_1.add(menuItem);


        JMenuItem menuItem_2 = new JMenuItem("矩阵图");
        menuItem_2.addActionListener(new JuzhengChooseAction());
        menu_1.add(menuItem_2);

        scroll.setSize(400, 300);
        getContentPane().add(scroll, BorderLayout.CENTER);

    }

    private class OpenFilesAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            jfjuzheng = new JFrame("选取文件");
            JPanel jp = new JPanel();
            jfjuzheng.setSize(500,150);
            jfjuzheng.setLocation(350,100);
            jfjuzheng.setVisible(true);
            //				jfjuzheng.setLayout(null);
            //				jp.setPreferredSize(new Dimension(280, 192));
//            JLabel classnum = new JLabel("类  数");
//            lei = new TextField();
            JLabel allLeftpoint = new JLabel("左上坐标");
            JLabel allLableXLeft = new JLabel("X:");
            allLeftXText = new TextField();
            JLabel allLableYLeft = new JLabel("Y:");
            allLeftYText = new TextField();
            JLabel allRightpoint = new JLabel("右下坐标");
            JLabel allLableXRight = new JLabel("X:");
            allRightXText = new TextField();
            JLabel allLableYRight = new JLabel("Y:");
            allRightYText = new TextField();



            JLabel leftpoint = new JLabel("选取左上坐标");
            JLabel lableXLeft = new JLabel("X:");
            leftXText = new TextField();
            JLabel lableYLeft = new JLabel("Y:");
            leftYText = new TextField();

            JLabel rightpoint = new JLabel("选取右下坐标");
            JLabel lableXRight = new JLabel("X:");
            rightXText = new TextField();
            JLabel lableYRight = new JLabel("Y:");
            rightYText = new TextField();


            JLabel labledanwei = new JLabel("步长:");
            danwei = new TextField();
            JLabel XRight1 = new JLabel("X:");
            JLabel XRight2 = new JLabel("X:");
            JLabel YRight1 = new JLabel("Y:");
            JLabel YRight2 = new JLabel("Y:");

//            jp.add(classnum);
//            jp.add(lei);
            jp.add(allLeftpoint);
            jp.add(XRight1);
            jp.add(allLeftXText);
            jp.add(YRight1);
            jp.add(allLeftYText);
            jp.add(allRightpoint);
            jp.add(XRight2);
            jp.add(allRightXText);
            jp.add(YRight2);
            jp.add(allRightYText);
            jp.add(leftpoint);
            jp.add(lableXLeft);
            jp.add(leftXText);
            jp.add(lableYLeft);
            jp.add(leftYText);
            jp.add(rightpoint);
            jp.add(lableXRight);
            jp.add(rightXText);
            jp.add(lableYRight);
            jp.add(rightYText);
            jp.add(labledanwei);
            jp.add(danwei);

            JButton bt = new JButton("选择");
            bt.addActionListener(new FileChooseListener());
            jp.add(bt);
            jfjuzheng.getContentPane().add(jp);
        }
    }

    private class SVMAction implements ActionListener {
        List<List<Double>> datas = new ArrayList<List<Double>>();
        List<List<Double>> testDatas = new ArrayList<List<Double>>();
        List<String> label = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();
        WriteTo write = new WriteTo();
        String data = "";
        String dataTotest = "";
        String testData = "";

        public void actionPerformed(ActionEvent e) {
            if (file.openFiles("选择训练集")) {
                datas = String2Double(file);
                if (file.openFiles("选择测试集")) {
                    testDatas = String2Double(file);
                    nameList = file.getNameList();
                    label = file.chooseLabelFile("选择标签");
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(6); // 设置最大小数位
                    testData += "\r\n";

                    for (int i = 0; i < testDatas.size(); i++) {
                        for (int j = 0; j < testDatas.get(i).size(); j++) {
                            String temp = df.format(testDatas.get(i).get(j));
                            testData += temp;
                            if (j != testDatas.get(i).size() - 1)
                                testData += " ";
                        }
                        if (i < testDatas.size() - 1)
                            testData += "\r\n";
                    }

                    dataTotest += "\r\n";
                    for (int i = 0; i < datas.size(); i++) {
                        for (int j = 0; j < datas.get(i).size(); j++) {
                            String temp = df.format(datas.get(i).get(j));
                            dataTotest  += temp;
                            if (j != datas.get(i).size() - 1)
                                dataTotest += " ";
                        }
                        if (i < datas.size() - 1)
                            dataTotest += "\r\n";
                    }

                    data += "\r\n";
                    for (int i = 0; i < datas.size(); i++) {
                        data += label.get(i) + " ";
                        for (int j = 0; j < datas.get(i).size(); j++) {
                            String temp = df.format(datas.get(i).get(j));
                            data += temp;
                            if (j != datas.get(i).size() - 1)
                                data += " ";
                        }
                        if (i < datas.size() - 1)
                            data += "\r\n";
                    }

                    File file = new File(".\\temp");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    write.writeTo(".\\temp\\data.csv", data);
                    write.writeTo(".\\temp\\dataTotest.csv", dataTotest);
                    write.writeTo(".\\temp\\testData.csv", testData);
                }
                SimplifiedSmo svm = new SimplifiedSmo();
                String[] accura = svm.runSVM(label.size(), datas.get(0).size(),0);
                int total = accura.length+1;
                int right = 0;
                for(int i=0;i<accura.length;i++){
                    if(accura[i].equals(label.get(i)))
                        right++;
                }
                double acc =(double) right/total;
                String[] result = svm.runSVM(label.size(), datas.get(0).size(),1);
                JTextArea jta = new JTextArea();
                jta.append("训练准确率为: "+acc+"%"+"\r\n");
                for (int i = 0; i < result.length; i++) {
                    jta.append("测试元组: ");
                    jta.append(nameList.get(i) + " ");
                    jta.append("类别为: ");
                    jta.append(result[i] + "\r\n");
                }
                JFrame mv = new JFrame("结果");
                mv.setLayout(null);
                //实例化文本框
                jta.setLineWrap(true);
                //在文本框上添加滚动条
                JScrollPane jsp = new JScrollPane(jta);
                //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
                jsp.setBounds(13, 10, 450, 340);
                //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //把滚动条添加到容器里面
                mv.add(jsp);
                mv.setSize(470, 400);
                mv.setLocation(400, 200);
                mv.setResizable(false);
                mv.setVisible(true);
                mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        }
    }

    public static List<List<Double>> String2Double(FileAction file) {
        List<List<Double>> data = new ArrayList<>();
        for (String abs[] : file.getAbslist()) {
            List absL = new ArrayList<>();
            double[] absD = new double[abs.length];
            for (int i = 0, len = abs.length; i < len; i++) {
                absD[i] = Double.valueOf(abs[i]);
                absL.add(absD[i]);
            }

            data.add(absL);
        }
        return data;
    }

    private class KNNAction implements ActionListener {
        List<List<Double>> datas = new ArrayList<List<Double>>();
        List<List<Double>> testDatas = new ArrayList<List<Double>>();
        List<String> label = new ArrayList<String>();
        List<String> nameList = new ArrayList<String>();

        public void actionPerformed(ActionEvent e) {

            if (file.openFiles("选择训练集")) {
                datas = String2Double(file);
                if (file.openFiles("选择测试集")) {
                    testDatas = String2Double(file);
                    nameList = file.getNameList();
                    label = file.chooseLabelFile("选择标签");
                    jfjuzheng = new JFrame("请输入K值");
                    JPanel jp = new JPanel();
                    jfjuzheng.setSize(300, 80);
                    jfjuzheng.setLocation(350, 100);
                    jfjuzheng.setVisible(true);
                    Label name = new Label("K值");
                    weishu = new TextField();
                    jp.add(name);
                    jp.add(weishu);
                    JButton bt = new JButton("选择");
                    JTextArea jta = new JTextArea();
                    bt.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            KNN knn = new KNN();
                            String result = "";
                            for (int i = 0; i < testDatas.size(); i++) {
                                List<Double> test = testDatas.get(i);

                                jta.append("测试元组: ");
                                jta.append(nameList.get(i) + " ");
                                jta.append("类别为: ");
                                jta.append(Math.round(Float.parseFloat((knn.knn(datas, test, label, Integer.valueOf(weishu.getText()))))) + "\r\n");
                            }
                            JFrame mv = new JFrame("结果");
                            mv.setLayout(null);
                            //实例化文本框
                            jta.setLineWrap(true);
                            //在文本框上添加滚动条
                            JScrollPane jsp = new JScrollPane(jta);
                            //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
                            jsp.setBounds(13, 10, 450, 340);
                            //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
                            jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                            //把滚动条添加到容器里面
                            mv.add(jsp);
                            mv.setSize(470, 400);
                            mv.setLocation(400, 200);
                            mv.setResizable(false);
                            mv.setVisible(true);
                            mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                    });
                    jp.add(bt);
                    jfjuzheng.getContentPane().add(jp);
                }
            }
        }
    }

    private class BPNNction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//            double[][] feature = new FileAction().chooseFeatureFile("输入训练特征集");
//            ArrayList<String> allable = new FileAction().chooseLabelFile();//返回的第一个为label的父文件夹路径
//            double[][] predictfeature = new FileAction().chooseFeatureFile("输入预测特征集");
//            double[][] lable = new double[allable.size() - 1][1];
//            double[] lableres = new double[allable.size() - 1];
//            for (int i = 0; i < allable.size() - 1; i++) {
//                lable[i][0] = Double.parseDouble(allable.get(i + 1));
//            }
////			BpDeepTest bp = new BpDeepTest();
//            TrainData t = new TrainData();
//            t.setfeature(feature);
//            t.setlabel(lable);
//            t.TrainData1();
//            BP_1 bp = new BP_1(feature[0].length, 10, 1, 0.1);
//
//            bp.train(50, t);
//            lableres = bp.getPredict(predictfeature);
//			lableres=bp.BpDeepTest(feature, lable);
            double[][] feature = new FileAction().chooseFeatureFile("输入训练特征集");

            if(feature!=null)
            {
                ArrayList<String> allable = new FileAction().chooseLabelFile();//返回的第一个为label的父文件夹路径
                if(allable!=null) {
                    double[][] predictfeature = new FileAction().chooseFeatureFile("输入预测特征集");
                    if(predictfeature!=null) {
                        double[] lable = new double[allable.size() - 1];
                        double[] lableres = new double[allable.size() - 1];
                        Set<Double> set = new TreeSet<Double>();
                        for (int i = 0; i < allable.size() - 1; i++) {
                            lable[i] = Double.parseDouble(allable.get(i + 1));
                            set.add(lable[i]);
                        }

                        BP bp = new BP(feature[0].length, 10, set.size());
                        for (int time = 0; time < 1000; time++) {
                            for (int i = 0; i < feature.length; i++) {
                                double[] labeltrain = new double[set.size()];
                                for (int j = 0; j < set.size(); j++) {
                                    if (j == lable[i] - 1)
                                        labeltrain[j] = 1.0;
                                    else {
                                        labeltrain[j] = 0.0;
                                    }
                                }
                                bp.train(feature[i], labeltrain);
                            }
                        }
                        WriteTo wt = new WriteTo();
                        long time = System.currentTimeMillis();
                        for (int row = 0; row < predictfeature.length; row++) {
                            double[] result = bp.test(predictfeature[row]);
                            double max = -Integer.MIN_VALUE;
                            int idx = -1;

                            for (int i = 0; i != set.size(); i++) {
                                if (result[i] > max) {
                                    max = result[i];
                                    idx = i;
                                }
                                System.out.print(result[i]+"    " );

                            }
                            System.out.println();
                            wt.writeToContinue(allable.get(0) + "\\" + time + "labelresult.csv", "类别," + idx);
                        }
                    }
                }
            }
        }
    }

    private class PCAAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (file.openFiles("选择数据集")) {
                jfjuzheng = new JFrame("PCA");
                JPanel jp = new JPanel();
                jfjuzheng.setSize(300, 80);
                jfjuzheng.setLocation(350, 100);
                jfjuzheng.setVisible(true);
                Label name = new Label("Dimension");
                weishu = new TextField();
                jp.add(name);
                jp.add(weishu);
                JButton bt = new JButton("选择");
                bt.addActionListener(new pcaListener());
                jp.add(bt);
                jfjuzheng.getContentPane().add(jp);
            }
        }

    }

    private class pcaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String index = weishu.getText();
            if (index.matches("[0-9]+")) {
                Integer ws = Integer.valueOf(index);
                if (ws == 0) {
                    JOptionPane.showMessageDialog(null, "数据输入有误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    file.PCAhelp(ws);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字！", "消息提示", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private class MADAction implements ActionListener {
        Double[] dataA;
        Double[] dataB;
        Double sumA;
        String nameA;
        String nameB;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (file.OpenFile()) {
                nameA = file.filename;
                String[] abrA = file.getAbres();
                dataA = new Double[abrA.length];
                sumA = Double.valueOf(0);
                for (int i = 0; i < dataA.length; i++) {
                    dataA[i] = Double.valueOf(abrA[i]);
                    sumA += dataA[i];
                }
                if (file.OpenFile()) {
                    nameB = file.filename;
                    String[] abrB = file.getAbres();
                    dataB = new Double[abrB.length];
                    for (int i = 0; i < dataB.length; i++) {
                        dataB[i] = Double.valueOf(abrB[i]);
                    }
                    Double mean = sumA / dataA.length;
                    Double stdSum = Double.valueOf(0);
                    for (int i = 0; i < dataA.length; i++) {
                        stdSum += Math.pow(dataA[i] - mean, 2);
                    }
                    int length = dataA.length;
                    Double stdPower2 = stdSum / length;
                    Double madPower2 = Double.valueOf(0);

                    for (int i = 0; i <length; i++) {
                        madPower2 += Math.pow(dataA[i] - dataB[i], 2) / stdPower2;
                    }
                    Double mad = Math.pow(madPower2, 0.5);
                    JTextArea jta = new JTextArea();
                    jta.append("计算元组: "+nameA+"和"+nameB+"的马氏距离为："+mad);
                    JFrame mv = new JFrame("结果");
                    mv.setLayout(null);
                    //实例化文本框
                    jta.setLineWrap(true);
                    //在文本框上添加滚动条
                    JScrollPane jsp = new JScrollPane(jta);
                    //设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
                    jsp.setBounds(13, 10, 550, 240);
                    //默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
                    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    //把滚动条添加到容器里面
                    mv.add(jsp);
                    mv.setSize(570, 200);
                    mv.setLocation(600, 400);
                    mv.setResizable(false);
                    mv.setVisible(true);
                    mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }


        }

    }

    private class  KmeansAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!isChooseFileEnd) {
                JOptionPane.showMessageDialog(null, "请先聚类所需选择文件！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                new OpenFilesAction().actionPerformed(e);
            }
            else {
                jfjuzheng = new JFrame("Kmeans");
                JPanel jp = new JPanel();
                jfjuzheng.setSize(300, 80);
                jfjuzheng.setLocation(250, 100);
                jfjuzheng.setVisible(true);
                JLabel classnum = new JLabel("类数");
                lei = new TextField();

                jp.add(classnum);
                jp.add(lei);

                JButton bt = new JButton("选择");
                bt.addActionListener(new paramKmeansListener());
                jp.add(bt);
                jfjuzheng.getContentPane().add(jp);
            }
            //				if(file.kmeansopenFiles())
        }


    }

    public void selectFiles() {
        if (allRightXText.getText().matches("[0-9]+") && allLeftXText.getText().matches("[0-9]+")) {
            int allLength = Integer.parseInt(allRightXText.getText()) - Integer.parseInt(allLeftXText.getText()) + 1;//行总长度
            allLength = allLength / Integer.parseInt(danwei.getText());
            readlength = Integer.parseInt(rightYText.getText()) - Integer.parseInt(leftYText.getText());//读取行的长度
            readlength = readlength / Integer.parseInt(danwei.getText()) + 1;
            int startReadRow = Integer.parseInt(leftXText.getText());
            int startReadCol = Integer.parseInt(leftYText.getText());
            startReadCol = startReadCol / Integer.parseInt(danwei.getText());
            int temp = Integer.parseInt(rightXText.getText());
            if (temp / Integer.parseInt(danwei.getText()) - startReadRow / Integer.parseInt(danwei.getText()) > 0) {
                startReadCol++;
            }
            readtall = Integer.parseInt(rightXText.getText()) - Integer.parseInt(leftXText.getText()) + 1;

            isChooseFileEnd = file.openSelectFiles(readtall, readlength, startReadRow, startReadCol, allLength);
        }
    }

    private class FileChooseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectFiles();
        }
    }

    private class paramKmeansListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {


                String index = lei.getText();
                Integer lei2 = Integer.valueOf(index);
                if (lei2 <= 0 || lei2 > file.abslist.size()) {
                    JOptionPane.showMessageDialog(null, "数据输入有误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    file.kmeanshelp(lei2, readtall, readlength);

                }
            }
            catch(Exception e1)
            {
                JOptionPane.showMessageDialog(null, "请输入数字！", "消息提示", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class BaoCunAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (file.waveres.length > 0)
                file.baoCun();
            else
                JOptionPane.showMessageDialog(null, "请先选择文件！", "消息提示", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class JuzhengChooseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            if (file.JuZhenopenFiles()) {
                jfjuzheng = new JFrame("矩阵选择");
                JPanel jp = new JPanel();
                jfjuzheng.setSize(400, 100);
                jfjuzheng.setLocation(350, 100);
                jfjuzheng.setVisible(true);
                Label hanglie = new Label("生成 ");
                row = new TextField();
                Label hang = new Label("行 ");
                col = new TextField();
                Label lie = new Label("列矩阵 ");
                jp.add(hanglie);
                jp.add(row);
                jp.add(hang);
                jp.add(col);
                jp.add(lie);
                Label xuhao = new Label("选择每个文件第 ");
                jztf = new TextField();
                jztf.setText("1");
                jp.add(xuhao);
                jp.add(jztf);
                Label allamount = new Label("个数据    共  " + file.wavelist.get(0).length + " 个");
                jp.add(allamount);
                JButton bt = new JButton("选择");
                bt.addActionListener(new jzchooseListener());
                jp.add(bt);
                jfjuzheng.getContentPane().add(jp);
            }
        }

    }

    private class jzchooseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String index = jztf.getText();
            String row1 = row.getText();
            String col1 = col.getText();
            if (index.matches("[0-9]+") && row1.matches("[0-9]+") && col1.matches("[0-9]+")) {
                Integer start = Integer.valueOf(index);
                Integer row2 = Integer.valueOf(row1);
                Integer col2 = Integer.valueOf(col1);
                if (start <= 0 || start > file.wavelist.get(0).length || row1.equals(0) || col1.equals(0)) {
                    JOptionPane.showMessageDialog(null, "数据输入有误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    file.juZhenXuanZe(start, row2, col2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字！", "消息提示", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private class duoBoXingChooseAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (file.multyOpenFile())//选择文件要判断是否选择成功
            {
                System.out.println("hao");
            }
        }
    }

    private class BoXingChooseAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (file.OpenFile())//选择文件要判断是否选择成功
            {
                jf = new JFrame("波形选择");
                JPanel jp = new JPanel();
                jf.setSize(400, 80);
                jf.setLocation(350, 100);
                jf.setVisible(true);

                //			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Label From = new Label("数据范围 From ");

                tf1 = new TextField();

                tf1.setText("1");

                Label To = new Label("To  ");
                tf2 = new TextField();

                tf2.setText(file.waveres.length + "");

                Label allamount = new Label("共  " + file.waveres.length + " 个");

                jp.add(From);
                jp.add(tf1);
                jp.add(To);
                jp.add(tf2);
                jp.add(allamount);

                JButton bt = new JButton("选择");
                bt.addActionListener(new chooseListener());
                jp.add(bt);
                jf.getContentPane().add(jp);
            }
        }
    }

    private class PreDealAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            SmoothGUI smoothGUI = new SmoothGUI();
        }

    }

    private class chooseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            from = tf1.getText();//波形数据传入
            to = tf2.getText();//波形数据传入
            //			System.out.print(from+" "+to);
            if (from.matches("[0-9]+") && to.matches("[0-9]+")) {
                Integer start = Integer.valueOf(from);
                Integer end = Integer.valueOf(to);
                if (start > end || start <= 0 || start > file.waveres.length || end > file.waveres.length) {
                    JOptionPane.showMessageDialog(null, "数据输入有误！", "消息提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    file.boXingXuanZe(start, end);
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字！", "消息提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}



