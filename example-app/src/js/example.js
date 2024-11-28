import { CieIDLogin } from 'cie-id-login';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CieIDLogin.echo({ value: inputValue })
}
