package com.tourism.model;

import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface LoginUserRequestResponse {

	public class LoginUserRequest {

		private String userName;

		private String password;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	public class LoginUserResponse extends BaseResponse {

		private String emailId;

		private String userName;

		private String userId;

		private String role;

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
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

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	}
}