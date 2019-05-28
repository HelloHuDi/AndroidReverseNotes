package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bb.a;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    f ehi;
    String elr = "";
    private final q ftU = new b();
    private int ftx = 2;

    public e(String str) {
        AppMethodBeat.i(26083);
        a aVar = (a) this.ftU.acF();
        aVar.flY.jBB = str;
        aVar.flY.wue = 1;
        ab.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", Integer.valueOf(1), str);
        AppMethodBeat.o(26083);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(26084);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(26084);
        return a;
    }

    public final int acn() {
        return 3;
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final void a(m.a aVar) {
    }

    public final int getType() {
        return bb.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26085);
        com.tencent.mm.model.bb.b bVar = (com.tencent.mm.model.bb.b) qVar.ZS();
        this.elr = bVar.flZ.wuf;
        ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.elr);
        if (i2 == 4 && i3 == -301) {
            ax.a(true, bVar.flZ.vLL, bVar.flZ.vLM, bVar.flZ.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(26085);
                return;
            }
            ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            a(this.ftf, this.ehi);
            AppMethodBeat.o(26085);
        } else if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = qVar.acF().vyj.ver;
            ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26082);
                    new i().a(e.this.ftf, new f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(26081);
                            ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                e.this.a(e.this.ftf, e.this.ehi);
                                AppMethodBeat.o(26081);
                                return;
                            }
                            e.this.ehi.onSceneEnd(i, i2, "", e.this);
                            AppMethodBeat.o(26081);
                        }
                    });
                    AppMethodBeat.o(26082);
                }
            });
            AppMethodBeat.o(26085);
        } else if (i2 == 0 || i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26085);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(26085);
        }
    }
}
