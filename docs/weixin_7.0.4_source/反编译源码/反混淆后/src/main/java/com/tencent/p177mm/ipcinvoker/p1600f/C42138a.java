package com.tencent.p177mm.ipcinvoker.p1600f;

import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;

/* renamed from: com.tencent.mm.ipcinvoker.f.a */
public final class C42138a implements DeathRecipient {
    private String process;

    public C42138a(String str) {
        this.process = str;
    }

    public final void binderDied() {
        AppMethodBeat.m2504i(114109);
        C26340b.m41917i("IPC.DeathRecipientImpl", "binderDied(%s)", this.process);
        if (this.process == null || this.process.length() == 0) {
            AppMethodBeat.m2505o(114109);
            return;
        }
        C42139b.m74293lk(this.process);
        AppMethodBeat.m2505o(114109);
    }
}
