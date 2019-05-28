package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;

/* renamed from: com.tencent.mm.plugin.emoji.a.d */
public final class C2927d extends C33944a {

    /* renamed from: com.tencent.mm.plugin.emoji.a.d$a */
    public class C2928a extends C45843a {
        public C2928a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.m2504i(52734);
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
            AppMethodBeat.m2505o(52734);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bjp() {
            return true;
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] bjf() {
            AppMethodBeat.m2504i(52735);
            int al = C1338a.m2856al(this.mContext, C25738R.dimen.a13);
            int[] iArr = new int[]{al, al};
            AppMethodBeat.m2505o(52735);
            return iArr;
        }

        /* Access modifiers changed, original: protected|final */
        public final int bjg() {
            AppMethodBeat.m2504i(52736);
            int al = C1338a.m2856al(this.mContext, C25738R.dimen.a14);
            AppMethodBeat.m2505o(52736);
            return al;
        }
    }

    public C2927d(Context context) {
        super(context);
    }

    /* renamed from: d */
    public final C45843a mo7110d(Context context, View view) {
        AppMethodBeat.m2504i(52737);
        C2928a c2928a = new C2928a(context, view);
        c2928a.mo73648a(this.kSQ);
        AppMethodBeat.m2505o(52737);
        return c2928a;
    }

    /* renamed from: b */
    public final View mo7106b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(52738);
        C2928a c2928a = (C2928a) view.getTag();
        C11546f tX = getItem(i);
        if (!(c2928a == null || tX == null)) {
            tX.kTf = false;
            tX.kTg = false;
            EmotionSummary emotionSummary = tX.kTb;
            if (emotionSummary != null) {
                c2928a.setTitle(emotionSummary.PackName);
                C32291o.ahp().mo43766a(emotionSummary.IconUrl, c2928a.bji(), C20364g.m31459dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                c2928a.mo73646IQ(C14835h.m23085aJ("yyyy-MM-dd", ((long) emotionSummary.Timestamp) * 1000));
            }
        }
        AppMethodBeat.m2505o(52738);
        return view;
    }

    public final int bjw() {
        return 0;
    }

    /* renamed from: tU */
    public final void mo7111tU(int i) {
    }

    public final int bjx() {
        return 0;
    }

    /* renamed from: tV */
    public final void mo7112tV(int i) {
    }

    public final int bjy() {
        return 0;
    }

    /* renamed from: tW */
    public final void mo7113tW(int i) {
    }
}
