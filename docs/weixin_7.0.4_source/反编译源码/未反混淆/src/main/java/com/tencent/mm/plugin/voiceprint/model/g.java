package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    f ehi;
    private final q ftU = new a();
    String sKW = "";
    int sKX = 0;
    private String sKY = "";

    public g(String str) {
        AppMethodBeat.i(26092);
        a aVar = (a) this.ftU.acF();
        ab.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(73), str);
        aVar.flW.wub = 73;
        aVar.flW.wuc = str;
        AppMethodBeat.o(26092);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26093);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(26093);
        return a;
    }

    public final int getType() {
        return bd.CTRL_INDEX;
    }

    public final int acn() {
        return 3;
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final void a(m.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26094);
        ab.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ba.b bVar = (ba.b) qVar.ZS();
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26091);
                    new i().a(g.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(26090);
                            ab.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                g.this.a(g.this.ftf, g.this.ehi);
                                AppMethodBeat.o(26090);
                                return;
                            }
                            g.this.ehi.onSceneEnd(i, i2, "", g.this);
                            AppMethodBeat.o(26090);
                        }
                    });
                    AppMethodBeat.o(26091);
                }
            });
            AppMethodBeat.o(26094);
        } else if (i2 == 0 || i3 == 0) {
            if (bVar.flX.wud != null) {
                this.sKW = new String(bVar.flX.wud.wVc.getBufferToBytes());
                this.sKX = bVar.flX.wud.wTu;
                ab.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", Integer.valueOf(this.sKX), this.sKY, this.sKW);
            } else {
                ab.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26094);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26094);
        }
    }
}
