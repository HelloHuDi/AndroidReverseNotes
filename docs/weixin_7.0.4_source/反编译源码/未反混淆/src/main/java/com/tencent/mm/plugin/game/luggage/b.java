package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class b {
    public static long JQ;
    public static Map<String, String> mHeaders;
    public static String mTH;
    public static boolean mTI;

    public static boolean bDp() {
        AppMethodBeat.i(135808);
        if (bo.isNullOrNil(mTH)) {
            ab.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
            AppMethodBeat.o(135808);
            return false;
        } else if (a.bDl() <= 0) {
            AppMethodBeat.o(135808);
            return false;
        } else if ((System.currentTimeMillis() / 1000) - JQ > ((long) a.bDl())) {
            ab.i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
            AppMethodBeat.o(135808);
            return false;
        } else {
            ab.d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
            AppMethodBeat.o(135808);
            return true;
        }
    }
}
