package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.d;
import com.tencent.mm.audio.mix.h.a;
import java.util.ArrayList;

public final class b implements f {
    private String appId;

    public b(String str) {
        this.appId = str;
    }

    public final void Dp() {
        AppMethodBeat.i(137002);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", this.appId);
        d.Dm().clearCache();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
        ArrayList Do = d.Dm().Do();
        if (Do.size() > 0) {
            a.b(this.appId, Do);
        }
        AppMethodBeat.o(137002);
    }

    public final void end() {
        AppMethodBeat.i(137003);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
        AppMethodBeat.o(137003);
    }
}
