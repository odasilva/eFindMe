package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class ClientRelationGraph extends JPanel{
	
	private Customer client;
	private JPanel parentContainer;
	private mxGraph graph;
	private final String RECTANGLES_COLOR = mxConstants.STYLE_FILLCOLOR + "=#2E9AFE";
	private final String POSITIVE_RELATION_COLOR = mxConstants.STYLE_FILLCOLOR + "=#01DF01";
	private final String NEGATIVE_RELATION_COLOR = mxConstants.STYLE_FILLCOLOR + "=#FE2E2E";
	
	public ClientRelationGraph(Customer c,JPanel _parent)
	{
		super(new BorderLayout());
		parentContainer = _parent;
		client = c;
		graph = new mxGraph();
		createRectangles();
	}
	
	
	
	public void createRectangles()
	{
		graph.getModel().beginUpdate();
		mxCell clientRectangle = (mxCell) graph.insertVertex(null,null,client.getName(),430,220,160,60);
		clientRectangle.setStyle(RECTANGLES_COLOR);
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		add(graphComponent);
	    graph.getModel().endUpdate();
	}

}
