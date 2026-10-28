package netmirror.music.iad1tya.musicflow

import androidx.datastore.preferences.core.Preferences
import netmirror.music.iad1tya.constants.CanvasThumbnailAnimationKey
import netmirror.music.iad1tya.constants.DataSaverEnabledKey
import netmirror.music.iad1tya.constants.MusicFlowAnimatedBackgroundKey
import netmirror.music.iad1tya.constants.MusicFlowAutoNextKey
import netmirror.music.iad1tya.constants.MusicFlowAutoplayKey
import netmirror.music.iad1tya.constants.MusicFlowCellularPrefetchKey
import netmirror.music.iad1tya.constants.MusicFlowEnabledKey
import netmirror.music.iad1tya.constants.MusicFlowHideRecentKey
import netmirror.music.iad1tya.constants.MusicFlowLyricsKey

data class MusicFlowPreferences(
  val enabled: Boolean = true,
  val autoplay: Boolean = true,
  val autoNext: Boolean = true,
  val animatedBackground: Boolean = false,
  val lyrics: Boolean = true,
  val cellularPrefetch: Boolean = true,
  val hideRecent: Boolean = true,
  val dataSaver: Boolean = false,
) {
  companion object {
    fun from(preferences: Preferences) =
      MusicFlowPreferences(
        enabled = preferences[MusicFlowEnabledKey] ?: true,
        autoplay = preferences[MusicFlowAutoplayKey] ?: true,
        autoNext = preferences[MusicFlowAutoNextKey] ?: true,
        animatedBackground =
          preferences[MusicFlowAnimatedBackgroundKey]
            ?: preferences[CanvasThumbnailAnimationKey]
            ?: false,
        lyrics = preferences[MusicFlowLyricsKey] ?: true,
        cellularPrefetch = preferences[MusicFlowCellularPrefetchKey] ?: true,
        hideRecent = preferences[MusicFlowHideRecentKey] ?: true,
        dataSaver = preferences[DataSaverEnabledKey] ?: false,
      )
  }
}
