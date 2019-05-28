package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.cay;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.OutputStream;

public final class p extends m implements k {
    String cHr = "";
    private b ehh;
    public f ehi;
    private String filename;
    private OutputStream output = null;
    private String qJc;
    private int qJd = -1;
    int qJe = -1;
    private boolean qJf = true;
    private String qJg = null;
    private bau qJh;

    public p(bau bau, String str, String str2, int i, boolean z, int i2, String str3) {
        AppMethodBeat.i(36264);
        this.cHr = str;
        this.qJh = bau;
        this.qJf = z;
        this.qJd = i;
        this.qJe = i2;
        this.qJg = str3;
        this.qJc = an.fZ(af.getAccSnsPath(), str);
        a aVar = new a();
        aVar.fsJ = new cax();
        aVar.fsK = new cay();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.fsI = 208;
        aVar.fsL = 96;
        aVar.fsM = 1000000096;
        this.ehh = aVar.acD();
        cax cax = (cax) this.ehh.fsG.fsP;
        r Zi = af.cnu().Zi(str);
        if (Zi == null) {
            Zi = new r();
        }
        Zi.rfH = str;
        Zi.offset = 0;
        af.cnu().a(str, Zi);
        if (z) {
            this.filename = i.n(bau);
        } else {
            this.filename = i.m(bau);
        }
        e.tf(this.qJc);
        e.deleteFile(an.fZ(af.getAccSnsPath(), str) + this.filename);
        cax.xac = str2;
        cax.xad = 0;
        cax.ptx = 0;
        cax.ptw = 0;
        cax.jCt = this.qJd;
        ab.d("MicroMsg.NetSceneSnsDownload", "requestKey ".concat(String.valueOf(str3)));
        AppMethodBeat.o(36264);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36265);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36265);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36266);
        ab.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cay cay = (cay) ((b) qVar).fsH.fsP;
        if (((c) qVar.ZS()).vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            af.cnA().XG(this.qJg);
            AppMethodBeat.o(36266);
            return;
        }
        r Zi = af.cnu().Zi(this.cHr);
        if (cay.ptw <= 0) {
            ab.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
            AppMethodBeat.o(36266);
        } else if (cay.vJd == null) {
            ab.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
            AppMethodBeat.o(36266);
        } else if (cay.ptx < 0 || cay.ptx + cay.vJd.getBuffer().wR.length > cay.ptw) {
            ab.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
            AppMethodBeat.o(36266);
        } else if (cay.ptx != Zi.offset) {
            ab.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
            AppMethodBeat.o(36266);
        } else {
            int R = R(cay.vJd.getBuffer().toByteArray());
            if (R < 0) {
                ab.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                AppMethodBeat.o(36266);
                return;
            }
            Object obj;
            Zi.offset += R;
            Zi.rfD = cay.ptw;
            ab.d("MicroMsg.NetSceneSnsDownload", "byteLen " + R + "  totalLen " + cay.ptw);
            af.cnu().a(this.cHr, Zi);
            if (Zi.offset != Zi.rfD || Zi.rfD == 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                String e;
                ab.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                if (this.qJe == 1) {
                    e = i.e(this.qJh);
                } else {
                    e = i.l(this.qJh);
                }
                String fZ = an.fZ(af.getAccSnsPath(), this.cHr);
                e.deleteFile(fZ + e);
                e.h(fZ, this.filename, e);
                if (this.qJf) {
                    s.b(fZ, e, i.f(this.qJh), (float) af.cnN());
                } else {
                    String e2 = i.e(this.qJh);
                    if (!e.ct(fZ + e2)) {
                        s.a(fZ, e, e2, (float) af.cnO());
                    }
                    e2 = i.f(this.qJh);
                    if (!e.ct(fZ + e2)) {
                        s.b(fZ, e, e2, (float) af.cnN());
                    }
                }
                af.cnA().XG(this.qJg);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36266);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(36266);
        }
    }

    private void onError() {
        AppMethodBeat.i(36267);
        af.cnA().XG(this.qJg);
        AppMethodBeat.o(36267);
    }

    public final int getType() {
        return 208;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 100;
    }

    private int R(byte[] bArr) {
        AppMethodBeat.i(36268);
        if (i.Xn(af.getAccPath())) {
            try {
                if (this.output == null) {
                    e.tf(this.qJc);
                    this.output = e.L(this.qJc + this.filename, false);
                }
                ab.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
                this.output.write(bArr);
                aco();
                int length = bArr.length;
                AppMethodBeat.o(36268);
                return length;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
                aco();
                AppMethodBeat.o(36268);
                return -1;
            } catch (Throwable th) {
                aco();
                AppMethodBeat.o(36268);
            }
        } else {
            AppMethodBeat.o(36268);
            return 0;
        }
    }

    private void aco() {
        AppMethodBeat.i(36269);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.o(36269);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
            AppMethodBeat.o(36269);
        }
    }
}
