//
//  MainListView.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 15/10/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

struct MainListView: View {
    @ObservedObject var viewModel: MainViewModel

    let items: ItemsMain

    var body: some View {
        List(items) {item  in
            MainItemView(viewModel: self.viewModel, item: item)
        }
        .listStyle(PlainListStyle())
    }
}

#if DEBUG
struct MainListView_Previews: PreviewProvider {
    static var previews: some View {
        MainListView(viewModel: MainViewModel(), items: MainViewModel().students)
    }
}
#endif
