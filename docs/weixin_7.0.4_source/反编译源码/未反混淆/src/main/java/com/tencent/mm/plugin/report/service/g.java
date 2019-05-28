package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class g {
    private static SparseArray<Long> pYb = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> pYc = new SparseArray();
    private static boolean pYd = true;
    private static long pYe = 0;
    private static long pYf = 0;
    private static long pYg = 0;

    public static final class a {
        public static a pYl;
        public volatile boolean hasInit;
        public long[] pYh;
        public int pYi;
        public String pYj;
        public long pYk;

        class a implements FileFilter {
            a() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.i(72740);
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    AppMethodBeat.o(72740);
                    return true;
                }
                AppMethodBeat.o(72740);
                return false;
            }
        }

        public static synchronized a cgs() {
            a aVar;
            synchronized (a.class) {
                AppMethodBeat.i(72741);
                if (pYl == null) {
                    aVar = new a();
                    pYl = aVar;
                    aVar.pYi = getNumCores();
                    pYl.pYj = Lz();
                    a aVar2 = pYl;
                    ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    aVar2.pYk = memoryInfo.availMem >> 10;
                    aVar = pYl;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    aVar.pYh = jArr;
                    pYl.hasInit = true;
                }
                aVar = pYl;
                AppMethodBeat.o(72741);
            }
            return aVar;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x004a=Splitter:B:19:0x004a, B:33:0x007e=Splitter:B:33:0x007e} */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A:{SYNTHETIC, Splitter:B:22:0x0058} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A:{SYNTHETIC, Splitter:B:25:0x005d} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A:{SYNTHETIC, Splitter:B:36:0x008c} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A:{SYNTHETIC, Splitter:B:39:0x0091} */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A:{SYNTHETIC, Splitter:B:22:0x0058} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005d A:{SYNTHETIC, Splitter:B:25:0x005d} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A:{SYNTHETIC, Splitter:B:36:0x008c} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A:{SYNTHETIC, Splitter:B:39:0x0091} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4 A:{SYNTHETIC, Splitter:B:48:0x00b4} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{SYNTHETIC, Splitter:B:51:0x00b9} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4 A:{SYNTHETIC, Splitter:B:48:0x00b4} */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{SYNTHETIC, Splitter:B:51:0x00b9} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static String Lz() {
            Throwable e;
            Throwable th;
            AppMethodBeat.i(72742);
            String str = "N/A";
            FileReader fileReader;
            BufferedReader bufferedReader;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        str = bufferedReader.readLine().trim();
                        bufferedReader.close();
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2, "", new Object[0]);
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        try {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                            if (fileReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            AppMethodBeat.o(72742);
                            return str;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            AppMethodBeat.o(72742);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(72742);
                        return str;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader = null;
                    ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(72742);
                    return str;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                    ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e22222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(72742);
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2222222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2222222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22222222) {
                            ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(72742);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                fileReader = null;
                ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(72742);
                return str;
            } catch (IOException e8) {
                e = e8;
                bufferedReader = null;
                fileReader = null;
                ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(72742);
                return str;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(72742);
                throw th;
            }
            AppMethodBeat.o(72742);
            return str;
        }

        private static int getNumCores() {
            AppMethodBeat.i(72743);
            try {
                int length = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
                AppMethodBeat.o(72743);
                return length;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                AppMethodBeat.o(72743);
                return 1;
            }
        }
    }

    static {
        AppMethodBeat.i(72750);
        AppMethodBeat.o(72750);
    }

    public static void BN(int i) {
        AppMethodBeat.i(72744);
        if (pYd) {
            pYb.put(i, Long.valueOf(bo.anU()));
            ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(bo.anU()));
            AppMethodBeat.o(72744);
            return;
        }
        AppMethodBeat.o(72744);
    }

    public static void jG(long j) {
        AppMethodBeat.i(72745);
        if (pYd) {
            ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            pYb.put(8, Long.valueOf(j));
            AppMethodBeat.o(72745);
            return;
        }
        AppMethodBeat.o(72745);
    }

    public static void BO(int i) {
        AppMethodBeat.i(72746);
        if (pYd) {
            Long l = (Long) pYb.get(i);
            if (l == null) {
                AppMethodBeat.o(72746);
                return;
            } else if (l.longValue() == -1) {
                AppMethodBeat.o(72746);
                return;
            } else {
                pYb.put(i, Long.valueOf(-1));
                long anU = bo.anU() - l.longValue();
                if (anU <= 0) {
                    AppMethodBeat.o(72746);
                    return;
                }
                switch (i) {
                    case 8:
                        if (!ah.xzd) {
                            W(1, anU);
                            V(227, anU);
                            h.pYm.d(23, 1, 2, (int) anU, false);
                            break;
                        }
                        h.pYm.d(23, 4, 5, (int) anU, false);
                        break;
                    case 9:
                        W(3, anU);
                        V(229, anU);
                        h.pYm.d(27, 1, 2, (int) anU, false);
                        break;
                    case 10:
                        W(2, anU);
                        V(228, anU);
                        h.pYm.d(28, 1, 2, (int) anU, false);
                        break;
                    case 12:
                        W(6, anU);
                        break;
                    case 13:
                        W(7, anU);
                        break;
                    case 14:
                        W(8, anU);
                        break;
                    case 18:
                        W(10, anU);
                        break;
                    case 19:
                        W(9, anU);
                        break;
                    case 20:
                        W(12, anU);
                        break;
                    case 21:
                        W(11, anU);
                        break;
                    case 22:
                        W(13, anU);
                        break;
                    case 23:
                        W(16, anU);
                        break;
                    case 24:
                        W(15, anU);
                        break;
                    case 25:
                        W(14, anU);
                        break;
                }
                ab.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(anU));
                AppMethodBeat.o(72746);
                return;
            }
        }
        AppMethodBeat.o(72746);
    }

    private static void V(int i, long j) {
        AppMethodBeat.i(72747);
        if (j <= 0) {
            AppMethodBeat.o(72747);
        } else if (j < 1000) {
            h.pYm.ag(i, 0, 1);
            AppMethodBeat.o(72747);
        } else if (j < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            h.pYm.ag(i, 0, 3);
            AppMethodBeat.o(72747);
        } else if (j < 5000) {
            h.pYm.ag(i, 0, 5);
            AppMethodBeat.o(72747);
        } else if (j < 10000) {
            h.pYm.ag(i, 0, 7);
            AppMethodBeat.o(72747);
        } else {
            h.pYm.ag(i, 0, 9);
            AppMethodBeat.o(72747);
        }
    }

    private static void W(int i, long j) {
        AppMethodBeat.i(72748);
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYe + 60000) {
                AppMethodBeat.o(72748);
                return;
            }
            pYe = currentTimeMillis;
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYf + 60000) {
                AppMethodBeat.o(72748);
                return;
            }
            pYf = currentTimeMillis;
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYg + 60000) {
                AppMethodBeat.o(72748);
                return;
            }
            pYg = currentTimeMillis;
        }
        if (a.cgs().hasInit) {
            h.pYm.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.pYi), Long.valueOf(r0.pYh[0]), Long.valueOf(r0.pYh[1]), Long.valueOf(r0.pYk));
            AppMethodBeat.o(72748);
            return;
        }
        h.pYm.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.o(72748);
    }

    public static void BP(int i) {
        AppMethodBeat.i(72749);
        if (pYd) {
            ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            pYb.put(i, Long.valueOf(-1));
            AppMethodBeat.o(72749);
            return;
        }
        AppMethodBeat.o(72749);
    }
}
