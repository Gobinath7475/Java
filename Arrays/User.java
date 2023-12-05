public class User 
{
    int User_id ;
    String username ; 
    String password;
    String Email;
    String f_name;
    String L_name;
    String User_type;

    User (int User_id , String username , String password ,String Email ,String f_name ,String L_name ,String User_type )
    {
        this.User_id = User_id;
        this.username = username;
        this.password = password;
        this.Email = Email;
        this.f_name = f_name;
        this.L_name = L_name;
        this.User_type = User_type;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }

    public String getUser_type() {
        return User_type;
    }

    public void setUser_type(String user_type) {
        User_type = user_type;
    }

    @Override
    public String toString() {
        return "User [User_id=" + User_id + ", username=" + username + ", password=" + password + ", Email=" + Email
                + ", f_name=" + f_name + ", L_name=" + L_name + ", User_type=" + User_type + "]";
    }
    

    // public String toString()
    // {
    //     return User_id +" " + username +" " +  password + " " + Email +" " + f_name + " " + L_name + " " + User_type;
    // }
}
