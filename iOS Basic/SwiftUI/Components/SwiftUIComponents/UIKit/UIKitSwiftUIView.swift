//
//  UIKitSwiftUIView.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 22/12/22.
//

import SwiftUI

struct UIKitSwiftUIView: View {
    @State private var text = NSMutableAttributedString(string: "Your message")

    var body: some View {
        TextView(text: $text)
    }
}

struct UIKitSwiftUIView_Previews: PreviewProvider {
    static var previews: some View {
        UIKitSwiftUIView()
    }
}
