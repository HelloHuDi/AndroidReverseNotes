package com.tencent.matrix.trace.core;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Printer;
import com.tencent.matrix.p157d.C1070c;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.matrix.trace.core.a */
public final class C1145a implements IdleHandler {
    private static Printer bYO;
    private static final C1145a bYP = new C1145a();
    private static final HashSet<C1144a> listeners = new HashSet();

    /* renamed from: com.tencent.matrix.trace.core.a$a */
    public static abstract class C1144a {
        boolean bYS = false;

        /* Access modifiers changed, original: 0000 */
        public boolean isValid() {
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void dispatchStart() {
            this.bYS = true;
        }

        /* Access modifiers changed, original: 0000 */
        public void dispatchEnd() {
            this.bYS = false;
        }
    }

    private C1145a() {
        C1145a.m2508zw();
        if (VERSION.SDK_INT >= 23) {
            Looper.getMainLooper().getQueue().addIdleHandler(this);
        } else {
            ((MessageQueue) C1145a.reflectObject(Looper.getMainLooper(), "mQueue")).addIdleHandler(this);
        }
    }

    public final boolean queueIdle() {
        C1145a.m2508zw();
        return true;
    }

    /* renamed from: zw */
    private static void m2508zw() {
        final Printer printer = (Printer) C1145a.reflectObject(Looper.getMainLooper(), "mLogging");
        if (printer != bYO || bYO == null) {
            if (bYO != null) {
                C1070c.m2370w("Matrix.LooperMonitor", "[resetPrinter] maybe looper printer was replace other!", new Object[0]);
            }
            Looper mainLooper = Looper.getMainLooper();
            C11431 c11431 = new Printer() {
                boolean bYN = false;
                boolean bYQ = false;

                public final void println(String str) {
                    boolean z = true;
                    if (printer != null) {
                        printer.println(str);
                    }
                    if (!this.bYQ) {
                        boolean z2 = str.charAt(0) == '>' || str.charAt(0) == '<';
                        this.bYN = z2;
                        this.bYQ = true;
                        if (!this.bYN) {
                            C1070c.m2367e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", str);
                        }
                    }
                    if (this.bYN) {
                        if (str.charAt(0) != '>') {
                            z = false;
                        }
                        C1145a.m2507bc(z);
                    }
                }
            };
            bYO = c11431;
            mainLooper.setMessageLogging(c11431);
        }
    }

    /* renamed from: a */
    public static void m2506a(C1144a c1144a) {
        synchronized (listeners) {
            listeners.add(c1144a);
        }
    }

    private static <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            C1070c.m2367e("Matrix.LooperMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: bc */
    static /* synthetic */ void m2507bc(boolean z) {
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            C1144a c1144a = (C1144a) it.next();
            if (c1144a.isValid()) {
                if (z) {
                    if (!c1144a.bYS) {
                        c1144a.dispatchStart();
                    }
                } else if (c1144a.bYS) {
                    c1144a.dispatchEnd();
                }
            } else if (!z && c1144a.bYS) {
                c1144a.dispatchEnd();
            }
        }
    }
}
