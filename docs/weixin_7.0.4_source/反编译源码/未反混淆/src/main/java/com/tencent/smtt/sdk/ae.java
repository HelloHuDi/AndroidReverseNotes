package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ae implements Runnable {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public void run() {
        AppMethodBeat.i(64199);
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
        AppMethodBeat.o(64199);
    }
}
