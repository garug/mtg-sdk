package br.com.garug.mtg.implementations;

import br.com.garug.mtg.MTGApi;
import br.com.garug.mtg.entities.enums.MTGEntityEnum;
import br.com.garug.mtg.entities.implementations.Card;

public interface CardMTGApi extends MTGApi {
	
	MTGEntityEnum type = MTGEntityEnum.CARD;
	
	public default Card findOne(String id) {
		return (Card) MTGApi.findOne(id, type);
	}
}
