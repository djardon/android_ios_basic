//
//  ListsComponent.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 20/12/22.
//

import SwiftUI

struct ContentGroup: Identifiable {
    let id = UUID()
    let name: String
    let content: [Content]
}

struct Content: Identifiable {
    let id = UUID()
    let name: String
}


struct ListsComponent: View {
    private let contentGroup = [
        ContentGroup(
            name: "Languages",
            content: [
                Content(name: "UIKit"),
                Content(name: "SwiftUI")
            ]),
        ContentGroup(
            name: "More Options",
            content: [
                Content(name: "Code"),
                Content(name: "Storyboards"),
                Content(name: "xib")
            ]),
    ]

    init() {
        UIScrollView.appearance().bounces = false
    }

    var body: some View {
        VStack {
            List(contentGroup) { group in
                Section {
                    ForEach(group.content) { content in
                        Text(content.name)
                            .font(.title2)
                    }
                } header: {
                    Text(group.name)
                }
            }
            .listStyle(.sidebar)

            ScrollView(.horizontal, showsIndicators: false) {
                LazyHStack {
                    ForEach(1..<100) { index in
                        Text("\(index)")
                    }
                }
            }
            .padding(20)
            .frame(maxHeight: 100)
        }
    }
}

struct ListsComponent_Previews: PreviewProvider {
    static var previews: some View {
        ListsComponent()
    }
}
