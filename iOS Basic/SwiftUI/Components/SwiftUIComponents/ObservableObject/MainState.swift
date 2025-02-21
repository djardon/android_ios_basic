//
//  MainState.swift
//  SwiftUIComponents
//
//  Created by David Jardon on 21/12/22.
//

import Foundation


@MainActor final class MainState: ObservableObject {

    @Published private(set) var showLoading: Bool
    @Published private(set) var title: String = ""
    @Published private(set) var description: String = ""


    init() {
        showLoading = true
        loadConfiguration()
    }


    private func loadConfiguration() {
        DispatchQueue.main.asyncAfter(deadline: .now() + 3) { [weak self] in
            self?.title = "Content Main"
            self?.description = """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse non ullamcorper velit. Nam elit augue, vulputate nec tristique non, pellentesque id est. Nam blandit nulla vel vulputate tempor. Aliquam gravida est id malesuada ultricies. Proin tincidunt, massa at cursus rutrum, est sem porttitor justo, at ornare elit libero sit amet ante. Maecenas eros metus, interdum a dui in, suscipit congue felis. Cras ex nunc, placerat et convallis non, cursus nec lorem. Morbi vitae velit ac sapien gravida sodales. Vestibulum sapien massa, finibus ac odio sit amet, pellentesque ultricies massa. Cras laoreet pretium vestibulum. Curabitur in vehicula nulla, et feugiat sem. Curabitur lorem libero, dictum sit amet tellus pharetra, imperdiet efficitur mauris. Aliquam erat volutpat. Donec pellentesque mauris at laoreet accumsan. Ut egestas sem a felis faucibus tincidunt. Mauris tincidunt odio sed finibus faucibus. Nunc venenatis luctus orci, nec molestie ligula tristique a. Vestibulum suscipit luctus aliquet. Nunc aliquam rhoncus lorem, ac egestas quam vulputate sit amet. Proin blandit nisi ipsum, vel blandit tellus gravida sed.

            Vivamus eu eros est. In a pharetra lacus, in sagittis dolor. Sed efficitur lacinia est eget dictum. Aliquam molestie nunc a purus iaculis aliquet quis ac lacus. Cras egestas fermentum mi, mattis ornare felis luctus ac. Mauris sagittis pulvinar consectetur. In lobortis, nisi eu bibendum condimentum, dolor odio finibus lacus, eget pulvinar elit arcu nec tortor. Etiam pharetra ut felis vitae posuere. Phasellus faucibus lectus a enim dictum, a dignissim leo varius. Nulla facilisi.

            Aenean lectus velit, tempor ut viverra a, tincidunt non nunc. Vivamus ornare erat sem, eget laoreet quam lobortis id. Cras et fringilla dolor. Pellentesque eu efficitur orci. Nunc gravida volutpat erat a commodo. Cras vulputate lobortis orci, vitae gravida ligula condimentum et. Aenean vel dolor tellus. Integer ut erat laoreet, sodales nisl sit amet, laoreet neque. Cras elementum non augue eu mattis. Nullam ex ipsum, sagittis sed dictum nec, interdum at urna. Vestibulum luctus, turpis eget eleifend posuere, nisl mi tristique mauris, ut eleifend massa sem eget ante. Nullam sed metus semper, aliquam nunc in, laoreet elit.

            Suspendisse arcu leo, pharetra id nisl vitae, elementum euismod augue. Sed eget tincidunt dui, non malesuada neque. Quisque a mi at lectus tempor aliquam. Ut et libero ultricies, maximus lacus sit amet, condimentum tortor. Pellentesque fermentum venenatis ornare. Nunc accumsan sodales tortor. Vestibulum tempor quam eu nibh gravida, sed fermentum justo pharetra. Curabitur rutrum venenatis tortor eu tristique. Pellentesque rutrum ac tellus quis porta. Nunc rhoncus ultrices varius.

            Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent ornare semper lacus, non convallis turpis pellentesque vitae. Nam rutrum imperdiet pulvinar. Phasellus tristique vehicula felis vitae fringilla. Phasellus eu ipsum turpis. Nullam mauris ipsum, tempus vitae purus at, pellentesque rhoncus elit. Praesent volutpat leo velit, in sodales leo pharetra vitae. Etiam quis fringilla lectus. Integer commodo fringilla nibh.
            """
            self?.showLoading = false
        }
    }
}
