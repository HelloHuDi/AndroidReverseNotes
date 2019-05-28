package com.tencent.p177mm.audio.mix.p831d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;

/* renamed from: com.tencent.mm.audio.mix.d.b */
public final class C25839b extends C41778i {
    private C17958j clH;
    public boolean clI = false;
    public C17959k clJ;

    public C25839b(C17958j c17958j, String str) {
        super(str);
        this.clH = c17958j;
    }

    public final void run() {
        AppMethodBeat.m2504i(137049);
        C45174b.m83210i("MicroMsg.Mix.AudioDecodeTask", "run task %s", this.name);
        if (this.clI) {
            AppMethodBeat.m2505o(137049);
            return;
        }
        Process.setThreadPriority(-16);
        this.clH.mo33496a(this.clJ);
        this.clH.mo33495a(this);
        this.clI = true;
        C45174b.m83210i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", this.name);
        AppMethodBeat.m2505o(137049);
    }

    public final void reset() {
        this.clI = false;
    }

    /* renamed from: b */
    public final void mo43828b(C17959k c17959k) {
        AppMethodBeat.m2504i(137050);
        this.clJ = c17959k;
        this.cmn = System.currentTimeMillis();
        AppMethodBeat.m2505o(137050);
    }

    /* renamed from: Dv */
    public final boolean mo43827Dv() {
        return this.clJ == null;
    }
}
