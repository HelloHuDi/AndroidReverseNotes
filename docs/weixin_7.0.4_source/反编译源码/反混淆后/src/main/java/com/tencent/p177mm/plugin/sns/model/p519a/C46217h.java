package com.tencent.p177mm.plugin.sns.model.p519a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.a.h */
public final class C46217h extends C36808b {
    public C46217h(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
    }

    /* renamed from: Yx */
    public final String mo8601Yx(String str) {
        return str;
    }

    /* renamed from: E */
    public final boolean mo8600E(InputStream inputStream) {
        AppMethodBeat.m2504i(36752);
        C4990ab.m7417i("MicroMsg.SnsDownloadSightForAdShort", "download sight. %s ", this.qOa.getPath() + this.qOa.cop());
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            outputStream = C5730e.m8617L(this.qOa.getPath() + this.qOa.cop(), false);
            long currentTimeMillis = System.currentTimeMillis();
            this.qOl.value = "";
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (read > this.qOm) {
                        this.qOm = read;
                        this.qOn = C5046bo.anT();
                    }
                    if (this.qOo == 0) {
                        this.qOo = C5046bo.m7566gb(this.qOp);
                    }
                    if (C29036i.m46091Xn(C13373af.getAccPath())) {
                        outputStream.write(bArr, 0, read);
                        this.qOt += read;
                        obj = 1;
                        if (C36808b.m61164a(this.qOt, currentTimeMillis, this.qOl)) {
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
                                C4990ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(36752);
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    C36808b.m61164a(this.qOt, 0, this.qOl);
                }
                AppMethodBeat.m2505o(36752);
                return true;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            C4990ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(36752);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsDownloadSightForAdShort", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(36752);
        }
    }

    public final boolean cor() {
        AppMethodBeat.m2504i(36753);
        C5730e.m8633h(this.qOa.getPath(), this.qOa.cop(), C29036i.m46116j(this.cNr));
        AppMethodBeat.m2505o(36753);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 2;
    }
}
