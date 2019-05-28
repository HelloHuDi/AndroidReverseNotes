package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceError;

/* renamed from: com.tencent.smtt.sdk.af */
class C5811af extends WebResourceError {
    /* renamed from: a */
    final /* synthetic */ android.webkit.WebResourceError f1394a;
    /* renamed from: b */
    final /* synthetic */ C36426ad f1395b;

    C5811af(C36426ad c36426ad, android.webkit.WebResourceError webResourceError) {
        this.f1395b = c36426ad;
        this.f1394a = webResourceError;
    }

    public CharSequence getDescription() {
        AppMethodBeat.m2504i(64200);
        CharSequence description = this.f1394a.getDescription();
        AppMethodBeat.m2505o(64200);
        return description;
    }

    public int getErrorCode() {
        AppMethodBeat.m2504i(64201);
        int errorCode = this.f1394a.getErrorCode();
        AppMethodBeat.m2505o(64201);
        return errorCode;
    }
}
