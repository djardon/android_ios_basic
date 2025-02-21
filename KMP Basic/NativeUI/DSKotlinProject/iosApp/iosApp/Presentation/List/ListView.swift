//
//  ListView.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//


import SwiftUI
import Shared

struct ListView: View {
    @ObservedObject var state: ListViewState

    let columns = [
        GridItem(.adaptive(minimum: 120), alignment: .top)
    ]

    var body: some View {
        ZStack {
            if !state.museums.isEmpty {
                NavigationStack {
                    ScrollView {
                        gridView
                    }
                }
            } else {
                Text("No data available")
            }
        }
        .task {
            await state.fetchMuseums()
        }
    }

    private var gridView: some View {
        LazyVGrid(columns: columns, alignment: .leading, spacing: 20) {
            ForEach(state.museums, id: \.self) { item in
                NavigationLink(
                    destination: DetailView(
                        state: .init(useCase: KoinDependencies().getMuseumUseCase),
                        museumId: item.id
                    )
                ) {
                    MuseumFrame(museum: item, onClick: {})
                }
                .buttonStyle(PlainButtonStyle())
            }
        }
        .padding(.horizontal)
    }
}

#Preview {
    ListView(state: .init(useCase: KoinDependencies().getMuseumsUseCase))
}

