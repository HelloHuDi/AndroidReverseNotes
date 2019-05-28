package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.protocal.protobuf.acj;
import com.tencent.p177mm.protocal.protobuf.aqr;
import com.tencent.p177mm.protocal.protobuf.aqs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.k */
public final class C34025k extends C45874a<aqr, aqs> {
    private final WeakReference<C38927b<C34025k>> lqU;
    public List<String> lvZ;
    public List<String> lwa;
    public List<String> lwb;

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo7173g(C1331a c1331a) {
    }

    public C34025k(C38927b<C34025k> c38927b) {
        AppMethodBeat.m2504i(19462);
        this.lqU = new WeakReference(c38927b);
        AppMethodBeat.m2505o(19462);
    }

    public final int getType() {
        return 1758;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19463);
        C4990ab.m7411d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aqs aqs = (aqs) aTS();
            this.lwb = new ArrayList();
            Iterator it = aqs.wuF.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().aoJ(str2)) {
                    this.lwb.add(str2);
                }
            }
            this.lvZ = new ArrayList();
            this.lwa = new ArrayList();
            if (aqs.wuG != null) {
                Iterator it2 = aqs.wuG.iterator();
                while (it2.hasNext()) {
                    acj acj = (acj) it2.next();
                    if (acj.wke) {
                        this.lwa.add(acj.username);
                    }
                    C9638aw.m17190ZK();
                    if (C18628c.m29078XM().aoJ(acj.username)) {
                        this.lvZ.add(acj.username);
                    }
                }
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", Integer.valueOf(this.lwa.size()), this.lwa.toString());
            C4990ab.m7411d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", Integer.valueOf(this.lvZ.size()), this.lvZ);
        }
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C38927b c38927b = (C38927b) this.lqU.get();
        if (c38927b != null) {
            C4990ab.m7410d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            c38927b.mo23473a(i2, i3, str, this);
            AppMethodBeat.m2505o(19463);
            return;
        }
        C4990ab.m7410d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
        AppMethodBeat.m2505o(19463);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19464);
        aqs aqs = new aqs();
        AppMethodBeat.m2505o(19464);
        return aqs;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19465);
        aqr aqr = new aqr();
        AppMethodBeat.m2505o(19465);
        return aqr;
    }
}
