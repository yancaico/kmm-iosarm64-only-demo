import SwiftUI
import shared
import AnsjerCamera
import IOTCamera

struct ContentView: View {
	let greet = Greeting().greet()
    let ss = PlatformKt.getPlatform().name + IOTCamera.Camera.getAVAPIsVersion()

	var body: some View {
		Text(greet + ss)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
