package com.tencent.p177mm.p1185bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cks;
import com.tencent.p177mm.protocal.protobuf.ckt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.io.File;

/* renamed from: com.tencent.mm.bc.b */
public final class C17973b extends C1207m implements C1918k {
    private String clientId;
    private int coc;
    private C7472b ehh;
    private C1202f ehi;
    public String fNa;
    private int frO;
    private String imgPath;
    private String username;

    public C17973b(String str, String str2) {
        this(str);
        this.imgPath = str2;
    }

    private C17973b(String str) {
        AppMethodBeat.m2504i(136858);
        this.username = str;
        this.frO = 0;
        this.coc = 0;
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        this.clientId = stringBuilder.append(C1668a.m3383QF()).append(System.currentTimeMillis()).toString();
        AppMethodBeat.m2505o(136858);
    }

    public final int getType() {
        return 575;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(136859);
        C1206b c1206b;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(136859);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(136859);
        return c1206b;
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(136860);
        this.ehi = c1202f;
        if (this.imgPath == null || this.imgPath.length() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            AppMethodBeat.m2505o(136860);
            return -1;
        } else if (C1173e.m2561ct(this.imgPath)) {
            if (this.frO == 0) {
                this.frO = (int) new File(this.imgPath).length();
            }
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cks();
            c1196a.fsK = new ckt();
            c1196a.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            c1196a.fsI = 575;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            this.ehh = c1196a.acD();
            byte[] e = C1173e.m2569e(this.imgPath, this.coc, Math.min(this.frO - this.coc, 32768));
            if (e == null) {
                C4990ab.m7412e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                AppMethodBeat.m2505o(136860);
                return -1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(e.length), Integer.valueOf(this.frO));
            cks cks = (cks) this.ehh.fsG.fsP;
            cks.wcP = this.username;
            cks.ptw = this.frO;
            cks.ptx = this.coc;
            cks.ptz = new SKBuiltinBuffer_t().setBuffer(e);
            cks.pty = cks.ptz.getILen();
            cks.ptv = this.clientId;
            int a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(136860);
            return a;
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.imgPath);
            AppMethodBeat.m2505o(136860);
            return -1;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(136861);
        C4990ab.m7411d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ckt ckt = (ckt) ((C7472b) c1929q).fsH.fsP;
            this.fNa = ckt.wGv;
            this.coc = ckt.ptx;
            if (this.coc < this.frO) {
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                C4990ab.m7410d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                AppMethodBeat.m2505o(136861);
                return;
            }
            if (!C5046bo.isNullOrNil(this.fNa)) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
                if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                    aoO.mo14726iY(this.fNa);
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(this.username, aoO);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(136861);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(136861);
    }
}
