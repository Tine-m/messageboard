package app.controllers;

import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.PostMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class PostController {

    private final PostMapper mapper;

    public PostController() {
        this.mapper = new PostMapper();
    }

    public void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.get("/posts", ctx -> getAllPosts(ctx, connectionPool));

    }

    private void getAllPosts(Context ctx, ConnectionPool connectionPool) {
        String msg = ctx.queryParam("msg");
        try {
            ctx.attribute("posts", mapper.findAll(connectionPool));
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }

        ctx.attribute("msg", "Alle poster hentes ...");
        ctx.render("posts.html");
    }
}
