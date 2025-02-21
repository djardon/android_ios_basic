//
//  LabeledInfo.swift
//  iosApp
//
//  Created by David Jardon
//  Copyright © 2024 DS. All rights reserved.
//

import SwiftUI

struct LabeledInfo: View {
    var label: String
    var data: String
    
    var body: some View {
        Spacer()
        Text("**\(label):** \(data)")
    }
}
