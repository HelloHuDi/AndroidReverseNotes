package com.tencent.p177mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.l */
public final class C19695l extends C4887d {
    final C19696a iAA = new C19696a(this, (byte) 0);
    private boolean iAB = false;
    long iAw;
    public long iAx;
    private final C19698c iAy = new C19698c(this, (byte) 0);
    final C19697b iAz = new C19697b(this, (byte) 0);
    public boolean mStopped = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.l$a */
    final class C19696a extends C42672h {
        private long iAC;

        private C19696a() {
        }

        /* synthetic */ C19696a(C19695l c19695l, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.m2504i(114395);
            String str = C19695l.this.mName + "|Background";
            AppMethodBeat.m2505o(114395);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(114396);
            if (2 == message.what) {
                C19695l.this.mo10075b((C4886a) C19695l.this.iAz);
                AppMethodBeat.m2505o(114396);
                return true;
            }
            boolean k = super.mo10090k(message);
            AppMethodBeat.m2505o(114396);
            return k;
        }

        public final void enter() {
            AppMethodBeat.m2504i(114397);
            super.enter();
            this.iAC = C5046bo.anU();
            AppMethodBeat.m2505o(114397);
        }

        public final void exit() {
            AppMethodBeat.m2504i(114398);
            super.exit();
            C19695l.this.iAw = C5046bo.anU() - this.iAC;
            AppMethodBeat.m2505o(114398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.l$b */
    final class C19697b extends C42672h {
        private long iAE;

        private C19697b() {
        }

        /* synthetic */ C19697b(C19695l c19695l, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.m2504i(114399);
            String str = C19695l.this.mName + "|Foreground";
            AppMethodBeat.m2505o(114399);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(114400);
            if (1 == message.what) {
                C19695l.this.mo10075b((C4886a) C19695l.this.iAA);
                AppMethodBeat.m2505o(114400);
                return true;
            }
            boolean k = super.mo10090k(message);
            AppMethodBeat.m2505o(114400);
            return k;
        }

        public final void enter() {
            AppMethodBeat.m2504i(114401);
            super.enter();
            this.iAE = C5046bo.anU();
            AppMethodBeat.m2505o(114401);
        }

        public final void exit() {
            AppMethodBeat.m2504i(114402);
            super.exit();
            C19695l.this.iAx = C5046bo.anU() - this.iAE;
            AppMethodBeat.m2505o(114402);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.l$c */
    final class C19698c extends C42672h {
        private C19698c() {
        }

        /* synthetic */ C19698c(C19695l c19695l, byte b) {
            this();
        }

        public final String getName() {
            AppMethodBeat.m2504i(114403);
            String str = C19695l.this.mName + "|Init";
            AppMethodBeat.m2505o(114403);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(114404);
            if (2 == message.what) {
                C19695l.this.mo10075b((C4886a) C19695l.this.iAz);
                AppMethodBeat.m2505o(114404);
                return true;
            } else if (1 == message.what) {
                C19695l.this.mo10075b((C4886a) C19695l.this.iAA);
                AppMethodBeat.m2505o(114404);
                return true;
            } else {
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(114404);
                return k;
            }
        }
    }

    public C19695l(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        AppMethodBeat.m2504i(114405);
        mo10073a(this.iAz);
        mo10073a(this.iAA);
        mo10073a(this.iAy);
        mo10076b((C7292c) this.iAy);
        AppMethodBeat.m2505o(114405);
    }

    public final boolean aLf() {
        AppMethodBeat.m2504i(114406);
        if (dpQ() == this.iAA || this.iAB) {
            AppMethodBeat.m2505o(114406);
            return true;
        }
        AppMethodBeat.m2505o(114406);
        return false;
    }

    /* renamed from: nt */
    private void m30517nt(int i) {
        AppMethodBeat.m2504i(114409);
        if (dpP() == null) {
            sendMessage(i);
            AppMethodBeat.m2505o(114409);
        } else if (Looper.myLooper() == this.xCt.getLooper()) {
            this.xCt.handleMessage(Message.obtain(this.xCt, i));
            AppMethodBeat.m2505o(114409);
        } else {
            mo10072Mc(i);
            AppMethodBeat.m2505o(114409);
        }
    }

    public final void start() {
        AppMethodBeat.m2504i(114410);
        if (this.mStopped) {
            AppMethodBeat.m2505o(114410);
            return;
        }
        super.start();
        AppMethodBeat.m2505o(114410);
    }

    public final void avC() {
        AppMethodBeat.m2504i(114411);
        super.avC();
        this.iAB = true;
        AppMethodBeat.m2505o(114411);
    }

    public final void aLg() {
        AppMethodBeat.m2504i(114407);
        C4990ab.m7410d(this.mName, "toForeground");
        m30517nt(2);
        AppMethodBeat.m2505o(114407);
    }

    public final void aLh() {
        AppMethodBeat.m2504i(114408);
        C4990ab.m7410d(this.mName, "toBackground");
        m30517nt(1);
        AppMethodBeat.m2505o(114408);
    }
}
