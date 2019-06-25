package com.tourism.model;

import java.util.List;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface FetchUsersRequestResponse {

	public class FetchUsersResponse extends BaseResponse {

		private List<UserResponse> users;

		public List<UserResponse> getUsers() {
			return users;
		}

		public void setUsers(List<UserResponse> users) {
			this.users = users;
		}

		@Override
		public String toString() {
			return "FetchUsersResponse [users=" + users + "]";
		}

	}

	public class UserResponse {

		private Integer id;

		private String userName;

		private String userId;

		private String phNo;

		private String email;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPhNo() {
			return phNo;
		}

		public void setPhNo(String phNo) {
			this.phNo = phNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "UserResponse [id=" + id + ", userName=" + userName + ", userId=" + userId + ", phNo=" + phNo
					+ ", email=" + email + "]";
		}

	}
}
