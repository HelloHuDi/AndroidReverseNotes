package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bc.a;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends m implements k {
    int Kt = 0;
    private int Lp = 0;
    f ehi;
    private String filename;
    private final q ftU;
    String gCk = "";
    public boolean sLb = false;
    private boolean sLd = false;
    private Handler sLe = null;
    private int sLf = 0;

    public h(String str, int i, String str2) {
        AppMethodBeat.i(26097);
        ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", Integer.valueOf(i), bo.bc(str2, ""));
        this.ftU = new c();
        a aVar = (a) this.ftU.acF();
        this.filename = str;
        this.Lp = 0;
        aVar.fma.wTu = i;
        aVar.fma.wuc = str2;
        this.sLf = 0;
        aVar.fma.wTs = 0;
        ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", Integer.valueOf(i), Integer.valueOf(0));
        this.sLb = true;
        cHL();
        AppMethodBeat.o(26097);
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final int acn() {
        return 240;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26098);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(26098);
        return a;
    }

    private int cHL() {
        AppMethodBeat.i(26099);
        a aVar = (a) this.ftU.acF();
        cob cob = new cob();
        g gVar = new g();
        aVar.fma.xkT = cob;
        l lVar = new l(m.by(this.filename, false));
        int asZ = (int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false));
        if (asZ - this.Lp >= 6000) {
            gVar = lVar.cF(this.Lp, 6000);
        } else {
            int i = this.Lp;
            gVar = lVar.cF(i, asZ - i);
        }
        ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", Integer.valueOf(this.Lp), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.cqs), Integer.valueOf(asZ), Boolean.valueOf(this.sLb));
        if (gVar.cqs == 0) {
            AppMethodBeat.o(26099);
            return -2;
        } else if (gVar.ret < 0) {
            ab.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", Integer.valueOf(gVar.ret));
            AppMethodBeat.o(26099);
            return -1;
        } else if (this.Lp >= 469000) {
            ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", Integer.valueOf(this.Lp));
            AppMethodBeat.o(26099);
            return -1;
        } else {
            cob.xlC = new SKBuiltinBuffer_t().setBuffer(gVar.buf);
            cob.ptx = this.Lp;
            cob.xlA = gVar.cqs;
            cob.xlB = 0;
            aVar.fma.wTs = this.sLf;
            if (this.sLb && gVar.fXD >= ((int) com.tencent.mm.vfs.e.asZ(m.by(this.filename, false)))) {
                cob.xlB = 1;
                this.sLd = true;
                ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", Integer.valueOf(asZ));
            }
            this.Lp = gVar.fXD;
            aVar.fma.xkT = cob;
            AppMethodBeat.o(26099);
            return 0;
        }
    }

    public final int getType() {
        return be.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26100);
        ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bc.b bVar = (bc.b) qVar.ZS();
        final int i4;
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            i4 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26096);
                    new i().a(h.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(26095);
                            ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                h.this.a(h.this.ftf, h.this.ehi);
                                AppMethodBeat.o(26095);
                                return;
                            }
                            h.this.ehi.onSceneEnd(i, i2, "", h.this);
                            AppMethodBeat.o(26095);
                        }
                    });
                    AppMethodBeat.o(26096);
                }
            });
            AppMethodBeat.o(26100);
        } else if (i2 == 0 || i3 == 0) {
            this.sLf = bVar.fmb.wTs;
            this.Kt = bVar.fmb.vYu;
            this.gCk = bVar.fmb.xkU;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.fmb.wTs);
            objArr[1] = Integer.valueOf(this.Kt);
            objArr[2] = Boolean.valueOf(bo.isNullOrNil(this.gCk));
            if (bo.isNullOrNil(this.gCk)) {
                i4 = 0;
            } else {
                i4 = this.gCk.length();
            }
            objArr[3] = Integer.valueOf(i4);
            ab.i(str2, str3, objArr);
            if (this.sLd) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(26100);
                return;
            }
            ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", Integer.valueOf(cHL()));
            a(this.ftf, this.ehi);
            ab.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
            AppMethodBeat.o(26100);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26100);
        }
    }
}
