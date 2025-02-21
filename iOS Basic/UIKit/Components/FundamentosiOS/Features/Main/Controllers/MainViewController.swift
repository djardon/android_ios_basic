//
//  MainViewController.swift
//  FundamentosiOS
//
//  Created by David Jardon on 24/06/21.
//

import UIKit

class MainViewController: UIViewController {

    // MARK: - IBOutlets
    @IBOutlet weak var labelHello: UILabel!
    @IBOutlet weak var panicButton: UIButton!
    
    // MARK: - IBActions
    @IBAction func onPanicPressed(_ sender: Any) {
        print("onPanicButtonPressed")
    }
    
    // MARK: - Public properties
    
    // MARK: - Private properties
    
    
    // MARK: - Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        print("viewDidLoad")

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        print("viewWillAppear")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        print("viewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        print("viewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        print("viewDidDisappear")
    }
}
