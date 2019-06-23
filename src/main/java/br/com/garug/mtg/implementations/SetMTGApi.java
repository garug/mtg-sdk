package br.com.garug.mtg.implementations;

import br.com.garug.mtg.MTGApi;
import br.com.garug.mtg.entities.enums.MTGEntityEnum;
import br.com.garug.mtg.entities.implementations.Set;

public interface SetMTGApi extends MTGApi {
MTGEntityEnum type = MTGEntityEnum.SET;
	public default Set findOne(String id) {
		return (Set) MTGApi.findOne(id, type);
	}
}
