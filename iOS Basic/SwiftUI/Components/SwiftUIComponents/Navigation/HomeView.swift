//
//  HomeView.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 21/12/22.
//

import SwiftUI

struct HomeView: View {
    var body: some View {
        NavigationView {
            VStack {
                Text("Choose the best UI design framework")

                VStack {
                    NavigationLink(destination: DetailView()) {
                        Text("Choose UIKit")
                    }
                    NavigationLink(destination: DetailView()) {
                        Text("Choose SwiftUI")
                    }
                }
            }
            .navigationTitle("UI iOS")
            .navigationBarItems(leading: Button("Option 1") {

            },
                                trailing: Button("Option 2") {

            })
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
