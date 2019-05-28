package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NativeProperty {
    private static final int ARM_FEATURE_ARMv7 = 1;
    private static final int ARM_FEATURE_NEON = 4;
    private static final int FAMILY_ARM = 1;
    private static final int FAMILY_ARM64 = 4;
    private static int cpuFamily = 1;
    private static int cpuFeature;

    private static native int nGetCpuInfo();

    static {
        AppMethodBeat.m2504i(83937);
        try {
            System.loadLibrary("pitu_tools");
            String systemProperty = getSystemProperty("ro.product.cpu.abi");
            if (systemProperty == null || systemProperty.equals("x86")) {
                cpuFeature = 5;
                AppMethodBeat.m2505o(83937);
                return;
            }
            cpuFeature = nGetCpuInfo();
            AppMethodBeat.m2505o(83937);
        } catch (UnsatisfiedLinkError e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(83937);
        } catch (RuntimeException e2) {
            LogUtils.m50206e(e2);
            AppMethodBeat.m2505o(83937);
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            AppMethodBeat.m2505o(83937);
        }
    }

    public static int cpuFeature() {
        return cpuFeature;
    }

    public static boolean isArmV7Feature() {
        return (1 == cpuFamily && (cpuFeature & 1) != 0) || 4 == cpuFamily;
    }

    public static boolean hasNeonFeature() {
        return 1 == cpuFamily && (cpuFeature & 4) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A:{SYNTHETIC, Splitter:B:22:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A:{SYNTHETIC, Splitter:B:15:0x0044} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getSystemProperty(String str) {
        Throwable e;
        BufferedReader bufferedReader = null;
        AppMethodBeat.m2504i(83936);
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    LogUtils.m50206e(e2);
                }
                AppMethodBeat.m2505o(83936);
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    LogUtils.m50206e(e);
                    if (bufferedReader2 != null) {
                    }
                    AppMethodBeat.m2505o(83936);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            LogUtils.m50206e(e22);
                        }
                    }
                    AppMethodBeat.m2505o(83936);
                    throw e;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = null;
            LogUtils.m50206e(e);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    LogUtils.m50206e(e5);
                }
            }
            AppMethodBeat.m2505o(83936);
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(83936);
            throw e;
        }
    }
}
