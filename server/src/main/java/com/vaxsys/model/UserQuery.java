package com.vaxsys.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userQuery")
public class UserQuery {
		
		@Transient
	    public static final String SEQUENCE_NAME = "userQuery_sequence";
	
        @Id
        private long id;
        private String name;
        private String email;
        private String queryDescription;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getQueryDescription() {
			return queryDescription;
		}
		public void setQueryDescription(String queryDescription) {
			this.queryDescription = queryDescription;
		}
		public UserQuery(long id, String name, String email, String queryDescription) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.queryDescription = queryDescription;
		}
        
}
