package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

public final class a extends LinearLayoutManager {
    private final int uUe = x.gq(ah.getContext());
    public int uUf = -1;
    public boolean uUg = false;

    public a() {
        AppMethodBeat.i(27140);
        AppMethodBeat.o(27140);
    }

    public final int b(int i, o oVar, s sVar) {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(27141);
        if (this.uUg) {
            int i4 = i < 0 ? k.aU(49.0f) <= ((float) Math.abs(i)) ? 1 : i3 : i3;
            if (i <= 0) {
                i2 = i4;
            } else if (((float) this.uUe) + k.aU(49.0f) >= ((float) i)) {
                i2 = i3;
            }
            if (i2 == 0 || !this.uUg) {
                try {
                    i3 = super.b(i, oVar, sVar);
                    AppMethodBeat.o(27141);
                    return i3;
                } catch (Exception e) {
                    AppMethodBeat.o(27141);
                    return i3;
                }
            }
            AppMethodBeat.o(27141);
            return i3;
        }
        i3 = super.b(i, oVar, sVar);
        AppMethodBeat.o(27141);
        return i3;
    }

    public final int c(s sVar) {
        if (this.uUf > 0) {
            return this.uUf;
        }
        return TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
    }

    public final void c(o oVar, s sVar) {
        AppMethodBeat.i(27142);
        try {
            super.c(oVar, sVar);
            AppMethodBeat.o(27142);
        } catch (Exception e) {
            AppMethodBeat.o(27142);
        }
    }
}
