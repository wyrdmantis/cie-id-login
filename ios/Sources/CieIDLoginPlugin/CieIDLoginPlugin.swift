import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(CieIDLoginPlugin)
public class CieIDLoginPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "CieIDLoginPlugin"
    public let jsName = "CieIDLogin"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = CieIDLogin()

    @objc func loginWithCieID(_ call: CAPPluginCall) {
        call.unimplemented("Not implemented on iOS.")
    }
}
