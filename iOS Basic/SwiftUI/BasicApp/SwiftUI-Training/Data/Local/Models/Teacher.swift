//
//  Teacher.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 22/09/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import SwiftUI

typealias Teachers = Array<Teacher>

/// Teacher
class Teacher: Identifiable {
    // Enum for teacher type with two options 'intern' or 'extern'
    enum TeacherType: CustomStringConvertible {
        case intern
        case extern
        
        // Use CustomStringConvertible and description
        // to print String representation of the enum
        // we can localize all strings with this method
        var description: String {
            switch self {
                case .intern:
                    return "Intern"
                
                case .extern:
                    return "Extern"
            }
        }
    }
    
    /// teacher name
    let name: String
    /// teacher email
    let email: String?
    /// teacher avatar
    let avatar: String?
    /// teacher birthdate
    let birthdate: Date?
    /// teacher type
    var type: TeacherType?

    /// Init
    init(name: String, avatar: String? = nil, email: String? = nil, birthdate: Date? = nil, type: TeacherType? = nil) {
        self.name = name
        self.email = email
        self.avatar = avatar
        self.birthdate = birthdate
        self.type = type
    }
}
