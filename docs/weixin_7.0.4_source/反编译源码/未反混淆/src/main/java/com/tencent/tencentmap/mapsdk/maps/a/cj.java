package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class cj {
    private static String a = "info.3g.qq.com";

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A:{SYNTHETIC, Splitter:B:20:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(String str, int i, int i2) {
        Throwable th;
        AppMethodBeat.i(98640);
        boolean z = false;
        Socket socket;
        try {
            socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(str, 80), 5000);
                if (socket.isConnected()) {
                    z = true;
                }
                try {
                    socket.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th4) {
                    }
                }
                AppMethodBeat.o(98640);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            socket = null;
            if (socket != null) {
            }
            AppMethodBeat.o(98640);
            throw th;
        }
        AppMethodBeat.o(98640);
        return z;
    }

    public static boolean b() {
        AppMethodBeat.i(98639);
        boolean a = a(a, 80, 5000);
        AppMethodBeat.o(98639);
        return a;
    }

    public static boolean a() {
        AppMethodBeat.i(98638);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = new boolean[]{false};
        a.a.b().execute(new ck(zArr, countDownLatch));
        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        boolean z = zArr[0];
        AppMethodBeat.o(98638);
        return z;
    }
}
