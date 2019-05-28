package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.protocal.protobuf.C23376ck;
import com.tencent.p177mm.protocal.protobuf.C44108cj;
import com.tencent.p177mm.protocal.protobuf.ach;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.g */
public final class C27833g extends C45874a<C44108cj, C23376ck> {
    List<String> jzq;
    private final WeakReference<C38927b<C27833g>> lqU;
    public ArrayList<ach> lvv;

    /* renamed from: g */
    public final /* synthetic */ void mo7173g(C1331a c1331a) {
        AppMethodBeat.m2504i(19447);
        C44108cj c44108cj = (C44108cj) c1331a;
        for (String add : this.jzq) {
            c44108cj.fLd.add(add);
        }
        AppMethodBeat.m2505o(19447);
    }

    public C27833g(List<String> list, C38927b<C27833g> c38927b) {
        AppMethodBeat.m2504i(19445);
        this.jzq = list;
        this.lqU = new WeakReference(c38927b);
        AppMethodBeat.m2505o(19445);
    }

    public final int getType() {
        return 1777;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19446);
        C4990ab.m7411d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C23376ck c23376ck = (C23376ck) aTS();
            this.lvv = new ArrayList();
            if (c23376ck.vEx != null) {
                Iterator it = c23376ck.vEx.iterator();
                while (it.hasNext()) {
                    C4990ab.m7411d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", Integer.valueOf(r1.index), Integer.valueOf(r1.hzv), ((ach) it.next()).username);
                    this.lvv.add(r1);
                }
                C4990ab.m7411d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", this.lvv.toString(), Integer.valueOf(c23376ck.vEx.size()));
            }
            C45891ad.boY().mo54564a(this.lvv, "hardcode_rank_id", "hardcode_app_name");
        }
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C38927b c38927b = (C38927b) this.lqU.get();
        if (c38927b != null) {
            c38927b.mo23473a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19446);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19448);
        C23376ck c23376ck = new C23376ck();
        AppMethodBeat.m2505o(19448);
        return c23376ck;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19449);
        C44108cj c44108cj = new C44108cj();
        AppMethodBeat.m2505o(19449);
        return c44108cj;
    }
}
