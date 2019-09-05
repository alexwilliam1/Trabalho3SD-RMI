/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import rmi.ServerFrame;

/**
 *
 * @author aw
 */
public class Servidor extends UnicastRemoteObject implements Servico {
    private static ServerFrame s;
    private static ImageIcon imageOR,imageMOD;
    
    public Servidor() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            s = new ServerFrame();
            s.setVisible(true);
            System.out.println("Servidor Inicializado\n");
            s.txtS.setText("Servidor Inicializado\n");
            Servidor servidor = new Servidor();
            String Localizacao = "rmi://192.168.0.107:1099/servico";
            System.out.println("Escutando a porta 1099\n");
            s.txtS.append("Escutando a porta 1099\n");
            Naming.rebind(Localizacao, servidor);
        } catch (MalformedURLException ex) {
            System.out.println("Erro de URL mal formada: " + ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }

    public byte[] aplicacao(byte[] data) throws RemoteException, IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage imagem = ImageIO.read(bis);
        
        File f = new File("/home/rennan/Imagens/imagemOriginal");
        ImageIO.write(imagem, "jpeg", f);
        
        String a = s.txtS.getText();
        if(a != ""){
            s.txtS.setText("");
        }
        
        System.out.println("Imagem recebida do cliente\n");
        s.txtS.append("Imagem recebida do cliente\n");
        
        imageOR = new ImageIcon(imagem);
        imageOR.setImage(imageOR.getImage().getScaledInstance(370, 290,BufferedImage.TYPE_INT_ARGB));
        s.lbImagemOriginal.setIcon(imageOR);
        
        int red,onlyRed;
        Color color;
                
        int w = imagem.getWidth();
        int h = imagem.getHeight();
        
        System.out.println("Processando requisiçao\n");
        s.txtS.append("Processando requisiçao\n");
        
        for (int col = 0; col < w; col++) {
            for (int lin = 0; lin < h; lin++) {
                color = new Color(imagem.getRGB(col,lin));
                red = color.getRed();
                onlyRed = new Color(red, 0, 0).getRGB();
                imagem.setRGB(col, lin, onlyRed);
            }
        }
        System.out.println("Aplicando modificações\n");
        s.txtS.append("Aplicando modificações\n");
        
        File g = new File("/home/rennan/Imagens/imagemManipulada");
        ImageIO.write(imagem, "jpeg", g);
        
        imageMOD = new ImageIcon(imagem);
        imageMOD.setImage(imageMOD.getImage().getScaledInstance(390, 290,BufferedImage.TYPE_INT_ARGB));
        s.lbImagemModificada.setIcon(imageMOD);
        
        System.out.println("Filtro aplicado com sucesso\n");
        s.txtS.append("Filtro aplicado com sucesso\n");
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(imagem, "jpg", bos);
        byte[] ret = bos.toByteArray();
        
        System.out.println("Nova imagem retornada ao cliente\n");
        s.txtS.append("Nova imagem retornada ao cliente\n");

        return ret;
    }
}
