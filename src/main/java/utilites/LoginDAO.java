package main.java.utilites;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * Created by admin on 30.01.2017.
 */
public class LoginDAO {
    private static InitialContext ctx;
    private static DataSource ds;

    static {
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/PostgresDS");
        } catch (NamingException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean isAuthenticated(String jsessionid) {
        boolean isAuth = false;
        if (jsessionid == null) return false;
        try {
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                String sessions = rs.getString("session");
                if (sessions!=null&&sessions.equals(jsessionid)) {
                    isAuth = true;
                    break;
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuth;
    }

    public static boolean auth(String login, String pass) {
        boolean isAuth = false;
        if (login == null | pass == null) return false;
        String md5hash = MD5hash(pass);
        try {
            Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                if (rs.getString("user").equals(login) && rs.getString("pass").equals(md5hash)) {
                    isAuth = true;
                    break;
                }
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAuth;
    }

    public static void addAuthSession(HttpServletRequest req, String pass) {
        String jsessionid=null;
        Cookie[] cookies = req.getCookies();
        if (cookies!=null)for (Cookie cookie:cookies){
            if ("JSESSIONID".equals(cookie.getName())){
                jsessionid = cookie.getValue();
                break;
            }
        }
        if (jsessionid!=null){
            try {
                Connection con = ds.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE users SET session = ? WHERE pass = ?");
                preparedStatement.setString(1,jsessionid);
                preparedStatement.setString(2,MD5hash(pass));
                int i = preparedStatement.executeUpdate();
                preparedStatement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static String MD5hash(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); //хз что это и как это
                result = sb.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;

    }
}