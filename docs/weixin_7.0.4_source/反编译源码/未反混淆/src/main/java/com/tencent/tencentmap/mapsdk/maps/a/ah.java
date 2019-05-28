package com.tencent.tencentmap.mapsdk.maps.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah<E> {
    public static SparseArray<E> a(SparseArray<E> sparseArray) {
        AppMethodBeat.i(98426);
        if (sparseArray != null) {
            SparseArray<E> sparseArray2 = new SparseArray(sparseArray.size());
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                sparseArray2.append(keyAt, sparseArray.get(keyAt));
            }
            AppMethodBeat.o(98426);
            return sparseArray2;
        }
        AppMethodBeat.o(98426);
        return null;
    }
}
