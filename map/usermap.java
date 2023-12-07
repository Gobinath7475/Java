public class usermap {
    private  int user_id;
    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private String usertype;

    usermap(int userid,String username,String password,String email,String fname,String lname,String usertype){
        this.user_id=userid;
        this.username=username;
        this.password=password;
        this.email=email;
        this.fname=fname;
        this.lname=lname;
        this.usertype=usertype;
    }

    public int getUser_id() {
        return user_id;
    } 

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "usermap [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
                + ", fname=" + fname + ", lname=" + lname + ", usertype=" + usertype + "]";
    }
     }
    