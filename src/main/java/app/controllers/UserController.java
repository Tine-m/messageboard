package app.controllers;

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
        //app.get("login", ctx -> ctx.render("login.html"));
        app.post("login", ctx -> login(ctx, connectionPool));
    }

    private void login(Context ctx, ConnectionPool connectionPool) {
        // hent data fra html form
        // kalde user mapper for at søge i database
        // sendes til posts (redirect)
        ctx.redirect("posts");
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
