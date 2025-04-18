import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortScanner
{

    public static void main(String[] args)
    {
        System.out.print("Enter IP address to scan: ");
        String ip = EasyIn.getString();

        System.out.print("Enter start port: ");
        int startPort = Integer.parseInt(EasyIn.getString());

        System.out.print("Enter end port: ");
        int endPort = Integer.parseInt(EasyIn.getString());

        int threadCount = 100; // Number of threads
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int port = startPort; port <= endPort; port++)
            {
                final int currentPort = port;
                executor.submit(() -> scanPort(ip, currentPort));
            }

        executor.shutdown();
    }

    private static void scanPort(String ip, int port)
    {
        try (Socket socket = new Socket())
            {
                socket.connect(new InetSocketAddress(ip, port), 200);
                System.out.println("Port " + port + " is OPEN");
                checkVulnerability(port);
            }
        catch (IOException ignored)
            {
                // Port is closed or unreachable
            }
    }

    private static void checkVulnerability(int port)
    {
        switch (port)
            {
                case 21:
                    System.out.println("  -> [!] FTP port open - potential anonymous login.");
                    break;
                case 23:
                    System.out.println("  -> [!] Telnet open - insecure and outdated.");
                    break;
                case 445:
                    System.out.println("  -> [!] SMB open - often targeted by malware.");
                    break;
                case 3389:
                    System.out.println("  -> [!] RDP open - high risk of brute-force.");
                    break;
                default:
                    break;
            }
    }
}
