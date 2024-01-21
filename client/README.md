## App Client (emulates Smartphone App)

+ To emulate the Smartphone App client:

        java -jar client-${PUT_LATEST_VERSION_HERE}.jar -mode app -host localhost -port 9443


+ In this client: register new user and/or login with the same credentials

        Command Email Password AppName
        register username@example.com UserPassword Blynk

        Command Email Password S.O* Version* AppName* (*optional parameters)
        login username@example.com UserPassword Android 2.27.34 Blynk


+ Save profile with simple dashboard

        createDash {"id":1, "name":"My Dashboard"}


+ Create device in previously created dashboard

        Command DashId Device* (*json format)
        createDevice 1 {"id":1, "name":"Device 001", "boardType":"Arduino UNO"}


+ You will get server response similar to this:

    	14:11:07.503 TRACE - Incoming client id=19220, command=CreateDevice, body='{"id":1,"name":"Device 001","boardType":"Generic Board","token":"yw6kFlwrL_wKKsIIowb8w9COPmR8pa7m","status":"OFFLINE","disconnectTime":0,"connectTime":0,"firstConnectTime":0,"dataReceivedAt":0,"isUserIcon":false}'


Where `yw6kFlwrL_wKKsIIowb8w9COPmR8pa7m` is your Auth Token.

## Hardware Client (emulates Hardware)

+ Start new client and use received Auth Token to login

    	java -jar client-${PUT_LATEST_VERSION_HERE}.jar -mode hardware -host localhost -port 8442
    	login 33bcbe756b994a6768494d55d1543c74
   

You can run as many clients as you want. You have only 15 seconds for login until your client will be disconnected from server, 
so hurry up :).

Clients with the same credentials and Auth Token are grouped into one Session and can send messages to each other.
All client’s commands are human-friendly, so you don't have to remember the codes.

## Hardware Commands

List of hardware commands:

+ Digital write:

    	hardware dw 9 1
    	hardware dw 9 0


+ Digital read:

    	hardware dr 9
    	You should receive response: dw 9 <val>


+ Analog write:

    	hardware aw 14 123


+ Analog read:

    	hardware ar 14
        You should receive response: aw 14 <val>


+ Virtual write:

    	hardware vw 9 1234
        hardware vw 9 string
        hardware vw 9 item1 item2 item3
        hardware vw 9 key1 val1 key2 val2

 
+ Virtual read:

    	hardware vr 9
    	You should receive response: vw 9 <values>
