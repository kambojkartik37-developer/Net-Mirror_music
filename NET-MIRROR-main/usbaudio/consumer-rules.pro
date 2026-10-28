# Keep classes and constructors looked up from jni_bridge.cpp.
-keep class netmirror.music.usbaudio.model.DacFormat { <init>(...); }
-keep class netmirror.music.usbaudio.model.DacCapabilities { <init>(...); }

# Keep names used by the exported JNI method symbols.
-keepclasseswithmembernames class netmirror.music.usbaudio.UsbAudioDriver { native <methods>; }
