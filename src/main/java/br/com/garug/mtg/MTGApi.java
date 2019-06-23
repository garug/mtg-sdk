package br.com.garug.mtg;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.garug.mtg.entities.MTGEntity;
import br.com.garug.mtg.entities.enums.MTGEntityEnum;
import br.com.garug.mtg.implementations.CardMTGApi;
import br.com.garug.mtg.implementations.SetMTGApi;

public interface MTGApi {
	Logger LOGGER = LoggerFactory.getLogger(MTGApi.class);
    String API_URL = "https://api.magicthegathering.io/v1";
    CardMTGApi card = new CardMTGApi() {};
    SetMTGApi set = new SetMTGApi() {};

    public static List<? extends MTGEntity> findAll() {
    	// TODO implements
		return null;
	}
    
    public static MTGEntity findOne(String id, MTGEntityEnum type) {
    	JsonNode node = getJson(API_URL + "/" + type.getMultiple() + "/" + id);
        ObjectMapper mapper = new ObjectMapper();
        try {
        	return mapper.readValue(node.get(type.getOne()).toString(), type.getJavaType());
        } catch(JsonParseException | JsonMappingException e) {
            LOGGER.error("Some error in deserialize object", e);
        } catch (IOException e) {
        	LOGGER.error("Some error in deserialize specific " + type.getOne(), e);
        }
        throw new IllegalArgumentException("Cannot possible retrieve a entity with actual data" );
    }
    
    static JsonNode getJson(String url) {
    	// Get string represent JSON
        String json = null;
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
        	HttpGet request = new HttpGet(url);
        	HttpResponse response = httpClient.execute(request);
        	json = EntityUtils.toString(response.getEntity());
        } catch (ParseException e) {
        	LOGGER.error("Some error in parse object response: " + url, e);
        } catch (IOException e) {
        	LOGGER.error("Some error in request", e);
        }
        
        // Construct JsonNode
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, JsonNode.class);
        } catch (IOException e) {
            // TODO implement catch
        }
        
        throw new IllegalArgumentException("Can't return a JsonNode for request: " + url);
    }
}
