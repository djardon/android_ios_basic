//
//  SectionList.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 20/12/22.
//

import SwiftUI

struct SectionList: View {
    var contentGroup: ContentGroup

    var body: some View {
        Section {
            ForEach(contentGroup.content) { content in
                Text(content.name)
                    .font(.title2)
            }
        } header: {
            Text(contentGroup.name)
        }
    }
}

struct SectionList_Previews: PreviewProvider {
    static var previews: some View {
        SectionList(contentGroup: ContentGroup(
            name: "Languages",
            content: [
                Content(name: "UIKit"),
                Content(name: "SwiftUI")
            ]))
    }
}
