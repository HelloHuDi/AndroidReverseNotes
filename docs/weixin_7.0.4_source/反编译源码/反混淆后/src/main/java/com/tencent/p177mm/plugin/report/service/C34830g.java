package com.tencent.p177mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.report.service.g */
public final class C34830g {
    private static SparseArray<Long> pYb = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> pYc = new SparseArray();
    private static boolean pYd = true;
    private static long pYe = 0;
    private static long pYf = 0;
    private static long pYg = 0;

    /* renamed from: com.tencent.mm.plugin.report.service.g$a */
    public static final class C21671a {
        public static C21671a pYl;
        public volatile boolean hasInit;
        public long[] pYh;
        public int pYi;
        public String pYj;
        public long pYk;

        /* renamed from: com.tencent.mm.plugin.report.service.g$a$a */
        class C21672a implements FileFilter {
            C21672a() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(72740);
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    AppMethodBeat.m2505o(72740);
                    return true;
                }
                AppMethodBeat.m2505o(72740);
                return false;
            }
        }

        public static synchronized C21671a cgs() {
            C21671a c21671a;
            synchronized (C21671a.class) {
                AppMethodBeat.m2504i(72741);
                if (pYl == null) {
                    c21671a = new C21671a();
                    pYl = c21671a;
                    c21671a.pYi = C21671a.getNumCores();
                    pYl.pYj = C21671a.m33183Lz();
                    C21671a c21671a2 = pYl;
                    ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    c21671a2.pYk = memoryInfo.availMem >> 10;
                    c21671a = pYl;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(C1448h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(C1448h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    c21671a.pYh = jArr;
                    pYl.hasInit = true;
                }
                c21671a = pYl;
                AppMethodBeat.m2505o(72741);
            }
            return c21671a;
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
        /* renamed from: Lz */
        private static String m33183Lz() {
            Throwable e;
            Throwable th;
            AppMethodBeat.m2504i(72742);
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
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2, "", new Object[0]);
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                            if (fileReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            AppMethodBeat.m2505o(72742);
                            return str;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            AppMethodBeat.m2505o(72742);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.m2505o(72742);
                        return str;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader = null;
                    C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(72742);
                    return str;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                    C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e22222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(72742);
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2222222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e2222222, "", new Object[0]);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22222222) {
                            C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(72742);
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedReader = null;
                fileReader = null;
                C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(72742);
                return str;
            } catch (IOException e8) {
                e = e8;
                bufferedReader = null;
                fileReader = null;
                C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(72742);
                return str;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                fileReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.m2505o(72742);
                throw th;
            }
            AppMethodBeat.m2505o(72742);
            return str;
        }

        private static int getNumCores() {
            AppMethodBeat.m2504i(72743);
            try {
                int length = new File("/sys/devices/system/cpu/").listFiles(new C21672a()).length;
                AppMethodBeat.m2505o(72743);
                return length;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                AppMethodBeat.m2505o(72743);
                return 1;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(72750);
        AppMethodBeat.m2505o(72750);
    }

    /* renamed from: BN */
    public static void m57194BN(int i) {
        AppMethodBeat.m2504i(72744);
        if (pYd) {
            pYb.put(i, Long.valueOf(C5046bo.anU()));
            C4990ab.m7411d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(C5046bo.anU()));
            AppMethodBeat.m2505o(72744);
            return;
        }
        AppMethodBeat.m2505o(72744);
    }

    /* renamed from: jG */
    public static void m57199jG(long j) {
        AppMethodBeat.m2504i(72745);
        if (pYd) {
            C4990ab.m7411d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            pYb.put(8, Long.valueOf(j));
            AppMethodBeat.m2505o(72745);
            return;
        }
        AppMethodBeat.m2505o(72745);
    }

    /* renamed from: BO */
    public static void m57195BO(int i) {
        AppMethodBeat.m2504i(72746);
        if (pYd) {
            Long l = (Long) pYb.get(i);
            if (l == null) {
                AppMethodBeat.m2505o(72746);
                return;
            } else if (l.longValue() == -1) {
                AppMethodBeat.m2505o(72746);
                return;
            } else {
                pYb.put(i, Long.valueOf(-1));
                long anU = C5046bo.anU() - l.longValue();
                if (anU <= 0) {
                    AppMethodBeat.m2505o(72746);
                    return;
                }
                switch (i) {
                    case 8:
                        if (!C4996ah.xzd) {
                            C34830g.m57198W(1, anU);
                            C34830g.m57197V(227, anU);
                            C7060h.pYm.mo8380d(23, 1, 2, (int) anU, false);
                            break;
                        }
                        C7060h.pYm.mo8380d(23, 4, 5, (int) anU, false);
                        break;
                    case 9:
                        C34830g.m57198W(3, anU);
                        C34830g.m57197V(229, anU);
                        C7060h.pYm.mo8380d(27, 1, 2, (int) anU, false);
                        break;
                    case 10:
                        C34830g.m57198W(2, anU);
                        C34830g.m57197V(228, anU);
                        C7060h.pYm.mo8380d(28, 1, 2, (int) anU, false);
                        break;
                    case 12:
                        C34830g.m57198W(6, anU);
                        break;
                    case 13:
                        C34830g.m57198W(7, anU);
                        break;
                    case 14:
                        C34830g.m57198W(8, anU);
                        break;
                    case 18:
                        C34830g.m57198W(10, anU);
                        break;
                    case 19:
                        C34830g.m57198W(9, anU);
                        break;
                    case 20:
                        C34830g.m57198W(12, anU);
                        break;
                    case 21:
                        C34830g.m57198W(11, anU);
                        break;
                    case 22:
                        C34830g.m57198W(13, anU);
                        break;
                    case 23:
                        C34830g.m57198W(16, anU);
                        break;
                    case 24:
                        C34830g.m57198W(15, anU);
                        break;
                    case 25:
                        C34830g.m57198W(14, anU);
                        break;
                }
                C4990ab.m7417i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(anU));
                AppMethodBeat.m2505o(72746);
                return;
            }
        }
        AppMethodBeat.m2505o(72746);
    }

    /* renamed from: V */
    private static void m57197V(int i, long j) {
        AppMethodBeat.m2504i(72747);
        if (j <= 0) {
            AppMethodBeat.m2505o(72747);
        } else if (j < 1000) {
            C7060h.pYm.mo15416ag(i, 0, 1);
            AppMethodBeat.m2505o(72747);
        } else if (j < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            C7060h.pYm.mo15416ag(i, 0, 3);
            AppMethodBeat.m2505o(72747);
        } else if (j < 5000) {
            C7060h.pYm.mo15416ag(i, 0, 5);
            AppMethodBeat.m2505o(72747);
        } else if (j < 10000) {
            C7060h.pYm.mo15416ag(i, 0, 7);
            AppMethodBeat.m2505o(72747);
        } else {
            C7060h.pYm.mo15416ag(i, 0, 9);
            AppMethodBeat.m2505o(72747);
        }
    }

    /* renamed from: W */
    private static void m57198W(int i, long j) {
        AppMethodBeat.m2504i(72748);
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYe + 60000) {
                AppMethodBeat.m2505o(72748);
                return;
            }
            pYe = currentTimeMillis;
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYf + 60000) {
                AppMethodBeat.m2505o(72748);
                return;
            }
            pYf = currentTimeMillis;
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < pYg + 60000) {
                AppMethodBeat.m2505o(72748);
                return;
            }
            pYg = currentTimeMillis;
        }
        if (C21671a.cgs().hasInit) {
            C7060h.pYm.mo8377a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.pYi), Long.valueOf(r0.pYh[0]), Long.valueOf(r0.pYh[1]), Long.valueOf(r0.pYk));
            AppMethodBeat.m2505o(72748);
            return;
        }
        C7060h.pYm.mo8377a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.m2505o(72748);
    }

    /* renamed from: BP */
    public static void m57196BP(int i) {
        AppMethodBeat.m2504i(72749);
        if (pYd) {
            C4990ab.m7411d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            pYb.put(i, Long.valueOf(-1));
            AppMethodBeat.m2505o(72749);
            return;
        }
        AppMethodBeat.m2505o(72749);
    }
}
