package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p642h.C5707g;
import com.tencent.p177mm.vending.p642h.C7369h;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.b */
public final class C10304b {
    private static volatile C5004al hzV;
    private static String hzW = "app_brand_audio_player";
    private static AtomicInteger hzX = new AtomicInteger(0);
    private static Object lockObj = new Object();
    private static C7306ak mHandler;

    static {
        AppMethodBeat.m2504i(137714);
        AppMethodBeat.m2505o(137714);
    }

    public static void onCreate(String str) {
        AppMethodBeat.m2504i(137710);
        C4990ab.m7417i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", str);
        if (hzX.incrementAndGet() == 1) {
            synchronized (lockObj) {
                try {
                    C10304b.aCt();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137710);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(137710);
    }

    private static void aCt() {
        AppMethodBeat.m2504i(137711);
        if (hzV == null) {
            hzV = new C5004al(hzW);
            C5707g.m8573a(hzW, new C7369h(hzV.oAl.getLooper(), hzW));
        }
        mHandler = new C7306ak(hzV.oAl.getLooper());
        AppMethodBeat.m2505o(137711);
    }

    /* renamed from: AO */
    public static void m17969AO(String str) {
        AppMethodBeat.m2504i(137712);
        C4990ab.m7417i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", str);
        if (hzX.decrementAndGet() == 0) {
            synchronized (lockObj) {
                try {
                    if (!(hzV == null || hzV == null)) {
                        C5707g.asT(hzW);
                        hzV.oAl.quit();
                        hzV = null;
                        mHandler = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137712);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(137712);
    }

    /* renamed from: I */
    public static void m17970I(Runnable runnable) {
        AppMethodBeat.m2504i(137713);
        synchronized (lockObj) {
            try {
                if (mHandler != null) {
                    mHandler.post(runnable);
                } else {
                    C4990ab.m7420w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
                    C10304b.aCt();
                    mHandler.post(runnable);
                }
            } finally {
                AppMethodBeat.m2505o(137713);
            }
        }
    }
}
