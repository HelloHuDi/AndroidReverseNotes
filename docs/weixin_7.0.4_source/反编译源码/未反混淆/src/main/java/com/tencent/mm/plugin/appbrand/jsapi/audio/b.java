package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static volatile al hzV;
    private static String hzW = "app_brand_audio_player";
    private static AtomicInteger hzX = new AtomicInteger(0);
    private static Object lockObj = new Object();
    private static ak mHandler;

    static {
        AppMethodBeat.i(137714);
        AppMethodBeat.o(137714);
    }

    public static void onCreate(String str) {
        AppMethodBeat.i(137710);
        ab.i("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", str);
        if (hzX.incrementAndGet() == 1) {
            synchronized (lockObj) {
                try {
                    aCt();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(137710);
                }
            }
            return;
        }
        AppMethodBeat.o(137710);
    }

    private static void aCt() {
        AppMethodBeat.i(137711);
        if (hzV == null) {
            hzV = new al(hzW);
            g.a(hzW, new h(hzV.oAl.getLooper(), hzW));
        }
        mHandler = new ak(hzV.oAl.getLooper());
        AppMethodBeat.o(137711);
    }

    public static void AO(String str) {
        AppMethodBeat.i(137712);
        ab.i("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", str);
        if (hzX.decrementAndGet() == 0) {
            synchronized (lockObj) {
                try {
                    if (!(hzV == null || hzV == null)) {
                        g.asT(hzW);
                        hzV.oAl.quit();
                        hzV = null;
                        mHandler = null;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(137712);
                }
            }
            return;
        }
        AppMethodBeat.o(137712);
    }

    public static void I(Runnable runnable) {
        AppMethodBeat.i(137713);
        synchronized (lockObj) {
            try {
                if (mHandler != null) {
                    mHandler.post(runnable);
                } else {
                    ab.w("MicroMsg.Audio.AudioApiTaskExecutor", "mHandler is null, recreate");
                    aCt();
                    mHandler.post(runnable);
                }
            } finally {
                AppMethodBeat.o(137713);
            }
        }
    }
}
