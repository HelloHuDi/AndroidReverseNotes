package com.tencent.p177mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.p177mm.p217ci.C1389j;
import com.tencent.p177mm.sdk.p599a.C4871a;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.platformtools.ao */
public final class C5013ao implements UncaughtExceptionHandler {
    private static C5013ao xzq = null;
    private C5012d xzr;
    private C4871a xzs;
    public C5009a xzt;
    public Map<String, C5010b> xzu;
    private UncaughtExceptionHandler xzv;
    private boolean xzw;
    private List<C5011c> xzx;

    /* renamed from: com.tencent.mm.sdk.platformtools.ao$a */
    public interface C5009a {
        /* renamed from: Bl */
        void mo4542Bl();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ao$b */
    public interface C5010b {
        String abq();
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ao$c */
    public interface C5011c {
        /* renamed from: b */
        void mo4564b(String str, Throwable th);
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.ao$d */
    public interface C5012d {
        /* renamed from: a */
        void mo4541a(C5013ao c5013ao, String str, Throwable th);
    }

    /* renamed from: a */
    public static synchronized void m7458a(C5012d c5012d) {
        synchronized (C5013ao.class) {
            if (xzq == null) {
                xzq = new C5013ao();
            }
            xzq.xzr = c5012d;
        }
    }

    /* renamed from: a */
    public static synchronized void m7455a(C4871a c4871a) {
        synchronized (C5013ao.class) {
            if (xzq == null) {
                xzq = new C5013ao();
            }
            xzq.xzs = c4871a;
        }
    }

    /* renamed from: a */
    public static synchronized void m7456a(C5009a c5009a) {
        synchronized (C5013ao.class) {
            if (xzq == null) {
                xzq = new C5013ao();
            }
            xzq.xzt = c5009a;
        }
    }

    /* renamed from: a */
    public static synchronized void m7459a(String str, C5010b c5010b) {
        synchronized (C5013ao.class) {
            if (xzq == null) {
                xzq = new C5013ao();
            }
            xzq.xzu.put(str, c5010b);
        }
    }

    /* renamed from: D */
    public static synchronized void m7453D(String str, final String str2, boolean z) {
        synchronized (C5013ao.class) {
            C5013ao.m7459a(str, new C5010b() {
                public final String abq() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    /* renamed from: a */
    public static synchronized void m7457a(C5011c c5011c) {
        synchronized (C5013ao.class) {
            if (c5011c != null) {
                if (xzq == null) {
                    xzq = new C5013ao();
                }
                xzq.xzx.add(c5011c);
            }
        }
    }

    private C5013ao() {
        this.xzr = null;
        this.xzs = null;
        this.xzt = null;
        this.xzu = new HashMap();
        this.xzv = null;
        this.xzw = false;
        this.xzx = new LinkedList();
        this.xzv = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String amD(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    /* renamed from: m */
    public static String m7460m(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String amD = C5013ao.amD(byteArrayOutputStream.toString());
        return amD;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.xzw) {
            this.xzw = true;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                final String amD = C5013ao.amD(byteArrayOutputStream.toString());
                if (!(this.xzs == null || amD == null)) {
                    HandlerThread handlerThread = new HandlerThread("close-db-while-crash");
                    handlerThread.start();
                    final C1389j c1389j = new C1389j();
                    new Handler(handlerThread.getLooper()).post(new Runnable() {
                        public final void run() {
                            C5013ao.this.xzs.mo5190lG(amD);
                            C1389j c1389j = c1389j;
                            synchronized (c1389j.eHH) {
                                if (c1389j.eHH[0] == (byte) 0) {
                                    c1389j.eHH[0] = (byte) 1;
                                    c1389j.eHH.notifyAll();
                                    C4990ab.m7417i("MicroMsg.WxTimeoutLock", "notify done %s", c1389j);
                                }
                            }
                        }
                    });
                    c1389j.dOX();
                }
                if (!(this.xzr == null || amD == null)) {
                    this.xzr.mo4541a(this, amD, th);
                    this.xzt.mo4542Bl();
                }
                for (C5011c c5011c : this.xzx) {
                    if (c5011c != null) {
                        try {
                            c5011c.mo4564b(amD, th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            C4990ab.appenderClose();
            if (C5058f.DEBUG) {
                this.xzv.uncaughtException(thread, th);
                return;
            }
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
