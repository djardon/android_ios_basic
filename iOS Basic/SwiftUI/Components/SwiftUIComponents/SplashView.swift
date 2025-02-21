//
//  ContentView.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 19/12/22.
//

import SwiftUI

struct SplashView: View {
    var body: some View {
        VStack(spacing: 0) {
            Text("Hasten Group")

            Spacer()
            hContent
            Spacer()

            Text("2022")
        }
        .padding()
    }

    private var hContent: some View {
        HStack {
            Spacer()
            Text("SwiftUI")
            Spacer()
        }
    }
}

struct SplashView_Previews: PreviewProvider {
    static var previews: some View {
        SplashView()
    }
}
