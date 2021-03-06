package com.lab;

import javax.swing.*;
import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
         configPanel = new ConfigPanel(this);
 //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(controlPanel, SOUTH);
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel, NORTH);

 //...TODO

        //invoke the layout manager


        pack();
    }
}
