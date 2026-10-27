package netmirror.music.iad1tya.models

import com.music.innertube.models.YTItem
import netmirror.music.iad1tya.db.entities.LocalItem

data class SimilarRecommendation(
  val title: LocalItem,
  val items: List<YTItem>,
)
