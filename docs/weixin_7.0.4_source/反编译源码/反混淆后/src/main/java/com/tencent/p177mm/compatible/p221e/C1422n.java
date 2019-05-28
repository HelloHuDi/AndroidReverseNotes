package com.tencent.p177mm.compatible.p221e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.compatible.e.n */
public final class C1422n {
    private static Map<String, String> esN = null;

    /* renamed from: com.tencent.mm.compatible.e.n$a */
    class C1421a implements FileFilter {
        C1421a() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.m2504i(92945);
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                AppMethodBeat.m2505o(92945);
                return true;
            }
            AppMethodBeat.m2505o(92945);
            return false;
        }
    }

    /* renamed from: LA */
    public static Map<String, String> m3011LA() {
        AppMethodBeat.m2504i(92946);
        if (esN == null) {
            esN = C1422n.m3016LF();
        }
        Map map = esN;
        AppMethodBeat.m2505o(92946);
        return map;
    }

    /* renamed from: LB */
    public static String m3012LB() {
        AppMethodBeat.m2504i(92947);
        if (esN == null) {
            esN = C1422n.m3016LF();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        stringBuilder.append(C1422n.m3017b(esN, "Features"));
        stringBuilder.append(": ");
        stringBuilder.append(C1422n.m3017b(esN, "Processor"));
        stringBuilder.append(": ");
        stringBuilder.append(C1422n.m3017b(esN, "CPU architecture"));
        stringBuilder.append(": ");
        stringBuilder.append(C1422n.m3017b(esN, "Hardware"));
        stringBuilder.append(": ");
        stringBuilder.append(C1422n.m3017b(esN, "Serial"));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(92947);
        return stringBuilder2;
    }

    /* renamed from: LC */
    public static boolean m3013LC() {
        AppMethodBeat.m2504i(92948);
        if (esN == null) {
            esN = C1422n.m3016LF();
        }
        if (esN != null) {
            String b = C1422n.m3017b(esN, "Features");
            if (b != null && b.contains("neon")) {
                AppMethodBeat.m2505o(92948);
                return true;
            } else if (b != null && b.contains("asimd")) {
                AppMethodBeat.m2505o(92948);
                return true;
            }
        }
        AppMethodBeat.m2505o(92948);
        return false;
    }

    /* renamed from: LE */
    public static boolean m3015LE() {
        AppMethodBeat.m2504i(92950);
        if (esN == null) {
            esN = C1422n.m3016LF();
        }
        if (esN != null) {
            String b = C1422n.m3017b(esN, "CPU architecture");
            C4990ab.m7410d("CpuFeatures", "arch ".concat(String.valueOf(b)));
            if (b != null) {
                try {
                    if (b.length() > 0) {
                        int i = C5046bo.getInt(C1422n.m3019kt(C1422n.m3018ks(b)), 0);
                        C4990ab.m7410d("CpuFeatures", "armarch ".concat(String.valueOf(i)));
                        if (i >= 6) {
                            AppMethodBeat.m2505o(92950);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(92950);
        return false;
    }

    public static int getNumCores() {
        AppMethodBeat.m2504i(92951);
        try {
            int length = new File("/sys/devices/system/cpu/").listFiles(new C1421a()).length;
            AppMethodBeat.m2505o(92951);
            return length;
        } catch (Exception e) {
            AppMethodBeat.m2505o(92951);
            return 1;
        }
    }

    /* renamed from: q */
    private static boolean m3020q(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    /* renamed from: ks */
    private static String m3018ks(String str) {
        AppMethodBeat.m2504i(92952);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    while (!C1422n.m3020q(str.charAt(0))) {
                        if (str.length() == 1) {
                            AppMethodBeat.m2505o(92952);
                            return null;
                        }
                        str = str.substring(1);
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(92952);
        return str;
    }

    /* renamed from: kt */
    private static String m3019kt(String str) {
        int i;
        AppMethodBeat.m2504i(92953);
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            try {
                if (!C1422n.m3020q(str.charAt(i2)) || str.length() <= i) {
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
                AppMethodBeat.m2505o(92953);
            }
        }
        i2 = i - 1;
        if (str.length() > i2 + 1 && i2 > 0) {
            str = str.substring(0, i2);
        }
        AppMethodBeat.m2505o(92953);
        return str;
    }

    /* renamed from: b */
    private static String m3017b(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(92954);
        String str2 = (String) map.get(str);
        AppMethodBeat.m2505o(92954);
        return str2;
    }

    /* renamed from: LF */
    public static HashMap<String, String> m3016LF() {
        Throwable e;
        AppMethodBeat.m2504i(92955);
        HashMap hashMap = new HashMap();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, 2);
                    if (split != null && split.length >= 2) {
                        String trim = split[0].trim();
                        readLine = split[1].trim();
                        if (hashMap.get(trim) == null) {
                            hashMap.put(trim, readLine);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                        C5046bo.m7527b(bufferedReader);
                        AppMethodBeat.m2505o(92955);
                        return hashMap;
                    } catch (Throwable th) {
                        e = th;
                        C5046bo.m7527b(bufferedReader);
                        AppMethodBeat.m2505o(92955);
                        throw e;
                    }
                }
            }
            C5046bo.m7527b(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            C4990ab.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92955);
            return hashMap;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            C5046bo.m7527b(bufferedReader);
            AppMethodBeat.m2505o(92955);
            throw e;
        }
        AppMethodBeat.m2505o(92955);
        return hashMap;
    }

    /* renamed from: LD */
    public static boolean m3014LD() {
        AppMethodBeat.m2504i(92949);
        try {
            boolean z;
            if (VERSION.SDK_INT >= 4) {
                z = true;
            } else {
                z = false;
            }
            if (z && C1422n.m3013LC()) {
                AppMethodBeat.m2505o(92949);
                return true;
            }
            AppMethodBeat.m2505o(92949);
            return false;
        } catch (IncompatibleClassChangeError e) {
            C4990ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
            AppMethodBeat.m2505o(92949);
            throw e2;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(92949);
            return false;
        }
    }
}
