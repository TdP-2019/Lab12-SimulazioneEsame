package it.polito.tdp.model;

import java.time.LocalDateTime;

public class Evento implements Comparable<Evento>{

	public enum TipoEvento{
		CRIMINE,
		ARRIVA_AGENTE,
		GESTITO
	}
	
	private TipoEvento tipo;
	private LocalDateTime data;
	private Event crimine;
	
	public Evento(TipoEvento tipo, LocalDateTime data, Event crimine) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.crimine = crimine;
	}
	
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Event getCrimine() {
		return crimine;
	}
	public void setCrimine(Event crimine) {
		this.crimine = crimine;
	}

	@Override
	public int compareTo(Evento o) {
		return this.data.compareTo(o.getData());
	}
	
	
	
}
