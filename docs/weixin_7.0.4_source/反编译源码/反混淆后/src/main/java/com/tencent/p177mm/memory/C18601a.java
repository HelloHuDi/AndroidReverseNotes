package com.tencent.p177mm.memory;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.NavigableMap;

/* renamed from: com.tencent.mm.memory.a */
public abstract class C18601a<T> extends C42181e<T, Integer> {
    /* renamed from: c */
    public synchronized T mo20956a(Integer num) {
        T t;
        NavigableMap subMap = this.fdA.subMap(num, true, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER), true);
        if (!(subMap == null || subMap.isEmpty())) {
            for (Integer intValue : subMap.keySet()) {
                C42179d c42179d = (C42179d) subMap.get(Integer.valueOf(intValue.intValue()));
                if (c42179d.size() > 0) {
                    T pop = c42179d.pop();
                    this.fdA.put(c42179d.mo67725WZ(), c42179d);
                    t = pop;
                    break;
                }
            }
            t = null;
            if (t != null) {
                mo67731fj(mo20958aS(t));
            }
        }
        t = null;
        return t;
    }

    /* renamed from: d */
    public synchronized T mo33852d(Integer num) {
        T t;
        C42179d c42179d = (C42179d) this.fdA.get(num);
        if (c42179d == null || c42179d.size() <= 0) {
            int i;
            String str = "MicroMsg.BiggerThanPool";
            String str2 = "BiggerThanPool getExactSize cannot get %s size count %d";
            Object[] objArr = new Object[2];
            objArr[0] = num;
            if (c42179d == null) {
                i = -1;
            } else if (c42179d.fdy == null) {
                i = -1;
            } else {
                i = c42179d.fdy.size();
            }
            objArr[1] = Integer.valueOf(i);
            C4990ab.m7411d(str, str2, objArr);
            t = null;
        } else {
            T pop = c42179d.pop();
            this.fdA.put(c42179d.mo67725WZ(), c42179d);
            mo67731fj(mo20958aS(pop));
            t = pop;
        }
        return t;
    }
}
