package com.tencent.p177mm.plugin.sns.model.p519a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C43558b.C219173;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.a.d */
public final class C3881d extends C36808b {
    private int qOA = 0;
    private long qOz = 0;

    public C3881d(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
    }

    /* renamed from: Yx */
    public final String mo8601Yx(String str) {
        return str;
    }

    public final boolean coq() {
        return false;
    }

    /* renamed from: b */
    public final C1936u mo8602b(C1936u c1936u) {
        AppMethodBeat.m2504i(36747);
        this.qOz = 0;
        if (this.qOz > 0) {
            C4990ab.m7416i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.qOz);
            c1936u.setRequestProperty("RANGE", "bytes=" + this.qOz + "-");
        }
        AppMethodBeat.m2505o(36747);
        return c1936u;
    }

    /* renamed from: E */
    public final boolean mo8600E(InputStream inputStream) {
        AppMethodBeat.m2504i(36748);
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            String str = this.qOa.getPath() + this.qOa.cop();
            C4990ab.m7416i("MicroMsg.SnsDownloadAdSight", "getdatabegin ".concat(String.valueOf(C5730e.asZ(str))));
            outputStream = C5730e.m8617L(str, true);
            int i = 1;
            long currentTimeMillis = System.currentTimeMillis();
            this.qOl.value = "";
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (this.qOo == 0) {
                        this.qOo = C5046bo.m7566gb(this.qOp);
                    }
                    if (read > this.qOm) {
                        this.qOm = read;
                        this.qOn = C5046bo.anT();
                    }
                    if (C29036i.m46091Xn(C13373af.getAccPath())) {
                        outputStream.write(bArr, 0, read);
                        this.qOt += read;
                        if (this.qOt - this.qOA > Downloads.SPLIT_RANGE_SIZE_WAP * i) {
                            C13373af.bCo().post(new C219173(this.qOa.cHr, str));
                            this.qOA = this.qOt;
                            i++;
                        }
                        obj = 1;
                        if (C36808b.m61164a(this.qOt, currentTimeMillis, this.qOl)) {
                            currentTimeMillis = System.currentTimeMillis();
                            obj = null;
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.SnsDownloadAdSight", "read data");
                        outputStream.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(36748);
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    C36808b.m61164a(this.qOt, 0, this.qOl);
                }
                C4990ab.m7416i("MicroMsg.SnsDownloadAdSight", "getdataend2  ".concat(String.valueOf(C5730e.asZ(this.qOa.getPath() + this.qOa.cop()))));
                AppMethodBeat.m2505o(36748);
                return true;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            C4990ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(36748);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(36748);
        }
    }

    public final boolean cor() {
        AppMethodBeat.m2504i(36749);
        long asZ = C5730e.asZ(this.qOa.getPath() + this.qOa.cop());
        C4990ab.m7416i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + asZ + " " + this.qOq);
        if (asZ < ((long) this.qOq) + this.qOz) {
            AppMethodBeat.m2505o(36749);
            return false;
        }
        C5730e.m8633h(this.qOa.getPath(), this.qOa.cop(), C29036i.m46119k(this.cNr));
        AppMethodBeat.m2505o(36749);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final int cos() {
        return 4;
    }
}
