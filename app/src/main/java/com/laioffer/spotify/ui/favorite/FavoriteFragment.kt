package com.laioffer.spotify.ui.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.laioffer.spotify.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme(colors = darkColors()) {
                    FavoriteScreen(viewModel, onTap = { album ->
                        Log.d("FavoriteFragment", "We tapped ${album.name}")
                        val direction = FavoriteFragmentDirections.actionFavoriteFragmentToPlaylistFragment(album)
                        findNavController().navigate(directions = direction)
                    })
                }
            }
        }
    }
}