//
//  StateBinding.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 21/12/22.
//

import SwiftUI
import Combine

/*
 @State 
 @Binding

 @StateObject
 @ObservedObject

 @EnvironmentObject
 */

class Progress: ObservableObject {
    @Published private(set) var score = 0

    func addScore() {
        score += 1
        objectWillChange.send()
    }
}

struct StateBindingDetail: View {
    @ObservedObject var progress: Progress

    var body: some View {
        VStack {
            Button("Add 1") {
                progress.addScore()
            }
            Text("Progress detail \(progress.score)")
        }
    }
}

struct StateBinding: View {
    @StateObject private var progress = Progress()
    @State private var isEnabled: Bool = false


    var body: some View {
        VStack {
            StateBindingDetail(progress: progress)
            Text("Progress \(progress.score)")

            Toggle("Change state", isOn: $isEnabled)
        }
    }
}

struct StateBinding_Previews: PreviewProvider {
    static var previews: some View {
        StateBinding()
    }
}
