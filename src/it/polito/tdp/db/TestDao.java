package it.polito.tdp.db;

import it.polito.tdp.model.Event;

public class TestDao {

	public static void main(String[] args) {
		EventsDao dao = new EventsDao();
		for(Event e : dao.listAllEvents())
			System.out.println(e);
	}

}
