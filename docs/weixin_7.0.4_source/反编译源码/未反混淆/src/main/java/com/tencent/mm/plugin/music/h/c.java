package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.e.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static boolean zX(int i) {
        AppMethodBeat.i(137696);
        switch (i) {
            case 10:
            case 11:
                AppMethodBeat.o(137696);
                return true;
            default:
                a aVar = k.bUf().oLX;
                if (aVar == null || !aVar.zF(i)) {
                    AppMethodBeat.o(137696);
                    return false;
                }
                AppMethodBeat.o(137696);
                return true;
        }
    }

    public static boolean L(e eVar) {
        AppMethodBeat.i(137697);
        if (eVar == null) {
            AppMethodBeat.o(137697);
            return false;
        } else if (TextUtils.isEmpty(eVar.protocol)) {
            AppMethodBeat.o(137697);
            return false;
        } else {
            ab.d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", eVar.protocol);
            if ("hls".equalsIgnoreCase(eVar.protocol)) {
                AppMethodBeat.o(137697);
                return true;
            }
            AppMethodBeat.o(137697);
            return false;
        }
    }
}
