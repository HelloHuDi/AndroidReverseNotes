package com.tencent.mm.plugin.music.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ag;

public final class e {
    public static String bSy() {
        AppMethodBeat.i(137265);
        String stringBuilder = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ag.ck(System.nanoTime())).toString();
        AppMethodBeat.o(137265);
        return stringBuilder;
    }
}
