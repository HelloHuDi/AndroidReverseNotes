package com.tencent.p177mm.p190at.p191a.p1527d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import java.util.Map;

/* renamed from: com.tencent.mm.at.a.d.a */
public final class C45159a<K, V> {
    public C1177f<K, V> eRT;

    public C45159a(int i) {
        AppMethodBeat.m2504i(116095);
        this.eRT = new C7598c(i);
        AppMethodBeat.m2505o(116095);
    }

    /* renamed from: aj */
    public final synchronized boolean mo73069aj(K k) {
        boolean aj;
        AppMethodBeat.m2504i(116097);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.m2505o(116097);
            throw nullPointerException;
        }
        aj = this.eRT.mo4405aj(k);
        AppMethodBeat.m2505o(116097);
        return aj;
    }

    public final V get(K k) {
        AppMethodBeat.m2504i(116098);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.m2505o(116098);
            throw nullPointerException;
        }
        Object obj = this.eRT.get(k);
        AppMethodBeat.m2505o(116098);
        return obj;
    }

    public final V put(K k, V v) {
        AppMethodBeat.m2504i(116099);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.m2505o(116099);
            throw nullPointerException;
        }
        Object put = this.eRT.put(k, v);
        AppMethodBeat.m2505o(116099);
        return put;
    }

    public final synchronized Map<K, V> snapshot() {
        Map snapshot;
        AppMethodBeat.m2504i(116100);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.m2505o(116100);
            throw nullPointerException;
        }
        snapshot = this.eRT.snapshot();
        AppMethodBeat.m2505o(116100);
        return snapshot;
    }

    public final synchronized String toString() {
        String obj;
        AppMethodBeat.m2504i(116101);
        if (this.eRT == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.m2505o(116101);
            throw nullPointerException;
        }
        obj = this.eRT.toString();
        AppMethodBeat.m2505o(116101);
        return obj;
    }
}
