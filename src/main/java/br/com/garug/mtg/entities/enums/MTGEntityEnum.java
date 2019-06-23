package br.com.garug.mtg.entities.enums;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.garug.mtg.entities.implementations.Card;
import br.com.garug.mtg.entities.implementations.Set;

public enum MTGEntityEnum {
	CARD("card", "cards", new ObjectMapper().getTypeFactory().constructType(Card.class)),
	SET("set", "sets", new ObjectMapper().getTypeFactory().constructType(Set.class));
	
	private String one;
	private String multiple;
	private JavaType javaType;
	
	private MTGEntityEnum(String one, String multiple, JavaType type) {
		this.one = one;
		this.multiple = multiple;
		this.javaType = type;
	}

	public String getOne() {
		return one;
	}

	public String getMultiple() {
		return multiple;
	}
	
	public JavaType getJavaType() {
		return javaType;
	}
}
