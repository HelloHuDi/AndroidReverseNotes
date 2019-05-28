package com.tencent.mm.plugin.luckymoney.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    private static int nZA;
    private static int nZB;
    private static int nZC;
    private static int nZx;
    private static int nZy;
    private static int nZz;
    public c nZD;

    public a(ViewGroup viewGroup) {
        AppMethodBeat.i(42432);
        if (nZx == 0) {
            Resources resources = viewGroup.getResources();
            nZx = resources.getDimensionPixelSize(R.dimen.y_);
            nZy = resources.getDimensionPixelOffset(R.dimen.ye);
            nZz = resources.getDimensionPixelOffset(R.dimen.yd);
            nZA = resources.getDimensionPixelOffset(R.dimen.yc);
            nZB = resources.getDimensionPixelOffset(R.dimen.yf);
            nZC = resources.getDimensionPixelOffset(R.dimen.ya);
        }
        AppMethodBeat.o(42432);
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(42433);
        a aVar = new a(viewGroup);
        aVar.b(viewGroup, bVar);
        AppMethodBeat.o(42433);
        return aVar;
    }

    public final c P(int i, long j) {
        AppMethodBeat.i(42434);
        c cVar = this.nZD;
        cVar.nZL = 0;
        cVar.nZM = j;
        cVar = cVar.aF((float) i).bLL();
        AppMethodBeat.o(42434);
        return cVar;
    }

    private void b(ViewGroup viewGroup, b bVar) {
        AppMethodBeat.i(42435);
        c aH = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).R(0.0f, 800.0f).S(-2000.0f, 1250.0f).aH(2000.0f);
        aH.oal = 3000.0f;
        aH.oam = 500.0f;
        aH = aH.bLH();
        aH.nZO = e.bLQ();
        this.nZD = aH.bLI().bLJ();
        AppMethodBeat.o(42435);
    }
}
