package com.tencent.p177mm.pluginsdk.p1082i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40620aa;
import com.tencent.p177mm.vfs.C5730e;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.i.c */
public final class C14862c {
    private static boolean[] vfY = new boolean[21];

    /* renamed from: com.tencent.mm.pluginsdk.i.c$1 */
    static class C148631 implements Runnable {
        C148631() {
        }

        public final void run() {
            AppMethodBeat.m2504i(27472);
            C14862c.access$000();
            AppMethodBeat.m2505o(27472);
        }
    }

    public static boolean diH() {
        AppMethodBeat.m2504i(27473);
        C1720g.m3537RQ();
        if (C1720g.m3536RP().isSDCardAvailable()) {
            boolean ajm = C14862c.ajm(C6457e.eSn);
            C1720g.m3539RS().mo10302aa(new C148631());
            AppMethodBeat.m2505o(27473);
            return ajm;
        }
        AppMethodBeat.m2505o(27473);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2 A:{SYNTHETIC, Splitter:B:35:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d7 A:{SYNTHETIC, Splitter:B:38:0x00d7} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd A:{SYNTHETIC, Splitter:B:48:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102 A:{SYNTHETIC, Splitter:B:51:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2 A:{SYNTHETIC, Splitter:B:35:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d7 A:{SYNTHETIC, Splitter:B:38:0x00d7} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd A:{SYNTHETIC, Splitter:B:48:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102 A:{SYNTHETIC, Splitter:B:51:0x0102} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean ajm(String str) {
        IOException e;
        Throwable th;
        boolean z = true;
        AppMethodBeat.m2504i(27474);
        if (C5730e.m8628ct(str)) {
            String str2 = str + "test_writable";
            DataOutputStream dataOutputStream;
            DataInputStream dataInputStream;
            try {
                if (C5730e.m8628ct(str2)) {
                    C5730e.deleteFile(str2);
                }
                C5730e.atc(str2);
                dataOutputStream = new DataOutputStream(C5730e.m8617L(str2, false));
                try {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    dataInputStream = new DataInputStream(C5730e.openRead(str2));
                    try {
                        int readInt = dataInputStream.readInt();
                        dataInputStream.close();
                        if (!(C5730e.deleteFile(str2) && C5046bo.m7563gW(1, readInt))) {
                            z = false;
                        }
                        try {
                            dataOutputStream.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e2, "", new Object[0]);
                        }
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e3, "", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            C4990ab.m7420w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e.getMessage());
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e5) {
                                    C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e5, "", new Object[0]);
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                    z = false;
                                } catch (IOException e52) {
                                    C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e52, "", new Object[0]);
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            if (!z) {
                            }
                            AppMethodBeat.m2505o(27474);
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e22) {
                                    C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e22, "", new Object[0]);
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e32) {
                                    C4990ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e32, "", new Object[0]);
                                }
                            }
                            AppMethodBeat.m2505o(27474);
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    e52 = e6;
                    dataInputStream = null;
                    C4990ab.m7420w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e52.getMessage());
                    if (dataOutputStream != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    if (z) {
                    }
                    AppMethodBeat.m2505o(27474);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataOutputStream != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    AppMethodBeat.m2505o(27474);
                    throw th;
                }
            } catch (IOException e7) {
                e52 = e7;
                dataInputStream = null;
                dataOutputStream = null;
                C4990ab.m7420w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e52.getMessage());
                if (dataOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                if (z) {
                }
                AppMethodBeat.m2505o(27474);
                return z;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                AppMethodBeat.m2505o(27474);
                throw th;
            }
            if (z) {
                C4990ab.m7420w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; ");
            }
            AppMethodBeat.m2505o(27474);
        } else {
            AppMethodBeat.m2505o(27474);
        }
        return z;
    }

    static /* synthetic */ void access$000() {
        StringBuilder stringBuilder;
        AppMethodBeat.m2504i(27475);
        long currentTimeMillis = System.currentTimeMillis();
        if (!(vfY[4] || C14862c.ajm(C6457e.euQ))) {
            C7060h.pYm.mo15419k(951, 4, 1);
            vfY[4] = true;
        }
        if (!(vfY[5] || C14862c.ajm(C6457e.euT))) {
            C7060h.pYm.mo15419k(951, 5, 1);
            vfY[5] = true;
        }
        if (!(vfY[6] || C14862c.ajm(C6457e.euR))) {
            C7060h.pYm.mo15419k(951, 6, 1);
            vfY[6] = true;
        }
        if (!(vfY[7] || C14862c.ajm(C6457e.evi))) {
            C7060h.pYm.mo15419k(951, 7, 1);
            vfY[7] = true;
        }
        if (!(vfY[8] || C14862c.ajm(C6457e.euX))) {
            C7060h.pYm.mo15419k(951, 8, 1);
            vfY[8] = true;
        }
        if (!vfY[9]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("emoji/").toString())) {
                C7060h.pYm.mo15419k(951, 9, 1);
                vfY[9] = true;
            }
        }
        if (!vfY[10]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("record/").toString())) {
                C7060h.pYm.mo15419k(951, 10, 1);
                vfY[10] = true;
            }
        }
        if (!vfY[11]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("sns/").toString())) {
                C7060h.pYm.mo15419k(951, 11, 1);
                vfY[11] = true;
            }
        }
        if (!(vfY[12] || C14862c.ajm(C40620aa.m70077Ya()))) {
            C7060h.pYm.mo15419k(951, 12, 1);
            vfY[12] = true;
        }
        if (!(vfY[13] || C14862c.ajm(C43217c.m76863XW()))) {
            C7060h.pYm.mo15419k(951, 13, 1);
            vfY[13] = true;
        }
        if (!(vfY[14] || C14862c.ajm(C43217c.m76864XX()))) {
            C7060h.pYm.mo15419k(951, 14, 1);
            vfY[14] = true;
        }
        if (!vfY[15]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("video/").toString())) {
                C7060h.pYm.mo15419k(951, 15, 1);
                vfY[15] = true;
            }
        }
        if (!(vfY[16] || C14862c.ajm(C32850q.amg()))) {
            C7060h.pYm.mo15419k(951, 16, 1);
            vfY[16] = true;
        }
        if (!(vfY[17] || C14862c.ajm(C32850q.m53708XY()))) {
            C7060h.pYm.mo15419k(951, 17, 1);
            vfY[17] = true;
        }
        if (!vfY[18]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("dbback/").toString())) {
                C7060h.pYm.mo15419k(951, 18, 1);
                vfY[18] = true;
            }
        }
        if (!vfY[19]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("mailapp/").toString())) {
                C7060h.pYm.mo15419k(951, 19, 1);
                vfY[19] = true;
            }
        }
        if (!vfY[20]) {
            stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            if (!C14862c.ajm(stringBuilder.append(C1720g.m3536RP().eJM).append("openim/").toString())) {
                C7060h.pYm.mo15419k(951, 20, 1);
                vfY[20] = true;
            }
        }
        C4990ab.m7410d("MicroMsg.SdcardCheckUtil", "check time:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(27475);
    }
}
