package com.tencent.p177mm.plugin.emoji.p381a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.p230g.p231a.C18232da.C18231a;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42951i.C11558a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C33944a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C38870d;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C45842c;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.a.c */
public final class C36759c extends C33944a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog gqo;

    /* renamed from: com.tencent.mm.plugin.emoji.a.c$a */
    public class C36760a extends C45843a {
        public C36760a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.m2504i(52722);
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
            AppMethodBeat.m2505o(52722);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final boolean mo58600a(C11558a c11558a, View view) {
            AppMethodBeat.m2504i(52723);
            bjn();
            boolean a = super.mo58600a(c11558a, view);
            AppMethodBeat.m2505o(52723);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final void mo58601b(C11558a c11558a, View view) {
            AppMethodBeat.m2504i(52724);
            super.mo58601b(c11558a, view);
            if (C2932a.m5216JW(getProductId())) {
                int i;
                C18232da c18232da = new C18232da();
                c18232da.cwf.cwg = getProductId();
                C18231a c18231a = c18232da.cwf;
                if (C2932a.blE()) {
                    i = 7;
                } else {
                    i = 3;
                }
                c18231a.status = i;
                c18232da.cwf.progress = getProgress();
                c18232da.cwf.cwh = this.kRB.kTe;
                C4879a.xxA.mo10055m(c18232da);
            }
            AppMethodBeat.m2505o(52724);
        }

        /* Access modifiers changed, original: protected|final */
        public final int bjg() {
            return -1;
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean bjp() {
            return true;
        }

        /* Access modifiers changed, original: protected|final */
        public final int[] bjf() {
            AppMethodBeat.m2504i(52725);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9725dq);
            int[] iArr = new int[]{dimensionPixelSize, dimensionPixelSize};
            AppMethodBeat.m2505o(52725);
            return iArr;
        }

        public final void bjs() {
            AppMethodBeat.m2504i(52726);
            if (this.kRB == null) {
                AppMethodBeat.m2505o(52726);
                return;
            }
            switch (bjn()) {
                case 0:
                case 3:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(C25738R.drawable.f6484fp);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(C25738R.string.bai);
                    this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
                    this.kRL.setVisibility(4);
                    this.kRL.setImageResource(C25738R.drawable.emoji_download);
                    this.kRM.setVisibility(4);
                    AppMethodBeat.m2505o(52726);
                    return;
                case 6:
                    bjq();
                    AppMethodBeat.m2505o(52726);
                    return;
                default:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(C25738R.drawable.f6489fu);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(C25738R.string.bcb);
                    this.kRK.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a73));
                    this.kRL.setVisibility(4);
                    this.kRL.setImageResource(C25738R.drawable.emoji_download);
                    this.kRM.setVisibility(4);
                    AppMethodBeat.m2505o(52726);
                    return;
            }
        }
    }

    public C36759c(Context context) {
        super(context);
    }

    /* renamed from: b */
    public final View mo7106b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(52728);
        C36760a c36760a = (C36760a) view.getTag();
        C11546f tX = getItem(i);
        if (!(c36760a == null || tX == null)) {
            EmotionSummary emotionSummary = tX.kTb;
            if (emotionSummary != null) {
                if (C2932a.m5218g(emotionSummary)) {
                    c36760a.bjh();
                    c36760a.bjj();
                } else {
                    if (C5046bo.isNullOrNil(emotionSummary.PackName)) {
                        c36760a.setTitle(emotionSummary.ProductID);
                    } else {
                        c36760a.setTitle(emotionSummary.PackName);
                    }
                    if (C5046bo.isNullOrNil(emotionSummary.IconUrl)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                        c36760a.bji().setImageDrawable(null);
                    } else {
                        C32291o.ahp().mo43766a(emotionSummary.IconUrl, c36760a.bji(), C20364g.m31459dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                    }
                }
                if (i + 1 == getCount()) {
                    c36760a.kRC.setBackgroundResource(C25738R.drawable.f6625k7);
                }
            }
        }
        AppMethodBeat.m2505o(52728);
        return view;
    }

    /* renamed from: d */
    public final C45843a mo7110d(Context context, View view) {
        AppMethodBeat.m2504i(52729);
        C36760a c36760a = new C36760a(context, view);
        c36760a.mo73648a(this.kSQ);
        AppMethodBeat.m2505o(52729);
        return c36760a;
    }

    /* renamed from: a */
    public final C45842c mo54487a(C20383f c20383f) {
        AppMethodBeat.m2504i(52730);
        C38870d c38870d = new C38870d(c20383f);
        AppMethodBeat.m2505o(52730);
        return c38870d;
    }

    /* renamed from: bW */
    public final void mo54491bW(String str, int i) {
        AppMethodBeat.m2504i(52731);
        if (i == 7) {
            super.mo54491bW(str, i);
        }
        AppMethodBeat.m2505o(52731);
    }

    public final void bjv() {
        AppMethodBeat.m2504i(52733);
        super.bjv();
        AppMethodBeat.m2505o(52733);
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

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(52727);
        if (this.kSP == null) {
            this.kSP = mo54487a(null);
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(52727);
    }

    public final void clear() {
        AppMethodBeat.m2504i(52732);
        if (this.gqo != null) {
            this.gqo.cancel();
        }
        super.clear();
        AppMethodBeat.m2505o(52732);
    }
}
