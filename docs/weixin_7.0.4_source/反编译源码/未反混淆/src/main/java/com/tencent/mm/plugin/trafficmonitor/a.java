package com.tencent.mm.plugin.trafficmonitor;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class a {
    private static Map<Integer, Long> sJA = new HashMap();
    private static Map<Integer, Long> sJB = new HashMap();
    private static Map<Integer, Long> sJC = new HashMap();
    private static Map<Integer, Long> sJD = new HashMap();
    private static Map<Integer, Long> sJE = new HashMap();
    private static Map<Integer, Long> sJF = new HashMap();
    private static Map<Integer, Long> sJG = new HashMap();
    private static Map<Integer, Long> sJH = new HashMap();
    private static Map<Integer, Long> sJI = new HashMap();
    private static Map<Integer, Long> sJJ = new HashMap();
    private static Map<Integer, Long> sJK = new HashMap();
    private static final File sJL;
    private static final File sJM;
    private static Map<Integer, Long> sJv = new HashMap();
    private static Map<Integer, Long> sJw = new HashMap();
    private static Map<Integer, Long> sJx = new HashMap();
    private static Map<Integer, Long> sJy = new HashMap();
    private static Map<Integer, Long> sJz = new HashMap();

    static {
        File file = null;
        AppMethodBeat.i(114755);
        File file2 = new File("/proc/" + Process.myPid() + "/net/dev");
        if (!file2.isFile()) {
            file2 = null;
        }
        sJL = file2;
        file2 = new File("/proc/net/xt_qtaguid/stats");
        if (file2.isFile()) {
            file = file2;
        }
        sJM = file;
        AppMethodBeat.o(114755);
    }

    public static void init(int i) {
        AppMethodBeat.i(114746);
        sJD.put(Integer.valueOf(i), Long.valueOf(0));
        sJE.put(Integer.valueOf(i), Long.valueOf(0));
        sJF.put(Integer.valueOf(i), Long.valueOf(0));
        sJG.put(Integer.valueOf(i), Long.valueOf(0));
        sJH.put(Integer.valueOf(i), Long.valueOf(0));
        sJI.put(Integer.valueOf(i), Long.valueOf(0));
        sJJ.put(Integer.valueOf(i), Long.valueOf(0));
        sJK.put(Integer.valueOf(i), Long.valueOf(0));
        sJv.put(Integer.valueOf(i), Long.valueOf(0));
        sJw.put(Integer.valueOf(i), Long.valueOf(0));
        sJx.put(Integer.valueOf(i), Long.valueOf(0));
        sJy.put(Integer.valueOf(i), Long.valueOf(0));
        sJz.put(Integer.valueOf(i), Long.valueOf(0));
        sJA.put(Integer.valueOf(i), Long.valueOf(0));
        sJB.put(Integer.valueOf(i), Long.valueOf(0));
        sJC.put(Integer.valueOf(i), Long.valueOf(0));
        AppMethodBeat.o(114746);
    }

    public static long FP(int i) {
        AppMethodBeat.i(114747);
        if (sJz == null) {
            AppMethodBeat.o(114747);
            return 0;
        } else if (sJz.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114747);
            return 0;
        } else if (((Long) sJz.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJz.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114747);
            return longValue;
        } else {
            AppMethodBeat.o(114747);
            return 0;
        }
    }

    public static long FQ(int i) {
        AppMethodBeat.i(114748);
        if (sJA == null) {
            AppMethodBeat.o(114748);
            return 0;
        } else if (sJA.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114748);
            return 0;
        } else if (((Long) sJA.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJA.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114748);
            return longValue;
        } else {
            AppMethodBeat.o(114748);
            return 0;
        }
    }

    public static long FR(int i) {
        AppMethodBeat.i(114749);
        if (sJJ == null) {
            AppMethodBeat.o(114749);
            return 0;
        } else if (sJJ.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114749);
            return 0;
        } else if (((Long) sJJ.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJJ.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114749);
            return longValue;
        } else {
            AppMethodBeat.o(114749);
            return 0;
        }
    }

    public static long FS(int i) {
        AppMethodBeat.i(114750);
        if (sJK == null) {
            AppMethodBeat.o(114750);
            return 0;
        } else if (sJK.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114750);
            return 0;
        } else if (((Long) sJK.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJK.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114750);
            return longValue;
        } else {
            AppMethodBeat.o(114750);
            return 0;
        }
    }

    public static long FT(int i) {
        AppMethodBeat.i(114751);
        if (sJH == null) {
            AppMethodBeat.o(114751);
            return 0;
        } else if (sJH.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114751);
            return 0;
        } else if (((Long) sJH.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJH.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114751);
            return longValue;
        } else {
            AppMethodBeat.o(114751);
            return 0;
        }
    }

    public static long FU(int i) {
        AppMethodBeat.i(114752);
        if (sJI == null) {
            AppMethodBeat.o(114752);
            return 0;
        } else if (sJI.get(Integer.valueOf(i)) == null) {
            AppMethodBeat.o(114752);
            return 0;
        } else if (((Long) sJI.get(Integer.valueOf(i))).longValue() > 0) {
            long longValue = ((Long) sJI.get(Integer.valueOf(i))).longValue();
            AppMethodBeat.o(114752);
            return longValue;
        } else {
            AppMethodBeat.o(114752);
            return 0;
        }
    }

    public static void reset(int i) {
        AppMethodBeat.i(114753);
        sJE.put(Integer.valueOf(i), Long.valueOf(-1));
        sJD.put(Integer.valueOf(i), Long.valueOf(-1));
        sJG.put(Integer.valueOf(i), Long.valueOf(-1));
        sJF.put(Integer.valueOf(i), Long.valueOf(-1));
        sJw.put(Integer.valueOf(i), Long.valueOf(-1));
        sJv.put(Integer.valueOf(i), Long.valueOf(-1));
        sJy.put(Integer.valueOf(i), Long.valueOf(-1));
        sJx.put(Integer.valueOf(i), Long.valueOf(-1));
        update(i);
        AppMethodBeat.o(114753);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x050c A:{Splitter:B:5:0x0022, PHI: r8 , ExcHandler: all (r2_178 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:117:0x050c, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:118:0x050d, code skipped:
            r4 = r2;
     */
    /* JADX WARNING: Missing block: B:124:0x0518, code skipped:
            r2 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void update(int i) {
        Throwable th;
        AppMethodBeat.i(114754);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        Scanner scanner = null;
        Scanner scanner2;
        try {
            long j7;
            if (sJL != null) {
                scanner2 = new Scanner(sJL);
                try {
                    scanner2.nextLine();
                    scanner2.nextLine();
                    while (scanner2.hasNext()) {
                        String[] split = scanner2.nextLine().split("[ :\t]+");
                        int i2 = split[0].length() == 0 ? 1 : 0;
                        if (split[i2 + 0].equals("lo")) {
                            j7 = j4;
                        } else if (split[i2 + 0].startsWith("rmnet") || split[i2 + 0].startsWith("ccmni")) {
                            j += bo.getLong(split[i2 + 9], 0);
                            j2 += bo.getLong(split[i2 + 1], 0);
                        } else {
                            j3 += bo.getLong(split[i2 + 9], 0);
                            j7 = bo.getLong(split[i2 + 1], 0) + j4;
                        }
                        j4 = j7;
                    }
                    scanner2.close();
                } catch (Exception e) {
                    scanner = scanner2;
                    try {
                        sJH.put(Integer.valueOf(i), Long.valueOf(0));
                        sJI.put(Integer.valueOf(i), Long.valueOf(0));
                        sJJ.put(Integer.valueOf(i), Long.valueOf(0));
                        sJK.put(Integer.valueOf(i), Long.valueOf(0));
                        sJD.put(Integer.valueOf(i), Long.valueOf(-1));
                        sJE.put(Integer.valueOf(i), Long.valueOf(-1));
                        sJF.put(Integer.valueOf(i), Long.valueOf(-1));
                        sJG.put(Integer.valueOf(i), Long.valueOf(-1));
                        if (scanner != null) {
                        }
                        AppMethodBeat.o(114754);
                    } catch (Throwable th2) {
                        th = th2;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                        }
                        AppMethodBeat.o(114754);
                        throw th;
                    }
                } catch (Throwable th3) {
                }
                try {
                    long longValue;
                    if (((Long) sJv.get(Integer.valueOf(i))).longValue() < 0) {
                        sJv.put(Integer.valueOf(i), Long.valueOf(j));
                    }
                    if (((Long) sJw.get(Integer.valueOf(i))).longValue() < 0) {
                        sJw.put(Integer.valueOf(i), Long.valueOf(j2));
                    }
                    if (((Long) sJx.get(Integer.valueOf(i))).longValue() < 0) {
                        sJx.put(Integer.valueOf(i), Long.valueOf(j3));
                    }
                    if (((Long) sJy.get(Integer.valueOf(i))).longValue() < 0) {
                        sJy.put(Integer.valueOf(i), Long.valueOf(j4));
                    }
                    sJz.put(Integer.valueOf(i), Long.valueOf(j >= ((Long) sJv.get(Integer.valueOf(i))).longValue() ? j - ((Long) sJv.get(Integer.valueOf(i))).longValue() : j));
                    Map map = sJA;
                    Integer valueOf = Integer.valueOf(i);
                    if (j2 >= ((Long) sJw.get(Integer.valueOf(i))).longValue()) {
                        longValue = j2 - ((Long) sJw.get(Integer.valueOf(i))).longValue();
                    } else {
                        longValue = j2;
                    }
                    map.put(valueOf, Long.valueOf(longValue));
                    map = sJB;
                    valueOf = Integer.valueOf(i);
                    if (j3 >= ((Long) sJx.get(Integer.valueOf(i))).longValue()) {
                        longValue = j3 - ((Long) sJx.get(Integer.valueOf(i))).longValue();
                    } else {
                        longValue = j3;
                    }
                    map.put(valueOf, Long.valueOf(longValue));
                    map = sJC;
                    valueOf = Integer.valueOf(i);
                    if (j4 >= ((Long) sJy.get(Integer.valueOf(i))).longValue()) {
                        longValue = j4 - ((Long) sJy.get(Integer.valueOf(i))).longValue();
                    } else {
                        longValue = j4;
                    }
                    map.put(valueOf, Long.valueOf(longValue));
                    sJv.put(Integer.valueOf(i), Long.valueOf(j));
                    sJw.put(Integer.valueOf(i), Long.valueOf(j2));
                    sJx.put(Integer.valueOf(i), Long.valueOf(j3));
                    sJy.put(Integer.valueOf(i), Long.valueOf(j4));
                    scanner = null;
                } catch (Exception e2) {
                    scanner = null;
                    sJH.put(Integer.valueOf(i), Long.valueOf(0));
                    sJI.put(Integer.valueOf(i), Long.valueOf(0));
                    sJJ.put(Integer.valueOf(i), Long.valueOf(0));
                    sJK.put(Integer.valueOf(i), Long.valueOf(0));
                    sJD.put(Integer.valueOf(i), Long.valueOf(-1));
                    sJE.put(Integer.valueOf(i), Long.valueOf(-1));
                    sJF.put(Integer.valueOf(i), Long.valueOf(-1));
                    sJG.put(Integer.valueOf(i), Long.valueOf(-1));
                    if (scanner != null) {
                    }
                    AppMethodBeat.o(114754);
                } catch (Throwable th4) {
                    th = th4;
                    scanner2 = null;
                    if (scanner2 != null) {
                    }
                    AppMethodBeat.o(114754);
                    throw th;
                }
            }
            if (sJM != null) {
                int myUid = Process.myUid();
                scanner2 = new Scanner(sJM);
                scanner2.nextLine();
                j4 = 0;
                j3 = 0;
                while (scanner2.hasNext()) {
                    String[] split2 = scanner2.nextLine().split("[ :\\t]+");
                    if (bo.getInt(split2[3], 0) == myUid) {
                        String str = split2[1];
                        long j8 = bo.getLong(split2[5], 0);
                        long j9 = bo.getLong(split2[7], 0);
                        if (str.startsWith("rmnet") || str.startsWith("ccmni")) {
                            j6 += j8;
                            j5 += j9;
                        } else {
                            if (str.equals("lo")) {
                                j7 = j4;
                            } else {
                                j7 = j4 + j8;
                                j3 += j9;
                            }
                            j4 = j7;
                        }
                    }
                }
                if (((Long) sJE.get(Integer.valueOf(i))).longValue() < 0) {
                    sJE.put(Integer.valueOf(i), Long.valueOf(j6));
                }
                if (((Long) sJD.get(Integer.valueOf(i))).longValue() < 0) {
                    sJD.put(Integer.valueOf(i), Long.valueOf(j5));
                }
                if (((Long) sJG.get(Integer.valueOf(i))).longValue() < 0) {
                    sJG.put(Integer.valueOf(i), Long.valueOf(j4));
                }
                if (((Long) sJF.get(Integer.valueOf(i))).longValue() < 0) {
                    sJF.put(Integer.valueOf(i), Long.valueOf(j3));
                }
                sJH.put(Integer.valueOf(i), Long.valueOf(j5 >= ((Long) sJD.get(Integer.valueOf(i))).longValue() ? j5 - ((Long) sJD.get(Integer.valueOf(i))).longValue() : j5));
                Map map2 = sJI;
                Integer valueOf2 = Integer.valueOf(i);
                if (j6 >= ((Long) sJE.get(Integer.valueOf(i))).longValue()) {
                    j7 = j6 - ((Long) sJE.get(Integer.valueOf(i))).longValue();
                } else {
                    j7 = j6;
                }
                map2.put(valueOf2, Long.valueOf(j7));
                map2 = sJJ;
                valueOf2 = Integer.valueOf(i);
                if (j3 >= ((Long) sJF.get(Integer.valueOf(i))).longValue()) {
                    j7 = j3 - ((Long) sJF.get(Integer.valueOf(i))).longValue();
                } else {
                    j7 = j3;
                }
                map2.put(valueOf2, Long.valueOf(j7));
                map2 = sJK;
                valueOf2 = Integer.valueOf(i);
                if (j4 >= ((Long) sJG.get(Integer.valueOf(i))).longValue()) {
                    j7 = j4 - ((Long) sJG.get(Integer.valueOf(i))).longValue();
                } else {
                    j7 = j4;
                }
                map2.put(valueOf2, Long.valueOf(j7));
                sJD.put(Integer.valueOf(i), Long.valueOf(j5));
                sJE.put(Integer.valueOf(i), Long.valueOf(j6));
                sJF.put(Integer.valueOf(i), Long.valueOf(j3));
                sJG.put(Integer.valueOf(i), Long.valueOf(j4));
            } else {
                scanner2 = scanner;
            }
            if (scanner2 != null) {
                scanner2.close();
                AppMethodBeat.o(114754);
                return;
            }
        } catch (Exception e3) {
            sJH.put(Integer.valueOf(i), Long.valueOf(0));
            sJI.put(Integer.valueOf(i), Long.valueOf(0));
            sJJ.put(Integer.valueOf(i), Long.valueOf(0));
            sJK.put(Integer.valueOf(i), Long.valueOf(0));
            sJD.put(Integer.valueOf(i), Long.valueOf(-1));
            sJE.put(Integer.valueOf(i), Long.valueOf(-1));
            sJF.put(Integer.valueOf(i), Long.valueOf(-1));
            sJG.put(Integer.valueOf(i), Long.valueOf(-1));
            if (scanner != null) {
                scanner.close();
                AppMethodBeat.o(114754);
                return;
            }
            AppMethodBeat.o(114754);
        } catch (Throwable th22) {
            th = th22;
            scanner2 = scanner;
            if (scanner2 != null) {
                scanner2.close();
            }
            AppMethodBeat.o(114754);
            throw th;
        }
        AppMethodBeat.o(114754);
    }
}
