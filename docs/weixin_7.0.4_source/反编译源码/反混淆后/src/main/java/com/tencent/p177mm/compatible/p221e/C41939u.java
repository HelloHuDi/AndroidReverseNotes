package com.tencent.p177mm.compatible.p221e;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.mm.compatible.e.u */
public final class C41939u {
    private static final Object etw = new Object();

    /* renamed from: c */
    public static C41938t m74076c(Looper looper) {
        AppMethodBeat.m2504i(93009);
        Camera open = Camera.open();
        C41938t c41938t;
        if (looper == null) {
            c41938t = new C41938t(open);
            AppMethodBeat.m2505o(93009);
            return c41938t;
        }
        C41939u.m74073a(open);
        c41938t = new C41938t(open);
        AppMethodBeat.m2505o(93009);
        return c41938t;
    }

    static {
        AppMethodBeat.m2504i(93013);
        AppMethodBeat.m2505o(93013);
    }

    /* renamed from: b */
    public static C41938t m74074b(final int i, Looper looper) {
        AppMethodBeat.m2504i(93010);
        C41938t c41938t;
        if (C1443d.m3068iW(28)) {
            try {
                c41938t = new C41938t(C41939u.m74075c(i, looper));
                AppMethodBeat.m2505o(93010);
                return c41938t;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMCamera", e, "opnImpl error, try camera directly, myLooper: %s", Looper.myLooper());
                if (Looper.myLooper() == null) {
                    final Camera[] cameraArr = new Camera[]{null};
                    C7305d.m12301h(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(93008);
                            cameraArr[0] = Camera.open(i);
                            synchronized (C41939u.etw) {
                                try {
                                    C41939u.etw.notifyAll();
                                    C4990ab.m7416i("MicroMsg.MMCamera", "openCamera notifyAll");
                                } catch (Exception e) {
                                    C4990ab.printErrStackTrace("MicroMsg.MMCamera", e, "MMCamera_openLooperNull notify error", new Object[0]);
                                } catch (Throwable th) {
                                    AppMethodBeat.m2505o(93008);
                                }
                            }
                            AppMethodBeat.m2505o(93008);
                        }
                    }, "MMCamera_openLooperNull").start();
                    synchronized (etw) {
                        try {
                            etw.wait();
                            C4990ab.m7416i("MicroMsg.MMCamera", "openCamera wait finish");
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.MMCamera", e2, "MMCamera_openLooperNull wait error", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(93010);
                        }
                        c41938t = new C41938t(cameraArr[0]);
                        AppMethodBeat.m2505o(93010);
                        return c41938t;
                    }
                }
                c41938t = new C41938t(Camera.open(i));
                AppMethodBeat.m2505o(93010);
                return c41938t;
            }
        }
        c41938t = new C41938t(C41939u.m74075c(i, looper));
        AppMethodBeat.m2505o(93010);
        return c41938t;
    }

    /* renamed from: c */
    private static Camera m74075c(int i, Looper looper) {
        AppMethodBeat.m2504i(93011);
        Camera open = Camera.open(i);
        if (looper == null) {
            AppMethodBeat.m2505o(93011);
        } else {
            C41939u.m74073a(open);
            AppMethodBeat.m2505o(93011);
        }
        return open;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m74073a(Camera camera) {
        Throwable th;
        NoSuchFieldException noSuchFieldException;
        AppMethodBeat.m2504i(93012);
        try {
            Field declaredField = Camera.class.getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            Constructor constructor = null;
            for (Class cls : Camera.class.getDeclaredClasses()) {
                if (cls.getName().endsWith("EventHandler")) {
                    constructor = cls.getConstructors()[0];
                    constructor.setAccessible(true);
                    break;
                }
            }
            declaredField.set(camera, (Handler) constructor.newInstance(new Object[]{camera, camera, Looper.getMainLooper()}));
            AppMethodBeat.m2505o(93012);
        } catch (NoSuchFieldException e) {
            C4990ab.m7409c("MicroMsg.MMCamera", "%s", e);
            C7053e.pXa.mo8378a(950, 200, 1, false);
            AppMethodBeat.m2505o(93012);
        } catch (IllegalAccessException e2) {
            C4990ab.m7409c("MicroMsg.MMCamera", "%s", e2);
            C7053e.pXa.mo8378a(950, 200, 1, false);
            AppMethodBeat.m2505o(93012);
        } catch (InvocationTargetException e3) {
            C4990ab.m7409c("MicroMsg.MMCamera", "%s", e3);
            AppMethodBeat.m2505o(93012);
        } catch (InstantiationException e4) {
            C4990ab.m7409c("MicroMsg.MMCamera", "%s", e4);
            AppMethodBeat.m2505o(93012);
        } catch (Throwable th2) {
            th = th2;
            noSuchFieldException = null;
            if (noSuchFieldException != null) {
            }
            AppMethodBeat.m2505o(93012);
            throw th;
        }
    }
}
