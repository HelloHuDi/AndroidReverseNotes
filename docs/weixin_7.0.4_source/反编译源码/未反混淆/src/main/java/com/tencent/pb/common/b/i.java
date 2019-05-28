package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;
import java.lang.ref.WeakReference;

public final class i implements c {
    private WeakReference<c> Jq;

    public i(c cVar) {
        this.Jq = new WeakReference(cVar);
    }

    public final void r(int i, byte[] bArr) {
        if (this.Jq == null || this.Jq.get() == null) {
            c.w("OnRespForLongAIDLImpl fail", "callback is null, errCode=".concat(String.valueOf(i)));
            return;
        }
        ((c) this.Jq.get()).r(i, bArr);
    }
}
