//
//  MainView.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI


struct MainView: View {
    @ObservedObject var viewModel: MainViewModel
    @State private var selection = 0
    
    var body: some View {
        NavigationView {
            TabView(selection: $selection) {
                MainListView(viewModel: viewModel, items: viewModel.students)
                .tabItem {
                    Image("ic_tab_students")
                    Text("title_students")
                }.tag(0)
                
                MainListView(viewModel: viewModel, items: viewModel.teachers)
                .tabItem {
                    Image("ic_tab_teachers")
                    Text("title_teachers")
                }.tag(1)
                
                MainListView(viewModel: viewModel, items: viewModel.subjects)
                .tabItem {
                    Image("ic_tab_subjects")
                    Text("title_subjects")
                }.tag(2)
            }
            .navigationBarTitle(title(for: selection))
        }
        .onAppear(perform: viewModel.loadAll)
    }
    
    private func title(for selection: Int) -> Text {
        switch selection {
            case 0:
                return Text("title_students")
                
            case 1:
                return Text("title_teachers")
                
            default:
                return Text("title_subjects")
        }
    }
}

#if DEBUG
struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        ForEach(["iPhone 11 Pro", "iPhone 11 Pro Max", "iPhone SE"], id: \.self) { deviceName in
            Group {
                MainView(viewModel: MainViewModel())
                    .environment(\.locale, Locale(identifier: "en"))
                    .previewDevice(PreviewDevice(rawValue: deviceName))
            }
        }
    }
}
#endif
