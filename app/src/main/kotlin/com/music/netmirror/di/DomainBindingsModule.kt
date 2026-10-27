package com.music.netmirror.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import netmirror.music.core.repository.PlaylistRepositoryImpl
import netmirror.music.core.repository.SongRepositoryImpl
import netmirror.music.domain.repositories.PlaylistRepository
import netmirror.music.domain.repositories.SongRepository
import netmirror.music.iad1tya.musicflow.MusicFlowFeedSource
import netmirror.music.iad1tya.musicflow.MusicFlowRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainBindingsModule {

  @Binds
  @Singleton
  abstract fun bindSongRepository(
    impl: SongRepositoryImpl
  ): SongRepository

  @Binds
  @Singleton
  abstract fun bindPlaylistRepository(
    impl: PlaylistRepositoryImpl
  ): PlaylistRepository

  @Binds
  @Singleton
  abstract fun bindMusicFlowFeedSource(
    impl: MusicFlowRepository
  ): MusicFlowFeedSource
}
