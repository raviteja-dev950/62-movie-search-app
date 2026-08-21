import React, { useState, useEffect } from "react";
import api from "../api/api";

export default function MovieSearch() {
  const [movies, setMovies] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [stats, setStats] = useState(null);
  const [search, setSearch] = useState("");
  const [category, setCategory] = useState("All");

  useEffect(() => {
    api.get("/movies").then(res => { setMovies(res.data); setFiltered(res.data); });
    api.get("/movies/stats").then(res => setStats(res.data));
  }, []);

  const handleSearch = async (val) => {
    setSearch(val);
    if (!val) { setFiltered(movies); return; }
    const res = await api.get(`/movies/search?q=${val}`);
    setFiltered(res.data);
  };

  const filterCategory = (cat) => {
    setCategory(cat);
    if (cat === "All") setFiltered(movies);
    else setFiltered(movies.filter(m => m.category === cat));
  };

  if (!movies.length) return <div style={{color:"white", padding:20}}>Loading 62...</div>;

  return (
    <div style={{minHeight:"100vh", background:"#0a0a0a", color:"white", fontFamily:"Segoe UI"}}>
      <header style={{padding:"20px 40px", display:"flex", justifyContent:"space-between", alignItems:"center", borderBottom:"1px solid #222", position:"sticky", top:0, background:"#0a0a0a", zIndex:100}}>
        <div style={{fontWeight:"bold", fontSize:22}}><span style={{color:"#e50914"}}>Movie</span>.flix</div>
        <div style={{display:"flex", gap:15, alignItems:"center"}}>
          <span style={{color:"#666", fontSize:13}}>{stats?.tier}</span>
          <span style={{background:"#e50914", color:"white", padding:"4px 12px", borderRadius:20, fontWeight:"bold", fontSize:13}}>62/100</span>
        </div>
      </header>

      <section style={{padding:"60px 40px", maxWidth:1200, margin:"0 auto"}}>
        <h1 style={{fontSize:48, fontWeight:800, margin:"0 0 10px 0"}}>Search Movies <span style={{color:"#e50914"}}>Unlimited</span></h1>
        <p style={{color:"#666", marginBottom:30}}>62/100 - Netflix Clone - Find Trending, Top Rated, New Releases</p>
        
        <div style={{display:"flex", gap:15, marginBottom:20}}>
          <input value={search} onChange={e=>handleSearch(e.target.value)} placeholder="Search by title or genre... e.g. Sci-Fi, Action" style={{flex:1, background:"#111", border:"1px solid #333", padding:"14px 20px", borderRadius:30, color:"white", outline:"none", fontSize:16}}/>
        </div>

        <div style={{display:"flex", gap:10, marginBottom:30, flexWrap:"wrap"}}>
          {["All","Trending","Top Rated","New Release"].map(c => (
            <button key={c} onClick={()=>filterCategory(c)} style={{background: category===c?"#e50914":"#222", color:"white", border:"none", padding:"8px 18px", borderRadius:20, cursor:"pointer", fontSize:13}}>{c}</button>
          ))}
        </div>

        {stats && (
          <div style={{display:"flex", gap:30, marginBottom:30, flexWrap:"wrap"}}>
            <div><div style={{fontSize:22, fontWeight:"bold"}}>{stats.total}</div><div style={{color:"#666", fontSize:11}}>TOTAL</div></div>
            <div><div style={{fontSize:22, fontWeight:"bold", color:"#e50914"}}>{stats.trending}</div><div style={{color:"#666", fontSize:11}}>TRENDING</div></div>
            <div><div style={{fontSize:22, fontWeight:"bold"}}>{stats.topRated}</div><div style={{color:"#666", fontSize:11}}>TOP RATED</div></div>
            <div><div style={{fontSize:22, fontWeight:"bold"}}>{stats.newRelease}</div><div style={{color:"#666", fontSize:11}}>NEW</div></div>
            <div><div style={{fontSize:22, fontWeight:"bold"}}>{stats.tierProgress}</div><div style={{color:"#666", fontSize:11}}>TIER 6</div></div>
          </div>
        )}

        <div style={{display:"grid", gridTemplateColumns:"repeat(auto-fill,minmax(220px,1fr))", gap:20}}>
          {filtered.map(m => (
            <div key={m.id} style={{background:"#111", border:"1px solid #222", borderRadius:12, overflow:"hidden"}}>
              <div style={{height:300, background:`url(${m.poster}) center/cover`, position:"relative"}}>
                <span style={{position:"absolute", top:10, left:10, background:"#e50914", color:"white", padding:"2px 8px", borderRadius:10, fontSize:10, fontWeight:"bold"}}>{m.category}</span>
                <span style={{position:"absolute", top:10, right:10, background:"rgba(0,0,0,0.8)", color:"#ffd700", padding:"2px 8px", borderRadius:10, fontSize:11}}>⭐ {m.rating}</span>
              </div>
              <div style={{padding:14}}>
                <h3 style={{margin:"0 0 4px 0", fontSize:16}}>{m.title}</h3>
                <div style={{color:"#666", fontSize:12}}>{m.year} • {m.genre} • {m.director}</div>
                <div style={{color:"#888", fontSize:11, marginTop:8, lineHeight:1.4}}>{m.description}</div>
              </div>
            </div>
          ))}
        </div>
      </section>

      <footer style={{textAlign:"center", padding:30, color:"#444", fontSize:13, borderTop:"1px solid #111", marginTop:40}}>
        © 2026 Ravi Teja • 62/100 Projects • MovieFlix • Tier 6 Completed! • Built with React + Spring Boot 9595
      </footer>
    </div>
  );
}