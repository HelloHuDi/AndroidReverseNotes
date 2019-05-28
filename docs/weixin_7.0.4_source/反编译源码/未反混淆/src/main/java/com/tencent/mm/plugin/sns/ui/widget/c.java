package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c {
    private static c rNa = new c();
    private a rMO = null;
    public int rMP = 0;

    static {
        AppMethodBeat.i(40502);
        AppMethodBeat.o(40502);
    }

    public static c cvy() {
        return rNa;
    }

    public final a getTextViewConfig() {
        AppMethodBeat.i(40500);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) (15.0f * com.tencent.mm.bz.a.dm(ah.getContext())));
        if (this.rMO == null || ((int) this.rMO.eOg) != fromDPToPix) {
            this.rMO = b.ST().ad((float) fromDPToPix).jV(ah.getContext().getResources().getColor(R.color.a0d)).jU(16).eNR;
        }
        a aVar = this.rMO;
        AppMethodBeat.o(40500);
        return aVar;
    }

    public final int getViewWidth() {
        int i;
        AppMethodBeat.i(40501);
        if (this.rMP <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            int dimension = (int) (ah.getResources().getDimension(R.dimen.m4) + ah.getResources().getDimension(R.dimen.m4));
            int dimension2 = (int) ah.getResources().getDimension(R.dimen.a9g);
            int dimension3 = (int) ah.getResources().getDimension(R.dimen.m4);
            this.rMP = ((i - dimension2) - dimension) - dimension3;
            ab.i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rMP + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        i = this.rMP;
        AppMethodBeat.o(40501);
        return i;
    }
}
