/*
	Copyright 2020 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.opml;

import be.ceau.opml.entity.Body;
import be.ceau.opml.entity.Opml;
import be.ceau.opml.entity.Outline;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ApplicationTest {

	@Test
	public void test() throws OpmlParseException {

		Opml opml = SampleReader.parse("/data.opml");
		System.out.println(opml.getHead());
		System.out.println(opml.getVersion());
		System.out.println(opml.getBody());
		Body body = opml.getBody();
		List<Outline> list = body.getOutlines();
		print(list);
	}

	public void print(List<Outline> list) {
		if (list == null && list.size() ==0) {
			return;
		}
		for (Outline outline : list) {
			if (outline.getSubElements().size() >0) {
				System.out.println(outline.getAttribute("text"));
				print(outline.getSubElements());
			}
		}
	}
}
