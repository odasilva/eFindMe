package eFindMe.ESGI.client;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class ClientRelationGraph extends JPanel{
	
	private Customer client;
	private JPanel parent;
	private mxGraph graph;
	
	public ClientRelationGraph(Customer c,JPanel _parent)
	{
		super(new BorderLayout());
		client = c;
		graph = new mxGraph();
		createSquare();
	}
	
	
	
	public void createSquare()
	{
		graph.getModel().beginUpdate();
		Object square = graph.insertVertex(parent,null,client.getName(),20,20,80,30);
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		add(graphComponent);
	    graph.getModel().endUpdate();
	}

}
