package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.ae */
class C16146ae implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C36426ad f3020a;

    C16146ae(C36426ad c36426ad) {
        this.f3020a = c36426ad;
    }

    public void run() {
        AppMethodBeat.m2504i(64199);
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.f3020a.f15124b.getContext()) && TbsDownloader.needDownload(this.f3020a.f15124b.getContext(), false)) {
            TbsDownloader.startDownload(this.f3020a.f15124b.getContext());
        }
        AppMethodBeat.m2505o(64199);
    }
}
