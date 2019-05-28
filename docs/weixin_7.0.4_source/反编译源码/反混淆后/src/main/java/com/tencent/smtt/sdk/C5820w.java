package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.w */
class C5820w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C5819v f1433a;

    C5820w(C5819v c5819v) {
        this.f1433a = c5819v;
    }

    public void run() {
        AppMethodBeat.m2504i(64115);
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.f1433a.f1432b.getContext()) && TbsDownloader.needDownload(this.f1433a.f1432b.getContext(), false)) {
            TbsDownloader.startDownload(this.f1433a.f1432b.getContext());
        }
        AppMethodBeat.m2505o(64115);
    }
}
