package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

final class l implements TbsListener {
    final /* synthetic */ Context a;
    final /* synthetic */ PreInitCallback b;

    l(Context context, PreInitCallback preInitCallback) {
        this.a = context;
        this.b = preInitCallback;
    }

    public final void onDownloadFinish(int i) {
    }

    public final void onDownloadProgress(int i) {
    }

    public final void onInstallFinish(int i) {
        AppMethodBeat.i(63989);
        QbSdk.preInit(this.a, this.b);
        AppMethodBeat.o(63989);
    }
}
