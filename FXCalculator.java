/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.math.BigDecimal;

/**
 *
 * @author Eric
 */
 

public class FXCalculator extends Application {
    final int BTWIDTH=100,BTHEIGHT=100;
    int overwrtflg=1;
    String[] strlist=new String[10];
    String str2=new String();
    boolean IsPostive=true;
    BigDecimal bd1=new BigDecimal(0.0);  
    BigDecimal bd2=new BigDecimal(0.0);  
    BigDecimal ret;       
    final int OPINITIAL=0,OPADD=1,OPSUBTRACT=2,OPMULTIPLE=3,OPDIVIDE=4;    
    int optype;
    String[] oplist=new String[3];
        
    @Override
    public void start(Stage primaryStage) {                     
        optype=OPINITIAL;//the inital option type
        //create two text fields
        TextField Jtxt1=new TextField(); 
        Jtxt1.setText("0");
        Jtxt1.setEditable(false);
        Jtxt1.setAlignment(Pos.BASELINE_RIGHT);
        
        TextField Jtxt2=new TextField(); 
        Jtxt2.setText("0");
        Jtxt2.setEditable(false);
        Jtxt2.setAlignment(Pos.BASELINE_RIGHT);
        
        //create all the buttons
        Button bt0 = new Button();        
        bt0.setText("  0  ");  
        bt0.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt1 = new Button();
        bt1.setText("  1  ");       
        bt1.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt2 = new Button();
        bt2.setText("  2  ");
        bt2.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt3 = new Button();
        bt3.setText("  3  ");
        bt3.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt4 = new Button();
        bt4.setText("  4  ");
        bt4.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt5 = new Button();
        bt5.setText("  5  ");
        bt5.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt6 = new Button();
        bt6.setText("  6  ");
        bt6.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt7 = new Button();
        bt7.setText("  7  ");
        bt7.setMinSize(BTWIDTH, BTHEIGHT);        

        Button bt8 = new Button();        
        bt8.setText("  8  ");
        bt8.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt9 = new Button();        
        bt9.setText("  9  ");
        bt9.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_C = new Button();
        bt_C.setText("  C  ");        
        bt_C.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_sign = new Button();
        bt_sign.setText("+/-");        
        bt_sign.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_percent = new Button();
        bt_percent.setText("  %  ");        
        bt_percent.setMinSize(BTWIDTH, BTHEIGHT);
        bt_percent.setDisable(true);
        
        Button bt_del = new Button();
        bt_del.setText("DEL");        
        bt_del.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_divide = new Button();
        bt_divide.setText("  /  ");        
        bt_divide.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_multi = new Button();
        bt_multi.setText("  *  ");        
        bt_multi.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_subtrac = new Button();
        bt_subtrac.setText("  -  ");        
        bt_subtrac.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_dot = new Button();
        bt_dot.setText("  .   ");        
        bt_dot.setMinSize(BTWIDTH, BTHEIGHT);        
        
        Button bt_equal = new Button();
        bt_equal.setText("  =  ");        
        bt_equal.setMinSize(BTWIDTH, BTHEIGHT);                
        
        Button bt_add = new Button();
        bt_add.setText("  +  ");        
        bt_add.setMinSize(BTWIDTH, BTHEIGHT);        
        
        //button C is to turn 0 also the option type too
        bt_C.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                 Jtxt1.setText(null);
		       Jtxt2.setText("0");
		       overwrtflg=1;
                       optype=OPINITIAL;
                       oplist[0]="0";
                       oplist[1]="0";
            }
        });
        
        //sign button for put on or take off "-"
        bt_sign.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {                                    
                IsPostive= !IsPostive;
                 str2=Jtxt2.getText();                                                   
                 if(IsPostive==true){
                     strlist=str2.split("-");
                     str2=strlist[1];
                     Jtxt2.setText(str2);      
                     
                 }
                 else{
                     Jtxt2.setText("-" + str2 );
                 }
                 
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
		 
            }
        });
        
        //didn't make anything for this button
        bt_percent.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {                                
                 str2=Jtxt2.getText();                
		 Jtxt1.setText(str2 + "%");                 
            }
        });
        
        //delete a number
        bt_del.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                str2=Jtxt2.getText();		                
                str2=str2.substring(0, str2.length()-1);
                if(str2.length()==0){
                    str2="0";
                }
                Jtxt2.setText(str2);
            }
        });
        
        //number button also jude which number to put in different arrary
        bt7.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("7");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "7");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }                
            }
        });
        
        //number button also jude which number to put in different arrary
        bt8.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {                
                if(overwrtflg==1){
	  	 Jtxt2.setText("8");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "8");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //number button also jude which number to put in different arrary
        bt9.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("9");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "9");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //change the option type to divide
        bt_divide.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {    
                optype=OPDIVIDE;
                
                str2=Jtxt2.getText();                		    	                                                                         
                Jtxt1.setText(str2 + "÷");                
                Jtxt2.setText("");
            }
        });
        
        //number button also jude which number to put in different arrary
        bt4.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("4");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "4");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //number button also jude which number to put in different arrary
        bt5.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("5");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "5");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //number button also jude which number to put in different arrary
        bt6.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("6");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "6");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //change the option type to mutiple
        bt_multi.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                optype=OPMULTIPLE;
                str2=Jtxt2.getText();                		    	 
                Jtxt1.setText(str2 + "x");
                Jtxt2.setText("");
            }
        });
        
        //number button also jude which number to put in different arrary
        bt1.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("1");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "1");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //number button also jude which number to put in different arrary
        bt2.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("2");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "2");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //number button also jude which number to put in different arrary
        bt3.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("3");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "3");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //change the option type to subtract
        bt_subtrac.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                optype=OPSUBTRACT;
                str2=Jtxt2.getText();		    	 
                Jtxt1.setText(str2 + "-");
                Jtxt2.setText("");
            }
        });
        
        //add dot
        bt_dot.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                str2=Jtxt2.getText();		    	 
                Jtxt2.setText(str2 + ".");
            }
        });
        
        //number button also jude which number to put in different arrary
        bt0.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                if(overwrtflg==1){
	  	 Jtxt2.setText("0");
                 overwrtflg=0; 
                }		    	 
                else{		
                    str2=Jtxt2.getText();
                    Jtxt2.setText(str2 + "0");		    
                }
                
                if(optype==OPINITIAL){
                    oplist[0]=Jtxt2.getText();
                }
                else{
                    oplist[1]=Jtxt2.getText();
                }
            }
        });
        
        //to see which option type it is and do different works
        bt_equal.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                str2=Jtxt2.getText();		    	 
                
                
                BigDecimal bd1=new BigDecimal(oplist[0]);  
                BigDecimal bd2=new BigDecimal(oplist[1]);                   
                ret=bd1;
                //for debug
                //System.out.println(oplist[0]);
                //System.out.println(oplist[1]);
                if(optype==OPADD){
                    ret=bd1.add(bd2);                    
                }
                else if(optype==OPSUBTRACT){
                    ret=bd1.subtract(bd2);
                }
                else if(optype==OPMULTIPLE){
                    ret=bd1.multiply(bd2);
                }
                else if(optype==OPDIVIDE){
                    ret=bd1.divide(bd2);
                }
                //for debug
                //System.out.println(bd1);
                //System.out.println(ret);
                                
                
                Jtxt2.setText(ret.toString());                                                
                
                optype=OPINITIAL;
            }
        });
        
        //change option type to add
        bt_add.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                optype=OPADD;
                str2=Jtxt2.getText();		    	 
                Jtxt1.setText(str2 + "+");
                Jtxt2.setText("");
            }
        });                
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        GridPane parentgrid=new GridPane();
        GridPane grid=new GridPane();
        
        parentgrid.add(Jtxt1, 0, 0);
        parentgrid.add(Jtxt2, 0, 1);
        parentgrid.add(grid, 0, 2);
        
        grid.add(bt_C, 0, 0);
        grid.add(bt_sign, 1, 0);        
        grid.add(bt_percent, 2, 0);
        grid.add(bt_del, 3, 0);
        
        grid.add(bt7, 0, 1);
        grid.add(bt8, 1, 1);
        grid.add(bt9, 2, 1);
        grid.add(bt_divide, 3, 1);
        
        grid.add(bt4, 0, 2);
        grid.add(bt5, 1, 2);
        grid.add(bt6, 2, 2);
        grid.add(bt_multi, 3, 2);
        
        grid.add(bt1, 0, 3);
        grid.add(bt2, 1, 3);
        grid.add(bt3, 2, 3);
        grid.add(bt_subtrac, 3, 3);
        
        grid.add(bt_dot, 0, 4);
        grid.add(bt0, 1, 4);      
        grid.add(bt_equal, 2, 4);
        grid.add(bt_add, 3, 4);
        
        
        
        
        Scene scene = new Scene(parentgrid, 400, 545);
        
        
        
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
