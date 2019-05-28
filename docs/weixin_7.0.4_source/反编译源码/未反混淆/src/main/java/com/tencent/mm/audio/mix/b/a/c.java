package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.d;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements f {
    private String appId;

    public c(String str) {
        this.appId = str;
    }

    public final void Dp() {
        AppMethodBeat.i(137004);
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "runTask, appId:%s", this.appId);
        d Dm = d.Dm();
        synchronized (Dm.ckQ) {
            try {
                Iterator it = Dm.ckO.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.audio.mix.a.c cVar = (com.tencent.mm.audio.mix.a.c) Dm.ckP.get((String) it.next());
                    if (cVar != null) {
                        cVar.recycle();
                    }
                }
                Dm.ckO.clear();
                Dm.ckP.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(137004);
            }
        }
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "delete all pcm cache File");
        ArrayList Do = d.Dm().Do();
        if (Do.size() > 0) {
            a.b(this.appId, Do);
        }
        AppMethodBeat.o(137004);
    }

    public final void end() {
        AppMethodBeat.i(137005);
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "end task");
        AppMethodBeat.o(137005);
    }
}
