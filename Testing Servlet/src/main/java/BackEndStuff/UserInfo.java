package BackEndStuff;

public class UserInfo {
    public String Email;
    public String Name;
    public String Phone;
    public String Creation_Date;
    public String DOB;

    public UserInfo(String email, String name, String phone, String creation_Date, String DOB) {
        Email = email;
        Name = name;
        Phone = phone;
        Creation_Date = creation_Date;
        this.DOB = DOB;
    }
}
