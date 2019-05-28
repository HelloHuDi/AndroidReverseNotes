package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.k;

public final class l extends j {
    public final MediaPlayer bTR() {
        AppMethodBeat.i(104836);
        k kVar = new k();
        AppMethodBeat.o(104836);
        return kVar;
    }

    public final AudioTrack ac(int i, int i2, int i3) {
        AppMethodBeat.i(104837);
        e eVar = new e(3, i, i2, i3);
        AppMethodBeat.o(104837);
        return eVar;
    }
}
