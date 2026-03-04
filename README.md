# MessageBoard

## Projektstruktur

```
src
└─ main
   ├─ java
   │  └─ app
   │     ├─ Main.java
   │     ├─ controllers
   │     │  └─ PostController.java
   │     ├─ entities
   │     │  └─ Post.java
   │     └─ persistence
   │        └─ PostMapper.java
   │
   └─ resources
      ├─ templates
      │  ├─ posts.html
      │  ├─ post_new.html
      │  └─ post_edit.html
      │
      └─ public
         ├─ css
         └─ images

docs
├─ diagrams
│  ├─ architecture.png
│  ├─ tilstandsdiagram.png
│  └─ er-diagram.png
│
└─ api
   └─ routes.md

sql
├─ create_tables.sql
├─ seed_data.sql
└─ drop_tables.sql

README.md
```

### Hvad ligger hvor

- `controllers` – routing og web requests
- `entities` – domæneklasser
- `persistence` – database adgang (JDBC mapper)
- `templates` – Thymeleaf HTML
- `public` – statiske filer (css, images)
