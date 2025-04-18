# 🔍 Java Port Scanner & Vulnerability Checker

A simple multithreaded **Java port scanner** that allows users to input an IP address and a port range using `EasyIn.get()`. It scans for open ports and flags common services that might be vulnerable.

---

## 🚀 Features

- User input via `EasyIn.get()`
- Custom port range
- Multithreaded scanning for speed
- Basic vulnerability warnings (FTP, Telnet, SMB, RDP, etc.)
- Written in pure Java (no external libraries)

---

## 🖥️ Example Usage

```shell
Enter IP address to scan: test.rebex.net
Enter start port: 20
Enter end port: 100
