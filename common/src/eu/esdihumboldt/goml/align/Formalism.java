/*
 * HUMBOLDT: A Framework for Data Harmonisation and Service Integration.
 * EU Integrated Project #030962                  01.10.2006 - 30.09.2010
 * 
 * For more information on the project, please refer to the this web site:
 * http://www.esdi-humboldt.eu
 * 
 * LICENSE: For information on the license under which this program is 
 * available, please refer to http:/www.esdi-humboldt.eu/license.html#core
 * (c) the HUMBOLDT Consortium, 2007 to 2010.
 */

package eu.esdihumboldt.goml.align;

import java.net.URI;

/**
 * A {@link Formalism} identifies the formal language or structure used to 
 * express a {@link Schema}.
 * 
 * @author Thorsten Reitz 
 * @partner 01 / Fraunhofer Institute for Computer Graphics Research
 * @version $Id$ 
 */
public class Formalism {

	/**
	 * The name of this {@link Formalism}.
	 */
	private String name;
	
	/**
	 * The {@link URI} identifying this {@link Formalism}.
	 */
	private URI location;
	
	// getters / setters .......................................................

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public URI getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(URI location) {
		this.location = location;
	}
	
}
