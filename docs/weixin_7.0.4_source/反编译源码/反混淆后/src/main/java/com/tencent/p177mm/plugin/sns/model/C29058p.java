package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6296c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.C13478s;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cax;
import com.tencent.p177mm.protocal.protobuf.cay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.sns.model.p */
public final class C29058p extends C1207m implements C1918k {
    String cHr = "";
    private C7472b ehh;
    public C1202f ehi;
    private String filename;
    private OutputStream output = null;
    private String qJc;
    private int qJd = -1;
    int qJe = -1;
    private boolean qJf = true;
    private String qJg = null;
    private bau qJh;

    public C29058p(bau bau, String str, String str2, int i, boolean z, int i2, String str3) {
        AppMethodBeat.m2504i(36264);
        this.cHr = str;
        this.qJh = bau;
        this.qJf = z;
        this.qJd = i;
        this.qJe = i2;
        this.qJg = str3;
        this.qJc = C3892an.m6198fZ(C13373af.getAccSnsPath(), str);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cax();
        c1196a.fsK = new cay();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        c1196a.fsI = 208;
        c1196a.fsL = 96;
        c1196a.fsM = 1000000096;
        this.ehh = c1196a.acD();
        cax cax = (cax) this.ehh.fsG.fsP;
        C29098r Zi = C13373af.cnu().mo25630Zi(str);
        if (Zi == null) {
            Zi = new C29098r();
        }
        Zi.rfH = str;
        Zi.offset = 0;
        C13373af.cnu().mo25633a(str, Zi);
        if (z) {
            this.filename = C29036i.m46123n(bau);
        } else {
            this.filename = C29036i.m46122m(bau);
        }
        C5730e.m8643tf(this.qJc);
        C5730e.deleteFile(C3892an.m6198fZ(C13373af.getAccSnsPath(), str) + this.filename);
        cax.xac = str2;
        cax.xad = 0;
        cax.ptx = 0;
        cax.ptw = 0;
        cax.jCt = this.qJd;
        C4990ab.m7410d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(str3)));
        AppMethodBeat.m2505o(36264);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36265);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36265);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36266);
        C4990ab.m7410d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cay cay = (cay) ((C7472b) c1929q).fsH.fsP;
        if (((C6296c) c1929q.mo5618ZS()).vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C13373af.cnA().mo69133XG(this.qJg);
            AppMethodBeat.m2505o(36266);
            return;
        }
        C29098r Zi = C13373af.cnu().mo25630Zi(this.cHr);
        if (cay.ptw <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
            AppMethodBeat.m2505o(36266);
        } else if (cay.vJd == null) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
            AppMethodBeat.m2505o(36266);
        } else if (cay.ptx < 0 || cay.ptx + cay.vJd.getBuffer().f1226wR.length > cay.ptw) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
            AppMethodBeat.m2505o(36266);
        } else if (cay.ptx != Zi.offset) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
            AppMethodBeat.m2505o(36266);
        } else {
            int R = m46194R(cay.vJd.getBuffer().toByteArray());
            if (R < 0) {
                C4990ab.m7412e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                AppMethodBeat.m2505o(36266);
                return;
            }
            Object obj;
            Zi.offset += R;
            Zi.rfD = cay.ptw;
            C4990ab.m7410d("MicroMsg.NetSceneSnsDownload", "byteLen " + R + "  totalLen " + cay.ptw);
            C13373af.cnu().mo25633a(this.cHr, Zi);
            if (Zi.offset != Zi.rfD || Zi.rfD == 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                String e;
                C4990ab.m7410d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                if (this.qJe == 1) {
                    e = C29036i.m46108e(this.qJh);
                } else {
                    e = C29036i.m46121l(this.qJh);
                }
                String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), this.cHr);
                C5730e.deleteFile(fZ + e);
                C5730e.m8633h(fZ, this.filename, e);
                if (this.qJf) {
                    C13478s.m21644b(fZ, e, C29036i.m46110f(this.qJh), (float) C13373af.cnN());
                } else {
                    String e2 = C29036i.m46108e(this.qJh);
                    if (!C5730e.m8628ct(fZ + e2)) {
                        C13478s.m21641a(fZ, e, e2, (float) C13373af.cnO());
                    }
                    e2 = C29036i.m46110f(this.qJh);
                    if (!C5730e.m8628ct(fZ + e2)) {
                        C13478s.m21644b(fZ, e, e2, (float) C13373af.cnN());
                    }
                }
                C13373af.cnA().mo69133XG(this.qJg);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36266);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(36266);
        }
    }

    private void onError() {
        AppMethodBeat.m2504i(36267);
        C13373af.cnA().mo69133XG(this.qJg);
        AppMethodBeat.m2505o(36267);
    }

    public final int getType() {
        return 208;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: R */
    private int m46194R(byte[] bArr) {
        AppMethodBeat.m2504i(36268);
        if (C29036i.m46091Xn(C13373af.getAccPath())) {
            try {
                if (this.output == null) {
                    C5730e.m8643tf(this.qJc);
                    this.output = C5730e.m8617L(this.qJc + this.filename, false);
                }
                C4990ab.m7410d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
                this.output.write(bArr);
                aco();
                int length = bArr.length;
                AppMethodBeat.m2505o(36268);
                return length;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
                aco();
                AppMethodBeat.m2505o(36268);
                return -1;
            } catch (Throwable th) {
                aco();
                AppMethodBeat.m2505o(36268);
            }
        } else {
            AppMethodBeat.m2505o(36268);
            return 0;
        }
    }

    private void aco() {
        AppMethodBeat.m2504i(36269);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.m2505o(36269);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
            AppMethodBeat.m2505o(36269);
        }
    }
}
