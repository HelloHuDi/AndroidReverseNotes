package com.tencent.p177mm.plugin.music.p460b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.cache.C21343c;
import com.tencent.p177mm.plugin.music.cache.C39432e;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.b.b */
public final class C12656b {
    private static boolean oJr = false;
    private static long oJs = 0;

    public static boolean bSx() {
        AppMethodBeat.m2504i(137261);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z;
        if (currentTimeMillis - oJs < 120000) {
            z = oJr;
            AppMethodBeat.m2505o(137261);
            return z;
        }
        oJs = currentTimeMillis;
        if (C39432e.bTG()) {
            z = ((C21343c) C43329b.m77295ar(C21343c.class)).bTC();
        } else {
            C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            z = false;
        }
        oJr = z;
        C4990ab.m7417i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudio:%b", Boolean.valueOf(oJr));
        if (!oJr) {
            if (C39432e.bTG()) {
                z = ((C21343c) C43329b.m77295ar(C21343c.class)).bTD();
            } else {
                C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                z = false;
            }
            oJr = z;
            C4990ab.m7417i("MicroMsg.Audio.AudioMixSupport", "isSupportMixAudioByCP:%b", Boolean.valueOf(oJr));
        }
        z = oJr;
        AppMethodBeat.m2505o(137261);
        return z;
    }
}
