package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.plugin.appbrand.h.r;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d extends i {
    final String TAG = this.mName;
    final i gPI;
    final d gWB;
    final a gWC;
    final e gWD;
    final c gWE;
    final b gWF;
    public final AtomicBoolean gWG = new AtomicBoolean(false);
    private final AtomicBoolean gWH = new AtomicBoolean(false);
    private final AtomicReference<com.tencent.mm.sdk.d.c> gWI = new AtomicReference(null);
    private final AtomicReference<com.tencent.mm.sdk.d.c> gWJ = new AtomicReference(null);
    private com.tencent.mm.sdk.d.c gWK = null;

    final class e extends h {
        e(i iVar) {
            super(iVar);
        }

        public final String getName() {
            AppMethodBeat.i(86860);
            String str = d.this.mName + "|Suspend";
            AppMethodBeat.o(86860);
            return str;
        }

        public final void enter() {
            AppMethodBeat.i(86861);
            super.enter();
            d.this.xCt.sendEmptyMessageDelayed(11, ((long) d.this.gPI.ye().hhc) * 1000);
            r d = d.d(d.this);
            if (d != null) {
                d.pause();
                for (l lVar : d.this.gPI.xT().gPJ.gQj.ciF.values()) {
                    lVar.chO.pause();
                }
            }
            AppMethodBeat.o(86861);
        }

        public final void exit() {
            AppMethodBeat.i(86862);
            super.exit();
            d.this.xCt.removeMessages(11);
            AppMethodBeat.o(86862);
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(86863);
            switch (message.what) {
                case 3:
                    d.a(d.this, d.this.gWB);
                    AppMethodBeat.o(86863);
                    return true;
                case 11:
                    ab.i(d.this.TAG, "suspend timeout");
                    d.this.awy();
                    AppMethodBeat.o(86863);
                    return true;
                default:
                    boolean k = super.k(message);
                    AppMethodBeat.o(86863);
                    return k;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] gWN = new int[b.values().length];

        static {
            AppMethodBeat.i(86844);
            try {
                gWN[b.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWN[b.SUSPEND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gWN[b.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gWN[b.BACKGROUND.ordinal()] = 4;
                AppMethodBeat.o(86844);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(86844);
            }
        }
    }

    final class b extends h {
        b(i iVar) {
            super(iVar);
        }

        public final String getName() {
            AppMethodBeat.i(86850);
            String str = d.this.mName + "|BackgroundKeepNoChange";
            AppMethodBeat.o(86850);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(86851);
            switch (message.what) {
                case 3:
                    d.a(d.this, d.this.gWB);
                    AppMethodBeat.o(86851);
                    return true;
                default:
                    boolean k = super.k(message);
                    AppMethodBeat.o(86851);
                    return k;
            }
        }
    }

    final class d extends h {
        d(i iVar) {
            super(iVar);
        }

        public final String getName() {
            AppMethodBeat.i(86856);
            String str = d.this.mName + "|Foreground";
            AppMethodBeat.o(86856);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(86857);
            switch (message.what) {
                case 1:
                    d.a(d.this, d.this.gWC);
                    AppMethodBeat.o(86857);
                    return true;
                default:
                    boolean k = super.k(message);
                    AppMethodBeat.o(86857);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.i(86858);
            super.enter();
            r d = d.d(d.this);
            if (d != null) {
                d.resume();
                for (l lVar : d.this.gPI.xT().gPJ.gQj.ciF.values()) {
                    lVar.chO.resume();
                }
            }
            AppMethodBeat.o(86858);
        }

        public final void exit() {
            AppMethodBeat.i(86859);
            super.exit();
            AppMethodBeat.o(86859);
        }
    }

    final class a extends g {
        a(i iVar, i iVar2) {
            super(iVar, iVar2);
        }

        public final String getName() {
            AppMethodBeat.i(86845);
            String str = d.this.mName + "|Background";
            AppMethodBeat.o(86845);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(86846);
            switch (message.what) {
                case 3:
                    d.a(d.this, d.this.gWB);
                    AppMethodBeat.o(86846);
                    return true;
                case 12:
                    super.nu(16);
                    AppMethodBeat.o(86846);
                    return true;
                default:
                    boolean k = super.k(message);
                    AppMethodBeat.o(86846);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.i(86847);
            super.enter();
            AppMethodBeat.o(86847);
        }

        public final void exit() {
            AppMethodBeat.i(86848);
            super.exit();
            AppMethodBeat.o(86848);
        }

        /* Access modifiers changed, original: final */
        public final void awB() {
            AppMethodBeat.i(86849);
            if (d.this.dpQ() == this) {
                d.a(d.this, d.this.gWE);
                d.this.nt(1000);
            }
            AppMethodBeat.o(86849);
        }
    }

    final class c extends h {
        c(i iVar) {
            super(iVar);
        }

        public final String getName() {
            AppMethodBeat.i(86852);
            String str = d.this.mName + "|BackgroundTemporary";
            AppMethodBeat.o(86852);
            return str;
        }

        public final boolean k(Message message) {
            AppMethodBeat.i(86853);
            switch (message.what) {
                case 3:
                    d.a(d.this, d.this.gWB);
                    AppMethodBeat.o(86853);
                    return true;
                case 4:
                    RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    ab.i(d.this.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", Integer.valueOf(runningAppProcessInfo.importance));
                    if (runningAppProcessInfo.importance == 100) {
                        d.a(d.this, d.this.gWF);
                        AppMethodBeat.o(86853);
                        return true;
                    }
                    d.a(d.this, d.this.gWD);
                    AppMethodBeat.o(86853);
                    return true;
                case 10:
                    ab.i(d.this.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                    d.a(d.this, d.this.gWF);
                    AppMethodBeat.o(86853);
                    return true;
                default:
                    boolean k = super.k(message);
                    AppMethodBeat.o(86853);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.i(86854);
            super.enter();
            d.this.xCt.sendEmptyMessageDelayed(4, ((long) d.this.gPI.ye().hhb) * 1000);
            AppMethodBeat.o(86854);
        }

        public final void exit() {
            AppMethodBeat.i(86855);
            super.exit();
            d.this.xCt.removeMessages(4);
            AppMethodBeat.o(86855);
        }
    }

    public abstract void a(b bVar);

    public abstract void awy();

    d(i iVar) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + iVar.mAppId + "]", iVar.atd());
        this.gPI = iVar;
        this.gWE = new c(this);
        this.gWF = new b(this);
        this.gWC = new a(this, iVar);
        this.gWB = new d(this);
        this.gWD = new e(this);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(86837);
                d.this.a(d.this.gWE);
                d.this.a(d.this.gWF);
                d.this.a(d.this.gWC);
                d.this.a(d.this.gWB);
                d.this.a(d.this.gWD);
                d.this.b((com.tencent.mm.sdk.d.c) d.this.gWB);
                AppMethodBeat.o(86837);
            }
        };
        if (Looper.myLooper() == this.xCt.getLooper()) {
            anonymousClass1.run();
            return;
        }
        this.gWH.set(true);
        this.xCt.post(anonymousClass1);
    }

    public final void start() {
        if (!this.gWG.get()) {
            if (Looper.myLooper() == this.xCt.getLooper()) {
                super.start();
            } else {
                this.xCt.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(86838);
                        super.start();
                        AppMethodBeat.o(86838);
                    }
                });
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar) {
        this.gWI.set(null);
        this.gWJ.set(hVar);
        Message dpP = dpP();
        if (dpP == null || dpP.what != -2) {
            com.tencent.mm.sdk.d.a aVar = this.gWK;
            this.gWK = hVar;
            if (aVar != null && a(aVar) != a((com.tencent.mm.sdk.d.a) hVar)) {
                a(a((com.tencent.mm.sdk.d.a) hVar));
                return;
            }
            return;
        }
        this.gWK = hVar;
    }

    private b awA() {
        if (this.gWG.get()) {
            return b.DESTROYED;
        }
        com.tencent.mm.sdk.d.a aVar = (com.tencent.mm.sdk.d.c) this.gWI.get();
        if (aVar != null) {
            return a(aVar);
        }
        aVar = (com.tencent.mm.sdk.d.c) this.gWJ.get();
        if (aVar != null) {
            return a(aVar);
        }
        if (Thread.currentThread().getId() != this.xCt.getLooper().getThread().getId()) {
            aVar = (com.tencent.mm.sdk.d.a) new bj<com.tencent.mm.sdk.d.a>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(86840);
                    com.tencent.mm.sdk.d.a c = super.dpQ();
                    AppMethodBeat.o(86840);
                    return c;
                }
            }.b(new ak(this.xCt.getLooper()));
        } else {
            aVar = super.dpQ();
        }
        return a(aVar);
    }

    private b a(com.tencent.mm.sdk.d.a aVar) {
        if (aVar == this.gWC || aVar == this.gWE || aVar == this.gWF) {
            return b.BACKGROUND;
        }
        if (aVar == this.gWD) {
            return b.SUSPEND;
        }
        if (aVar == this.gWB) {
            return b.FOREGROUND;
        }
        return b.FOREGROUND;
    }

    public final void nt(int i) {
        this.gWH.set(true);
        if (dpP() == null) {
            super.sendMessage(i);
        } else {
            super.Mc(i);
        }
    }

    public final boolean i(Message message) {
        return message.what != 1000;
    }

    public final void j(Message message) {
        String str;
        super.j(message);
        com.tencent.mm.sdk.d.a dpQ = super.dpQ();
        String str2 = this.TAG;
        String str3 = "unhandledMessage(%d) state=%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(message.what);
        if (dpQ == null) {
            str = "NULL";
        } else {
            str = dpQ.getName();
        }
        objArr[1] = str;
        ab.i(str2, str3, objArr);
        this.gWH.set(false);
        if (3 == message.what && this.xCt.hasMessages(1)) {
            super.sendMessage(3);
        }
    }

    public final void avC() {
        super.avC();
        if (this.xCt.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.xCt.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(86843);
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            AppMethodBeat.i(86842);
                            Looper.myLooper().quit();
                            AppMethodBeat.o(86842);
                            return false;
                        }
                    });
                    AppMethodBeat.o(86843);
                }
            });
        }
    }

    public final b awz() {
        com.tencent.mm.sdk.d.d.c cVar = this.xCt;
        if (cVar == null) {
            return b.DESTROYED;
        }
        if (!this.gWH.get() || Thread.currentThread().getId() == cVar.getLooper().getThread().getId()) {
            return awA();
        }
        if (!al.isMainThread()) {
            return (b) new bj<b>() {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(86839);
                    b b = d.this.awA();
                    AppMethodBeat.o(86839);
                    return b;
                }
            }.b(new ak(cVar.getLooper()));
        }
        com.tencent.mm.sdk.d.a aVar = (com.tencent.mm.sdk.d.c) this.gWJ.get();
        ab.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", Long.valueOf(cVar.getLooper().getThread().getId()), aVar, Boolean.valueOf(this.gWG.get()));
        if (aVar != null) {
            return a(aVar);
        }
        return r2 ? b.DESTROYED : b.FOREGROUND;
    }

    static /* synthetic */ void a(d dVar, h hVar) {
        dVar.gWH.set(false);
        dVar.gWI.set(hVar);
        dVar.gWJ.set(null);
        super.b((com.tencent.mm.sdk.d.a) hVar);
    }

    static /* synthetic */ r d(d dVar) {
        if (dVar.gPI.xT() == null) {
            return null;
        }
        return (r) dVar.gPI.xT().aBx().af(r.class);
    }
}
