# MiniSpotify - Android Music Streaming App

A modern Android music streaming application built with Jetpack Compose, following MVVM architecture and modern Android development best practices.

## 🎵 Features

- **Home Feed**: Browse music albums organized by sections
- **Playlist View**: View songs in each album with album artwork
- **Audio Playback**: Play songs using ExoPlayer with play/pause controls
- **Favorites Management**: Save and manage favorite albums locally
- **Navigation**: Seamless navigation between screens using Navigation Component
- **Dark Theme**: Beautiful dark-themed UI matching Spotify's design

## 🏗️ Architecture

This project follows **MVVM (Model-View-ViewModel)** architecture pattern:

```
┌─────────────┐
│    View     │ (Fragments + Compose Screens)
│  (UI Layer) │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ ViewModel   │ (State Management)
│  (Logic)    │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Repository  │ (Data Layer)
└──────┬──────┘
       │
   ┌───┴───┐
   │       │
   ▼       ▼
Network  Database
(Retrofit) (Room)
```

## 🛠️ Key Technologies

### UI & Framework
- **Jetpack Compose** - Modern declarative UI framework
- **Material Design** - Material 3 components and theming
- **Navigation Component** - Type-safe navigation with Safe Args
- **ViewBinding** - For XML layouts

### Architecture Components
- **ViewModel** - Lifecycle-aware state management
- **LiveData/StateFlow** - Reactive data streams
- **Room Database** - Local data persistence for favorites
- **Hilt** - Dependency injection framework

### Networking & Media
- **Retrofit** - REST API client
- **Gson** - JSON serialization
- **ExoPlayer** - Audio playback engine
- **Coil** - Image loading library

### Kotlin Features
- **Coroutines** - Asynchronous programming
- **Flow** - Reactive streams
- **Data Classes** - Immutable data models
- **Parcelize** - Efficient data passing between screens

## 📁 Project Structure

```
app/src/main/java/com/laioffer/spotify/
├── database/          # Room database setup
│   ├── AppDatabase.kt
│   ├── DatabaseDao.kt
│   └── DatabaseModule.kt
├── datamodel/        # Data models
│   ├── Album.kt
│   ├── Playlist.kt
│   ├── Section.kt
│   └── Song.kt
├── network/          # Networking layer
│   ├── NetworkApi.kt
│   └── NetworkModule.kt
├── player/           # Audio player
│   ├── PlayerModule.kt
│   ├── PlayerViewModule.kt
│   └── PlayerBar.kt
├── repository/       # Data repositories
│   ├── FavoriteAlbumRepository.kt
│   ├── HomeRepository.kt
│   └── PlaylistRepository.kt
└── ui/               # UI components
    ├── favorite/     # Favorite screen
    ├── home/         # Home feed screen
    ├── playlist/    # Playlist screen
    └── theme/        # Theme configuration
```

## 🚀 Getting Started

### Prerequisites

- **Android Studio** Hedgehog (2023.1.1) or later
- **JDK 8** or higher
- **Android SDK** API 34
- **Kotlin** 1.9.0
- **Gradle** 8.7

### Backend Setup

This app requires a backend server running on `http://localhost:8080`. The backend should provide:

- `GET /feed` - Returns home feed with sections and albums
- `GET /playlist/{id}` - Returns playlist with songs for an album
- `GET /songs/{filename}` - Serves audio files (e.g., `solo.mp3`)

**Note**: When running on Android Emulator, the app automatically converts `localhost` URLs to `10.0.2.2` to access the host machine's localhost.

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/leo-Zhizhu/MiniSpotify-frontend.git
   cd MiniSpotify-frontend
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned directory

3. **Sync Gradle**
   - Android Studio will automatically sync Gradle dependencies
   - Wait for the sync to complete

4. **Start Backend Server**
   - Ensure your backend server is running on port 8080
   - The server should serve the API endpoints mentioned above

5. **Run the App**
   - Connect an Android device or start an emulator
   - Click "Run" button or press `Shift+F10`
   - The app will build and install on your device

## 🔧 Configuration

### Network Configuration

The app is configured to connect to `http://10.0.2.2:8080/` by default (for emulator). To change the base URL, modify:

```kotlin
// app/src/main/java/com/laioffer/spotify/network/NetworkModule.kt
private const val BASE_URL = "http://10.0.2.2:8080/"
```

**For Physical Device**: Replace `10.0.2.2` with your computer's local IP address (e.g., `192.168.1.100`).

### Network Security Config

The app includes a network security configuration to allow HTTP connections (for development). For production, use HTTPS and update `network_security_config.xml`.

## 📱 Usage

1. **Home Screen**: Browse albums organized by sections
2. **Tap Album**: Navigate to playlist view showing all songs
3. **Tap Song**: Start audio playback
4. **Favorite**: Tap the heart icon to save albums to favorites
5. **Favorites Tab**: View all favorited albums

## 🎨 UI Components

### Screens
- **HomeFragment**: Displays feed with album sections
- **PlaylistFragment**: Shows songs in an album with playback controls
- **FavoriteFragment**: Lists all favorited albums

### Key UI Features
- Lazy loading for efficient list rendering
- Image caching with Coil
- Smooth navigation transitions
- Responsive layout design

## 🧪 Testing

Run unit tests:
```bash
./gradlew test
```

Run instrumented tests:
```bash
./gradlew connectedAndroidTest
```

## 📦 Dependencies

### Core Dependencies
- `androidx.compose.ui:ui:1.3.2` - Compose UI framework
- `androidx.compose.material:material:1.2.0` - Material components
- `androidx.navigation:navigation-fragment-ktx:2.5.3` - Navigation
- `com.google.dagger.hilt.android:2.48` - Dependency injection

### Data & Networking
- `androidx.room:room-runtime:2.4.3` - Room database
- `com.squareup.retrofit2:retrofit:2.9.0` - REST client
- `com.squareup.retrofit2:converter-gson:2.9.0` - JSON converter

### Media
- `com.google.android.exoplayer:exoplayer-core:2.18.2` - Audio playback

### Image Loading
- `io.coil-kt:coil-compose:2.2.2` - Image loading

## 🐛 Troubleshooting

### Audio Not Playing
1. Check backend server is running on port 8080
2. Verify emulator volume is up
3. Check Logcat for ExoPlayer errors
4. Ensure song URLs are accessible (check network security config)

### Network Connection Issues
- **Emulator**: Use `10.0.2.2` to access host machine
- **Physical Device**: Use your computer's local IP address
- Check `network_security_config.xml` allows HTTP connections

### Build Errors
- Clean and rebuild: `Build > Clean Project` then `Build > Rebuild Project`
- Invalidate caches: `File > Invalidate Caches / Restart`
- Check Gradle sync completed successfully

## 📝 Development Notes

### Architecture Decisions
- **MVVM**: Separates UI from business logic
- **Repository Pattern**: Abstracts data sources
- **Dependency Injection**: Using Hilt for testability
- **Reactive Programming**: StateFlow for state management

### Best Practices Implemented
- Single Activity architecture
- Type-safe navigation with Safe Args
- Coroutines for async operations
- Room for local persistence
- Proper lifecycle management

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Leo Zhizhu**
- GitHub: [@leo-Zhizhu](https://github.com/leo-Zhizhu)

## 🙏 Acknowledgments

- Spotify for design inspiration
- Android Jetpack team for excellent libraries
- Kotlin team for the amazing language

---

**Note**: This is a learning project demonstrating modern Android development practices. For production use, additional features like authentication, payment, and advanced playback controls would be needed.
