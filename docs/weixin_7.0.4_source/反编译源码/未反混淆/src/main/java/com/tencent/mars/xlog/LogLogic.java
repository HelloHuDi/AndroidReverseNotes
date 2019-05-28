package com.tencent.mars.xlog;

import android.os.Debug;
import android.os.Process;
import com.tencent.mm.protocal.d;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LogLogic {
    static long printVMSizeTime;

    public static native int getAppenderModeFromCfg();

    public static native int getIPxxLogLevel();

    public static native int getLogLevelFromCfg();

    public static native void initIPxxLogInfo();

    public static native void setIPxxLogML(int i, int i2);

    public static String appendMemLog(String str) {
        if (d.vxp) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - printVMSizeTime > 120000) {
            printVMSizeTime = currentTimeMillis;
            return String.format("[%s] %s", new Object[]{getVmStatus(), str});
        }
        return String.format("[%sK] %s", new Object[]{Long.valueOf(getDalvikHeap()), str});
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static String getVmSize() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    return str;
                }
            }
            return split[12];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getVmStatus() {
        String format = String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())});
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(getStringFromFile(format).trim());
            return stringBuilder.toString();
        } catch (Exception e) {
            return stringBuilder.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String convertStreamToString(InputStream inputStream) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine).append(10);
                    } else {
                        bufferedReader.close();
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getStringFromFile(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
