package dev.hotel.dto;

import java.util.List;

public class MessageErreurDto {

	private List<String> messages;

	public MessageErreurDto(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
