package org.imooc.bean;

public class User {
	
	private Long id;
	private String name;
	private String password;
	private String chName;
	private Long groupId;
	private Group groupUser;

	public Group getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(Group groupUser) {
		this.groupUser = groupUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", chName='" + chName + '\'' +
				", groupId=" + groupId +
				", groupUser=" + groupUser +
				'}';
	}
}