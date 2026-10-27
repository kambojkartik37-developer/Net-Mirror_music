package netmirror.music.iad1tya.ui.screens.equalizer

import netmirror.music.dsp.core.models.SavedEQProfile

data class EQState(
  val profiles: List<SavedEQProfile> = emptyList(),
  val activeProfileId: String? = null,
  val importStatus: String? = null,
  val error: String? = null
)
