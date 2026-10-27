# NET-MIRROR source modifications

- Replaced PNG assets in Android mipmap icon variants with the NET-MIRROR red N emblem.
- Replaced the in-app launcher placeholder artwork with the same compact emblem.
- Removed first-run welcome dialog rows for Instagram, X, GitHub, Buy Me a Coffee, Patreon, UPI, Discord, and the repository-star external action.
- Removed the repository funding metadata file.

## Performance note
The source retains the existing Gradle/R8 settings. This change does not claim a verified APK build or device performance test; build and playback should be tested on a real device. Removing features or dependencies blindly can break playback and was avoided.
