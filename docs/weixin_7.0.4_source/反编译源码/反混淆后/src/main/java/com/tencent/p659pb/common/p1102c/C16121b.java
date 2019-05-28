package com.tencent.p659pb.common.p1102c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.pb.common.c.b */
public final class C16121b {
    /* renamed from: H */
    public static <E> List<E> m24451H(E... eArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            arrayList.add(eArr[i]);
        }
        return arrayList;
    }

    /* renamed from: I */
    public static <E> Map<E, E> m24452I(E... eArr) {
        if (eArr.length % 2 != 0) {
            throw new IllegalArgumentException("length of map is " + eArr.length);
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < eArr.length; i += 2) {
            hashMap.put(eArr[i], eArr[i + 1]);
        }
        return hashMap;
    }
}
