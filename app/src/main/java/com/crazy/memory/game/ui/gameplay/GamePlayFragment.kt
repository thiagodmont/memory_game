package com.crazy.memory.game.ui.gameplay

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.crazy.memory.game.R
import com.crazy.memory.game.base.BaseFragment
import com.crazy.memory.game.base.viewBinding
import com.crazy.memory.game.databinding.FragmentGameplayBinding
import com.crazy.memory.game.domain.model.CardModel
import com.crazy.memory.game.extensions.changeTouchable
import com.crazy.memory.game.extensions.observe
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GamePlayFragment: BaseFragment(R.layout.fragment_gameplay) {
    private val viewBind by viewBinding(FragmentGameplayBinding::bind)
    private val args: GamePlayFragmentArgs by navArgs()
    private val viewModel: GamePlayViewModel by viewModel {parametersOf(args.row, args.column)}

    private var mediaPlayerSuccess: MediaPlayer? = null
    private var mediaPlayerFail: MediaPlayer? = null
    private var mediaPlayerBackground: MediaPlayer? = null
    private var mediaPlayerWon: MediaPlayer? = null
    private var adapter: CardAdapter? = null

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)

        adapter = CardAdapter(isLarge = args.column > 2)

        adapter?.setOnItemClickListener(object : CardAdapter.OnItemClickListener {
            override fun onItemClick(model: CardModel) {
                viewModel.flippedCard(key = model.key)
            }
        })

        viewBind.ibBackHome.setOnClickListener {
            findNavController().popBackStack()
        }

        viewBind.mbPlayAgain.setOnClickListener {
            viewBind.rvCards.visibility = View.VISIBLE
            viewBind.mbPlayAgain.visibility = View.GONE
            viewBind.ivTrophy.visibility = View.GONE

            viewModel.startGame()
        }

        configureRecyclerView()
        configureSounds()
    }

    override fun setupObservers() {
        observe(viewModel.boardList) { boardList ->
            boardList?.let {
                adapter?.setList(it)
            }
        }
        
        observe(viewModel.unFlipCards) { listCards ->
            listCards?.forEach { card ->
                card?.let { adapter?.changeItem(it) }
            }
        }

        observe(viewModel.waitUnFlip) {
            activity?.changeTouchable(it)
        }

        observe(viewModel.matched) {
            playSuccess()
        }

        observe(viewModel.unMatched) {
            playFail()
        }

        observe(viewModel.won) {
            playWon()

            viewBind.rvCards.visibility = View.GONE
            viewBind.mbPlayAgain.visibility = View.VISIBLE
            viewBind.ivTrophy.visibility = View.VISIBLE
        }

        observe(viewModel.score) {
            viewBind.mtvScore.text = it.toString()
        }
    }

    private fun configureRecyclerView() {
        viewBind.rvCards.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = this@GamePlayFragment.adapter
            layoutManager = GridLayoutManager(this@GamePlayFragment.context, args.column)
            setHasFixedSize(true)
        }
    }

    private fun configureSounds() {
        mediaPlayerSuccess = MediaPlayer.create(context, R.raw.success)
        mediaPlayerFail = MediaPlayer.create(context, R.raw.fail)
        mediaPlayerWon = MediaPlayer.create(context, R.raw.won)

        mediaPlayerSuccess?.setOnCompletionListener {
            mediaPlayerBackground?.start()
        }

        mediaPlayerFail?.setOnCompletionListener {
            mediaPlayerBackground?.start()
        }

        mediaPlayerWon?.setOnCompletionListener {
            mediaPlayerBackground?.start()
        }

        configureBackgroundSound()
    }

    private fun configureBackgroundSound() {
        if (mediaPlayerBackground == null) {
            mediaPlayerBackground = MediaPlayer.create(context, R.raw.background_gameplay)

            mediaPlayerBackground?.isLooping = true
            mediaPlayerBackground?.setOnPreparedListener {
                mediaPlayerBackground?.start()
            }
        } else {
            mediaPlayerBackground?.start()
        }
    }

    private fun playSuccess() {
        mediaPlayerBackground?.pause()
        mediaPlayerSuccess?.start()
    }

    private fun playFail() {
        mediaPlayerBackground?.pause()
        mediaPlayerFail?.start()
    }

    private fun playWon() {
        mediaPlayerBackground?.pause()
        mediaPlayerWon?.start()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayerBackground?.stop()
        mediaPlayerBackground?.release()
        mediaPlayerBackground = null
    }

    override fun onResume() {
        super.onResume()
        configureBackgroundSound()
    }
}