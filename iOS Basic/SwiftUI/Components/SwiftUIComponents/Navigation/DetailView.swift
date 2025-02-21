//
//  DetailView.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 21/12/22.
//

import SwiftUI

struct DetailView: View {
    @EnvironmentObject var session: UserSession

    var body: some View {
        Text("Hello, \(session.name)!")
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView()
            .environmentObject(UserSession(token: "", name: "David"))
    }
}
