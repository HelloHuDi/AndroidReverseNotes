package com.tencent.mm.ap;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class a extends m implements k {
    private bi csG = new bi();
    private f ehi;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(16437);
            a.this.a(999, 0, 0, "", null, null);
            AppMethodBeat.o(16437);
        }
    };

    public a(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(16438);
        this.csG.setStatus(1);
        this.csG.ju(str);
        this.csG.eJ(bf.oC(str));
        this.csG.hO(1);
        this.csG.setContent(str2);
        this.csG.setType(t.nK(str));
        aw.ZK();
        long Z = c.XO().Z(this.csG);
        if (Z == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        ab.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
        AppMethodBeat.o(16438);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16439);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.csG.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(16439);
        return 999;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.storage.c.CTRL_INDEX;
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16440);
        ab.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.csG.field_msgId);
        this.csG.setStatus(2);
        this.csG.eJ(bf.q(this.csG.field_talker, System.currentTimeMillis() / 1000));
        aw.ZK();
        c.XO().a(this.csG.field_msgId, this.csG);
        this.ehi.onSceneEnd(0, 0, str, this);
        AppMethodBeat.o(16440);
    }
}
