package com.tencent.mm.plugin.sns.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class h extends b {
    public h(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String Yx(String str) {
        return str;
    }

    public final boolean E(InputStream inputStream) {
        AppMethodBeat.i(36752);
        ab.i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", this.qOa.getPath() + this.qOa.cop());
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            outputStream = e.L(this.qOa.getPath() + this.qOa.cop(), false);
            long currentTimeMillis = System.currentTimeMillis();
            this.qOl.value = "";
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (read > this.qOm) {
                        this.qOm = read;
                        this.qOn = bo.anT();
                    }
                    if (this.qOo == 0) {
                        this.qOo = bo.gb(this.qOp);
                    }
                    if (i.Xn(af.getAccPath())) {
                        outputStream.write(bArr, 0, read);
                        this.qOt += read;
                        obj = 1;
                        if (b.a(this.qOt, currentTimeMillis, this.qOl)) {
                            currentTimeMillis = System.currentTimeMillis();
                            obj = null;
                        }
                    } else {
                        outputStream.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(36752);
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    b.a(this.qOt, 0, this.qOl);
                }
                AppMethodBeat.o(36752);
                return true;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(36752);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(36752);
        }
    }

    public final boolean cor() {
        AppMethodBeat.i(36753);
        e.h(this.qOa.getPath(), this.qOa.cop(), i.j(this.cNr));
        AppMethodBeat.o(36753);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 2;
    }
}
