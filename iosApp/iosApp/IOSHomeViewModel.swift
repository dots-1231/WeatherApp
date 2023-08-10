//
//  IOSHomeViewModel.swift
//  iosApp
//
//  Created by Hamza Monawer on 8/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

@available(iOS 15.0, *)
extension ContentView {
    
    @MainActor class IOSHomeViewModel : ObservableObject {
        private var weatherUseCase: Weather
        
        private let viewModel: HomeViewModel
        
        @Published var state: HomeState = HomeState(
            location: "",
            weatherDataModel: nil
        )
        
        private var handle: DisposableHandle?
        
        init(weatherUseCase: Weather){
            self.weatherUseCase = weatherUseCase
            self.viewModel = HomeViewModel(weather: weatherUseCase, coroutineScope: nil)
        }
        
        func onEvent(event: HomeEvent) {
            self.viewModel.onEvent(event: event)
        }
        
        func startObserving() {
            handle = viewModel.state.subscribe(onCollect: { state in
                if let state = state {
                    self.state = state
                }
            })
        }
        
        func dispose() {
            handle?.dispose()
        }
    }
}
