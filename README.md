# 🎬 Project 62 – Movie Search App + Movies API | Netflix Clone Telugu Cinema | Single Repo

<p align="left">
<img src="https://img.shields.io/badge/React-19.0.0-61DAFB?logo=react&logoColor=white" alt="React 19.0.0">
<img src="https://img.shields.io/badge/Java-21-E76F00?logo=openjdk&logoColor=white" alt="Java 21">
<img src="https://img.shields.io/badge/Spring%20Boot-3.3.3-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 3.3.3">
<img src="https://img.shields.io/badge/TailwindCSS-3.4.1-38BDF8?logo=tailwindcss&logoColor=white" alt="TailwindCSS 3.4.1">
<img src="https://img.shields.io/badge/Axios-REST%20Client-D4AF00?logo=axios&logoColor=white" alt="Axios REST Client">
<img src="https://img.shields.io/badge/Apache%20Tomcat-10.1.30-D4AF00?logo=apachetomcat&logoColor=white" alt="Apache Tomcat 10.1.30">
<img src="https://img.shields.io/badge/Status-Completed-20B000" alt="Completed">
</p>

---

# 📖 Project Overview

**Movie Search App + Movies API | Netflix Clone Telugu Cinema** is **Project 62** of **Tier 6 – Frontend Mastery with React**, developed using **React 19**, **Spring Boot 3.3.3**, **TailwindCSS 3.4.1**, and **Axios** in a single monorepo.

React frontend runs on **port 3000** and communicates with the Spring Boot REST API running on **port 9595** through Axios.

The backend provides REST endpoints for:

- `GET /api/movies/test`
- `GET /api/movies`
- `GET /api/movies/search?q=`
- `GET /api/movies/trending`
- `GET /api/movies/stats`

The frontend displays:

- Movie.flix header
- 62/100 project badge
- Telugu Cinema - Tier 6 Completed! label
- Search Movies Unlimited hero
- Search by title or genre input
- All / Trending / Top Rated / New Release filters
- Movie statistics
- Responsive movie cards
- Footer

This project uses a **single repository architecture** containing both backend and frontend.

---

# ✨ Features

## 🧭 Header

- Movie.flix branding
- Sticky header
- 62/100 badge
- Telugu Cinema label

## 🔍 Search

- Search by title
- Search by genre
- Search by director
- Real-time filtering
- Axios API search

## 🏷 Filters

- All
- Trending
- Top Rated
- New Release

## 📊 Statistics

- 20 Total Movies
- 7 Trending
- 7 Top Rated
- 5 New Releases
- 10/10 Tier 6

## 🎬 Movie Cards

- Telugu posters
- Rating badge
- Genre
- Director
- Year
- Description

---

# 🛠 Technologies Used

| Technology | Version |
|---|---|
| React | 19.0.0 |
| Java | 21 |
| Spring Boot | 3.3.3 |
| TailwindCSS | 3.4.1 |
| Axios | 1.6+ |
| Maven | 3.9+ |
| Apache Tomcat | 10.1.30 |

---

# 📂 Project Structure

```text
62-movie-search-app/
│
├── backend/
│   └── 62-movie-search-app-backend/
│       ├── src/main/java/com/raviteja/movie/
│       │   ├── MovieApplication.java
│       │   └── controller/
│       │       └── MovieController.java
│       ├── src/main/resources/
│       │   └── application.properties
│       └── pom.xml
│
├── frontend/
│   └── 62-movie-search-ui/
│       ├── public/
│       ├── src/
│       │   ├── api/api.js
│       │   ├── components/MovieSearch.jsx
│       │   ├── App.js
│       │   ├── index.js
│       │   └── index.css
│       ├── package.json
│       └── package-lock.json
│
├── screenshots/
├── .gitignore
└── README.md
```

---

# ▶ How to Run

## 1. Clone Repository

```bash
git clone https://github.com/raviteja-dev950/62-movie-search-app.git
cd 62-movie-search-app
```

## 2. Backend

```properties
server.port=9595
spring.application.name=movie-api
```

Run:

```text
Run As → Spring Boot App
```

Backend:

```text
http://localhost:9595/api/movies/test
```

## 3. Frontend

```bash
cd frontend/62-movie-search-ui
npm install
npm install axios
npm start
```

Frontend:

```text
http://localhost:3000
```

## 4. Axios

```javascript
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:9595/api"
});

export default api;
```

---

# 🔄 Application Flow

```text
User
 │
 ▼
React UI (3000)
 │
 ├── Search
 ├── Filters
 ├── Stats
 └── Movies
 │
 ▼
Axios
 │
 ▼
Spring Boot API (9595)
 │
 ├── /movies
 ├── /search
 ├── /trending
 ├── /stats
 └── /test
 │
 ▼
Movie Cards
```

---

# 📊 Statistics

| Item | Value |
|---|---:|
| Total Movies | 20 |
| Trending | 7 |
| Top Rated | 7 |
| New Release | 5 |
| Tier Progress | 10/10 |

---

# 🎬 Default Movies

| ID | Movie | Category |
|---:|---|---|
| 1 | RRR | Trending |
| 2 | Baahubali 2 | Top Rated |
| 3 | Pushpa | Trending |
| 4 | KGF Chapter 2 | Trending |
| 5 | Ala Vaikunthapurramuloo | Top Rated |
| 6 | Sarileru Neekevvaru | New Release |
| 7 | Devara | New Release |
| 8 | Kalki 2898 AD | New Release |
| 9 | Salaar | Trending |
| 10 | Hanuman | Top Rated |
| 11 | Guntur Kaaram | New Release |
| 12 | Tillu Square | Trending |
| 13 | Arjun Reddy | Top Rated |
| 14 | Maharshi | Top Rated |
| 15 | Sita Ramam | Top Rated |
| 16 | Jersey | Top Rated |
| 17 | Geetha Govindam | Trending |
| 18 | F2 | Comedy |
| 19 | Hi Nanna | New Release |
| 20 | Dasara | Trending |

---

# 🧪 API Testing

## Test API

```bash
curl http://localhost:9595/api/movies/test
```

## All Movies

```bash
curl http://localhost:9595/api/movies
```

## Search

```bash
curl http://localhost:9595/api/movies/search?q=RRR
```

## Trending

```bash
curl http://localhost:9595/api/movies/trending
```

## Stats

```bash
curl http://localhost:9595/api/movies/stats
```

---

# 📡 API Endpoints

| Method | Endpoint |
|---|---|
| GET | `/api/movies/test` |
| GET | `/api/movies` |
| GET | `/api/movies/search?q=` |
| GET | `/api/movies/trending` |
| GET | `/api/movies/stats` |

---

# 📦 Expected Test Response

```text
WORKING 62 TELUGU!
```

# 📊 Expected Stats Response

```json
{
  "total": 20,
  "trending": 7,
  "topRated": 7,
  "newRelease": 5,
  "telugu": 20,
  "tierProgress": "10/10",
  "tier": "Telugu Cinema - Tier 6 Completed!"
}
```

---

# 📸 Screenshots

```text
screenshots/demo1.png
screenshots/demo2.png
screenshots/demo3.png
screenshots/demo4.png
```

---

# 🎯 Learning Outcomes

- Spring Boot REST APIs
- React Hooks
- Axios Integration
- Search Functionality
- Category Filtering
- Responsive UI
- Monorepo Architecture
- CORS Configuration
- JSON Data Handling

---

# 🚀 Future Enhancements

- Movie Details Page
- Watchlist
- Reviews
- Trailer Support
- JWT Authentication
- MySQL Database
- Spring Data JPA
- Vercel Deployment
- Render Deployment

---

# 👨‍💻 Author

**Ravi Teja**

Java Full Stack Developer

100 Java Full Stack Projects Challenge

**Project 62 / 100**

Tier 6 – Frontend Mastery with React

---

# ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

## Single Repo

```text
https://github.com/raviteja-dev950/62-movie-search-app
```

## Backend

```text
backend/62-movie-search-app-backend/
Port: 9595
```

## Frontend

```text
frontend/62-movie-search-ui/
Port: 3000
```