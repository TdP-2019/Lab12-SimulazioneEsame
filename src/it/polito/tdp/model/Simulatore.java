package it.polito.tdp.model;

import java.util.Map;

public class Simulatore {
	//TIPI DI EVENTO
	//1. Evento Criminoso
	//	1.1 La centrale seleziona 
	//		l'agente più vicino
	/*
	 * 	Calcolo il cammino minimo tra tutti i vertici che
	 * 	hanno degli agenti liberi e il vertice in cui è
	 * 	avvenuto il crimine
	 * 
	 * 
	 */
	//	1.2 Setta l'agente a occupato
	//2. Arriva agente
	//	2.1 Definisco quanto durerà l'intervento
	//	2.2 Controlla se l'evento
	//		è mal gestito
	//3. Crimine terminato
	//	3.1 Libero l'agente
	
	// Strutture dati che ci servono
	private Integer malGestiti;
	private Integer N;
	private Integer anno;
	private Integer mese;
	private Integer giorno;
	
	//mappa di distretto-# agenti
	private Map<Integer,Integer> agenti;
	
	//
	
}
