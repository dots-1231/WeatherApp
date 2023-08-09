import SwiftUI
import shared

@available(iOS 15.0, *)
struct ContentView: View {
	let greet = Greeting().greet()
    @State private var locationText: String = ""

	var body: some View {
        NavigationView {
            Form {
                Section {
                    HStack {
                        TextField(
                            "Enter a city or zipcode",
                            text: $locationText
                        )
                        
                        Button("Submit") {
                            
                        }.background(Color.clear)
                            .padding(12)
                    }
                    
                    
                }
                
                List {
                    WeatherCardView()
                        .listRowInsets(EdgeInsets(top: 8, leading: 16, bottom: 8, trailing: 16))
                        .listRowSeparator(.hidden)
                        .listRowBackground(Color.clear)
                    WeatherCardView()
                        .listRowInsets(EdgeInsets(top: 8, leading: 16, bottom: 8, trailing: 16))
                        .listRowSeparator(.hidden)
                        .listRowBackground(Color.clear)
                }
            }
            .navigationTitle("Multiplatform Weather App")
            .navigationBarTitleDisplayMode(.inline)
        }
	}
}

struct WeatherCardView: View {
    
    var body: some View {
        ZStack {
            RoundedRectangle(
                cornerRadius: 25,
                style: .continuous
            ).fill(.white)
            
            VStack(alignment: .leading) {
                Text("Burke, VA")
                    .font(.title2)
                    .foregroundColor(.black)
                    .fixedSize(horizontal: false, vertical: true)
                
                Text("Temperature: 56 Fahrenheit")
                    .font(.body)
                    .foregroundColor(.gray)
            }
            .padding(20)
            .multilineTextAlignment(.leading)
        }
        .padding()
    }
}

@available(iOS 15.0, *)
struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
