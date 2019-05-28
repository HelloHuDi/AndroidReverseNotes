package com.tencent.p177mm.p182ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ajj;
import com.tencent.p177mm.protocal.protobuf.ajk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.ah.k */
final class C41734k extends C1207m implements C1918k {
    private C1202f ehi;
    private String frH;
    private int frL;
    private String frN;
    private int fsc;
    private String fsd;
    private OutputStream output = null;
    private String username;

    public C41734k(String str) {
        AppMethodBeat.m2504i(77932);
        this.username = str;
        if (C7616ad.m13548mR(str)) {
            this.username = C7616ad.aoC(str);
        }
        C4990ab.m7416i("MicroMsg.NetSceneGetHDHeadImg", "init Headimage in_username:" + str + " out_username" + this.username);
        this.frL = 480;
        this.fsc = 480;
        this.frN = "jpg";
        AppMethodBeat.m2505o(77932);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        boolean z = false;
        AppMethodBeat.m2504i(77933);
        this.ehi = c1202f;
        if (this.username == null || this.username.length() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "username is null");
            AppMethodBeat.m2505o(77933);
            return -1;
        } else if (this.username.endsWith("@qqim")) {
            C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "never try get qq user hd.");
            AppMethodBeat.m2505o(77933);
            return -1;
        } else {
            C17879g acu = C17884o.acu();
            C17884o.acd();
            this.frH = C41732d.m73514C(this.username, true);
            if (C5730e.m8628ct(this.frH)) {
                C4990ab.m7416i("MicroMsg.NetSceneGetHDHeadImg", "The HDAvatar of " + this.username + " is already exists");
                AppMethodBeat.m2505o(77933);
                return 0;
            }
            C37438f c37438f;
            this.fsd = this.frH + ".tmp";
            C37438f qm = acu.mo33380qm(this.username);
            if (qm == null) {
                C5730e.deleteFile(this.fsd);
                qm = new C37438f();
                qm.username = this.username;
                qm.frN = this.frN;
                qm.frL = this.frL;
                qm.frM = this.fsc;
                qm.bJt = -1;
                acu.fni.insert("hdheadimginfo", "username", qm.mo60326Hl());
                c37438f = qm;
            } else {
                String str = this.fsd;
                if (qm != null && str != null && str.length() != 0 && qm.aci().equals(this.frN) && qm.frL == this.frL && qm.frM == this.fsc && C5730e.asZ(str) == ((long) qm.coc)) {
                    z = true;
                }
                if (!z) {
                    C5730e.deleteFile(this.fsd);
                    qm.reset();
                    qm.username = this.username;
                    qm.frN = this.frN;
                    qm.frL = this.frL;
                    qm.frM = this.fsc;
                    acu.mo33379a(this.username, qm);
                }
                c37438f = qm;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new ajj();
            c1196a.fsK = new ajk();
            c1196a.uri = "/cgi-bin/micromsg-bin/gethdheadimg";
            c1196a.fsI = 158;
            c1196a.fsL = 47;
            c1196a.fsM = 1000000047;
            C7472b acD = c1196a.acD();
            ajj ajj = (ajj) acD.fsG.fsP;
            if (!C7616ad.m13548mR(this.username)) {
                ajj.jBB = this.username;
                ajj.wpi = 1;
            } else if (this.username.equals(C1853r.m3846Yz() + "@bottle")) {
                ajj.jBB = C1853r.m3846Yz();
                ajj.wpi = 2;
            } else {
                ajj.jBB = this.username;
                ajj.wpi = 2;
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetHDHeadImg", "inUser:" + this.username + " outUser:" + ajj.jBB + " outType:" + ajj.wpi);
            ajj.wpf = this.frL;
            ajj.wpg = this.fsc;
            ajj.wph = this.frN;
            ajj.ptw = c37438f.frO;
            ajj.ptx = c37438f.coc;
            int a = mo4457a(c1902e, acD, this);
            AppMethodBeat.m2505o(77933);
            return a;
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(77934);
        C1206b c1206b;
        if (this.username == null || this.username.length() == 0) {
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(77934);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(77934);
        return c1206b;
    }

    public final int acn() {
        return 10;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(77935);
        ajk ajk = (ajk) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7410d("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            aco();
            AppMethodBeat.m2505o(77935);
        } else if (i2 == 4 || i2 == 5) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "ErrType:".concat(String.valueOf(i2)));
            aco();
            AppMethodBeat.m2505o(77935);
        } else {
            Object obj;
            int i4 = c1929q.mo5618ZS().vyl;
            if (i4 == -4 || i4 == -54 || i4 == -55) {
                C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "retcode == ".concat(String.valueOf(i4)));
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "handleCertainError");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.m2505o(77935);
                return;
            }
            i4 = -1;
            if (!(ajk.ptz == null || ajk.ptz.getBuffer() == null)) {
                i4 = m73540R(ajk.ptz.getBuffer().f1226wR);
            }
            if (i4 < 0) {
                C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "appendBuf fail");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.m2505o(77935);
                return;
            }
            C17879g acu = C17884o.acu();
            C37438f qm = acu.mo33380qm(this.username);
            if (qm == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetHDHeadImg", "info == null");
                this.ehi.onSceneEnd(i2, i3, str, this);
                aco();
                AppMethodBeat.m2505o(77935);
                return;
            }
            Object obj2;
            qm.coc = i4 + ajk.ptx;
            qm.frO = ajk.ptw;
            acu.mo33379a(this.username, qm);
            if (qm.coc >= qm.frO) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                C4990ab.m7417i("MicroMsg.NetSceneGetHDHeadImg", "%d doScene again info[%s %d %d]", Integer.valueOf(hashCode()), this.username, Integer.valueOf(qm.coc), Integer.valueOf(qm.frO));
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.m2505o(77935);
                return;
            }
            C5730e.m8623aQ(this.fsd, this.frH);
            C41734k.m73541av(this.frH, this.username);
            aco();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(77935);
        }
    }

    /* renamed from: av */
    public static void m73541av(String str, String str2) {
        AppMethodBeat.m2504i(77936);
        C17884o.acd().mo67499au(str, str2);
        AppMethodBeat.m2505o(77936);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(77937);
        super.cancel();
        aco();
        AppMethodBeat.m2505o(77937);
    }

    public final int getType() {
        return 158;
    }

    /* renamed from: R */
    private int m73540R(byte[] bArr) {
        AppMethodBeat.m2504i(77938);
        try {
            if (this.output == null) {
                this.output = C5730e.m8617L(this.fsd, false);
            }
            this.output.write(bArr);
            int length = bArr.length;
            AppMethodBeat.m2505o(77938);
            return length;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(77938);
            return -1;
        }
    }

    private void aco() {
        AppMethodBeat.m2504i(77939);
        try {
            if (this.output != null) {
                this.output.flush();
                this.output.close();
                this.output = null;
            }
            AppMethodBeat.m2505o(77939);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.NetSceneGetHDHeadImg", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(77939);
        }
    }
}
