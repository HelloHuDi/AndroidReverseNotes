package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ah;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q extends ah {
    private final LinearLayoutManager iPk;
    private final int iPl = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private final int iPm;

    public q(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        AppMethodBeat.i(133541);
        this.iPk = linearLayoutManager;
        this.iPm = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
        AppMethodBeat.o(133541);
    }

    public final int cb(int i) {
        AppMethodBeat.i(133542);
        int cb = super.cb(Math.max(this.iPm, Math.min(this.iPl, i)));
        AppMethodBeat.o(133542);
        return cb;
    }

    public final PointF bX(int i) {
        AppMethodBeat.i(133543);
        PointF bX = this.iPk.bX(i);
        AppMethodBeat.o(133543);
        return bX;
    }
}
