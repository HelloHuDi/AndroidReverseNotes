package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10343a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a */
public final class C26940a extends C10343a {
    public final void aCR() {
        AppMethodBeat.m2504i(94258);
        if (this.hEt.hEl == null) {
            C26944a.m42896e("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
            mo21808a(C26942j.hET);
            done();
            AppMethodBeat.m2505o(94258);
            return;
        }
        this.hEt.mo21794dW(true);
        mo21808a(C26942j.hEL);
        done();
        AppMethodBeat.m2505o(94258);
    }

    public final String getName() {
        return "CloseAction";
    }
}
