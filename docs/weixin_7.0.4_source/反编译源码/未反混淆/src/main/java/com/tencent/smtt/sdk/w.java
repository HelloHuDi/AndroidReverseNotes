package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class w implements Runnable {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public void run() {
        AppMethodBeat.i(64115);
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
        AppMethodBeat.o(64115);
    }
}
