package com.tencent.p177mm.plugin.music.p997h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p462e.C46096a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.h.c */
public final class C34585c {
    /* renamed from: zX */
    public static boolean m56720zX(int i) {
        AppMethodBeat.m2504i(137696);
        switch (i) {
            case 10:
            case 11:
                AppMethodBeat.m2505o(137696);
                return true;
            default:
                C46096a c46096a = C39435k.bUf().oLX;
                if (c46096a == null || !c46096a.mo46669zF(i)) {
                    AppMethodBeat.m2505o(137696);
                    return false;
                }
                AppMethodBeat.m2505o(137696);
                return true;
        }
    }

    /* renamed from: L */
    public static boolean m56719L(C9058e c9058e) {
        AppMethodBeat.m2504i(137697);
        if (c9058e == null) {
            AppMethodBeat.m2505o(137697);
            return false;
        } else if (TextUtils.isEmpty(c9058e.protocol)) {
            AppMethodBeat.m2505o(137697);
            return false;
        } else {
            C4990ab.m7411d("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", c9058e.protocol);
            if ("hls".equalsIgnoreCase(c9058e.protocol)) {
                AppMethodBeat.m2505o(137697);
                return true;
            }
            AppMethodBeat.m2505o(137697);
            return false;
        }
    }
}
