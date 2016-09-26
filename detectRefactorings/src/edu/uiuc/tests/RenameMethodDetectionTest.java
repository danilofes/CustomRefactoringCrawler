package edu.uiuc.tests;

import junit.framework.TestCase;

import org._3pq.jgrapht.graph.AbstractBaseGraph;
import org._3pq.jgrapht.graph.DirectedMultigraph;

import edu.uiuc.detectRefactorings.detection.RenameMethodDetection;
import edu.uiuc.detectRefactorings.util.Node;

public class RenameMethodDetectionTest extends TestCase {

	private AbstractBaseGraph g1;

	private AbstractBaseGraph g2;

	Node node1, node2, node11, node21;

	RenameMethodDetection detector;

	public void setUp() {
		g1 = new DirectedMultigraph();
		node1 = new Node("pack1/class1/method1", "method");
		g1.addVertex(node1);
		node2 = new Node("pack1/class2/method2", "method");
		g1.addVertex(node2);

		g2 = new DirectedMultigraph();
		node11 = new Node("pack1/class1/method1", "method");
		g2.addVertex(node11);
		node21 = new Node("pack1/class2/method2", "method");
		g2.addVertex(node21);
		detector = new RenameMethodDetection(g1, g2);
	}

	public void test_NoCallers() {
		double likeliness = detector.analyzeIncomingEdges(node1, node11);
		assertEquals(0, likeliness, .001);
	}

	public void testSimilar_SimilarCallGraph() {
		g1.addEdge(node1, node2, Node.METHOD_CALL);
		g2.addEdge(node21, node21, Node.METHOD_CALL);
		
		g1.addEdge(node2, node2, Node.METHOD_CALL);
		double likeliness = detector.analyzeIncomingEdges(node2, node21);
		assertEquals(.75, likeliness, .001);
		

	}
	
	public void testSimilar_SameCallGraph() {
		g1.addEdge(node1, node2, Node.METHOD_CALL);
		g2.addEdge(node11, node21, Node.METHOD_CALL);
		
		g1.addEdge(node2, node2, Node.METHOD_CALL);
		g2.addEdge(node21, node21, Node.METHOD_CALL);
		double likeliness = detector.analyzeIncomingEdges(node2, node21);
		assertEquals(1.0, likeliness, .001);
	}
	
	public void testNotSimilar() {
		g1.addEdge(node1,node2, Node.METHOD_CALL);
		
		double likeliness = detector.analyzeIncomingEdges(node2, node21);
		assertEquals(0, likeliness, .001);
	}
	
	public void testNotSimilar_25Similarity() {
		g1.addEdge(node2, node1, Node.METHOD_CALL);
		g1.addEdge(node2, node2, Node.METHOD_CALL);
		
		g2.addEdge(node21, node11, Node.METHOD_CALL);
		
		double likeliness = detector.analyzeIncomingEdges(node2, node21);
		assertEquals(.0, likeliness, .001);
	}
}
