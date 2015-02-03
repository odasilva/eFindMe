package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
	private Map<String , mxCell> graphItemsMap;
	private Document doc;
	private String xml;
	
	
	public ClientRelationGraph(Customer c,JPanel _parent,Document d)
	{
		super(new BorderLayout());
		parentContainer = _parent;
		client = c;
		doc = d;
		
		graph = new mxGraph();
		
		
		createRectangle(client.getName(),430,220,160,60);
		createRectangle("test", 430, 100, 160, 60);
	}
	
	
	
	public void createRectangle(String text,int xPos,int yPos,int width,int height)
	{
		graph.getModel().beginUpdate();
		mxCell rect = (mxCell) graph.insertVertex(null,null,text,xPos,yPos,width,height
				,mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_DOUBLE_ELLIPSE);
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		add(graphComponent);
	    graph.getModel().endUpdate();
	}
	
	public void setPositiveColor(mxCell obj)
	{
		graph.getModel().beginUpdate();
		obj.setStyle(POSITIVE_RELATION_COLOR);
		graph.getModel().endUpdate();
	}
	
	public void setNegativeColor(mxCell obj)
	{
		obj.setStyle(NEGATIVE_RELATION_COLOR);
	}
	

}
