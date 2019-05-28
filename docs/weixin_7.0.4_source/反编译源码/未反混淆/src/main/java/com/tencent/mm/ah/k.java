package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.io.OutputStream;

final class k extends m implements com.tencent.mm.network.k {
    private f ehi;
    private String frH;
    private int frL;
    private String frN;
    private int fsc;
    private String fsd;
    private OutputStream output = null;
    private String username;

    public k(String str) {
        AppMethodBeat.i(77932);
        this.username = str;
        if (ad.mR(str)) {
            this.username = ad.aoC(str);
        }
        ab.i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.frL = 480;
        this.fsc = 480;
        this.frN = "jpg";
        AppMethodBeat.o(77932);
    }

    public final int a(e eVar, f fVar) {
        boolean z = false;
        AppMethodBeat.i(77933);
        this.ehi = fVar;
        if (this.username == null || this.username.length() == 0) {
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            AppMethodBeat.o(77933);
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            AppMethodBeat.o(77933);
            return -1;
        } else {
            g acu = o.acu();
            o.acd();
            this.frH = d.C(this.username, true);
            if (com.tencent.mm.vfs.e.ct(this.frH)) {
                ab.i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                AppMethodBeat.o(77933);
                return 0;
            }
            f fVar2;
            this.fsd = this.frH + ".tmp";
            f qm = acu.qm(this.username);
            if (qm == null) {
                com.tencent.mm.vfs.e.deleteFile(this.fsd);
                qm = new f();
                qm.username = this.username;
                qm.frN = this.frN;
                qm.frL = this.frL;
                qm.frM = this.fsc;
                qm.bJt = -1;
                acu.fni.insert("hdheadimginfo", "username", qm.Hl());
                fVar2 = qm;
            } else {
                String str = this.fsd;
                if (qm != null && str != null && str.length() != 0 && qm.aci().equals(this.frN) && qm.frL == this.frL && qm.frM == this.fsc && com.tencent.mm.vfs.e.asZ(str) == ((long) qm.coc)) {
                    z = true;
                }
                if (!z) {
                    com.tencent.mm.vfs.e.deleteFile(this.fsd);
                    qm.reset();
                    qm.username = this.username;
                    qm.frN = this.frN;
                    qm.frL = this.frL;
                    qm.frM = this.fsc;
                    acu.a(this.username, qm);
                }
                fVar2 = qm;
            }
            a aVar = new a();
            aVar.fsJ = new ajj();
            aVar.fsK = new ajk();
            aVar.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            aVar.fsI = 158;
            aVar.fsL = 47;
            aVar.fsM = 1000000047;
            b acD = aVar.acD();
            ajj ajj = (ajj) acD.fsG.fsP;
            if (!ad.mR(this.username)) {
                ajj.jBB = this.username;
                ajj.wpi = 1;
            } else if (this.username.equals(r.Yz() + "@bottle")) {
                ajj.jBB = r.Yz();
                ajj.wpi = 2;
            } else {
                ajj.jBB = this.username;
                ajj.wpi = 2;
            }
            ab.d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ajj.jBB + " outType:" + ajj.wpi);
            ajj.wpf = this.frL;
            ajj.wpg = this.fsc;
            ajj.wph = this.frN;
            ajj.ptw = fVar2.frO;
            ajj.ptx = fVar2.coc;
            int a = a(eVar, acD, this);
            AppMethodBeat.o(77933);
            return a;
        }
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(77934);
        m.b bVar;
        if (this.username == null || this.username.length() == 0) {
            bVar = m.b.EFailed;
            AppMethodBeat.o(77934);
            return bVar;
        }
        bVar = m.b.EOk;
        AppMethodBeat.o(77934);
        return bVar;
    }

    public final int acn() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(77935);
        ajk ajk = (ajk) ((b) qVar).fsH.fsP;
        ab.d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            aco();
            AppMethodBeat.o(77935);
        } else if (i2 == 4 || i2 == 5) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(i2)));
            aco();
            AppMethodBeat.o(77935);
        } else {
            Object obj;
            int i4 = qVar.ZS().vyl;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                ab.e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(i4)));
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ab.e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.o(77935);
                return;
            }
            i4 = -1;
            if (!(ajk.ptz == null || ajk.ptz.getBuffer() == null)) {
                i4 = R(ajk.ptz.getBuffer().wR);
            }
            if (i4 < 0) {
                ab.e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.o(77935);
                return;
            }
            g acu = o.acu();
            f qm = acu.qm(this.username);
            if (qm == null) {
                ab.e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.o(77935);
                return;
            }
            Object obj2;
            qm.coc = i4 + ajk.ptx;
            qm.frO = ajk.ptw;
            acu.a(this.username, qm);
            if (qm.coc >= qm.frO) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                ab.i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(qm.coc), Integer.valueOf(qm.frO));
                if (a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.o(77935);
                return;
            }
            com.tencent.mm.vfs.e.aQ(this.fsd, this.frH);
            av(this.frH, this.username);
            aco();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(77935);
        }
    }

    public static void av(String str, String str2) {
        AppMethodBeat.i(77936);
        o.acd().au(str, str2);
        AppMethodBeat.o(77936);
    }

    public final void cancel() {
        AppMethodBeat.i(77937);
        super.cancel();
        aco();
        AppMethodBeat.o(77937);
    }

    public final int getType() {
        return 158;
    }

    private int R(byte[] bArr) {
        AppMethodBeat.i(77938);
        try {
            if (this.output == null) {
                this.output = com.tencent.mm.vfs.e.L(this.fsd, false);
            }
            this.output.write(bArr);
            int length = bArr.length;
            AppMethodBeat.o(77938);
            return length;
        } catch (IOException e) {
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bo.l(e));
            AppMethodBeat.o(77938);
            return -1;
        }
    }

    private void aco() {
        AppMethodBeat.i(77939);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.o(77939);
        } catch (IOException e) {
            ab.e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", bo.l(e));
            AppMethodBeat.o(77939);
        }
    }
}
