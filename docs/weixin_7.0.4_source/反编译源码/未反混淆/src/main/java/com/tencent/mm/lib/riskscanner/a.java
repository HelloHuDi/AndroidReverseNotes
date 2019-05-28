package com.tencent.mm.lib.riskscanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.PrintWriter;
import java.io.StringWriter;

final class a {
    private static ThreadLocal<Long> eOz = new ThreadLocal();

    static {
        AppMethodBeat.i(114457);
        AppMethodBeat.o(114457);
    }

    public static void SZ() {
        AppMethodBeat.i(114454);
        ab.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        e.pXa.a(590, 0, 1, true);
        eOz.set(Long.valueOf(bo.yz()));
        AppMethodBeat.o(114454);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A:{SYNTHETIC, Splitter:B:17:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A:{SYNTHETIC, Splitter:B:20:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A:{SYNTHETIC, Splitter:B:28:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A:{SYNTHETIC, Splitter:B:31:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070 A:{SYNTHETIC, Splitter:B:17:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A:{SYNTHETIC, Splitter:B:20:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A:{SYNTHETIC, Splitter:B:28:0x0087} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A:{SYNTHETIC, Splitter:B:31:0x008c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(Throwable th) {
        PrintWriter printWriter;
        Throwable th2;
        PrintWriter printWriter2;
        AppMethodBeat.i(114455);
        ab.i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", th.getMessage());
        eOz.remove();
        e.pXa.a(590, 4, 1, true);
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable th3) {
                th2 = th3;
                printWriter2 = null;
                if (stringWriter != null) {
                }
                if (printWriter2 != null) {
                }
                AppMethodBeat.o(114455);
                throw th2;
            }
            try {
                th.printStackTrace(printWriter);
                printWriter.flush();
                e.pXa.a(14177, "-1,".concat(String.valueOf(stringWriter.toString().replace(",", "##"))), false, true);
                try {
                    stringWriter.close();
                } catch (Throwable th4) {
                }
                try {
                    printWriter.close();
                    AppMethodBeat.o(114455);
                } catch (Throwable th5) {
                    AppMethodBeat.o(114455);
                }
            } catch (Throwable th6) {
                th2 = th6;
                printWriter2 = printWriter;
                if (stringWriter != null) {
                }
                if (printWriter2 != null) {
                }
                AppMethodBeat.o(114455);
                throw th2;
            }
        } catch (Throwable th32) {
            th2 = th32;
            printWriter2 = null;
            stringWriter = null;
            if (stringWriter != null) {
                try {
                    stringWriter.close();
                } catch (Throwable th7) {
                }
            }
            if (printWriter2 != null) {
                try {
                    printWriter2.close();
                } catch (Throwable th8) {
                }
            }
            AppMethodBeat.o(114455);
            throw th2;
        }
    }

    public static void jX(int i) {
        AppMethodBeat.i(114456);
        ab.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", Integer.valueOf(i));
        switch (i) {
            case -10:
                e.pXa.a(590, 2, 1, true);
                AppMethodBeat.o(114456);
                return;
            case 0:
                Long l = (Long) eOz.get();
                if (l != null) {
                    ab.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", Long.valueOf(bo.yz() - l.longValue()));
                    e.pXa.d(v.CTRL_INDEX, 5, 1, (int) r4, true);
                    AppMethodBeat.o(114456);
                    return;
                }
                e.pXa.a(590, 1, 1, true);
                AppMethodBeat.o(114456);
                return;
            default:
                e.pXa.a(590, 3, 1, true);
                AppMethodBeat.o(114456);
                return;
        }
    }
}
