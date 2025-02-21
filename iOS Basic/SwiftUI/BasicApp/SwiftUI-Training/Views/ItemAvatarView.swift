//
//  ItemAvatarView.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

/// ItemAvatarView
/// View protocol - implemented by the custom views.
struct ItemAvatarView: View {
    /// image
    let image: String
    /// size
    let size: CGFloat
    
    /// body - default property for the view.
    var body: some View {
        Image(image)        // creates an imageview with specified image
            .resizable()    // makes image resizable
            .scaledToFit()
            .clipped()
            .frame(width: size, height: size) // frame for the image (width, height)
            .clipShape(Circle())
            .background(Color.clear)
    }
}
