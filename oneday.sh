cdluizcarvalho@redrails-note:~$ adb shell
$ su
# netcfg 
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    DOWN  0.0.0.0         0.0.0.0         0x00000002
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    DOWN  0.0.0.0         0.0.0.0         0x00000002
pdp0     UP    187.46.196.106  255.255.255.0   0x000010d1
# netcfg pdp0
usage: netcfg [<interface> {dhcp|up|down}]
# ifconfig pdp0
pdp0: ip 187.46.196.106 mask 255.255.255.0 flags [up point-to-point running multicast]
# netcfg wlan0 up
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    UP    0.0.0.0         0.0.0.0         0x00000003
# ifconfig wlan0 192.168.1.105 netmask 255.255.255.0
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    UP    192.168.1.105   255.255.255.0   0x00000003
# ping 208.67.222.222
connect: Network is unreachable
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    DOWN  0.0.0.0         0.0.0.0         0x00000002
# ping 208.67.222.222         
PING 208.67.222.222 (208.67.222.222) 56(84) bytes of data.
64 bytes from 208.67.222.222: icmp_seq=1 ttl=52 time=358 ms
64 bytes from 208.67.222.222: icmp_seq=2 ttl=52 time=381 ms
64 bytes from 208.67.222.222: icmp_seq=3 ttl=52 time=302 ms
^C
--- 208.67.222.222 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2002ms
rtt min/avg/max/mdev = 302.525/347.773/381.905/33.349 ms
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    DOWN  0.0.0.0         0.0.0.0         0x00000002
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    UP    192.168.1.102   255.255.255.0   0x00000043
# ping 208.67.222.222                               
PING 208.67.222.222 (208.67.222.222) 56(84) bytes of data.
64 bytes from 208.67.222.222: icmp_seq=2 ttl=52 time=361 ms
64 bytes from 208.67.222.222: icmp_seq=3 ttl=52 time=254 ms
64 bytes from 208.67.222.222: icmp_seq=4 ttl=52 time=407 ms
64 bytes from 208.67.222.222: icmp_seq=5 ttl=52 time=429 ms
64 bytes from 208.67.222.222: icmp_seq=6 ttl=52 time=350 ms
^C
--- 208.67.222.222 ping statistics ---
6 packets transmitted, 5 received, 16% packet loss, time 5005ms
rtt min/avg/max/mdev = 254.102/360.743/429.745/60.656 ms
# ping 208.67.222.222
connect: Network is unreachable
# ifconfig wlan0 192.168.1.102 netmask 255.255.255.0
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    UP    192.168.1.102   255.255.255.0   0x00000003
# ping 208.67.222.222
connect: Network is unreachable
# ping 208.67.222.222
PING 208.67.222.222 (208.67.222.222) 56(84) bytes of data.
64 bytes from 208.67.222.222: icmp_seq=1 ttl=54 time=425 ms
64 bytes from 208.67.222.222: icmp_seq=2 ttl=54 time=292 ms
64 bytes from 208.67.222.222: icmp_seq=3 ttl=54 time=300 ms
64 bytes from 208.67.222.222: icmp_seq=4 ttl=54 time=549 ms
^C
--- 208.67.222.222 ping statistics ---
5 packets transmitted, 4 received, 20% packet loss, time 4004ms
rtt min/avg/max/mdev = 292.270/392.048/549.331/105.019 ms
# route add -host 208.67.222.222 dev wlan0
Invalid argument
# ifconfig
# ifconfig wlan0
wlan0: Cannot assign requested address
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    DOWN  0.0.0.0         0.0.0.0         0x00000002
pdp0     UP    187.47.134.164  255.255.255.0   0x000010d1
# ifconfig wlan0
wlan0: ip 192.168.1.102 mask 255.255.255.0 flags [up broadcast running]
# route add -host <ip> gw dev
cannot open ip: no such file
# route add -host 208.67.222.222 gw dev
Invalid argument
# route list                        
Invalid argument
# route
Invalid argument
# route -show
Invalid argument
# route --show
Invalid argument
# ip
Usage: ip [ OPTIONS ] OBJECT { COMMAND | help }
       ip [ -force ] -batch filename
where  OBJECT := { link | addr | addrlabel | route | rule | neigh | ntable |
                   tunnel | maddr | mroute | monitor | xfrm }
       OPTIONS := { -V[ersion] | -s[tatistics] | -d[etails] | -r[esolve] |
                    -f[amily] { inet | inet6 | ipx | dnet | link } |
                    -o[neline] | -t[imestamp] | -b[atch] [filename] }
# ip route show
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
default via 192.168.1.1 dev wlan0 
# route add -host 208.67.222.222 gw 192.168.1.100 dev wlan0
Invalid argument
# route add 208.67.222.222 gw 192.168.1.100 dev wlan0
Invalid argument
# route add 208.67.222.222 gw 192.168.1.100 dev wlan0
Invalid argument
# route add 192.168.1.100 gw 192.168.1.100 dev wlan0
Invalid argument
# route -v
Invalid argument
# route -n
Invalid argument
# route -e
Invalid argument
# cat /etc/networks
/etc/networks: No such file or directory
# route -n
Invalid argument
# route -h
Invalid argument
# route --help
Invalid argument
# route -help
Invalid argument
# ip ro chg 208.67.222.222 via dev wlan0
Error: an inet address is expected rather than "dev".
# ip
Usage: ip [ OPTIONS ] OBJECT { COMMAND | help }
       ip [ -force ] -batch filename
where  OBJECT := { link | addr | addrlabel | route | rule | neigh | ntable |
                   tunnel | maddr | mroute | monitor | xfrm }
       OPTIONS := { -V[ersion] | -s[tatistics] | -d[etails] | -r[esolve] |
                    -f[amily] { inet | inet6 | ipx | dnet | link } |
                    -o[neline] | -t[imestamp] | -b[atch] [filename] }
# ip route add 208.67.222.222 gw dev wlan0
Error: either "to" is duplicate, or "gw" is a garbage.
# ip show
Object "show" is unknown, try "ip help".
# ip route show
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
default via 192.168.1.1 dev wlan0 
# ip route show
189.117.15.0/24 dev pdp0  proto kernel  scope link  src 189.117.15.143 
default via 189.117.15.1 dev pdp0 
# ifconfig wlan0 192.168.1.102 netmask 255.255.255.0
# netcfg
lo       UP    127.0.0.1       255.0.0.0       0x00000049
dummy0   DOWN  0.0.0.0         0.0.0.0         0x00000082
rmnet0   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet1   DOWN  0.0.0.0         0.0.0.0         0x00001002
rmnet2   DOWN  0.0.0.0         0.0.0.0         0x00001002
usb0     DOWN  0.0.0.0         0.0.0.0         0x00001002
tunl0    DOWN  0.0.0.0         0.0.0.0         0x00000080
gre0     DOWN  0.0.0.0         0.0.0.0         0x00000080
sit0     DOWN  0.0.0.0         0.0.0.0         0x00000080
ip6tnl0  DOWN  0.0.0.0         0.0.0.0         0x00000080
wlan0    UP    192.168.1.102   255.255.255.0   0x00000003
pdp0     UP    189.117.15.143  255.255.255.0   0x000010d1
# ip route add 208.67.222.222 via 192.168.1.1 dev wlan0
# ip route show
208.67.222.222 via 192.168.1.1 dev wlan0 
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
189.117.15.0/24 dev pdp0  proto kernel  scope link  src 189.117.15.143 
default via 189.117.15.1 dev pdp0 
# ping 208.67.222.222
PING 208.67.222.222 (208.67.222.222) 56(84) bytes of data.
From 192.168.1.102 icmp_seq=1 Destination Host Unreachable
From 192.168.1.102 icmp_seq=2 Destination Host Unreachable
From 192.168.1.102 icmp_seq=3 Destination Host Unreachable
From 192.168.1.102 icmp_seq=5 Destination Host Unreachable
From 192.168.1.102 icmp_seq=6 Destination Host Unreachable
From 192.168.1.102 icmp_seq=7 Destination Host Unreachable
^C
--- 208.67.222.222 ping statistics ---
8 packets transmitted, 0 received, +6 errors, 100% packet loss, time 7005ms
, pipe 3
# ip route del 208.67.222.222
# ip route show
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
189.117.15.0/24 dev pdp0  proto kernel  scope link  src 189.117.15.143 
default via 189.117.15.1 dev pdp0 
# ip route add 208.67.222.222 via dev wlan0
Error: an inet address is expected rather than "dev".
# ip route add 208.67.222.222 gw dev wlan0
Error: either "to" is duplicate, or "gw" is a garbage.
# ip route show
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
189.117.15.0/24 dev pdp0  proto kernel  scope link  src 189.117.15.143 
default via 189.117.15.1 dev pdp0 
# ip route del 192.168.1.0/24 
# ip route show
189.117.15.0/24 dev pdp0  proto kernel  scope link  src 189.117.15.143 
default via 189.117.15.1 dev pdp0 
# ip route add 208.67.222.222 gw dev wlan0
Error: either "to" is duplicate, or "gw" is a garbage.
# ip route add 208.67.222.222 via 192.168.1.1 dev wlan0
RTNETLINK answers: Network is unreachable
# ip route shpw
Command "shpw" is unknown, try "ip route help".
# ip route show
# ping www.google.com
ping: unknown host www.google.com
# luizcarvalho@redrails-note:~$ ^C
luizcarvalho@redrails-note:~$ adb shell
$ su
# ip route show
186.252.131.0/24 dev pdp0  proto kernel  scope link  src 186.252.131.33 
192.168.1.0/24 dev wlan0  proto kernel  scope link  src 192.168.1.102 
default via 186.252.131.1 dev pdp0 
default via 192.168.1.1 dev wlan0 
# 
