package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends i {
    private j clH;
    public boolean clI = false;
    public k clJ;

    public b(j jVar, String str) {
        super(str);
        this.clH = jVar;
    }

    public final void run() {
        AppMethodBeat.i(137049);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", this.name);
        if (this.clI) {
            AppMethodBeat.o(137049);
            return;
        }
        Process.setThreadPriority(-16);
        this.clH.a(this.clJ);
        this.clH.a(this);
        this.clI = true;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", this.name);
        AppMethodBeat.o(137049);
    }

    public final void reset() {
        this.clI = false;
    }

    public final void b(k kVar) {
        AppMethodBeat.i(137050);
        this.clJ = kVar;
        this.cmn = System.currentTimeMillis();
        AppMethodBeat.o(137050);
    }

    public final boolean Dv() {
        return this.clJ == null;
    }
}
