package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebIconDatabase.C5810a;

/* renamed from: com.tencent.smtt.sdk.bl */
class C46738bl implements IconListener {
    /* renamed from: a */
    final /* synthetic */ C5810a f18014a;
    /* renamed from: b */
    final /* synthetic */ WebIconDatabase f18015b;

    C46738bl(WebIconDatabase webIconDatabase, C5810a c5810a) {
        this.f18015b = webIconDatabase;
        this.f18014a = c5810a;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64700);
        this.f18014a.mo12144a(str, bitmap);
        AppMethodBeat.m2505o(64700);
    }
}
