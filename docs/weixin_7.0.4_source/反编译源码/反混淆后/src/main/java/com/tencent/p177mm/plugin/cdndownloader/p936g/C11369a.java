package com.tencent.p177mm.plugin.cdndownloader.p936g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7369h;

/* renamed from: com.tencent.mm.plugin.cdndownloader.g.a */
public final class C11369a {
    private static volatile C5004al ftB;
    private static final Object iRa = new Object();

    static {
        AppMethodBeat.m2504i(965);
        AppMethodBeat.m2505o(965);
    }

    public static C5004al aNS() {
        AppMethodBeat.m2504i(964);
        if (ftB == null) {
            synchronized (iRa) {
                try {
                    if (ftB == null) {
                        ftB = new C5004al("CDNDownloader#WorkThread");
                        C5707g.m8573a("CDNDownloader#WorkThread", new C7369h(ftB.oAl.getLooper(), "CDNDownloader#WorkThread"));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(964);
                    }
                }
            }
        }
        C5004al c5004al = ftB;
        AppMethodBeat.m2505o(964);
        return c5004al;
    }
}
