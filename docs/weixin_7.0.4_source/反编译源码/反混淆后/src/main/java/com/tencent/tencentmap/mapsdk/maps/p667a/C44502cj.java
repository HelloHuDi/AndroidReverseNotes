package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41037ch.C36490a;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cj */
public final class C44502cj {
    /* renamed from: a */
    private static String f17404a = "info.3g.qq.com";

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A:{SYNTHETIC, Splitter:B:20:0x0035} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m80708a(String str, int i, int i2) {
        Throwable th;
        AppMethodBeat.m2504i(98640);
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
                AppMethodBeat.m2505o(98640);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            socket = null;
            if (socket != null) {
            }
            AppMethodBeat.m2505o(98640);
            throw th;
        }
        AppMethodBeat.m2505o(98640);
        return z;
    }

    /* renamed from: b */
    public static boolean m80709b() {
        AppMethodBeat.m2504i(98639);
        boolean a = C44502cj.m80708a(f17404a, 80, 5000);
        AppMethodBeat.m2505o(98639);
        return a;
    }

    /* renamed from: a */
    public static boolean m80707a() {
        AppMethodBeat.m2504i(98638);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = new boolean[]{false};
        C36490a.f15279a.mo65126b().execute(new C16214ck(zArr, countDownLatch));
        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        boolean z = zArr[0];
        AppMethodBeat.m2505o(98638);
        return z;
    }
}
