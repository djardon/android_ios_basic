//
//  ImageComponent.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 19/12/22.
//

import SwiftUI

struct ImageComponent: View {
    var body: some View {
        GeometryReader { geometryReader in
            VStack {
                Image(systemName: "heart.fill")
                    .resizable()
                    .renderingMode(.template)
                    .foregroundColor(.green)
                    .scaledToFit()
                    .frame(height: geometryReader.size.height * 0.25)
                    .frame(maxWidth: .infinity)

                Image("bck_image")
                    .resizable()
                    .scaledToFill()
                    .frame(height: .imageHeight)
                    .frame(maxWidth: .infinity)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    .overlay(
                        Image(systemName: "heart.fill")
                            .resizable()
                            .renderingMode(.template)
                            .foregroundColor(.green)
                            .scaledToFit()
                            .frame(height: 50)
                            .frame(maxWidth: .infinity,
                                   alignment: .trailing)
                            .padding(.trailing, 12)
                    )

                ButtonsComponents(withIcon: true) {

                }
            }
            .padding(.horizontal, .paddingHorizontal)
        }
    }
}

private extension CGFloat {
    static let paddingHorizontal: CGFloat = 20
    static let imageHeight: CGFloat = 200
}

struct ImageComponent_Previews: PreviewProvider {
    static var previews: some View {
        ImageComponent()
    }
}
