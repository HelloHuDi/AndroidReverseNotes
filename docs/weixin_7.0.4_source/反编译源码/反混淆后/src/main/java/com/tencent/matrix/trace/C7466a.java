package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1068b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.C1145a;
import com.tencent.matrix.trace.core.C1148b;
import com.tencent.matrix.trace.core.C1148b.C11491;
import com.tencent.matrix.trace.core.C1148b.C11502;
import com.tencent.matrix.trace.p170a.C1133a;
import com.tencent.matrix.trace.p175f.C7467a;
import com.tencent.matrix.trace.p175f.C7468b;
import com.tencent.matrix.trace.p175f.C7469c;
import com.tencent.matrix.trace.p175f.C7470d;

/* renamed from: com.tencent.matrix.trace.a */
public class C7466a extends C6283b {
    private final C1133a bYu;
    public C7468b bYv;
    public C7470d bYw;
    public C7469c bYx;
    private C7467a bYy;

    /* renamed from: com.tencent.matrix.trace.a$1 */
    class C11301 implements Runnable {
        C11301() {
        }

        public final void run() {
            boolean z = true;
            if (!C1148b.m2518zx().bZi) {
                C1148b zx = C1148b.m2518zx();
                C1133a a = C7466a.this.bYu;
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    throw new AssertionError("must be init in main thread!");
                }
                boolean z2;
                zx.bZi = true;
                zx.bYH = a;
                zx.bsZ = Choreographer.getInstance();
                zx.bYZ = C1148b.reflectObject(zx.bsZ, "mLock");
                zx.bZa = (Object[]) C1148b.reflectObject(zx.bsZ, "mCallbackQueues");
                zx.bZc = C1148b.m2515d(zx.bZa[0], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                zx.bZd = C1148b.m2515d(zx.bZa[1], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                zx.bZb = C1148b.m2515d(zx.bZa[2], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                zx.bZe = ((Long) C1148b.reflectObject(zx.bsZ, "mFrameIntervalNanos")).longValue();
                C1145a.m2506a(new C11491());
                if (a.bYE) {
                    zx.mo4376a(new C11502());
                }
                String str = "Matrix.UIThreadMonitor";
                String str2 = "[UIThreadMonitor] %s %s %s %s %s frameIntervalNanos:%s";
                Object[] objArr = new Object[6];
                if (zx.bYZ == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                if (zx.bZa == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[1] = Boolean.valueOf(z2);
                if (zx.bZc == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[2] = Boolean.valueOf(z2);
                if (zx.bZb == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                if (zx.bZd != null) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                objArr[5] = Long.valueOf(zx.bZe);
                C1070c.m2368i(str, str2, objArr);
            }
            AppMethodBeat.getInstance().onStart();
            C1148b.m2518zx().onStart();
            C7466a.this.bYy.mo14535zE();
            C7466a.this.bYx.mo14535zE();
            C7466a.this.bYv.mo14535zE();
            C7466a.this.bYw.mo14535zE();
        }
    }

    /* renamed from: com.tencent.matrix.trace.a$2 */
    class C11312 implements Runnable {
        C11312() {
        }

        public final void run() {
            AppMethodBeat.getInstance().onStop();
            C1148b.m2518zx().onStop();
            C7466a.this.bYy.mo14536zF();
            C7466a.this.bYx.mo14536zF();
            C7466a.this.bYv.mo14536zF();
            C7466a.this.bYw.mo14536zF();
        }
    }

    public C7466a(C1133a c1133a) {
        this.bYu = c1133a;
    }

    public void init(Application application, C1061c c1061c) {
        super.init(application, c1061c);
        C1070c.m2368i("Matrix.TracePlugin", "trace plugin init, trace config: %s", this.bYu.toString());
        if (VERSION.SDK_INT < 16) {
            C1070c.m2367e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.bYy = new C7467a(this.bYu);
        this.bYx = new C7469c(this.bYu);
        this.bYv = new C7468b(this.bYu);
        this.bYw = new C7470d(this.bYu);
    }

    public void start() {
        super.start();
        if (isSupported()) {
            C1070c.m2370w("Matrix.TracePlugin", "start!", new Object[0]);
            C11301 c11301 = new C11301();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                c11301.run();
                return;
            }
            C1070c.m2370w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            C1068b.m2357zK().post(c11301);
            return;
        }
        C1070c.m2370w("Matrix.TracePlugin", "[start] Plugin is unSupported!", new Object[0]);
    }

    public void stop() {
        super.stop();
        if (isSupported()) {
            C1070c.m2370w("Matrix.TracePlugin", "stop!", new Object[0]);
            C11312 c11312 = new C11312();
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                c11312.run();
                return;
            }
            C1070c.m2370w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            C1068b.m2357zK().post(c11312);
            return;
        }
        C1070c.m2370w("Matrix.TracePlugin", "[stop] Plugin is unSupported!", new Object[0]);
    }

    public void onForeground(boolean z) {
        super.onForeground(z);
        if (isSupported() && this.bYx != null) {
            this.bYx.onForeground(z);
        }
    }

    public void destroy() {
        super.destroy();
    }

    public String getTag() {
        return "Trace";
    }

    /* renamed from: zv */
    public static AppMethodBeat m12838zv() {
        return AppMethodBeat.getInstance();
    }
}
