//
//  MuseumDetail.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI
import Shared

struct MuseumDetails: View {
    var museum: Museum

    var body: some View {
        ScrollView {

            VStack {
                AsyncImage(url: URL(string: museum.imageSmallUrl)) { phase in
                    switch phase {
                        case .empty:
                            ProgressView()
                        case .success(let image):
                            image
                                .resizable()
                                .scaledToFill()
                                .clipped()
                        default:
                            EmptyView()
                    }
                }

                VStack(alignment: .leading, spacing: 6) {
                    Text(museum.title)
                        .font(.title)

                    LabeledInfo(label: "Artist", data: museum.artist)
                    LabeledInfo(label: "Date", data: museum.date)
                    LabeledInfo(label: "Dimensions", data: museum.dimensions)
                    LabeledInfo(label: "Medium", data: museum.medium)
                    LabeledInfo(label: "Department", data: museum.department)
                    LabeledInfo(label: "Repository", data: museum.repository)
                    LabeledInfo(label: "Credits", data: museum.creditLine)
                }
                .padding(16)
            }
        }
    }
}
