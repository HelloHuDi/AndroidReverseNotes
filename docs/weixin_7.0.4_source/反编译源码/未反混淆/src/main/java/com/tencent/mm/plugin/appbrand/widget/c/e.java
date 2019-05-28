package com.tencent.mm.plugin.appbrand.widget.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"AppCompatCustomView"})
public final class e extends f implements a {
    public final /* bridge */ /* synthetic */ boolean aCH() {
        AppMethodBeat.i(126661);
        boolean aCH = super.aCH();
        AppMethodBeat.o(126661);
        return aCH;
    }

    public final /* bridge */ /* synthetic */ void setInterceptEvent(boolean z) {
        AppMethodBeat.i(126662);
        super.setInterceptEvent(z);
        AppMethodBeat.o(126662);
    }

    public e(Context context) {
        super(context);
    }

    public final void setImageFilePath(String str) {
    }

    public final void setImageByteArray(byte[] bArr) {
    }

    public final View getView() {
        return this;
    }
}
