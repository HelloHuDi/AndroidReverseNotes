package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.da;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog gqo;

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* Access modifiers changed, original: protected|final */
        public final void bje() {
            AppMethodBeat.i(52722);
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
            AppMethodBeat.o(52722);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean a(com.tencent.mm.plugin.emoji.model.i.a aVar, View view) {
            AppMethodBeat.i(52723);
            bjn();
            boolean a = super.a(aVar, view);
            AppMethodBeat.o(52723);
            return a;
        }

        /* Access modifiers changed, original: protected|final */
        public final void b(com.tencent.mm.plugin.emoji.model.i.a aVar, View view) {
            AppMethodBeat.i(52724);
            super.b(aVar, view);
            if (com.tencent.mm.plugin.emoji.h.a.JW(getProductId())) {
                int i;
                da daVar = new da();
                daVar.cwf.cwg = getProductId();
                com.tencent.mm.g.a.da.a aVar2 = daVar.cwf;
                if (com.tencent.mm.plugin.emoji.h.a.blE()) {
                    i = 7;
                } else {
                    i = 3;
                }
                aVar2.status = i;
                daVar.cwf.progress = getProgress();
                daVar.cwf.cwh = this.kRB.kTe;
                com.tencent.mm.sdk.b.a.xxA.m(daVar);
            }
            AppMethodBeat.o(52724);
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
            AppMethodBeat.i(52725);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.dq);
            int[] iArr = new int[]{dimensionPixelSize, dimensionPixelSize};
            AppMethodBeat.o(52725);
            return iArr;
        }

        public final void bjs() {
            AppMethodBeat.i(52726);
            if (this.kRB == null) {
                AppMethodBeat.o(52726);
                return;
            }
            switch (bjn()) {
                case 0:
                case 3:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(R.drawable.fp);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(R.string.bai);
                    this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
                    this.kRL.setVisibility(4);
                    this.kRL.setImageResource(R.drawable.emoji_download);
                    this.kRM.setVisibility(4);
                    AppMethodBeat.o(52726);
                    return;
                case 6:
                    bjq();
                    AppMethodBeat.o(52726);
                    return;
                default:
                    this.kRH.setVisibility(8);
                    this.kRI.setBackgroundResource(R.drawable.fu);
                    this.kRI.setVisibility(0);
                    this.kRK.setVisibility(0);
                    this.kRK.setText(R.string.bcb);
                    this.kRK.setTextColor(this.mContext.getResources().getColorStateList(R.color.a73));
                    this.kRL.setVisibility(4);
                    this.kRL.setImageResource(R.drawable.emoji_download);
                    this.kRM.setVisibility(4);
                    AppMethodBeat.o(52726);
                    return;
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(52728);
        a aVar = (a) view.getTag();
        f tX = getItem(i);
        if (!(aVar == null || tX == null)) {
            EmotionSummary emotionSummary = tX.kTb;
            if (emotionSummary != null) {
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    aVar.bjh();
                    aVar.bjj();
                } else {
                    if (bo.isNullOrNil(emotionSummary.PackName)) {
                        aVar.setTitle(emotionSummary.ProductID);
                    } else {
                        aVar.setTitle(emotionSummary.PackName);
                    }
                    if (bo.isNullOrNil(emotionSummary.IconUrl)) {
                        ab.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                        aVar.bji().setImageDrawable(null);
                    } else {
                        o.ahp().a(emotionSummary.IconUrl, aVar.bji(), g.dH(emotionSummary.ProductID, emotionSummary.IconUrl));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.kRC.setBackgroundResource(R.drawable.k7);
                }
            }
        }
        AppMethodBeat.o(52728);
        return view;
    }

    public final a d(Context context, View view) {
        AppMethodBeat.i(52729);
        a aVar = new a(context, view);
        aVar.a(this.kSQ);
        AppMethodBeat.o(52729);
        return aVar;
    }

    public final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f fVar) {
        AppMethodBeat.i(52730);
        d dVar = new d(fVar);
        AppMethodBeat.o(52730);
        return dVar;
    }

    public final void bW(String str, int i) {
        AppMethodBeat.i(52731);
        if (i == 7) {
            super.bW(str, i);
        }
        AppMethodBeat.o(52731);
    }

    public final void bjv() {
        AppMethodBeat.i(52733);
        super.bjv();
        AppMethodBeat.o(52733);
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

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(52727);
        if (this.kSP == null) {
            this.kSP = a(null);
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(52727);
    }

    public final void clear() {
        AppMethodBeat.i(52732);
        if (this.gqo != null) {
            this.gqo.cancel();
        }
        super.clear();
        AppMethodBeat.o(52732);
    }
}
