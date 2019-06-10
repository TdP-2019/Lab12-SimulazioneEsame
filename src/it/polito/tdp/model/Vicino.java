package it.polito.tdp.model;

public class Vicino implements Comparable<Vicino>{
	private Integer v;
	private Double distanza;
	
	public Vicino(Integer v, Double distanza) {
		super();
		this.v = v;
		this.distanza = distanza;
	}
	
	public Integer getV() {
		return v;
	}
	public void setV(Integer v) {
		this.v = v;
	}
	public Double getDistanza() {
		return distanza;
	}
	public void setDistanza(Double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int compareTo(Vicino o) {
		return this.distanza.
				compareTo(o.getDistanza());
	}
	
}
