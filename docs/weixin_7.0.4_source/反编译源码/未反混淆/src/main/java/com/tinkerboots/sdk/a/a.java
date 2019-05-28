package com.tinkerboots.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tinkerboots.sdk.a.a.b;
import com.tinkerboots.sdk.b.c;

public final class a {
    private static volatile a ATY;
    public b ATX;
    public final com.tinkerboots.sdk.a.b.a ATZ = com.tinkerboots.sdk.a.b.a.dWl();
    public long hgu = 10800000;
    public boolean isDebug;

    private a(b bVar) {
        AppMethodBeat.i(65525);
        this.ATX = bVar;
        AppMethodBeat.o(65525);
    }

    public static a a(b bVar) {
        AppMethodBeat.i(65526);
        if (ATY != null) {
            RuntimeException runtimeException = new RuntimeException("tinker server client is already init");
            AppMethodBeat.o(65526);
            throw runtimeException;
        }
        if (ATY == null) {
            synchronized (com.tinkerboots.sdk.a.b.a.class) {
                try {
                    if (ATY == null) {
                        ATY = new a(bVar);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65526);
                    }
                }
            }
        }
        a aVar = ATY;
        AppMethodBeat.o(65526);
        return aVar;
    }

    public final void iO(String str, String str2) {
        AppMethodBeat.i(BitUtils.BIT_TURN_ZERO_4);
        this.ATZ.iP(str, str2);
        AppMethodBeat.o(BitUtils.BIT_TURN_ZERO_4);
    }

    public final void SH(int i) {
        AppMethodBeat.i(65528);
        if (((long) i) == -1) {
            dWk();
            AppMethodBeat.o(65528);
        } else if (i < 0 || i > 24) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("hours must be between 0 and 24");
            AppMethodBeat.o(65528);
            throw tinkerRuntimeException;
        } else {
            this.hgu = (((long) i) * 3600) * 1000;
            AppMethodBeat.o(65528);
        }
    }

    private static boolean dWk() {
        AppMethodBeat.i(65529);
        com.tencent.tinker.lib.util.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
        boolean commit = c.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        AppMethodBeat.o(65529);
        return commit;
    }
}
