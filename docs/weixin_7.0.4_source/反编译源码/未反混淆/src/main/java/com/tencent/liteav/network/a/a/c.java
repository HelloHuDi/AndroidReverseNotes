package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public final class c implements com.tencent.liteav.network.a.c {
    private static final Random b = new Random();
    final InetAddress a;
    private final int c;

    static {
        AppMethodBeat.i(67641);
        AppMethodBeat.o(67641);
    }

    public c(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public c(InetAddress inetAddress, int i) {
        this.a = inetAddress;
        this.c = i;
    }

    public final e[] a(b bVar, d dVar) {
        int nextInt;
        AppMethodBeat.i(67639);
        synchronized (b) {
            try {
                nextInt = b.nextInt() & 255;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(67639);
            }
        }
        byte[] a = a(b.a(bVar.a, nextInt));
        if (a == null) {
            Object aVar = new a(bVar.a, "cant get answer");
            throw aVar;
        }
        e[] a2 = b.a(a, nextInt, bVar.a);
        AppMethodBeat.o(67639);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(byte[] bArr) {
        Throwable th;
        AppMethodBeat.i(67640);
        DatagramSocket datagramSocket;
        try {
            datagramSocket = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.a, 53);
                datagramSocket.setSoTimeout(this.c * 1000);
                datagramSocket.send(datagramPacket);
                datagramPacket = new DatagramPacket(new byte[1500], 1500);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                datagramSocket.close();
                AppMethodBeat.o(67640);
                return data;
            } catch (Throwable th2) {
                th = th2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                AppMethodBeat.o(67640);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            datagramSocket = null;
            if (datagramSocket != null) {
            }
            AppMethodBeat.o(67640);
            throw th;
        }
    }
}
