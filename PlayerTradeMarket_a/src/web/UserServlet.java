package web;

import pojo.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{

    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        req.setAttribute("username",username);

        User user = userService.login(username,password);
        if(user == null){
            req.setAttribute("msg","用户名或密码错误！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/pages/user/login_success.jsp");
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        if(token != null && token.equalsIgnoreCase(code)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            req.setAttribute("username",username);
            req.setAttribute("email",email);

            User user = new User(null,username,password,email);

            if(userService.existName(username)){
                req.setAttribute("msg","用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.register(user);
                req.getSession().setAttribute("user",user); //这里没有id，不知道以后会不会出问题
                resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/pages/user/regist_success.jsp");
            }
        }else{
            req.setAttribute("msg","验证码错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/index.jsp");
    }
}
