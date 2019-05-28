package com.tencent.mm.loader.e;

import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class e implements com.tencent.mm.loader.d.e {
    private d<String, Integer> eQt = new d(10);

    public final synchronized boolean a(a<?> aVar) {
        boolean z;
        if (this.eQt.aj(aVar.toString())) {
            int intValue = ((Integer) this.eQt.get(aVar.toString())).intValue();
            this.eQt.put(aVar.toString(), Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    ab.i("MicroMsg.Loader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", aVar, Integer.valueOf(50), Integer.valueOf(intValue));
                }
                z = false;
            }
            z = true;
        } else {
            this.eQt.put(aVar.toString(), Integer.valueOf(1));
            z = true;
        }
        return z;
    }
}
