package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.model.cf */
public final class C1842cf {
    public static boolean fnO = false;
    private static C1842cf fnR = null;
    private ArrayList<String> fnP = new ArrayList();
    private String fnQ = "";

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1842cf(String str, boolean z) {
        Throwable e;
        AppMethodBeat.m2504i(58145);
        RandomAccessFile randomAccessFile;
        try {
            this.fnQ = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.fnQ, "rw");
            try {
                String format;
                long length = randomAccessFile.length();
                C4990ab.m7417i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(C7243d.vxo), this.fnQ);
                if (length <= 0 || length > 10240) {
                    randomAccessFile.seek(0);
                    if (!z) {
                        format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                        randomAccessFile.write((format + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                        this.fnP.add(format);
                    }
                } else {
                    while (randomAccessFile.getFilePointer() < length) {
                        format = C5046bo.m7532bc(randomAccessFile.readLine(), "");
                        if (format.length() != 8) {
                            C4990ab.m7413e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.fnQ);
                        } else if (format.startsWith("2")) {
                            this.fnP.add(format);
                        } else {
                            C4990ab.m7413e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.fnQ);
                        }
                    }
                }
                format = String.format("%x", new Object[]{Integer.valueOf(C7243d.vxo)});
                if (this.fnP.size() == 0 || !format.equals(this.fnP.get(this.fnP.size() - 1))) {
                    fnO = true;
                    this.fnP.add(format);
                    randomAccessFile.seek(length);
                    randomAccessFile.write((format + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                }
                String str2 = "";
                for (int i = 0; i < this.fnP.size(); i++) {
                    str2 = str2 + ((String) this.fnP.get(i)) + ";";
                }
                C4990ab.m7417i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(fnO), str2, this.fnQ);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.VersionHistory", e2, "Close Version History file failed.", "");
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.VersionHistory", e, "Open Version History file failed.", "");
                    try {
                        randomAccessFile.close();
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.VersionHistory", e22, "Close Version History file failed.", "");
                    }
                    if (fnR != null) {
                    }
                    AppMethodBeat.m2505o(58145);
                    return;
                } catch (Throwable th) {
                    e = th;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                        C4990ab.printErrStackTrace("MicroMsg.VersionHistory", e4, "Close Version History file failed.", "");
                    }
                    AppMethodBeat.m2505o(58145);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            C4990ab.printErrStackTrace("MicroMsg.VersionHistory", e, "Open Version History file failed.", "");
            randomAccessFile.close();
            if (fnR != null) {
            }
            AppMethodBeat.m2505o(58145);
            return;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            AppMethodBeat.m2505o(58145);
            throw e;
        }
        if (fnR != null || fnR == this || fnR.fnP.size() >= this.fnP.size()) {
            AppMethodBeat.m2505o(58145);
            return;
        }
        fnR.fnP = this.fnP;
        C5730e.m8644y(this.fnQ, fnR.fnQ);
        AppMethodBeat.m2505o(58145);
    }

    /* renamed from: oO */
    public static void m3789oO(String str) {
        AppMethodBeat.m2504i(58146);
        fnR = new C1842cf(str, true);
        AppMethodBeat.m2505o(58146);
    }

    public static String aaH() {
        AppMethodBeat.m2504i(58147);
        String str;
        if (fnR != null) {
            C1842cf c1842cf = fnR;
            str = "";
            int size = 4 >= c1842cf.fnP.size() ? 0 : c1842cf.fnP.size() - 4;
            while (true) {
                int i = size;
                if (i < c1842cf.fnP.size()) {
                    str = str + ((String) c1842cf.fnP.get(i)) + ";";
                    size = i + 1;
                } else {
                    AppMethodBeat.m2505o(58147);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.m2505o(58147);
        return str;
    }
}
