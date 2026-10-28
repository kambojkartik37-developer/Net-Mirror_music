# NET-MIRROR — Android TV performance pass

Per your instructions this round: **no assets, fonts, resources, languages, or features
were touched or removed.** Everything about the app's size and content is exactly as in
the source you uploaded. Only runtime behavior was tuned, specifically to reduce RAM
pressure and crashes on low-RAM Android TV boxes. Three files changed, all small,
self-contained edits:

### 1. `app/src/main/kotlin/com/music/netmirror/playback/MusicService.kt`
The ExoPlayer audio buffer was set to pre-fetch **6 minutes** of audio ahead (both min
and max buffer). That's a lot of audio sitting in RAM at once, on top of everything
else the app holds in memory. Reduced to 45s min / 90s max — still a comfortable
cushion against network hiccups, far less memory held at once. Instant-start behavior
(150ms) is untouched, so playback still starts immediately.

### 2. `app/src/main/kotlin/com/music/netmirror/App.kt` — two changes
- Coil's image memory cache was capped at **25%** of the app's available memory. On a
  1-2GB RAM TV box that's a large chunk reserved just for thumbnails, competing with
  playback buffers and the UI. Lowered to 12%. Thumbnails just get re-decoded a bit more
  often on cache misses — no visual change, no feature removed.
- Added an `onTrimMemory()` override. The app previously had **no response at all** to
  Android's low-memory signals, which on a constrained device means the system just
  kills the app outright when memory gets tight — that's what shows up to a user as a
  random crash/close. Now, when the system reports memory pressure, the app proactively
  drops the image cache to free RAM instead of waiting to be killed.

### Why not more (e.g., why isn't this smaller too)
You asked specifically for **no size change**, so I didn't touch fonts, images,
translations, or remove any modules/screens this round (equalizer, widgets, ambient
recognition, canvas backgrounds, etc. are all still there, exactly as uploaded). If you
want those size-reduction changes too, say so explicitly and I'll combine both passes
into one build.

### Build & verify
Same as before — I don't have Android SDK/Maven access in this sandbox, so none of this
has been compiled or run on a device. Build and test on real (or low-spec-emulated) TV
hardware before relying on it:
```
./gradlew assembleFossArm64Release
```
If a build or runtime error shows up, send me the exact error/stack trace and I'll fix
it directly rather than guessing — that'll be far cheaper than another blind pass.
