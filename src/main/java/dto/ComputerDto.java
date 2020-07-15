package dto;

public class ComputerDto {
	private int id;
	public String name;
	
	public ComputerDto() {}

	public ComputerDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ComputerDto(String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ComputerDto [id=" + id + ", name=" + name + "]";
	}
	
	
}
