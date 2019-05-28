package com.tencent.p177mm.plugin.ipcall.p438a.p1274a;

import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.a.a */
public abstract class C43218a implements C1202f {
    protected int errCode = 0;
    protected int errType = 0;
    protected C43219c nvN;
    protected C28323a nwr;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.a.a$a */
    public interface C28323a {
        /* renamed from: a */
        void mo46234a(int i, Object obj, int i2, int i3);

        /* renamed from: b */
        void mo46235b(int i, Object obj, int i2, int i3);
    }

    /* renamed from: b */
    public abstract void mo24088b(C43219c c43219c);

    public abstract int[] bHC();

    public abstract int getServiceType();

    public abstract void onDestroy();

    /* renamed from: wO */
    public abstract void mo24092wO();

    /* renamed from: a */
    public final void mo68721a(C28323a c28323a) {
        this.nwr = c28323a;
    }

    public void init() {
        for (int a : bHC()) {
            C9638aw.m17182Rg().mo14539a(a, (C1202f) this);
        }
        mo24092wO();
    }

    public void destroy() {
        for (int b : bHC()) {
            C9638aw.m17182Rg().mo14546b(b, (C1202f) this);
        }
        this.nwr = null;
        onDestroy();
    }

    /* renamed from: a */
    public void mo68722a(C43219c c43219c) {
        C4990ab.m7411d("MicroMsg.BaseIPCallService", "start service, type: %d", Integer.valueOf(getServiceType()));
        this.nvN = c43219c;
        mo24088b(this.nvN);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        C4990ab.m7411d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.getType()), Integer.valueOf(getServiceType()));
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.nwr != null) {
                this.nwr.mo46234a(getServiceType(), c1207m, i, i2);
            }
        } else if (this.nwr != null) {
            this.nwr.mo46235b(getServiceType(), c1207m, i, i2);
        }
    }
}
