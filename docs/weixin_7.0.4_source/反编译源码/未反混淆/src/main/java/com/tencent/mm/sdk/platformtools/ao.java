package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.ci.j;
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

public final class ao implements UncaughtExceptionHandler {
    private static ao xzq = null;
    private d xzr;
    private com.tencent.mm.sdk.a.a xzs;
    public a xzt;
    public Map<String, b> xzu;
    private UncaughtExceptionHandler xzv;
    private boolean xzw;
    private List<c> xzx;

    public interface a {
        void Bl();
    }

    public interface b {
        String abq();
    }

    public interface c {
        void b(String str, Throwable th);
    }

    public interface d {
        void a(ao aoVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (ao.class) {
            if (xzq == null) {
                xzq = new ao();
            }
            xzq.xzr = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.a.a aVar) {
        synchronized (ao.class) {
            if (xzq == null) {
                xzq = new ao();
            }
            xzq.xzs = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ao.class) {
            if (xzq == null) {
                xzq = new ao();
            }
            xzq.xzt = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (ao.class) {
            if (xzq == null) {
                xzq = new ao();
            }
            xzq.xzu.put(str, bVar);
        }
    }

    public static synchronized void D(String str, final String str2, boolean z) {
        synchronized (ao.class) {
            a(str, new b() {
                public final String abq() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (ao.class) {
            if (cVar != null) {
                if (xzq == null) {
                    xzq = new ao();
                }
                xzq.xzx.add(cVar);
            }
        }
    }

    private ao() {
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

    public static String m(Throwable th) {
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
        String amD = amD(byteArrayOutputStream.toString());
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
                final String amD = amD(byteArrayOutputStream.toString());
                if (!(this.xzs == null || amD == null)) {
                    HandlerThread handlerThread = new HandlerThread("close-db-while-crash");
                    handlerThread.start();
                    final j jVar = new j();
                    new Handler(handlerThread.getLooper()).post(new Runnable() {
                        public final void run() {
                            ao.this.xzs.lG(amD);
                            j jVar = jVar;
                            synchronized (jVar.eHH) {
                                if (jVar.eHH[0] == (byte) 0) {
                                    jVar.eHH[0] = (byte) 1;
                                    jVar.eHH.notifyAll();
                                    ab.i("MicroMsg.WxTimeoutLock", "notify done %s", jVar);
                                }
                            }
                        }
                    });
                    jVar.dOX();
                }
                if (!(this.xzr == null || amD == null)) {
                    this.xzr.a(this, amD, th);
                    this.xzt.Bl();
                }
                for (c cVar : this.xzx) {
                    if (cVar != null) {
                        try {
                            cVar.b(amD, th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            ab.appenderClose();
            if (f.DEBUG) {
                this.xzv.uncaughtException(thread, th);
                return;
            }
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
