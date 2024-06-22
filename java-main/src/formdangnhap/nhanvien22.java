/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formdangnhap;

import cafe.*;
import sendclient.ClientThread;
import formdangnhap.Toancuc;
import formdangnhap.dangnhap;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import sendclient.ClientThreadnhanvien;



//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.Socket;
//import javax.swing.DefaultListModel;
//import javax.swing.JList;
 /*
 * @author This PC
 */
public class nhanvien22 extends javax.swing.JFrame implements Runnable {
 // JFrame frame = new JFrame("Điều chỉnh màu nền của JFrame");
//45689
        // Đặt màu nền cho JFrame
      //  frame.getContentPane().setBackground(Color.BLUE);
    /**
     * 
     * Creates new form TEST
     */int mon1=100;
    
    private JList lsHistory = new JList();
    ServerSocket svSocket;
    
    DataOutputStream output;
    DataInputStream input;
    DefaultListModel model;
    
    String username;
    String sdt;
    String tenkh;
    int tuoi;
    String host;
    int port;
    Socket socket;
    DataOutputStream dos;
    public boolean attachmentOpen = false;
    private boolean isConnected = false;
    // private JList lsHistory = new JList();
 //Socket socket;
   // DataOutputStream output;
    //DataInputStream input;
   // DefaultListModel model;
    private double total=0.0;
    private int x=0;
    private double tax=0.0;
    boolean isBtnTotalPressed = false;
    String b;

    

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
    
     
      public void connect(){
    //    appendMessage(" Đang kết nối...", "Trạng thái", Color.PINK, Color.PINK);
        try {
            socket = new Socket(host, port);
            dos = new DataOutputStream(socket.getOutputStream());
            // gửi username đang kết nối
            dos.writeUTF("CMD_JOIN "+tenkh);
            appendMessage(" Đã kết nối", "Trạng thái", Color.PINK, Color.PINK);
            appendMessage(" Gửi tin nhắn bây giờ!", "Trạng thái", Color.PINK, Color.PINK);
           
            
            // Khởi động Client Thread 
            new Thread(new ClientThreadnhanvien(socket,this)).start();
            jButton99.setEnabled(true);
            // đã được kết nối
            isConnected = true;
            
        }
        catch(IOException e) {
            
            
            isConnected = false;
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến máy chủ, vui lòng thử lại sau.!","Kết nối thất bại",JOptionPane.ERROR_MESSAGE);
            appendMessage("[IOException]: "+ e.getMessage(), "Lỗi", Color.RED, Color.RED);
        }
    }
     
     
    public nhanvien22() {
     //   Toancuc tc=new Toancuc();
         
        
     MyInit();
        initComponents();
    
         model=new DefaultListModel();
       jLabel21.setText(Toancuc.getTenkh());
       
     
     // jLabel21.setText("a");
        //  model=new DefaultListModel();
         // System.out.println("Giá trị từ olay: " + valueFromloginButton); // In giá trị ra console
         
       // System.out.println("tenkh="+tc.getTenkh());

    }
      public void initFrame2(String username, String host, int port){
        this.username = username;
        this.host = host;
        this.port = port;
        setTitle( username);
        //Kết nối 
        connect();
    }
      
     void MyInit(){
         setLocationRelativeTo(null);
     }
     
   
   
     
   String bb="";
   String cc="";
  public void updateTextField() {
        // Sử dụng giá trị từ Toancuc để cập nhật txtten
        jLabel21.setText(Toancuc.getTenkh());
        bb=Toancuc.getTuoi();
         // cc=Toancuc.getTenkh2();
    }
  
   
   
   
   
    public boolean isConnected(){
        return this.isConnected;
    }
  
      public void setMyTitle(String s){
        setTitle(s);
    }
    
    /*
        Phương thức tải get download
    */
    
    
    /*
        Phương thức get host
    */
    public String getMyHost(){
        return this.host;
    }
    
    /*
        Phương thức get Port
    */
    public int getMyPort(){
        return this.port;
    }
    
    /*
        Phương thức nhận My Username
    */
    public String getMyUsername(){
        return this.username;
    }
    
    /*
        Cập nhật Attachment 
    */
    public void updateAttachment(boolean b){
        this.attachmentOpen = b;
    }
    
    
    
    
    public void appendMessage(String msg, String header, Color headerColor, Color contentColor){
        jTextPane99.setEditable(true);
        getMsgHeader(header, headerColor);
        getMsgContent(msg, contentColor);
        jTextPane99.setEditable(false);
    }
     public void appendMyMessage(String msg, String header){
        jTextPane99.setEditable(true);
     //   getMsgHeader(header, Color.GREEN);
      //  getMsgContent(msg, Color.BLACK);
        jTextPane99.setEditable(false);
    }
     public void getMsgHeader(String header, Color color){
        int len = jTextPane99.getDocument().getLength();
        jTextPane99.setCaretPosition(len);
     //   jTextPane1.setCharacterAttributes(MessageStyle.styleMessageContent(color, "Impact", 13), false);
        jTextPane99.replaceSelection(header+":");
    }
    /*
        Nội dung tin nhắn
    */
    public void getMsgContent(String msg, Color color){
        int len = jTextPane99.getDocument().getLength();
        jTextPane99.setCaretPosition(len);
      //  jTextPane1.setCharacterAttributes(MessageStyle.styleMessageContent(color, "Arial", 12), false);
        jTextPane99.replaceSelection(msg +"\n\n");
    }
     
    

  
   
  
   
   
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane99 = new javax.swing.JTextPane();
        jTextField99 = new javax.swing.JTextField();
        jButton99 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jTextPane99.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        jScrollPane6.setViewportView(jTextPane99);

        jTextField99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField99ActionPerformed(evt);
            }
        });

        jButton99.setBackground(new java.awt.Color(255, 153, 153));
        jButton99.setText("Gửi");
        jButton99.setEnabled(false);
        jButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton99ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("NHÂN VIÊN CHÚ Ý TIN NHẮN TỪ KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel21)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 


 

     
    


    // Đảm bảo bạn có phương thức initComponents để khởi tạo các thành phần giao diện người dùng
    

    
     
        public void getTax(double t){
//       if(t>0&&t<100000.0){
//           tax=2000.0;
//       }
//        else
//         if(t >= 100000.0 && t <= 200000.0){
//        tax = 5000.0;
//    } else if(t > 200000.0 && t <= 300000.0){
//        tax = 10000.0;
//    } else if(t > 300000.0 && t <= 400000.0){
//        tax = 15000.0;
//    } else if(t > 400000.0 && t <= 500000.0){
//        tax = 20000.0;
//    } else if(t > 500000.0 && t <= 600000.0){
//        tax = 25000.0;
//    } else if(t > 600000.0 && t <= 700000.0){
//        tax = 30000.0;
//    } else if(t > 700000.0 && t <= 800000.0){
//        tax = 35000.0;
//    } else if(t > 800000.0 && t <= 900000.0){
//        tax = 40000.0;
//    } else if(t > 900000.0 && t <= 1000000.0){
//        tax = 45000.0;
//    }
tax=(t*10)/100;
   }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
   //  dangnhap dennhap =new dangnhap();
    //// dennhap.show();
   //  this.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void jTextField99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField99ActionPerformed
        // TODO add your handling code here:
        try {
            String content = username+" "+ evt.getActionCommand();
            dos.writeUTF("CMD_CHATALL "+ content);
            appendMyMessage(" "+evt.getActionCommand(), username);
            jTextField99.setText("");
        } catch (IOException e) {
            appendMessage(" Không thể gửi tin nhắn đi bây giờ, không thể kết nối đến Máy Chủ tại thời điểm này, xin vui lòng thử lại sau hoặc khởi động lại ứng dụng này.!", "Lỗi", Color.RED, Color.RED);
        }
    }//GEN-LAST:event_jTextField99ActionPerformed

    private void jButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton99ActionPerformed
        // TODO add your handling code here:
        try {
            String content = username+" "+ jTextField99.getText();
            dos.writeUTF("CMD_CHATALL "+ content);
            appendMyMessage(" "+jTextField99.getText(), username);
            jTextField99.setText("");
        } catch (IOException e) {
            appendMessage(" Không thể gửi tin nhắn đi bây giờ, không thể kết nối đến Máy Chủ tại thời điểm này, xin vui lòng thử lại sau hoặc khởi động lại ứng dụng này.!", "Lỗi", Color.RED, Color.RED);
        }
    }//GEN-LAST:event_jButton99ActionPerformed

 // daodienChat dd=new daodienChat();
    /**
     * @param args the command line arguments
     */
   
    
   public static void main(String args[]) {
    
       
      
       
 try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(nhanvien22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(nhanvien22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(nhanvien22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(nhanvien22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new nhanvien22().setVisible(true);
        }
    });
}
  
   
    
private String valueFromusernameField;
private javax.swing.JTextField usernameField ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField99;
    private javax.swing.JTextPane jTextPane99;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

}
