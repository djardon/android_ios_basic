//
//  ButtonsComponents.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 20/12/22.
//

import SwiftUI

struct CustomButtonStyle: ButtonStyle {
    @Environment(\.isEnabled) var isEnabled

    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .padding(8)
            .frame(height: 40)
            .foregroundColor(.white)
            .frame(maxWidth: .infinity)
            .background(isEnabled ? Color.colorCustom : Color.gray)
            .clipShape(Capsule())
            .opacity(configuration.isPressed ? 0.5 : 1)
    }
}

struct ButtonsComponents: View {
    var withIcon: Bool
    var onButtonPressed: () -> Void

    var body: some View {
        Button {
            // Button pressed
            onButtonPressed()
        } label: {
            HStack {
                button("Button")
            }
        }
        .buttonStyle(CustomButtonStyle())
        .disabled(false)
    }

    private func button(_ title: String) -> some View {
        HStack {
            if withIcon {
                Image(systemName: "heart.fill")
                    .resizable()
                    .scaledToFit()
                    .frame(height: 40)
            }
            Text(title)
                .font(.largeTitle)
        }
    }
}

struct ButtonsComponents_Previews: PreviewProvider {
    static var previews: some View {
        ButtonsComponents(withIcon: true) {

        }
    }
}
