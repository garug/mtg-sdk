package br.com.garug.mtg.implementations;

import br.com.garug.mtg.MTGApi;
import br.com.garug.mtg.entities.enums.MTGEntityEnum;
import br.com.garug.mtg.entities.implementations.Card;

public interface SetMTGApi extends MTGApi {
MTGEntityEnum type = MTGEntityEnum.CARD;
	// TODO change entity to ENUM
	public default Card findOne(Integer id) {
		return (Card) MTGApi.findOne(id, type);
	}
}
