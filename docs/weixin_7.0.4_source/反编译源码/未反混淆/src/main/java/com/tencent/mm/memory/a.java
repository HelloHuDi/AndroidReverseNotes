package com.tencent.mm.memory;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.NavigableMap;

public abstract class a<T> extends e<T, Integer> {
    /* renamed from: c */
    public synchronized T a(Integer num) {
        T t;
        NavigableMap subMap = this.fdA.subMap(num, true, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER), true);
        if (!(subMap == null || subMap.isEmpty())) {
            for (Integer intValue : subMap.keySet()) {
                d dVar = (d) subMap.get(Integer.valueOf(intValue.intValue()));
                if (dVar.size() > 0) {
                    T pop = dVar.pop();
                    this.fdA.put(dVar.WZ(), dVar);
                    t = pop;
                    break;
                }
            }
            t = null;
            if (t != null) {
                fj(aS(t));
            }
        }
        t = null;
        return t;
    }

    public synchronized T d(Integer num) {
        T t;
        d dVar = (d) this.fdA.get(num);
        if (dVar == null || dVar.size() <= 0) {
            int i;
            String str = "MicroMsg.BiggerThanPool";
            String str2 = "BiggerThanPool getExactSize cannot get %s size count %d";
            Object[] objArr = new Object[2];
            objArr[0] = num;
            if (dVar == null) {
                i = -1;
            } else if (dVar.fdy == null) {
                i = -1;
            } else {
                i = dVar.fdy.size();
            }
            objArr[1] = Integer.valueOf(i);
            ab.d(str, str2, objArr);
            t = null;
        } else {
            T pop = dVar.pop();
            this.fdA.put(dVar.WZ(), dVar);
            fj(aS(pop));
            t = pop;
        }
        return t;
    }
}
