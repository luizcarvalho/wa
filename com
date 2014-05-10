ATIVAR DUAS INTERFACES
svc wifi enable
svc data enable
svc data prefer

== ADICIONAR ROTAS
route add 208.67.222.222 gw 192.168.1.100 dev wlan0
route add default gw 192.168.1.100 dev wlan0
ip ro chg 10.0.0/24 dev dummy


netcfg wlan0 up
ifconfig wlan0 192.168.1.105 netmask 255.255.255.0
route add 192.168.1.100 gw 192.168.1.100 dev wlan0
setprop net.dns1 8.8.8.8
netcfg

== SHOW INTERFACES
netcfg

== UP INTERFACE
ifconfig wlan0 

== LIST ROUTES
ip route show
ip route list table main 
ip route list table local

== CLEAN CACHE
ip route flush cache

== ADICIONAR ROTA 
ip route add 208.67.222.222 via 192.168.1.1 dev wlan0 (OK)
ip route add 208.67.222.222 dev wlan0

