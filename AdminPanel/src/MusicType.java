import java.util.Set;

public class MusicType {
	private long id;
	private String typeName;

	public MusicType(long id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public MusicType() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
