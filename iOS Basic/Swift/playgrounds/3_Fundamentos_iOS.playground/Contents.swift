import UIKit

// CLOSURES

var friends = ["Roos", "Rachel", "Monica", "Phoebe", "Joey", "Chandler"]
friends.forEach { friend in
    print(friend)
}

friends.forEach { print($0) }

friends.filter { $0.isEmpty }
friends.filter { friend in
    return friend.isEmpty
}

friends.first { !$0.isEmpty && $0.count > 4 }

let friendsNameCount = friends.map { $0.count }
print(friendsNameCount)


typealias CustomClosure = (Int) -> Int

let sum7: CustomClosure = {  (num: Int) -> Int in
    return num + 7
}

func closure(sum: CustomClosure) -> Int {
    return sum(10)
}

print(closure(sum: sum7))

print(closure { paramNum -> Int in
    return paramNum + 10
})


class Shop {
    var price: Float = 0.5
    var name: String = ""
    
    func updateName(name: String) {
        self.name = name
        print("updateName de Shop")
    }
}

protocol ShopProtocol {
    var clients: Int { get set }
    
    func calculateReveneu()
    func clientsNumber() -> Int
}

class Cafeteria: Shop, ShopProtocol {
    var clients: Int = 0
    
    func calculateReveneu() {
        
    }
    
    func clientsNumber() -> Int {
        return 0
    }
    
    var coffees: Int = 10 {
        willSet(newCoffees) {
            print("Viene más café \(newCoffees), teníamos \(coffees)")
        }
        didSet {
            print("Tenemos más café \(coffees)")
            totalCoffessPrice = Float(coffees) * price
        }
    }
    
    var totalCoffessPrice: Float = 0
    
    override func updateName(name: String) {
        super.updateName(name: name)
        print("updateName de Cafetería")
        
    }
}

let cafeteria = Cafeteria()
cafeteria.name = "Central Perk"
cafeteria.coffees = 100
cafeteria.totalCoffessPrice
cafeteria.coffees += 200
cafeteria.totalCoffessPrice
cafeteria.updateName(name: "Cafetería bonita")
cafeteria.name



class Bar: ShopProtocol {
    var clients: Int = 10
    
    func calculateReveneu() {
        
    }
    
    func clientsNumber() -> Int {
        let callback: () -> Void = { [weak self] in
            self?.clients
        }
        return clients
    }
}

let bar = Bar()


func showShopData(shop: ShopProtocol) {
    print(shop.clients)
}

showShopData(shop: bar)
showShopData(shop: cafeteria)


protocol FriendsDelegate: AnyObject {
    func orderPizza(num: Int) -> Bool
    func takeABreak()
}

class FriendsFunctionsDelegate {
    weak var delegate: FriendsDelegate? = nil
    
    func pizza() {
        delegate?.orderPizza(num: 10)
    }
    
    func sleep() {
        delegate?.takeABreak()
    }
}

class FriendsFunctions: FriendsDelegate {
    func orderPizza(num: Int) -> Bool {
        print("He pedido \(num) pizzas")
        return true
    }
    
    func takeABreak() {
        print("Nos estábamos tomando un descanso!!")
    }
}

let friendsFunctionsDelegate = FriendsFunctionsDelegate()
let friendsFunctions = FriendsFunctions()

friendsFunctionsDelegate.delegate = friendsFunctions
friendsFunctionsDelegate.pizza()
friendsFunctionsDelegate.sleep()


// Singleton
class UserSession {
    static let shared = UserSession()
    private init() {}
    
    var userName: String = ""
    
    func sayHello() {
        print("Hello!")
    }
}

UserSession.shared.sayHello()
UserSession.shared.userName = "David"





