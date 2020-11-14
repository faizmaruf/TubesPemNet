package Client;
 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
 

public class ChatClient extends javax.swing.JFrame {
 
    //test Rizky
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket socket;
    private String server, username;
    private int port;
    private List<String> clients;
 
    public ChatClient() {
        clients = new ArrayList<>();
        initComponents();
    }
 
    public boolean start() {
        try {
            socket = new Socket(server, port);
        } catch (Exception ec) {
            System.out.println("Error connectiong to server:" + ec);
            return false;
        }
 
        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        System.out.println(msg);
 
        try {
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            System.out.println("Exception creating new Input/output Streams: " + eIO);
            return false;
        }
 
        new ChatClient.ListenFromServer().start();
 
        try {
            output.writeObject("login~" + username + "~" + username + " sedang login...~server~\n");
            output.writeObject("list~" + username + "~" + username + " sedang login...~server~\n");
 
        } catch (IOException eIO) {
            System.out.println("Exception doing login : " + eIO);
            disconnect();
            return false;
        }
 
        return true;
    }
 
    private void disconnect() {
        try {
            // TODO add your handling code here:
            output.writeObject("logout~" + username + "~" + username + " sudah logout...~Server~\n");
        } catch (IOException ex) {
            //Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        try {
            if (input != null) {
                input.close();
            }
        } catch (Exception e) {
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (Exception e) {
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
 
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        postTextField = new javax.swing.JTextField();
        kirimButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serverTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        masukButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        viewTextArea.setEditable(false);
        viewTextArea.setColumns(20);
        viewTextArea.setLineWrap(true);
        viewTextArea.setRows(5);
        viewTextArea.setFocusable(false);
        jScrollPane1.setViewportView(viewTextArea);
 
        jScrollPane2.setViewportView(clientTable);
 
        postTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postTextFieldActionPerformed(evt);
            }
        });
 
        kirimButton.setText("Kirim");
        kirimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimButtonActionPerformed(evt);
            }
        });
 
        jLabel2.setText("Server");
 
        serverTextField.setText("127.0.0.1");
 
        jLabel3.setText("Port");
 
        portTextField.setText("9999");
 
        masukButton.setText("Masuk");
        masukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukButtonActionPerformed(evt);
            }
        });
 
        jLabel4.setText("Username");
 
        usernameTextField.setText("animous");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(postTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kirimButton))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(masukButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masukButton)
                    .addComponent(jLabel4)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(postTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kirimButton))))
                .addContainerGap())
        );
 
        pack();
    }// </editor-fold>
 
    private void masukButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.server = serverTextField.getText();
        this.port = new Integer(portTextField.getText());
        this.username = usernameTextField.getText();
        start();
    }
 
    private void kirimButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            String message = "postText~" + username + "~" + postTextField.getText() + "~all~\n";
            output.writeObject(message);
            postTextField.setText("");
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void postTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        kirimButtonActionPerformed(evt);
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JTable clientTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kirimButton;
    private javax.swing.JButton masukButton;
    private javax.swing.JTextField portTextField;
    private javax.swing.JTextField postTextField;
    private javax.swing.JTextField serverTextField;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTextArea viewTextArea;
    // End of variables declaration
 
    class ListenFromServer extends Thread {
 
        @Override
        public void run() {
            while (true) {
                try {
                    String msg = (String) input.readObject();
                    String res;
                    String type = msg.split("~")[0];
                    String pengirim = msg.split("~")[1];
                    String text = msg.split("~")[2];
                    String kepada = msg.split("~")[3];
                    switch (type) {
                        case "recieveText":
                            res = pengirim + ": " + text;
                            viewTextArea.setText(viewTextArea.getText() + res + "\n");
                            break;
                        case "recievePrivateText":
                            res = pengirim + ": " + text;
                            if (kepada.equals(username)) {
                                viewTextArea.setText(viewTextArea.getText() + res + "\n");
                            }
                            break;
                        case "login":
                            viewTextArea.setText(viewTextArea.getText() + pengirim + " sedah login..." + "\n");
                            clients.add(pengirim);
                            break;
                        case "logout":
                            viewTextArea.setText(viewTextArea.getText() + pengirim + " telah logout..." + "\n");
                            clients.remove(pengirim);
                            break;
                        case "list":
                            setTable(text);
                            break;
                    }
                } catch (IOException e) {
                    System.out.println("Server has close the connection: " + e);
                    break;
                } catch (ClassNotFoundException e2) {
                }
            }
        }
 
        private void setTable(String text) {
            int rows = text.split(":").length - 1;
            Object[][] data = new Object[rows][1];
            for (int i = 0; i < rows; i++) {
                String t = text.split(":")[i];
                data[i][0] = t;
            }
 
            String[] header = {"Clients"};
 
            clientTable.setModel(new DefaultTableModel(data, header));
        }
    }
}
