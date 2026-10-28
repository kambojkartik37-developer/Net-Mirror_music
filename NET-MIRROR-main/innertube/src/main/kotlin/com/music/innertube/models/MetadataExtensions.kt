package com.music.innertube.models

import com.music.netmirror.metadata.cleaner.MetadataCleaner
import com.music.netmirror.metadata.models.CleanedMetadata

val SongItem.cleanedMetadata: CleanedMetadata
  get() = MetadataCleaner.clean(title, artists.firstOrNull()?.name.orEmpty())

val SongItem.displayTitle: String
  get() = cleanedMetadata.toDisplayTitle()

val SongItem.cleanArtistName: String
  get() = cleanedMetadata.primaryArtist
