/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author rennan
 */
public class ServerFrame extends JFrame implements ActionListener {
    public static JTextArea txtS;
    public static JLabel lbImagemOriginal, lbImagemModificada, orig, modif;

    public ServerFrame() {
        this.setTitle("SERVIDOR");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setLayout(null);
        
        JScrollPane scroll = new JScrollPane(txtS);
        
        lbImagemOriginal = new JLabel();
        lbImagemOriginal.setBounds(30, 30, 360, 290);
        lbImagemModificada = new JLabel();
        lbImagemModificada.setBounds(400, 30, 390, 290);
        orig = new JLabel();
        orig.setBounds(120, 10, 250, 20);
        orig.setText("Imagem Original");
        modif = new JLabel();
        modif.setBounds(500, 10, 250, 20);
        modif.setText("Imagem Modificada");

        txtS = new JTextArea();
        txtS.setEditable(false);
        txtS.setBounds(200, 400, 400, 125);
        add(txtS);
        add(lbImagemOriginal);
        add(lbImagemModificada);
        add(orig);
        add(modif);
        this.add(scroll);
        //this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
