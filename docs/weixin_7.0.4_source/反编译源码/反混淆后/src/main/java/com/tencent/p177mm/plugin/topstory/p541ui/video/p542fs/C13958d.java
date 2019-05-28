package com.tencent.p177mm.plugin.topstory.p541ui.video.p542fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13986n;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4233e;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.fs.d */
public final class C13958d extends C4233e {
    protected C4232b sDN;
    public boolean sFI = false;

    public C13958d(C4232b c4232b) {
        super(c4232b);
        this.sDN = c4232b;
    }

    /* renamed from: j */
    public final void mo9205j(final List<chw> list, boolean z) {
        AppMethodBeat.m2504i(1874);
        super.mo9205j(list, z);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1873);
                C13986n cGg = C13958d.this.sDo.cGg();
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGg.cGR()), Integer.valueOf(list.size()));
                List list = list;
                synchronized (cGg) {
                    try {
                        if (!C5046bo.m7548ek(list)) {
                            cGg.cGQ().addAll(list);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(1873);
                    }
                }
                C13958d c13958d = C13958d.this;
                c13958d.mo66316cg(r0 + c13958d.getHeadersCount());
            }
        });
        AppMethodBeat.m2505o(1874);
    }

    /* renamed from: FG */
    public final int mo9196FG(int i) {
        return 0;
    }
}
