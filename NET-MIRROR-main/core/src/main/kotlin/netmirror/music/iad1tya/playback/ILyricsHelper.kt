package netmirror.music.iad1tya.playback

import netmirror.music.iad1tya.models.MediaMetadata

data class LyricsWithProvider(val lyrics: String?, val providerName: String)

interface ILyricsHelper {
  suspend fun getLyrics(mediaMetadata: MediaMetadata): LyricsWithProvider
}
