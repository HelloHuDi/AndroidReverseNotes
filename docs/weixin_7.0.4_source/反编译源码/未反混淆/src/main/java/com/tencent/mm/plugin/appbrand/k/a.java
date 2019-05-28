package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.btd;
import java.util.Locale;

public final class a {
    public static boolean a(int i, int i2, btd btd) {
        return i == 0 && i2 == 0 && btd != null;
    }

    public static boolean b(com.tencent.mm.ai.a.a<?> aVar) {
        AppMethodBeat.i(132307);
        if (aVar == null || !a(aVar.errType, aVar.errCode, aVar.fsy)) {
            AppMethodBeat.o(132307);
            return false;
        }
        AppMethodBeat.o(132307);
        return true;
    }

    public static String c(com.tencent.mm.ai.a.a aVar) {
        AppMethodBeat.i(132308);
        String str;
        if (aVar == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(132308);
            return str;
        }
        str = String.format(Locale.US, "%d %d %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm});
        AppMethodBeat.o(132308);
        return str;
    }
}
