import SwiftUI
import shared
import AFNetworking
//import IOTCamera


struct ContentView: View {
    
    let greet = Greeting().greet()
    let hellKmm = HelloKMM()

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
