package com.tencent.p177mm.plugin.appbrand.p281b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p297h.C26902r;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d.C4890c;
import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.mm.plugin.appbrand.b.d */
public abstract class C26788d extends C45525i {
    final String TAG = this.mName;
    final C6750i gPI;
    final C26792d gWB;
    final C26793a gWC;
    final C26787e gWD;
    final C26794c gWE;
    final C26791b gWF;
    public final AtomicBoolean gWG = new AtomicBoolean(false);
    private final AtomicBoolean gWH = new AtomicBoolean(false);
    private final AtomicReference<C7292c> gWI = new AtomicReference(null);
    private final AtomicReference<C7292c> gWJ = new AtomicReference(null);
    private C7292c gWK = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$1 */
    class C20881 implements Runnable {
        C20881() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86837);
            C26788d.this.mo10073a(C26788d.this.gWE);
            C26788d.this.mo10073a(C26788d.this.gWF);
            C26788d.this.mo10073a(C26788d.this.gWC);
            C26788d.this.mo10073a(C26788d.this.gWB);
            C26788d.this.mo10073a(C26788d.this.gWD);
            C26788d.this.mo10076b((C7292c) C26788d.this.gWB);
            AppMethodBeat.m2505o(86837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$2 */
    class C20892 implements Runnable {
        C20892() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86838);
            super.start();
            AppMethodBeat.m2505o(86838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$3 */
    class C67423 extends C5039bj<C45524b> {
        C67423() {
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(86839);
            C45524b b = C26788d.this.awA();
            AppMethodBeat.m2505o(86839);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$4 */
    class C67434 extends C5039bj<C4886a> {
        C67434() {
        }

        public final /* synthetic */ Object run() {
            AppMethodBeat.m2504i(86840);
            C4886a c = super.dpQ();
            AppMethodBeat.m2505o(86840);
            return c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$5 */
    class C101395 extends C5039bj<Boolean> {
        C101395() {
        }

        /* JADX WARNING: Missing block: B:5:0x001f, code skipped:
            if (r2 != false) goto L_0x0021;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object run() {
            boolean z = true;
            AppMethodBeat.m2504i(86841);
            if (C26788d.this.dpQ() == C26788d.this.gWC) {
                boolean z2;
                if ((C26788d.this.gWC.gWW & 1) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            z = false;
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(86841);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$e */
    final class C26787e extends C38138h {
        C26787e(C45525i c45525i) {
            super(c45525i);
        }

        public final String getName() {
            AppMethodBeat.m2504i(86860);
            String str = C26788d.this.mName + "|Suspend";
            AppMethodBeat.m2505o(86860);
            return str;
        }

        public final void enter() {
            AppMethodBeat.m2504i(86861);
            super.enter();
            C26788d.this.xCt.sendEmptyMessageDelayed(11, ((long) C26788d.this.gPI.mo15034ye().hhc) * 1000);
            C26902r d = C26788d.m42638d(C26788d.this);
            if (d != null) {
                d.pause();
                for (C32488l c32488l : C26788d.this.gPI.mo15032xT().gPJ.gQj.ciF.values()) {
                    c32488l.chO.pause();
                }
            }
            AppMethodBeat.m2505o(86861);
        }

        public final void exit() {
            AppMethodBeat.m2504i(86862);
            super.exit();
            C26788d.this.xCt.removeMessages(11);
            AppMethodBeat.m2505o(86862);
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(86863);
            switch (message.what) {
                case 3:
                    C26788d.m42635a(C26788d.this, C26788d.this.gWB);
                    AppMethodBeat.m2505o(86863);
                    return true;
                case 11:
                    C4990ab.m7416i(C26788d.this.TAG, "suspend timeout");
                    C26788d.this.awy();
                    AppMethodBeat.m2505o(86863);
                    return true;
                default:
                    boolean k = super.mo10090k(message);
                    AppMethodBeat.m2505o(86863);
                    return k;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$6 */
    class C267896 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.b.d$6$1 */
        class C267861 implements IdleHandler {
            C267861() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(86842);
                Looper.myLooper().quit();
                AppMethodBeat.m2505o(86842);
                return false;
            }
        }

        C267896() {
        }

        public final void run() {
            AppMethodBeat.m2504i(86843);
            Looper.myQueue().addIdleHandler(new C267861());
            AppMethodBeat.m2505o(86843);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$7 */
    static /* synthetic */ class C267907 {
        static final /* synthetic */ int[] gWN = new int[C45524b.values().length];

        static {
            AppMethodBeat.m2504i(86844);
            try {
                gWN[C45524b.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWN[C45524b.SUSPEND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gWN[C45524b.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gWN[C45524b.BACKGROUND.ordinal()] = 4;
                AppMethodBeat.m2505o(86844);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.m2505o(86844);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$b */
    final class C26791b extends C38138h {
        C26791b(C45525i c45525i) {
            super(c45525i);
        }

        public final String getName() {
            AppMethodBeat.m2504i(86850);
            String str = C26788d.this.mName + "|BackgroundKeepNoChange";
            AppMethodBeat.m2505o(86850);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(86851);
            switch (message.what) {
                case 3:
                    C26788d.m42635a(C26788d.this, C26788d.this.gWB);
                    AppMethodBeat.m2505o(86851);
                    return true;
                default:
                    boolean k = super.mo10090k(message);
                    AppMethodBeat.m2505o(86851);
                    return k;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$d */
    final class C26792d extends C38138h {
        C26792d(C45525i c45525i) {
            super(c45525i);
        }

        public final String getName() {
            AppMethodBeat.m2504i(86856);
            String str = C26788d.this.mName + "|Foreground";
            AppMethodBeat.m2505o(86856);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(86857);
            switch (message.what) {
                case 1:
                    C26788d.m42635a(C26788d.this, C26788d.this.gWC);
                    AppMethodBeat.m2505o(86857);
                    return true;
                default:
                    boolean k = super.mo10090k(message);
                    AppMethodBeat.m2505o(86857);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.m2504i(86858);
            super.enter();
            C26902r d = C26788d.m42638d(C26788d.this);
            if (d != null) {
                d.resume();
                for (C32488l c32488l : C26788d.this.gPI.mo15032xT().gPJ.gQj.ciF.values()) {
                    c32488l.chO.resume();
                }
            }
            AppMethodBeat.m2505o(86858);
        }

        public final void exit() {
            AppMethodBeat.m2504i(86859);
            super.exit();
            AppMethodBeat.m2505o(86859);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$a */
    final class C26793a extends C26795g {
        C26793a(C45525i c45525i, C6750i c6750i) {
            super(c45525i, c6750i);
        }

        public final String getName() {
            AppMethodBeat.m2504i(86845);
            String str = C26788d.this.mName + "|Background";
            AppMethodBeat.m2505o(86845);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(86846);
            switch (message.what) {
                case 3:
                    C26788d.m42635a(C26788d.this, C26788d.this.gWB);
                    AppMethodBeat.m2505o(86846);
                    return true;
                case 12:
                    super.mo44563nu(16);
                    AppMethodBeat.m2505o(86846);
                    return true;
                default:
                    boolean k = super.mo10090k(message);
                    AppMethodBeat.m2505o(86846);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.m2504i(86847);
            super.enter();
            AppMethodBeat.m2505o(86847);
        }

        public final void exit() {
            AppMethodBeat.m2504i(86848);
            super.exit();
            AppMethodBeat.m2505o(86848);
        }

        /* Access modifiers changed, original: final */
        public final void awB() {
            AppMethodBeat.m2504i(86849);
            if (C26788d.this.dpQ() == this) {
                C26788d.m42635a(C26788d.this, C26788d.this.gWE);
                C26788d.this.mo44560nt(1000);
            }
            AppMethodBeat.m2505o(86849);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.b.d$c */
    final class C26794c extends C38138h {
        C26794c(C45525i c45525i) {
            super(c45525i);
        }

        public final String getName() {
            AppMethodBeat.m2504i(86852);
            String str = C26788d.this.mName + "|BackgroundTemporary";
            AppMethodBeat.m2505o(86852);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(86853);
            switch (message.what) {
                case 3:
                    C26788d.m42635a(C26788d.this, C26788d.this.gWB);
                    AppMethodBeat.m2505o(86853);
                    return true;
                case 4:
                    RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    C4990ab.m7417i(C26788d.this.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", Integer.valueOf(runningAppProcessInfo.importance));
                    if (runningAppProcessInfo.importance == 100) {
                        C26788d.m42635a(C26788d.this, C26788d.this.gWF);
                        AppMethodBeat.m2505o(86853);
                        return true;
                    }
                    C26788d.m42635a(C26788d.this, C26788d.this.gWD);
                    AppMethodBeat.m2505o(86853);
                    return true;
                case 10:
                    C4990ab.m7416i(C26788d.this.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                    C26788d.m42635a(C26788d.this, C26788d.this.gWF);
                    AppMethodBeat.m2505o(86853);
                    return true;
                default:
                    boolean k = super.mo10090k(message);
                    AppMethodBeat.m2505o(86853);
                    return k;
            }
        }

        public final void enter() {
            AppMethodBeat.m2504i(86854);
            super.enter();
            C26788d.this.xCt.sendEmptyMessageDelayed(4, ((long) C26788d.this.gPI.mo15034ye().hhb) * 1000);
            AppMethodBeat.m2505o(86854);
        }

        public final void exit() {
            AppMethodBeat.m2504i(86855);
            super.exit();
            C26788d.this.xCt.removeMessages(4);
            AppMethodBeat.m2505o(86855);
        }
    }

    /* renamed from: a */
    public abstract void mo21489a(C45524b c45524b);

    public abstract void awy();

    C26788d(C6750i c6750i) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + c6750i.mAppId + "]", c6750i.atd());
        this.gPI = c6750i;
        this.gWE = new C26794c(this);
        this.gWF = new C26791b(this);
        this.gWC = new C26793a(this, c6750i);
        this.gWB = new C26792d(this);
        this.gWD = new C26787e(this);
        C20881 c20881 = new C20881();
        if (Looper.myLooper() == this.xCt.getLooper()) {
            c20881.run();
            return;
        }
        this.gWH.set(true);
        this.xCt.post(c20881);
    }

    public final void start() {
        if (!this.gWG.get()) {
            if (Looper.myLooper() == this.xCt.getLooper()) {
                super.start();
            } else {
                this.xCt.post(new C20892());
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo44558a(C38138h c38138h) {
        this.gWI.set(null);
        this.gWJ.set(c38138h);
        Message dpP = dpP();
        if (dpP == null || dpP.what != -2) {
            C4886a c4886a = this.gWK;
            this.gWK = c38138h;
            if (c4886a != null && m42633a(c4886a) != m42633a((C4886a) c38138h)) {
                mo21489a(m42633a((C4886a) c38138h));
                return;
            }
            return;
        }
        this.gWK = c38138h;
    }

    private C45524b awA() {
        if (this.gWG.get()) {
            return C45524b.DESTROYED;
        }
        C4886a c4886a = (C7292c) this.gWI.get();
        if (c4886a != null) {
            return m42633a(c4886a);
        }
        c4886a = (C7292c) this.gWJ.get();
        if (c4886a != null) {
            return m42633a(c4886a);
        }
        if (Thread.currentThread().getId() != this.xCt.getLooper().getThread().getId()) {
            c4886a = (C4886a) new C67434().mo10372b(new C7306ak(this.xCt.getLooper()));
        } else {
            c4886a = super.dpQ();
        }
        return m42633a(c4886a);
    }

    /* renamed from: a */
    private C45524b m42633a(C4886a c4886a) {
        if (c4886a == this.gWC || c4886a == this.gWE || c4886a == this.gWF) {
            return C45524b.BACKGROUND;
        }
        if (c4886a == this.gWD) {
            return C45524b.SUSPEND;
        }
        if (c4886a == this.gWB) {
            return C45524b.FOREGROUND;
        }
        return C45524b.FOREGROUND;
    }

    /* renamed from: nt */
    public final void mo44560nt(int i) {
        this.gWH.set(true);
        if (dpP() == null) {
            super.sendMessage(i);
        } else {
            super.mo10072Mc(i);
        }
    }

    /* renamed from: i */
    public final boolean mo10079i(Message message) {
        return message.what != 1000;
    }

    /* renamed from: j */
    public final void mo10080j(Message message) {
        String str;
        super.mo10080j(message);
        C4886a dpQ = super.dpQ();
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
        C4990ab.m7417i(str2, str3, objArr);
        this.gWH.set(false);
        if (3 == message.what && this.xCt.hasMessages(1)) {
            super.sendMessage(3);
        }
    }

    public final void avC() {
        super.avC();
        if (this.xCt.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.xCt.post(new C267896());
        }
    }

    public final C45524b awz() {
        C4890c c4890c = this.xCt;
        if (c4890c == null) {
            return C45524b.DESTROYED;
        }
        if (!this.gWH.get() || Thread.currentThread().getId() == c4890c.getLooper().getThread().getId()) {
            return awA();
        }
        if (!C5004al.isMainThread()) {
            return (C45524b) new C67423().mo10372b(new C7306ak(c4890c.getLooper()));
        }
        C4886a c4886a = (C7292c) this.gWJ.get();
        C4990ab.m7417i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", Long.valueOf(c4890c.getLooper().getThread().getId()), c4886a, Boolean.valueOf(this.gWG.get()));
        if (c4886a != null) {
            return m42633a(c4886a);
        }
        return r2 ? C45524b.DESTROYED : C45524b.FOREGROUND;
    }

    /* renamed from: a */
    static /* synthetic */ void m42635a(C26788d c26788d, C38138h c38138h) {
        c26788d.gWH.set(false);
        c26788d.gWI.set(c38138h);
        c26788d.gWJ.set(null);
        super.mo10075b((C4886a) c38138h);
    }

    /* renamed from: d */
    static /* synthetic */ C26902r m42638d(C26788d c26788d) {
        if (c26788d.gPI.mo15032xT() == null) {
            return null;
        }
        return (C26902r) c26788d.gPI.mo15032xT().aBx().mo14970af(C26902r.class);
    }
}
