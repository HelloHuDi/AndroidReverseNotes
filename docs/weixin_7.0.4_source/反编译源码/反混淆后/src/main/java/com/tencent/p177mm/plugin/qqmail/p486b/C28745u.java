package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.qqmail.b.u */
public final class C28745u extends C1207m implements C1918k {
    private String cJb;
    private int coc = 0;
    private C7472b ehh;
    private C1202f ehi;
    private C32231g fEW;
    public String filePath = null;
    private int frO = 0;

    public C28745u(String str, String str2, C32231g c32231g) {
        AppMethodBeat.m2504i(67988);
        this.filePath = str;
        this.cJb = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.fEW = c32231g;
        C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", this.cJb, this.filePath);
        AppMethodBeat.m2505o(67988);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(67989);
        C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C34749ah c34749ah = (C34749ah) ((C7472b) c1929q).fsH.fsP;
            String str2 = c34749ah.ptv;
            C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", c34749ah.ptv, Integer.valueOf(c34749ah.ptw), c34749ah.ptE);
            if (str2.equals(this.cJb)) {
                this.coc = c34749ah.ptx;
                if (this.coc < this.frO) {
                    C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.coc), Integer.valueOf(this.frO));
                    if (mo4456a(this.ftf, this.ehi) < 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.ehi != null) {
                            this.ehi.onSceneEnd(i2, i3, str, this);
                        }
                        if (this.fEW != null) {
                            this.fEW.mo8280a(this.coc, this.frO, this);
                        }
                        AppMethodBeat.m2505o(67989);
                        return;
                    }
                }
                String str3 = c34749ah.ptE;
                C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", Integer.valueOf(this.coc), Integer.valueOf(this.frO), str3);
                if (this.ehi != null) {
                    this.ehi.onSceneEnd(i2, i3, str, this);
                }
                if (this.fEW != null) {
                    this.fEW.mo8280a(this.coc, this.frO, this);
                }
                AppMethodBeat.m2505o(67989);
                return;
            }
            AppMethodBeat.m2505o(67989);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(67989);
    }

    public final int acn() {
        return 640;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(67990);
        C1206b c1206b;
        if (C5046bo.isNullOrNil(this.filePath) || !C5730e.m8628ct(this.filePath)) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(67990);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(67990);
        return c1206b;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    public final int getType() {
        return 484;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(67991);
        this.ehi = c1202f;
        if (C5046bo.isNullOrNil(this.filePath)) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            AppMethodBeat.m2505o(67991);
            return -1;
        } else if (C5730e.m8628ct(this.filePath)) {
            if (this.frO == 0) {
                this.frO = (int) C5730e.asZ(this.filePath);
                C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", Integer.valueOf(this.frO));
            }
            int min = Math.min(this.frO - this.coc, 32768);
            C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", Integer.valueOf(this.coc), Integer.valueOf(min));
            byte[] e = C5730e.m8632e(this.filePath, this.coc, min);
            if (e == null) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                AppMethodBeat.m2505o(67991);
                return -1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", Integer.valueOf(e.length));
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C34748ag();
            c1196a.fsK = new C34749ah();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadfile";
            c1196a.fsI = 484;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            this.ehh = c1196a.acD();
            C34748ag c34748ag = (C34748ag) this.ehh.fsG.fsP;
            c34748ag.ptv = this.cJb;
            c34748ag.ptw = this.frO;
            c34748ag.ptx = this.coc;
            c34748ag.pty = min;
            c34748ag.ptz = C1946aa.m4152ad(e);
            C4990ab.m7417i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", Integer.valueOf(mo4457a(c1902e, this.ehh, this)));
            AppMethodBeat.m2505o(67991);
            return mo4457a(c1902e, this.ehh, this);
        } else {
            C4990ab.m7413e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", this.filePath);
            AppMethodBeat.m2505o(67991);
            return -1;
        }
    }

    public final C34749ah ccv() {
        if (this.ehh != null) {
            return (C34749ah) this.ehh.fsH.fsP;
        }
        return null;
    }
}
