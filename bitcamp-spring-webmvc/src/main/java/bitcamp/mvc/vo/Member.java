package bitcamp.mvc.vo;

public class Member {
    String id;
    String email;
    String password;
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
