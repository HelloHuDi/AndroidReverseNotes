package com.tencent.matrix.p151a.p153b;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.p151a.p154c.C1059b;
import com.tencent.matrix.p151a.p154c.C1059b.C1057b;
import com.tencent.matrix.p157d.C1070c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.matrix.a.b.e */
public final class C1047e {
    private static boolean bVc;
    private static C1057b bVd = new C10481();
    private static C1059b bVe = new C1059b("power", "android.os.IPowerManager", bVd);
    private static List<C1045b> bVf = new ArrayList();

    /* renamed from: com.tencent.matrix.a.b.e$a */
    static final class C1044a {
        WorkSource bVB;
        String bVC;
        int flags;
        String packageName;
        String tag;
        IBinder token;

        private C1044a() {
        }

        /* synthetic */ C1044a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.e$b */
    public interface C1045b {
        /* renamed from: a */
        void mo4179a(IBinder iBinder, int i);

        /* renamed from: a */
        void mo4180a(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3);
    }

    /* renamed from: com.tencent.matrix.a.b.e$c */
    static final class C1046c {
        int flags;
        IBinder token;

        private C1046c() {
        }

        /* synthetic */ C1046c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.e$1 */
    static class C10481 implements C1057b {
        C10481() {
        }

        /* renamed from: b */
        public final void mo4170b(Method method, Object[] objArr) {
            C1070c.m2369v("Matrix.PowerManagerServiceHooker", "onServiceMethodInvoke: method name %s", method.getName());
            C1047e.m2326a(method, objArr);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2326a(Method method, Object[] objArr) {
        C1046c c1046c = null;
        int i = 0;
        if (method.getName().equals("acquireWakeLock")) {
            C1044a c1044a;
            if (objArr != null) {
                C1070c.m2368i("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                C1070c.m2368i("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                C1044a c1044a2;
                switch (objArr.length) {
                    case 4:
                        if (objArr.length == 4) {
                            c1044a2 = new C1044a();
                            if (objArr[2] != null && !(objArr[2] instanceof String)) {
                                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                                c1044a = null;
                                break;
                            }
                            c1044a2.tag = (String) objArr[2];
                            if (objArr[3] != null && !(objArr[3] instanceof WorkSource)) {
                                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", objArr[3]);
                                c1044a = null;
                                break;
                            }
                            c1044a2.bVB = (WorkSource) objArr[3];
                            if (!(objArr[0] instanceof Integer)) {
                                if (!(objArr[0] instanceof IBinder)) {
                                    C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", objArr[0]);
                                    c1044a = null;
                                    break;
                                }
                                c1044a2.token = (IBinder) objArr[0];
                                if (!(objArr[1] instanceof Integer)) {
                                    C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", objArr[1]);
                                    c1044a = null;
                                    break;
                                }
                                c1044a2.flags = ((Integer) objArr[1]).intValue();
                            } else {
                                c1044a2.flags = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof IBinder)) {
                                    C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", objArr[1]);
                                    c1044a = null;
                                    break;
                                }
                                c1044a2.token = (IBinder) objArr[1];
                            }
                            c1044a = c1044a2;
                            break;
                        }
                        C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                        c1044a = null;
                        break;
                    default:
                        if (objArr.length != 6 && objArr.length != 5) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args length invalid : %d", Integer.valueOf(objArr.length));
                            c1044a = null;
                            break;
                        }
                        c1044a2 = new C1044a();
                        if (!(objArr[0] instanceof IBinder)) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", objArr[0]);
                            c1044a = null;
                            break;
                        }
                        c1044a2.token = (IBinder) objArr[0];
                        if (!(objArr[1] instanceof Integer)) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", objArr[1]);
                            c1044a = null;
                            break;
                        }
                        c1044a2.flags = ((Integer) objArr[1]).intValue();
                        if (objArr[2] != null && !(objArr[2] instanceof String)) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                            c1044a = null;
                            break;
                        }
                        c1044a2.tag = (String) objArr[2];
                        if (objArr[3] != null && !(objArr[3] instanceof String)) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 3 not String, %s", objArr[3]);
                            c1044a = null;
                            break;
                        }
                        c1044a2.packageName = (String) objArr[3];
                        if (objArr[4] != null && !(objArr[4] instanceof WorkSource)) {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", objArr[4]);
                            c1044a = null;
                            break;
                        }
                        c1044a2.bVB = (WorkSource) objArr[4];
                        if (objArr.length != 5) {
                            if (objArr[5] != null && !(objArr[5] instanceof String)) {
                                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 5 not String, %s", objArr[5]);
                                c1044a = null;
                                break;
                            }
                            c1044a2.bVC = (String) objArr[5];
                            c1044a = c1044a2;
                            break;
                        }
                        c1044a = c1044a2;
                        break;
                        break;
                }
            }
            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs args null", new Object[0]);
            c1044a = null;
            if (c1044a == null) {
                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (C1047e.class) {
                for (int i2 = 0; i2 < bVf.size(); i2++) {
                    ((C1045b) bVf.get(i2)).mo4180a(c1044a.token, c1044a.flags, c1044a.tag, c1044a.packageName, c1044a.bVB, c1044a.bVC);
                }
            }
        } else if (method.getName().equals("releaseWakeLock")) {
            if (objArr == null) {
                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs args null", new Object[0]);
            } else {
                C1070c.m2368i("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                C1070c.m2368i("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                if (objArr.length != 2) {
                    C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                } else {
                    C1046c c1046c2 = new C1046c();
                    if (objArr[0] instanceof IBinder) {
                        c1046c2.token = (IBinder) objArr[0];
                        if (objArr[1] instanceof Integer) {
                            c1046c2.flags = ((Integer) objArr[1]).intValue();
                            c1046c = c1046c2;
                        } else {
                            C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", objArr[1]);
                        }
                    } else {
                        C1070c.m2370w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", objArr[0]);
                    }
                }
            }
            if (c1046c == null) {
                C1070c.m2370w("Matrix.PowerManagerServiceHooker", "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (C1047e.class) {
                while (i < bVf.size()) {
                    ((C1045b) bVf.get(i)).mo4179a(c1046c.token, c1046c.flags);
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2325a(C1045b c1045b) {
        synchronized (C1047e.class) {
            if (!bVf.contains(c1045b)) {
                bVf.add(c1045b);
                if (!(bVc || bVf.isEmpty())) {
                    C1070c.m2368i("Matrix.PowerManagerServiceHooker", "checkHook hookRet:%b", Boolean.valueOf(bVe.doHook()));
                    bVc = true;
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m2327b(C1045b c1045b) {
        synchronized (C1047e.class) {
            bVf.remove(c1045b);
            if (bVc && bVf.isEmpty()) {
                C1070c.m2368i("Matrix.PowerManagerServiceHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(bVe.doUnHook()));
                bVc = false;
            }
        }
    }
}
