package br.com.garug.mtg.entities.implementations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.garug.mtg.entities.MTGEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Set extends MTGEntity {
	// Searchables parameters
	private String name;
	private String block;
	// Non-searchables parameters
	private String code;
	private String gathererCode;
	private String oldCode;
	private String magicCardsInfoCode;
	private String releaseDate;
	private String border;
	private String expansion;
	private String type;
	private Boolean onlineOnly;
	private String[] cards;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGathererCode() {
		return gathererCode;
	}
	public void setGathererCode(String gathererCode) {
		this.gathererCode = gathererCode;
	}
	public String getOldCode() {
		return oldCode;
	}
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}
	public String getMagicCardsInfoCode() {
		return magicCardsInfoCode;
	}
	public void setMagicCardsInfoCode(String magicCardsInfoCode) {
		this.magicCardsInfoCode = magicCardsInfoCode;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getBorder() {
		return border;
	}
	public void setBorder(String border) {
		this.border = border;
	}
	public String getExpansion() {
		return expansion;
	}
	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getOnlineOnly() {
		return onlineOnly;
	}
	public void setOnlineOnly(Boolean onlineOnly) {
		this.onlineOnly = onlineOnly;
	}
	public String[] getCards() {
		return cards;
	}
	public void setCards(String[] cards) {
		this.cards = cards;
	}
	
	
}
