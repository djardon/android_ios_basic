//
//  DetailView.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI
import Shared

struct DetailView: View {
    @ObservedObject var state: DetailViewState
    let museumId: Int32

    var body: some View {
        VStack {
            if let museum = state.museum {
                MuseumDetails(museum: museum)
            }
        }
        .onAppear {
            state.setId(museumId: museumId)
        }
    }
}


#Preview {
    DetailView(state: .init(useCase: KoinDependencies().getMuseumUseCase),
               museumId: 436532)
}
