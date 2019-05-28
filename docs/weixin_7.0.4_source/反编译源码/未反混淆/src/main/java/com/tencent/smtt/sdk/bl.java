package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebIconDatabase.a;

class bl implements IconListener {
    final /* synthetic */ a a;
    final /* synthetic */ WebIconDatabase b;

    bl(WebIconDatabase webIconDatabase, a aVar) {
        this.b = webIconDatabase;
        this.a = aVar;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        AppMethodBeat.i(64700);
        this.a.a(str, bitmap);
        AppMethodBeat.o(64700);
    }
}
