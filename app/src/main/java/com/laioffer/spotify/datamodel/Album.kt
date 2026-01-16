package com.laioffer.spotify.datamodel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Album")
@Parcelize
data class Album(
    @PrimaryKey
    val id: Int,
    @SerializedName("album")
    val name: String,
    val year: String,
    val cover: String,
    val artists: String,
    val description: String
): Parcelable {
    companion object {
        fun empty(): Album {
            return Album(
                id = -1,
                "",
                "",
                "",
                "",
                "",
            )
        }
    }
}


