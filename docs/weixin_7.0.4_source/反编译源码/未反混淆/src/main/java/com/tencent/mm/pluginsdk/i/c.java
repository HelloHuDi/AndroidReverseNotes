package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.aa;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class c {
    private static boolean[] vfY = new boolean[21];

    public static boolean diH() {
        AppMethodBeat.i(27473);
        g.RQ();
        if (g.RP().isSDCardAvailable()) {
            boolean ajm = ajm(e.eSn);
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27472);
                    c.access$000();
                    AppMethodBeat.o(27472);
                }
            });
            AppMethodBeat.o(27473);
            return ajm;
        }
        AppMethodBeat.o(27473);
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
        AppMethodBeat.i(27474);
        if (com.tencent.mm.vfs.e.ct(str)) {
            String str2 = str + "test_writable";
            DataOutputStream dataOutputStream;
            DataInputStream dataInputStream;
            try {
                if (com.tencent.mm.vfs.e.ct(str2)) {
                    com.tencent.mm.vfs.e.deleteFile(str2);
                }
                com.tencent.mm.vfs.e.atc(str2);
                dataOutputStream = new DataOutputStream(com.tencent.mm.vfs.e.L(str2, false));
                try {
                    dataOutputStream.writeInt(1);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    dataInputStream = new DataInputStream(com.tencent.mm.vfs.e.openRead(str2));
                    try {
                        int readInt = dataInputStream.readInt();
                        dataInputStream.close();
                        if (!(com.tencent.mm.vfs.e.deleteFile(str2) && bo.gW(1, readInt))) {
                            z = false;
                        }
                        try {
                            dataOutputStream.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e2, "", new Object[0]);
                        }
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e3, "", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            ab.w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e.getMessage());
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e5) {
                                    ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e5, "", new Object[0]);
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                    z = false;
                                } catch (IOException e52) {
                                    ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e52, "", new Object[0]);
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            if (!z) {
                            }
                            AppMethodBeat.o(27474);
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e22) {
                                    ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e22, "", new Object[0]);
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e32) {
                                    ab.printErrStackTrace("MicroMsg.SdcardCheckUtil", e32, "", new Object[0]);
                                }
                            }
                            AppMethodBeat.o(27474);
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    e52 = e6;
                    dataInputStream = null;
                    ab.w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e52.getMessage());
                    if (dataOutputStream != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    if (z) {
                    }
                    AppMethodBeat.o(27474);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataOutputStream != null) {
                    }
                    if (dataInputStream != null) {
                    }
                    AppMethodBeat.o(27474);
                    throw th;
                }
            } catch (IOException e7) {
                e52 = e7;
                dataInputStream = null;
                dataOutputStream = null;
                ab.w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; " + e52.getMessage());
                if (dataOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                if (z) {
                }
                AppMethodBeat.o(27474);
                return z;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                }
                if (dataInputStream != null) {
                }
                AppMethodBeat.o(27474);
                throw th;
            }
            if (z) {
                ab.w("MicroMsg.SdcardCheckUtil", " dir: " + str + " Unusable; ");
            }
            AppMethodBeat.o(27474);
        } else {
            AppMethodBeat.o(27474);
        }
        return z;
    }

    static /* synthetic */ void access$000() {
        StringBuilder stringBuilder;
        AppMethodBeat.i(27475);
        long currentTimeMillis = System.currentTimeMillis();
        if (!(vfY[4] || ajm(e.euQ))) {
            h.pYm.k(951, 4, 1);
            vfY[4] = true;
        }
        if (!(vfY[5] || ajm(e.euT))) {
            h.pYm.k(951, 5, 1);
            vfY[5] = true;
        }
        if (!(vfY[6] || ajm(e.euR))) {
            h.pYm.k(951, 6, 1);
            vfY[6] = true;
        }
        if (!(vfY[7] || ajm(e.evi))) {
            h.pYm.k(951, 7, 1);
            vfY[7] = true;
        }
        if (!(vfY[8] || ajm(e.euX))) {
            h.pYm.k(951, 8, 1);
            vfY[8] = true;
        }
        if (!vfY[9]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("emoji/").toString())) {
                h.pYm.k(951, 9, 1);
                vfY[9] = true;
            }
        }
        if (!vfY[10]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("record/").toString())) {
                h.pYm.k(951, 10, 1);
                vfY[10] = true;
            }
        }
        if (!vfY[11]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("sns/").toString())) {
                h.pYm.k(951, 11, 1);
                vfY[11] = true;
            }
        }
        if (!(vfY[12] || ajm(aa.Ya()))) {
            h.pYm.k(951, 12, 1);
            vfY[12] = true;
        }
        if (!(vfY[13] || ajm(com.tencent.mm.plugin.i.c.XW()))) {
            h.pYm.k(951, 13, 1);
            vfY[13] = true;
        }
        if (!(vfY[14] || ajm(com.tencent.mm.plugin.i.c.XX()))) {
            h.pYm.k(951, 14, 1);
            vfY[14] = true;
        }
        if (!vfY[15]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("video/").toString())) {
                h.pYm.k(951, 15, 1);
                vfY[15] = true;
            }
        }
        if (!(vfY[16] || ajm(q.amg()))) {
            h.pYm.k(951, 16, 1);
            vfY[16] = true;
        }
        if (!(vfY[17] || ajm(q.XY()))) {
            h.pYm.k(951, 17, 1);
            vfY[17] = true;
        }
        if (!vfY[18]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("dbback/").toString())) {
                h.pYm.k(951, 18, 1);
                vfY[18] = true;
            }
        }
        if (!vfY[19]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("mailapp/").toString())) {
                h.pYm.k(951, 19, 1);
                vfY[19] = true;
            }
        }
        if (!vfY[20]) {
            stringBuilder = new StringBuilder();
            g.RQ();
            if (!ajm(stringBuilder.append(g.RP().eJM).append("openim/").toString())) {
                h.pYm.k(951, 20, 1);
                vfY[20] = true;
            }
        }
        ab.d("MicroMsg.SdcardCheckUtil", "check time:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(27475);
    }
}
