package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a<RequestType extends com.tencent.mm.bt.a, ResponseType extends com.tencent.mm.bt.a> extends m implements k {
    private f eIc;
    protected b lqv;

    public abstract RequestType bon();

    public abstract ResponseType boo();

    public abstract String getUri();

    /* Access modifiers changed, original: protected */
    public void g(RequestType requestType) {
    }

    public final ResponseType aTS() {
        if (this.lqv == null || this.lqv.fsH.fsP == null) {
            return null;
        }
        return this.lqv.fsH.fsP;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ab.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
    }

    public final int a(e eVar, f fVar) {
        this.eIc = fVar;
        if (this.lqv == null) {
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = getType();
            aVar.uri = getUri();
            aVar.fsJ = bon();
            aVar.fsK = boo();
            aVar.fsL = 0;
            aVar.fsM = 0;
            this.lqv = aVar.acD();
            g(this.lqv.fsG.fsP);
        }
        return a(eVar, this.lqv, this);
    }
}
