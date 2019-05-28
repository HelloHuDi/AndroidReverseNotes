package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;

/* renamed from: com.tencent.map.lib.util.c */
public final class C32219c<T, K> {
    /* renamed from: a */
    private HashMap<T, K> f15010a;
    /* renamed from: b */
    private int f15011b = 0;
    /* renamed from: c */
    private int f15012c = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;

    /* renamed from: a */
    public final synchronized void mo52908a(T t, K k) {
        AppMethodBeat.m2504i(98246);
        if (this.f15010a == null) {
            this.f15010a = new HashMap();
        }
        this.f15010a.put(t, k);
        AppMethodBeat.m2505o(98246);
    }

    /* renamed from: a */
    public final synchronized K mo52907a(T t) {
        K k;
        AppMethodBeat.m2504i(98247);
        if (this.f15010a == null) {
            k = null;
            AppMethodBeat.m2505o(98247);
        } else {
            k = this.f15010a.get(t);
            AppMethodBeat.m2505o(98247);
        }
        return k;
    }
}
