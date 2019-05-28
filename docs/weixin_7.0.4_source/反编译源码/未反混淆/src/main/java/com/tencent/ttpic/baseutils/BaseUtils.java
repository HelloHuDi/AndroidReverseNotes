package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class BaseUtils {
    public static boolean isEmpty(Collection collection) {
        AppMethodBeat.i(49591);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(49591);
            return true;
        }
        AppMethodBeat.o(49591);
        return false;
    }

    public static int size(Collection collection) {
        AppMethodBeat.i(49592);
        if (collection == null) {
            AppMethodBeat.o(49592);
            return 0;
        }
        int size = collection.size();
        AppMethodBeat.o(49592);
        return size;
    }

    public static int size(Object[] objArr) {
        return objArr == null ? 0 : objArr.length;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(49593);
        if (charSequence == null || !charSequence.equals(charSequence2)) {
            AppMethodBeat.o(49593);
            return false;
        }
        AppMethodBeat.o(49593);
        return true;
    }

    public static boolean indexOutOfBounds(Collection collection, int i) {
        AppMethodBeat.i(49594);
        if (collection == null || i < 0 || i >= collection.size()) {
            AppMethodBeat.o(49594);
            return true;
        }
        AppMethodBeat.o(49594);
        return false;
    }
}
