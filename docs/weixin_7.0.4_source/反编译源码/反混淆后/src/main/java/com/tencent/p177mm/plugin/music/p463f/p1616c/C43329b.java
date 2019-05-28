package com.tencent.p177mm.plugin.music.p463f.p1616c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.music.f.c.b */
public final class C43329b {
    private static C43329b oNX = null;
    private Context ctx;
    private ConcurrentHashMap<Class<? extends C43328a>, C43328a> oNY = new ConcurrentHashMap();

    private C43329b(Context context) {
        AppMethodBeat.m2504i(137662);
        this.ctx = context;
        AppMethodBeat.m2505o(137662);
    }

    public static synchronized void init(Context context) {
        synchronized (C43329b.class) {
            AppMethodBeat.m2504i(137663);
            if (oNX != null) {
                AppMethodBeat.m2505o(137663);
            } else {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                oNX = new C43329b(context);
                AppMethodBeat.m2505o(137663);
            }
        }
    }

    private static C43329b bUJ() {
        AppMethodBeat.m2504i(137664);
        if (oNX == null) {
            C43329b.init(null);
        }
        C43329b c43329b = oNX;
        AppMethodBeat.m2505o(137664);
        return c43329b;
    }

    public static synchronized void release() {
        synchronized (C43329b.class) {
            AppMethodBeat.m2504i(137665);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            C43329b c43329b = oNX;
            c43329b.oNY.clear();
            c43329b.ctx = null;
            oNX = null;
            AppMethodBeat.m2505o(137665);
        }
    }

    /* renamed from: a */
    public static void m77294a(Class<? extends C43328a> cls, C43328a c43328a) {
        AppMethodBeat.m2504i(137666);
        C43329b.bUJ().oNY.put(cls, c43328a);
        AppMethodBeat.m2505o(137666);
    }

    /* renamed from: L */
    public static void m77293L(Class<? extends C43328a> cls) {
        AppMethodBeat.m2504i(137667);
        C43329b.bUJ().oNY.remove(cls);
        AppMethodBeat.m2505o(137667);
    }

    /* renamed from: ar */
    public static <T extends C43328a> T m77295ar(Class<T> cls) {
        AppMethodBeat.m2504i(137668);
        C43328a c43328a = (C43328a) C43329b.bUJ().oNY.get(cls);
        AppMethodBeat.m2505o(137668);
        return c43328a;
    }
}
