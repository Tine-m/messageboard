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
- `docs/` - alt hvad der forklarer projektet (uml diagrammer m.m.)
- `sql/` - database scripts

---

## Commit beskeder og GitHub Issues

Når du laver et commit, skal commit-beskeden kort forklare **hvad der er lavet** og gerne referere til et **GitHub issue**.


### Grundregel

Commit-beskeden skal beskrive **ændringen**, ikke hvad du gjorde.

God:
```
Add create user form
```

Mindre god:
```
Worked on form
```

### Når commit løser et issue

Hvis committen **færdiggør en feature eller bugfix**, skal du skrive:

```
Fixes #<issue-number> eller
Closes #<issue-numer>

```

Eksempel:

```
Add create user (Closes #3)
```

Når committen pushes til GitHub, bliver issue **automatisk lukket**.


### Typiske commit beskeder

#### Feature
```
Add create user (Closes #2)
```

#### Bug fix
```
Fix image rendering in user list (Fixes #7)
```

#### Mindre ændringer (lukker ikke issue)
```
Improve HTML layout for user details
```

```
Refactor UserMapper SQL queries
```

### Gode commit regler

- Hold beskeden **kort og præcis**
- Beskriv **hvad der blev ændret**
- Referér til et **issue**, når det er relevant
- Lav **små commits**

Commit historikken bliver dermed en **log over projektets features**.


