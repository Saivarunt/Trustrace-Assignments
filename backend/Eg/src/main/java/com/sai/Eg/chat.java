package com.sai.Eg;

import java.io.Serializable;

import org.hibernate.annotations.Generated;

//import hibernate.annotation.Generated;

import jakarta.persistence.*;

@Entity
@Table(name="chat")
public class chat implements Serializable{
	@Id
	@Column(name="chat_id")// if we are changing the name we have to declare else not needed
	public String chatId;
	public String chat_type;
	public boolean vanish_mode ;
	public String settings;
}