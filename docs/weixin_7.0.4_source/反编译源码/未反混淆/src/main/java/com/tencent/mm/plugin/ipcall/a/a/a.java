package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a implements f {
    protected int errCode = 0;
    protected int errType = 0;
    protected c nvN;
    protected a nwr;

    public interface a {
        void a(int i, Object obj, int i2, int i3);

        void b(int i, Object obj, int i2, int i3);
    }

    public abstract void b(c cVar);

    public abstract int[] bHC();

    public abstract int getServiceType();

    public abstract void onDestroy();

    public abstract void wO();

    public final void a(a aVar) {
        this.nwr = aVar;
    }

    public void init() {
        for (int a : bHC()) {
            aw.Rg().a(a, (f) this);
        }
        wO();
    }

    public void destroy() {
        for (int b : bHC()) {
            aw.Rg().b(b, (f) this);
        }
        this.nwr = null;
        onDestroy();
    }

    public void a(c cVar) {
        ab.d("MicroMsg.BaseIPCallService", "start service, type: %d", Integer.valueOf(getServiceType()));
        this.nvN = cVar;
        b(this.nvN);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        ab.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.getType()), Integer.valueOf(getServiceType()));
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.nwr != null) {
                this.nwr.a(getServiceType(), mVar, i, i2);
            }
        } else if (this.nwr != null) {
            this.nwr.b(getServiceType(), mVar, i, i2);
        }
    }
}
