package com.tencent.p177mm.plugin.exdevice.p390f.p954b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.a */
public final class C38938a {
    SparseArray<WeakReference<C27835e>> lwe;

    /* renamed from: a */
    public final void mo61821a(C27835e c27835e) {
        AppMethodBeat.m2504i(19475);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            this.lwe = new SparseArray();
        }
        this.lwe.put(c27835e.hashCode(), new WeakReference(c27835e));
        AppMethodBeat.m2505o(19475);
    }

    /* renamed from: b */
    public final void mo61823b(C27835e c27835e) {
        AppMethodBeat.m2504i(19476);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
            AppMethodBeat.m2505o(19476);
            return;
        }
        this.lwe.remove(c27835e.hashCode());
        AppMethodBeat.m2505o(19476);
    }

    /* renamed from: a */
    public final void mo61822a(String str, C27834d c27834d) {
        AppMethodBeat.m2504i(19477);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            C4990ab.m7410d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            AppMethodBeat.m2505o(19477);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lwe.size()) {
                C27835e c27835e = (C27835e) ((WeakReference) this.lwe.get(this.lwe.keyAt(i2))).get();
                if (c27835e != null) {
                    c27835e.mo30744b(str, c27834d);
                }
                i = i2 + 1;
            } else {
                C4990ab.m7410d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
                AppMethodBeat.m2505o(19477);
                return;
            }
        }
    }
}
