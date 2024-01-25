# Este não é o fonte original do servidor Blynk Legacy
Este é uma cópia de https://github.com/Peterkn2001/blynk-server.
O repositório do servidor Blynk Legacy foi removido há algum tempo. Eu clonei este porque tenho o servidor rodando localmente em minha casa, então tenho uma dependência dele. O servidor Blynk Legacy foi descontinuado e não há mais suporte. Portanto enconrajo você fortemente a usar o novo e oficial [Blynk IOT](https://blynk.io/).
As versões lançadas aqui serão apenas atualização tradução dos manuais para pt-BR, correções de bugs e pequenas implementações sem nenhuma garantia ou suporte, use por sua conta e risco!!!

### Observe que o servidor Blynk Legacy foi descontinuado e não há mais suporte!
Ele não funciona com o aplicativo Blynk mais recente, e o aplicativo legado foi retirado das lojas de aplicativos app/play stores a partir de 30 de junho de 2022. Os aplicativos instalados anteriormente continuarão funcionando, embora versões posteriores do aplicativo legado não tenham a capacidade de criar novas contas, portanto, será necessária uma versão anterior do aplicativo ou a conta precisará ser criada manualmente, copiando e renomeando a conta Blynk.cc padrão.

Os servidores em nuvem legados foram desativados em 31 de dezembro de 2022. Isso não terá impacto nos servidores legados locais, mas como todo o suporte e atualizações para este servidor local legado e os aplicativos legados já cessaram, o uso de um servidor legado local deve ser considerado como medida provisória, porque o servidor eventualmente se tornará vulnerável quando o suporte para Java 11 for retirado e quando os aplicativos não funcionarem mais em versões mais recentes dos sistemas operacionais móveis.

A instalação do aplicativo iOS depois de retirado da app store exigirá o jailbraking do dispositivo móvel da Apple, e os usuários do Android precisarão obter e carregar lateralmente uma cópia do aplicativo legado fora da playstore.

# O que é o Blynk?

Blynk é uma plataforma com aplicativos iOS e Android para controlar Arduino, ESP8266, Raspberry Pi e similares pela Internet.
Você pode construir facilmente interfaces gráficas para todos os seus projetos simplesmente arrastando e soltando widgets. 
Se precisar de mais informações, acesse estes links:
* [Site Blynk](https://www.blynk.io)
* [Documentos Blynk](http://docs.blynk.cc)
* [Comunidade Blynk](https://community.blynk.cc)
* [Gerador de Exemplos Blynk](https://examples.blynk.cc)
* [Facebook](http://www.fb.com/blynkapp)
* [Twitter](http://twitter.com/blynk_app)
* [Blynk library](https://github.com/Josafa2018/blynk-library)
* [Kickstarter](https://www.kickstarter.com/projects/167134865/blynk-build-an-app-for-your-arduino-project-in-5-m/description)

![Configurações do Dashboard](https://github.com/Josafa2018/blynk-server-legacy/blob/master/docs/overview/dash_settings.png)
![Widgets Box](https://github.com/Josafa2018/blynk-server-legacy/blob/master/docs/overview/widgets_box.png)
![Dashboard](https://github.com/Josafa2018/blynk-server-legacy/blob/master/docs/overview/dash.png)
![Dashboard2](https://github.com/Josafa2018/blynk-server-legacy/blob/master/docs/overview/dash2.png)

# Conteúdo

- [Download](#servidor-blynk)
- [Requisitos](#requisitos)
- [Configuração Rápida do Servidor](#configuração-rápida-do-servidor)
- [Habilitando E-mail no Servidor](#habilitando-email-no-servidor)
- [Configuração Rápida do Servidor no Raspberry PI](#configuração-rápida-do-servidor-no-raspberry-pi)
- [Configuração do Contêiner Docker](#configuração-do-contêiner-docker)
- [Habilitando a Reinicialização Automática do Servidor em Sistemas Linux](#habilitando-a-reinicialização-automática-do-servidor-em-sistemas-linux)
- [Habilitando a Reinicialização Automática do Servidor no Windows](#habilitando-a-reinicialização-automática-do-servidor-no-windows)
- [Atualizando o Servidor em Sistemas Linux](#atualizando-o-servidor-em-sistemas-linux)
- [Atualizando o Servidor no Windows](#atualizando-o-servidor-no-windows)
- [Configurando App e sketch para Servidor](#configurando-app-e-sketch-para-servidor)
- [Configuração Avançada do Servidor](#configuração-avançada-do-servidor)
- [Interface de Administração](#ui-administração)
- [API HTTP/S RESTful](#https-restful)
- [Habilitando Envio de SMS no Servidor](#habilitando-envio-de-sms-no-servidor)
- [Habilitando o armazenamento de dados raw](#habilitando-o-armazenamento-de-dados-raw)
- [Gerar Certificados Automáticos Let's Encrypt](#gerar-certificados-automáticos-lets-encrypt)
- [Gerar Certificados Manuais Let's Encrypt SSL/TLS](#gerar-certificados-manuais-lets-encrypt-ssltls)
- [Gerar Certificado Auto-Asssinado SSL](#gerar-certificado-auto-asssinado-ssl)
- [Instalação Java no Ubuntu](#instalação-java-no-ubuntu)
- [Como funciona o Blynk?](#como-funciona-o-blynk)
- [Protocolo Blynk](#protocolo-blynk)

# INICIANDO

## Servidor Blynk
Blynk é um servidor Java open-source baseado em [Netty](https://github.com/netty/netty), responsável por encaminhar mensagens entre o aplicativo móvel Blynk e várias placas microcontroladoras e SBCs (ou seja, Arduino, Raspberry Pi. etc).

**Baixe a versão mais recente do servidor [aqui](https://github.com/Josafa2018/blynk-server-legacy/releases).**

[![GitHub version](https://img.shields.io/github/release/Josafa2018/blynk-server.svg)](https://github.com/Josafa2018/blynk-server-legacy/releases/latest)
[![GitHub download](https://img.shields.io/github/downloads/Josafa2018/blynk-server-legacy/total.svg)](https://github.com/Josafa2018/blynk-server-legacy/releases/latest)

## Requisitos
- Necessário Java 8/11 (OpenJDK, Oracle) 
- Qualquer sistema operacional que possa executar java 
- Pelo menos 30 MB de RAM (pode ser menos com ajuste)
- Portas abertas 9443 (para aplicativos e hardware com ssl), 8080 (para hardware sem ssl)

[Instalação do Java no Ubuntu](#instalação-do-java-no-ubuntu).

Para Windows baixe o Java [aqui](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) e instale. 

## Configuração Rápida do Servidor

+ Certifique-se de estar usando Java 11

        java -version
        Output: java version "11"

+ Execute o servidor nas portas padrão '8080 para hardware' e '9443 para aplicativos' (porta SSL)

        java -jar server-0.41.18.jar -dataFolder /path
        
É isso! 

**NOTA: ```/path``` deve ser o caminho para uma pasta existente onde você deseja armazenar todos os seus dados.**

+ Como saída você deverá ver algo assim:

        Blynk Server successfully started.
        All server output is stored in current folder in 'logs/blynk.log' file.
        
### Habilitando Email no Servidor

### NOTA 1 - A partir de 30 de maio de 2022, o Google parou de permitir aplicativos menos seguros em contas pessoais do Gmail, portanto, o e-mail do servidor local Blynk não será possível na maioria dos casos.

### NOTA 2 - Para utilização de uma conta Gmail é nececessário ativar verificação de duas etapas nas configurações de sua conta Gmail, e em seguida acessar o link `Verificação de duas etapas` ir até a opção `Senhas de app` e criar uma senha para ser usada nas configuração abaixo.

Para ativar notificações por email no Servidor Local, você precisa fornecer as credenciais de email. Crie um arquivo `mail.properties` na mesma pasta onde `server.jar` está. Configurações do Email:

        mail.smtp.auth=true
        mail.smtp.starttls.enable=true
        mail.smtp.host=smtp.gmail.com
        mail.smtp.port=587
        mail.smtp.username=SEU_EMAIL_AQUI
        mail.smtp.password=SUA_SENHA_DE_APP_AQUI
        
Encontre um exemlo [aqui](https://github.com/Josafa2018/blynk-server-legacy/blob/master/server/notifications/email/src/main/resources/mail.properties).

AVISO : somente contas do Gmail são permitidas.

NOTE : you'll need to setup Gmail to allow less secure applications.
NOTA: você precisará configurar o Gmail e criar senha de aplicativo.
Acesse [here](https://support.google.com/accounts/answer/185833?hl=pt-BR) e terá informações de como criar senha de app.

## Configuração Rápida do Servidor no Raspberry PI

+ Faça login no Raspberry Pi via ssh;
+ Instale o java 11: 
        
        sudo apt install openjdk-11-jdk openjdk-11-jre
        
+ Certifique-se de está usando o Java 11

        java -version
        Output: java version "11"
        
+ Baixe o arquivo jar do servidor Blynk (ou copie-o manualmente para o Raspberry Pi via comando ssh e scp): 
   
        wget "https://github.com/Josafa2018/blynk-server-legacy/releases/download/v0.41.16/server-0.41.18.jar"

+ Execute o servidor na porta padrão '8080 para hardware' e '9443 para aplicativos' (porta SSL)

        java -jar server-0.41.18.jar -dataFolder /home/pi/Blynk
        
É isso! 

+ Na saída você verá algo assim:

        Blynk Server successfully started.
        All server output is stored in current folder in 'logs/blynk.log' file.

## Configuração do Contêiner Docker

### Inicialização rápida

+ Instale o [Docker](https://docs.docker.com/install/)
+ Execute o contêiner Docker

        docker run -p 8080:8080 -p 9443:9443 mpherg/blynk-server

### Inicialização rápida no Raspberry Pi

+ Instale [Docker](https://docs.docker.com/engine/install/debian/)
+ Execute o contêiner Docker

        docker run -p 8080:8080 -p 9443:9443 linuxkonsult/rasbian-blynk

### Personalização completa

+ Verifique o [README](server/Docker) na pasta docker




## Habilitando a Reinicialização Automática do Servidor em Sistemas Linux
        
+ Para ativar a reinicialização automática do servidor, encontre o arquivo /etc/rc.local e adicione:

        java -jar /home/pi/server-0.41.18.jar -dataFolder /home/pi/Blynk &
        
+ Ou se a abordagem acima não funcionar, execute 
       
        crontab -e

adicione a seguinte linha:

        @reboot java -jar /home/pi/server-0.41.18.jar -dataFolder /home/pi/Blynk &
        
salvafr e sair.

## Habilitando a Reinicialização Automática do Servidor no Windows

+ Crie o arquivo bat:

        start-blynk.bat

+ Adicione esse linha nele: 

        java -jar server-0.41.16.jar -dataFolder /home/pi/Blynk
        
+ Coloque o arquivo bat na pasta de inicialização do Windows

Você também pode usar [este](https://github.com/Peterkn2001/blynk-server/tree/master/scripts/win) script para executar o Servidor.

## Atualizando o Servidor em Sistemas Linux

**IMPORTANTE** O servidor deve estar sempre atualizado antes de atualizar o aplicativo Blynk. Para atualizar seu servidor para uma versão mais recente, você precisará encerrar o processo antigo e iniciar um novo.

+ Encontre o ID do processo do servidor Blynk

        ps -aux | grep java
        
+ A saída deve mostrar algo assim
 
        username   10539  1.0 12.1 3325808 428948 pts/76 Sl   Jan22   9:11 java -jar server-0.41.16.jar   
        
+ Encerre o processo antigo.

        kill 10539

10539 - id do processo do servidor blynk na saída do comando acima..
 
+ Inicie o Servidor [normalmente](#quick-local-server-setup)

Após essas etapas, você pode atualizar o aplicativo Blynk. O downgrade da versão do servidor não é compatível. 

**WARNING!**
Please **do not** revert your server to lower versions. You may loose all of your data.

## Atualizando o Servidor no Windows

+ Abra o Gerenciador de Tarefas;

+ Encontre o processo Java;

+ Pare o processo;

+ Inicie o novo servidor [normalmente](#quick-local-server-setup)
                
## Configurando App e Sketch para Servidor

+ Specify custom server path in your application

![Custom server icon](https://github.com/Peterkn2001/blynk-server/blob/master/docs/login.png)
![Server properties menu](https://github.com/Peterkn2001/blynk-server/blob/master/docs/custom.png)

+ Change your ethernet sketch from

    ```
    Blynk.begin(auth);
    ```
    
    to
    
    ```
    Blynk.begin(auth, "your_host", 8080);
    ```
    
    or to
    
    ```
    Blynk.begin(auth, IPAddress(xxx,xxx,xxx,xxx), 8080);
    ```
        
+ Change your WIFI sketch from
        
    ```
    Blynk.begin(auth, SSID, pass));
    ```
   
    to
    
    ```
    Blynk.begin(auth, SSID, pass, "your_host", 8080);
    ```
    
    or to
    
    ```
    Blynk.begin(auth, SSID, pass, IPAddress(XXX,XXX,XXX,XXX), 8080);
    ```
        
+ Change your rasp PI javascript from

    ```
    var blynk = new Blynk.Blynk(AUTH, options = {connector : new Blynk.TcpClient()});
    ```
    
    to
    
    ```
    var blynk = new Blynk.Blynk(AUTH, options= {addr:"xxx.xxx.xxx.xxx", port:8080});
    ```
        
+ or in case of USB when running blynk-ser.sh provide '-s' option with address of your local server

        ./blynk-ser.sh -s you_host_or_IP
        
        
**IMPORTANT** 
Blynk is being constantly developed. Mobile apps and server are updated often. To avoid problems during updates either turn off auto-update for Blynk app, or update both local server and blynk app at same time to avoid possible migration issues.

**IMPORTANT** 
Blynk local server is different from  Blynk Cloud server. They are not related at all. You have to create new account when using Blynk local server.

## Configuração Avançada do Servidor
For more flexibility you can extend server with more options by creating ```server.properties``` file in same folder as ```server.jar```. 
Example could be found [here](https://github.com/Peterkn2001/blynk-server/blob/master/server/core/src/main/resources/server.properties).
You could also specify any path to ```server.properties``` file via command line argument ```-serverConfig```. You can 
do the same with ```mail.properties``` via ```-mailConfig``` and ```sms.properties``` via ```-smsConfig```.
 
For example:

    java -jar server-0.41.16-java8.jar -dataFolder /home/pi/Blynk -serverConfig /home/pi/someFolder/server.properties

Available server options:

+ Blynk app, https, web sockets, admin port
        
        https.port=9443


+ Http, hardware and web sockets port

        http.port=8080
        
        
+ For simplicity Blynk already provides server jar with built in SSL certificates, so you have working server out of the box via SSL/TLS sockets. But as certificate and it's private key are in public this is totally not secure. So in order to fix that you need to provide your own certificates. And change below properties with path to your cert. and private key and it's password. See how to generate self-signed certificates [here](#generate-ssl-certificates)

        #points to cert and key that placed in same folder as running jar.
        
        server.ssl.cert=./server_embedded.crt
        server.ssl.key=./server_embedded.pem
        server.ssl.key.pass=pupkin123

**Note**: if you use Let's Encrypt certificates you'll have to add ```#define BLYNK_SSL_USE_LETSENCRYPT``` before ```#include <BlynkSimpleEsp8266_SSL.h>``` in the Arduino Sketch for your hardware.
        
+ User profiles folder. Folder in which all users profiles will be stored. By default System.getProperty("java.io.tmpdir")/blynk used. Will be created if not exists

        data.folder=/tmp/blynk
        

+ Folder for all application logs. Will be created if it doesn't exist. "." is dir from which you are running script.

        logs.folder=./logs
        

+ Log debug level. Possible values: trace|debug|info|error. Defines how precise logging will be. From left to right -> maximum logging to minimum

        log.level=trace
        

+ Maximum allowed number of user dashboards.

        user.dashboard.max.limit=100
        

+ 100 Req/sec rate limit per user. You also may want to extend this limit on [hardware side](https://github.com/blynkkk/blynk-library/blob/f4e132652906d63d683abeed89f5d6ebe369e37a/Blynk/BlynkConfig.h#L42).

        user.message.quota.limit=100
        

+ this setting defines how often you can send mail/tweet/push or any other notification. Specified in seconds
        
        notifications.frequency.user.quota.limit=60
        

+ Maximum allowed user profile size. In Kb's.

        user.profile.max.size=128
        
        
+ Number of strings to store in terminal widget (terminal history data)

        terminal.strings.pool.size=25
        

+ Maximum allowed number of notification queue. Queue responsible for processing email, pushes, twits sending. Because of performance issue - those queue is processed in separate thread, this is required due to blocking nature of all above operations. Usually limit shouldn't be reached
        
        notifications.queue.limit=5000
        
        
+ Number of threads for performing blocking operations - push, twits, emails, db queries. Recommended to hold this value low unless you have to perform a lot of blocking operations.

        blocking.processor.thread.pool.limit=6
        

+ Period for flushing all user DB to disk. In millis

        profile.save.worker.period=60000

+ Specifies maximum period of time when hardware socket could be idle. After which socket will be closed due to non activity. In seconds. Leave it empty for infinity timeout

        hard.socket.idle.timeout=15
        
+ Mostly required for local servers setup in case user want to log raw data in CSV format. See [raw data] (#raw-data-storage) section for more info.
        
        enable.raw.data.store=true
        
+ Url for opening admin page. Must start from "/". For "/admin" url path will look like that "https://127.0.0.1:9443/admin". 

        admin.rootPath=/admin
        
+ Comma separated list of administrator IPs. Allow access to admin UI only for those IPs. You may set it for 0.0.0.0/0 to allow access for all. You may use CIDR notation. For instance, 192.168.0.53/24.
        
        allowed.administrator.ips=0.0.0.0/0
        
+ Default admin name and password. Will be created on initial server start
        
        admin.email=admin@blynk.cc
        admin.pass=admin

+ Host for reset password redirect and certificate generation. By default current server IP is taken from "eth" network interface. Could be replaced with more friendly hostname. It is recommended to override this property with your server IP to avoid possible problems of host resolving.
        
        server.host=blynk-cloud.com
        
+ Email used for certificate registration, could be omitted in case you already specified it in mail.properties.
        
        contact.email=pupkin@gmail.com
        
## UI Administração

Blynk server provides administration panel where you can monitor your server. It is accessible at this URL:

        https://your_ip:9443/admin
        
![Administration UI](https://github.com/Peterkn2001/blynk-server/blob/master/docs/admin_panel.png)
              
**WARNING**
Please change default admin password and name right after login to admin page. **THIS IS SECURITY MEASURE**.
        
**WARNING**
Default ```allowed.administrator.ips``` setting allows access for everyone. In other words, 
administration page available from any other computer. Please restrict access to it via property ```allowed.administrator.ips```.

### Turn off chrome https warning on localhost

- Paste in chrome 

        chrome://flags/#allow-insecure-localhost

- You should see highlighted text saying: "Allow invalid certificates for resources loaded from localhost". Click enable.
        
## HTTP/S RESTful
Blynk HTTP/S RESTful API allows to easily read and write values to/from Pins in Blynk apps and Hardware. 
Http API description could be found [here](http://docs.blynkapi.apiary.io).

### Habilitando Envio de SMS no Servidor
To enable SMS notifications on Local Server you need to provide credentials for SMS gateway (currently Blynk server
supports only 1 provider - [Nexmo](https://www.nexmo.com/). You need to create file ```sms.properties``` 
within same folder where server.jar is.

        nexmo.api.key=
        nexmo.api.secret=
        
And fill in the above properties with the credentials you'll get from Nexmo. (Account -> Settings -> API settings).
You can also send SMS over email if your cell provider supports that. See [discussion](http://community.blynk.cc/t/sms-notification-for-important-alert/2542) for more details.
 

## Habilitando o Armazenamento de Dados RAW
By default raw data storage is disabled (as it consumes disk space a lot). 
When you enable it, every ```Blynk.virtualWrite``` command will be saved to DB.
You will need to install PostgreSQL Database (**minimum required version is 9.5**) to enable this functionality:

#### 1. Enabling raw data on server

Enable raw data in ```server.properties``` : 

        enable.db=true
        enable.raw.db.data.store=true

#### 2. Install PostgreSQL. Option A

        sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'
        wget -q https://www.postgresql.org/media/keys/ACCC4CF8.asc -O - | sudo apt-key add -
        
        sudo apt-get update
        sudo apt-get install postgresql postgresql-contrib
        
#### 2. Install PostgreSQL.  Option B 

        sudo apt-get update
        apt-get --no-install-recommends install postgresql-9.6 postgresql-contrib-9.6

#### 3. Download Blynk DB script

        wget https://raw.githubusercontent.com/Peterkn2001Peterkn2001/blynk-server/master/server/core/src/main/resources/create_schema.sql
        wget https://raw.githubusercontent.com/Peterkn2001/blynk-server/master/server/core/src/main/resources/reporting_schema.sql

#### 4. Move create_schema.sql and reporting_schema.sql to temp folder (to avoid permission problems)

        mv create_schema.sql /tmp
        mv reporting_schema.sql /tmp
        
Result:  

        /tmp/create_schema.sql
        /tmp/reporting_schema.sql
        
Copy it to clipboard from your console.

#### 5. Connect to PostgreSQL

        sudo su - postgres
        psql

#### 6. Create Blynk DB and Reporting DB, test user and tables

        \i /tmp/create_schema.sql
        \i /tmp/reporting_schema.sql
        
```/tmp/create_schema.sql``` - is path from step 4.
        
You should see next output:

        postgres=# \i /tmp/create_schema.sql
        CREATE DATABASE
        You are now connected to database "blynk" as user "postgres".
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE TABLE
        CREATE ROLE
        GRANT
        GRANT

#### Quit

        \q
               
Now start your server and you should see next text in ```postgres.log``` file : 

        2017-03-02 16:17:18.367 - DB url : jdbc:postgresql://localhost:5432/blynk?tcpKeepAlive=true&socketTimeout=150
        2017-03-02 16:17:18.367 - DB user : test
        2017-03-02 16:17:18.367 - Connecting to DB...
        2017-03-02 16:17:18.455 - Connected to database successfully.
        
WARNING:
Raw data may consume your disk space very quickly!

### CSV data format

Data format is:

        value,timestamp,deviceId
        
For example:

        10,1438022081332,0
        
Where ```10``` - value of pin.
```1438022081332``` - the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
To display the date/time in excel you may use formula:

        =((COLUMN/(60*60*24)/1000+25569))
        
```0``` - device id
        
### Gerar Certificados Automáticos Let's Encrypt

Latest Blynk server has super cool feature - automatic Let's Encrypt certificates generation. 
However, it has few requirements: 
 
+ Add ```server.host``` property in ```server.properties``` file. 
For example : 
 
        server.host=myhost.com

IP is not supported, this is the limitation of Let's Encrypt. Also have in mind that ```myhost.com``` 
should be resolved by public DNS severs.
        
+ Add ```contact.email``` property in ```server.properties```. For example : 
 
        contact.email=test@gmail.com
        
+ You need to start server on port 80 (requires root or admin rights) or 
make [port forwarding](#port-forwarding-for-https-api) to default Blynk HTTP port - 8080.

That's it! Run server as regular and certificates will be generated automatically.

![](https://gifyu.com/images/certs.gif)

### Gerar Certificados Manuais Let's Encrypt SSL/TLS

+ First install [certbot](https://github.com/certbot/certbot) on your server (machine where you going to run Blynk Server)

        wget https://dl.eff.org/certbot-auto
        chmod a+x certbot-auto
        
+ Generate and verify certificates (your server should be connected to internet and have open 80/443 ports)

        ./certbot-auto certonly --agree-tos --email YOUR_EMAIL --standalone -d YOUR_HOST

For example 

        ./certbot-auto certonly --agree-tos --email pupkin@blynk.cc --standalone -d blynk.cc

+ Then add to your ```server.properties``` file (in folder with server.jar)

        server.ssl.cert=/etc/letsencrypt/live/YOUR_HOST/fullchain.pem
        server.ssl.key=/etc/letsencrypt/live/YOUR_HOST/privkey.pem
        server.ssl.key.pass=
        
### Gerar Certificado Auto-Asssinado SSL

+ Generate self-signed certificate and key

        openssl req -x509 -nodes -days 1825 -newkey rsa:2048 -keyout server.key -out server.crt
        
+ Convert server.key to PKCS#8 private key file in PEM format

        openssl pkcs8 -topk8 -v1 PBE-SHA1-2DES -in server.key -out server.enc.key
        
If you connect hardware with [USB script](https://github.com/blynkkk/blynk-library/tree/master/scripts) you have to provide an option '-s' pointing to "common name" (hostname) you did specified during certificate generation.
        
As an output you'll retrieve server.crt and server.pem files that you need to provide for server.ssl properties.

### Instalação do Java no Ubuntu

        sudo add-apt-repository ppa:openjdk-r/ppa \
        && sudo apt-get update -q \
        && sudo apt install -y openjdk-11-jdk
        
or if above doesn't work:

        sudo apt-add-repository ppa:webupd8team/java
        sudo apt-get update
        sudo apt-get install oracle-java8-installer
        
### Port forwarding for HTTP/S API

        sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
        sudo iptables -t nat -A PREROUTING -p tcp --dport 443 -j REDIRECT --to-port 9443

### Enabling QR generation on server
        
        sudo apt-get install libxrender1

### Behind wifi router
If you want to run Blynk server behind WiFi-router and want it to be accessible from the Internet, you have to add port-forwarding rule on your router. This is required in order to forward all of the requests that come to the router within the local network to Blynk server.

### How to build
Blynk has a bunch of integration tests that require DB, so you have to skip tests during build.

        mvn clean install -Dmaven.test.skip=true
        
### Como Funciona o Blynk?
When hardware connects to Blynk cloud it opens either keep-alive ssl/tls connection on port 443 (9443 for local servers) or keep-alive plain
tcp/ip connection on port 8080. Blynk app opens mutual ssl/tls connection to Blynk Cloud on port 443 (9443 for local servers).
Blynk Cloud is responsible for forwarding messages between hardware and app. In both (app and hardware) connections Blynk uses 
own binary protocol described below.

### Protocolo Blynk


#### Hardware side protocol

Blynk transfers binary messages between the server and the hardware with the following structure:

| Command       | Message Id    | Length/Status   | Body     |
|:-------------:|:-------------:|:---------------:|:--------:|
| 1 byte        | 2 bytes       | 2 bytes         | Variable |

Command and Status definitions: [BlynkProtocolDefs.h](https://github.com/Peterkn2001/blynk-library/blob/7e942d661bc54ded310bf5d00edee737d0ca44d7/src/Blynk/BlynkProtocolDefs.h)


#### Mobile app side protocol

Blynk transfers binary messages between the server and mobile app with the following structure:

| Command       | Message Id    | Length/Status   | Body     |
|:-------------:|:-------------:|:---------------:|:--------:|
| 1 byte        | 2 bytes       | 4 bytes         | Variable |


#### Websockets web side protocol

Blynk transfers binary messages between the server and websockets (for web) with the following structure:

| Websocket header   | Command       | Message Id    | Body     |
|:------------------:|:-------------:|:-------------:|:--------:|
|                    | 1 byte        | 2 bytes       | Variable |


When command code == 0, than message structure is next:

| Websocket header   | Command       | Message Id    | Response code |
|:------------------:|:-------------:|:-------------:|:-------------:|
|                    | 1 byte        | 2 bytes       | 4 bytes       |

[Possible response codes](https://github.com/Peterkn2001/blynk-server/blob/master/server/core/src/main/java/cc/blynk/server/core/protocol/enums/Response.java#L12).
[Possible command codes](https://github.com/Peterkn2001/blynk-server/blob/master/server/core/src/main/java/cc/blynk/server/core/protocol/enums/Command.java#L12)

Message Id and Length are [big endian](http://en.wikipedia.org/wiki/Endianness#Big-endian).
Body has a command-specific format.

## Licensing
[GNU GPL license](https://github.com/Peterkn2001/blynk-server/blob/master/license.txt)
