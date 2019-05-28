package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {
    private static b rMR = new b();
    private a rMO = null;
    private int rMP = 0;

    static {
        AppMethodBeat.i(40478);
        AppMethodBeat.o(40478);
    }

    public static b cvx() {
        return rMR;
    }

    public final a getTextViewConfig() {
        AppMethodBeat.i(40476);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), (int) (15.0f * com.tencent.mm.bz.a.dm(ah.getContext())));
        if (this.rMO == null || ((int) this.rMO.eOg) != fromDPToPix) {
            this.rMO = com.tencent.mm.kiss.widget.textview.a.b.ST().ad((float) fromDPToPix).jV(ah.getContext().getResources().getColor(R.color.a0d)).jU(16).a(TruncateAt.END).eNR;
        }
        a aVar = this.rMO;
        AppMethodBeat.o(40476);
        return aVar;
    }

    public final int getViewWidth() {
        int i;
        AppMethodBeat.i(40477);
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
        AppMethodBeat.o(40477);
        return i;
    }
}
