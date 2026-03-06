package app.controllers;

import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    private final UserMapper mapper;

    public UserController() {
        this.mapper = new UserMapper();
    }

    public void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.get("register", ctx -> ctx.render("register.html"));
        app.post("register", ctx -> registerUser(ctx, connectionPool));
        app.post("login", ctx -> login(ctx, connectionPool));
        app.get("logout", ctx -> logout(ctx));
    }

    private void login(Context ctx, ConnectionPool connectionPool) {
        // hent data fra html form
        // kalde user mapper for at søge i database
        // sendes til posts (redirect)
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
        try {
            User user = mapper.login(username,password, connectionPool);
            ctx.sessionAttribute("currentUser", user);
            ctx.redirect("posts");
        } catch (DatabaseException e) {
            ctx.attribute("msg", e.getMessage());
            ctx.render("login.html");
        }

        ctx.redirect("posts");
    }

    public static void logout(Context ctx) {
        ctx.req().getSession().invalidate();
        ctx.redirect("/");
    }

    private void registerUser(Context ctx, ConnectionPool connectionPool) {
        // hent data fra html form
        // kalde data mapper for at gemme i database
        // rediriger til forside
        String username = ctx.formParam("username");
        String password1 = ctx.formParam("password1");
        String password2 = ctx.formParam("password2");
        if (password1.equals(password2)) {
            try {
                mapper.createUser(username, password1, connectionPool);
                ctx.redirect("/login");
            } catch (DatabaseException e) {
                ctx.attribute("msg", e.getMessage());
                ctx.render("register.html");
            }
        } else {
            ctx.attribute("msg", "Passwords matcher ikke");
            ctx.render("register.html");
        }
    }
}
