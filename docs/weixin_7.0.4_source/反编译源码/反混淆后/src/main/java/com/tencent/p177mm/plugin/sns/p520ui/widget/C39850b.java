package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C18525b;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.b */
public final class C39850b {
    private static C39850b rMR = new C39850b();
    private C42149a rMO = null;
    private int rMP = 0;

    static {
        AppMethodBeat.m2504i(40478);
        AppMethodBeat.m2505o(40478);
    }

    public static C39850b cvx() {
        return rMR;
    }

    public final C42149a getTextViewConfig() {
        AppMethodBeat.m2504i(40476);
        int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), (int) (15.0f * C1338a.m2860dm(C4996ah.getContext())));
        if (this.rMO == null || ((int) this.rMO.eOg) != fromDPToPix) {
            this.rMO = C18525b.m28828ST().mo33777ad((float) fromDPToPix).mo33779jV(C4996ah.getContext().getResources().getColor(C25738R.color.a0d)).mo33778jU(16).mo33776a(TruncateAt.END).eNR;
        }
        C42149a c42149a = this.rMO;
        AppMethodBeat.m2505o(40476);
        return c42149a;
    }

    public final int getViewWidth() {
        int i;
        AppMethodBeat.m2504i(40477);
        if (this.rMP <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            int dimension = (int) (C4996ah.getResources().getDimension(C25738R.dimen.f9979m4) + C4996ah.getResources().getDimension(C25738R.dimen.f9979m4));
            int dimension2 = (int) C4996ah.getResources().getDimension(C25738R.dimen.a9g);
            int dimension3 = (int) C4996ah.getResources().getDimension(C25738R.dimen.f9979m4);
            this.rMP = ((i - dimension2) - dimension) - dimension3;
            C4990ab.m7416i("MicroMsg.SnsCommentPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rMP + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        i = this.rMP;
        AppMethodBeat.m2505o(40477);
        return i;
    }
}
