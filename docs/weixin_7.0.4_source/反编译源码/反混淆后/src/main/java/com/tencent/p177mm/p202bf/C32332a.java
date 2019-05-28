package com.tencent.p177mm.p202bf;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.clg;
import com.tencent.p177mm.protocal.protobuf.clh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.bf.a */
public final class C32332a extends C1207m implements C1918k {
    private int aTg;
    private C7472b ehh;
    C1202f ehi;
    private String fQv;
    private int fQw;
    int fQx;
    private int fQy;
    private String filemd5;
    String filename;
    C7564ap frk;
    private int sampleRate;

    /* renamed from: com.tencent.mm.bf.a$1 */
    class C323331 implements C5015a {
        C323331() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116534);
            C4990ab.m7410d("MicroMsg.NetSceneUploadMedia", C1447g.m3075Mq() + " onTimerExpired: file:" + C32332a.this.filename + " nowlen:" + C5730e.asZ(C32332a.this.filename) + " oldoff:" + C32332a.this.fQx);
            if (C32332a.this.mo4456a(C32332a.this.ftf, C32332a.this.ehi) == -1) {
                C32332a.this.ehi.onSceneEnd(3, -1, "doScene failed", C32332a.this);
            }
            AppMethodBeat.m2505o(116534);
            return false;
        }
    }

    public C32332a(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(116535);
        this.fQv = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.fQw = 0;
        this.aTg = 0;
        this.fQx = 0;
        this.fQy = 5;
        this.frk = new C7564ap(new C323331(), true);
        this.fQv = C5046bo.anU();
        this.filename = str;
        this.fQy = i;
        this.sampleRate = i2;
        this.fQw = i3;
        this.aTg = i4;
        this.filemd5 = C1178g.m2591x(C5730e.m8632e(this.filename, 0, (int) C5730e.asZ(this.filename)));
        AppMethodBeat.m2505o(116535);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = 3960;
        AppMethodBeat.m2504i(116536);
        this.ehi = c1202f;
        int asZ = (int) C5730e.asZ(this.filename);
        C4990ab.m7410d("MicroMsg.NetSceneUploadMedia", C1447g.m3075Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + "this.filemd5 " + this.filemd5);
        if (asZ <= 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            AppMethodBeat.m2505o(116536);
            return -1;
        }
        int i2 = asZ - this.fQx;
        if (i2 <= 3960) {
            i = i2;
        }
        C4990ab.m7416i("MicroMsg.NetSceneUploadMedia", C1447g.m3075Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + "  canReadLen " + i);
        byte[] e = C5730e.m8632e(this.filename, this.fQx, i);
        if (e == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMedia", "read data error");
            AppMethodBeat.m2505o(116536);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clg();
        c1196a.fsK = new clh();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        c1196a.fsI = 240;
        c1196a.fsL = 111;
        c1196a.fsM = 1000000111;
        this.ehh = c1196a.acD();
        clg clg = (clg) this.ehh.fsG.fsP;
        clg.xiT = new bts().alV(this.fQv);
        clg.ptz = new SKBuiltinBuffer_t().setBuffer(e);
        clg.pty = e.length;
        clg.xiU = new bts().alV(this.filemd5);
        clg.ptw = asZ;
        clg.ptx = this.fQx;
        clg.nda = this.fQy;
        clg.xiV = 1;
        clg.xiW = this.sampleRate;
        clg.xiX = this.fQw;
        clg.xiY = this.aTg;
        i = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(116536);
        return i;
    }

    public final int getType() {
        return 240;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116537);
        C4990ab.m7410d("MicroMsg.NetSceneUploadMedia", C1447g.m3075Mq() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        clg clg = (clg) ((C7472b) c1929q).fsG.fsP;
        String str2 = ((clh) ((C7472b) c1929q).fsH.fsP).fKk;
        C4990ab.m7417i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(clg.ptw), Integer.valueOf(clg.pty), Integer.valueOf(clg.ptx));
        if (i2 != 0 || i3 != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadMedia", C1447g.m3075Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116537);
        } else if (clg.ptw > clg.pty + clg.ptx || str2 == null || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.fQx = clg.ptz.getILen() + clg.ptx;
            C4990ab.m7410d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.frk.mo16770ae(500, 500);
            AppMethodBeat.m2505o(116537);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(116537);
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 60;
    }
}
