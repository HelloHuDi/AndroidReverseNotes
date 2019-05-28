package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class c {
    private static long cdW;
    private static final List<a> ivN = Collections.synchronizedList(new LinkedList());

    public static class a {
        long aZV;
        String appId;
        String category;
        String ivO;
        String ivP;
        String name;
        long start;

        public final String toString() {
            AppMethodBeat.i(114382);
            String str = this.name + "," + this.category + "," + this.ivO + "," + (this.start - c.cdW) + "," + (this.aZV - c.cdW) + "," + this.ivP;
            AppMethodBeat.o(114382);
            return str;
        }
    }

    static {
        AppMethodBeat.i(114389);
        AppMethodBeat.o(114389);
    }

    public static void gs(long j) {
        cdW = j;
    }

    public static void a(String str, String str2, long j, long j2) {
        AppMethodBeat.i(114383);
        a(str, "Native", str2, j, j2, null);
        AppMethodBeat.o(114383);
    }

    public static void a(String str, String str2, String str3, long j, long j2, String str4) {
        AppMethodBeat.i(114384);
        a(str, str2, str3, "X", j, j2, str4);
        AppMethodBeat.o(114384);
    }

    public static void a(String str, String str2, String str3, double d) {
        AppMethodBeat.i(114385);
        long currentTimeMillis = System.currentTimeMillis();
        String format = String.format("{ \"%s\": %f }", new Object[]{str3, Double.valueOf(d)});
        a(str, str2, str3, "C", currentTimeMillis, currentTimeMillis, format);
        AppMethodBeat.o(114385);
    }

    public static void a(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        AppMethodBeat.i(114386);
        a aVar = new a();
        aVar.appId = str;
        aVar.name = str3;
        aVar.category = str2;
        aVar.ivO = str4;
        aVar.start = j;
        aVar.aZV = j2;
        if (str5 != null) {
            encode = URLEncoder.encode(str5);
        } else {
            encode = "";
        }
        aVar.ivP = encode;
        if (ivN.size() < Downloads.MIN_WAIT_FOR_NETWORK) {
            ivN.add(aVar);
        }
        AppMethodBeat.o(114386);
    }

    static boolean Do(String str) {
        AppMethodBeat.i(114387);
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (ivN) {
            try {
                if (ivN.size() == 0) {
                } else {
                    ab.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", Integer.valueOf(ivN.size()));
                    for (a aVar : ivN) {
                        if (aVar.appId.equals(str) && aVar.start >= cdW) {
                            stringBuilder.append(aVar.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    }
                    ivN.clear();
                    boolean cJ = cJ(str, stringBuilder.toString());
                    AppMethodBeat.o(114387);
                    return cJ;
                }
            } finally {
                AppMethodBeat.o(114387);
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086 A:{SYNTHETIC, Splitter:B:18:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091 A:{SYNTHETIC, Splitter:B:25:0x0091} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean cJ(String str, String str2) {
        Object e;
        Throwable th;
        boolean z = true;
        AppMethodBeat.i(114388);
        if (f.Mn()) {
            FileWriter fileWriter = null;
            try {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/appbrand/trace/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileWriter fileWriter2 = new FileWriter(new File(file, String.format("trace_%s_%d", new Object[]{str, Long.valueOf(cdW)})), true);
                try {
                    fileWriter2.write(str2);
                    try {
                        fileWriter2.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = fileWriter2;
                    try {
                        ab.e("MicroMsg.AppBrandPerformanceTracer", "dump file error: ".concat(String.valueOf(e)));
                        if (fileWriter == null) {
                        }
                        AppMethodBeat.o(114388);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                        }
                        AppMethodBeat.o(114388);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    AppMethodBeat.o(114388);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                ab.e("MicroMsg.AppBrandPerformanceTracer", "dump file error: ".concat(String.valueOf(e)));
                if (fileWriter == null) {
                    try {
                        fileWriter.close();
                        z = false;
                    } catch (Exception e6) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                AppMethodBeat.o(114388);
                return z;
            }
            AppMethodBeat.o(114388);
            return z;
        }
        ab.e("MicroMsg.AppBrandPerformanceTracer", "dumpToFile error, SDCard is unavailable.");
        AppMethodBeat.o(114388);
        return false;
    }
}
