package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.WebIconDatabase.C5810a;

/* renamed from: com.tencent.smtt.sdk.bk */
class C40976bk implements IconListener {
    /* renamed from: a */
    final /* synthetic */ C5810a f16294a;
    /* renamed from: b */
    final /* synthetic */ WebIconDatabase f16295b;

    C40976bk(WebIconDatabase webIconDatabase, C5810a c5810a) {
        this.f16295b = webIconDatabase;
        this.f16294a = c5810a;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64699);
        this.f16294a.mo12144a(str, bitmap);
        AppMethodBeat.m2505o(64699);
    }
}
