package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceError;

class af extends WebResourceError {
    final /* synthetic */ android.webkit.WebResourceError a;
    final /* synthetic */ ad b;

    af(ad adVar, android.webkit.WebResourceError webResourceError) {
        this.b = adVar;
        this.a = webResourceError;
    }

    public CharSequence getDescription() {
        AppMethodBeat.i(64200);
        CharSequence description = this.a.getDescription();
        AppMethodBeat.o(64200);
        return description;
    }

    public int getErrorCode() {
        AppMethodBeat.i(64201);
        int errorCode = this.a.getErrorCode();
        AppMethodBeat.o(64201);
        return errorCode;
    }
}
