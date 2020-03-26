package com.lab;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
 //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)

       //setLayout(new GridLayout(4, 4));
        //add all buttons ...TODO
        this.add(saveBtn);
        this.add(loadBtn);
        this.add(resetBtn);
        this.add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::clear);
        exitBtn.addActionListener(this::exit);
 //...TODO
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("d:/test.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.canvas.repaint();
    }

    private void clear(ActionEvent e) {
        //aici am incercat sa fac pagina goala doar ca nu mai mergea sa desenezi dupa,asa ca am facut alta varianta
         /*   Graphics2D graphics;
            frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
            graphics = frame.canvas.image.createGraphics();
            graphics.setColor(Color.WHITE); //fill the image with white
            graphics.fillRect(0, 0, 800, 600);
             frame.canvas.repaint();*/

        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fill(new RegularPolygon(800, 600, 800*600, 4));
        frame.canvas.repaint();

    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }


 //...TODO
}
