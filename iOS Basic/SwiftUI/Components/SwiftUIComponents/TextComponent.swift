//
//  TextComponent.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 19/12/22.
//

import SwiftUI

struct TextComponent: View {
    var body: some View {
        VStack(spacing: 20) {
            Text("Hello, World!")
                .font(.largeTitle)
                .bold()
                .foregroundColor(.colorCustom)

            Text("Text")
                .font(.footnote)
                .foregroundColor(.green) +
            Text(" Components")
                .font(.footnote)
                .bold()
                .foregroundColor(.colorCustom)
                .underline()

            TextField("Example placeholder",
                      text: .constant(""))
            .keyboardType(.emailAddress)
            .textInputAutocapitalization(.words)
            .textFieldStyle(.roundedBorder)
            .padding(.horizontal, 80)
            .padding(.top, 20)
        }
    }
}

struct TextComponent_Previews: PreviewProvider {
    static var previews: some View {
        TextComponent()
    }
}
