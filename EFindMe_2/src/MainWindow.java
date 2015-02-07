import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eFindMe.ESGI.SaveCustomer;
import eFindMe.ESGI.client.RelationManager;


public class MainWindow extends JFrame implements ActionListener{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String nameAPP = "EFindMe";
		private String twtnewClient = "Créer nouveau client";
		private String twtsearchRef = "Chercher référence";
		private String twtseeGraph = "Afficher Graph";
		
		//Interface
		private JPanel container = new JPanel();
		private JPanel top = new JPanel();
		private JButton newClient = new JButton (twtnewClient);
		private JButton searchRef = new JButton (twtsearchRef);
		private JButton seeGraph = new JButton (twtseeGraph);
		
	public MainWindow(){
		
		//Interface
		this.setTitle(nameAPP);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		top.setLayout(new GridLayout(14,1));
		
		newClient.addActionListener(this);
		searchRef.addActionListener(this);
		seeGraph.addActionListener(this);
		
		top.add(newClient);
		top.add(searchRef);
		top.add(seeGraph);
		
		
		container.add(top, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == newClient)
		{ 
			new SaveCustomer();
		}
		else if(arg0.getSource() == searchRef)
		{ 
			JFileChooser chooser = new JFileChooser("src/Client/");
	        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	           //Appelle Objet Benoist : "src/Client"+ chooser.getSelectedFile().getName()
	        }
		}else if(arg0.getSource() == seeGraph)
		{ 
			JFileChooser chooser = new JFileChooser("src/Graph/");
	        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	           //Appelle Objet Jerome : "src/Graph"+ chooser.getSelectedFile().getName()
	        	new RelationManager(chooser.getSelectedFile().getName());
	        }
		}
		
	}
	
}
