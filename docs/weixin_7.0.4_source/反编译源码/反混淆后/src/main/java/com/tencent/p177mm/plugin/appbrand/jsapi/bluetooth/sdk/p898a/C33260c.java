package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C10345h;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C38282g;
import java.util.Map;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c */
public final class C33260c {
    public Context context;
    public Map<String, C10341d> hEg;
    public C10345h hEh;
    public C38282g hEi;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c$2 */
    public class C166432 implements C10345h {
        /* renamed from: ag */
        public final void mo21816ag(String str, boolean z) {
            AppMethodBeat.m2504i(94245);
            if (C33260c.this.hEh != null) {
                C33260c.this.hEh.mo21816ag(str, z);
            }
            AppMethodBeat.m2505o(94245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c$1 */
    public class C332611 implements C38282g {
        /* renamed from: f */
        public final void mo30606f(String str, String str2, String str3, String str4) {
            AppMethodBeat.m2504i(94244);
            if (C33260c.this.hEi != null) {
                C33260c.this.hEi.mo30606f(str, str2, str3, str4);
            }
            AppMethodBeat.m2505o(94244);
        }
    }

    public C33260c(Context context) {
        this.context = context;
    }
}
