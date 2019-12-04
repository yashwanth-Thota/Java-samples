package Application.Models;

// User Model
import Utils.*;

public class User {
		private String email;
		private String password;
		private int id;
		private String phone;
		private String name;
		private UserLevel userCategory=UserLevel.User;
		private AccountStatus accountStatus=AccountStatus.Active;
		public User() {
				
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAccountStatus(AccountStatus accountStatus)
		{
			this.accountStatus = accountStatus;
		}
		public User(String email, String password, int id, String phone, String name
				 ) {
			super();
			this.email = email;
			this.password = password;
			this.id = id;
			this.phone = phone;
			this.name = name;
		}
		public AccountStatus getAccountStatus()
		{
			return  accountStatus;
		}
		public UserLevel getUserCategory() {
			return userCategory;
		}
		public void setUserCategory(UserLevel userCategory) {
			this.userCategory = userCategory;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getId() {
			return id;
		}
		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password=password;
		}
		public void setEmail(String email) {
			this.email=email;
		}
}
