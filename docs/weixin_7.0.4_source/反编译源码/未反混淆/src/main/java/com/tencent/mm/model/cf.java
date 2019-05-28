package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class cf {
    public static boolean fnO = false;
    private static cf fnR = null;
    private ArrayList<String> fnP = new ArrayList();
    private String fnQ = "";

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cf(String str, boolean z) {
        Throwable e;
        AppMethodBeat.i(58145);
        RandomAccessFile randomAccessFile;
        try {
            this.fnQ = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.fnQ, "rw");
            try {
                String format;
                long length = randomAccessFile.length();
                ab.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.vxo), this.fnQ);
                if (length <= 0 || length > 10240) {
                    randomAccessFile.seek(0);
                    if (!z) {
                        format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                        randomAccessFile.write((format + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                        this.fnP.add(format);
                    }
                } else {
                    while (randomAccessFile.getFilePointer() < length) {
                        format = bo.bc(randomAccessFile.readLine(), "");
                        if (format.length() != 8) {
                            ab.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.fnQ);
                        } else if (format.startsWith("2")) {
                            this.fnP.add(format);
                        } else {
                            ab.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.fnQ);
                        }
                    }
                }
                format = String.format("%x", new Object[]{Integer.valueOf(d.vxo)});
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
                ab.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(fnO), str2, this.fnQ);
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.VersionHistory", e2, "Close Version History file failed.", "");
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.VersionHistory", e, "Open Version History file failed.", "");
                    try {
                        randomAccessFile.close();
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.VersionHistory", e22, "Close Version History file failed.", "");
                    }
                    if (fnR != null) {
                    }
                    AppMethodBeat.o(58145);
                    return;
                } catch (Throwable th) {
                    e = th;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e4) {
                        ab.printErrStackTrace("MicroMsg.VersionHistory", e4, "Close Version History file failed.", "");
                    }
                    AppMethodBeat.o(58145);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
            ab.printErrStackTrace("MicroMsg.VersionHistory", e, "Open Version History file failed.", "");
            randomAccessFile.close();
            if (fnR != null) {
            }
            AppMethodBeat.o(58145);
            return;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            AppMethodBeat.o(58145);
            throw e;
        }
        if (fnR != null || fnR == this || fnR.fnP.size() >= this.fnP.size()) {
            AppMethodBeat.o(58145);
            return;
        }
        fnR.fnP = this.fnP;
        e.y(this.fnQ, fnR.fnQ);
        AppMethodBeat.o(58145);
    }

    public static void oO(String str) {
        AppMethodBeat.i(58146);
        fnR = new cf(str, true);
        AppMethodBeat.o(58146);
    }

    public static String aaH() {
        AppMethodBeat.i(58147);
        String str;
        if (fnR != null) {
            cf cfVar = fnR;
            str = "";
            int size = 4 >= cfVar.fnP.size() ? 0 : cfVar.fnP.size() - 4;
            while (true) {
                int i = size;
                if (i < cfVar.fnP.size()) {
                    str = str + ((String) cfVar.fnP.get(i)) + ";";
                    size = i + 1;
                } else {
                    AppMethodBeat.o(58147);
                    return str;
                }
            }
        }
        str = "";
        AppMethodBeat.o(58147);
        return str;
    }
}
