package com.tinkerboots.sdk.p688a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.ttpic.baseutils.BitUtils;
import com.tinkerboots.sdk.p1355b.C31174c;
import com.tinkerboots.sdk.p688a.p1120b.C36621a;
import com.tinkerboots.sdk.p688a.p1579a.C41146b;

/* renamed from: com.tinkerboots.sdk.a.a */
public final class C44597a {
    private static volatile C44597a ATY;
    public C41146b ATX;
    public final C36621a ATZ = C36621a.dWl();
    public long hgu = 10800000;
    public boolean isDebug;

    private C44597a(C41146b c41146b) {
        AppMethodBeat.m2504i(65525);
        this.ATX = c41146b;
        AppMethodBeat.m2505o(65525);
    }

    /* renamed from: a */
    public static C44597a m81008a(C41146b c41146b) {
        AppMethodBeat.m2504i(65526);
        if (ATY != null) {
            RuntimeException runtimeException = new RuntimeException("tinker server client is already init");
            AppMethodBeat.m2505o(65526);
            throw runtimeException;
        }
        if (ATY == null) {
            synchronized (C36621a.class) {
                try {
                    if (ATY == null) {
                        ATY = new C44597a(c41146b);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(65526);
                    }
                }
            }
        }
        C44597a c44597a = ATY;
        AppMethodBeat.m2505o(65526);
        return c44597a;
    }

    /* renamed from: iO */
    public final void mo71469iO(String str, String str2) {
        AppMethodBeat.m2504i(BitUtils.BIT_TURN_ZERO_4);
        this.ATZ.mo58436iP(str, str2);
        AppMethodBeat.m2505o(BitUtils.BIT_TURN_ZERO_4);
    }

    /* renamed from: SH */
    public final void mo71468SH(int i) {
        AppMethodBeat.m2504i(65528);
        if (((long) i) == -1) {
            C44597a.dWk();
            AppMethodBeat.m2505o(65528);
        } else if (i < 0 || i > 24) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("hours must be between 0 and 24");
            AppMethodBeat.m2505o(65528);
            throw tinkerRuntimeException;
        } else {
            this.hgu = (((long) i) * 3600) * 1000;
            AppMethodBeat.m2505o(65528);
        }
    }

    private static boolean dWk() {
        AppMethodBeat.m2504i(65529);
        C5952a.m9284i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
        boolean commit = C31174c.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        AppMethodBeat.m2505o(65529);
        return commit;
    }
}
