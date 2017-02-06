package main.java.utilites;

import main.java.entity.Page;

/**
 * Created by riot_000 on 06.02.2017.
 */
public class PageDAO {
    public static Page getPageByPath(String path) {
        if ("/".equals(path)) return new Page("/","Добро пожаловать!","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec justo nunc, feugiat et viverra eget, mollis in libero. Quisque in cursus nunc, sit amet sodales mi.","Добро пожаловать!","/WEB-INF/templates/page.jsp");
        if ("/admin".equals(path.toLowerCase())) return new Page("/admin","Панель админа","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec justo nunc, feugiat et viverra eget, mollis in libero. Quisque in cursus nunc, sit amet sodales mi.","Добро пожаловать!","/WEB-INF/templates/admin.jsp");
    return new Page("/404","404-страница не найденна","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec justo nunc, feugiat et viverra eget, mollis in libero. Quisque in cursus nunc, sit amet sodales mi.","Добро пожаловать!","/WEB-INF/templates/404.jsp");

    }
}
