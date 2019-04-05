package view.visualization;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Visualizer extends JFrame {
	
	private static final long serialVersionUID = 1L;

    public Visualizer() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
    }
    
    private void init() {
        BubbleSortVisualization bsv = new BubbleSortVisualization();
        bsv.frame = this;
        setTitle("Bubble Sort Visualization");
        setResizable(false);
        //bsv.setPreferredSize(new Dimension(bsv.width, bsv.height));
        //bsv.setMinimumSize(new Dimension(bsv.width, bsv.height));
        //setLocationRelativeTo(null);
        add(bsv, BorderLayout.CENTER);
        bsv.init();
        pack();
        setVisible(true);
    }
    
}
