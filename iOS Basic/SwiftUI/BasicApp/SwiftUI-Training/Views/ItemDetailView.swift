//
//  ItemDetailView.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 15/10/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

struct ItemDetailView: View {
    let title: String?
    let subtitle: String?

    var body: some View {
        VStack(alignment: .leading) {
            if (title != nil && !(title?.isEmpty ?? true)) {
                Text(title ?? "").font(.headline)
            }
            
            if (subtitle != nil && !(subtitle?.isEmpty ?? true)) {
                Text(subtitle ?? "").font(.footnote)
            }
        }
        .padding(Edge.Set(arrayLiteral: .leading, .trailing), 8.0)
    }
}


#if DEBUG
struct ItemDetailView_Previews: PreviewProvider {
    static var previews: some View {
        ItemDetailView(title: "David",
                       subtitle: "d.jardon@gmail.com")
    }
}
#endif
