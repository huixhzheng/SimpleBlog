package com.duell.blogging.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tags", uniqueConstraints={@UniqueConstraint(columnNames="id")})

public class TagEntry {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="text")
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
