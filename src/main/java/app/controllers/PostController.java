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
        app.get("/posts/new", ctx -> addPost(ctx, connectionPool));
        app.post("/posts", ctx -> createPost(ctx, connectionPool));

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

    private void addPost(Context ctx, ConnectionPool connectionPool) {
        ctx.render("addpost.html");
    }

    private void createPost(Context ctx, ConnectionPool connectionPool) {
        String msg = ctx.queryParam("msg");
        try {
            //TODO change
            System.out.println("POST oprettet");
            ctx.attribute("posts", mapper.findAll(connectionPool));
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }

        //TODO bliver ikke vist på skrm, nok pga. redkirect
        ctx.attribute("msg", "Ny post oprettet i DB ...næsten");
        ctx.redirect("posts");
    }
}
