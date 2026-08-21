package com.raviteja.movie.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    List<Map<String, Object>> movies = new ArrayList<>();

    public MovieController() {
        // TELUGU SUPER HITS!
        addMovie(1, "RRR", "Action Drama", 2022, 8.0, "S.S. Rajamouli", "https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=300", "Trending");
        addMovie(2, "Baahubali 2", "Action Epic", 2017, 8.2, "S.S. Rajamouli", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=300", "Top Rated");
        addMovie(3, "Pushpa: The Rise", "Action", 2021, 7.6, "Sukumar", "https://images.unsplash.com/photo-1626379616459-b2ce1d9decbc?w=300", "Trending");
        addMovie(4, "KGF Chapter 2", "Action", 2022, 8.2, "Prashanth Neel", "https://images.unsplash.com/photo-1594909122845-11baa439b7bf?w=300", "Trending");
        addMovie(5, "Ala Vaikunthapurramuloo", "Comedy Family", 2020, 7.3, "Trivikram", "https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?w=300", "Top Rated");
        addMovie(6, "Sarileru Neekevvaru", "Action Comedy", 2020, 5.7, "Anil Ravipudi", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=300", "New Release");
        addMovie(7, "Devara Part 1", "Action Drama", 2024, 7.5, "Koratala Siva", "https://images.unsplash.com/photo-1440404653325-ab127d49abc1?w=300", "New Release");
        addMovie(8, "Kalki 2898 AD", "Sci-Fi Epic", 2024, 8.5, "Nag Ashwin", "https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=300", "New Release");
        addMovie(9, "Salaar", "Action", 2023, 6.5, "Prashanth Neel", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=300", "Trending");
        addMovie(10, "Hanuman", "Superhero", 2024, 7.8, "Prashanth Varma", "https://images.unsplash.com/photo-1626379616459-b2ce1d9decbc?w=300", "Top Rated");
        addMovie(11, "Guntur Kaaram", "Family Action", 2024, 6.8, "Trivikram", "https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=300", "New Release");
        addMovie(12, "Tillu Square", "Comedy Thriller", 2024, 7.0, "Mallik Ram", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=300", "Trending");
        addMovie(13, "Arjun Reddy", "Romance Drama", 2017, 8.1, "Sandeep Reddy Vanga", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=300", "Top Rated");
        addMovie(14, "Maharshi", "Social Drama", 2019, 7.3, "Vamshi Paidipally", "https://images.unsplash.com/photo-1440404653325-ab127d49abc1?w=300", "Top Rated");
        addMovie(15, "Sita Ramam", "Romance Period", 2022, 8.3, "Hanu Raghavapudi", "https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?w=300", "Top Rated");
        addMovie(16, "Jersey", "Sports Drama", 2019, 8.5, "Gowtam Tinnanuri", "https://images.unsplash.com/photo-1626379616459-b2ce1d9decbc?w=300", "Top Rated");
        addMovie(17, "Geetha Govindam", "Romance Comedy", 2018, 7.6, "Parasuram", "https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=300", "Trending");
        addMovie(18, "F2", "Comedy Family", 2019, 6.8, "Anil Ravipudi", "https://images.unsplash.com/photo-1506744038136-46273834b3fb?w=300", "Comedy");
        addMovie(19, "Hi Nanna", "Romance Family", 2023, 7.9, "Shouryuv", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=300", "New Release");
        addMovie(20, "Dasara", "Action Drama", 2023, 7.2, "Srikanth Odela", "https://images.unsplash.com/photo-1594909122845-11baa439b7bf?w=300", "Trending");
    }

    private void addMovie(int id, String title, String genre, int year, double rating, String director, String poster, String category) {
        Map<String, Object> m = new HashMap<>();
        m.put("id", id);
        m.put("title", title);
        m.put("genre", genre);
        m.put("year", year);
        m.put("rating", rating);
        m.put("director", director);
        m.put("poster", poster);
        m.put("category", category);
        m.put("description", title + " Telugu Superhit directed by " + director + " - " + genre);
        m.put("language", "Telugu");
        movies.add(m);
    }

    @GetMapping("/test")
    public String test() {
        return "WORKING 62 TELUGU!";
    }

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return movies;
    }

    @GetMapping("/search")
    public List<Map<String, Object>> search(@RequestParam String q) {
        String query = q.toLowerCase();
        return movies.stream()
                .filter(m -> m.get("title").toString().toLowerCase().contains(query) ||
                             m.get("genre").toString().toLowerCase().contains(query) ||
                             m.get("director").toString().toLowerCase().contains(query) ||
                             m.get("language").toString().toLowerCase().contains(query))
                .collect(Collectors.toList());
    }

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        Map<String, Object> s = new HashMap<>();
        s.put("total", movies.size());
        s.put("trending", movies.stream().filter(m -> "Trending".equals(m.get("category"))).count());
        s.put("topRated", movies.stream().filter(m -> "Top Rated".equals(m.get("category"))).count());
        s.put("newRelease", movies.stream().filter(m -> "New Release".equals(m.get("category"))).count());
        s.put("telugu", movies.size());
        s.put("tierProgress", "10/10");
        s.put("tier", "Telugu Cinema - Tier 6 Completed!");
        return s;
    }
}