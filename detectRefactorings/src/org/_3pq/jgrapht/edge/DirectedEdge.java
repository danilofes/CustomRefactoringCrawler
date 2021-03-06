/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Lead:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2004, by Barak Naveh and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
/* -----------------
 * DirectedEdge.java
 * -----------------
 * (C) Copyright 2003, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   -
 *
 * $Id: DirectedEdge.java,v 1.2 2005/09/17 19:19:50 can Exp $
 *
 * Changes
 * -------
 * 24-Jul-2003 : Initial revision (BN);
 * 10-Aug-2003 : General edge refactoring (BN);
 *
 */
package org._3pq.jgrapht.edge;


/**
 * A implementation of directed edge.
 *
 * @author Barak Naveh
 *
 * @since Jul 14, 2003
 */
public class DirectedEdge extends DefaultEdge {
    private String label;

	/**
     * @see DefaultEdge#DefaultEdge(Object, Object)
     */
    public DirectedEdge( Object sourceVertex, Object targetVertex ) {
        super( sourceVertex, targetVertex );
    }

    /**
	 * @param source
	 * @param target
	 * @param label
	 */
	public DirectedEdge(Object source, Object target, String label) {
		super(source, target);
		setLabel(label);
	}

	/**
     * Returns a string representation of this directed edge. The
     * representation is a parenthesized pair (v1,v2) where v1 is the source
     * vertex of this edge and v2 is the target vertex of this edge.
     *
     * @return a string representation of this directed edge.
     */
    public String toString(  ) {
        return "(" + getSource(  ) + "," + getTarget(  ) + ")";
    }

	/* (non-Javadoc)
	 * @see org._3pq.jgrapht.LabeledElement#setLabel(java.lang.Object)
	 */
	public void setLabel(String label) {
		this.label = label;
		
	}

	/* (non-Javadoc)
	 * @see org._3pq.jgrapht.LabeledElement#getLabel()
	 */
	public Object getLabel() {
		return label;
	}

	/* (non-Javadoc)
	 * @see org._3pq.jgrapht.LabeledElement#hasLabel()
	 */
	public boolean hasLabel() {
		return label != null;
	}

	
}
