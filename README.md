# 🎯 WebSocket

<img src="https://github.com/rasitesdmr/springboot-websocket/blob/master/image/ws1.png">

* HTTP ve WebSocket, client-server (istemci-sunucu) iletişiminde kullanılan iletişim protokolleridir.

## 📌 HTTP PROTOCOL ?

<img src="https://github.com/rasitesdmr/springboot-websocket/blob/master/image/http1.png">

* İstemcinin (client) isteği (request) ve sunucunun (server) yanıtı (response) gönderdiği yerde HTTP tek yönlüdür.
* Bir örnek verelim, bir kullanıcı (client) sunucuya (server) bir istek (request) gönderdiğinde, bu istek
  HTTP veya HTTPS biçiminde olur, bir istek sunucusu aldıktan sonra istemciye (client) yanıtı gönderir,
  her istek (request), yanıtı (response) gönderdikten sonra karşılık gelen bir yanıtla ilişkilendirilir.
* Bağlantı kapanır, her HTTP veya HTTPS isteği her seferinde sunucuyla yeni bağlantı kurar ve yanıt alındıktan sonra
  bağlantı kendi kendine sonlandırılır.
* HTTP, bağlantı yönelimli bir protokol olan TCP'nin üstünde çalışan durumsuz bir protokoldür, üç yönlü el sıkışma
  yöntemlerini kullanarak veri paketi aktarımının teslimini garanti eder ve kaybolan paketleri yeniden iletir.
* HTTP, TCP, SCTP gibi herhangi bir güvenilir bağlantı yönelimli protokolün üzerinde çalışabilir. Bir istemci sunucuya
  bir HTTP isteği gönderdiğinde, istemci ile sunucu arasında bir TCP bağlantısı açılır ve yanıt alındıktan sonra TCP
  bağlantısı sonlandırılır, her HTTP isteği sunucuya ayrı bir TCP bağlantısı açar, örn. istemci sunucuya 10 istek
  gönderirse 10 ayrı TCP bağlantısı açılacaktır. ve yanıt/geri dönüş aldıktan sonra kapanır.

## 📌 TCP (Transmission Control Protocol) (Geçiş kontrol protokolü) ?

* TCP (Transmission Control Protocol) bilgisayarlar arasındaki iletişimin, küçük paketler hâlinde ve kayıpsız olarak
  gerçekleştirilmesini sağlayan bir protokoldür.
* Aslında TCP (Transmission Control Protocol) protokolünün en önemli özelliği kimlik doğrulaması yapması ve veriyi
  karşı tarafa gönderirken veya alırken verinin bütünlüğünü sağlamasıdır.
* Gelişmiş bilgisayar ağlarında ortaya çıkan kayıpları önlemek için TCP protokolü yazılmıştır.
  HTTP, HTTPS, POP3, SSH, SMTP, TELNET ve FTP gibi günlük hayatta sıkça kullandığımız protokollerin veri iletimi TCP
  vasıtasıyla yapılır

## 📌 TCP Nasıl Çalışır ?

* TCP protokolünün çalışma mantığı üç başlıkta incelenebilir.
* Birinci aşamada hedefe bir bağlantı isteği gönderilir.
* İkinci aşamada bağlantının gerçekleştiği onaylanır ve veri transferi başlar.
* Üçüncü aşamada ise veri transferinin tamamlandığı taraflara iletilerek bağlantı sonlandırılır.
* Bu üç aşamanın gerçekleşmesi ‘’State’’ işlemi olarak tanımlanır.

## 📌 WEBSOCKET PROTOCOL ?

<img src="https://github.com/rasitesdmr/springboot-websocket/blob/master/image/ws2.png">

* WebSocket iki yönlüdür.
* HTTP'nin aksine ws:// veya wss:// ile başlar, aynı istemci-sunucu (client-server) iletişim senaryosunda kullanılan tam
  çift yönlü bir protokoldür.
* Durum bilgisi olan bir protokoldür, yani istemci ve sunucu arasındaki bağlantı, taraflardan biri (istemci veya sunucu)
  tarafından sonlandırılıncaya kadar canlı kalacaktır.
* İstemci ve sunucudan herhangi biri tarafından bağlantı kapatıldıktan sonra, bağlantı her iki uçtan da sonlandırılır.
* İstemci-sunucu iletişimine bir örnek verelim.
* Bir web tarayıcısı ve bir sunucu olan istemci var, istemci ve sunucu arasındaki bağlantıyı her başlattığımızda,
  istemci-sunucu el sıkışmasını yaptı ve yeni bir bağlantı oluşturmaya karar verdi ve bu bağlantı herhangi biri
  tarafından
  sonlandırılıncaya kadar hayatta kalacaktır.
* Bağlantı kurulduğunda ve canlı olduğunda iletişim, sonlandırılıncaya kadar aynı bağlantı kanalı kullanılarak
  gerçekleşir.
* İstemci-sunucu el sıkışmasından sonra, istemci-sunucu onu canlı tutmak için yeni bir bağlantıya karar verir,
  bu yeni bağlantı WebSocket olarak bilinir.
* İletişim bağlantısı kurulduktan ve bağlantı açıldıktan sonra, istemci-sunucu arasındaki bağlantı devam edene kadar
  mesaj alışverişi çift yönlü modda gerçekleşecektir.
* Bunlardan herhangi biri (istemci-sunucu) ölürse veya bağlantıyı kapatmaya karar verirse, her iki taraf da kapatılır.
* Soketin çalışma şekli, HTTP'nin çalışma şeklinden biraz farklıdır, durum kodu 101, WebSocket'teki anahtarlama
  protokolünü belirtir.

## 📌 When not to use WebSocket ?

* Ağ üzerinden iletilen gerçek zamanlı güncellenmiş veya sürekli veri akışlarını istiyorsak WebSocket kullanılabilir.
* Eski verileri getirmek istiyorsak veya bir uygulama ile işlemek için verileri yalnızca bir kez almak istiyorsak
  HTTP protokolü ile gitmeliyiz, çok sık gerekmeyen veya yalnızca bir kez alınan eski veriler basit HTTP isteği ile
  sorgulanabilir, bu yüzden bu senaryoda WebSocket kullanmamak daha iyidir.

<img src="https://github.com/rasitesdmr/springboot-websocket/blob/master/image/ws4.png">