package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class e {
    private static e rNh = new e();
    private static final int rNk = a.am(ah.getContext(), R.dimen.dz);
    public int rMP = 0;
    private com.tencent.mm.kiss.widget.textview.a.a rNi = null;
    private com.tencent.mm.kiss.widget.textview.a.a rNj = null;

    static {
        AppMethodBeat.i(40522);
        AppMethodBeat.o(40522);
    }

    public static e cvB() {
        return rNh;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig() {
        AppMethodBeat.i(40518);
        int dm = (int) (((float) rNk) * a.dm(ah.getContext()));
        if (this.rNi == null || ((int) this.rNi.eOg) != dm) {
            this.rNi = b.ST().jU(8388627).jV(ah.getContext().getResources().getColor(R.color.w4)).ad((float) dm).eNR;
        }
        com.tencent.mm.kiss.widget.textview.a.a aVar = this.rNi;
        AppMethodBeat.o(40518);
        return aVar;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a cvC() {
        AppMethodBeat.i(40519);
        int dm = (int) (((float) rNk) * a.dm(ah.getContext()));
        if (this.rNj == null || ((int) this.rNj.eOg) != dm) {
            this.rNj = b.ST().jU(8388627).jV(ah.getContext().getResources().getColor(R.color.w4)).ad((float) dm).SU().eNR;
        }
        com.tencent.mm.kiss.widget.textview.a.a aVar = this.rNj;
        AppMethodBeat.o(40519);
        return aVar;
    }

    public final int getViewWidth() {
        int i;
        AppMethodBeat.i(40520);
        if (this.rMP <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            int dimension = (int) (ah.getResources().getDimension(R.dimen.m4) + ah.getResources().getDimension(R.dimen.m4));
            int dimension2 = (int) ah.getResources().getDimension(R.dimen.a9g);
            int dimension3 = (int) ah.getResources().getDimension(R.dimen.m4);
            this.rMP = (i - dimension2) - dimension;
            ab.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rMP + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        i = this.rMP;
        AppMethodBeat.o(40520);
        return i;
    }

    public static float getTextSize() {
        AppMethodBeat.i(40521);
        float dm = (float) ((int) (((float) rNk) * a.dm(ah.getContext())));
        AppMethodBeat.o(40521);
        return dm;
    }
}
