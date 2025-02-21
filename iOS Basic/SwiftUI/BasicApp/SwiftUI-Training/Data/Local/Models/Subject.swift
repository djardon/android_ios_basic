//
//  Subject.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

typealias Subjects = Array<Subject>

/// Subject
class Subject: Identifiable {
    /// subject name
    let name: String
    /// subject avatar
    let avatar: String?
    /// subject birthdate
    let year: Date?
    /// subject teachers
    var teachers: [Teacher]
    /// subject students
    var students: [Student]
    
    /// Init
    init(name: String, avatar: String? = nil, year: Date? = nil, teachers: [Teacher] = [], students: [Student] = []) {
        self.name = name
        self.avatar = avatar
        self.year = year
        self.teachers = teachers
        self.students = students
    }
}
