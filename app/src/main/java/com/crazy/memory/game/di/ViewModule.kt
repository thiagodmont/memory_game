package com.crazy.memory.game.di

import com.crazy.memory.game.ui.gameplay.GamePlayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { (row: Int, column: Int) -> GamePlayViewModel(row, column) }
}