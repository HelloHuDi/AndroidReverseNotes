package com.tencent.matrix.d;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Process;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static a caC = null;
    private static long caD = 0;
    private static long caE = 0;
    private static int caF = 0;

    public enum a {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static JSONObject a(JSONObject jSONObject, Application application) {
        try {
            jSONObject.put("machine", aC(application));
            jSONObject.put("cpu_app", zH());
            jSONObject.put("mem", getTotalMemory(application));
            jSONObject.put("mem_free", zG());
        } catch (JSONException e) {
            c.e("Matrix.DeviceUtil", "[JSONException for stack, error: %s", e);
        }
        return jSONObject;
    }

    public static a aC(Context context) {
        if (caC != null) {
            return caC;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long totalMemory = getTotalMemory(context);
        int zI = zI();
        c.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(totalMemory), Integer.valueOf(zI));
        if (totalMemory >= 4294967296L) {
            caC = a.BEST;
        } else if (totalMemory >= 3221225472L) {
            caC = a.HIGH;
        } else if (totalMemory >= 2147483648L) {
            if (zI >= 4) {
                caC = a.HIGH;
            } else if (zI >= 2) {
                caC = a.MIDDLE;
            } else if (zI > 0) {
                caC = a.LOW;
            }
        } else if (totalMemory >= 1073741824) {
            if (zI >= 4) {
                caC = a.MIDDLE;
            } else if (zI >= 2) {
                caC = a.LOW;
            } else if (zI > 0) {
                caC = a.LOW;
            }
        } else if (0 > totalMemory || totalMemory >= 1073741824) {
            caC = a.UN_KNOW;
        } else {
            caC = a.BAD;
        }
        c.i("Matrix.DeviceUtil", "getLevel, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", level:" + caC, new Object[0]);
        return caC;
    }

    private static long getTotalMemory(Context context) {
        if (0 != caD) {
            return caD;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (VERSION.SDK_INT < 16) {
            return 0;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        activityManager.getMemoryInfo(memoryInfo);
        caD = memoryInfo.totalMem;
        caE = memoryInfo.threshold;
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory == Long.MAX_VALUE) {
            caF = activityManager.getMemoryClass();
        } else {
            caF = (int) (maxMemory / 1048576);
        }
        c.i("Matrix.DeviceUtil", "getTotalMemory cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", total_mem:" + caD + ", LowMemoryThresold:" + caE + ", Memory Class:" + caF, new Object[0]);
        return caD;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A:{SYNTHETIC, Splitter:B:31:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A:{SYNTHETIC, Splitter:B:24:0x0072} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zG() {
        Exception e;
        Throwable th;
        long j = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String[] split = readLine.split("\\s+");
                    if ("MemFree:".equals(split[0])) {
                        j = ((long) Integer.parseInt(split[1])) * 1024;
                        break;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                    c.i("Matrix.DeviceUtil", "close reader %s", e2.toString());
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    c.i("Matrix.DeviceUtil", "[getAvailMemory] error! %s", e2.toString());
                    if (bufferedReader != null) {
                    }
                    return j / 1024;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            c.i("Matrix.DeviceUtil", "close reader %s", e4.toString());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            c.i("Matrix.DeviceUtil", "[getAvailMemory] error! %s", e2.toString());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22) {
                    c.i("Matrix.DeviceUtil", "close reader %s", e22.toString());
                }
            }
            return j / 1024;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            throw th;
        }
        return j / 1024;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x017c A:{SYNTHETIC, Splitter:B:54:0x017c} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015e A:{SYNTHETIC, Splitter:B:47:0x015e} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fd A:{SYNTHETIC, Splitter:B:28:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011c A:{SYNTHETIC, Splitter:B:36:0x011c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double zH() {
        RandomAccessFile randomAccessFile;
        String[] split;
        long parseLong;
        Exception e;
        long parseLong2;
        long j;
        Throwable th;
        RandomAccessFile randomAccessFile2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        double d = 0.0d;
        try {
            randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            try {
                split = randomAccessFile.readLine().split(" ");
                parseLong = (((((Long.parseLong(split[2]) + Long.parseLong(split[3])) + Long.parseLong(split[4])) + Long.parseLong(split[5])) + Long.parseLong(split[6])) + Long.parseLong(split[7])) + Long.parseLong(split[8]);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                    c.i("Matrix.DeviceUtil", "close process reader %s", e2.toString());
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    c.i("Matrix.DeviceUtil", "RandomAccessFile(Process Stat) reader fail, error: %s", e2.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e22) {
                            c.i("Matrix.DeviceUtil", "close process reader %s", e22.toString());
                            parseLong = 0;
                        }
                    }
                    parseLong = 0;
                    randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
                    try {
                        split = randomAccessFile.readLine().split(" ");
                        parseLong2 = Long.parseLong(split[13]) + Long.parseLong(split[14]);
                        randomAccessFile.close();
                        j = parseLong2;
                    } catch (Exception e4) {
                        e22 = e4;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            c.i("Matrix.DeviceUtil", "RandomAccessFile(App Stat) reader fail, error: %s", e22.toString());
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception e222) {
                                    c.i("Matrix.DeviceUtil", "close app reader %s", e222.toString());
                                    j = 0;
                                }
                            }
                            j = 0;
                            if (0 != parseLong) {
                            }
                            c.i("Matrix.DeviceUtil", "getAppCpuRate cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",rate:" + d, new Object[0]);
                            return d;
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile2 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (Exception e5) {
                                c.i("Matrix.DeviceUtil", "close app reader %s", e5.toString());
                            }
                        }
                        throw th;
                    }
                    if (0 != parseLong) {
                    }
                    c.i("Matrix.DeviceUtil", "getAppCpuRate cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",rate:" + d, new Object[0]);
                    return d;
                } catch (Throwable th4) {
                    th = th4;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e52) {
                            c.i("Matrix.DeviceUtil", "close process reader %s", e52.toString());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e222 = e6;
            randomAccessFile = null;
            c.i("Matrix.DeviceUtil", "RandomAccessFile(Process Stat) reader fail, error: %s", e222.toString());
            if (randomAccessFile != null) {
            }
            parseLong = 0;
            randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            split = randomAccessFile.readLine().split(" ");
            parseLong2 = Long.parseLong(split[13]) + Long.parseLong(split[14]);
            randomAccessFile.close();
            j = parseLong2;
            if (0 != parseLong) {
            }
            c.i("Matrix.DeviceUtil", "getAppCpuRate cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",rate:" + d, new Object[0]);
            return d;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
            if (randomAccessFile != null) {
            }
            throw th;
        }
        try {
            randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            split = randomAccessFile.readLine().split(" ");
            parseLong2 = Long.parseLong(split[13]) + Long.parseLong(split[14]);
            try {
                randomAccessFile.close();
                j = parseLong2;
            } catch (Exception e2222) {
                c.i("Matrix.DeviceUtil", "close app reader %s", e2222.toString());
                j = parseLong2;
            }
        } catch (Exception e7) {
            e2222 = e7;
            c.i("Matrix.DeviceUtil", "RandomAccessFile(App Stat) reader fail, error: %s", e2222.toString());
            if (randomAccessFile2 != null) {
            }
            j = 0;
            if (0 != parseLong) {
            }
            c.i("Matrix.DeviceUtil", "getAppCpuRate cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",rate:" + d, new Object[0]);
            return d;
        }
        if (0 != parseLong) {
            d = (((double) j) / ((double) parseLong)) * 100.0d;
        }
        c.i("Matrix.DeviceUtil", "getAppCpuRate cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",rate:" + d, new Object[0]);
        return d;
    }

    private static int zI() {
        int i = 0;
        if (VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int ci = ci("/sys/devices/system/cpu/possible");
            if (ci == 0) {
                ci = ci("/sys/devices/system/cpu/present");
            }
            if (ci == 0) {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
                if (listFiles != null) {
                    i = listFiles.length;
                }
            } else {
                i = ci;
            }
        } catch (Exception e) {
        }
        if (i == 0) {
            i = 1;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094 A:{SYNTHETIC, Splitter:B:34:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078 A:{SYNTHETIC, Splitter:B:26:0x0078} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int ci(String str) {
        IOException e;
        Throwable th;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine == null || !readLine.matches("0-[\\d]+$")) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e2.toString());
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(readLine.substring(2)) + 1;
                try {
                    fileInputStream.close();
                    return parseInt;
                } catch (IOException e3) {
                    c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e3.toString());
                    return parseInt;
                }
            } catch (IOException e4) {
                e2 = e4;
                try {
                    c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e2.toString());
                    if (fileInputStream != null) {
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e2 = e5;
            fileInputStream = null;
            c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e2.toString());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e22) {
                    c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e22.toString());
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e32) {
                    c.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e32.toString());
                }
            }
            throw th;
        }
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static long zJ() {
        int i = 0;
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split(IOUtils.LINE_SEPARATOR_UNIX);
            int length = split.length;
            while (i < length) {
                String str = split[i];
                if (str.startsWith("VmSize")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
                i++;
            }
            if (split.length <= 12) {
                return -1;
            }
            Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
            if (matcher2.find()) {
                return Long.parseLong(matcher2.group());
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String convertStreamToString(InputStream inputStream) {
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
    private static String getStringFromFile(String str) {
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
