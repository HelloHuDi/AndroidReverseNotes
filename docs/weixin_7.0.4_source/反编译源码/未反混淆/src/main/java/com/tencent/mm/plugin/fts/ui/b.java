package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {

    public static final class c {
        public static final int mHA = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.ni);
        public static final TextPaint mHB = new TextPaint();
        public static final int mHu = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.dt);
        public static final TextPaint mHv = new TextPaint();
        public static final int mHw = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.m5);
        public static final TextPaint mHx = new TextPaint();
        public static final int mHy = com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.kr);
        public static final TextPaint mHz = new TextPaint();

        static {
            AppMethodBeat.i(61719);
            mHv.setTextSize((float) mHu);
            mHx.setTextSize((float) mHw);
            mHz.setTextSize((float) mHy);
            mHB.setTextSize((float) mHA);
            AppMethodBeat.o(61719);
        }
    }

    public static class a {
        public static int mHq;

        static {
            AppMethodBeat.i(61717);
            mHq = 0;
            Context context = ah.getContext();
            mHq = ((com.tencent.mm.bz.a.gd(context) - (com.tencent.mm.bz.a.al(context, R.dimen.mv) * 2)) - com.tencent.mm.bz.a.al(context, R.dimen.lw)) - com.tencent.mm.bz.a.al(context, R.dimen.mv);
            AppMethodBeat.o(61717);
        }
    }

    public static final class b {
        public static final int mHr = ah.getContext().getResources().getColor(R.color.a61);
        public static final int mHs = Color.parseColor("#661AAD19");
        public static final int mHt = Color.parseColor("#801AAD19");

        static {
            AppMethodBeat.i(61718);
            AppMethodBeat.o(61718);
        }
    }
}
