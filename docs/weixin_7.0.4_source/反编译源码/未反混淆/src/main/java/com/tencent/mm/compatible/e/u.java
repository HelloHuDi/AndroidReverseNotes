package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class u {
    private static final Object etw = new Object();

    public static t c(Looper looper) {
        AppMethodBeat.i(93009);
        Camera open = Camera.open();
        t tVar;
        if (looper == null) {
            tVar = new t(open);
            AppMethodBeat.o(93009);
            return tVar;
        }
        a(open);
        tVar = new t(open);
        AppMethodBeat.o(93009);
        return tVar;
    }

    static {
        AppMethodBeat.i(93013);
        AppMethodBeat.o(93013);
    }

    public static t b(final int i, Looper looper) {
        AppMethodBeat.i(93010);
        t tVar;
        if (d.iW(28)) {
            try {
                tVar = new t(c(i, looper));
                AppMethodBeat.o(93010);
                return tVar;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMCamera", e, "opnImpl error, try camera directly, myLooper: %s", Looper.myLooper());
                if (Looper.myLooper() == null) {
                    final Camera[] cameraArr = new Camera[]{null};
                    com.tencent.mm.sdk.g.d.h(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(93008);
                            cameraArr[0] = Camera.open(i);
                            synchronized (u.etw) {
                                try {
                                    u.etw.notifyAll();
                                    ab.i("MicroMsg.MMCamera", "openCamera notifyAll");
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.MMCamera", e, "MMCamera_openLooperNull notify error", new Object[0]);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(93008);
                                }
                            }
                            AppMethodBeat.o(93008);
                        }
                    }, "MMCamera_openLooperNull").start();
                    synchronized (etw) {
                        try {
                            etw.wait();
                            ab.i("MicroMsg.MMCamera", "openCamera wait finish");
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.MMCamera", e2, "MMCamera_openLooperNull wait error", new Object[0]);
                        } catch (Throwable th) {
                            AppMethodBeat.o(93010);
                        }
                        tVar = new t(cameraArr[0]);
                        AppMethodBeat.o(93010);
                        return tVar;
                    }
                }
                tVar = new t(Camera.open(i));
                AppMethodBeat.o(93010);
                return tVar;
            }
        }
        tVar = new t(c(i, looper));
        AppMethodBeat.o(93010);
        return tVar;
    }

    private static Camera c(int i, Looper looper) {
        AppMethodBeat.i(93011);
        Camera open = Camera.open(i);
        if (looper == null) {
            AppMethodBeat.o(93011);
        } else {
            a(open);
            AppMethodBeat.o(93011);
        }
        return open;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(Camera camera) {
        Throwable th;
        NoSuchFieldException noSuchFieldException;
        AppMethodBeat.i(93012);
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
            AppMethodBeat.o(93012);
        } catch (NoSuchFieldException e) {
            ab.c("MicroMsg.MMCamera", "%s", e);
            e.pXa.a(950, 200, 1, false);
            AppMethodBeat.o(93012);
        } catch (IllegalAccessException e2) {
            ab.c("MicroMsg.MMCamera", "%s", e2);
            e.pXa.a(950, 200, 1, false);
            AppMethodBeat.o(93012);
        } catch (InvocationTargetException e3) {
            ab.c("MicroMsg.MMCamera", "%s", e3);
            AppMethodBeat.o(93012);
        } catch (InstantiationException e4) {
            ab.c("MicroMsg.MMCamera", "%s", e4);
            AppMethodBeat.o(93012);
        } catch (Throwable th2) {
            th = th2;
            noSuchFieldException = null;
            if (noSuchFieldException != null) {
            }
            AppMethodBeat.o(93012);
            throw th;
        }
    }
}
