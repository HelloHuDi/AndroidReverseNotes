package com.tencent.p659pb.common.p660b;

import com.tencent.p659pb.common.p1102c.C44443c;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.pb.common.b.i */
public final class C44442i implements C30913c {
    /* renamed from: Jq */
    private WeakReference<C30913c> f17269Jq;

    public C44442i(C30913c c30913c) {
        this.f17269Jq = new WeakReference(c30913c);
    }

    /* renamed from: r */
    public final void mo40010r(int i, byte[] bArr) {
        if (this.f17269Jq == null || this.f17269Jq.get() == null) {
            C44443c.m80392w("OnRespForLongAIDLImpl fail", "callback is null, errCode=".concat(String.valueOf(i)));
            return;
        }
        ((C30913c) this.f17269Jq.get()).mo40010r(i, bArr);
    }
}
