package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.d */
public final class C42613d extends C45640a {
    private static final Map<String, C42613d> ijP = new ConcurrentHashMap();
    private final WeakReference<Context> atF;
    private final String ijQ;
    private final String ijR;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.d$a */
    static final class C19582a extends C7564ap {
        C19582a(final String str) {
            super(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(132068);
                    C42613d.m75451Cn(str);
                    AppMethodBeat.m2505o(132068);
                    return false;
                }
            }, false);
            AppMethodBeat.m2504i(132069);
            AppMethodBeat.m2505o(132069);
        }
    }

    static {
        AppMethodBeat.m2504i(132073);
        AppMethodBeat.m2505o(132073);
    }

    /* renamed from: Cn */
    public static C42613d m75451Cn(String str) {
        AppMethodBeat.m2504i(132070);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132070);
            return null;
        }
        C42613d c42613d = (C42613d) ijP.remove(str);
        AppMethodBeat.m2505o(132070);
        return c42613d;
    }

    C42613d(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(132071);
        this.ijQ = str;
        this.ijR = context.getClass().getName();
        this.atF = new WeakReference(context);
        this.ijC = z;
        ijP.put(str, this);
        C19582a c19582a = new C19582a(str);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        c19582a.mo16770ae(toMillis, toMillis);
        AppMethodBeat.m2505o(132071);
    }

    /* Access modifiers changed, original: protected|final */
    public final Context aHM() {
        AppMethodBeat.m2504i(132072);
        Context context = (Context) this.atF.get();
        AppMethodBeat.m2505o(132072);
        return context;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aHK() {
        return this.ijR;
    }
}
