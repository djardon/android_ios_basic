//
//  Student.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

typealias ItemsMain = Array<ItemMain>

class ItemMain: Identifiable {
    /// image
    var image: String?
    /// title
    var title: String
    /// subtitle
    var subtitle: String?
    
    /// Init
    init(image: String? = nil, title: String, subtitle: String? = nil) {
        self.image = image
        self.title = title
        self.subtitle = subtitle
    }
}


/// Student
class Student: Identifiable  {
    /// student name
    var name: String
    /// student email
    var email: String?
    /// student avatar
    var avatar: String?
    /// student birthdate
    var birthdate: Date?
    
    /// Init
    init(name: String, avatar: String? = nil, email: String? = nil, birthdate: Date? = nil) {
        self.name = name
        self.email = email
        self.avatar = avatar
        self.birthdate = birthdate
    }
}
