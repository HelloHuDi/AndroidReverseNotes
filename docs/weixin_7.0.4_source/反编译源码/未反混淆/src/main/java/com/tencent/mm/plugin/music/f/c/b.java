package com.tencent.mm.plugin.music.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b oNX = null;
    private Context ctx;
    private ConcurrentHashMap<Class<? extends a>, a> oNY = new ConcurrentHashMap();

    private b(Context context) {
        AppMethodBeat.i(137662);
        this.ctx = context;
        AppMethodBeat.o(137662);
    }

    public static synchronized void init(Context context) {
        synchronized (b.class) {
            AppMethodBeat.i(137663);
            if (oNX != null) {
                AppMethodBeat.o(137663);
            } else {
                ab.i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                oNX = new b(context);
                AppMethodBeat.o(137663);
            }
        }
    }

    private static b bUJ() {
        AppMethodBeat.i(137664);
        if (oNX == null) {
            init(null);
        }
        b bVar = oNX;
        AppMethodBeat.o(137664);
        return bVar;
    }

    public static synchronized void release() {
        synchronized (b.class) {
            AppMethodBeat.i(137665);
            ab.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            b bVar = oNX;
            bVar.oNY.clear();
            bVar.ctx = null;
            oNX = null;
            AppMethodBeat.o(137665);
        }
    }

    public static void a(Class<? extends a> cls, a aVar) {
        AppMethodBeat.i(137666);
        bUJ().oNY.put(cls, aVar);
        AppMethodBeat.o(137666);
    }

    public static void L(Class<? extends a> cls) {
        AppMethodBeat.i(137667);
        bUJ().oNY.remove(cls);
        AppMethodBeat.o(137667);
    }

    public static <T extends a> T ar(Class<T> cls) {
        AppMethodBeat.i(137668);
        a aVar = (a) bUJ().oNY.get(cls);
        AppMethodBeat.o(137668);
        return aVar;
    }
}
