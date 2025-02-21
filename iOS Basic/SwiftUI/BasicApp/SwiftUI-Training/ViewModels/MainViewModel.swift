//
//  MainViewModel.swift
//  SwiftUI-Training
//
//  Created by David Jardon on 15/10/2019.
//  Copyright © 2019 ds. All rights reserved.
//

import Foundation
import SwiftUI
import Combine

class MainViewModel: ObservableObject {
    @Published var students: ItemsMain = [ItemMain]()
    @Published var teachers: ItemsMain = [ItemMain]()
    @Published var subjects: ItemsMain = [ItemMain]()
    
    func loadAll() {
        loadStudents()
        loadTeachers()
        loadSubjects()
    }
    
    func deleteStudents() {
        students = students.dropLast()
    }
    
    func loadStudents() {
        
        
        
        students = defaultStudents.compactMap { student in
            return ItemMain(image: student.avatar,
                            title: student.name,
                            subtitle: student.email)
        }
    }
    
    func loadTeachers() {
        teachers = defaultTeachers.compactMap { teacher in
            return ItemMain(image: teacher.avatar,
                            title: teacher.name,
                            subtitle: teacher.email)
        }
    }
    
    func loadSubjects() {
        subjects = defaultSubjects.compactMap { subject in
            return ItemMain(image: subject.avatar,
                            title: subject.name)
        }
    }
}
