package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class l extends d {
    Bundle fPq;
    final b hKU;
    public a hKV;
    final c hKW = new c() {
        public final String getName() {
            AppMethodBeat.i(93827);
            String str = l.this.mName + "$StateListening";
            AppMethodBeat.o(93827);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(93828);
            if (1 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.hKX);
                AppMethodBeat.o(93828);
                return true;
            }
            boolean k = super.k(message);
            AppMethodBeat.o(93828);
            return k;
        }

        public final void enter() {
            AppMethodBeat.i(93829);
            super.enter();
            ((com.tencent.mm.plugin.appbrand.s.b.a) e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).c("gcj02", l.this.hKU, l.this.fPq);
            if (l.this.hKV != null) {
                l.this.hKV.Bb("StateNotListening");
            }
            AppMethodBeat.o(93829);
        }
    };
    final c hKX = new c() {
        public final String getName() {
            AppMethodBeat.i(93830);
            String str = l.this.mName + "$StateNotListening";
            AppMethodBeat.o(93830);
            return str;
        }

        public final void enter() {
            AppMethodBeat.i(93831);
            super.enter();
            ((com.tencent.mm.plugin.appbrand.s.b.a) e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).b("gcj02", l.this.hKU, l.this.fPq);
            if (l.this.hKV != null) {
                l.this.hKV.Bb("StateListening");
            }
            AppMethodBeat.o(93831);
        }

        public final void exit() {
            AppMethodBeat.i(93832);
            super.exit();
            ((com.tencent.mm.plugin.appbrand.s.b.a) e.B(com.tencent.mm.plugin.appbrand.s.b.a.class)).c("gcj02", l.this.hKU, l.this.fPq);
            AppMethodBeat.o(93832);
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(93833);
            if (2 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.hKW);
                AppMethodBeat.o(93833);
                return true;
            } else if (3 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.hKY);
                AppMethodBeat.o(93833);
                return true;
            } else {
                boolean k = super.k(message);
                AppMethodBeat.o(93833);
                return k;
            }
        }
    };
    final c hKY = new c() {
        public final String getName() {
            AppMethodBeat.i(93834);
            String str = l.this.mName + "$StateSuspend";
            AppMethodBeat.o(93834);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(93835);
            if (2 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.hKW);
                AppMethodBeat.o(93835);
                return true;
            } else if (4 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.hKX);
                AppMethodBeat.o(93835);
                return true;
            } else {
                boolean k = super.k(message);
                AppMethodBeat.o(93835);
                return k;
            }
        }

        public final void enter() {
            AppMethodBeat.i(93836);
            super.enter();
            if (l.this.hKV != null) {
                l.this.hKV.Bb("StateSuspend");
            }
            AppMethodBeat.o(93836);
        }
    };

    public interface a {
        void Bb(String str);
    }

    l(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        super("RuntimeLocationUpdateStateManager[" + cVar.getAppId() + "]", Looper.getMainLooper());
        AppMethodBeat.i(93837);
        this.hKU = new b(cVar);
        a(this.hKW);
        a(this.hKX);
        a(this.hKY);
        b(this.hKW);
        AppMethodBeat.o(93837);
    }
}
