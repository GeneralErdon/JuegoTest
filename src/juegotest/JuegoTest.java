package juegotest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoTest extends JFrame {

    public JButton BDerecha, BAbajo, BArriba, BIzquierda, Play;
    public static JTextField txt1, txt2, Player2;
    public static JLabel lblX, lblY;
    public static int x=350,y=230, l=40, a=20, opc, x2=400, y2 = 230, l2 =40, a2=20;
    public static String ch=null;
    public static JPanel Cola;
    public JComboBox P2;
    
    public static void player(int x, int y, int x2, int y2){
        lblX.setText("Coords X: "+ Integer.toString(x));
        lblY.setText("Coords Y: "+ Integer.toString(y));
        if (x==(790-l) || x==0 || y==0 || y==440){
            txt1.setBackground(Color.red);
            txt1.setText("(*n*)");
            Cola.setBackground(Color.red);
        }
        else{
            txt1.setBackground(Color.green);
            txt1.setText("(^u^)");
            Cola.setBackground(Color.green);
        }
        switch(ch){
            case "a","d":
                txt1.setBounds(x, y, l, a);
                
                if("a".equals(ch)){
                    Cola.setBounds((x+30), y, (l+30), a);
                }else{
                    Cola.setBounds((x-60), y, (l+30), a);
                }
                
                break;
            case "w","s":
                txt1.setBounds(x, y, l, a);
                if("w".equals(ch)){
                    Cola.setBounds(x, (y+10), l, (a+30));
                }else{
                    Cola.setBounds(x, (y-40), l, (a+30));
                }
                break;
            case "j","u":
                Player2.setBounds(x2, y2, l2, a2);
                
                
                
                break;
            case "h","k":
                Player2.setBounds(x2, y2, l2, a2);
                
                break;
        }
        //txt1.setBounds(x, y, 50, 20);
    }
    // Movimiento por tecla Metodo
    public static void mov(String ch){
        switch (ch){
            case "s": //movimiento hacia Abajo
                if(y<440){
                    y = y + 10;
                }
                
                player(x,y,x2,y2);
                break;
            case "a": //movimiento hacia Izquierda
                if(x>0){
                    x = x - 10;    
                }
                
                player(x, y,x2,y2);
                break;
            case "d": //movimiento hacia Derecha
                if(x<790-l){
                    x = x + 10;    
                }
                player(x, y,x2,y2);
                break;
            case "w": //movimiento hacia Arriba
                if(y>0){
                    y = y - 10;
                }
                player(x,y,x2,y2);
                break;
            case "j": //movimiento hacia Abajo
                if(y2<440){
                    y2 = y2 + 10;
                }
                
                player(x,y,x2,y2);
                break;
            case "h": //movimiento hacia Izquierda
                if(x2>0){
                    x2 = x2 - 10;    
                }
                
                player(x, y,x2,y2);
                break;
            case "k": //movimiento hacia Derecha
                if(x2<790-l2){
                    x2 = x2 + 10;    
                }
                player(x, y,x2,y2);
                break;
            case "u": //movimiento hacia Arriba
                if(y2>0){
                    y2 = y2 - 10;
                }
                player(x,y,x2,y2);
                break;
        }
    }
    
    
    
    
    public JuegoTest(){
        // CONSTRUCTOR
        
        setTitle("Prueba de Jueguito");
        setSize(800,500);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //sex();  LLAMANDO AL METODO DE LA PRUEBA
        
        Cola = new JPanel();
        Cola.setBackground(Color.green);
        Cola.setBounds(x ,y ,l ,(a) );
        add(Cola);
        
        // Boton diseño
        BDerecha = new JButton("D");
        BDerecha.setBounds(700, 350, 50, 30);
        BDerecha.setEnabled(false);
        add(BDerecha);
        // Boton Arriba
        BArriba = new JButton("W");
        BArriba.setBounds(670, 320, 50, 30);
        BArriba.setEnabled(false);
        add(BArriba);
        
        BIzquierda = new JButton("A");
        BIzquierda.setBounds(640, 350, 50, 30);
        BIzquierda.setEnabled(false);
        add(BIzquierda);
        
        
        
        BAbajo = new JButton("S");
        BAbajo.setBounds(670, 380, 50, 30);
        BAbajo.setEnabled(false);
        add(BAbajo);
       
        
        
        
        // txt1 diseño
        txt1= new JTextField("(^u^)");
        txt1.setBounds(x, y, l, a);
        txt1.setEditable(false);
        txt1.setBackground(Color.green);
        
        // Player 2 Diseño
        Player2 = new JTextField("(>u<)");
        Player2.setBounds(x2, y2, l2, a2);
        Player2.setBackground(Color.CYAN);
        Player2.setEditable(false);
        
        // txt1 Diseño de MOVIMIENTO
        
        txt1.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                
            }
            public void keyPressed(KeyEvent e){
                ch=String.valueOf(e.getKeyChar());
                mov(ch);
                
                /*if("a".equals(ch)){ PROBANDO EL .EQUAL
                    if(x>0){
                        x = x - 10;    
                    }
                
                    texto(x, y);
                }PROBANDO EL .EQUAL*/
                
               
            }
            public void keyReleased(KeyEvent e){
                
            }
        }
        );
        
        
        // lbl X Diseño
        lblX = new JLabel("Coords X: " + x);
        lblX.setBounds(0,0,100,30);
        add(lblX);
        // lbl Y Diseño
        lblY = new JLabel("Coords Y: " + y);
        lblY.setBounds(120,0,100,30);
        add(lblY);
        
        
        
        P2 = new JComboBox();
        P2.setBounds(350, 150, 80, 30);
        P2.setModel(new DefaultComboBoxModel(new String[]{"1 Player", "2 Player"}));
        add(P2);
        
        Play = new JButton("Play");
        Play.setBounds(350,230,60,50);
        Play.setBackground(Color.green);
        add(Play);
        Play.grabFocus();
        
        Play.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt){
                opc = P2.getSelectedIndex();
                if(opc==0){
                    add(txt1);
                    Play.setVisible(false);
                    remove(Play);
                    P2.setVisible(false);
                    remove(P2);
                    txt1.grabFocus();
                    
                }
                else{
                    add(txt1);
                    add(Player2);
                    Play.setVisible(false);
                    remove(Play);
                    P2.setVisible(false);
                    remove(P2);
                    txt1.grabFocus();
                }
                
            }
        });
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        new JuegoTest().setVisible(true);
        
    }
    
}
