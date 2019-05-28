package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    b euH = null;
    private final String euI = "audio_lock";
    Context mContext = null;

    public interface a {
        void gF(int i);
    }

    public interface b {
        boolean Mm();

        void a(a aVar);

        boolean requestFocus();
    }

    public b(Context context) {
        AppMethodBeat.i(93060);
        this.mContext = context;
        com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                AppMethodBeat.i(93059);
                b.this.euH = new c(b.this.mContext);
                AppMethodBeat.o(93059);
            }
        });
        AppMethodBeat.o(93060);
    }

    public final boolean requestFocus() {
        boolean z;
        AppMethodBeat.i(93061);
        synchronized ("audio_lock") {
            try {
                if (this.euH == null) {
                    z = false;
                } else {
                    z = this.euH.requestFocus();
                    AppMethodBeat.o(93061);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93061);
            }
        }
        return z;
    }

    public final boolean Mm() {
        boolean z;
        AppMethodBeat.i(93062);
        synchronized ("audio_lock") {
            try {
                if (this.euH == null) {
                    z = false;
                } else {
                    z = this.euH.Mm();
                    AppMethodBeat.o(93062);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93062);
            }
        }
        return z;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(93063);
        if (this.euH != null) {
            this.euH.a(aVar);
        }
        AppMethodBeat.o(93063);
    }
}
