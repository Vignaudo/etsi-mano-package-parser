/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.sol001;

import java.util.HashMap;
import java.util.Map;

import com.ubiqube.parser.tosca.Artifact;
import com.ubiqube.parser.tosca.objects.tosca.artifacts.nfv.SwImage;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.vdu.OsContainer;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ArtifactStorageMapper extends CustomMapper<OsContainer, tosca.nodes.nfv.vdu.OsContainer> {

	@Override
	public void mapBtoA(final tosca.nodes.nfv.vdu.OsContainer b, final OsContainer a, final MappingContext context) {
		if (null == a.getArtifacts()) {
			a.setArtifacts(new HashMap<>());
		}
		final Map<String, Artifact> tgt = a.getArtifacts();
		map(tgt, b.getArtifacts());
		super.mapBtoA(b, a, context);
	}

	private void map(final Map<String, Artifact> tgt, final Map<String, Artifact> artifacts) {
		if (null == artifacts) {
			return;
		}
		artifacts.entrySet().forEach(x -> {
			final SwImage obj = mapperFacade.map(x.getValue(), SwImage.class);
			tgt.put(x.getKey(), obj);
		});
	}

}
