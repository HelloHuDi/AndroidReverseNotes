package com.tencent.p177mm.plugin.card.p355ui.p356v2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.ui.v2.e */
public final class C38775e {
    private static final int kqm;

    static {
        AppMethodBeat.m2504i(89328);
        Context context = C4996ah.getContext();
        C25052j.m39375o(context, "MMApplicationContext.getContext()");
        kqm = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10247vo);
        AppMethodBeat.m2505o(89328);
    }

    public static final int ber() {
        return kqm;
    }
}
