package com.tencent.p177mm.plugin.luckymoney.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.a */
public final class C39324a {
    private static int nZA;
    private static int nZB;
    private static int nZC;
    private static int nZx;
    private static int nZy;
    private static int nZz;
    public C34449c nZD;

    public C39324a(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(42432);
        if (nZx == 0) {
            Resources resources = viewGroup.getResources();
            nZx = resources.getDimensionPixelSize(C25738R.dimen.f10331y_);
            nZy = resources.getDimensionPixelOffset(C25738R.dimen.f10336ye);
            nZz = resources.getDimensionPixelOffset(C25738R.dimen.f10335yd);
            nZA = resources.getDimensionPixelOffset(C25738R.dimen.f10334yc);
            nZB = resources.getDimensionPixelOffset(C25738R.dimen.f10337yf);
            nZC = resources.getDimensionPixelOffset(C25738R.dimen.f10332ya);
        }
        AppMethodBeat.m2505o(42432);
    }

    /* renamed from: a */
    public static C39324a m67000a(ViewGroup viewGroup, C34448b c34448b) {
        AppMethodBeat.m2504i(42433);
        C39324a c39324a = new C39324a(viewGroup);
        c39324a.m67001b(viewGroup, c34448b);
        AppMethodBeat.m2505o(42433);
        return c39324a;
    }

    /* renamed from: P */
    public final C34449c mo62213P(int i, long j) {
        AppMethodBeat.m2504i(42434);
        C34449c c34449c = this.nZD;
        c34449c.nZL = 0;
        c34449c.nZM = j;
        c34449c = c34449c.mo54984aF((float) i).bLL();
        AppMethodBeat.m2505o(42434);
        return c34449c;
    }

    /* renamed from: b */
    private void m67001b(ViewGroup viewGroup, C34448b c34448b) {
        AppMethodBeat.m2504i(42435);
        C34449c aH = new C34449c(viewGroup.getContext(), c34448b, new C28431d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).mo54982R(0.0f, 800.0f).mo54983S(-2000.0f, 1250.0f).mo54986aH(2000.0f);
        aH.oal = 3000.0f;
        aH.oam = 500.0f;
        aH = aH.bLH();
        aH.nZO = C12433e.bLQ();
        this.nZD = aH.bLI().bLJ();
        AppMethodBeat.m2505o(42435);
    }
}
