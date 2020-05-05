package com.server;

public class EmailDTO {
	private String rcpt;
	private String title;
	private String content;
	private String from;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRcpt() {
		return rcpt;
	}

	public void setRcpt(String rcpt) {
		this.rcpt = rcpt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "EmailDTO [rcpt=" + rcpt + ", title=" + title + ", content=" + content + ", from=" + from + ", name="
				+ name + "]";
	}


}
