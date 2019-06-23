package br.com.garug.mtg.implementations;

import java.util.List;

import br.com.garug.mtg.MTGApi;
import br.com.garug.mtg.entities.enums.MTGEntityEnum;
import br.com.garug.mtg.entities.implementations.Card;

public interface CardMTGApi extends MTGApi {

	MTGEntityEnum type = MTGEntityEnum.CARD;

	public default Card findOne(String id) {
		return (Card) MTGApi.findOne(id, type);
	}
	
	@SuppressWarnings("unchecked")
	public default List<Card> findAll() {
		return (List<Card>) MTGApi.findAll(type);
	}
}
