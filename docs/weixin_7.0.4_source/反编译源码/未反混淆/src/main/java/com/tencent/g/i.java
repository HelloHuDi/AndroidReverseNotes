package com.tencent.g;

import android.content.Context;
import com.tencent.g.b.b;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public final class i {
    private static i AHM;
    private Context Gn;
    private boolean mStarted;

    private static i dSH() {
        AppMethodBeat.i(127762);
        if (AHM == null) {
            synchronized (i.class) {
                try {
                    if (AHM == null) {
                        AHM = new i();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(127762);
                    }
                }
            }
        }
        i iVar = AHM;
        AppMethodBeat.o(127762);
        return iVar;
    }

    public static void dM(Context context) {
        AppMethodBeat.i(127763);
        i dSH = dSH();
        if (!dSH.mStarted) {
            dSH.Gn = context;
            try {
                b a = f.a(new d("EventCenter", com.tencent.g.a.b.class.getName()));
                if (a != null) {
                    a.start();
                }
                AppMethodBeat.o(127763);
                return;
            } catch (Throwable th) {
                c.w("service", th);
            }
        }
        AppMethodBeat.o(127763);
    }
}
