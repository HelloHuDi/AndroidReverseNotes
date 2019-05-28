package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.d;

public class a extends b {
    private final com.tencent.matrix.trace.a.a bYu;
    public com.tencent.matrix.trace.f.b bYv;
    public d bYw;
    public c bYx;
    private com.tencent.matrix.trace.f.a bYy;

    public a(com.tencent.matrix.trace.a.a aVar) {
        this.bYu = aVar;
    }

    public void init(Application application, com.tencent.matrix.b.c cVar) {
        super.init(application, cVar);
        com.tencent.matrix.d.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", this.bYu.toString());
        if (VERSION.SDK_INT < 16) {
            com.tencent.matrix.d.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.bYy = new com.tencent.matrix.trace.f.a(this.bYu);
        this.bYx = new c(this.bYu);
        this.bYv = new com.tencent.matrix.trace.f.b(this.bYu);
        this.bYw = new d(this.bYu);
    }

    public void start() {
        super.start();
        if (isSupported()) {
            com.tencent.matrix.d.c.w("Matrix.TracePlugin", "start!", new Object[0]);
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    boolean z = true;
                    if (!com.tencent.matrix.trace.core.b.zx().bZi) {
                        com.tencent.matrix.trace.core.b zx = com.tencent.matrix.trace.core.b.zx();
                        com.tencent.matrix.trace.a.a a = a.this.bYu;
                        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                            throw new AssertionError("must be init in main thread!");
                        }
                        boolean z2;
                        zx.bZi = true;
                        zx.bYH = a;
                        zx.bsZ = Choreographer.getInstance();
                        zx.bYZ = com.tencent.matrix.trace.core.b.reflectObject(zx.bsZ, "mLock");
                        zx.bZa = (Object[]) com.tencent.matrix.trace.core.b.reflectObject(zx.bsZ, "mCallbackQueues");
                        zx.bZc = com.tencent.matrix.trace.core.b.d(zx.bZa[0], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                        zx.bZd = com.tencent.matrix.trace.core.b.d(zx.bZa[1], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                        zx.bZb = com.tencent.matrix.trace.core.b.d(zx.bZa[2], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                        zx.bZe = ((Long) com.tencent.matrix.trace.core.b.reflectObject(zx.bsZ, "mFrameIntervalNanos")).longValue();
                        com.tencent.matrix.trace.core.a.a(new com.tencent.matrix.trace.core.a.a() {
                            public final boolean isValid() {
                                return b.this.bYT;
                            }

                            public final void dispatchStart() {
                                super.dispatchStart();
                                b.b(b.this);
                            }

                            public final void dispatchEnd() {
                                super.dispatchEnd();
                                b.c(b.this);
                            }
                        });
                        if (a.bYE) {
                            zx.a(new com.tencent.matrix.trace.e.c() {
                                public final void a(String str, long j, long j2, long j3, long j4) {
                                    com.tencent.matrix.d.c.i("Matrix.UIThreadMonitor", "activityName[%s] frame cost:%sms [%s|%s|%s]ns", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
                                }
                            });
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
                        com.tencent.matrix.d.c.i(str, str2, objArr);
                    }
                    AppMethodBeat.getInstance().onStart();
                    com.tencent.matrix.trace.core.b.zx().onStart();
                    a.this.bYy.zE();
                    a.this.bYx.zE();
                    a.this.bYv.zE();
                    a.this.bYw.zE();
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                anonymousClass1.run();
                return;
            }
            com.tencent.matrix.d.c.w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            com.tencent.matrix.d.b.zK().post(anonymousClass1);
            return;
        }
        com.tencent.matrix.d.c.w("Matrix.TracePlugin", "[start] Plugin is unSupported!", new Object[0]);
    }

    public void stop() {
        super.stop();
        if (isSupported()) {
            com.tencent.matrix.d.c.w("Matrix.TracePlugin", "stop!", new Object[0]);
            AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.getInstance().onStop();
                    com.tencent.matrix.trace.core.b.zx().onStop();
                    a.this.bYy.zF();
                    a.this.bYx.zF();
                    a.this.bYv.zF();
                    a.this.bYw.zF();
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                anonymousClass2.run();
                return;
            }
            com.tencent.matrix.d.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
            com.tencent.matrix.d.b.zK().post(anonymousClass2);
            return;
        }
        com.tencent.matrix.d.c.w("Matrix.TracePlugin", "[stop] Plugin is unSupported!", new Object[0]);
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

    public static AppMethodBeat zv() {
        return AppMethodBeat.getInstance();
    }
}
