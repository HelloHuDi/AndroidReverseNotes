package com.tencent.mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends com.tencent.mm.plugin.mmsight.api.b {
    private d gLs;
    private VideoTransPara gLt;

    public static class a implements com.tencent.mm.plugin.mmsight.api.b.a {
        public final com.tencent.mm.plugin.mmsight.api.b asm() {
            AppMethodBeat.i(76304);
            b bVar = new b();
            AppMethodBeat.o(76304);
            return bVar;
        }
    }

    public final void a(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        AppMethodBeat.i(76305);
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        j.c(videoTransPara);
        this.gLt = videoTransPara;
        AppMethodBeat.o(76305);
    }

    public final void b(com.tencent.mm.remoteservice.d dVar, VideoTransPara videoTransPara) {
        AppMethodBeat.i(76306);
        if (dVar != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(dVar));
        }
        j.c(videoTransPara);
        j.ouz.etz = 1;
        this.gLt = videoTransPara;
        AppMethodBeat.o(76306);
    }

    public final d asl() {
        AppMethodBeat.i(76307);
        if (this.gLt != null) {
            k.bPR();
            this.gLs = k.p(this.gLt);
        }
        if (this.gLs instanceof l) {
            l lVar = (l) this.gLs;
            ab.i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", Boolean.TRUE);
            lVar.oww = true;
        }
        d dVar = this.gLs;
        AppMethodBeat.o(76307);
        return dVar;
    }
}
