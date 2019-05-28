package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class d extends b {
    private int qOA = 0;
    private long qOz = 0;

    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String Yx(String str) {
        return str;
    }

    public final boolean coq() {
        return false;
    }

    public final u b(u uVar) {
        AppMethodBeat.i(36747);
        this.qOz = 0;
        if (this.qOz > 0) {
            ab.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.qOz);
            uVar.setRequestProperty("RANGE", "bytes=" + this.qOz + "-");
        }
        AppMethodBeat.o(36747);
        return uVar;
    }

    public final boolean E(InputStream inputStream) {
        AppMethodBeat.i(36748);
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            String str = this.qOa.getPath() + this.qOa.cop();
            ab.i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(e.asZ(str))));
            outputStream = e.L(str, true);
            int i = 1;
            long currentTimeMillis = System.currentTimeMillis();
            this.qOl.value = "";
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (this.qOo == 0) {
                        this.qOo = bo.gb(this.qOp);
                    }
                    if (read > this.qOm) {
                        this.qOm = read;
                        this.qOn = bo.anT();
                    }
                    if (i.Xn(af.getAccPath())) {
                        outputStream.write(bArr, 0, read);
                        this.qOt += read;
                        if (this.qOt - this.qOA > Downloads.SPLIT_RANGE_SIZE_WAP * i) {
                            af.bCo().post(new AnonymousClass3(this.qOa.cHr, str));
                            this.qOA = this.qOt;
                            i++;
                        }
                        obj = 1;
                        if (b.a(this.qOt, currentTimeMillis, this.qOl)) {
                            currentTimeMillis = System.currentTimeMillis();
                            obj = null;
                        }
                    } else {
                        ab.i("MicroMsg.SnsDownloadAdSight", "read data");
                        outputStream.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(36748);
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    b.a(this.qOt, 0, this.qOl);
                }
                ab.i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(e.asZ(this.qOa.getPath() + this.qOa.cop()))));
                AppMethodBeat.o(36748);
                return true;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(36748);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(36748);
        }
    }

    public final boolean cor() {
        AppMethodBeat.i(36749);
        long asZ = e.asZ(this.qOa.getPath() + this.qOa.cop());
        ab.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + asZ + " " + this.qOq);
        if (asZ < ((long) this.qOq) + this.qOz) {
            AppMethodBeat.o(36749);
            return false;
        }
        e.h(this.qOa.getPath(), this.qOa.cop(), i.k(this.cNr));
        AppMethodBeat.o(36749);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 4;
    }
}
