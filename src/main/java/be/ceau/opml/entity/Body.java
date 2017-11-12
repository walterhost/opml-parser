/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		https://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.opml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the content of the outline. Must have at least one outline element.
 */
public class Body implements Serializable {

	private static final long serialVersionUID = 1510395846940L;

	// A <body> contains one or more <outline> elements
	private final List<Outline> outlines = new ArrayList<>();

	public void addOutline(Outline outline) {
		if (outline != null) {
			this.outlines.add(outline);
		}
	}

	/**
	 * @return mutable {@link List} holding every {@link Outline} in this {@link Body}
	 */
	public List<Outline> getOutlines() {
		return outlines;
	}

	/**
	 * @return {@link Outline} at the given index, or {@code null} if there is no element at that index
	 */
	public Outline getOutline(int index) {
		if (index < outlines.size()) {
			return outlines.get(index);
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Body [outlines=");
		for (Outline outline : outlines) {
			sb.append(System.lineSeparator()).append(outline);
		}
		return sb.append("]").toString();
	}

}