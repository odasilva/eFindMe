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
	private mxCell clientEllipse;
	private mxCell parent;
	
	
	public ClientRelationGraph(Customer c,JPanel _parent,Document d)
	{
		super(new BorderLayout());
		parentContainer = _parent;
		client = c;
		doc = d;
		graphItemsMap = new HashMap<String, mxCell>();
		
		graph = new mxGraph();
		
		graph.getModel().beginUpdate();
		
		createClientEllipse(client.getSociety(),700,300,220,110);
		parent = (mxCell)graph.getDefaultParent();
		/*c.getReferencesList().add(new Reference("test", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test1", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test3", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test1", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test3", "azeaz@az.fr", "true"));
		*/
		
		
			for (int i = 0; i < client.getReferencesList().size(); i++)
			{
				Reference ref = client.getReferencesList().get(i);
				switch (i) {
				
				case 0:
					mxCell cell = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX()
							, clientEllipse.getGeometry().getY() - 250
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell);
					break;
					
				case 1:
					mxCell cell1 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX()
							, clientEllipse.getGeometry().getY() + 270
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell1);
					break;
					
				case 2:
					mxCell cell2 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() + 600
							, clientEllipse.getGeometry().getY()
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell2);
					break;
					
				case 3:
					mxCell cell3 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() - 600
							, clientEllipse.getGeometry().getY()
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell3);
					break;
					
				case 4:
					mxCell cell4 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() + 300
							, clientEllipse.getGeometry().getY() - 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell4);
					break;
					
				case 5:
					mxCell cell5 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() - 300
							, clientEllipse.getGeometry().getY() - 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell5);
					break;
					
				case 6:
					mxCell cell6 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() + 300
							, clientEllipse.getGeometry().getY() + 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell6);
				case 7:
					mxCell cell7 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() - 300
							, clientEllipse.getGeometry().getY() + 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell7);
					break;
					
				case 8:
					mxCell cell8 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() + 600
							, clientEllipse.getGeometry().getY() - 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell8);
				case 9:
					mxCell cell9 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() - 600
							, clientEllipse.getGeometry().getY() + 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell9);
					break;
					
					
				case 10:
					mxCell cell10 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() - 600
							, clientEllipse.getGeometry().getY() + 200
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell10);
					break;



				default :
					mxCell cell11 = createReferenceEllipse(ref
							, clientEllipse.getGeometry().getX() 
							, clientEllipse.getGeometry().getY()
							, 220, 110);
					graph.insertEdge(clientEllipse,null, ref.getUrl(), clientEllipse, cell11);
					break;
				}
				
			
		}
		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		add(graphComponent);
		graph.setCellsMovable(false);
		graph.getModel().endUpdate();
	}
	
	
	
	public mxCell createReferenceEllipse(Reference r,double xPos,double yPos,int width,int height)
	{
		
		mxCell rect = null;
		if(r.getIsPositive().equals("true"))
		{
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r.getSource(),xPos,yPos,width,height
					,POSITIVE_RELATION_COLOR);
		}
		if(r.getIsPositive().equals("false"))
		{
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r.getSource(),xPos,yPos,width,height
					,NEGATIVE_RELATION_COLOR);
		}
		if(r.getIsPositive().equals(""))
		{
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r.getSource(),xPos,yPos,width,height
					,RECTANGLES_COLOR);
		}
		
	   return rect;
	}
	
	public void createClientEllipse(String text,int xPos,int yPos,int width,int height)
	{
		graph.getModel().beginUpdate();
		clientEllipse = (mxCell) graph.insertVertex(null,null,text,xPos,yPos,width,height
				,mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
		graphItemsMap.put(text, clientEllipse);
	    graph.getModel().endUpdate();
	}
	
	
	public void setPositiveColor(mxCell obj)
	{
		graph.getModel().beginUpdate();
		graph.setCellStyle(POSITIVE_RELATION_COLOR, new Object[]{obj});
		obj.setStyle(obj.getStyle() + (POSITIVE_RELATION_COLOR));
		graph.getModel().endUpdate();
	}
	
	public void setNegativeColor(mxCell obj)
	{
		obj.setStyle(NEGATIVE_RELATION_COLOR);
	}
	

}
