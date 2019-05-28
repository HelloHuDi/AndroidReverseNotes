package com.bumptech.glide.p086c.p088b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.b.x */
final class C41549x {
    private boolean aCl;
    private final Handler handler = new Handler(Looper.getMainLooper(), new C41550a());

    /* renamed from: com.bumptech.glide.c.b.x$a */
    static final class C41550a implements Callback {
        C41550a() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(91887);
            if (message.what == 1) {
                ((C17526u) message.obj).recycle();
                AppMethodBeat.m2505o(91887);
                return true;
            }
            AppMethodBeat.m2505o(91887);
            return false;
        }
    }

    C41549x() {
        AppMethodBeat.m2504i(91888);
        AppMethodBeat.m2505o(91888);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo66574e(C17526u<?> c17526u) {
        AppMethodBeat.m2504i(91889);
        C45002j.m82426om();
        if (this.aCl) {
            this.handler.obtainMessage(1, c17526u).sendToTarget();
            AppMethodBeat.m2505o(91889);
            return;
        }
        this.aCl = true;
        c17526u.recycle();
        this.aCl = false;
        AppMethodBeat.m2505o(91889);
    }
}
