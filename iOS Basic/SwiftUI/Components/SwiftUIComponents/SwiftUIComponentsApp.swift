//
//  SwiftUIComponentsApp.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 19/12/22.
//

import SwiftUI

class UserSession: ObservableObject {
    @Published var token: String
    @Published var name: String

    init(token: String, name: String) {
        self.token = token
        self.name = name
    }
}


@main
struct SwiftUIComponentsApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    private var session = UserSession(token: "", name: "Luis")

    init() {

    }

    var body: some Scene {
        WindowGroup {
            HomeView()
                .environmentObject(session)
        }
    }
}
