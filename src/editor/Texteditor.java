package editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Texteditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner font;
    JLabel fontLabel;
    JLabel status;
    JButton fcolor;
    JComboBox<String> fbox;
    JMenuBar menu;
    JMenu fmenu;
    JMenuItem open;
    JMenuItem save;
    JMenuItem exit;

    Texteditor() {
    	
    	ImageIcon logo = new ImageIcon("texteditor.png");
		this.setIconImage(logo.getImage());
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Heramb's Text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateStatus();
            }
        });

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontLabel = new JLabel("Font: ");

        font = new JSpinner();
        font.setPreferredSize(new Dimension(50, 25));
        font.setValue(20);
        font.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) font.getValue()));
            }
        });

        fcolor = new JButton("Color");
        fcolor.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fbox = new JComboBox<>(fonts);
        fbox.addActionListener(this);
        fbox.setSelectedItem("Arial");

        menu = new JMenuBar();
        fmenu = new JMenu("File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        fmenu.add(open);
        fmenu.add(save);
        fmenu.add(exit);

        menu.add(fmenu);

        status = new JLabel("Words: 0 | Lines: 0");

        this.add(status);
        this.setJMenuBar(menu);
        this.add(fontLabel);
        this.add(font);
        this.add(fcolor);
        this.add(fbox);
        this.add(scrollPane);
        this.setVisible(true);

        // Initialize status bar
        updateStatus();
    }

    private void updateStatus() {
        String text = textArea.getText();
        int wordCount = text.split("\\s+").length;
        int lineCount = textArea.getLineCount();
        status.setText("Words: " + wordCount + " | Lines: " + lineCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fcolor) {
            Color color = JColorChooser.showDialog(null, "Choose a color", Color.black);
            textArea.setForeground(color);
        }

        if (e.getSource() == fbox) {
            textArea.setFont(new Font((String) fbox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }

        if (e.getSource() == open) {
            JFileChooser filec = new JFileChooser();
            filec.setCurrentDirectory(new File("."));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
            filec.setFileFilter(filter);

            int res = filec.showOpenDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                File file = new File(filec.getSelectedFile().getAbsolutePath());

                try (Scanner fin = new Scanner(file)) {
                    textArea.setText(""); // Clear the text area before loading new file
                    while (fin.hasNextLine()) {
                        textArea.append(fin.nextLine() + "\n");
                    }
                    updateStatus();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource() == save) {
            JFileChooser filec = new JFileChooser();
            filec.setCurrentDirectory(new File("."));

            int res = filec.showSaveDialog(null);

            if (res == JFileChooser.APPROVE_OPTION) {
                File file = new File(filec.getSelectedFile().getAbsolutePath());
                try (PrintWriter fileout = new PrintWriter(file)) {
                    fileout.println(textArea.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
