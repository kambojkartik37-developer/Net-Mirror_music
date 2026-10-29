import SwiftUI

@main
struct NetMirrorApp: App {
    var body: some Scene {
        WindowGroup {
            RootView()
                .preferredColorScheme(.dark)
        }
    }
}

private struct RootView: View {
    var body: some View {
        TabView {
            SearchView()
                .tabItem {
                    Label("Search", systemImage: "magnifyingglass")
                }

            LibraryView()
                .tabItem {
                    Label("Library", systemImage: "music.note.list")
                }

            SettingsView()
                .tabItem {
                    Label("Settings", systemImage: "gearshape")
                }
        }
        .tint(.purple)
    }
}

private struct SearchView: View {
    @State private var query = ""

    var body: some View {
        NavigationStack {
            VStack(spacing: 20) {
                Image(systemName: "waveform")
                    .font(.system(size: 56, weight: .medium))
                    .foregroundStyle(.purple)

                Text("NetMirror Music")
                    .font(.largeTitle.bold())

                Text("iOS edition")
                    .foregroundStyle(.secondary)

                TextField("Search songs and artists", text: $query)
                    .textFieldStyle(.roundedBorder)
                    .submitLabel(.search)
                    .padding(.horizontal)

                ContentUnavailableView(
                    "Music search isn't connected yet",
                    systemImage: "music.magnifyingglass",
                    description: Text("The native iOS shell builds first. Music providers will be integrated in a later step.")
                )
                .padding(.top, 8)

                Spacer()
            }
            .padding(.top, 36)
            .navigationTitle("Discover")
        }
    }
}

private struct LibraryView: View {
    var body: some View {
        NavigationStack {
            ContentUnavailableView(
                "Your library",
                systemImage: "music.note.list",
                description: Text("Library storage and playlists are not connected yet.")
            )
            .navigationTitle("Library")
        }
    }
}

private struct SettingsView: View {
    var body: some View {
        NavigationStack {
            List {
                Section("About") {
                    LabeledContent("App", value: "NetMirror Music")
                    LabeledContent("Platform", value: "iOS")
                    LabeledContent("Status", value: "Starter build")
                }

                Section {
                    Text("This is the initial native iOS shell. Playback, search providers, lyrics, and audio effects still need iOS-specific implementation.")
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                }
            }
            .navigationTitle("Settings")
        }
    }
}
