package com.tencent.p177mm.plugin.wallet_core.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.m */
public final class C29634m {
    public String hwA;
    public boolean kDs;
    public int retCode;
    public int tzy;

    /* renamed from: a */
    public static C29634m m47002a(boolean z, int i, int i2, String str) {
        AppMethodBeat.m2504i(46781);
        C29634m c29634m = new C29634m();
        c29634m.kDs = z;
        c29634m.retCode = i;
        c29634m.tzy = i2;
        c29634m.hwA = str;
        AppMethodBeat.m2505o(46781);
        return c29634m;
    }

    /* renamed from: gi */
    public static C29634m m47003gi(int i, int i2) {
        AppMethodBeat.m2504i(46782);
        C29634m a = C29634m.m47002a(false, i, i2, "");
        AppMethodBeat.m2505o(46782);
        return a;
    }

    /* renamed from: y */
    public final void mo47880y(Context context, boolean z) {
        AppMethodBeat.m2504i(46783);
        if (!this.kDs) {
            C30379h.m48461b(context, context.getString(C25738R.string.fiu), "", false);
        } else if (!C5046bo.isNullOrNil(this.hwA)) {
            if (z) {
                Toast.makeText(context, this.hwA, 1).show();
                AppMethodBeat.m2505o(46783);
                return;
            }
            C30379h.m48461b(context, this.hwA, "", false);
            AppMethodBeat.m2505o(46783);
            return;
        }
        AppMethodBeat.m2505o(46783);
    }
}
