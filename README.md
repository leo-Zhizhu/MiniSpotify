# MiniSpotify

A full-stack music streaming mobile app: Android app (Jetpack Compose) + Ktor backend. Achieved core functionalities of Spotify with lightweighted codes.

---

## User-facing features

- **Home** — Browse album sections (e.g. “Top mixes”, “Made for you”). Tap an album to open its playlist.
- **Playlist** — See tracks for an album, tap a song to play/pause. Heart icon toggles favorite for the album.
- **Favorites** — List of favorited albums; tap one to open its playlist. Favorites are stored on device.
- **Playback** — In-app audio playback with play/pause and seek. Playback continues across navigation.

---

## Technical highlights

### Monorepo layout

- **`app/`** — Android application (Gradle, Kotlin, Android SDK 34).
- **`spotify_backend/`** — Ktor server (Gradle Kotlin DSL, JVM 11).

### Android app

- **Architecture:** MVVM with Repository layer.
- **UI:** Jetpack Compose, single Activity, Fragment-based navigation with BottomNavigation (Home / Favorites).
- **DI:** Hilt.
- **Data:** Retrofit + Gson for API, Room for local favorites, Coroutines + Flow.
- **Media:** ExoPlayer for streaming; Coil for images.
- **Navigation:** Navigation Component + Safe Args (type-safe arguments).

### Backend

- **Stack:** Ktor (Netty), Kotlin, kotlinx.serialization.
- **Endpoints:** `GET /feed`, `GET /playlist/{id}`, `GET /playlists`, static `GET /songs/{filename}`.
- **Data:** JSON from classpath (`feed.json`, `playlists.json`); audio from `src/main/resources/static/songs/`.

### Integration

- App base URL: `http://10.0.2.2:8080/` (emulator). Replace with host IP or real backend URL for device/production.
- Backend binds to `0.0.0.0:8080` so it’s reachable from emulator/network.

---

## Deployment guide

### Prerequisites

- **Android:** Android Studio (e.g. Hedgehog+), JDK 8+, Android SDK 34.
- **Backend:** JDK 11+ (for `spotify_backend`).

### 1. Clone and open

```bash
git clone https://github.com/leo-Zhizhu/MiniSpotify-frontend.git
cd MiniSpotify-frontend
```

Open the **root folder** in Android Studio (the one that contains both `app` and `spotify_backend`).

### 2. Run the backend

```bash
cd spotify_backend
./gradlew run
```

Leave it running. Server: `http://localhost:8080`.

- **Optional:** Add `.mp3` files under `spotify_backend/src/main/resources/static/songs/` and reference them in `playlists.json` as `http://localhost:8080/songs/YourFile.mp3` (or `http://10.0.2.2:8080/songs/...` for emulator).

### 3. Run the Android app

- In Android Studio: select the **app** run configuration, choose device/emulator, Run.
- App uses `http://10.0.2.2:8080/` by default (emulator → host). For a **physical device**, set the base URL in `app/.../network/NetworkModule.kt` to your machine’s IP (e.g. `http://192.168.1.100:8080/`).

### 4. Deploy backend (e.g. cloud)

- Build: `cd spotify_backend && ./gradlew installDist` (or shadowJar if configured).
- Run the generated script or JAR on a host with JDK 11+, e.g.:
  - `./build/install/com.laioffer.spotify_backend/bin/com.laioffer.spotify_backend`
- Point the Android app’s base URL to this server (HTTPS in production).

### 5. Push to GitHub (main branch)

From the repo root:

```bash
git remote set-url origin https://github.com/leo-Zhizhu/MiniSpotify-frontend.git
git add -A
git status
git commit -m "Your message"
git branch -M main
git push -u origin main
```

Use a Personal Access Token or SSH if prompted.

---

## Project structure (summary)

```
MiniSpotify-frontend/
├── app/                          # Android app
│   ├── src/main/java/.../        # UI, ViewModels, repo, network, player, db
│   └── src/main/res/             # layouts, navigation, drawables
├── spotify_backend/              # Ktor API
│   ├── src/main/kotlin/          # Application.kt (routes)
│   └── src/main/resources/      # feed.json, playlists.json, static/songs/
├── build.gradle                  # Root Android Gradle
├── settings.gradle               # include ':app'
└── README.md                     # This file
```

---

## Troubleshooting

- **No audio:** Backend running? Emulator volume up? Song URLs in `playlists.json` match files in `static/songs/`?
- **App can’t reach API:** Emulator → `10.0.2.2:8080`; device → same WiFi and host IP in `NetworkModule.kt`.
- **Build errors:** Sync Gradle; clean/rebuild; ensure JDK 11 for backend, JDK 8+ for Android.

---

## Author

**Leo Zhizhu** — [@leo-Zhizhu](https://github.com/leo-Zhizhu)

## License

MIT.
