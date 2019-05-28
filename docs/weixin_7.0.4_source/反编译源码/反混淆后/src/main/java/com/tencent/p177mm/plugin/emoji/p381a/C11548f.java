package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C27727e;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.a.f */
public class C11548f extends C33944a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean kSk = false;
    public boolean kSl = true;
    public boolean kSm = false;
    public boolean kSn = true;

    /* renamed from: com.tencent.mm.plugin.emoji.a.f$a */
    public class C11549a extends C45843a {
        public C11549a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.m2504i(52743);
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
            AppMethodBeat.m2505o(52743);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bjp() {
            AppMethodBeat.m2504i(52746);
            boolean a = C11548f.this.kSl;
            AppMethodBeat.m2505o(52746);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] bjf() {
            AppMethodBeat.m2504i(52744);
            int al = C1338a.m2856al(this.mContext, C25738R.dimen.a0z);
            int[] iArr = new int[]{al, al};
            AppMethodBeat.m2505o(52744);
            return iArr;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bjg() {
            AppMethodBeat.m2504i(52745);
            int al = C1338a.m2856al(this.mContext, C25738R.dimen.a0y);
            AppMethodBeat.m2505o(52745);
            return al;
        }
    }

    public C11548f(Context context) {
        super(context);
    }

    /* renamed from: d */
    public final C45843a mo7110d(Context context, View view) {
        AppMethodBeat.m2504i(52747);
        C11549a c11549a = new C11549a(context, view);
        c11549a.mo73648a(this.kSQ);
        AppMethodBeat.m2505o(52747);
        return c11549a;
    }

    public final void clear() {
        AppMethodBeat.m2504i(52748);
        super.clear();
        AppMethodBeat.m2505o(52748);
    }

    /* renamed from: b */
    public View mo7106b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        AppMethodBeat.m2504i(52749);
        C11549a c11549a = (C11549a) view.getTag();
        C11546f tX = getItem(i);
        if (this.kSm) {
            tX.kTh = true;
            tX.kTf = false;
            tX.kTg = false;
        }
        if (!(c11549a == null || tX == null)) {
            tX.kTg = this.kSn;
            EmotionBannerSet emotionBannerSet = tX.kTc;
            if (emotionBannerSet == null) {
                c11549a.mo73663tT(0);
                z = false;
            } else {
                c11549a.setTitle(emotionBannerSet.Title);
                c11549a.mo73647IR(emotionBannerSet.Desc);
                if (!C5046bo.isNullOrNil(emotionBannerSet.IconUrl)) {
                    C32291o.ahp().mo43766a(emotionBannerSet.IconUrl, c11549a.bji(), C20364g.m31459dH("", emotionBannerSet.IconUrl));
                }
                if (C5046bo.isNullOrNil(emotionBannerSet.TagUrl)) {
                    c11549a.mo73662tS(8);
                } else {
                    C32291o.ahp().mo43766a(emotionBannerSet.TagUrl, c11549a.bjk(), C20364g.m31459dH("", emotionBannerSet.TagUrl));
                    c11549a.mo73662tS(0);
                }
                c11549a.mo73663tT(8);
            }
            if (!z) {
                EmotionSummary emotionSummary = tX.kTb;
                if (emotionSummary != null) {
                    c11549a.setTitle(emotionSummary.PackName);
                    if (C2932a.m5218g(emotionSummary)) {
                        C32291o.ahp().mo43765a("", c11549a.bji());
                        c11549a.bjj();
                    } else {
                        C32291o.ahp().mo43766a(emotionSummary.IconUrl, c11549a.bji(), C20364g.m31459dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                    }
                    boolean dR = C27727e.m44040dR(emotionSummary.PackType, 2);
                    if (!TextUtils.isEmpty(emotionSummary.TagUri)) {
                        c11549a.bjk().setImageDrawable(null);
                        c11549a.bjk().setVisibility(0);
                        C32291o.ahp().mo43766a(emotionSummary.TagUri, c11549a.bjk(), C20364g.m31459dH("", emotionSummary.TagUri));
                    } else if (dR) {
                        c11549a.mo73662tS(0);
                        c11549a.bjl();
                    } else {
                        c11549a.mo73662tS(8);
                    }
                    c11549a.mo73647IR(bjA() ? emotionSummary.ExptDesc : emotionSummary.Introduce);
                    if (this.kSk && c11549a.kRC != null) {
                        c11549a.kRC.setBackgroundResource(C25738R.drawable.f6625k7);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52749);
        return view;
    }

    public int bjw() {
        return 0;
    }

    /* renamed from: tU */
    public void mo7111tU(int i) {
    }

    public int bjx() {
        return 0;
    }

    /* renamed from: tV */
    public void mo7112tV(int i) {
    }

    public int bjy() {
        return 0;
    }

    /* renamed from: tW */
    public void mo7113tW(int i) {
    }

    /* Access modifiers changed, original: protected */
    public boolean bjA() {
        return false;
    }
}
