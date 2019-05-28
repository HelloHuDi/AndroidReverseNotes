package com.tencent.matrix.p151a.p153b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import com.tencent.matrix.p151a.p154c.C1059b;
import com.tencent.matrix.p151a.p154c.C1059b.C1057b;
import com.tencent.matrix.p157d.C1070c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.matrix.a.b.b */
public class C1036b {
    private static boolean bVc;
    private static C1057b bVd = new C10371();
    private static C1059b bVe = new C1059b("alarm", "android.app.IAlarmManager", bVd);
    private static List<C1033c> bVf = new ArrayList();
    private static Class bVg;
    private static Field bVh;

    /* renamed from: com.tencent.matrix.a.b.b$a */
    static final class C1031a {
        OnAlarmListener bUQ;
        PendingIntent bUY;

        private C1031a() {
        }

        /* synthetic */ C1031a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.b$b */
    static final class C1032b {
        /* renamed from: e */
        static C1031a m2312e(Object[] objArr) {
            if (objArr.length != 2) {
                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            C1031a c1031a = new C1031a();
            if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
                c1031a.bUY = (PendingIntent) objArr[0];
                if (C1036b.bVg == null || C1036b.bVh == null) {
                    C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                    return null;
                } else if (objArr[1] == null || C1036b.bVg.isInstance(objArr[1])) {
                    try {
                        if (objArr[1] != null) {
                            c1031a.bUQ = (OnAlarmListener) C1036b.bVh.get(objArr[1]);
                        }
                        return c1031a;
                    } catch (IllegalAccessException e) {
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 init exp:%s", e.getLocalizedMessage());
                        return null;
                    }
                } else {
                    C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not ListenerWrapper, %s", objArr[1]);
                    return null;
                }
            }
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", objArr[0]);
            return null;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.b$c */
    public interface C1033c {
        /* renamed from: a */
        void mo4168a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener);

        /* renamed from: a */
        void mo4169a(PendingIntent pendingIntent, OnAlarmListener onAlarmListener);
    }

    /* renamed from: com.tencent.matrix.a.b.b$d */
    static final class C1034d {
        long bUN;
        long bUO;
        OnAlarmListener bUQ;
        PendingIntent bUY;
        long bVi;
        int flags;
        int type;

        private C1034d() {
        }

        /* synthetic */ C1034d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.matrix.a.b.b$e */
    static final class C1035e {
        /* renamed from: f */
        static C1034d m2315f(Object[] objArr) {
            if (objArr.length != 11) {
                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            C1034d c1034d = new C1034d();
            if (objArr[1] instanceof Integer) {
                c1034d.type = ((Integer) objArr[1]).intValue();
                if (objArr[2] instanceof Long) {
                    c1034d.bUN = ((Long) objArr[2]).longValue();
                    if (objArr[3] instanceof Long) {
                        c1034d.bVi = ((Long) objArr[3]).longValue();
                        if (objArr[4] instanceof Long) {
                            c1034d.bUO = ((Long) objArr[4]).longValue();
                            if (objArr[5] instanceof Integer) {
                                c1034d.flags = ((Integer) objArr[5]).intValue();
                                if (objArr[6] == null || (objArr[6] instanceof PendingIntent)) {
                                    c1034d.bUY = (PendingIntent) objArr[6];
                                    if (C1036b.bVg == null || C1036b.bVh == null) {
                                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                                        return null;
                                    }
                                    if (VERSION.SDK_INT >= 24) {
                                        if (objArr[7] == null || C1036b.bVg.isInstance(objArr[7])) {
                                            try {
                                                if (objArr[7] != null) {
                                                    c1034d.bUQ = (OnAlarmListener) C1036b.bVh.get(objArr[7]);
                                                }
                                            } catch (IllegalAccessException e) {
                                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 init exp:%s", e.getLocalizedMessage());
                                                return null;
                                            }
                                        }
                                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 not ListenerWrapper, %s", objArr[7]);
                                        return null;
                                    }
                                    return c1034d;
                                }
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 6 not PendingIntent, %s", objArr[6]);
                                return null;
                            }
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not Integer, %s", objArr[5]);
                            return null;
                        }
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Long, %s", objArr[4]);
                        return null;
                    }
                    C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                    return null;
                }
                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                return null;
            }
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Integer, %s", objArr[1]);
            return null;
        }
    }

    /* renamed from: com.tencent.matrix.a.b.b$1 */
    static class C10371 implements C1057b {
        C10371() {
        }

        /* renamed from: b */
        public final void mo4170b(Method method, Object[] objArr) {
            C1070c.m2369v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", method.getName());
            C1036b.m2317a(method, objArr);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m2317a(Method method, Object[] objArr) {
        C1031a c1031a = null;
        int i = 0;
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            C1034d c1034d;
            if (objArr != null) {
                C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                C1034d c1034d2;
                switch (objArr.length) {
                    case 3:
                        if (objArr.length == 3) {
                            c1034d2 = new C1034d();
                            if (!(objArr[0] instanceof Integer)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUN = ((Long) objArr[1]).longValue();
                            if (objArr[2] != null && !(objArr[2] instanceof PendingIntent)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not PendingIntent, %s", objArr[2]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUY = (PendingIntent) objArr[2];
                            c1034d = c1034d2;
                            break;
                        }
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        c1034d = null;
                        break;
                        break;
                    case 4:
                        if (objArr.length == 4) {
                            c1034d2 = new C1034d();
                            if (!(objArr[0] instanceof Integer)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUN = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUO = ((Long) objArr[2]).longValue();
                            if (objArr[3] != null && !(objArr[3] instanceof PendingIntent)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not PendingIntent, %s", objArr[3]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUY = (PendingIntent) objArr[3];
                            c1034d = c1034d2;
                            break;
                        }
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        c1034d = null;
                        break;
                        break;
                    case 6:
                    case 7:
                        if (objArr.length != 7 && objArr.length != 6) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            c1034d = null;
                            break;
                        }
                        c1034d2 = new C1034d();
                        if (!(objArr[0] instanceof Integer)) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                            c1034d = null;
                            break;
                        }
                        c1034d2.type = ((Integer) objArr[0]).intValue();
                        if (!(objArr[1] instanceof Long)) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                            c1034d = null;
                            break;
                        }
                        c1034d2.bUN = ((Long) objArr[1]).longValue();
                        if (!(objArr[2] instanceof Long)) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                            c1034d = null;
                            break;
                        }
                        c1034d2.bVi = ((Long) objArr[2]).longValue();
                        if (!(objArr[3] instanceof Long)) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                            c1034d = null;
                            break;
                        }
                        c1034d2.bUO = ((Long) objArr[3]).longValue();
                        if (objArr[4] != null && !(objArr[4] instanceof PendingIntent)) {
                            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not PendingIntent, %s", objArr[4]);
                            c1034d = null;
                            break;
                        }
                        c1034d2.bUY = (PendingIntent) objArr[4];
                        c1034d = c1034d2;
                        break;
                        break;
                    case 8:
                        if (objArr.length == 8) {
                            c1034d2 = new C1034d();
                            if (!(objArr[0] instanceof Integer)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUN = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bVi = ((Long) objArr[2]).longValue();
                            if (!(objArr[3] instanceof Long)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUO = ((Long) objArr[3]).longValue();
                            if (!(objArr[4] instanceof Integer)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Integer, %s", objArr[4]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.flags = ((Integer) objArr[4]).intValue();
                            if (objArr[5] != null && !(objArr[5] instanceof PendingIntent)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not PendingIntent, %s", objArr[5]);
                                c1034d = null;
                                break;
                            }
                            c1034d2.bUY = (PendingIntent) objArr[5];
                            c1034d = c1034d2;
                            break;
                        }
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        c1034d = null;
                        break;
                        break;
                    default:
                        c1034d = C1035e.m2315f(objArr);
                        break;
                }
            }
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createSetArgs args null", new Object[0]);
            c1034d = null;
            if (c1034d == null) {
                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "dispatchSet setArgs null", new Object[0]);
                return;
            }
            synchronized (C1036b.class) {
                for (int i2 = 0; i2 < bVf.size(); i2++) {
                    ((C1033c) bVf.get(i2)).mo4168a(c1034d.type, c1034d.bUN, c1034d.bVi, c1034d.bUO, c1034d.flags, c1034d.bUY, c1034d.bUQ);
                }
            }
        } else if (method.getName().equals("remove")) {
            if (objArr != null) {
                C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                switch (objArr.length) {
                    case 1:
                        if (objArr.length == 1) {
                            C1031a c1031a2 = new C1031a();
                            if (objArr[0] != null && !(objArr[0] instanceof PendingIntent)) {
                                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args idx 0 not PendingIntent, %s", objArr[0]);
                                break;
                            }
                            c1031a2.bUY = (PendingIntent) objArr[0];
                            c1031a = c1031a2;
                            break;
                        }
                        C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                        break;
                        break;
                    default:
                        c1031a = C1032b.m2312e(objArr);
                        break;
                }
            }
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "createCancelArgs args null", new Object[0]);
            if (c1031a == null) {
                C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "dispatchCancel cancelArgs null", new Object[0]);
                return;
            }
            synchronized (C1036b.class) {
                while (i < bVf.size()) {
                    ((C1033c) bVf.get(i)).mo4169a(c1031a.bUY, c1031a.bUQ);
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
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e);
        } catch (NoSuchFieldException e2) {
            C1070c.m2370w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e2);
        }
    }

    /* renamed from: a */
    public static synchronized void m2316a(C1033c c1033c) {
        synchronized (C1036b.class) {
            if (!bVf.contains(c1033c)) {
                bVf.add(c1033c);
                if (!(bVc || bVf.isEmpty())) {
                    C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "checkHook hookRet:%b", Boolean.valueOf(bVe.doHook()));
                    bVc = true;
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m2318b(C1033c c1033c) {
        synchronized (C1036b.class) {
            bVf.remove(c1033c);
            if (bVc && bVf.isEmpty()) {
                C1070c.m2368i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(bVe.doUnHook()));
                bVc = false;
            }
        }
    }
}
