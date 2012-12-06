/*
 * Copyright (c) 2012 Fraunhofer IGD
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Fraunhofer IGD
 */

package eu.esdihumboldt.hale.io.xslt;

import javax.xml.namespace.NamespaceContext;

/**
 * Context for a XSLT generation process.
 * 
 * @author Simon Templer
 */
public interface XsltGenerationContext {

	/**
	 * Namespace URI for XSLT.
	 */
	public static final String NS_URI_XSL = "http://www.w3.org/1999/XSL/Transform";

	/**
	 * Get the namespace context available for the XSLT.
	 * 
	 * @return the namespace context holding the association of prefixes to
	 *         namespaces
	 */
	public NamespaceContext getNamespaceContext();

}
