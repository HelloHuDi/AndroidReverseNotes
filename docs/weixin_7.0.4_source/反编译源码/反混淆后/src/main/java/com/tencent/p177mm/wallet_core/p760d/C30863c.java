package com.tencent.p177mm.wallet_core.p760d;

import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.wallet_core.d.c */
public abstract class C30863c<T extends C24157d> implements C1202f {
    public C1202f Agk;
    T Agl;
    public int rtType;

    /* renamed from: a */
    public abstract void mo25116a(C24157d c24157d);

    /* renamed from: a */
    public abstract boolean mo25117a(int i, int i2, T t);

    public final void bMO() {
        C4990ab.m7417i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", Integer.valueOf(this.rtType));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(this.rtType, (C1202f) this);
    }

    /* renamed from: b */
    public final void mo49361b(C24157d c24157d) {
        C4990ab.m7417i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", Integer.valueOf(this.rtType));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(this.rtType, (C1202f) this);
        mo25116a(c24157d);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C4990ab.m7411d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if ((c1207m instanceof C24157d) && !mo25117a(i, i2, (C24157d) c1207m) && this.Agk != null && this.Agl != null && (this.Agl instanceof C1207m)) {
            this.Agk.onSceneEnd(i, i2, str, (C1207m) this.Agl);
        }
    }
}
