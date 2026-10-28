package netmirror.music.iad1tya.playback

import netmirror.music.iad1tya.db.entities.SongEntity

interface ISyncUtils {
  fun likeSong(song: SongEntity)
}
