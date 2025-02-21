//
//  MainItemView.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

struct MainItemView : View {
    @ObservedObject var viewModel: MainViewModel

    let item: ItemMain
    @State private var showingAlert = false

    var body: some View {
        ZStack(alignment: .leading) {
            Rectangle()
                .foregroundColor(Color.white)
                .cornerRadius(8)
                .shadow(color: Color.gray,
                        radius: 4)
            HStack(spacing: 8) {
                // Avatar image
                ItemAvatarView(image: item.image ?? "",
                           size: CGFloat(60.0))
                ItemDetailView(title: item.title,
                               subtitle: item.subtitle)
            }
            .padding(8)
            .background(Color.white)
        }
        .padding(4)
        .onTapGesture {
            self.showingAlert = !self.showingAlert
            self.viewModel.deleteStudents()
        }
        .alert(isPresented: self.$showingAlert) {
            Alert(title: Text("Important message"),
                  message: Text(item.title),
                  dismissButton: .default(Text("Got it!")))
        }
    }
}

#if DEBUG
struct MainItemView_Previews: PreviewProvider {
    static var previews: some View {
        MainItemView(viewModel: MainViewModel(), item: MainViewModel().students.first ?? ItemMain(title: "David"))
    }
}
#endif
