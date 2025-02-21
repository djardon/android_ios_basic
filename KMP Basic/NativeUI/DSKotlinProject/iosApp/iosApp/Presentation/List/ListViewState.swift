//
//  ListViewState.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI
import Shared

class ListViewState: ObservableObject {
    @Published var museums: [Museum] = []

    private var getMuseumsUseCase: GetMuseumsUseCase

    init(useCase: GetMuseumsUseCase) {
        self.getMuseumsUseCase = useCase
    }

    @MainActor
    func fetchMuseums() async {
        let emittedValues = getMuseumsUseCase.execute()
        //  The for await loop handles the asynchronous sequence of emitted values.
        for await museum in emittedValues {
            self.museums = museum
        }
    }
}
