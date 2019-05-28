package com.tencent.mm.sdk.platformtools;

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
import com.tencent.mm.compatible.util.e;
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

public final class c {
    private static final Handler handler;
    private static final WeakHashMap<Bitmap, a> xxQ = new WeakHashMap();
    private static boolean xxR;

    static final class a {
        final String source;
        final StackTraceElement[] xxV;
        final Options xxW = null;
        final long xxX = System.currentTimeMillis();

        a(String str) {
            AppMethodBeat.i(93303);
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            this.xxV = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, 4, stackTrace.length);
            this.source = str;
            AppMethodBeat.o(93303);
        }
    }

    static /* synthetic */ void a(PrintWriter printWriter) {
        AppMethodBeat.i(93314);
        a(printWriter, 0, -1);
        AppMethodBeat.o(93314);
    }

    static /* synthetic */ void dnW() {
        AppMethodBeat.i(93315);
        I(1048576, -1);
        AppMethodBeat.o(93315);
    }

    static /* synthetic */ String mp(long j) {
        AppMethodBeat.i(93313);
        String mo = mo(j);
        AppMethodBeat.o(93313);
        return mo;
    }

    static {
        AppMethodBeat.i(93316);
        HandlerThread handlerThread;
        if (bp.dnM()) {
            handlerThread = new HandlerThread("BitmapTracer");
            handlerThread.start();
            handler = new Handler(handlerThread.getLooper(), new Callback() {
                boolean xxS = false;
                long xxT = 0;

                public final boolean handleMessage(Message message) {
                    Throwable e;
                    AppMethodBeat.i(93298);
                    c.xxR = false;
                    Runtime runtime = Runtime.getRuntime();
                    long totalMemory = runtime.totalMemory();
                    long freeMemory = runtime.freeMemory();
                    long maxMemory = runtime.maxMemory();
                    ab.i("MicroMsg.BitmapTracer", "Memory level: %s (+%s) / %s", c.mp(totalMemory - freeMemory), c.mp(freeMemory), c.mp(maxMemory));
                    if (!this.xxS && totalMemory - freeMemory > 209715200) {
                        maxMemory = System.currentTimeMillis();
                        if (maxMemory - this.xxT > 180000) {
                            System.gc();
                            this.xxT = maxMemory;
                            AppMethodBeat.o(93298);
                            return true;
                        }
                        Closeable closeable = null;
                        Closeable printWriter;
                        try {
                            printWriter = new PrintWriter(new GZIPOutputStream(new FileOutputStream(e.eSn + "BitmapTraces.txt.gz")));
                            try {
                                c.a(printWriter);
                                bo.b(printWriter);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    ab.printErrStackTrace("MicroMsg.BitmapTracer", e, "", new Object[0]);
                                    bo.b(printWriter);
                                    Debug.dumpHprofData(e.eSn + "Memory.hprof");
                                    this.xxS = true;
                                    AppMethodBeat.o(93298);
                                    return true;
                                } catch (Throwable th) {
                                    e = th;
                                    closeable = printWriter;
                                    bo.b(closeable);
                                    AppMethodBeat.o(93298);
                                    throw e;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            printWriter = null;
                            ab.printErrStackTrace("MicroMsg.BitmapTracer", e, "", new Object[0]);
                            bo.b(printWriter);
                            Debug.dumpHprofData(e.eSn + "Memory.hprof");
                            this.xxS = true;
                            AppMethodBeat.o(93298);
                            return true;
                        } catch (Throwable th2) {
                            e = th2;
                            bo.b(closeable);
                            AppMethodBeat.o(93298);
                            throw e;
                        }
                        try {
                            Debug.dumpHprofData(e.eSn + "Memory.hprof");
                        } catch (Exception e4) {
                            ab.printErrStackTrace("MicroMsg.BitmapTracer", e4, "", new Object[0]);
                        }
                        this.xxS = true;
                    }
                    AppMethodBeat.o(93298);
                    return true;
                }
            });
        } else {
            handler = null;
            handlerThread = new HandlerThread("BitmapBriefTracer");
            handlerThread.start();
            new ap(handlerThread.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(93297);
                    c.dnV();
                    AppMethodBeat.o(93297);
                    return true;
                }
            }, true).ae(120000, 120000);
        }
        ao.a(new com.tencent.mm.sdk.platformtools.ao.c() {
            public final void b(String str, Throwable th) {
                AppMethodBeat.i(93299);
                if (th instanceof OutOfMemoryError) {
                    c.dnW();
                    AppMethodBeat.o(93299);
                    return;
                }
                AppMethodBeat.o(93299);
            }
        });
        AppMethodBeat.o(93316);
    }

    public static void dnV() {
        AppMethodBeat.i(93304);
        I(2097152, 3);
        AppMethodBeat.o(93304);
    }

    private static void I(long j, int i) {
        AppMethodBeat.i(93305);
        a(new PrintWriter(new Writer() {
            private StringWriter xxU;

            public final void write(char[] cArr, int i, int i2) {
                AppMethodBeat.i(93300);
                if (this.xxU == null) {
                    this.xxU = new StringWriter();
                }
                this.xxU.write(cArr, i, i2);
                AppMethodBeat.o(93300);
            }

            public final void flush() {
                AppMethodBeat.i(93301);
                if (this.xxU == null) {
                    AppMethodBeat.o(93301);
                    return;
                }
                String stringWriter = this.xxU.toString();
                this.xxU = null;
                ab.w("MicroMsg.BitmapTracer", stringWriter);
                AppMethodBeat.o(93301);
            }

            public final void close() {
                AppMethodBeat.i(93302);
                flush();
                AppMethodBeat.o(93302);
            }
        }, false), j, i);
        AppMethodBeat.o(93305);
    }

    public static Bitmap ag(Bitmap bitmap) {
        AppMethodBeat.i(93306);
        Bitmap g = g(bitmap, null);
        AppMethodBeat.o(93306);
        return g;
    }

    public static Bitmap f(Bitmap bitmap, String str) {
        AppMethodBeat.i(93307);
        Bitmap g = g(bitmap, str);
        AppMethodBeat.o(93307);
        return g;
    }

    private static Bitmap g(Bitmap bitmap, String str) {
        AppMethodBeat.i(93308);
        if (bitmap == null) {
            AppMethodBeat.o(93308);
            return null;
        } else if (bitmap.getAllocationByteCount() >= 1048576 || bp.dnM()) {
            a aVar = new a(str);
            synchronized (xxQ) {
                try {
                    xxQ.put(bitmap, aVar);
                    if (!(handler == null || xxR)) {
                        handler.sendEmptyMessageDelayed(0, 5000);
                        xxR = true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93308);
                }
            }
            return bitmap;
        } else {
            AppMethodBeat.o(93308);
            return bitmap;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String mo(long j) {
        AppMethodBeat.i(93309);
        String format;
        if (j >= 1073741824) {
            format = String.format("%.2f GB", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
            AppMethodBeat.o(93309);
            return format;
        } else if (j >= 1048576) {
            format = String.format("%.2f MB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
            AppMethodBeat.o(93309);
            return format;
        } else if (j >= 1024) {
            format = String.format("%.2f kB", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
            AppMethodBeat.o(93309);
            return format;
        } else {
            format = String.format("%d bytes", new Object[]{Long.valueOf(j)});
            AppMethodBeat.o(93309);
            return format;
        }
    }

    private static void a(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        AppMethodBeat.i(93310);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.append("  at ").println(stackTraceElement.toString());
        }
        AppMethodBeat.o(93310);
    }

    private static void a(PrintWriter printWriter, long j, int i) {
        PrintWriter printWriter2;
        a aVar;
        Bitmap bitmap;
        AppMethodBeat.i(93311);
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
                aVar = null;
                bitmap = null;
                for (Entry entry : arrayList) {
                    Bitmap bitmap2 = (Bitmap) entry.getKey();
                    a aVar2 = (a) entry.getValue();
                    if (bitmap2 != null) {
                        if (bitmap2.isRecycled()) {
                            i3++;
                        } else {
                            long allocationByteCount = (long) bitmap2.getAllocationByteCount();
                            j2 += allocationByteCount;
                            i2++;
                            if (bitmap == null || allocationByteCount > ((long) bitmap.getAllocationByteCount())) {
                                aVar = aVar2;
                                bitmap = bitmap2;
                            }
                            if (allocationByteCount >= j && (i == -1 || j3 < ((long) i))) {
                                j3++;
                                printWriter.append('#').println(i2);
                                a(printWriter, bitmap2, aVar2, currentTimeMillis);
                            }
                            j3 = j3;
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                printWriter.print("ConcurrentModificationException occur.");
                printWriter.flush();
                printWriter.close();
                AppMethodBeat.o(93311);
                return;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(93311);
                    throw th;
                }
            }
        }
        if (!(bitmap == null || aVar == null)) {
            printWriter.append("# Biggest Bitmap");
            a(printWriter, bitmap, aVar, currentTimeMillis);
        }
        printWriter2 = printWriter;
        printWriter2.format("\n\nLiving Bitmaps: %d, %s\n", new Object[]{Integer.valueOf(i2), mo(j2)});
        printWriter.append("Recycled Bitmaps: ").println(i3);
        printWriter.flush();
        printWriter.close();
        AppMethodBeat.o(93311);
    }

    private static void a(PrintWriter printWriter, Bitmap bitmap, a aVar, long j) {
        String str;
        AppMethodBeat.i(93312);
        Config config = bitmap.getConfig();
        String str2 = "\nSize: %s (%d x %d, %s)\n";
        Object[] objArr = new Object[4];
        objArr[0] = mo((long) bitmap.getAllocationByteCount());
        objArr[1] = Integer.valueOf(bitmap.getWidth());
        objArr[2] = Integer.valueOf(bitmap.getHeight());
        if (config == null) {
            str = "UNKNOWN";
        } else {
            str = config.name();
        }
        objArr[3] = str;
        printWriter.format(str2, objArr);
        printWriter.append("Source: ").println(aVar.source);
        printWriter.format("Acquired: %d seconds ago\n", new Object[]{Long.valueOf((j - aVar.xxX) / 1000)});
        printWriter.print("Stack:\n");
        a(aVar.xxV, printWriter);
        printWriter.print("=======================================================\n");
        printWriter.flush();
        AppMethodBeat.o(93312);
    }
}
