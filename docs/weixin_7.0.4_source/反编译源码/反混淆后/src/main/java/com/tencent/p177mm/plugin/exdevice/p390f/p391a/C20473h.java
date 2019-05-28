package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.protocal.protobuf.C35962vq;
import com.tencent.p177mm.protocal.protobuf.C40581vr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.h */
public final class C20473h extends C45874a<C35962vq, C40581vr> {
    private final WeakReference<C38927b<C20473h>> lqU;
    String username;

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo7173g(C1331a c1331a) {
        ((C35962vq) c1331a).wcF = this.username;
    }

    public C20473h(String str, C38927b<C20473h> c38927b) {
        AppMethodBeat.m2504i(19450);
        this.username = str;
        this.lqU = new WeakReference(c38927b);
        AppMethodBeat.m2505o(19450);
    }

    public final int getType() {
        return 1792;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19451);
        C4990ab.m7411d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        if (i2 == 0 && i3 == 0) {
            C45891ad.boY().mo54562Kq(this.username);
        }
        C38927b c38927b = (C38927b) this.lqU.get();
        if (c38927b != null) {
            c38927b.mo23473a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19451);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19452);
        C40581vr c40581vr = new C40581vr();
        AppMethodBeat.m2505o(19452);
        return c40581vr;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19453);
        C35962vq c35962vq = new C35962vq();
        AppMethodBeat.m2505o(19453);
        return c35962vq;
    }
}
