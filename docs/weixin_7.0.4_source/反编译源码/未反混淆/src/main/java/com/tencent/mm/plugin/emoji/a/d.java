package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d extends com.tencent.mm.plugin.emoji.a.a.a {

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.i(52734);
            this.kRE.setVisibility(8);
            this.kRG.setVisibility(8);
            this.kRF.setVisibility(0);
            this.kRH.setVisibility(8);
            this.kRL.setVisibility(8);
            this.kRM.setVisibility(8);
            this.kRD.setVisibility(0);
            this.iDT.setVisibility(0);
            this.kRJ.setVisibility(0);
            this.kRI.setVisibility(0);
            this.kRI.setBackgroundDrawable(null);
            this.kRK.setVisibility(0);
            AppMethodBeat.o(52734);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bjp() {
            return true;
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] bjf() {
            AppMethodBeat.i(52735);
            int al = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a13);
            int[] iArr = new int[]{al, al};
            AppMethodBeat.o(52735);
            return iArr;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bjg() {
            AppMethodBeat.i(52736);
            int al = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a14);
            AppMethodBeat.o(52736);
            return al;
        }
    }

    public d(Context context) {
        super(context);
    }

    public final a d(Context context, View view) {
        AppMethodBeat.i(52737);
        a aVar = new a(context, view);
        aVar.a(this.kSQ);
        AppMethodBeat.o(52737);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(52738);
        a aVar = (a) view.getTag();
        f tX = getItem(i);
        if (!(aVar == null || tX == null)) {
            tX.kTf = false;
            tX.kTg = false;
            EmotionSummary emotionSummary = tX.kTb;
            if (emotionSummary != null) {
                aVar.setTitle(emotionSummary.PackName);
                o.ahp().a(emotionSummary.IconUrl, aVar.bji(), g.dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                aVar.IQ(h.aJ("yyyy-MM-dd", ((long) emotionSummary.Timestamp) * 1000));
            }
        }
        AppMethodBeat.o(52738);
        return view;
    }

    public final int bjw() {
        return 0;
    }

    public final void tU(int i) {
    }

    public final int bjx() {
        return 0;
    }

    public final void tV(int i) {
    }

    public final int bjy() {
        return 0;
    }

    public final void tW(int i) {
    }
}
