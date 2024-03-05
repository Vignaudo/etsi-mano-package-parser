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
package com.ubiqube.parser.tosca.objects.tosca.policies.nfv;

import java.util.List;

import jakarta.validation.Valid;

import com.ubiqube.parser.tosca.objects.tosca.policies.Root;

/**
 * The NsAutoScale policy type is a base policy type for defining NS auto-scale
 * specific policies as defined in ETSI GS NFV-IFA 014 [2].tosca.nodes.nfv.NS
 */
public class NsAutoScale extends Root {
	@Valid
	private List<String> targets;

	public List<String> getTargets() {
		return this.targets;
	}

	public void setTargets(final List<String> targets) {
		this.targets = targets;
	}
}
