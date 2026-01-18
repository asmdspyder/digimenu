package dto.response;

public class TagResponse {

    private Long id;
    private String tagName;
    private String tagColor;

    public TagResponse(Long id, String tagName, String tagColor) {
        this.id = id;
        this.tagName = tagName;
        this.tagColor = tagColor;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagColor() {
		return tagColor;
	}

	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}

    
    
 
}