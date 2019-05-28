package com.tencent.p177mm.audio.mix.p1181b.p1182a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.audio.mix.b.a.c */
public final class C41769c implements C25837f {
    private String appId;

    public C41769c(String str) {
        this.appId = str;
    }

    /* renamed from: Dp */
    public final void mo43825Dp() {
        AppMethodBeat.m2504i(137004);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "runTask, appId:%s", this.appId);
        C45166d Dm = C45166d.m83168Dm();
        synchronized (Dm.ckQ) {
            try {
                Iterator it = Dm.ckO.iterator();
                while (it.hasNext()) {
                    C37484c c37484c = (C37484c) Dm.ckP.get((String) it.next());
                    if (c37484c != null) {
                        c37484c.recycle();
                    }
                }
                Dm.ckO.clear();
                Dm.ckP.clear();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(137004);
            }
        }
        C45174b.m83209i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "delete all pcm cache File");
        ArrayList Do = C45166d.m83168Dm().mo73131Do();
        if (Do.size() > 0) {
            C41782a.m73752b(this.appId, Do);
        }
        AppMethodBeat.m2505o(137004);
    }

    public final void end() {
        AppMethodBeat.m2504i(137005);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "end task");
        AppMethodBeat.m2505o(137005);
    }
}
