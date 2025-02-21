//
//  MainView.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 21/12/22.
//

import SwiftUI

struct MainView: View {
    @StateObject private var state = MainState()

    var body: some View {
        NavigationView {
            VStack {
                if state.showLoading {
                    progressView
                } else {
                    ZStack {
                        contentView
                        VStack {
                            Spacer()
                            actionView
                        }
                    }
                }
            }
            .frame(maxWidth: .infinity,
                   maxHeight: .infinity)
            .background(Color.colorCustom)
        }
    }

    private var progressView: some View {
        ProgressView()
            .scaleEffect(2)
            .tint(.white)
    }

    private var contentView: some View {
        ScrollView(showsIndicators: false) {
            VStack(spacing: 20) {
                Text(state.title)
                    .font(.largeTitle)
                    .foregroundColor(.white)
                Text(state.description)
                    .multilineTextAlignment(.center)
                    .font(.body)
                    .foregroundColor(.white)
            }
            .padding(.top, 20)
            .padding(.bottom, 60)
            .padding(.horizontal, 20)
        }
    }

    private var actionView: some View {
        NavigationLink {
            HomeView()
        } label: {
            HStack {
                Text("Next")
                Image(systemName: "arrow.right")
            }
            .foregroundColor(.black)
            .padding(12)
            .background(Color.white)
            .clipShape(Capsule())
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
