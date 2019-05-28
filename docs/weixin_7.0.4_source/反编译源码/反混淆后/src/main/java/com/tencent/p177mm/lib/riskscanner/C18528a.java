package com.tencent.p177mm.lib.riskscanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.PrintWriter;
import java.io.StringWriter;

/* renamed from: com.tencent.mm.lib.riskscanner.a */
final class C18528a {
    private static ThreadLocal<Long> eOz = new ThreadLocal();

    static {
        AppMethodBeat.m2504i(114457);
        AppMethodBeat.m2505o(114457);
    }

    /* renamed from: SZ */
    public static void m28834SZ() {
        AppMethodBeat.m2504i(114454);
        C4990ab.m7416i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        C7053e.pXa.mo8378a(590, 0, 1, true);
        eOz.set(Long.valueOf(C5046bo.m7588yz()));
        AppMethodBeat.m2505o(114454);
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
    /* renamed from: g */
    public static void m28835g(Throwable th) {
        PrintWriter printWriter;
        Throwable th2;
        PrintWriter printWriter2;
        AppMethodBeat.m2504i(114455);
        C4990ab.m7417i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", th.getMessage());
        eOz.remove();
        C7053e.pXa.mo8378a(590, 4, 1, true);
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
                AppMethodBeat.m2505o(114455);
                throw th2;
            }
            try {
                th.printStackTrace(printWriter);
                printWriter.flush();
                C7053e.pXa.mo8376a(14177, "-1,".concat(String.valueOf(stringWriter.toString().replace(",", "##"))), false, true);
                try {
                    stringWriter.close();
                } catch (Throwable th4) {
                }
                try {
                    printWriter.close();
                    AppMethodBeat.m2505o(114455);
                } catch (Throwable th5) {
                    AppMethodBeat.m2505o(114455);
                }
            } catch (Throwable th6) {
                th2 = th6;
                printWriter2 = printWriter;
                if (stringWriter != null) {
                }
                if (printWriter2 != null) {
                }
                AppMethodBeat.m2505o(114455);
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
            AppMethodBeat.m2505o(114455);
            throw th2;
        }
    }

    /* renamed from: jX */
    public static void m28836jX(int i) {
        AppMethodBeat.m2504i(114456);
        C4990ab.m7417i("MicroMsg.RiskScannerReportService", "Report scan result, %d", Integer.valueOf(i));
        switch (i) {
            case -10:
                C7053e.pXa.mo8378a(590, 2, 1, true);
                AppMethodBeat.m2505o(114456);
                return;
            case 0:
                Long l = (Long) eOz.get();
                if (l != null) {
                    C4990ab.m7417i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", Long.valueOf(C5046bo.m7588yz() - l.longValue()));
                    C7053e.pXa.mo8380d(C45628v.CTRL_INDEX, 5, 1, (int) r4, true);
                    AppMethodBeat.m2505o(114456);
                    return;
                }
                C7053e.pXa.mo8378a(590, 1, 1, true);
                AppMethodBeat.m2505o(114456);
                return;
            default:
                C7053e.pXa.mo8378a(590, 3, 1, true);
                AppMethodBeat.m2505o(114456);
                return;
        }
    }
}
