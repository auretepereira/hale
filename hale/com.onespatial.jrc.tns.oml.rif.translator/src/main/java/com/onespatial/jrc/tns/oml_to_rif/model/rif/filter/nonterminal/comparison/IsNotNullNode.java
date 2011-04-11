/*
 * HUMBOLDT: A Framework for Data Harmonisation and Service Integration.
 * EU Integrated Project #030962                 01.10.2006 - 30.09.2010
 * 
 * For more information on the project, please refer to the this web site:
 * http://www.esdi-humboldt.eu
 * 
 * LICENSE: For information on the license under which this program is 
 * available, please refer to http:/www.esdi-humboldt.eu/license.html#core
 * (c) the HUMBOLDT Consortium, 2007 to 2010.
 */
package com.onespatial.jrc.tns.oml_to_rif.model.rif.filter.nonterminal.comparison;

import com.onespatial.jrc.tns.oml_to_rif.model.rif.filter.nonterminal.NodeType;

/**
 * A node within a predicate tree that expresses an "is not null" comparison (tests
 * whether an attribute does exist.
 * 
 * @author Susanne Reinwarth / TU Dresden
 *
 */
public class IsNotNullNode extends AbstractComparisonNode {

	/**
     * Set as protected in case this class is extended.
     */
	protected NodeType nodeType = NodeType.IS_NOT_NULL_NODE;

    @Override
    public NodeType getNodeType()
    {
        return nodeType;
    }

}
