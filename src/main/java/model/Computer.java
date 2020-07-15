/**
 * 
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "computer")
public class Computer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public Computer() {}
	
	public Computer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + "]";
	}
	
	public static class ComputerBuilder {
		private int id;
		private String name;
		

		public ComputerBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public ComputerBuilder setName(String name) {
			this.name = name;
			return this;
		}


		public Computer build() {
			return new Computer(this);
		}
		
	}
	
	private Computer(ComputerBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}
	
}
