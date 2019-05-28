package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.b */
public final class C29876b {
    public static int uyg = C29876b.m47352fr(C4996ah.getContext());
    public static final int uyh = C5230ak.getStatusBarHeight(C4996ah.getContext());
    public static final int uyi = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
    public static final int uyj = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.ab2);
    public static final int uyk = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.ab1);
    public static final int uyl = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.aaz);
    public static final int uym;
    public static final float uyn;
    public static final int uyo = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.aav);
    public static final int uyp;
    public static final float uyq;

    static {
        AppMethodBeat.m2504i(8149);
        int dimensionPixelSize = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.aay);
        uym = dimensionPixelSize;
        uyn = ((float) dimensionPixelSize) / ((float) uyl);
        dimensionPixelSize = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.aau);
        uyp = dimensionPixelSize;
        uyq = ((float) dimensionPixelSize) / ((float) uyo);
        AppMethodBeat.m2505o(8149);
    }

    /* renamed from: fr */
    private static int m47352fr(Context context) {
        AppMethodBeat.m2504i(8147);
        C4990ab.m7417i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", Integer.valueOf(C5230ak.m7988fr(context)));
        AppMethodBeat.m2505o(8147);
        return C5230ak.m7988fr(context);
    }

    /* renamed from: fs */
    public static void m47353fs(Context context) {
        AppMethodBeat.m2504i(8148);
        uyg = C29876b.m47352fr(context);
        AppMethodBeat.m2505o(8148);
    }
}
