package com.tencent.p177mm.sdk.platformtools;

import android.app.Activity;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor */
public final class ListenerInstanceMonitor {
    private static final Map<Object, Set<C4981a>> xyA = new WeakHashMap();
    private static final byte[] xyB = new byte[0];
    private static Field xyC;
    private static HandlerThread xyD = null;
    private static C7306ak xyE = null;
    private static volatile boolean xyF = false;
    private static final String xyG = Activity.class.getName();
    private static final Runnable xyH = new C49801();

    /* renamed from: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor$1 */
    static class C49801 implements Runnable {
        C49801() {
        }

        /* JADX WARNING: Missing block: B:8:0x0019, code skipped:
            r1 = com.tencent.p177mm.sdk.platformtools.ListenerInstanceMonitor.dok();
     */
        /* JADX WARNING: Missing block: B:9:0x001d, code skipped:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:12:0x0026, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.ListenerInstanceMonitor.access$400().isEmpty() == false) goto L_0x0051;
     */
        /* JADX WARNING: Missing block: B:13:0x0028, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
     */
        /* JADX WARNING: Missing block: B:14:0x0031, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:27:?, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:29:0x0056, code skipped:
            if (android.os.Debug.isDebuggerConnected() == false) goto L_0x0068;
     */
        /* JADX WARNING: Missing block: B:30:0x0058, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
     */
        /* JADX WARNING: Missing block: B:34:0x0064, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(115204);
     */
        /* JADX WARNING: Missing block: B:35:0x0068, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
     */
        /* JADX WARNING: Missing block: B:37:?, code skipped:
            java.lang.Runtime.getRuntime().gc();
            java.lang.Thread.sleep(100);
            java.lang.Runtime.getRuntime().runFinalization();
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(115204);
            synchronized (ListenerInstanceMonitor.xyH) {
                try {
                    if (!ListenerInstanceMonitor.xyF) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(115204);
                }
            }
            ListenerLeakedException listenerLeakedException;
            return;
            return;
            synchronized (ListenerInstanceMonitor.xyB) {
                try {
                    for (Entry value : ListenerInstanceMonitor.xyA.entrySet()) {
                        Iterator it = ((Set) value.getValue()).iterator();
                        while (it.hasNext()) {
                            C4981a c4981a = (C4981a) it.next();
                            listenerLeakedException = c4981a.xyI.get();
                            Activity activity = (Activity) c4981a.xyJ.get();
                            if (activity == null) {
                                C4990ab.m7417i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", c4981a.xyK.getName());
                                it.remove();
                            } else {
                                boolean isDestroyed = activity.isDestroyed();
                                if (isDestroyed) {
                                    for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                                        if (ListenerInstanceMonitor.xyG.equals(stackTraceElement.getClassName()) && "performDestroy".equals(stackTraceElement.getMethodName())) {
                                            isDestroyed = false;
                                            break;
                                        }
                                    }
                                } else {
                                    isDestroyed = false;
                                }
                                if (isDestroyed && listenerLeakedException == null) {
                                    if (c4981a.xyN > 3) {
                                        String str;
                                        it.remove();
                                        Object obj = (C5047bp.dpL() || C5047bp.dnM()) ? 1 : null;
                                        if (c4981a.xyJ.get() == null) {
                                            if (c4981a.xyL != null) {
                                                str = "ui of class [" + c4981a.xyK.getName() + "] held by\n [" + c4981a.dom() + "] is recycled";
                                            } else {
                                                str = "ui of class [" + c4981a.xyK.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
                                            }
                                        } else if (c4981a.xyL != null) {
                                            str = "ui of class [" + c4981a.xyK.getName() + "] held by\n [" + c4981a.dom() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
                                        } else {
                                            str = "ui of class [" + c4981a.xyK.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                                        }
                                        listenerLeakedException = new ListenerLeakedException(str, c4981a.xyM);
                                        if (obj != null) {
                                            throw listenerLeakedException;
                                        }
                                        C4990ab.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", listenerLeakedException, "", new Object[0]);
                                    } else {
                                        c4981a.xyN++;
                                        C4990ab.m7421w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", c4981a.xyK.getName(), Integer.valueOf(c4981a.xyN));
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(115204);
                }
            }
            synchronized (ListenerInstanceMonitor.xyH) {
                try {
                    if (ListenerInstanceMonitor.xyF) {
                        ListenerInstanceMonitor.xyE.postDelayed(this, 10000);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(115204);
                    }
                }
            }
            return;
            throw listenerLeakedException;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor$ListenerLeakedException */
    static final class ListenerLeakedException extends RuntimeException {
        ListenerLeakedException(String str, Throwable th) {
            super(str + "\n See stacktrace to find where is the holder(listener) being added.");
            AppMethodBeat.m2504i(115211);
            setStackTrace(th.getStackTrace());
            AppMethodBeat.m2505o(115211);
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor$a */
    static class C4981a {
        final WeakReference<Object> xyI = new WeakReference(new Object());
        WeakReference<Activity> xyJ;
        Class<?> xyK;
        Field xyL;
        Throwable xyM;
        int xyN;

        C4981a(Activity activity, Field field, Throwable th) {
            AppMethodBeat.m2504i(115205);
            this.xyJ = new WeakReference(activity);
            this.xyK = activity.getClass();
            this.xyL = field;
            this.xyM = th;
            this.xyN = 0;
            AppMethodBeat.m2505o(115205);
        }

        public final String toString() {
            AppMethodBeat.m2504i(115206);
            String str = dom() + "@" + dol().replace(10, '|');
            AppMethodBeat.m2505o(115206);
            return str;
        }

        private String dol() {
            Throwable th;
            AppMethodBeat.m2504i(115207);
            StringWriter stringWriter = new StringWriter();
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    this.xyM.printStackTrace(printWriter);
                    C5046bo.m7527b(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    AppMethodBeat.m2505o(115207);
                    return stringWriter2;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(printWriter);
                    AppMethodBeat.m2505o(115207);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                C5046bo.m7527b(printWriter);
                AppMethodBeat.m2505o(115207);
                throw th;
            }
        }

        /* Access modifiers changed, original: final */
        public final String dom() {
            AppMethodBeat.m2504i(115208);
            String str;
            if (this.xyL == null) {
                str = "#null#";
                AppMethodBeat.m2505o(115208);
                return str;
            }
            Object declaringClass = this.xyL.getDeclaringClass();
            if (declaringClass.isAnonymousClass()) {
                Type genericSuperclass = declaringClass.getGenericSuperclass();
                if (Object.class.equals(genericSuperclass)) {
                    declaringClass = declaringClass.getGenericInterfaces()[0];
                } else if (genericSuperclass != null) {
                    Type declaringClass2 = genericSuperclass;
                }
                str = "field " + this.xyL.getName() + " define in anonymous class of " + declaringClass2.toString().replace('<', '#').replace('>', '#');
                AppMethodBeat.m2505o(115208);
                return str;
            }
            str = "field " + this.xyL.getName() + " defined in " + declaringClass2.getName();
            AppMethodBeat.m2505o(115208);
            return str;
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            AppMethodBeat.m2504i(115209);
            Object obj = this.xyJ.get();
            if (obj != null) {
                hashCode = obj.hashCode();
            } else {
                hashCode = 0;
            }
            if (this.xyL != null) {
                hashCode2 = this.xyL.hashCode();
            } else {
                hashCode2 = 0;
            }
            if (this.xyM != null) {
                i = this.xyM.hashCode();
            }
            hashCode = (hashCode + hashCode2) + i;
            AppMethodBeat.m2505o(115209);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            AppMethodBeat.m2504i(115210);
            if (obj == null || !(obj instanceof C4981a)) {
                AppMethodBeat.m2505o(115210);
                return false;
            }
            C4981a c4981a = (C4981a) obj;
            Object obj2 = this.xyJ.get();
            Object obj3 = c4981a.xyJ.get();
            boolean equals = (obj2 == null && obj3 == null) ? true : (obj2 == null || obj3 == null) ? false : obj2.equals(obj3);
            if (equals) {
                Field field = this.xyL;
                Field field2 = c4981a.xyL;
                equals = (field == null && field2 == null) ? true : (field == null || field2 == null) ? false : field.equals(field2);
                if (equals) {
                    Throwable th = this.xyM;
                    Throwable th2 = c4981a.xyM;
                    if (!(th == null && th2 == null)) {
                        z = (th == null || th2 == null) ? false : th.equals(th2);
                    }
                    AppMethodBeat.m2505o(115210);
                    return z;
                }
                AppMethodBeat.m2505o(115210);
                return false;
            }
            AppMethodBeat.m2505o(115210);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(115218);
        xyC = null;
        if (!C5047bp.dpL() && !C5047bp.dnM()) {
            C4990ab.m7420w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
            AppMethodBeat.m2505o(115218);
        } else if (C4996ah.bqo()) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                xyC = declaredField;
                declaredField.setAccessible(true);
                ListenerInstanceMonitor.doi();
                AppMethodBeat.m2505o(115218);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "init failed, keep disabled.", new Object[0]);
                AppMethodBeat.m2505o(115218);
            }
        } else {
            C4990ab.m7420w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
            AppMethodBeat.m2505o(115218);
        }
    }

    private static void doi() {
        AppMethodBeat.m2504i(115212);
        synchronized (xyH) {
            try {
                if (!xyF) {
                    HandlerThread anM = C7305d.anM("ListenerInstanceMonitor");
                    xyD = anM;
                    anM.start();
                    C7306ak c7306ak = new C7306ak(xyD.getLooper());
                    xyE = c7306ak;
                    c7306ak.postDelayed(xyH, 10000);
                    xyF = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115212);
            }
        }
    }

    /* renamed from: cA */
    public static void m7382cA(Object obj) {
        AppMethodBeat.m2504i(115213);
        if (obj == null) {
            AppMethodBeat.m2505o(115213);
            return;
        }
        Throwable th = new Throwable();
        for (Object obj2 = obj.getClass(); !Object.class.equals(obj2); obj2 = obj2.getSuperclass()) {
            if (Activity.class.isAssignableFrom(obj2)) {
                ListenerInstanceMonitor.m7380a(obj, null, th);
            } else if (View.class.isAssignableFrom(obj2)) {
                ListenerInstanceMonitor.m7381b(obj, null, th);
            } else {
                for (Field field : obj2.getDeclaredFields()) {
                    Class type = field.getType();
                    if (Activity.class.isAssignableFrom(type)) {
                        ListenerInstanceMonitor.m7380a(obj, field, th);
                    } else if (View.class.isAssignableFrom(type)) {
                        ListenerInstanceMonitor.m7381b(obj, field, th);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(115213);
    }

    /* renamed from: a */
    private static void m7380a(Object obj, Field field, Throwable th) {
        Activity activity;
        AppMethodBeat.m2504i(115214);
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                activity = (Activity) field.get(obj);
                if (activity == null) {
                    AppMethodBeat.m2505o(115214);
                    return;
                }
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(115214);
                return;
            }
        } else if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            AppMethodBeat.m2505o(115214);
            return;
        }
        ListenerInstanceMonitor.m7379a(obj, activity, field, th);
        AppMethodBeat.m2505o(115214);
    }

    /* renamed from: b */
    private static void m7381b(Object obj, Field field, Throwable th) {
        Object obj2;
        AppMethodBeat.m2504i(115215);
        if (field == null) {
            if (obj instanceof View) {
                obj2 = (View) obj;
            } else {
                AppMethodBeat.m2505o(115215);
                return;
            }
        } else if (xyC == null) {
            AppMethodBeat.m2505o(115215);
            return;
        } else {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                View obj22 = (View) field.get(obj);
                if (obj22 == null) {
                    AppMethodBeat.m2505o(115215);
                    return;
                }
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(115215);
                return;
            }
        }
        try {
            obj22 = xyC.get(obj22);
            if (obj22 instanceof Activity) {
                ListenerInstanceMonitor.m7379a(obj, (Activity) obj22, field, th);
            }
            AppMethodBeat.m2505o(115215);
        } catch (Throwable th3) {
            AppMethodBeat.m2505o(115215);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m7379a(Object obj, Activity activity, Field field, Throwable th) {
        int length;
        AppMethodBeat.m2504i(115216);
        C5060h c5060h = null;
        if (obj.getClass().isAnnotationPresent(C5060h.class)) {
            c5060h = (C5060h) obj.getClass().getAnnotation(C5060h.class);
        } else {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(C5060h.class)) {
                    c5060h = (C5060h) method.getAnnotation(C5060h.class);
                    break;
                }
            }
        }
        if (c5060h != null) {
            int i;
            Class cls = activity.getClass();
            Class[] doa = c5060h.doa();
            if (doa != null && doa.length > 0) {
                length = doa.length;
                i = 0;
                while (i < length) {
                    if (!cls.equals(doa[i])) {
                        i++;
                    }
                }
                i = 0;
                if (i != 0) {
                    C4990ab.m7421w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                    AppMethodBeat.m2505o(115216);
                    return;
                }
            }
            i = 1;
            if (i != 0) {
            }
        }
        synchronized (xyB) {
            try {
                Set set = (Set) xyA.get(obj);
                if (set == null) {
                    set = new HashSet();
                    xyA.put(obj, set);
                }
                set.add(new C4981a(activity, field, th));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115216);
            }
        }
    }

    /* renamed from: cB */
    public static void m7383cB(Object obj) {
        AppMethodBeat.m2504i(115217);
        if (obj == null) {
            AppMethodBeat.m2505o(115217);
            return;
        }
        synchronized (xyB) {
            try {
                xyA.remove(obj);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115217);
            }
        }
    }
}
