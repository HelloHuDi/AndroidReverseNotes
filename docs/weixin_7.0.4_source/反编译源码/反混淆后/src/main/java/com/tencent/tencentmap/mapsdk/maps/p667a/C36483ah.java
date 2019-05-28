package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ah */
public final class C36483ah<E> {
    /* renamed from: a */
    public static SparseArray<E> m60324a(SparseArray<E> sparseArray) {
        AppMethodBeat.m2504i(98426);
        if (sparseArray != null) {
            SparseArray<E> sparseArray2 = new SparseArray(sparseArray.size());
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                sparseArray2.append(keyAt, sparseArray.get(keyAt));
            }
            AppMethodBeat.m2505o(98426);
            return sparseArray2;
        }
        AppMethodBeat.m2505o(98426);
        return null;
    }
}
