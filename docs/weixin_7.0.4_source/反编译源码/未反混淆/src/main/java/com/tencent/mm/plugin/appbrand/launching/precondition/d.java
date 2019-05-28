package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d extends a {
    private static final Map<String, d> ijP = new ConcurrentHashMap();
    private final WeakReference<Context> atF;
    private final String ijQ;
    private final String ijR;

    static final class a extends ap {
        a(final String str) {
            super(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(132068);
                    d.Cn(str);
                    AppMethodBeat.o(132068);
                    return false;
                }
            }, false);
            AppMethodBeat.i(132069);
            AppMethodBeat.o(132069);
        }
    }

    static {
        AppMethodBeat.i(132073);
        AppMethodBeat.o(132073);
    }

    public static d Cn(String str) {
        AppMethodBeat.i(132070);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(132070);
            return null;
        }
        d dVar = (d) ijP.remove(str);
        AppMethodBeat.o(132070);
        return dVar;
    }

    d(Context context, String str, boolean z) {
        AppMethodBeat.i(132071);
        this.ijQ = str;
        this.ijR = context.getClass().getName();
        this.atF = new WeakReference(context);
        this.ijC = z;
        ijP.put(str, this);
        a aVar = new a(str);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        aVar.ae(toMillis, toMillis);
        AppMethodBeat.o(132071);
    }

    /* Access modifiers changed, original: protected|final */
    public final Context aHM() {
        AppMethodBeat.i(132072);
        Context context = (Context) this.atF.get();
        AppMethodBeat.o(132072);
        return context;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aHK() {
        return this.ijR;
    }
}
