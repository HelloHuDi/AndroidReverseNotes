package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    private static boolean oJr = false;
    private static long oJs = 0;

    public static boolean bSx() {
        AppMethodBeat.i(137261);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z;
        if (currentTimeMillis - oJs < 120000) {
            z = oJr;
            AppMethodBeat.o(137261);
            return z;
        }
        oJs = currentTimeMillis;
        if (e.bTG()) {
            z = ((c) com.tencent.mm.plugin.music.f.c.b.ar(c.class)).bTC();
        } else {
            ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            z = false;
        }
        oJr = z;
        ab.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", Boolean.valueOf(oJr));
        if (!oJr) {
            if (e.bTG()) {
                z = ((c) com.tencent.mm.plugin.music.f.c.b.ar(c.class)).bTD();
            } else {
                ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                z = false;
            }
            oJr = z;
            ab.i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", Boolean.valueOf(oJr));
        }
        z = oJr;
        AppMethodBeat.o(137261);
        return z;
    }
}
