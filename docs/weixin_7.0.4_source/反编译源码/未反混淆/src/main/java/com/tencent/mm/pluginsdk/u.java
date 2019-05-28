package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class u {
    private static boolean vaB = false;
    public String mTag = "";
    public boolean vaA = false;

    public u(String str) {
        this.mTag = str;
    }

    public static void dgS() {
        vaB = true;
    }

    public final boolean cM(String str) {
        AppMethodBeat.i(105838);
        if (vaB) {
            ab.i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            AppMethodBeat.o(105838);
            return false;
        } else if (this.vaA) {
            ab.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            AppMethodBeat.o(105838);
            return true;
        } else {
            AppMethodBeat.o(105838);
            return false;
        }
    }
}
