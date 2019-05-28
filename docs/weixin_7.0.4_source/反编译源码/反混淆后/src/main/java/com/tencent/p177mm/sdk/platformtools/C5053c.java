package com.tencent.p177mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.tencent.mm.sdk.platformtools.c */
public final class C5053c {
    private static final Handler handler;
    private static final WeakHashMap<Bitmap, C5052a> xxQ = new WeakHashMap();
    private static boolean xxR;

    /* renamed from: com.tencent.mm.sdk.platformtools.c$2 */
    static class C50502 implements Callback {
        boolean xxS = false;
        long xxT = 0;

        C50502() {
        }

        public final boolean handleMessage(Message message) {
            Throwable e;
            AppMethodBeat.m2504i(93298);
            C5053c.xxR = false;
            Runtime runtime = Runtime.getRuntime();
            long totalMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            long maxMemory = runtime.maxMemory();
            C4990ab.m7417i("MicroMsg.BitmapTracer", "Memory level: %s (+%s) / %s", C5053c.m7606mp(totalMemory - freeMemory), C5053c.m7606mp(freeMemory), C5053c.m7606mp(maxMemory));
            if (!this.xxS && totalMemory - freeMemory > 209715200) {
                maxMemory = System.currentTimeMillis();
                if (maxMemory - this.xxT > 180000) {
                    System.gc();
                    this.xxT = maxMemory;
                    AppMethodBeat.m2505o(93298);
                    return true;
                }
                Closeable closeable = null;
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(new GZIPOutputStream(new FileOutputStream(C6457e.eSn + "BitmapTraces.txt.gz")));
                    try {
                        C5053c.m7598a(printWriter);
                        C5046bo.m7527b(printWriter);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.BitmapTracer", e, "", new Object[0]);
                            C5046bo.m7527b(printWriter);
                            Debug.dumpHprofData(C6457e.eSn + "Memory.hprof");
                            this.xxS = true;
                            AppMethodBeat.m2505o(93298);
                            return true;
                        } catch (Throwable th) {
                            e = th;
                            closeable = printWriter;
                            C5046bo.m7527b(closeable);
                            AppMethodBeat.m2505o(93298);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    printWriter = null;
                    C4990ab.printErrStackTrace("MicroMsg.BitmapTracer", e, "", new Object[0]);
                    C5046bo.m7527b(printWriter);
                    Debug.dumpHprofData(C6457e.eSn + "Memory.hprof");
                    this.xxS = true;
                    AppMethodBeat.m2505o(93298);
                    return true;
                } catch (Throwable th2) {
                    e = th2;
                    C5046bo.m7527b(closeable);
                    AppMethodBeat.m2505o(93298);
                    throw e;
                }
                try {
                    Debug.dumpHprofData(C6457e.eSn + "Memory.hprof");
                } catch (Exception e4) {
                    C4990ab.printErrStackTrace("MicroMsg.BitmapTracer", e4, "", new Object[0]);
                }
                this.xxS = true;
            }
            AppMethodBeat.m2505o(93298);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.c$4 */
    static class C50514 extends Writer {
        private StringWriter xxU;

        C50514() {
        }

        public final void write(char[] cArr, int i, int i2) {
            AppMethodBeat.m2504i(93300);
            if (this.xxU == null) {
                this.xxU = new StringWriter();
            }
            this.xxU.write(cArr, i, i2);
            AppMethodBeat.m2505o(93300);
        }

        public final void flush() {
            AppMethodBeat.m2504i(93301);
            if (this.xxU == null) {
                AppMethodBeat.m2505o(93301);
                return;
            }
            String stringWriter = this.xxU.toString();
            this.xxU = null;
            C4990ab.m7420w("MicroMsg.BitmapTracer", stringWriter);
            AppMethodBeat.m2505o(93301);
        }

        public final void close() {
            AppMethodBeat.m2504i(93302);
            flush();
            AppMethodBeat.m2505o(93302);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.c$a */
    static final class C5052a {
        final String source;
        final StackTraceElement[] xxV;
        final Options xxW = null;
        final long xxX = System.currentTimeMillis();

        C5052a(String str) {
            AppMethodBeat.m2504i(93303);
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            this.xxV = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, 4, stackTrace.length);
            this.source = str;
            AppMethodBeat.m2505o(93303);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.c$1 */
    static class C50541 implements C5015a {
        C50541() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(93297);
            C5053c.dnV();
            AppMethodBeat.m2505o(93297);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.c$3 */
    static class C50553 implements C5011c {
        C50553() {
        }

        /* renamed from: b */
        public final void mo4564b(String str, Throwable th) {
            AppMethodBeat.m2504i(93299);
            if (th instanceof OutOfMemoryError) {
                C5053c.dnW();
                AppMethodBeat.m2505o(93299);
                return;
            }
            AppMethodBeat.m2505o(93299);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m7598a(PrintWriter printWriter) {
        AppMethodBeat.m2504i(93314);
        C5053c.m7599a(printWriter, 0, -1);
        AppMethodBeat.m2505o(93314);
    }

    static /* synthetic */ void dnW() {
        AppMethodBeat.m2504i(93315);
        C5053c.m7596I(1048576, -1);
        AppMethodBeat.m2505o(93315);
    }

    /* renamed from: mp */
    static /* synthetic */ String m7606mp(long j) {
        AppMethodBeat.m2504i(93313);
        String mo = C5053c.m7605mo(j);
        AppMethodBeat.m2505o(93313);
        return mo;
    }

    static {
        AppMethodBeat.m2504i(93316);
        HandlerThread handlerThread;
        if (C5047bp.dnM()) {
            handlerThread = new HandlerThread("BitmapTracer");
            handlerThread.start();
            handler = new Handler(handlerThread.getLooper(), new C50502());
        } else {
            handler = null;
            handlerThread = new HandlerThread("BitmapBriefTracer");
            handlerThread.start();
            new C7564ap(handlerThread.getLooper(), new C50541(), true).mo16770ae(120000, 120000);
        }
        C5013ao.m7457a(new C50553());
        AppMethodBeat.m2505o(93316);
    }

    public static void dnV() {
        AppMethodBeat.m2504i(93304);
        C5053c.m7596I(2097152, 3);
        AppMethodBeat.m2505o(93304);
    }

    /* renamed from: I */
    private static void m7596I(long j, int i) {
        AppMethodBeat.m2504i(93305);
        C5053c.m7599a(new PrintWriter(new C50514(), false), j, i);
        AppMethodBeat.m2505o(93305);
    }

    /* renamed from: ag */
    public static Bitmap m7602ag(Bitmap bitmap) {
        AppMethodBeat.m2504i(93306);
        Bitmap g = C5053c.m7604g(bitmap, null);
        AppMethodBeat.m2505o(93306);
        return g;
    }

    /* renamed from: f */
    public static Bitmap m7603f(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(93307);
        Bitmap g = C5053c.m7604g(bitmap, str);
        AppMethodBeat.m2505o(93307);
        return g;
    }

    /* renamed from: g */
    private static Bitmap m7604g(Bitmap bitmap, String str) {
        AppMethodBeat.m2504i(93308);
        if (bitmap == null) {
            AppMethodBeat.m2505o(93308);
            return null;
        } else if (bitmap.getAllocationByteCount() >= 1048576 || C5047bp.dnM()) {
            C5052a c5052a = new C5052a(str);
            synchronized (xxQ) {
                try {
                    xxQ.put(bitmap, c5052a);
                    if (!(handler == null || xxR)) {
                        handler.sendEmptyMessageDelayed(0, 5000);
                        xxR = true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93308);
                }
            }
            return bitmap;
        } else {
            AppMethodBeat.m2505o(93308);
            return bitmap;
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: mo */
    private static String m7605mo(long j) {
        AppMethodBeat.m2504i(93309);
        String format;
        if (j >= 1073741824) {
            format = String.format("%.2f GB", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
            AppMethodBeat.m2505o(93309);
            return format;
        } else if (j >= 1048576) {
            format = String.format("%.2f MB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
            AppMethodBeat.m2505o(93309);
            return format;
        } else if (j >= 1024) {
            format = String.format("%.2f kB", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
            AppMethodBeat.m2505o(93309);
            return format;
        } else {
            format = String.format("%d bytes", new Object[]{Long.valueOf(j)});
            AppMethodBeat.m2505o(93309);
            return format;
        }
    }

    /* renamed from: a */
    private static void m7601a(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        AppMethodBeat.m2504i(93310);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.append("  at ").println(stackTraceElement.toString());
        }
        AppMethodBeat.m2505o(93310);
    }

    /* renamed from: a */
    private static void m7599a(PrintWriter printWriter, long j, int i) {
        PrintWriter printWriter2;
        C5052a c5052a;
        Bitmap bitmap;
        AppMethodBeat.m2504i(93311);
        if (j > 0) {
            printWriter2 = printWriter;
            printWriter2.format("Statistics for all Bitmaps larger than %.2f MB:\n", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
        } else {
            printWriter.print("Statistics for all Bitmaps alive:\n");
        }
        printWriter.flush();
        int i2 = 0;
        int i3 = 0;
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        synchronized (xxQ) {
            try {
                ArrayList<Entry> arrayList = new ArrayList();
                arrayList.addAll(xxQ.entrySet());
                c5052a = null;
                bitmap = null;
                for (Entry entry : arrayList) {
                    Bitmap bitmap2 = (Bitmap) entry.getKey();
                    C5052a c5052a2 = (C5052a) entry.getValue();
                    if (bitmap2 != null) {
                        if (bitmap2.isRecycled()) {
                            i3++;
                        } else {
                            long allocationByteCount = (long) bitmap2.getAllocationByteCount();
                            j2 += allocationByteCount;
                            i2++;
                            if (bitmap == null || allocationByteCount > ((long) bitmap.getAllocationByteCount())) {
                                c5052a = c5052a2;
                                bitmap = bitmap2;
                            }
                            if (allocationByteCount >= j && (i == -1 || j3 < ((long) i))) {
                                j3++;
                                printWriter.append('#').println(i2);
                                C5053c.m7600a(printWriter, bitmap2, c5052a2, currentTimeMillis);
                            }
                            j3 = j3;
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                printWriter.print("ConcurrentModificationException occur.");
                printWriter.flush();
                printWriter.close();
                AppMethodBeat.m2505o(93311);
                return;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(93311);
                    throw th;
                }
            }
        }
        if (!(bitmap == null || c5052a == null)) {
            printWriter.append("# Biggest Bitmap");
            C5053c.m7600a(printWriter, bitmap, c5052a, currentTimeMillis);
        }
        printWriter2 = printWriter;
        printWriter2.format("\n\nLiving Bitmaps: %d, %s\n", new Object[]{Integer.valueOf(i2), C5053c.m7605mo(j2)});
        printWriter.append("Recycled Bitmaps: ").println(i3);
        printWriter.flush();
        printWriter.close();
        AppMethodBeat.m2505o(93311);
    }

    /* renamed from: a */
    private static void m7600a(PrintWriter printWriter, Bitmap bitmap, C5052a c5052a, long j) {
        String str;
        AppMethodBeat.m2504i(93312);
        Config config = bitmap.getConfig();
        String str2 = "\nSize: %s (%d x %d, %s)\n";
        Object[] objArr = new Object[4];
        objArr[0] = C5053c.m7605mo((long) bitmap.getAllocationByteCount());
        objArr[1] = Integer.valueOf(bitmap.getWidth());
        objArr[2] = Integer.valueOf(bitmap.getHeight());
        if (config == null) {
            str = "UNKNOWN";
        } else {
            str = config.name();
        }
        objArr[3] = str;
        printWriter.format(str2, objArr);
        printWriter.append("Source: ").println(c5052a.source);
        printWriter.format("Acquired: %d seconds ago\n", new Object[]{Long.valueOf((j - c5052a.xxX) / 1000)});
        printWriter.print("Stack:\n");
        C5053c.m7601a(c5052a.xxV, printWriter);
        printWriter.print("=======================================================\n");
        printWriter.flush();
        AppMethodBeat.m2505o(93312);
    }
}
