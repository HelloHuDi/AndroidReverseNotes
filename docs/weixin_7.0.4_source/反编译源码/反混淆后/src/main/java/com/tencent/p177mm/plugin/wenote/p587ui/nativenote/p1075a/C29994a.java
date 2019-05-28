package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.a.a */
public final class C29994a extends LinearLayoutManager {
    private final int uUe = C40619x.m70071gq(C4996ah.getContext());
    public int uUf = -1;
    public boolean uUg = false;

    public C29994a() {
        AppMethodBeat.m2504i(27140);
        AppMethodBeat.m2505o(27140);
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.m2504i(27141);
        if (this.uUg) {
            int i4 = i < 0 ? C46457k.m87622aU(49.0f) <= ((float) Math.abs(i)) ? 1 : i3 : i3;
            if (i <= 0) {
                i2 = i4;
            } else if (((float) this.uUe) + C46457k.m87622aU(49.0f) >= ((float) i)) {
                i2 = i3;
            }
            if (i2 == 0 || !this.uUg) {
                try {
                    i3 = super.mo1759b(i, c25374o, c31880s);
                    AppMethodBeat.m2505o(27141);
                    return i3;
                } catch (Exception e) {
                    AppMethodBeat.m2505o(27141);
                    return i3;
                }
            }
            AppMethodBeat.m2505o(27141);
            return i3;
        }
        i3 = super.mo1759b(i, c25374o, c31880s);
        AppMethodBeat.m2505o(27141);
        return i3;
    }

    /* renamed from: c */
    public final int mo1764c(C31880s c31880s) {
        if (this.uUf > 0) {
            return this.uUf;
        }
        return TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(27142);
        try {
            super.mo1765c(c25374o, c31880s);
            AppMethodBeat.m2505o(27142);
        } catch (Exception e) {
            AppMethodBeat.m2505o(27142);
        }
    }
}
