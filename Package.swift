// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CieIdLogin",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CieIdLogin",
            targets: ["CieIDLoginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CieIDLoginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CieIDLoginPlugin"),
        .testTarget(
            name: "CieIDLoginPluginTests",
            dependencies: ["CieIDLoginPlugin"],
            path: "ios/Tests/CieIDLoginPluginTests")
    ]
)