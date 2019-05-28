package com.tencent.p177mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.api.C39375b;
import com.tencent.p177mm.plugin.mmsight.api.C39375b.C39376a;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43304d;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43306k;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C44750l;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.api.b */
public final class C45507b extends C39375b {
    private C43304d gLs;
    private VideoTransPara gLt;

    /* renamed from: com.tencent.mm.plugin.api.b$a */
    public static class C18991a implements C39376a {
        public final C39375b asm() {
            AppMethodBeat.m2504i(76304);
            C45507b c45507b = new C45507b();
            AppMethodBeat.m2505o(76304);
            return c45507b;
        }
    }

    /* renamed from: a */
    public final void mo62266a(C46607d c46607d, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76305);
        if (c46607d != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(c46607d));
        }
        C12563j.m20499c(videoTransPara);
        this.gLt = videoTransPara;
        AppMethodBeat.m2505o(76305);
    }

    /* renamed from: b */
    public final void mo62268b(C46607d c46607d, VideoTransPara videoTransPara) {
        AppMethodBeat.m2504i(76306);
        if (c46607d != null) {
            CaptureMMProxy.createProxy(new CaptureMMProxy(c46607d));
        }
        C12563j.m20499c(videoTransPara);
        C12563j.ouz.etz = 1;
        this.gLt = videoTransPara;
        AppMethodBeat.m2505o(76306);
    }

    public final C43304d asl() {
        AppMethodBeat.m2504i(76307);
        if (this.gLt != null) {
            C43306k.bPR();
            this.gLs = C43306k.m77221p(this.gLt);
        }
        if (this.gLs instanceof C44750l) {
            C44750l c44750l = (C44750l) this.gLs;
            C4990ab.m7417i("MicroMsg.MMSightFFMpegRecorder", "setStopOnCameraDataThread: %s", Boolean.TRUE);
            c44750l.oww = true;
        }
        C43304d c43304d = this.gLs;
        AppMethodBeat.m2505o(76307);
        return c43304d;
    }
}
