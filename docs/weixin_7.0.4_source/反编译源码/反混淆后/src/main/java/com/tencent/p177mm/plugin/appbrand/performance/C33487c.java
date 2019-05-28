package com.tencent.p177mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.tencent.mm.plugin.appbrand.performance.c */
public final class C33487c {
    private static long cdW;
    private static final List<C33488a> ivN = Collections.synchronizedList(new LinkedList());

    /* renamed from: com.tencent.mm.plugin.appbrand.performance.c$a */
    public static class C33488a {
        long aZV;
        String appId;
        String category;
        String ivO;
        String ivP;
        String name;
        long start;

        public final String toString() {
            AppMethodBeat.m2504i(114382);
            String str = this.name + "," + this.category + "," + this.ivO + "," + (this.start - C33487c.cdW) + "," + (this.aZV - C33487c.cdW) + "," + this.ivP;
            AppMethodBeat.m2505o(114382);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(114389);
        AppMethodBeat.m2505o(114389);
    }

    /* renamed from: gs */
    public static void m54693gs(long j) {
        cdW = j;
    }

    /* renamed from: a */
    public static void m54688a(String str, String str2, long j, long j2) {
        AppMethodBeat.m2504i(114383);
        C33487c.m54690a(str, "Native", str2, j, j2, null);
        AppMethodBeat.m2505o(114383);
    }

    /* renamed from: a */
    public static void m54690a(String str, String str2, String str3, long j, long j2, String str4) {
        AppMethodBeat.m2504i(114384);
        C33487c.m54691a(str, str2, str3, "X", j, j2, str4);
        AppMethodBeat.m2505o(114384);
    }

    /* renamed from: a */
    public static void m54689a(String str, String str2, String str3, double d) {
        AppMethodBeat.m2504i(114385);
        long currentTimeMillis = System.currentTimeMillis();
        String format = String.format("{ \"%s\": %f }", new Object[]{str3, Double.valueOf(d)});
        C33487c.m54691a(str, str2, str3, "C", currentTimeMillis, currentTimeMillis, format);
        AppMethodBeat.m2505o(114385);
    }

    /* renamed from: a */
    public static void m54691a(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        AppMethodBeat.m2504i(114386);
        C33488a c33488a = new C33488a();
        c33488a.appId = str;
        c33488a.name = str3;
        c33488a.category = str2;
        c33488a.ivO = str4;
        c33488a.start = j;
        c33488a.aZV = j2;
        if (str5 != null) {
            encode = URLEncoder.encode(str5);
        } else {
            encode = "";
        }
        c33488a.ivP = encode;
        if (ivN.size() < Downloads.MIN_WAIT_FOR_NETWORK) {
            ivN.add(c33488a);
        }
        AppMethodBeat.m2505o(114386);
    }

    /* renamed from: Do */
    static boolean m54687Do(String str) {
        AppMethodBeat.m2504i(114387);
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (ivN) {
            try {
                if (ivN.size() == 0) {
                } else {
                    C4990ab.m7411d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", Integer.valueOf(ivN.size()));
                    for (C33488a c33488a : ivN) {
                        if (c33488a.appId.equals(str) && c33488a.start >= cdW) {
                            stringBuilder.append(c33488a.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    }
                    ivN.clear();
                    boolean cJ = C33487c.m54692cJ(str, stringBuilder.toString());
                    AppMethodBeat.m2505o(114387);
                    return cJ;
                }
            } finally {
                AppMethodBeat.m2505o(114387);
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086 A:{SYNTHETIC, Splitter:B:18:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091 A:{SYNTHETIC, Splitter:B:25:0x0091} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cJ */
    private static final boolean m54692cJ(String str, String str2) {
        Object e;
        Throwable th;
        boolean z = true;
        AppMethodBeat.m2504i(114388);
        if (C1445f.m3070Mn()) {
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
                        C4990ab.m7412e("MicroMsg.AppBrandPerformanceTracer", "dump file error: ".concat(String.valueOf(e)));
                        if (fileWriter == null) {
                        }
                        AppMethodBeat.m2505o(114388);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                        }
                        AppMethodBeat.m2505o(114388);
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
                    AppMethodBeat.m2505o(114388);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                C4990ab.m7412e("MicroMsg.AppBrandPerformanceTracer", "dump file error: ".concat(String.valueOf(e)));
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
                AppMethodBeat.m2505o(114388);
                return z;
            }
            AppMethodBeat.m2505o(114388);
            return z;
        }
        C4990ab.m7412e("MicroMsg.AppBrandPerformanceTracer", "dumpToFile error, SDCard is unavailable.");
        AppMethodBeat.m2505o(114388);
        return false;
    }
}
