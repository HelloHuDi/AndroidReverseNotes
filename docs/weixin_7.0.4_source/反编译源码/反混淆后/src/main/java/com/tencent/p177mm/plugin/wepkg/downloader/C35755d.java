package com.tencent.p177mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.d */
public final class C35755d {
    private static Object lock = new Object();
    private static volatile C35755d uVX;
    HashMap<String, C14800c> uVY = new HashMap();

    static {
        AppMethodBeat.m2504i(63430);
        AppMethodBeat.m2505o(63430);
    }

    public static C35755d dgw() {
        AppMethodBeat.m2504i(63426);
        if (uVX == null) {
            synchronized (lock) {
                try {
                    if (uVX == null) {
                        uVX = new C35755d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63426);
                    }
                }
            }
        }
        C35755d c35755d = uVX;
        AppMethodBeat.m2505o(63426);
        return c35755d;
    }

    private C35755d() {
        AppMethodBeat.m2504i(63427);
        AppMethodBeat.m2505o(63427);
    }

    public final boolean ahO(String str) {
        AppMethodBeat.m2504i(63428);
        if (this.uVY.containsKey(str)) {
            this.uVY.remove(str);
        }
        AppMethodBeat.m2505o(63428);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo56538a(C14800c c14800c) {
        AppMethodBeat.m2504i(63429);
        if (this.uVY.containsKey(c14800c.uVO.uWo)) {
            c14800c.uVU = true;
            try {
                if (c14800c.uVQ != null) {
                    c14800c.uVQ.disconnect();
                }
                if (c14800c.uVP != null) {
                    c14800c.uVP.cancel(false);
                }
            } catch (Exception e) {
                C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e.getMessage());
            }
            this.uVY.remove(c14800c.uVO.uWo);
            AppMethodBeat.m2505o(63429);
            return true;
        }
        AppMethodBeat.m2505o(63429);
        return false;
    }
}
