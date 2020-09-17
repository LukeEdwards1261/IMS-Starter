package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String first_name;
	private String surname;

	public Customer(String first_name, String surname) {
		this.setFirstName(first_name);
		this.setSurname(surname);
	}

	public Customer(Long id, String first_name, String surname) {
		this.setId(id);
		this.setFirstName(first_name);
		this.setSurname(surname);
	}
	
	
	
	public Customer(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + first_name + " surname:" + surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (getFirst_name() == null) {
			if (other.getFirst_name() != null)
				return false;
		} else if (!getFirst_name().equals(other.getFirst_name()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
