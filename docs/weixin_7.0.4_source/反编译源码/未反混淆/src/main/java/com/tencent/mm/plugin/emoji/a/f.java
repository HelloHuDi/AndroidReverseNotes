package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bo;

public class f extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean kSk = false;
    public boolean kSl = true;
    public boolean kSm = false;
    public boolean kSn = true;

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.i(52743);
            this.kRE.setVisibility(8);
            bjm();
            this.kRH.setVisibility(8);
            this.kRL.setVisibility(8);
            this.kRM.setVisibility(8);
            this.kRD.setVisibility(0);
            this.iDT.setVisibility(0);
            this.kRJ.setVisibility(0);
            this.kRI.setVisibility(0);
            this.kRK.setVisibility(0);
            AppMethodBeat.o(52743);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bjp() {
            AppMethodBeat.i(52746);
            boolean a = f.this.kSl;
            AppMethodBeat.o(52746);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] bjf() {
            AppMethodBeat.i(52744);
            int al = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a0z);
            int[] iArr = new int[]{al, al};
            AppMethodBeat.o(52744);
            return iArr;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bjg() {
            AppMethodBeat.i(52745);
            int al = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a0y);
            AppMethodBeat.o(52745);
            return al;
        }
    }

    public f(Context context) {
        super(context);
    }

    public final a d(Context context, View view) {
        AppMethodBeat.i(52747);
        a aVar = new a(context, view);
        aVar.a(this.kSQ);
        AppMethodBeat.o(52747);
        return aVar;
    }

    public final void clear() {
        AppMethodBeat.i(52748);
        super.clear();
        AppMethodBeat.o(52748);
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        AppMethodBeat.i(52749);
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f tX = getItem(i);
        if (this.kSm) {
            tX.kTh = true;
            tX.kTf = false;
            tX.kTg = false;
        }
        if (!(aVar == null || tX == null)) {
            tX.kTg = this.kSn;
            EmotionBannerSet emotionBannerSet = tX.kTc;
            if (emotionBannerSet == null) {
                aVar.tT(0);
                z = false;
            } else {
                aVar.setTitle(emotionBannerSet.Title);
                aVar.IR(emotionBannerSet.Desc);
                if (!bo.isNullOrNil(emotionBannerSet.IconUrl)) {
                    o.ahp().a(emotionBannerSet.IconUrl, aVar.bji(), g.dH("", emotionBannerSet.IconUrl));
                }
                if (bo.isNullOrNil(emotionBannerSet.TagUrl)) {
                    aVar.tS(8);
                } else {
                    o.ahp().a(emotionBannerSet.TagUrl, aVar.bjk(), g.dH("", emotionBannerSet.TagUrl));
                    aVar.tS(0);
                }
                aVar.tT(8);
            }
            if (!z) {
                EmotionSummary emotionSummary = tX.kTb;
                if (emotionSummary != null) {
                    aVar.setTitle(emotionSummary.PackName);
                    if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                        o.ahp().a("", aVar.bji());
                        aVar.bjj();
                    } else {
                        o.ahp().a(emotionSummary.IconUrl, aVar.bji(), g.dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                    }
                    boolean dR = e.dR(emotionSummary.PackType, 2);
                    if (!TextUtils.isEmpty(emotionSummary.TagUri)) {
                        aVar.bjk().setImageDrawable(null);
                        aVar.bjk().setVisibility(0);
                        o.ahp().a(emotionSummary.TagUri, aVar.bjk(), g.dH("", emotionSummary.TagUri));
                    } else if (dR) {
                        aVar.tS(0);
                        aVar.bjl();
                    } else {
                        aVar.tS(8);
                    }
                    aVar.IR(bjA() ? emotionSummary.ExptDesc : emotionSummary.Introduce);
                    if (this.kSk && aVar.kRC != null) {
                        aVar.kRC.setBackgroundResource(R.drawable.k7);
                    }
                }
            }
        }
        AppMethodBeat.o(52749);
        return view;
    }

    public int bjw() {
        return 0;
    }

    public void tU(int i) {
    }

    public int bjx() {
        return 0;
    }

    public void tV(int i) {
    }

    public int bjy() {
        return 0;
    }

    public void tW(int i) {
    }

    /* Access modifiers changed, original: protected */
    public boolean bjA() {
        return false;
    }
}
