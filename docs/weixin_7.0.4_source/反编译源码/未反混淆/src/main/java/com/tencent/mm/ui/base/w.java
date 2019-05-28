package com.tencent.mm.ui.base;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w {
    SparseArray<View>[] yAA;
    int yAB;
    SparseArray<View> yAC;
    View[] yAy = new View[0];
    int[] yAz = new int[0];

    public w() {
        AppMethodBeat.i(107083);
        AppMethodBeat.o(107083);
    }

    static View a(SparseArray<View> sparseArray, int i) {
        AppMethodBeat.i(107084);
        int size = sparseArray.size();
        if (size > 0) {
            int i2;
            View view;
            for (i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                view = (View) sparseArray.get(keyAt);
                if (keyAt == i) {
                    sparseArray.remove(keyAt);
                    AppMethodBeat.o(107084);
                    return view;
                }
            }
            i2 = size - 1;
            view = (View) sparseArray.valueAt(i2);
            sparseArray.remove(sparseArray.keyAt(i2));
            AppMethodBeat.o(107084);
            return view;
        }
        AppMethodBeat.o(107084);
        return null;
    }
}
