package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.k */
final class C11413k {
    String kBq = null;
    long kBr = -1;
    long kBs = -1;

    C11413k() {
    }

    public final boolean isValid() {
        AppMethodBeat.m2504i(135587);
        if (C5046bo.isNullOrNil(this.kBq) || C5046bo.m7525az(this.kBs + 3600) / 1000 >= this.kBr) {
            AppMethodBeat.m2505o(135587);
            return false;
        }
        AppMethodBeat.m2505o(135587);
        return true;
    }

    public final String toString() {
        AppMethodBeat.m2504i(135588);
        String str = "OpenVoiceSessionKey{sessionKey='" + this.kBq + '\'' + ", expireTicks=" + this.kBr + ", initTicks=" + this.kBs + '}';
        AppMethodBeat.m2505o(135588);
        return str;
    }
}
