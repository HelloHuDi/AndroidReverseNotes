package com.tencent.p177mm.plugin.exdevice.p1545a;

import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.a.a */
public abstract class C45874a<RequestType extends C1331a, ResponseType extends C1331a> extends C1207m implements C1918k {
    private C1202f eIc;
    protected C7472b lqv;

    public abstract RequestType bon();

    public abstract ResponseType boo();

    public abstract String getUri();

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo7173g(RequestType requestType) {
    }

    public final ResponseType aTS() {
        if (this.lqv == null || this.lqv.fsH.fsP == null) {
            return null;
        }
        return this.lqv.fsH.fsP;
    }

    /* renamed from: a */
    public void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        C4990ab.m7417i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.eIc = c1202f;
        if (this.lqv == null) {
            C1196a c1196a = new C1196a();
            c1196a.fsI = getType();
            c1196a.uri = getUri();
            c1196a.fsJ = bon();
            c1196a.fsK = boo();
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            this.lqv = c1196a.acD();
            mo7173g(this.lqv.fsG.fsP);
        }
        return mo4457a(c1902e, this.lqv, this);
    }
}
