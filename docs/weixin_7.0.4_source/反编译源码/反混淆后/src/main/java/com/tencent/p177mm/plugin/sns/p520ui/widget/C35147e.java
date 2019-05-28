package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C18525b;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.e */
public final class C35147e {
    private static C35147e rNh = new C35147e();
    private static final int rNk = C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.f9733dz);
    public int rMP = 0;
    private C42149a rNi = null;
    private C42149a rNj = null;

    static {
        AppMethodBeat.m2504i(40522);
        AppMethodBeat.m2505o(40522);
    }

    public static C35147e cvB() {
        return rNh;
    }

    public final C42149a getTextViewConfig() {
        AppMethodBeat.m2504i(40518);
        int dm = (int) (((float) rNk) * C1338a.m2860dm(C4996ah.getContext()));
        if (this.rNi == null || ((int) this.rNi.eOg) != dm) {
            this.rNi = C18525b.m28828ST().mo33778jU(8388627).mo33779jV(C4996ah.getContext().getResources().getColor(C25738R.color.f12212w4)).mo33777ad((float) dm).eNR;
        }
        C42149a c42149a = this.rNi;
        AppMethodBeat.m2505o(40518);
        return c42149a;
    }

    public final C42149a cvC() {
        AppMethodBeat.m2504i(40519);
        int dm = (int) (((float) rNk) * C1338a.m2860dm(C4996ah.getContext()));
        if (this.rNj == null || ((int) this.rNj.eOg) != dm) {
            this.rNj = C18525b.m28828ST().mo33778jU(8388627).mo33779jV(C4996ah.getContext().getResources().getColor(C25738R.color.f12212w4)).mo33777ad((float) dm).mo33775SU().eNR;
        }
        C42149a c42149a = this.rNj;
        AppMethodBeat.m2505o(40519);
        return c42149a;
    }

    public final int getViewWidth() {
        int i;
        AppMethodBeat.m2504i(40520);
        if (this.rMP <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            int dimension = (int) (C4996ah.getResources().getDimension(C25738R.dimen.f9979m4) + C4996ah.getResources().getDimension(C25738R.dimen.f9979m4));
            int dimension2 = (int) C4996ah.getResources().getDimension(C25738R.dimen.a9g);
            int dimension3 = (int) C4996ah.getResources().getDimension(C25738R.dimen.f9979m4);
            this.rMP = (i - dimension2) - dimension;
            C4990ab.m7416i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rMP + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        i = this.rMP;
        AppMethodBeat.m2505o(40520);
        return i;
    }

    public static float getTextSize() {
        AppMethodBeat.m2504i(40521);
        float dm = (float) ((int) (((float) rNk) * C1338a.m2860dm(C4996ah.getContext())));
        AppMethodBeat.m2505o(40521);
        return dm;
    }
}
