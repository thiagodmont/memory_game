package com.crazy.memory.game.ui.lobby

import android.media.MediaPlayer
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.crazy.memory.game.R
import com.crazy.memory.game.base.BaseFragment
import com.crazy.memory.game.base.viewBinding
import com.crazy.memory.game.databinding.FragmentLobbyBinding

class LobbyFragment : BaseFragment(R.layout.fragment_lobby) {
    private var mediaPlayer: MediaPlayer? = null
    private val viewBind by viewBinding(FragmentLobbyBinding::bind)

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)

        viewBind.mbThreeXFour.setOnClickListener {
            findNavController().navigate(
                LobbyFragmentDirections.actionLobbyFragmentToGamePlayFragment(
                    row = 3,
                    column = 4
                )
            )
        }

        viewBind.mbFiveXTwo.setOnClickListener {
            findNavController().navigate(
                LobbyFragmentDirections.actionLobbyFragmentToGamePlayFragment(
                    row = 5,
                    column = 2
                )
            )
        }

        viewBind.mbFourXFour.setOnClickListener {
            findNavController().navigate(
                LobbyFragmentDirections.actionLobbyFragmentToGamePlayFragment(
                    row = 4,
                    column = 4
                )
            )
        }

        viewBind.mbFourXFive.setOnClickListener {
            findNavController().navigate(
                LobbyFragmentDirections.actionLobbyFragmentToGamePlayFragment(
                    row = 4,
                    column = 5
                )
            )
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onResume() {
        super.onResume()
        configureMediaLobby()
    }

    private fun configureMediaLobby() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.lobby)
            mediaPlayer?.isLooping = true

            mediaPlayer?.setOnPreparedListener {
                mediaPlayer?.start()
            }
        } else {
            mediaPlayer?.start()
        }
    }
}