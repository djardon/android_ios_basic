//
//  FormComponent.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 20/12/22.
//

import SwiftUI

struct FormComponent: View {
    var body: some View {
        Form {
            Text("Settings")
            Text("iOS Design")

            Section {
                Text("UIKit")
                Text("SwiftUI")
            }
        }
    }
}

struct FormComponent_Previews: PreviewProvider {
    static var previews: some View {
        FormComponent()
    }
}
