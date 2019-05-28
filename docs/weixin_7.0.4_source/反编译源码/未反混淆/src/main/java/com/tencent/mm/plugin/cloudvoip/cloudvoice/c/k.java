package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class k {
    String kBq = null;
    long kBr = -1;
    long kBs = -1;

    k() {
    }

    public final boolean isValid() {
        AppMethodBeat.i(135587);
        if (bo.isNullOrNil(this.kBq) || bo.az(this.kBs + 3600) / 1000 >= this.kBr) {
            AppMethodBeat.o(135587);
            return false;
        }
        AppMethodBeat.o(135587);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(135588);
        String str = "OpenVoiceSessionKey{sessionKey='" + this.kBq + '\'' + ", expireTicks=" + this.kBr + ", initTicks=" + this.kBs + '}';
        AppMethodBeat.o(135588);
        return str;
    }
}
