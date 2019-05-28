package com.facebook.device.yearclass;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public final boolean accept(File file) {
            AppMethodBeat.i(114625);
            String name = file.getName();
            if (name.startsWith("cpu")) {
                int i = 3;
                while (i < name.length()) {
                    if (Character.isDigit(name.charAt(i))) {
                        i++;
                    } else {
                        AppMethodBeat.o(114625);
                        return false;
                    }
                }
                AppMethodBeat.o(114625);
                return true;
            }
            AppMethodBeat.o(114625);
            return false;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    public static int getNumberOfCPUCores() {
        AppMethodBeat.i(114626);
        if (VERSION.SDK_INT <= 10) {
            AppMethodBeat.o(114626);
            return 1;
        }
        int coresFromFileInfo;
        try {
            coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromCPUFileList();
            }
        } catch (SecurityException e) {
            coresFromFileInfo = -1;
        } catch (NullPointerException e2) {
            coresFromFileInfo = -1;
        }
        AppMethodBeat.o(114626);
        return coresFromFileInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A:{SYNTHETIC, Splitter:B:16:0x0038} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCoresFromFileInfo(String str) {
        Throwable th;
        InputStream inputStream;
        AppMethodBeat.i(114627);
        InputStream inputStream2 = null;
        try {
            InputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int coresFromFileString = getCoresFromFileString(readLine);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
                AppMethodBeat.o(114627);
                return coresFromFileString;
            } catch (IOException e2) {
                inputStream2 = fileInputStream;
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                }
                AppMethodBeat.o(114627);
                throw th;
            }
        } catch (IOException e3) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(114627);
            return -1;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(114627);
            throw th;
        }
    }

    static int getCoresFromFileString(String str) {
        AppMethodBeat.i(114628);
        if (str == null || !str.matches("0-[\\d]+$")) {
            AppMethodBeat.o(114628);
            return -1;
        }
        int intValue = Integer.valueOf(str.substring(2)).intValue() + 1;
        AppMethodBeat.o(114628);
        return intValue;
    }

    private static int getCoresFromCPUFileList() {
        AppMethodBeat.i(114629);
        int length = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        AppMethodBeat.o(114629);
        return length;
    }

    static {
        AppMethodBeat.i(114634);
        AppMethodBeat.o(114634);
    }

    public static int getCPUMaxFreqKHz() {
        int i;
        FileInputStream fileInputStream;
        AppMethodBeat.i(114630);
        int i2 = -1;
        for (int i3 = 0; i3 < getNumberOfCPUCores(); i3++) {
            FileInputStream fileInputStream2;
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    fileInputStream2 = new FileInputStream(file);
                    fileInputStream2.read(bArr);
                    i = 0;
                    while (Character.isDigit(bArr[i]) && i < 128) {
                        i++;
                    }
                    Integer valueOf = Integer.valueOf(bo.ank(new String(bArr, 0, i)));
                    if (valueOf.intValue() > i2) {
                        i2 = valueOf.intValue();
                    }
                    fileInputStream2.close();
                }
            } catch (NumberFormatException e) {
                fileInputStream2.close();
            } catch (IOException e2) {
                i2 = -1;
            } catch (Throwable th) {
                fileInputStream2.close();
                AppMethodBeat.o(114630);
            }
        }
        if (i2 == -1) {
            fileInputStream = new FileInputStream("/proc/cpuinfo");
            i = parseFileForValue("cpu MHz", fileInputStream) * 1000;
            if (i > i2) {
                i2 = i;
            }
            fileInputStream.close();
        }
        AppMethodBeat.o(114630);
        return i2;
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        AppMethodBeat.i(114631);
        long j;
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j = memoryInfo.totalMem;
            AppMethodBeat.o(114631);
            return j;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) parseFileForValue("MemTotal", fileInputStream)) * 1024;
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        } catch (IOException e2) {
            j = -1;
        } catch (Throwable th) {
            fileInputStream.close();
            AppMethodBeat.o(114631);
        }
        AppMethodBeat.o(114631);
        return j;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        AppMethodBeat.i(114632);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == (byte) 10 || i == 0) {
                    if (bArr[i] == (byte) 10) {
                        i++;
                    }
                    int i2 = i;
                    while (i2 < read) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            continue;
                            break;
                        } else if (i3 == str.length() - 1) {
                            i = extractValue(bArr, i2);
                            AppMethodBeat.o(114632);
                            return i;
                        } else {
                            i2++;
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException | NumberFormatException e) {
        }
        AppMethodBeat.o(114632);
        return -1;
    }

    private static int extractValue(byte[] bArr, int i) {
        AppMethodBeat.i(114633);
        while (i < bArr.length && bArr[i] != (byte) 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                i2 = bo.ank(new String(bArr, 0, i, i2 - i));
                AppMethodBeat.o(114633);
                return i2;
            }
            i++;
        }
        AppMethodBeat.o(114633);
        return -1;
    }
}
