# MiniSpotify Backend

Ktor-based API server for the MiniSpotify app. Part of the [MiniSpotify monorepo](../README.md).

## Quick start

```bash
./gradlew run
```

Server runs at `http://localhost:8080`. For full setup, deployment, and API details, see the [root README](../README.md).

## API

- `GET /` — Health
- `GET /feed` — Home feed (sections + albums)
- `GET /playlists` — All playlists JSON
- `GET /playlist/{id}` — Playlist by album id
- `GET /songs/{filename}` — Static audio files (place files in `src/main/resources/static/songs/`)

## Adding audio files

Put `.mp3` files in `src/main/resources/static/songs/` and reference them in `playlists.json` as `http://localhost:8080/songs/YourFile.mp3` (or use `10.0.2.2` for emulator).
