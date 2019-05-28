package com.tencent.p177mm.plugin.appbrand.permission;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.h */
public class C24706h implements C19661f {
    protected final C6750i gPI;

    public C24706h(C6750i c6750i) {
        this.gPI = c6750i;
    }

    /* renamed from: Dq */
    public void mo34900Dq(String str) {
        AppMethodBeat.m2504i(102303);
        Toast.makeText(this.gPI.getContext(), String.format("jsapi banned %s", new Object[]{str}), 0).show();
        AppMethodBeat.m2505o(102303);
    }
}
