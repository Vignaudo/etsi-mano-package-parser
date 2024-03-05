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
package com.ubiqube.parser.tosca.objects.tosca.datatypes.nfv;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.ubiqube.parser.tosca.objects.tosca.datatypes.Root;

/**
 * Describes bitrate requirements applicable to the virtual link instantiated from a particicular VnfVirtualLink
 */
public class VirtualLinkBitrateLevel extends Root {
	/**
	 * Virtual link bitrate requirements for an instantiation level or bitrate delta for a scaling step
	 */
	@Valid
	@NotNull
	@JsonProperty("bitrate_requirements")
	private LinkBitrateRequirements bitrateRequirements;

	@NotNull
	public LinkBitrateRequirements getBitrateRequirements() {
		return this.bitrateRequirements;
	}

	public void setBitrateRequirements(@NotNull final LinkBitrateRequirements bitrateRequirements) {
		this.bitrateRequirements = bitrateRequirements;
	}
}
