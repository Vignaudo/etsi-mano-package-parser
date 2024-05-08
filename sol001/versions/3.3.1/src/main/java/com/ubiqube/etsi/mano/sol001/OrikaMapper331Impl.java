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
package com.ubiqube.etsi.mano.sol001;

import java.util.HashMap;
import java.util.Map;

import com.ubiqube.etsi.mano.service.pkg.tosca.Frequency2Converter;
import com.ubiqube.etsi.mano.service.pkg.tosca.Range2Converter;
import com.ubiqube.etsi.mano.service.pkg.tosca.Size2Converter;
import com.ubiqube.etsi.mano.service.pkg.tosca.Time2Converter;
import com.ubiqube.parser.tosca.Artifact;
import com.ubiqube.parser.tosca.api.ToscaMapper;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.VNF;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.VnfVirtualLink;
import com.ubiqube.parser.tosca.objects.tosca.nodes.nfv.vdu.Compute;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import tosca.datatypes.nfv.SwImageData;

public class OrikaMapper331Impl implements ToscaMapper {

	private static final String MONITORING_PARAMETERS_NAME_LIST = "monitoringParameters{name}";
	private static final String MONITORING_PARAMETERS_LIST = "monitoringParameters{}";
	private static final String MONITORING_PARAMETERS_KEY_MAP = "monitoringParameters{key}";
	private static final String MONITORING_PARAMETERS_VALUE_MAP = "monitoringParameters{value}";
	private final MapperFacade mapper;

	public OrikaMapper331Impl() {
		final DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		final ConverterFactory conv = mapperFactory.getConverterFactory();
		conv.registerConverter(new Size2Converter());
		conv.registerConverter(new Frequency2Converter());
		conv.registerConverter(new Time2Converter());
		conv.registerConverter(new Range2Converter());
		configureMapper(mapperFactory);
		mapper = mapperFactory.getMapperFacade();
	}

	public void configureMapper(final MapperFactory mapper) {
		mapper.classMap(VnfVirtualLink.class, tosca.nodes.nfv.VnfVirtualLink.class)
				.field(MONITORING_PARAMETERS_VALUE_MAP, MONITORING_PARAMETERS_LIST)
				.field(MONITORING_PARAMETERS_KEY_MAP, MONITORING_PARAMETERS_NAME_LIST)
				.byDefault()
				.register();
		mapper.classMap(VNF.class, tosca.nodes.nfv.VNF.class)
				.field(MONITORING_PARAMETERS_VALUE_MAP, MONITORING_PARAMETERS_LIST)
				.field(MONITORING_PARAMETERS_KEY_MAP, MONITORING_PARAMETERS_NAME_LIST)
				.byDefault()
				.register();
		mapper.classMap(Compute.class, tosca.nodes.nfv.vdu.Compute.class)
				.field(MONITORING_PARAMETERS_VALUE_MAP, MONITORING_PARAMETERS_LIST)
				.field(MONITORING_PARAMETERS_KEY_MAP, MONITORING_PARAMETERS_NAME_LIST)
				.customize(new CustomMapper<Compute, tosca.nodes.nfv.vdu.Compute>() {
					@Override
					public void mapBtoA(final tosca.nodes.nfv.vdu.Compute b, final Compute a, final MappingContext context) {
						if (null == a.getArtifacts()) {
							a.setArtifacts(new HashMap<>());
						}
						final Map<String, Artifact> tgt = a.getArtifacts();
						if (b.getArtifacts() != null) {
							tgt.putAll(b.getArtifacts());
						}
						if (null != b.getSwImageData()) {
							final SwImageData swid = b.getSwImageData();
							if (tgt.get(swid.getName()) != null) {
								return;
							}
							final ArtifactConverter cnv = new ArtifactConverter();
							final Artifact res = cnv.convertTo(swid, null, context);
							tgt.put(swid.getName(), res);
						}
						super.mapBtoA(b, a, context);
					}

				})
				.byDefault()
				.register();
	}

	@Override
	public <U> U map(final Object x, final Class<U> dest) {
		return mapper.map(x, dest);
	}
}
