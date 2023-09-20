package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
public  class JavaApplication1 extends JFrame implements ActionListener{
    JTextArea area;
    String text;
    JavaApplication1(){ 
        setTitle("Notepad");
        // ImageIcon will be written in this line
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        
        JMenu file = new JMenu("FIle");
        file.setFont(new Font("Aerial",Font.PLAIN,14));
        
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.addActionListener(this);
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK ));
        file.add(newdoc);
        
        JMenuItem Open = new JMenuItem("Open");
        Open.addActionListener(this);
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK ));
        file.add(Open);
        
        JMenuItem Save = new JMenuItem("Save");
        Save.addActionListener(this);
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK ));
        file.add(Save);
        
        JMenuItem Print = new JMenuItem("Print");
        Print.addActionListener(this);
        Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK ));
        file.add(Print);
        
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK ));
        file.add(Exit); 
        
        menubar.add(file);
        
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("Aerial",Font.PLAIN,14));
        
        JMenuItem Copy = new JMenuItem("Copy");
        Copy.addActionListener(this);
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK ));
        edit.add(Copy);
        
        JMenuItem Paste = new JMenuItem("Paste");
        Paste.addActionListener(this);
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK ));
        edit.add(Paste);
        
        JMenuItem Cut = new JMenuItem("Cut");
        Cut.addActionListener(this);
        Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK ));
        edit.add(Cut);
        
        JMenuItem SelectAll = new JMenuItem("SelectAll");
        SelectAll.addActionListener(this);
        SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK ));
        edit.add(SelectAll);
        
        
        menubar.add(edit);
        
        JMenu HelpMenu = new JMenu("Help");
        HelpMenu.setFont(new Font("Aerial",Font.PLAIN,14));
        
        JMenuItem Help = new JMenuItem("About");
        Help.addActionListener(this);
        Help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK ));
        edit.add(Help);
        
        HelpMenu.add(Help);
        menubar.add(HelpMenu);
        
        setJMenuBar(menubar);
        
        area = new JTextArea();
        area.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        add(area);
        
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("New")){
              area.setText("");
        }else if(e.getActionCommand().equals("Open")){
             JFileChooser chooser = new JFileChooser();
             chooser.setAcceptAllFileFilterUsed(false);
             FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
             chooser.addChoosableFileFilter(restrict);
             
             int action = chooser.showOpenDialog(this);
             if(action != JFileChooser.APPROVE_OPTION){
                 return;
             }
             File file = chooser.getSelectedFile();
             try {
                 BufferedReader reader = new BufferedReader(new FileReader(file));
                 area.read(reader,null);
             }
             catch(Exception ae){
                 ae.printStackTrace();
             }
        }else if(e.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("Save");
            
            int action = saveas.showOpenDialog(this);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File filename = new File(saveas.getSelectedFile()+".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getActionCommand().equals("Print")){
            try {
                area.print();
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }else if(e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Copy")){
               text = area.getSelectedText();
        }
        else if(e.getActionCommand().equals("Paste")){
               area.insert(text,area.getCaretPosition());
        
        }else if(e.getActionCommand().equals("Cut")){
            text = area.getSelectedText();
            area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
        }else if(e.getActionCommand().equals("SelectAll")){
            area.selectAll();
        }else if(e.getActionCommand().equals("About")){
             new About().setVisible(true);
        }
        
      //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        JavaApplication1 javaApplication1 = new JavaApplication1();
        
    }
    
    
}
