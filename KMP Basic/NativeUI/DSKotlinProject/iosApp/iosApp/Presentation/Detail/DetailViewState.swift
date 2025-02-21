//
//  DetailViewState.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI
import Shared

class DetailViewState: ObservableObject {
    @Published var museum: Museum? = nil
    @Published var museumId: Int32? = nil

    private var getMuseumUseCase: GetMuseumUseCase

    init(useCase: GetMuseumUseCase) {
        self.getMuseumUseCase = useCase
    }

    func setId(museumId: Int32) {
        self.museumId = museumId
        Task {
            await fetchMuseum()
        }
    }

    @MainActor
    func fetchMuseum() async {
        guard let museumId = museumId else { return }

        let emittedValues = getMuseumUseCase.execute(museumId: museumId)
        //  The for await loop handles the asynchronous sequence of emitted values.
        for await museum in emittedValues {
            self.museum = museum
        }
    }
}
