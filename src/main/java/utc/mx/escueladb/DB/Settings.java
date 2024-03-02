package utc.mx.escueladb.DB;

public class Settings {
    private String DataBase = "school";
    private String User = "root";
    private String Pssword = "";
    private String Driver = "com.mysql.cj.jdbc.Driver";
    private String Ip = "127.0.0.1";
    private String Port = "3306";
    private String Url = "jdbc:mysql://" + Ip + ":" + Port+"/";

    public String getDataBase() {
        return DataBase;
    }

    public String getUser() {
        return User;
    }

    public String getPssword() {
        return Pssword;
    }

    public String getDriver() {
        return Driver;
    }

    public String getUrl() {
        return Url;
    }
}
