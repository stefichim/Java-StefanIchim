package lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Document implements Serializable {
	private String id;
	private String name;
	private String location;

	
	public Document(String id, String name, String location) {
		super();
		this.id = id;
		this.name = name;

	}

	private Map<String, Object> tags = new HashMap<>();
	
	public void addTag(String key, Object obj) {
		tags.put(key,obj);
	}
	//.....

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, Object> getTags() {
		return tags;
	}

	public void setTags(Map<String, Object> tags) {
		this.tags = tags;
	}

}
