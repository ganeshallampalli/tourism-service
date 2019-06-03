package com.tourism.model;

import com.tourism.model.BaseRequestResponse.BaseRequest;
import com.tourism.model.BaseRequestResponse.BaseResponse;

public interface RegisterUserRequestResponse {

	public class RegisterUserRequest extends BaseRequest {

		private String firstName;

		private String lastName;

		private String phNo;

		private String email;

		private String password;

		private String role;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "RegisterUserRequest{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
					+ ", phNo='" + phNo + '\'' + ", email='" + email + '\'' + ", password='" + password + '\''
					+ ", role='" + role + '\'' + '}';
		}
	}

	public class RegisterUserResponse extends BaseResponse {
	}

}