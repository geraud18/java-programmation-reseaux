package com.kbytes.threads;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Synchronized extends Applet
        implements ActionListener, Runnable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel pnlButtonBar = new Panel();
    private Button btnStartNormal = new Button("Non synchronisé");
    private Button btnStartSynchronized = new Button("Synchronisé");
    private Canvas cnvGraphic = new Canvas();
    private Label lblStatus = new Label("Choisissez un mode d'exécution");

    private boolean drawMode = false;
    private int x, y;

    public void init() {
        pnlButtonBar.setLayout(new FlowLayout());
        pnlButtonBar.add(btnStartNormal);
        pnlButtonBar.add(btnStartSynchronized);
        btnStartNormal.addActionListener(this);
        btnStartSynchronized.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(pnlButtonBar, BorderLayout.NORTH);

        cnvGraphic.setBackground(Color.white);
        this.add(cnvGraphic, BorderLayout.CENTER);

        this.add(lblStatus, BorderLayout.SOUTH);
    }

    public void plot() {
        this.cnvGraphic.getGraphics().drawLine(this.x,this.y,this.x,this.y);
        if (++this.x >= 300) { this.x=0; this.y++; }
    }

    public void run() {
        while(this.y < 100) {
            if (drawMode) {
                synchronized(this) { this.plot(); }
            } else {
                this.plot();
            }
        }
    }

    public void actionPerformed(ActionEvent event) {
        this.drawMode = (event.getSource() == btnStartSynchronized );
        this.cnvGraphic.repaint();
        this.x = this.y = 0;

        (new Thread(this)).start();
        (new Thread(this)).start();
        (new Thread(this)).start();
    }
}