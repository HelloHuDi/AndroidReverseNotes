package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

/* renamed from: com.tencent.smtt.sdk.l */
final class C16152l implements TbsListener {
    /* renamed from: a */
    final /* synthetic */ Context f3031a;
    /* renamed from: b */
    final /* synthetic */ PreInitCallback f3032b;

    C16152l(Context context, PreInitCallback preInitCallback) {
        this.f3031a = context;
        this.f3032b = preInitCallback;
    }

    public final void onDownloadFinish(int i) {
    }

    public final void onDownloadProgress(int i) {
    }

    public final void onInstallFinish(int i) {
        AppMethodBeat.m2504i(63989);
        QbSdk.preInit(this.f3031a, this.f3032b);
        AppMethodBeat.m2505o(63989);
    }
}
