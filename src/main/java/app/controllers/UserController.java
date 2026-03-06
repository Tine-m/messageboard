package app.controllers;

import app.persistence.ConnectionPool;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class UserController {

    public void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.get("register", ctx -> registerUser(ctx, connectionPool));
    }

    private void registerUser(Context ctx, ConnectionPool connectionPool) {
        ctx.render("registeruser.html");
    }
}
