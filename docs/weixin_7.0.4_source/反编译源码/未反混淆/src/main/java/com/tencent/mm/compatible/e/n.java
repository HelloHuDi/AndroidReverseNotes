package com.tencent.mm.compatible.e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class n {
    private static Map<String, String> esN = null;

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            AppMethodBeat.i(92945);
            if (Pattern.matches("cpu[0-9]", file.getName())) {
                AppMethodBeat.o(92945);
                return true;
            }
            AppMethodBeat.o(92945);
            return false;
        }
    }

    public static Map<String, String> LA() {
        AppMethodBeat.i(92946);
        if (esN == null) {
            esN = LF();
        }
        Map map = esN;
        AppMethodBeat.o(92946);
        return map;
    }

    public static String LB() {
        AppMethodBeat.i(92947);
        if (esN == null) {
            esN = LF();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(": ");
        stringBuilder.append(b(esN, "Features"));
        stringBuilder.append(": ");
        stringBuilder.append(b(esN, "Processor"));
        stringBuilder.append(": ");
        stringBuilder.append(b(esN, "CPU architecture"));
        stringBuilder.append(": ");
        stringBuilder.append(b(esN, "Hardware"));
        stringBuilder.append(": ");
        stringBuilder.append(b(esN, "Serial"));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(92947);
        return stringBuilder2;
    }

    public static boolean LC() {
        AppMethodBeat.i(92948);
        if (esN == null) {
            esN = LF();
        }
        if (esN != null) {
            String b = b(esN, "Features");
            if (b != null && b.contains("neon")) {
                AppMethodBeat.o(92948);
                return true;
            } else if (b != null && b.contains("asimd")) {
                AppMethodBeat.o(92948);
                return true;
            }
        }
        AppMethodBeat.o(92948);
        return false;
    }

    public static boolean LE() {
        AppMethodBeat.i(92950);
        if (esN == null) {
            esN = LF();
        }
        if (esN != null) {
            String b = b(esN, "CPU architecture");
            ab.d("CpuFeatures", "arch ".concat(String.valueOf(b)));
            if (b != null) {
                try {
                    if (b.length() > 0) {
                        int i = bo.getInt(kt(ks(b)), 0);
                        ab.d("CpuFeatures", "armarch ".concat(String.valueOf(i)));
                        if (i >= 6) {
                            AppMethodBeat.o(92950);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(92950);
        return false;
    }

    public static int getNumCores() {
        AppMethodBeat.i(92951);
        try {
            int length = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            AppMethodBeat.o(92951);
            return length;
        } catch (Exception e) {
            AppMethodBeat.o(92951);
            return 1;
        }
    }

    private static boolean q(char c) {
        if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    private static String ks(String str) {
        AppMethodBeat.i(92952);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    while (!q(str.charAt(0))) {
                        if (str.length() == 1) {
                            AppMethodBeat.o(92952);
                            return null;
                        }
                        str = str.substring(1);
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(92952);
        return str;
    }

    private static String kt(String str) {
        int i;
        AppMethodBeat.i(92953);
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            try {
                if (!q(str.charAt(i2)) || str.length() <= i) {
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("CpuFeatures", e, "", new Object[0]);
                AppMethodBeat.o(92953);
            }
        }
        i2 = i - 1;
        if (str.length() > i2 + 1 && i2 > 0) {
            str = str.substring(0, i2);
        }
        AppMethodBeat.o(92953);
        return str;
    }

    private static String b(Map<String, String> map, String str) {
        AppMethodBeat.i(92954);
        String str2 = (String) map.get(str);
        AppMethodBeat.o(92954);
        return str2;
    }

    public static HashMap<String, String> LF() {
        Throwable e;
        AppMethodBeat.i(92955);
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
                        ab.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
                        bo.b(bufferedReader);
                        AppMethodBeat.o(92955);
                        return hashMap;
                    } catch (Throwable th) {
                        e = th;
                        bo.b(bufferedReader);
                        AppMethodBeat.o(92955);
                        throw e;
                    }
                }
            }
            bo.b(bufferedReader);
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            ab.printErrStackTrace("CpuFeatures", e, "getCpu() failed.", new Object[0]);
            bo.b(bufferedReader);
            AppMethodBeat.o(92955);
            return hashMap;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bo.b(bufferedReader);
            AppMethodBeat.o(92955);
            throw e;
        }
        AppMethodBeat.o(92955);
        return hashMap;
    }

    public static boolean LD() {
        AppMethodBeat.i(92949);
        try {
            boolean z;
            if (VERSION.SDK_INT >= 4) {
                z = true;
            } else {
                z = false;
            }
            if (z && LC()) {
                AppMethodBeat.o(92949);
                return true;
            }
            AppMethodBeat.o(92949);
            return false;
        } catch (IncompatibleClassChangeError e) {
            ab.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
            AppMethodBeat.o(92949);
            throw e2;
        } catch (Throwable th) {
            AppMethodBeat.o(92949);
            return false;
        }
    }
}
