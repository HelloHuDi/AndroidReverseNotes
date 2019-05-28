package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Scanner;

public final class bn {
    private static long pfF;
    private static long pfG;
    private static long pfH;
    private static long pfI;
    private static final File sJL;
    private static final File sJM;
    private static long xBU;
    private static long xBV;
    private static long xBW;
    private static long xBX;
    private static long xBY;
    private static long xBZ;
    private static long xCa;
    private static long xCb;
    private static long xCc;
    private static long xCd;
    private static long xCe;
    private static long xCf;

    static {
        File file = null;
        AppMethodBeat.i(52288);
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
        AppMethodBeat.o(52288);
    }

    public static long dpu() {
        return xCe > 0 ? xCe : 0;
    }

    public static long dpv() {
        return xCf > 0 ? xCf : 0;
    }

    public static long dpw() {
        return xCc > 0 ? xCc : 0;
    }

    public static long dpx() {
        return xCd > 0 ? xCd : 0;
    }

    public static long mt(long j) {
        return pfH > j ? pfH : j;
    }

    public static long dpy() {
        return pfI > 0 ? pfI : 0;
    }

    public static long mu(long j) {
        return pfF > j ? pfF : j;
    }

    public static long mv(long j) {
        return pfG > j ? pfG : j;
    }

    public static void reset() {
        AppMethodBeat.i(52286);
        xBU = -1;
        xBV = -1;
        xBW = -1;
        xBX = -1;
        xBZ = -1;
        xBY = -1;
        xCb = -1;
        xCa = -1;
        update();
        AppMethodBeat.o(52286);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0331 A:{Splitter:B:5:0x0022, PHI: r6 , ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0331 A:{Splitter:B:5:0x0022, PHI: r6 , ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0327  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:115:0x031f, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:119:0x0327, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:122:0x0331, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:127:0x0339, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:128:0x033a, code skipped:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:129:0x033c, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:130:0x033d, code skipped:
            r3 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void update() {
        Throwable e;
        AppMethodBeat.i(52287);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        Scanner scanner = null;
        Scanner scanner2;
        try {
            long j6;
            int i;
            long j7;
            if (sJL != null) {
                scanner2 = new Scanner(sJL);
                try {
                    scanner2.nextLine();
                    scanner2.nextLine();
                    j6 = 0;
                    while (scanner2.hasNext()) {
                        String[] split = scanner2.nextLine().split("[ :\t]+");
                        i = split[0].length() == 0 ? 1 : 0;
                        if (!split[i + 0].equals("lo")) {
                            if (split[i + 0].startsWith("rmnet") || split[i + 0].startsWith("ccmni")) {
                                j += Long.parseLong(split[i + 9]);
                                j2 += Long.parseLong(split[i + 1]);
                            } else {
                                j3 += Long.parseLong(split[i + 9]);
                                j6 += Long.parseLong(split[i + 1]);
                            }
                        }
                    }
                    scanner2.close();
                    scanner2 = null;
                    if (xBU < 0) {
                        xBU = j;
                        ab.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", Long.valueOf(j));
                    }
                    if (xBV < 0) {
                        xBV = j2;
                        ab.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", Long.valueOf(j2));
                    }
                    if (xBW < 0) {
                        xBW = j3;
                        ab.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", Long.valueOf(j3));
                    }
                    if (xBX < 0) {
                        xBX = j6;
                        ab.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", Long.valueOf(j6));
                    }
                    if (j6 - xBX < 0) {
                        ab.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j6 - xBX));
                    }
                    if (j3 - xBW < 0) {
                        ab.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j3 - xBW));
                    }
                    xCc = j >= xBU ? j - xBU : j;
                    if (j2 >= xBV) {
                        j7 = j2 - xBV;
                    } else {
                        j7 = j2;
                    }
                    xCd = j7;
                    if (j3 >= xBW) {
                        j7 = j3 - xBW;
                    } else {
                        j7 = j3;
                    }
                    xCe = j7;
                    if (j6 >= xBX) {
                        j7 = j6 - xBX;
                    } else {
                        j7 = j6;
                    }
                    xCf = j7;
                    xBU = j;
                    xBV = j2;
                    xBW = j3;
                    xBX = j6;
                    scanner = null;
                } catch (Exception e2) {
                    e = e2;
                    scanner = scanner2;
                    try {
                        ab.printErrStackTrace("MicroMsg.SDK.TrafficStats", e, "Failed retrieving TrafficStats.", new Object[0]);
                        if (scanner != null) {
                        }
                        ab.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xCf), Long.valueOf(xCe), Long.valueOf(xCd), Long.valueOf(xCc), Long.valueOf(pfI), Long.valueOf(pfH), Long.valueOf(pfG), Long.valueOf(pfF));
                        AppMethodBeat.o(52287);
                    } catch (Throwable th) {
                        e = th;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                        }
                        AppMethodBeat.o(52287);
                        throw e;
                    }
                } catch (Throwable th2) {
                }
            }
            if (sJM != null) {
                long j8;
                i = Process.myUid();
                scanner2 = new Scanner(sJM);
                scanner2.nextLine();
                j6 = 0;
                j3 = 0;
                while (scanner2.hasNext()) {
                    String[] split2 = scanner2.nextLine().split("[ :\\t]+");
                    if (Integer.parseInt(split2[3]) == i) {
                        String str = split2[1];
                        long parseLong = Long.parseLong(split2[5]);
                        j7 = Long.parseLong(split2[7]);
                        if (str.startsWith("rmnet") || str.startsWith("ccmni")) {
                            j5 += parseLong;
                            j4 += j7;
                        } else if (!str.equals("lo")) {
                            j6 += parseLong;
                            j3 += j7;
                        }
                    }
                }
                if (xBZ < 0) {
                    xBZ = j5;
                }
                if (xBY < 0) {
                    xBY = j4;
                }
                if (xCb < 0) {
                    xCb = j6;
                }
                if (xCa < 0) {
                    xCa = j3;
                }
                pfF = j4 >= xBY ? j4 - xBY : j4;
                if (j5 >= xBZ) {
                    j8 = j5 - xBZ;
                } else {
                    j8 = j5;
                }
                pfG = j8;
                if (j3 >= xCa) {
                    j8 = j3 - xCa;
                } else {
                    j8 = j3;
                }
                pfH = j8;
                if (j6 >= xCb) {
                    j8 = j6 - xCb;
                } else {
                    j8 = j6;
                }
                pfI = j8;
                xBY = j4;
                xBZ = j5;
                xCa = j3;
                xCb = j6;
            } else {
                scanner2 = scanner;
            }
            if (scanner2 != null) {
                scanner2.close();
            }
        } catch (Exception e3) {
            e = e3;
            ab.printErrStackTrace("MicroMsg.SDK.TrafficStats", e, "Failed retrieving TrafficStats.", new Object[0]);
            if (scanner != null) {
            }
            ab.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xCf), Long.valueOf(xCe), Long.valueOf(xCd), Long.valueOf(xCc), Long.valueOf(pfI), Long.valueOf(pfH), Long.valueOf(pfG), Long.valueOf(pfF));
            AppMethodBeat.o(52287);
        } catch (Throwable th3) {
            e = th3;
            scanner2 = scanner;
            if (scanner2 != null) {
            }
            AppMethodBeat.o(52287);
            throw e;
        }
        ab.i("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d", Long.valueOf(xCf), Long.valueOf(xCe), Long.valueOf(xCd), Long.valueOf(xCc), Long.valueOf(pfI), Long.valueOf(pfH), Long.valueOf(pfG), Long.valueOf(pfF));
        AppMethodBeat.o(52287);
    }
}
