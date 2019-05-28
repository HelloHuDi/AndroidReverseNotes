package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class d extends e {
    protected b sDN;
    public boolean sFI = false;

    public d(b bVar) {
        super(bVar);
        this.sDN = bVar;
    }

    public final void j(final List<chw> list, boolean z) {
        AppMethodBeat.i(1874);
        super.j(list, z);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1873);
                n cGg = d.this.sDo.cGg();
                ab.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(cGg.cGR()), Integer.valueOf(list.size()));
                List list = list;
                synchronized (cGg) {
                    try {
                        if (!bo.ek(list)) {
                            cGg.cGQ().addAll(list);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(1873);
                    }
                }
                d dVar = d.this;
                dVar.cg(r0 + dVar.getHeadersCount());
            }
        });
        AppMethodBeat.o(1874);
    }

    public final int FG(int i) {
        return 0;
    }
}
