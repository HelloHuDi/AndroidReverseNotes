package com.tencent.matrix.trace.core;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Printer;
import com.tencent.matrix.d.c;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;

public final class a implements IdleHandler {
    private static Printer bYO;
    private static final a bYP = new a();
    private static final HashSet<a> listeners = new HashSet();

    public static abstract class a {
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

    private a() {
        zw();
        if (VERSION.SDK_INT >= 23) {
            Looper.getMainLooper().getQueue().addIdleHandler(this);
        } else {
            ((MessageQueue) reflectObject(Looper.getMainLooper(), "mQueue")).addIdleHandler(this);
        }
    }

    public final boolean queueIdle() {
        zw();
        return true;
    }

    private static void zw() {
        final Printer printer = (Printer) reflectObject(Looper.getMainLooper(), "mLogging");
        if (printer != bYO || bYO == null) {
            if (bYO != null) {
                c.w("Matrix.LooperMonitor", "[resetPrinter] maybe looper printer was replace other!", new Object[0]);
            }
            Looper mainLooper = Looper.getMainLooper();
            AnonymousClass1 anonymousClass1 = new Printer() {
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
                            c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", str);
                        }
                    }
                    if (this.bYN) {
                        if (str.charAt(0) != '>') {
                            z = false;
                        }
                        a.bc(z);
                    }
                }
            };
            bYO = anonymousClass1;
            mainLooper.setMessageLogging(anonymousClass1);
        }
    }

    public static void a(a aVar) {
        synchronized (listeners) {
            listeners.add(aVar);
        }
    }

    private static <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            c.e("Matrix.LooperMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void bc(boolean z) {
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.isValid()) {
                if (z) {
                    if (!aVar.bYS) {
                        aVar.dispatchStart();
                    }
                } else if (aVar.bYS) {
                    aVar.dispatchEnd();
                }
            } else if (!z && aVar.bYS) {
                aVar.dispatchEnd();
            }
        }
    }
}
