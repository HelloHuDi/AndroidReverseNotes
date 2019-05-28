package com.tencent.mm.bf;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.clh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class a extends m implements k {
    private int aTg;
    private b ehh;
    f ehi;
    private String fQv;
    private int fQw;
    int fQx;
    private int fQy;
    private String filemd5;
    String filename;
    ap frk;
    private int sampleRate;

    public a(String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(116535);
        this.fQv = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.fQw = 0;
        this.aTg = 0;
        this.fQx = 0;
        this.fQy = 5;
        this.frk = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(116534);
                ab.d("MicroMsg.NetSceneUploadMedia", g.Mq() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + e.asZ(a.this.filename) + " oldoff:" + a.this.fQx);
                if (a.this.a(a.this.ftf, a.this.ehi) == -1) {
                    a.this.ehi.onSceneEnd(3, -1, "doScene failed", a.this);
                }
                AppMethodBeat.o(116534);
                return false;
            }
        }, true);
        this.fQv = bo.anU();
        this.filename = str;
        this.fQy = i;
        this.sampleRate = i2;
        this.fQw = i3;
        this.aTg = i4;
        this.filemd5 = com.tencent.mm.a.g.x(e.e(this.filename, 0, (int) e.asZ(this.filename)));
        AppMethodBeat.o(116535);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        int i = 3960;
        AppMethodBeat.i(116536);
        this.ehi = fVar;
        int asZ = (int) e.asZ(this.filename);
        ab.d("MicroMsg.NetSceneUploadMedia", g.Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + "this.filemd5 " + this.filemd5);
        if (asZ <= 0) {
            ab.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            AppMethodBeat.o(116536);
            return -1;
        }
        int i2 = asZ - this.fQx;
        if (i2 <= 3960) {
            i = i2;
        }
        ab.i("MicroMsg.NetSceneUploadMedia", g.Mq() + " read file:" + this.filename + " filelen:" + asZ + " oldoff:" + this.fQx + "  canReadLen " + i);
        byte[] e = e.e(this.filename, this.fQx, i);
        if (e == null) {
            ab.e("MicroMsg.NetSceneUploadMedia", "read data error");
            AppMethodBeat.o(116536);
            return -1;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new clg();
        aVar.fsK = new clh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.fsI = 240;
        aVar.fsL = 111;
        aVar.fsM = 1000000111;
        this.ehh = aVar.acD();
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
        i = a(eVar, this.ehh, this);
        AppMethodBeat.o(116536);
        return i;
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116537);
        ab.d("MicroMsg.NetSceneUploadMedia", g.Mq() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        clg clg = (clg) ((b) qVar).fsG.fsP;
        String str2 = ((clh) ((b) qVar).fsH.fsP).fKk;
        ab.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(clg.ptw), Integer.valueOf(clg.pty), Integer.valueOf(clg.ptx));
        if (i2 != 0 || i3 != 0) {
            ab.e("MicroMsg.NetSceneUploadMedia", g.Mq() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116537);
        } else if (clg.ptw > clg.pty + clg.ptx || str2 == null || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.fQx = clg.ptz.getILen() + clg.ptx;
            ab.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.frk.ae(500, 500);
            AppMethodBeat.o(116537);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(116537);
        }
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 60;
    }
}
