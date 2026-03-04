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

---
# GitHub workflow i dette projekt

I dette projekt bruger vi GitHub til at organisere arbejdet.

Vi bruger følgende elementer:

- **Issues** – beskriver opgaver (features eller bug fixes)
- **Commits** – indeholder ændringer i koden
- **Tags** – markerer vigtige checkpoints i projektet
- **Releases** – en samlet version af projektet baseret på et tag

Disse hænger sammen på følgende måde:

```
Issue → Commit → Tag → Release
```

---

# 1. Issues (opgaver)

Et **issue** beskriver en opgave i projektet.

Eksempel:

```
#3 Create post
```

Issues kan være:

- features
- bug fixes
- tekniske opgaver

---

# 2. Commits (kodeændringer)

Når du implementerer en feature eller løser en fejl, laver du et **commit**.

Commit-beskeden skal:

1. kort beskrive ændringen
2. referere til issue-nummeret

Eksempel:

```
Add create post form and POST route (Fixes #3)
```

`Fixes #3` betyder:

- når committen pushes til GitHub
- bliver **issue #3 automatisk lukket**

---

# 3. Tags (projektets checkpoints)

Et **tag** markerer en vigtig version af projektet.

I dette repository bruges tags til at markere **færdige features**.

Eksempel:

```
01-setup-project
02-feature-post-list
03-feature-post-create
04-feature-post-details
```

Tags gør det muligt at se hvordan projektet udvikler sig trin for trin.

Studerende kan f.eks. åbne et tag og se:

- hvordan koden så ud på det tidspunkt
- hvilke features der var implementeret

---

# 4. Releases (valgfrit)

En **release** er en offentlig version af projektet baseret på et tag.

En release indeholder:

- et tag
- en beskrivelse af hvad versionen indeholder
- evt. ekstra filer (assets)

Eksempel:

```
Release: 02-feature-post-list
```

Description:

```
Adds:

- Post entity
- PostMapper.findAll()
- GET /posts route
- posts.html template
```

Releases gør det nemmere at se projektets progression.

---

# 5. Samlet eksempel

```
Issue #3 Create post
↓
Commit: Add create post form (Fixes #3)
↓
Tag: 03-feature-post-create
↓
Release: 03-feature-post-create
```

Dette giver en klar historik over projektets udvikling.

---

# 6. Typisk workflow

Når du arbejder på en feature:

1. Find et **issue**
2. Implementér ændringer
3. Lav et **commit**
4. Push til GitHub

Eksempel:

```
git add .
git commit -m "Add post details page (Fixes #4)"
git push
```

---

# 7. Hvorfor vi gør det sådan

Denne struktur gør det lettere at:

- følge projektets udvikling
- forstå commit-historikken
- se hvornår features blev implementeret
- navigere i tidligere versioner af koden
