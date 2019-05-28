package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c<T extends d> implements f {
    public f Agk;
    T Agl;
    public int rtType;

    public abstract void a(d dVar);

    public abstract boolean a(int i, int i2, T t);

    public final void bMO() {
        ab.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", Integer.valueOf(this.rtType));
        g.RQ();
        g.RO().eJo.b(this.rtType, (f) this);
    }

    public final void b(d dVar) {
        ab.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", Integer.valueOf(this.rtType));
        g.RQ();
        g.RO().eJo.a(this.rtType, (f) this);
        a(dVar);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        ab.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if ((mVar instanceof d) && !a(i, i2, (d) mVar) && this.Agk != null && this.Agl != null && (this.Agl instanceof m)) {
            this.Agk.onSceneEnd(i, i2, str, (m) this.Agl);
        }
    }
}
