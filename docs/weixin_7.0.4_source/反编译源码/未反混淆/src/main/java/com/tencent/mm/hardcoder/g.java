package com.tencent.mm.hardcoder;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class g {

    public interface a {
        boolean kZ(String str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb A:{SYNTHETIC, Splitter:B:34:0x00fb} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0100 A:{SYNTHETIC, Splitter:B:37:0x0100} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b1 A:{SYNTHETIC, Splitter:B:21:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6 A:{SYNTHETIC, Splitter:B:24:0x00b6} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb A:{SYNTHETIC, Splitter:B:34:0x00fb} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0100 A:{SYNTHETIC, Splitter:B:37:0x0100} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b1 A:{SYNTHETIC, Splitter:B:21:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6 A:{SYNTHETIC, Splitter:B:24:0x00b6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[] PF() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(93942);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(" ");
                    long[] jArr = new long[]{Long.parseLong(split[13]), Long.parseLong(split[14])};
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime fileReader close exception:" + e2.getMessage());
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e22) {
                        c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime bufferedReader close exception:" + e22.getMessage());
                    }
                    AppMethodBeat.o(93942);
                    return jArr;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime exception:" + e.getMessage());
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(93942);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(93942);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime exception:" + e.getMessage());
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(93942);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(93942);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            fileReader = null;
            c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime exception:" + e.getMessage());
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e6) {
                    c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime fileReader close exception:" + e6.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e62) {
                    c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime bufferedReader close exception:" + e62.getMessage());
                }
            }
            AppMethodBeat.o(93942);
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e222) {
                    c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime fileReader close exception:" + e222.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e2222) {
                    c.e("HardCoder.HardCoderUtil", "getMyProcCpuTime bufferedReader close exception:" + e2222.getMessage());
                }
            }
            AppMethodBeat.o(93942);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b A:{SYNTHETIC, Splitter:B:46:0x014b} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0150 A:{SYNTHETIC, Splitter:B:49:0x0150} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0101 A:{SYNTHETIC, Splitter:B:33:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106 A:{SYNTHETIC, Splitter:B:36:0x0106} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x014b A:{SYNTHETIC, Splitter:B:46:0x014b} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0150 A:{SYNTHETIC, Splitter:B:49:0x0150} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[] jr(int i) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(93943);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/task/" + i + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            fileReader.close();
                        } catch (Exception e2) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies fileReader close exception:" + e2.getMessage());
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e22) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies bufferedReader close exception:" + e22.getMessage());
                        }
                        AppMethodBeat.o(93943);
                        return null;
                    }
                    String[] split = readLine.split(" ");
                    long[] jArr = new long[]{lb(split[13]), lb(split[14])};
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                        c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies fileReader close exception:" + e3.getMessage());
                    }
                    try {
                        bufferedReader.close();
                    } catch (Exception e32) {
                        c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies bufferedReader close exception:" + e32.getMessage());
                    }
                    AppMethodBeat.o(93943);
                    return jArr;
                } catch (Exception e4) {
                    e22 = e4;
                }
            } catch (Exception e5) {
                e22 = e5;
                bufferedReader = null;
                try {
                    c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies exception:" + e22.getMessage());
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(93943);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(93943);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(93943);
                throw th;
            }
        } catch (Exception e6) {
            e22 = e6;
            bufferedReader = null;
            fileReader = null;
            c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies exception:" + e22.getMessage());
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies fileReader close exception:" + e222.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e2222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies bufferedReader close exception:" + e2222.getMessage());
                }
            }
            AppMethodBeat.o(93943);
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e322) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies fileReader close exception:" + e322.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e3222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCpuJiffies bufferedReader close exception:" + e3222.getMessage());
                }
            }
            AppMethodBeat.o(93943);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A:{SYNTHETIC, Splitter:B:47:0x013a} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f A:{SYNTHETIC, Splitter:B:50:0x013f} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f0 A:{SYNTHETIC, Splitter:B:34:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5 A:{SYNTHETIC, Splitter:B:37:0x00f5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A:{SYNTHETIC, Splitter:B:47:0x013a} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f A:{SYNTHETIC, Splitter:B:50:0x013f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int js(int i) {
        Exception e;
        Throwable th;
        int i2 = -1;
        AppMethodBeat.i(93944);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/task/" + i + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            fileReader.close();
                        } catch (Exception e2) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCoreId fileReader close exception:" + e2.getMessage());
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e22) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCoreId bufferedReader close exception:" + e22.getMessage());
                        }
                        AppMethodBeat.o(93944);
                    } else {
                        i2 = la(readLine.split(" ")[38]);
                        try {
                            fileReader.close();
                        } catch (Exception e222) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCoreId fileReader close exception:" + e222.getMessage());
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e2222) {
                            c.e("HardCoder.HardCoderUtil", "getThreadCoreId bufferedReader close exception:" + e2222.getMessage());
                        }
                        AppMethodBeat.o(93944);
                    }
                } catch (Exception e3) {
                    e2222 = e3;
                }
            } catch (Exception e4) {
                e2222 = e4;
                bufferedReader = null;
                try {
                    c.e("HardCoder.HardCoderUtil", "getThreadCoreId exception:" + e2222.getMessage());
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(93944);
                    return i2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileReader != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(93944);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(93944);
                throw th;
            }
        } catch (Exception e5) {
            e2222 = e5;
            bufferedReader = null;
            fileReader = null;
            c.e("HardCoder.HardCoderUtil", "getThreadCoreId exception:" + e2222.getMessage());
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e22222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCoreId fileReader close exception:" + e22222.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e222222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCoreId bufferedReader close exception:" + e222222.getMessage());
                }
            }
            AppMethodBeat.o(93944);
            return i2;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e2222222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCoreId fileReader close exception:" + e2222222.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22222222) {
                    c.e("HardCoder.HardCoderUtil", "getThreadCoreId bufferedReader close exception:" + e22222222.getMessage());
                }
            }
            AppMethodBeat.o(93944);
            throw th;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A:{SYNTHETIC, Splitter:B:39:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A:{SYNTHETIC, Splitter:B:42:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A:{SYNTHETIC, Splitter:B:39:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A:{SYNTHETIC, Splitter:B:42:0x00f0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long jt(int i) {
        Exception e;
        Throwable th;
        long j = -1;
        AppMethodBeat.i(93945);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (file.exists()) {
                fileReader = new FileReader(file);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        j = lb(bufferedReader.readLine());
                        try {
                            bufferedReader.close();
                        } catch (Exception e2) {
                            c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId bufferedReader close exception:" + e2.getMessage());
                        }
                        try {
                            fileReader.close();
                        } catch (Exception e22) {
                            c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId fileReader close exception:" + e22.getMessage());
                        }
                        AppMethodBeat.o(93945);
                    } catch (Exception e3) {
                        e22 = e3;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    bufferedReader = null;
                    try {
                        c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId exception:" + e22.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e222) {
                                c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId bufferedReader close exception:" + e222.getMessage());
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e2222) {
                                c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId fileReader close exception:" + e2222.getMessage());
                            }
                        }
                        AppMethodBeat.o(93945);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId bufferedReader close exception:" + e5.getMessage());
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e52) {
                                c.e("HardCoder.HardCoderUtil", "getCpuFreqByCoreId fileReader close exception:" + e52.getMessage());
                            }
                        }
                        AppMethodBeat.o(93945);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    AppMethodBeat.o(93945);
                    throw th;
                }
            }
            AppMethodBeat.o(93945);
        } catch (Exception e6) {
            e2222 = e6;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
            if (bufferedReader != null) {
            }
            if (fileReader != null) {
            }
            AppMethodBeat.o(93945);
            throw th;
        }
        return j;
    }

    private static int la(String str) {
        int i = 0;
        AppMethodBeat.i(93946);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.o(93946);
                    return i;
                }
            } catch (NumberFormatException e) {
                c.printErrStackTrace("HardCoder.HardCoderUtil", e, "getInt", new Object[0]);
                AppMethodBeat.o(93946);
            }
        }
        AppMethodBeat.o(93946);
        return i;
    }

    private static long lb(String str) {
        long j = 0;
        AppMethodBeat.i(93947);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j = Long.decode(str).longValue();
                    AppMethodBeat.o(93947);
                    return j;
                }
            } catch (NumberFormatException e) {
                c.printErrStackTrace("HardCoder.HardCoderUtil", e, "getLong", new Object[0]);
                AppMethodBeat.o(93947);
            }
        }
        AppMethodBeat.o(93947);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A:{SYNTHETIC, Splitter:B:15:0x0037} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A:{SYNTHETIC, Splitter:B:23:0x0052} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, a aVar) {
        Throwable e;
        AppMethodBeat.i(93948);
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, aVar);
                try {
                    fileInputStream.close();
                    AppMethodBeat.o(93948);
                } catch (Exception e2) {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e2, "readFileContentIgnoreLine", new Object[0]);
                    AppMethodBeat.o(93948);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e, "readFileContentIgnoreLine", new Object[0]);
                    if (fileInputStream == null) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(93948);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            c.printErrStackTrace("HardCoder.HardCoderUtil", e, "readFileContentIgnoreLine", new Object[0]);
            if (fileInputStream == null) {
                try {
                    fileInputStream.close();
                    AppMethodBeat.o(93948);
                    return;
                } catch (Exception e22) {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e22, "readFileContentIgnoreLine", new Object[0]);
                    AppMethodBeat.o(93948);
                    return;
                }
            }
            AppMethodBeat.o(93948);
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e5) {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e5, "readFileContentIgnoreLine", new Object[0]);
                }
            }
            AppMethodBeat.o(93948);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047 A:{SYNTHETIC, Splitter:B:19:0x0047} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A:{SYNTHETIC, Splitter:B:27:0x0062} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(InputStream inputStream, a aVar) {
        Throwable e;
        AppMethodBeat.i(93949);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || !(aVar == null || aVar.kZ(readLine))) {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(93949);
                            return;
                        } catch (Exception e2) {
                            c.printErrStackTrace("HardCoder.HardCoderUtil", e2, "readFileContentIgnoreLine", new Object[0]);
                            AppMethodBeat.o(93949);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        c.printErrStackTrace("HardCoder.HardCoderUtil", e, "readFileContentIgnoreLine", new Object[0]);
                        if (bufferedReader == null) {
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(93949);
                        throw e;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            c.printErrStackTrace("HardCoder.HardCoderUtil", e, "readFileContentIgnoreLine", new Object[0]);
            if (bufferedReader == null) {
                try {
                    bufferedReader.close();
                    AppMethodBeat.o(93949);
                    return;
                } catch (Exception e22) {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e22, "readFileContentIgnoreLine", new Object[0]);
                    AppMethodBeat.o(93949);
                    return;
                }
            }
            AppMethodBeat.o(93949);
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                    c.printErrStackTrace("HardCoder.HardCoderUtil", e5, "readFileContentIgnoreLine", new Object[0]);
                }
            }
            AppMethodBeat.o(93949);
            throw e;
        }
    }
}
