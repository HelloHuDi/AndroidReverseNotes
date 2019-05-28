package com.tencent.p177mm.plugin.exdevice.p1609c.p1610a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.protocal.protobuf.C35958ub;
import com.tencent.p177mm.protocal.protobuf.C35959uc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.exdevice.c.a.a */
public final class C42984a extends C45874a<C35958ub, C35959uc> {
    String appId;
    String ceI;
    String cws;
    String lqT;
    private WeakReference<C38927b<C42984a>> lqU;

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo7173g(C1331a c1331a) {
        C35958ub c35958ub = (C35958ub) c1331a;
        c35958ub.wbq = this.ceI;
        c35958ub.vIk = this.cws;
        c35958ub.wbr = this.lqT;
        c35958ub.fKh = this.appId;
    }

    public C42984a(String str, String str2, String str3, String str4, C38927b<C42984a> c38927b) {
        AppMethodBeat.m2504i(19067);
        this.ceI = C5046bo.nullAsNil(str);
        this.cws = C5046bo.nullAsNil(str2);
        this.lqT = C5046bo.nullAsNil(str3);
        this.appId = C5046bo.nullAsNil(str4);
        this.lqU = new WeakReference(c38927b);
        AppMethodBeat.m2505o(19067);
    }

    public final int getType() {
        return 1799;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19068);
        C4990ab.m7411d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, c1929q.toString());
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C38927b c38927b = (C38927b) this.lqU.get();
        if (c38927b != null) {
            c38927b.mo23473a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19068);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19069);
        C35959uc c35959uc = new C35959uc();
        AppMethodBeat.m2505o(19069);
        return c35959uc;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19070);
        C35958ub c35958ub = new C35958ub();
        AppMethodBeat.m2505o(19070);
        return c35958ub;
    }
}
