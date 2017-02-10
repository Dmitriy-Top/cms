package main.java.utilites;

import main.java.entity.Page;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by riot_000 on 06.02.2017.
 */
public class PageDAO {
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

    public static Page getPageByPath(String path) {
        Page result = null;
        try {
            Connection cn = ds.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM pages WHERE uri = ?");
            ps.setString(1, path);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result = new Page(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(6),resultSet.getString(4),resultSet.getString(3),resultSet.getString(5));
            }
            resultSet.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null)
            result = new Page(0,"/404", "404-ОШИБКА", "", "404-ОШИБКА", "/WEB-INF/templates/404.jsp");
        return result;

    }
    public static Page getPageByID(Integer id) {
        Page result = null;
        try {
            Connection cn = ds.getConnection();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM pages WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                result = new Page(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(6),resultSet.getString(4),resultSet.getString(3),resultSet.getString(5));
            }
            resultSet.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == null)
            result = new Page(0,"/404", "404-ОШИБКА", "", "404-ОШИБКА", "/WEB-INF/templates/404.jsp");
        return result;

    }

    public static HashMap<String,String> getPagesUrls() {
        HashMap<String,String> result = new HashMap<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pages");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.put(rs.getString("header"),rs.getString("uri"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static HashMap<String,Integer> getPagesID() {
        HashMap<String,Integer> result = new HashMap<>();
        try {
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pages");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.put(rs.getString("header"),rs.getInt("id"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Boolean savePage(String url, String title, String header, String content) {
        Boolean isSave=false;
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO pages (uri,title,content,templatepath,header) VALUES (?,?,?,?,?)");
            ps.setString(1,url);
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setString(4,"/WEB-INF/templates/page.jsp");
            ps.setString(5,header);
            isSave=ps.execute();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSave;
    }

    public static void updatePage(Page page) {
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE pages SET uri = ?, title = ?, content = ?,templatepath = ?, header = ? WHERE id = ?");
            ps.setString(1,page.getUri());
            ps.setString(2,page.getTitle());
            ps.setString(3,page.getContent());
            ps.setString(4,page.getTemplatePath());
            ps.setString(5,page.getHeader());
            ps.setInt(6,page.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePage(Integer id, String url, String title, String header, String content) {
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE pages SET uri = ?, title = ?, content = ?,templatepath = ?, header = ? WHERE id = ?");
            ps.setString(1,url);
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setString(4,"/WEB-INF/templates/page.jsp");
            ps.setString(5,header);
            ps.setInt(6,id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePage(Integer id) {
        try{
            Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM pages WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
