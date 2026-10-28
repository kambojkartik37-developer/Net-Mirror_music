package netmirror.music.iad1tya.ui.utils

import androidx.navigation.NavController
import netmirror.music.iad1tya.ui.screens.Screens

fun NavController.backToMain() {
  val mainRoutes = Screens.MainScreens.map { it.route }

  while (
    previousBackStackEntry != null && currentBackStackEntry?.destination?.route !in mainRoutes
  ) {
    popBackStack()
  }
}
