//                           Assignment 0
//                           Rishit Gupta
//                             2019091

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Logic {
    /*This function extracts the month from the main date string and returns the month number as an integer */
    public static int getmonth(String date){
        char d3=date.charAt(3);
        int var3=Integer.parseInt(String.valueOf(d3))*10;
        char d4=date.charAt(4);
        int var4=Integer.parseInt(String.valueOf(d4));
        int month=var3+var4;
        return month;
    }
    /*This function extracts the date from the main date string and returns the date as an integer */
    public static int getday(String date){
        char d1=date.charAt(0);
        int var1=Integer.parseInt(String.valueOf(d1))*10;
        char d2=date.charAt(1);
        int var2=Integer.parseInt(String.valueOf(d2));
        int day=var1+var2;
        return day;
    }
    /*This function adds 21 days to the main date and returns the recoverydate*/
    public static String getrecoverydate(String date){
        int day=getday(date);
        int month=getmonth(date);
        int returnday;
        int returnmonth;
        String rtnday = "";
        if(month==4 || month==6){
            if(day<=9){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-9;
                returnmonth=month+1;
            }
        }
        else{
            if(day<=10){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-10;
                returnmonth=month+1;
            }
        }
        if(returnday<10){
            rtnday="0"+returnday;
        }
        else{
            rtnday=returnday+"";
        }
        String rtnmonth="0"+returnmonth;
        String s;
        s= rtnday +"/"+rtnmonth;
        return s;
    }

    public static int recoveredcases(String date,String tower,Patient[] arr){
        int a=activecases(date,tower,arr);
        int b=totalcases(date,tower,arr);
        return b-a;
    }
    public static boolean trueIfFirstIsLarger(String date1,String date2){
        int day1=getday(date1);
        int month1=getmonth(date1);
        int day2=getday(date2);
        int month2=getmonth(date2);
        System.out.println(day1);
        System.out.println(day2);
        if(month2>month1){
            return false;
        }
        else if(month2==month1){
            if(day1>=day2){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }

    }



    public static int activecases(String date, String tower,Patient[] arr){
        int count=0;
        for(int i=0;i<20;i++){
            String s=getrecoverydate(arr[i].date);
            System.out.println("Recovery"+s);
            System.out.println("Corona date= "+ arr[i].date);
            System.out.println("input= "+date);
//            System.out.println(tower.equals(arr[i].tower));

            if(trueIfFirstIsLarger(s,date) && tower.equals(arr[i].tower) && trueIfFirstIsLarger(date,arr[i].date)){
                System.out.println("HIIII"+ s);
                count+=1;
            }
        }

        return count;

    }

    public static int totalcases(String date,String tower,Patient[] arr){
        int count=0;

        for (int i=0;i<20;i++){
            if(trueIfFirstIsLarger(date,arr[i].date) && tower.equals(arr[i].tower)){
                count+=1;
            }
        }
        return count;
    }

//    public static void printPatientDetails(String date,String tower,Patient[] arr){
//
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//
        Patient[] arr=new Patient[20];
        arr[0]=new Patient("Flora",6,"A","01/04/2020");
        arr[1]=new Patient("Denys",24,"B","01/04/2020");
        arr[2]=new Patient("Jim",42,"C","18/05/2020");
        arr[3]=new Patient("Hazel",87,"D","23/06/2020");
        arr[4]=new Patient("Caery",72,"A","01/06/2020");
        arr[5]=new Patient("David",7,"B","14/06/2020");
        arr[6]=new Patient("Kevim",37,"D","05/06/2020");
        arr[7]=new Patient("Tom",67,"D","20/06/2020");
        arr[8]=new Patient("Bob",74,"A","04/07/2020");
        arr[9]=new Patient("Rachel",48,"C","24/07/2020");
        arr[10]=new Patient("Thomas",21,"C","11/06/2020");
        arr[11]=new Patient("Mary",17,"D","21/06/2020");
        arr[12]=new Patient("Smith",89,"A","07/08/2020");
        arr[13]=new Patient("Pearson",47,"B","04/06/2020");
        arr[14]=new Patient("Anderson",62,"B","27/07/2020");
        arr[15]=new Patient("Johnson",10,"D","01/08/2020");
        arr[16]=new Patient("Robertz",50,"A","09/08/2020");
        arr[17]=new Patient("Julie",86,"B","02/05/2020");
        arr[18]=new Patient("Edith",42,"D","07/06/2020");
        arr[19]=new Patient("John",95,"D","01/06/2020");
//        System.out.println(activecases("31/07/2020","C",arr));
//        System.out.println(recoveredcases("31/07/2020","C",arr));
        System.out.println(trueIfFirstIsLarger("14/08/2020","24/07/2020"));
        Console obj=new Console(arr);

    }


}

class Patient{
    public String name1;
    public int age;
    public String tower;
    public String date;

    public Patient(String name1,int age, String tower,String date) {
        this.name1=name1;
        this.age=age;
        this.tower=tower;
        this.date=date;
    }

}


class Console extends JFrame{

    public static boolean towA=false;
    public static boolean towB=false;
    public static boolean towC=false;
    public static boolean towD=false;

    public static String getrecoverydate(String date){
        int day=getday(date);
        int month=getmonth(date);
        int returnday;
        int returnmonth;
        String rtnday = "";
        if(month==4 || month==6){
            if(day<=9){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-9;
                returnmonth=month+1;
            }
        }
        else{
            if(day<=10){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-10;
                returnmonth=month+1;
            }
        }
        if(returnday<10){
            rtnday="0"+returnday;
        }
        else{
            rtnday=returnday+"";
        }
        String rtnmonth="0"+returnmonth;
        String s;
        s= rtnday +"/"+rtnmonth;
        return s;
    }

    public static int activecases(String date, String tower,Patient[] arr){
        int count=0;
        for(int i=0;i<20;i++){
            String s=getrecoverydate(arr[i].date);
            if(trueIfFirstIsLarger(s,date) && tower.equals(arr[i].tower) && trueIfFirstIsLarger(date,arr[i].date)){
                count+=1;
            }
        }

        return count;

    }

    public static int recoveredcases(String date,String tower,Patient[] arr){
        int a=activecases(date,tower,arr);
        int b=totalcases(date,tower,arr);
        return b-a;
    }
    public static int getmonth(String date){
        char d3=date.charAt(3);
        int var3=Integer.parseInt(String.valueOf(d3))*10;
        char d4=date.charAt(4);
        int var4=Integer.parseInt(String.valueOf(d4));
        int month=var3+var4;
        return month;
    }

    public static int getday(String date){
        char d1=date.charAt(0);
        int var1=Integer.parseInt(String.valueOf(d1))*10;
        char d2=date.charAt(1);
        int var2=Integer.parseInt(String.valueOf(d2));
        int day=var1+var2;
        return day;
    }


    public static boolean trueIfFirstIsLarger(String date1,String date2){
        int day1=getday(date1);
        int month1=getmonth(date1);
        int day2=getday(date2);
        int month2=getmonth(date2);
        if(month2>month1){
            return false;
        }
        else if(month2==month1){
            if(day1>=day2){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }

    }


    public static int totalcases(String date,String tower,Patient[] arr){
        int count=0;

        for (int i=0;i<20;i++){

            if(trueIfFirstIsLarger(date,arr[i].date) && tower.equals(arr[i].tower)){
                count+=1;
            }
        }
        return count;
    }

    Console(Patient[] arr) {

        JLabel jLabel1 = new JLabel();
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("Covid-19 Cases In The Colony");
        jLabel1.setText("Enter the date");
        JLabel jLabel2 = new JLabel();
//        jLabel1.setBounds(200,10,150,20);
        JLabel activecases=new JLabel();
        activecases.setText("Active Cases");
        activecases.setBounds(43,400,400,30);
        add(activecases);

        JLabel recoveredcases=new JLabel();
        recoveredcases.setText("Recovered Cases");
        recoveredcases.setBounds(243,400,400,30);
        add(recoveredcases);

        jLabel2.setText("Select your tower");
        JTextField jTextField1 = new JTextField(20);
        jLabel3.setBounds(90, 10, 500, 40);
        add(jLabel3);
        jLabel1.setBounds(130, 40, 500, 40);
        add(jLabel1);
        jTextField1.setBounds(75, 80, 200, 30);
        add(jTextField1);
        jLabel2.setBounds(120, 130, 400, 40);
        add(jLabel2);

        JCheckBox checkbox1 = new JCheckBox("Tower A");
        checkbox1.setBounds(125, 180, 100, 20);
        add(checkbox1);
        JCheckBox checkbox2 = new JCheckBox("Tower B");
        checkbox2.setBounds(125, 230, 100, 20);
        add(checkbox2);
        JCheckBox checkbox3 = new JCheckBox("Tower C");
        checkbox3.setBounds(125, 280, 100, 20);
        add(checkbox3);
        JCheckBox checkbox4 = new JCheckBox("Tower D");
        checkbox4.setBounds(125, 330, 100, 20);
        add(checkbox4);

        JButton report=new JButton("Get Report");
        report.setBounds(135,500,100,20);
        add(report);

         JButton b1=new JButton("Get Case Details");
         b1.setBounds(107,380,150,20);
         add(b1);
        JTextField active = new JTextField(0);
        active.setBounds(10, 440, 150, 30);
        add(active);

        JTextField recovered = new JTextField(0);
        recovered.setBounds(220, 440, 150, 30);
        add(recovered);

        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date=jTextField1.getText();
                setVisible(false);
                Report1 dhairya = new Report1(arr,date,towA,towB,towC,towD);

            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jTextField1.getText();
                int activecnt=0;
                int recoveredcnt=0;
                if(towA){
                    activecnt+=activecases(s,"A",arr);
                    recoveredcnt+=recoveredcases(s,"A",arr);
                }
                if(towB){
                    activecnt+=activecases(s,"B",arr);
                    recoveredcnt+=recoveredcases(s,"B",arr);
                }
                if(towC){
                    activecnt+=activecases(s,"C",arr);
                    recoveredcnt+=recoveredcases(s,"C",arr);
                }
                if(towD){
                    activecnt+=activecases(s,"D",arr);
                    recoveredcnt+=recoveredcases(s,"D",arr);
                }
                active.setText(activecnt+"");
                recovered.setText(recoveredcnt+"");
            }
        });
        checkbox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    towA=true;
                }
                else{
                    towA=false;
                }
            }
        });

        checkbox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    towB=true;
                }
                else{
                    towB=false;
                }
            }
        });

        checkbox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    towC=true;
                }
                else{
                    towC=false;
                }
            }
        });

        checkbox4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    towD=true;
                }
                else{
                    towD=false;
                }
            }
        });

        setLayout(null);
        setTitle("COVID-19");
        setSize(400, 600); //Dimensions of the frame
        getContentPane().setBackground(Color.cyan);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Stops the programe when you close the screen
    }
}


class Report1 extends JFrame{

    public static String getrecoverydate(String date){
        int day=getday(date);
        int month=getmonth(date);
        int returnday;
        int returnmonth;
        String rtnday = "";
        if(month==4 || month==6){
            if(day<=9){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-9;
                returnmonth=month+1;
            }
        }
        else{
            if(day<=10){
                returnday=21+day;
                returnmonth=month;
            }
            else{
                returnday=day-10;
                returnmonth=month+1;
            }
        }
        if(returnday<10){
            rtnday="0"+returnday;
        }
        else{
            rtnday=returnday+"";
        }
        String rtnmonth="0"+returnmonth;
        String s;
        s= rtnday +"/"+rtnmonth;
        return s;
    }

    public static int getmonth(String date){
        char d3=date.charAt(3);
        int var3=Integer.parseInt(String.valueOf(d3))*10;
        char d4=date.charAt(4);
        int var4=Integer.parseInt(String.valueOf(d4));
        int month=var3+var4;
        return month;
    }

    public static int getday(String date){
        char d1=date.charAt(0);
        int var1=Integer.parseInt(String.valueOf(d1))*10;
        char d2=date.charAt(1);
        int var2=Integer.parseInt(String.valueOf(d2));
        int day=var1+var2;
        return day;
    }



    public static boolean trueIfFirstIsLarger(String date1,String date2){
        int day1=getday(date1);
        int month1=getmonth(date1);
        int day2=getday(date2);
        int month2=getmonth(date2);
        if(month2>month1){
            return false;
        }
        else if(month2==month1){
            if(day1>=day2){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }

    }



    public static String status1(String input,String corona, String recovery){
        String a="";
    if(trueIfFirstIsLarger(input,corona) && trueIfFirstIsLarger(recovery,input) ){
        a="ACTIVE";
    }
    else if(trueIfFirstIsLarger(corona,input)){
        a="NO CORONA";
    }
    else if(trueIfFirstIsLarger(input,recovery)){
        a="RECOVERED";
    }

        return a;
    }

    Report1(Patient[] arr,String date,boolean towA,boolean towB,boolean towC, boolean towD){
        int maincnt=0;
        if(towA){
            maincnt+=5;
        }
        if(towB){
            maincnt+=5;
        }
        if(towC){
            maincnt+=3;
        }
        if(towD){
         maincnt+=7;
        }

        String data[][]=new String[maincnt][5];
        int index=0;
        for(int i=0;i<20;i++){
            String towe=arr[i].tower;
            if((towe=="A" && towA==true) ||(towe=="B" && towB==true) ||(towe=="C" && towC==true) ||(towe=="D" && towD==true)) {
                String corona = arr[i].date;
                String rec = getrecoverydate(arr[i].date);
                String ans = status1(date, corona, rec);
                data[index][0] = arr[i].name1;
                data[index][1] = Integer.toString(arr[i].age);
                data[index][2] = arr[i].tower;
                data[index][3] = ans;
                data[index][4] = getrecoverydate(arr[i].date) + "/2020";
                index+=1;
            }
        }
        String column[]={"Name","Age","Tower No.","Status","Recovery Date"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        add(sp);

//        setLayout(null);
        setTitle("COVID-19");
        setSize(500, 400); //Dimensions of the frame
        getContentPane().setBackground(Color.red);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Stops the progra
    }
}