package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.b */
public final class C27323b extends C5652a {
    private boolean iFB = false;

    public C27323b(Context context) {
        super(context);
        AppMethodBeat.m2504i(132890);
        if (context instanceof Activity) {
            this.iFB = C42696n.m75618b(((Activity) context).getWindow());
        }
        AppMethodBeat.m2505o(132890);
    }

    public final C5653c aMb() {
        AppMethodBeat.m2504i(132891);
        C5653c aMb = super.aMb();
        C42696n.m75616a(aMb.getWindow(), this.iFB);
        AppMethodBeat.m2505o(132891);
        return aMb;
    }
}
