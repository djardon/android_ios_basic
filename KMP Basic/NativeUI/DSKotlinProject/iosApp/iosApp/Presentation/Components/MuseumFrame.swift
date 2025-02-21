//
//  MuseumFrame.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI
import Shared

struct MuseumFrame: View {
    let museum: Museum
    let onClick: () -> Void

    var body: some View {
        VStack(alignment: .leading, spacing: 4) {
            GeometryReader { geometry in
                AsyncImage(url: URL(string: museum.imageSmallUrl)) { phase in
                    switch phase {
                        case .empty:
                            ProgressView()
                                .frame(width: geometry.size.width, height: geometry.size.width)
                        case .success(let image):
                            image
                                .resizable()
                                .scaledToFill()
                                .frame(width: geometry.size.width, height: geometry.size.width)
                                .clipped()
                                .aspectRatio(1, contentMode: .fill)
                        default:
                            EmptyView()
                                .frame(width: geometry.size.width, height: geometry.size.width)
                    }
                }
            }
            .aspectRatio(1, contentMode: .fit)

            Text(museum.title)
                .font(.headline)

            Text(museum.artist)
                .font(.subheadline)

            Text(museum.date)
                .font(.caption)
        }
    }
}
