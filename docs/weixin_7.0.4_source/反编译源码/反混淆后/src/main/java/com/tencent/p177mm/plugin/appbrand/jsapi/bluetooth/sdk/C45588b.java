package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.C33260c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.C26945a;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b */
public final class C45588b {
    private Context context;
    public C33260c hDY;
    public C26945a hDZ;

    public C45588b(Context context) {
        AppMethodBeat.m2504i(94219);
        this.context = context;
        this.hDY = new C33260c(context);
        this.hDZ = new C26945a(context);
        AppMethodBeat.m2505o(94219);
    }
}
