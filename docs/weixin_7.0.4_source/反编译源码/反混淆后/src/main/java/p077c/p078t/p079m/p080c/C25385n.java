package p077c.p078t.p079m.p080c;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: c.t.m.c.n */
public class C25385n implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static final String f5211a = TencentLocation.class.getPackage().getName();
    /* renamed from: d */
    private static C25385n f5212d = null;
    /* renamed from: b */
    private Context f5213b;
    /* renamed from: c */
    private UncaughtExceptionHandler f5214c;
    /* renamed from: e */
    private volatile boolean f5215e = false;
    /* renamed from: f */
    private CountDownLatch f5216f;

    /* renamed from: c.t.m.c.n$a */
    class C25386a extends Thread {
        /* renamed from: b */
        private String f5218b;

        public C25386a(String str) {
            this.f5218b = str;
        }

        public void run() {
            AppMethodBeat.m2504i(136388);
            C25383e.m40076a(C25385n.this.f5213b).mo42396a(this.f5218b);
            C25385n.this.f5216f.countDown();
            AppMethodBeat.m2505o(136388);
        }
    }

    static {
        AppMethodBeat.m2504i(136394);
        AppMethodBeat.m2505o(136394);
    }

    private C25385n(Context context) {
        this.f5213b = context;
    }

    /* renamed from: a */
    public static C25385n m40087a(Context context) {
        AppMethodBeat.m2504i(136389);
        if (f5212d == null) {
            synchronized (C25385n.class) {
                try {
                    if (f5212d == null) {
                        f5212d = new C25385n(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136389);
                    }
                }
            }
        }
        C25385n c25385n = f5212d;
        AppMethodBeat.m2505o(136389);
        return c25385n;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.m2504i(136390);
        if (m40088a(th) && this.f5213b != null) {
            String b = m40089b(th);
            if (!(b.contains("onLocationChanged") || b.contains("onStatusUpdate"))) {
                C37150q.m62212a(this.f5213b, "__bad_dex_info__", C37150q.f15845b);
                C37150q.m62211a(this.f5213b, "__loc_sdk_run_duration__", Long.valueOf(System.currentTimeMillis() - C37150q.f15846c));
                b = "EXP:" + C37150q.f15845b + "," + b;
                if (b.contains(IOUtils.LINE_SEPARATOR_UNIX)) {
                    b = b.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "$");
                }
                this.f5216f = new CountDownLatch(1);
                new C25386a(b).start();
                try {
                    this.f5216f.await(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                }
                TencentLocationManager.getInstance(this.f5213b).removeUpdates(null);
                AppMethodBeat.m2505o(136390);
                return;
            }
        }
        if (this.f5214c != null) {
            this.f5214c.uncaughtException(thread, th);
        }
        AppMethodBeat.m2505o(136390);
    }

    /* renamed from: a */
    private boolean m40088a(Throwable th) {
        AppMethodBeat.m2504i(136391);
        if (th == null) {
            AppMethodBeat.m2505o(136391);
            return false;
        }
        while (th != null) {
            for (StackTraceElement fileName : th.getStackTrace()) {
                if ("TL".equals(fileName.getFileName())) {
                    AppMethodBeat.m2505o(136391);
                    return true;
                }
            }
            th = th.getCause();
        }
        AppMethodBeat.m2505o(136391);
        return false;
    }

    /* renamed from: a */
    public void mo42404a() {
        AppMethodBeat.m2504i(136392);
        if (!this.f5215e) {
            this.f5214c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(f5212d);
            this.f5215e = true;
        }
        AppMethodBeat.m2505o(136392);
    }

    /* renamed from: b */
    private String m40089b(Throwable th) {
        AppMethodBeat.m2504i(136393);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
        } catch (Throwable th2) {
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(136393);
        return stringBuffer2;
    }
}
