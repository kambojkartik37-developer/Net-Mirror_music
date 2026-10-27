package netmirror.music.iad1tya.extensions

fun <T> tryOrNull(block: () -> T): T? =
  try {
    block()
  } catch (e: Exception) {
    null
  }
