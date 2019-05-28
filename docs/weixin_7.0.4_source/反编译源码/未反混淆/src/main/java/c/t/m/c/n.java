package c.t.m.c;

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

public class n implements UncaughtExceptionHandler {
    private static final String a = TencentLocation.class.getPackage().getName();
    private static n d = null;
    private Context b;
    private UncaughtExceptionHandler c;
    private volatile boolean e = false;
    private CountDownLatch f;

    class a extends Thread {
        private String b;

        public a(String str) {
            this.b = str;
        }

        public void run() {
            AppMethodBeat.i(136388);
            e.a(n.this.b).a(this.b);
            n.this.f.countDown();
            AppMethodBeat.o(136388);
        }
    }

    static {
        AppMethodBeat.i(136394);
        AppMethodBeat.o(136394);
    }

    private n(Context context) {
        this.b = context;
    }

    public static n a(Context context) {
        AppMethodBeat.i(136389);
        if (d == null) {
            synchronized (n.class) {
                try {
                    if (d == null) {
                        d = new n(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136389);
                    }
                }
            }
        }
        n nVar = d;
        AppMethodBeat.o(136389);
        return nVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(136390);
        if (a(th) && this.b != null) {
            String b = b(th);
            if (!(b.contains("onLocationChanged") || b.contains("onStatusUpdate"))) {
                q.a(this.b, "__bad_dex_info__", q.b);
                q.a(this.b, "__loc_sdk_run_duration__", Long.valueOf(System.currentTimeMillis() - q.c));
                b = "EXP:" + q.b + "," + b;
                if (b.contains(IOUtils.LINE_SEPARATOR_UNIX)) {
                    b = b.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "$");
                }
                this.f = new CountDownLatch(1);
                new a(b).start();
                try {
                    this.f.await(3000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                }
                TencentLocationManager.getInstance(this.b).removeUpdates(null);
                AppMethodBeat.o(136390);
                return;
            }
        }
        if (this.c != null) {
            this.c.uncaughtException(thread, th);
        }
        AppMethodBeat.o(136390);
    }

    private boolean a(Throwable th) {
        AppMethodBeat.i(136391);
        if (th == null) {
            AppMethodBeat.o(136391);
            return false;
        }
        while (th != null) {
            for (StackTraceElement fileName : th.getStackTrace()) {
                if ("TL".equals(fileName.getFileName())) {
                    AppMethodBeat.o(136391);
                    return true;
                }
            }
            th = th.getCause();
        }
        AppMethodBeat.o(136391);
        return false;
    }

    public void a() {
        AppMethodBeat.i(136392);
        if (!this.e) {
            this.c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(d);
            this.e = true;
        }
        AppMethodBeat.o(136392);
    }

    private String b(Throwable th) {
        AppMethodBeat.i(136393);
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
        AppMethodBeat.o(136393);
        return stringBuffer2;
    }
}
