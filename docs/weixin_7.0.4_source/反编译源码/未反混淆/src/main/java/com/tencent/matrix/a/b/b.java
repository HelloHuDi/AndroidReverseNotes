package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static boolean bVc;
    private static com.tencent.matrix.a.c.b.b bVd = new com.tencent.matrix.a.c.b.b() {
        public final void b(Method method, Object[] objArr) {
            com.tencent.matrix.d.c.v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", method.getName());
            b.a(method, objArr);
        }
    };
    private static com.tencent.matrix.a.c.b bVe = new com.tencent.matrix.a.c.b("alarm", "android.app.IAlarmManager", bVd);
    private static List<c> bVf = new ArrayList();
    private static Class bVg;
    private static Field bVh;

    static final class a {
        OnAlarmListener bUQ;
        PendingIntent bUY;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class b {
        static a e(Object[] objArr) {
            if (objArr.length != 2) {
                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            a aVar = new a();
            if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
                aVar.bUY = (PendingIntent) objArr[0];
                if (b.bVg == null || b.bVh == null) {
                    com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                    return null;
                } else if (objArr[1] == null || b.bVg.isInstance(objArr[1])) {
                    try {
                        if (objArr[1] != null) {
                            aVar.bUQ = (OnAlarmListener) b.bVh.get(objArr[1]);
                        }
                        return aVar;
                    } catch (IllegalAccessException e) {
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 init exp:%s", e.getLocalizedMessage());
                        return null;
                    }
                } else {
                    com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not ListenerWrapper, %s", objArr[1]);
                    return null;
                }
            }
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", objArr[0]);
            return null;
        }
    }

    public interface c {
        void a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener);

        void a(PendingIntent pendingIntent, OnAlarmListener onAlarmListener);
    }

    static final class d {
        long bUN;
        long bUO;
        OnAlarmListener bUQ;
        PendingIntent bUY;
        long bVi;
        int flags;
        int type;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static final class e {
        static d f(Object[] objArr) {
            if (objArr.length != 11) {
                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            d dVar = new d();
            if (objArr[1] instanceof Integer) {
                dVar.type = ((Integer) objArr[1]).intValue();
                if (objArr[2] instanceof Long) {
                    dVar.bUN = ((Long) objArr[2]).longValue();
                    if (objArr[3] instanceof Long) {
                        dVar.bVi = ((Long) objArr[3]).longValue();
                        if (objArr[4] instanceof Long) {
                            dVar.bUO = ((Long) objArr[4]).longValue();
                            if (objArr[5] instanceof Integer) {
                                dVar.flags = ((Integer) objArr[5]).intValue();
                                if (objArr[6] == null || (objArr[6] instanceof PendingIntent)) {
                                    dVar.bUY = (PendingIntent) objArr[6];
                                    if (b.bVg == null || b.bVh == null) {
                                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                                        return null;
                                    }
                                    if (VERSION.SDK_INT >= 24) {
                                        if (objArr[7] == null || b.bVg.isInstance(objArr[7])) {
                                            try {
                                                if (objArr[7] != null) {
                                                    dVar.bUQ = (OnAlarmListener) b.bVh.get(objArr[7]);
                                                }
                                            } catch (IllegalAccessException e) {
                                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 init exp:%s", e.getLocalizedMessage());
                                                return null;
                                            }
                                        }
                                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 not ListenerWrapper, %s", objArr[7]);
                                        return null;
                                    }
                                    return dVar;
                                }
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 6 not PendingIntent, %s", objArr[6]);
                                return null;
                            }
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not Integer, %s", objArr[5]);
                            return null;
                        }
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Long, %s", objArr[4]);
                        return null;
                    }
                    com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                    return null;
                }
                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                return null;
            }
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Integer, %s", objArr[1]);
            return null;
        }
    }

    static /* synthetic */ void a(Method method, Object[] objArr) {
        a aVar = null;
        int i = 0;
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            d dVar;
            if (objArr != null) {
                com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                d dVar2;
                switch (objArr.length) {
                    case 3:
                        if (objArr.length == 3) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUN = ((Long) objArr[1]).longValue();
                            if (objArr[2] != null && !(objArr[2] instanceof PendingIntent)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not PendingIntent, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUY = (PendingIntent) objArr[2];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    case 4:
                        if (objArr.length == 4) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUN = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUO = ((Long) objArr[2]).longValue();
                            if (objArr[3] != null && !(objArr[3] instanceof PendingIntent)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not PendingIntent, %s", objArr[3]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUY = (PendingIntent) objArr[3];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    case 6:
                    case 7:
                        if (objArr.length != 7 && objArr.length != 6) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            dVar = null;
                            break;
                        }
                        dVar2 = new d();
                        if (!(objArr[0] instanceof Integer)) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                            dVar = null;
                            break;
                        }
                        dVar2.type = ((Integer) objArr[0]).intValue();
                        if (!(objArr[1] instanceof Long)) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                            dVar = null;
                            break;
                        }
                        dVar2.bUN = ((Long) objArr[1]).longValue();
                        if (!(objArr[2] instanceof Long)) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                            dVar = null;
                            break;
                        }
                        dVar2.bVi = ((Long) objArr[2]).longValue();
                        if (!(objArr[3] instanceof Long)) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                            dVar = null;
                            break;
                        }
                        dVar2.bUO = ((Long) objArr[3]).longValue();
                        if (objArr[4] != null && !(objArr[4] instanceof PendingIntent)) {
                            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not PendingIntent, %s", objArr[4]);
                            dVar = null;
                            break;
                        }
                        dVar2.bUY = (PendingIntent) objArr[4];
                        dVar = dVar2;
                        break;
                        break;
                    case 8:
                        if (objArr.length == 8) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUN = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bVi = ((Long) objArr[2]).longValue();
                            if (!(objArr[3] instanceof Long)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUO = ((Long) objArr[3]).longValue();
                            if (!(objArr[4] instanceof Integer)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Integer, %s", objArr[4]);
                                dVar = null;
                                break;
                            }
                            dVar2.flags = ((Integer) objArr[4]).intValue();
                            if (objArr[5] != null && !(objArr[5] instanceof PendingIntent)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not PendingIntent, %s", objArr[5]);
                                dVar = null;
                                break;
                            }
                            dVar2.bUY = (PendingIntent) objArr[5];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    default:
                        dVar = e.f(objArr);
                        break;
                }
            }
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args null", new Object[0]);
            dVar = null;
            if (dVar == null) {
                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "dispatchSet setArgs null", new Object[0]);
                return;
            }
            synchronized (b.class) {
                for (int i2 = 0; i2 < bVf.size(); i2++) {
                    ((c) bVf.get(i2)).a(dVar.type, dVar.bUN, dVar.bVi, dVar.bUO, dVar.flags, dVar.bUY, dVar.bUQ);
                }
            }
        } else if (method.getName().equals("remove")) {
            if (objArr != null) {
                com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                switch (objArr.length) {
                    case 1:
                        if (objArr.length == 1) {
                            a aVar2 = new a();
                            if (objArr[0] != null && !(objArr[0] instanceof PendingIntent)) {
                                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args idx 0 not PendingIntent, %s", objArr[0]);
                                break;
                            }
                            aVar2.bUY = (PendingIntent) objArr[0];
                            aVar = aVar2;
                            break;
                        }
                        com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                        break;
                        break;
                    default:
                        aVar = b.e(objArr);
                        break;
                }
            }
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs args null", new Object[0]);
            if (aVar == null) {
                com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "dispatchCancel cancelArgs null", new Object[0]);
                return;
            }
            synchronized (b.class) {
                while (i < bVf.size()) {
                    ((c) bVf.get(i)).a(aVar.bUY, aVar.bUQ);
                    i++;
                }
            }
        }
    }

    static {
        try {
            Class cls = Class.forName("android.app.AlarmManager$ListenerWrapper");
            bVg = cls;
            Field declaredField = cls.getDeclaredField("mListener");
            bVh = declaredField;
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e);
        } catch (NoSuchFieldException e2) {
            com.tencent.matrix.d.c.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e2);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (!bVf.contains(cVar)) {
                bVf.add(cVar);
                if (!(bVc || bVf.isEmpty())) {
                    com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "checkHook hookRet:%b", Boolean.valueOf(bVe.doHook()));
                    bVc = true;
                }
            }
        }
    }

    public static synchronized void b(c cVar) {
        synchronized (b.class) {
            bVf.remove(cVar);
            if (bVc && bVf.isEmpty()) {
                com.tencent.matrix.d.c.i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(bVe.doUnHook()));
                bVc = false;
            }
        }
    }
}
