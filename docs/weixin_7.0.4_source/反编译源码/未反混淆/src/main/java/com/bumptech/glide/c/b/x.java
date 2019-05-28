package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x {
    private boolean aCl;
    private final Handler handler = new Handler(Looper.getMainLooper(), new a());

    static final class a implements Callback {
        a() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(91887);
            if (message.what == 1) {
                ((u) message.obj).recycle();
                AppMethodBeat.o(91887);
                return true;
            }
            AppMethodBeat.o(91887);
            return false;
        }
    }

    x() {
        AppMethodBeat.i(91888);
        AppMethodBeat.o(91888);
    }

    /* Access modifiers changed, original: final */
    public final void e(u<?> uVar) {
        AppMethodBeat.i(91889);
        j.om();
        if (this.aCl) {
            this.handler.obtainMessage(1, uVar).sendToTarget();
            AppMethodBeat.o(91889);
            return;
        }
        this.aCl = true;
        uVar.recycle();
        this.aCl = false;
        AppMethodBeat.o(91889);
    }
}
