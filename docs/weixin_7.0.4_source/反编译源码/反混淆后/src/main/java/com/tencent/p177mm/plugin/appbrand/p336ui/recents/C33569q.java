package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.LinearLayoutManager;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.q */
public final class C33569q extends C41189ah {
    private final LinearLayoutManager iPk;
    private final int iPl = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private final int iPm;

    public C33569q(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        AppMethodBeat.m2504i(133541);
        this.iPk = linearLayoutManager;
        this.iPm = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
        AppMethodBeat.m2505o(133541);
    }

    /* renamed from: cb */
    public final int mo30874cb(int i) {
        AppMethodBeat.m2504i(133542);
        int cb = super.mo30874cb(Math.max(this.iPm, Math.min(this.iPl, i)));
        AppMethodBeat.m2505o(133542);
        return cb;
    }

    /* renamed from: bX */
    public final PointF mo22752bX(int i) {
        AppMethodBeat.m2504i(133543);
        PointF bX = this.iPk.mo1761bX(i);
        AppMethodBeat.m2505o(133543);
        return bX;
    }
}
