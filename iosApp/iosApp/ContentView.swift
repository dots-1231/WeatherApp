import SwiftUI
import shared

@available(iOS 15.0, *)
struct ContentView: View {
    @State private var locationText: String = ""
    private let appModule = AppModule()
    
    @ObservedObject var viewModel: IOSHomeViewModel
    
    init() {
        self.viewModel = IOSHomeViewModel(
            weatherUseCase: appModule.weatherUseCase
        )
    }

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
                            viewModel.onEvent(event: HomeEvent.FetchWeather(location:locationText)
                            )
                        }
                        .background(Color.clear)
                        .padding(12)
                    }
                    
                    
                }
                
                
                List {
                    WeatherCardView(
                        location: viewModel.state.weatherDataModel?.location.name ?? "Default location",
                        temperature: viewModel.state.weatherDataModel?.currentWeather.feelsLikeFahrenheit ?? 0.0
                    )
                        .listRowInsets(EdgeInsets(top: 8, leading: 8, bottom: 8, trailing: 8))
                        .listRowSeparator(.hidden)
                        .listRowBackground(Color.clear)
                }
            }
            .navigationTitle("Multiplatform Weather App")
            .navigationBarTitleDisplayMode(.inline)
            .onAppear {
                viewModel.startObserving()
            }
            .onDisappear {
                viewModel.dispose()
            }
        }
	}
}

struct WeatherCardView: View {
    
    var location: String
    var temperature: Double
    
    var body: some View {
        ZStack {
            RoundedRectangle(
                cornerRadius: 25,
                style: .continuous
            ).fill(.white)
            
            VStack(alignment: .leading) {
                Text(location)
                    .font(.title2)
                    .foregroundColor(.black)
                    .fixedSize(horizontal: false, vertical: true)
                
                if(temperature == 0.0) {
                    Text("Temperature: Not available yet")
                } else {
                    Text("Temperature: \(Int(temperature)) Fahrenheit")
                        .font(.body)
                        .foregroundColor(.gray)
                }
                
                
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
