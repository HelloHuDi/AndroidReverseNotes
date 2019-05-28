package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;

public final class a implements DeathRecipient {
    private String process;

    public a(String str) {
        this.process = str;
    }

    public final void binderDied() {
        AppMethodBeat.i(114109);
        b.i("IPC.DeathRecipientImpl", "binderDied(%s)", this.process);
        if (this.process == null || this.process.length() == 0) {
            AppMethodBeat.o(114109);
            return;
        }
        b.lk(this.process);
        AppMethodBeat.o(114109);
    }
}
