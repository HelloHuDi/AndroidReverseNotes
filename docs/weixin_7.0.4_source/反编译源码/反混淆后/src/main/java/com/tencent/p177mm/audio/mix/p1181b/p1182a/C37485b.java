package com.tencent.p177mm.audio.mix.p1181b.p1182a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.audio.mix.b.a.b */
public final class C37485b implements C25837f {
    private String appId;

    public C37485b(String str) {
        this.appId = str;
    }

    /* renamed from: Dp */
    public final void mo43825Dp() {
        AppMethodBeat.m2504i(137002);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", this.appId);
        C45166d.m83168Dm().clearCache();
        C45174b.m83209i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
        ArrayList Do = C45166d.m83168Dm().mo73131Do();
        if (Do.size() > 0) {
            C41782a.m73752b(this.appId, Do);
        }
        AppMethodBeat.m2505o(137002);
    }

    public final void end() {
        AppMethodBeat.m2504i(137003);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
        AppMethodBeat.m2505o(137003);
    }
}
