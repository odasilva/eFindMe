package eFindMe.ESGI.client;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.Document;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;

public class ClientRelationGraph extends JPanel{
	
	private Customer client;
	private mxGraph graph;
	private final String RECTANGLES_COLOR = mxConstants.STYLE_FILLCOLOR + "=#2E9AFE";
	private final String POSITIVE_RELATION_COLOR = mxConstants.STYLE_FILLCOLOR + "=#01DF01";
	private final String NEGATIVE_RELATION_COLOR = mxConstants.STYLE_FILLCOLOR + "=#FE2E2E";
	private RelationManager parentFrame;
	private Document doc;
	private String xml;
	private mxCell clientEllipse;
	private mxCell parent;
	private mxGraphComponent graphComponent;
	public mxCell selectedCell;
	
	
	public ClientRelationGraph(RelationManager window, Customer c,Document d)
	{
		super(new BorderLayout());
		parentFrame = window;
		client = c;
		doc = d;
		selectedCell = null;
		
		graph = new mxGraph();
		graphComponent = new mxGraphComponent(graph);
		
		
		graph.getSelectionModel().addListener(mxEvent.CHANGE, new mxIEventListener() {

			@Override
			public void invoke(Object arg0, mxEventObject arg1) {
				mxGraphSelectionModel model = (mxGraphSelectionModel)arg0;
				if(model.getCells()[0] == null)
				{
					graph.getSelectionModel().clear();
					return;
				}
				mxCell cell = (mxCell)model.getCells()[0];
				if(cell.isVertex())
				{
					selectedCell = cell;
					parentFrame.setDescription((Reference)cell.getValue());
				}
			}
		});
		
		
		graph.getModel().beginUpdate();
		
		createClientEllipse(client.getSociety(),700,300,220,110);
		parent = (mxCell)graph.getDefaultParent();
		
		/*c.getReferencesList().add(new Reference("test", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test1", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test3", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test1", "azeaz@az.fr", "true"));
		c.getReferencesList().add(new Reference("test3", "azeaz@az.fr", "true"));*/
		

		
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
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r,xPos,yPos,width,height
					,POSITIVE_RELATION_COLOR);
		}
		if(r.getIsPositive().equals("false"))
		{
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r,xPos,yPos,width,height
					,NEGATIVE_RELATION_COLOR);
		}
		if(r.getIsPositive().equals(""))
		{
			 rect = (mxCell) graph.insertVertex(null,r.getUrl(),r,xPos,yPos,width,height
					,RECTANGLES_COLOR);
		}
		
	   return rect;
	}
	
	public void createClientEllipse(String text,int xPos,int yPos,int width,int height)
	{
		graph.getModel().beginUpdate();
		clientEllipse = (mxCell) graph.insertVertex(null,null,text,xPos,yPos,width,height
				,mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE);
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
	
	
	public void editSelectedReference(String appreciation)
	{
		if(selectedCell == null)
			return;
		if(appreciation.equals("POSITIF"))
		{
			selectedCell.setStyle(POSITIVE_RELATION_COLOR);
			Reference ref = (Reference)selectedCell.getValue();
			ref.setIsPositive("true");
			parentFrame.setDescription(ref);
		}
		if(appreciation.equals("NEGATIF"))
		{
			selectedCell.setStyle(NEGATIVE_RELATION_COLOR);
			Reference ref = (Reference)selectedCell.getValue();
			ref.setIsPositive("false");
			parentFrame.setDescription(ref);
		}
		if(appreciation.equals("NEUTRE"))
		{
			selectedCell.setStyle(RECTANGLES_COLOR);
			Reference ref = (Reference)selectedCell.getValue();
			ref.setIsPositive("");
			parentFrame.setDescription(ref);
		}
		
		graphComponent.refresh();
	}
	
	public void deleteSelectedReference()
	{
		if(selectedCell == null)
			return;
		graph.removeCells(new Object[]{selectedCell});
		graphComponent.refresh();
	}

}
