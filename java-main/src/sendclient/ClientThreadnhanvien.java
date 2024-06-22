package sendclient;


import cafe.TEST;
import formdangnhap.nhanvien22;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanhhoatranthi
 */
public class ClientThreadnhanvien implements Runnable{
    
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    nhanvien22 main;
    StringTokenizer st;
    protected DecimalFormat df = new DecimalFormat("##,#00");
    
    public ClientThreadnhanvien(Socket socket, nhanvien22 main){
        this.main = main;
        this.socket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            main.appendMessage("[IOException]: "+ e.getMessage(), "Lỗi", Color.RED, Color.RED);
        }
    }


    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                String data = dis.readUTF();
                st = new StringTokenizer(data);
                /** Get Message CMD **/
                String CMD = st.nextToken();
                switch(CMD){
                    case "CMD_MESSAGE":
                    //    SoundEffect.MessageReceive.play(); //  Play Audio clip
                        String msg = "";
                        String frm = st.nextToken();
                        while(st.hasMoreTokens()){
                            msg = msg +" "+ st.nextToken();
                        }
                        main.appendMessage(msg, frm, Color.MAGENTA, Color.BLUE);
                        break;
                        
                    
                    
                        
                  
                        
                    default: 
                        main.appendMessage("[CMDException]: Không rõ lệnh "+ CMD, "CMDException", Color.RED, Color.RED);
                    break;
                }
            }
        } catch(IOException e){
            main.appendMessage(" Bị mất kết nối đến Máy chũ, vui lòng thử lại.!", "Lỗi", Color.RED, Color.RED);
        }
    }
}