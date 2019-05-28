package com.tencent.matrix.a.b;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.WorkSource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static boolean bVc;
    private static com.tencent.matrix.a.c.b.b bVd = new com.tencent.matrix.a.c.b.b() {
        public final void b(Method method, Object[] objArr) {
            com.tencent.matrix.d.c.v("Matrix.PowerManagerServiceHooker", "onServiceMethodInvoke: method name %s", method.getName());
            e.a(method, objArr);
        }
    };
    private static com.tencent.matrix.a.c.b bVe = new com.tencent.matrix.a.c.b("power", "android.os.IPowerManager", bVd);
    private static List<b> bVf = new ArrayList();

    static final class a {
        WorkSource bVB;
        String bVC;
        int flags;
        String packageName;
        String tag;
        IBinder token;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        void a(IBinder iBinder, int i);

        void a(IBinder iBinder, int i, String str, String str2, WorkSource workSource, String str3);
    }

    static final class c {
        int flags;
        IBinder token;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(Method method, Object[] objArr) {
        c cVar = null;
        int i = 0;
        if (method.getName().equals("acquireWakeLock")) {
            a aVar;
            if (objArr != null) {
                com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                a aVar2;
                switch (objArr.length) {
                    case 4:
                        if (objArr.length == 4) {
                            aVar2 = new a();
                            if (objArr[2] != null && !(objArr[2] instanceof String)) {
                                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                                aVar = null;
                                break;
                            }
                            aVar2.tag = (String) objArr[2];
                            if (objArr[3] != null && !(objArr[3] instanceof WorkSource)) {
                                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", objArr[3]);
                                aVar = null;
                                break;
                            }
                            aVar2.bVB = (WorkSource) objArr[3];
                            if (!(objArr[0] instanceof Integer)) {
                                if (!(objArr[0] instanceof IBinder)) {
                                    com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", objArr[0]);
                                    aVar = null;
                                    break;
                                }
                                aVar2.token = (IBinder) objArr[0];
                                if (!(objArr[1] instanceof Integer)) {
                                    com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", objArr[1]);
                                    aVar = null;
                                    break;
                                }
                                aVar2.flags = ((Integer) objArr[1]).intValue();
                            } else {
                                aVar2.flags = ((Integer) objArr[0]).intValue();
                                if (!(objArr[1] instanceof IBinder)) {
                                    com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", objArr[1]);
                                    aVar = null;
                                    break;
                                }
                                aVar2.token = (IBinder) objArr[1];
                            }
                            aVar = aVar2;
                            break;
                        }
                        com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                        aVar = null;
                        break;
                    default:
                        if (objArr.length != 6 && objArr.length != 5) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args length invalid : %d", Integer.valueOf(objArr.length));
                            aVar = null;
                            break;
                        }
                        aVar2 = new a();
                        if (!(objArr[0] instanceof IBinder)) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", objArr[0]);
                            aVar = null;
                            break;
                        }
                        aVar2.token = (IBinder) objArr[0];
                        if (!(objArr[1] instanceof Integer)) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", objArr[1]);
                            aVar = null;
                            break;
                        }
                        aVar2.flags = ((Integer) objArr[1]).intValue();
                        if (objArr[2] != null && !(objArr[2] instanceof String)) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 2 not String, %s", objArr[2]);
                            aVar = null;
                            break;
                        }
                        aVar2.tag = (String) objArr[2];
                        if (objArr[3] != null && !(objArr[3] instanceof String)) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 3 not String, %s", objArr[3]);
                            aVar = null;
                            break;
                        }
                        aVar2.packageName = (String) objArr[3];
                        if (objArr[4] != null && !(objArr[4] instanceof WorkSource)) {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", objArr[4]);
                            aVar = null;
                            break;
                        }
                        aVar2.bVB = (WorkSource) objArr[4];
                        if (objArr.length != 5) {
                            if (objArr[5] != null && !(objArr[5] instanceof String)) {
                                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs6 args idx 5 not String, %s", objArr[5]);
                                aVar = null;
                                break;
                            }
                            aVar2.bVC = (String) objArr[5];
                            aVar = aVar2;
                            break;
                        }
                        aVar = aVar2;
                        break;
                        break;
                }
            }
            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createAcquireWakeLockArgs args null", new Object[0]);
            aVar = null;
            if (aVar == null) {
                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (e.class) {
                for (int i2 = 0; i2 < bVf.size(); i2++) {
                    ((b) bVf.get(i2)).a(aVar.token, aVar.flags, aVar.tag, aVar.packageName, aVar.bVB, aVar.bVC);
                }
            }
        } else if (method.getName().equals("releaseWakeLock")) {
            if (objArr == null) {
                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs args null", new Object[0]);
            } else {
                com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                if (objArr.length != 2) {
                    com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                } else {
                    c cVar2 = new c();
                    if (objArr[0] instanceof IBinder) {
                        cVar2.token = (IBinder) objArr[0];
                        if (objArr[1] instanceof Integer) {
                            cVar2.flags = ((Integer) objArr[1]).intValue();
                            cVar = cVar2;
                        } else {
                            com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", objArr[1]);
                        }
                    } else {
                        com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", objArr[0]);
                    }
                }
            }
            if (cVar == null) {
                com.tencent.matrix.d.c.w("Matrix.PowerManagerServiceHooker", "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (e.class) {
                while (i < bVf.size()) {
                    ((b) bVf.get(i)).a(cVar.token, cVar.flags);
                    i++;
                }
            }
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (!bVf.contains(bVar)) {
                bVf.add(bVar);
                if (!(bVc || bVf.isEmpty())) {
                    com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "checkHook hookRet:%b", Boolean.valueOf(bVe.doHook()));
                    bVc = true;
                }
            }
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (e.class) {
            bVf.remove(bVar);
            if (bVc && bVf.isEmpty()) {
                com.tencent.matrix.d.c.i("Matrix.PowerManagerServiceHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(bVe.doUnHook()));
                bVc = false;
            }
        }
    }
}
