package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.fts.ui.b */
public final class C45976b {

    /* renamed from: com.tencent.mm.plugin.fts.ui.b$c */
    public static final class C3197c {
        public static final int mHA = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f10016ni);
        public static final TextPaint mHB = new TextPaint();
        public static final int mHu = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9728dt);
        public static final TextPaint mHv = new TextPaint();
        public static final int mHw = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9980m5);
        public static final TextPaint mHx = new TextPaint();
        public static final int mHy = C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9936kr);
        public static final TextPaint mHz = new TextPaint();

        static {
            AppMethodBeat.m2504i(61719);
            mHv.setTextSize((float) mHu);
            mHx.setTextSize((float) mHw);
            mHz.setTextSize((float) mHy);
            mHB.setTextSize((float) mHA);
            AppMethodBeat.m2505o(61719);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.b$a */
    public static class C20875a {
        public static int mHq;

        static {
            AppMethodBeat.m2504i(61717);
            mHq = 0;
            Context context = C4996ah.getContext();
            mHq = ((C1338a.m2868gd(context) - (C1338a.m2856al(context, C25738R.dimen.f9995mv) * 2)) - C1338a.m2856al(context, C25738R.dimen.f9972lw)) - C1338a.m2856al(context, C25738R.dimen.f9995mv);
            AppMethodBeat.m2505o(61717);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.b$b */
    public static final class C28147b {
        public static final int mHr = C4996ah.getContext().getResources().getColor(C25738R.color.a61);
        public static final int mHs = Color.parseColor("#661AAD19");
        public static final int mHt = Color.parseColor("#801AAD19");

        static {
            AppMethodBeat.m2504i(61718);
            AppMethodBeat.m2505o(61718);
        }
    }
}
