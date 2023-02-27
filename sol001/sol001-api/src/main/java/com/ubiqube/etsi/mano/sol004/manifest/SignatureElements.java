/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.sol004.manifest;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
public class SignatureElements {
	private String source;
	private String algorithm;
	private String hash;
	private String signature;
	private String certificate;

	public SignatureElements(final String source, final String algorithm, final String hash, final String signature, final String certificate) {
		super();
		this.source = source;
		this.algorithm = algorithm;
		this.hash = hash;
		this.signature = signature;
		this.certificate = certificate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(final String source) {
		this.source = source;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(final String algorithm) {
		this.algorithm = algorithm;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(final String hash) {
		this.hash = hash;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(final String signature) {
		this.signature = signature;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(final String certificate) {
		this.certificate = certificate;
	}

}
