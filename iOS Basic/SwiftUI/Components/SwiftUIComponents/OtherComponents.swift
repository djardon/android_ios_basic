//
//  OtherComponents.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 20/12/22.
//

import SwiftUI

struct OtherComponents: View {
    @State private var favoriteColor = 0
    @State private var birthdate = Date.now
    @State private var age: Double = 0
    @State private var accept: Bool = true

    var body: some View {
        VStack {
            Picker("Favourite UI", selection: $favoriteColor) {
                Text("UIKit")
                Text("SwiftUI")
            }
            .pickerStyle(.segmented)

            DatePicker(selection: $birthdate,
                       in: ...Date.now,
                       displayedComponents: .date) {
                Text("Select date \(birthdate)")
            }

            Slider(value: $age, in: 0...100)
            Text("Age \(age)")

            Toggle("Press", isOn: $accept)
                .toggleStyle(.switch)
                .tint(.pink)

            Stepper("Enter your age \(age)",
                    value: $age,
                    in: 0...100)
        }
    }
}

struct OtherComponents_Previews: PreviewProvider {
    static var previews: some View {
        OtherComponents()
    }
}
