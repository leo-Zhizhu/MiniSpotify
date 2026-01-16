
package com.laioffer.spotify.player

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlayerModule {

    @Provides
    @Singleton
    fun providesPlayer(@ApplicationContext context: Context): ExoPlayer {
        return ExoPlayer.Builder(context).build().apply {
            // Set audio attributes for proper playback
            // This is important for audio playback, especially in emulators
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(com.google.android.exoplayer2.C.CONTENT_TYPE_MUSIC)
                .setUsage(com.google.android.exoplayer2.C.USAGE_MEDIA)
                .build()
            setAudioAttributes(audioAttributes, true)
        }
    }
}

