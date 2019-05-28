package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> lwe;

    public final void a(e eVar) {
        AppMethodBeat.i(19475);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            this.lwe = new SparseArray();
        }
        this.lwe.put(eVar.hashCode(), new WeakReference(eVar));
        AppMethodBeat.o(19475);
    }

    public final void b(e eVar) {
        AppMethodBeat.i(19476);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
            AppMethodBeat.o(19476);
            return;
        }
        this.lwe.remove(eVar.hashCode());
        AppMethodBeat.o(19476);
    }

    public final void a(String str, d dVar) {
        AppMethodBeat.i(19477);
        Assert.assertTrue(true);
        if (this.lwe == null) {
            ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            AppMethodBeat.o(19477);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lwe.size()) {
                e eVar = (e) ((WeakReference) this.lwe.get(this.lwe.keyAt(i2))).get();
                if (eVar != null) {
                    eVar.b(str, dVar);
                }
                i = i2 + 1;
            } else {
                ab.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
                AppMethodBeat.o(19477);
                return;
            }
        }
    }
}
