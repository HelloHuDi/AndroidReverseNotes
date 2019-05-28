package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l extends d {
    final a iAA = new a(this, (byte) 0);
    private boolean iAB = false;
    long iAw;
    public long iAx;
    private final c iAy = new c(this, (byte) 0);
    final b iAz = new b(this, (byte) 0);
    public boolean mStopped = false;

    final class a extends h {
        private long iAC;

        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.i(114395);
            String str = l.this.mName + "|Background";
            AppMethodBeat.o(114395);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(114396);
            if (2 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.iAz);
                AppMethodBeat.o(114396);
                return true;
            }
            boolean k = super.k(message);
            AppMethodBeat.o(114396);
            return k;
        }

        public final void enter() {
            AppMethodBeat.i(114397);
            super.enter();
            this.iAC = bo.anU();
            AppMethodBeat.o(114397);
        }

        public final void exit() {
            AppMethodBeat.i(114398);
            super.exit();
            l.this.iAw = bo.anU() - this.iAC;
            AppMethodBeat.o(114398);
        }
    }

    final class b extends h {
        private long iAE;

        private b() {
        }

        /* synthetic */ b(l lVar, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.i(114399);
            String str = l.this.mName + "|Foreground";
            AppMethodBeat.o(114399);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(114400);
            if (1 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.iAA);
                AppMethodBeat.o(114400);
                return true;
            }
            boolean k = super.k(message);
            AppMethodBeat.o(114400);
            return k;
        }

        public final void enter() {
            AppMethodBeat.i(114401);
            super.enter();
            this.iAE = bo.anU();
            AppMethodBeat.o(114401);
        }

        public final void exit() {
            AppMethodBeat.i(114402);
            super.exit();
            l.this.iAx = bo.anU() - this.iAE;
            AppMethodBeat.o(114402);
        }
    }

    final class c extends h {
        private c() {
        }

        /* synthetic */ c(l lVar, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.i(114403);
            String str = l.this.mName + "|Init";
            AppMethodBeat.o(114403);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(114404);
            if (2 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.iAz);
                AppMethodBeat.o(114404);
                return true;
            } else if (1 == message.what) {
                l.this.b((com.tencent.mm.sdk.d.a) l.this.iAA);
                AppMethodBeat.o(114404);
                return true;
            } else {
                boolean k = super.k(message);
                AppMethodBeat.o(114404);
                return k;
            }
        }
    }

    public l(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        AppMethodBeat.i(114405);
        a(this.iAz);
        a(this.iAA);
        a(this.iAy);
        b((com.tencent.mm.sdk.d.c) this.iAy);
        AppMethodBeat.o(114405);
    }

    public final boolean aLf() {
        AppMethodBeat.i(114406);
        if (dpQ() == this.iAA || this.iAB) {
            AppMethodBeat.o(114406);
            return true;
        }
        AppMethodBeat.o(114406);
        return false;
    }

    private void nt(int i) {
        AppMethodBeat.i(114409);
        if (dpP() == null) {
            sendMessage(i);
            AppMethodBeat.o(114409);
        } else if (Looper.myLooper() == this.xCt.getLooper()) {
            this.xCt.handleMessage(Message.obtain(this.xCt, i));
            AppMethodBeat.o(114409);
        } else {
            Mc(i);
            AppMethodBeat.o(114409);
        }
    }

    public final void start() {
        AppMethodBeat.i(114410);
        if (this.mStopped) {
            AppMethodBeat.o(114410);
            return;
        }
        super.start();
        AppMethodBeat.o(114410);
    }

    public final void avC() {
        AppMethodBeat.i(114411);
        super.avC();
        this.iAB = true;
        AppMethodBeat.o(114411);
    }

    public final void aLg() {
        AppMethodBeat.i(114407);
        ab.d(this.mName, "toForeground");
        nt(2);
        AppMethodBeat.o(114407);
    }

    public final void aLh() {
        AppMethodBeat.i(114408);
        ab.d(this.mName, "toBackground");
        nt(1);
        AppMethodBeat.o(114408);
    }
}
