package com.tencent.liteav.network.p812a.p813a;

import com.tencent.liteav.network.p812a.C17790b;
import com.tencent.liteav.network.p812a.C17791c;
import com.tencent.liteav.network.p812a.C25662a;
import com.tencent.liteav.network.p812a.C41694d;
import com.tencent.liteav.network.p812a.C45111e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/* renamed from: com.tencent.liteav.network.a.a.c */
public final class C25661c implements C17791c {
    /* renamed from: b */
    private static final Random f5356b = new Random();
    /* renamed from: a */
    final InetAddress f5357a;
    /* renamed from: c */
    private final int f5358c;

    static {
        AppMethodBeat.m2504i(67641);
        AppMethodBeat.m2505o(67641);
    }

    public C25661c(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public C25661c(InetAddress inetAddress, int i) {
        this.f5357a = inetAddress;
        this.f5358c = i;
    }

    /* renamed from: a */
    public final C45111e[] mo19951a(C17790b c17790b, C41694d c41694d) {
        int nextInt;
        AppMethodBeat.m2504i(67639);
        synchronized (f5356b) {
            try {
                nextInt = f5356b.nextInt() & 255;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(67639);
            }
        }
        byte[] a = m40712a(C8830b.m15733a(c17790b.f4209a, nextInt));
        if (a == null) {
            Object c25662a = new C25662a(c17790b.f4209a, "cant get answer");
            throw c25662a;
        }
        C45111e[] a2 = C8830b.m15734a(a, nextInt, c17790b.f4209a);
        AppMethodBeat.m2505o(67639);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private byte[] m40712a(byte[] bArr) {
        Throwable th;
        AppMethodBeat.m2504i(67640);
        DatagramSocket datagramSocket;
        try {
            datagramSocket = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.f5357a, 53);
                datagramSocket.setSoTimeout(this.f5358c * 1000);
                datagramSocket.send(datagramPacket);
                datagramPacket = new DatagramPacket(new byte[1500], 1500);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                datagramSocket.close();
                AppMethodBeat.m2505o(67640);
                return data;
            } catch (Throwable th2) {
                th = th2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                AppMethodBeat.m2505o(67640);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            datagramSocket = null;
            if (datagramSocket != null) {
            }
            AppMethodBeat.m2505o(67640);
            throw th;
        }
    }
}
